package com.example.neuronest.achievements

import com.example.neuronest.puzzlelevels.LevelProgressDao
import kotlinx.coroutines.flow.Flow
import java.util.Calendar
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class AchievementRepository @Inject constructor(
    private val achievementDao: AchievementDao,
    private val levelProgressDao: LevelProgressDao
) {
    suspend fun initializeAchievements() {
        val existing = achievementDao.getAllAchievements()
        if (existing.isEmpty()) {
            val defaultAchievements = AchievementType.values().map { it.toEntity() }
            achievementDao.insertAllAchievements(defaultAchievements)
        }
    }

    suspend fun getAllAchievements(): List<AchievementEntity> {
        initializeAchievements()
        return achievementDao.getAllAchievements()
    }

    fun getAllAchievementsFlow(): Flow<List<AchievementEntity>> {
        return achievementDao.getAllAchievementsFlow()
    }

    suspend fun getUnlockedCount(): Int {
        return achievementDao.getUnlockedCount()
    }

    suspend fun getTotalCount(): Int {
        return achievementDao.getTotalCount()
    }

    private suspend fun getTotalPuzzlesSolved(): Int {
        val puzzleTypes = listOf(
            "WordScramble",
            "Kakuro",
            "SequenceGenerator",
            "SudokuPuzzle",
            "LogicPuzzles",
            "Connections"
        )
        return puzzleTypes.sumOf { puzzleType ->
            try {
                levelProgressDao.getCompletedLevelsCount(puzzleType)
            } catch (e: Exception) {
                0
            }
        }
    }

    private suspend fun calculateCurrentStreak(): Int {
        val puzzleTypes = listOf(
            "WordScramble",
            "Kakuro",
            "SequenceGenerator",
            "SudokuPuzzle",
            "LogicPuzzles",
            "Connections"
        )

        val allProgress = puzzleTypes.flatMap { puzzleType ->
            levelProgressDao.getAllLevelsProgress(puzzleType)
        }

        if (allProgress.isEmpty()) return 0

        val playedDates = allProgress.map { progress ->
            val calendar = Calendar.getInstance()
            calendar.timeInMillis = progress.lastPlayed
            calendar.set(Calendar.HOUR_OF_DAY, 0)
            calendar.set(Calendar.MINUTE, 0)
            calendar.set(Calendar.SECOND, 0)
            calendar.set(Calendar.MILLISECOND, 0)
            calendar.timeInMillis
        }.distinct().sorted().reversed()

        if (playedDates.isEmpty()) return 0

        val today = Calendar.getInstance()
        today.set(Calendar.HOUR_OF_DAY, 0)
        today.set(Calendar.MINUTE, 0)
        today.set(Calendar.SECOND, 0)
        today.set(Calendar.MILLISECOND, 0)
        val todayMillis = today.timeInMillis

        var streak = 0
        var currentDay = todayMillis

        for (playedDate in playedDates) {
            if (playedDate == currentDay || playedDate == currentDay - (24 * 60 * 60 * 1000)) {
                streak++
                currentDay = playedDate - (24 * 60 * 60 * 1000)
            } else {
                break
            }
        }

        return streak
    }

    suspend fun checkAndUpdateAchievements() {
        initializeAchievements()

        val totalSolved = getTotalPuzzlesSolved()
        val currentStreak = calculateCurrentStreak()

        AchievementType.values().forEach { achievementType ->
            val achievement = achievementDao.getAchievement(achievementType.id)

            if (achievement != null && !achievement.isUnlocked) {
                val (shouldUnlock, progress) = when (achievementType) {
                    AchievementType.FIRST_10_PUZZLES -> {
                        Pair(totalSolved >= 10, totalSolved)
                    }

                    AchievementType.FIRST_200_PUZZLES -> {
                        Pair(totalSolved >= 200, totalSolved)
                    }

                    AchievementType.FIRST_500_PUZZLES -> {
                        Pair(totalSolved >= 500, totalSolved)
                    }

                    AchievementType.STREAK_7_DAYS -> {
                        Pair(currentStreak >= 7, currentStreak)
                    }

                    AchievementType.STREAK_30_DAYS -> {
                        Pair(currentStreak >= 30, currentStreak)
                    }

                    AchievementType.NEURONEST_CHAMPION -> {
                        val unlocked = totalSolved >= 500 && currentStreak >= 30
                        Pair(unlocked, if (unlocked) 1 else 0)
                    }
                }

                if (shouldUnlock) {
                    achievementDao.updateAchievementProgress(
                        achievementId = achievementType.id,
                        isUnlocked = true,
                        unlockedAt = System.currentTimeMillis(),
                        progress = achievementType.target
                    )
                } else {
                    achievementDao.updateAchievementProgress(
                        achievementId = achievementType.id,
                        isUnlocked = false,
                        unlockedAt = null,
                        progress = progress
                    )
                }
            }
        }
    }
}

