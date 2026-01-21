package com.example.neuronest.achievements

import com.example.neuronest.puzzlelevels.LevelProgressDao
import kotlinx.coroutines.flow.Flow
import java.util.Calendar
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Achievement Repository
 *
 * Manages achievement data and unlocking logic based on real puzzle progress.
 * All achievements are computed from actual database data - no fake data.
 */
@Singleton
class AchievementRepository @Inject constructor(
    private val achievementDao: AchievementDao,
    private val levelProgressDao: LevelProgressDao
) {

    /**
     * Initialize achievements if they don't exist
     */
    suspend fun initializeAchievements() {
        val existing = achievementDao.getAllAchievements()
        if (existing.isEmpty()) {
            val defaultAchievements = AchievementType.values().map { it.toEntity() }
            achievementDao.insertAllAchievements(defaultAchievements)
        }
    }

    /**
     * Get all achievements
     */
    suspend fun getAllAchievements(): List<AchievementEntity> {
        initializeAchievements()
        return achievementDao.getAllAchievements()
    }

    /**
     * Get achievements as Flow for reactive updates
     */
    fun getAllAchievementsFlow(): Flow<List<AchievementEntity>> {
        return achievementDao.getAllAchievementsFlow()
    }

    /**
     * Get unlocked count
     */
    suspend fun getUnlockedCount(): Int {
        return achievementDao.getUnlockedCount()
    }

    /**
     * Get total count
     */
    suspend fun getTotalCount(): Int {
        return achievementDao.getTotalCount()
    }

    /**
     * Calculate total puzzles solved across all types
     *
     * For ACHIEVEMENTS: Sum ALL solved puzzles across ALL puzzle types (GLOBAL total)
     * This is DIFFERENT from profile which shows per-puzzle progress
     */
    private suspend fun getTotalPuzzlesSolved(): Int {
        // MUST MATCH puzzle types in the level system
        val puzzleTypes = listOf("WordScramble", "Kakuro", "SequenceGenerator", "SudokuPuzzle", "LogicPuzzles", "Connections")
        return puzzleTypes.sumOf { puzzleType ->
            try {
                levelProgressDao.getCompletedLevelsCount(puzzleType)
            } catch (e: Exception) {
                0
            }
        }
    }

    /**
     * Calculate current streak based on daily play activity
     */
    private suspend fun calculateCurrentStreak(): Int {
        val puzzleTypes = listOf("WordScramble", "Kakuro", "SequenceGenerator", "SudokuPuzzle", "LogicPuzzles", "Connections")

        // Get all played dates from all puzzle types
        val allProgress = puzzleTypes.flatMap { puzzleType ->
            levelProgressDao.getAllLevelsProgress(puzzleType)
        }

        if (allProgress.isEmpty()) return 0

        // Get unique dates (day precision)
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

        // Calculate streak from today backwards
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
                currentDay = playedDate - (24 * 60 * 60 * 1000) // Move to previous day
            } else {
                break
            }
        }

        return streak
    }

    /**
     * Check and update all achievements based on current progress
     * This is the ONLY way achievements get unlocked - automatically based on real data
     */
    suspend fun checkAndUpdateAchievements() {
        initializeAchievements()

        val totalSolved = getTotalPuzzlesSolved()
        val currentStreak = calculateCurrentStreak()

        // Check each achievement
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
                        // Compound achievement: 500 puzzles AND 30-day streak
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
                    // Update progress even if not unlocked yet
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

