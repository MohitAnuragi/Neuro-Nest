package com.neuronest.neuronest.puzzlelevels

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LevelRepositoryImpl @Inject constructor(
    private val levelProgressDao: LevelProgressDao
) : LevelRepository {

    override suspend fun getMaxUnlockedLevel(puzzleType: String): Int {
        val maxCompleted = levelProgressDao.getMaxCompletedLevel(puzzleType) ?: 0
        return maxCompleted + 1 // Next level after highest completed
    }

    override suspend fun unlockNextLevel(puzzleType: String, currentLevel: Int) {
    }

    override suspend fun isLevelUnlocked(puzzleType: String, levelNumber: Int): Boolean {
        return levelNumber <= getMaxUnlockedLevel(puzzleType)
    }

    override suspend fun saveMaxUnlockedLevel(puzzleType: String, level: Int) {
    }

    override suspend fun completeLevel(
        puzzleType: String,
        levelNumber: Int,
        score: Int,
        stars: Int,
        timeTaken: Long?
    ): LevelCompletionResult {
        val existingProgress = levelProgressDao.getLevelProgress(puzzleType, levelNumber)
        val wasPreviouslyCompleted = existingProgress?.isCompleted ?: false

        val isNewHighScore = score > (existingProgress?.bestScore ?: 0)

        // Update level progress
        val newProgress = LevelProgressEntity(
            puzzleType = puzzleType,
            levelNumber = levelNumber,
            isCompleted = true,
            starsEarned = maxOf(existingProgress?.starsEarned ?: 0, stars),
            bestScore = maxOf(existingProgress?.bestScore ?: 0, score),
            bestTime = calculateBestTime(existingProgress?.bestTime, timeTaken),
            attempts = (existingProgress?.attempts ?: 0) + 1,
            lastPlayed = System.currentTimeMillis()
        )

        levelProgressDao.insertLevelProgress(newProgress)

        return LevelCompletionResult(
            levelNumber = levelNumber,
            puzzleType = puzzleType,
            starsEarned = stars,
            score = score,
            isNewHighScore = isNewHighScore,
            isLevelCompleted = !wasPreviouslyCompleted,
            nextLevelUnlocked = true
        )
    }

    override suspend fun isLevelCompleted(puzzleType: String, levelNumber: Int): Boolean {
        val progress = levelProgressDao.getLevelProgress(puzzleType, levelNumber)
        return progress?.isCompleted ?: false
    }

    override suspend fun getLevelStars(puzzleType: String, levelNumber: Int): Int {
        val progress = levelProgressDao.getLevelProgress(puzzleType, levelNumber)
        return progress?.starsEarned ?: 0
    }

    override suspend fun getLevelDetails(puzzleType: String, levelNumber: Int): LevelDetails? {
        if (!isLevelUnlocked(puzzleType, levelNumber)) return null

        val progress = levelProgressDao.getLevelProgress(puzzleType, levelNumber)

        return LevelDetails(
            levelNumber = levelNumber,
            puzzleType = puzzleType,
            difficulty = "Level $levelNumber",
            isUnlocked = true,
            isCompleted = progress?.isCompleted ?: false,
            starsEarned = progress?.starsEarned ?: 0,
            bestScore = progress?.bestScore ?: 0,
            bestTime = progress?.bestTime,
            attempts = progress?.attempts ?: 0
        )
    }

    override suspend fun getLevelProgress(puzzleType: String): LevelProgress {
        val maxUnlocked = getMaxUnlockedLevel(puzzleType)
        val completedLevels = levelProgressDao.getCompletedLevelsCount(puzzleType)
        val totalStars = levelProgressDao.getTotalStars(puzzleType) ?: 0
        val totalScore = levelProgressDao.getTotalScore(puzzleType) ?: 0

        return LevelProgress(
            puzzleType = puzzleType,
            currentLevel = maxUnlocked,
            totalScore = totalScore,
            totalStars = totalStars,
            levelsCompleted = completedLevels,
            isMaxLevelReached = maxUnlocked > 500
        )
    }

    override suspend fun getAllLevelsProgress(puzzleType: String): List<LevelProgress> {
        val maxUnlocked = getMaxUnlockedLevel(puzzleType)
        val allLevels = levelProgressDao.getAllLevelsProgress(puzzleType)

        return (1..500).map { levelNumber ->
            val levelEntity = allLevels.find { it.levelNumber == levelNumber }
            
            LevelProgress(
                puzzleType = puzzleType,
                currentLevel = levelNumber,
                totalScore = levelEntity?.bestScore?.toLong() ?: 0,
                totalStars = levelEntity?.starsEarned ?: 0,
                levelsCompleted = if (levelEntity?.isCompleted == true) 1 else 0,
                isMaxLevelReached = false
            )
        }
    }

    override suspend fun getCompletedLevelsCount(puzzleType: String): Int {
        return levelProgressDao.getCompletedLevelsCount(puzzleType)
    }

    override suspend fun getTotalStars(puzzleType: String): Int {
        return levelProgressDao.getTotalStars(puzzleType) ?: 0
    }

    override suspend fun getTotalScore(puzzleType: String): Long {
        return levelProgressDao.getTotalScore(puzzleType) ?: 0
    }

    override suspend fun resetLevelProgress(puzzleType: String) {
        levelProgressDao.resetLevelProgress(puzzleType)
    }

    override suspend fun resetAllProgress() {
        val puzzleTypes = listOf("Arithmetic", "WordScramble", "Connection", "Sequence", "Sudoku", "Logic")
        puzzleTypes.forEach { resetLevelProgress(it) }
    }

    override fun getLevelProgressFlow(puzzleType: String): Flow<LevelProgress> {
        return levelProgressDao.getAllLevelsProgressFlow(puzzleType).map { levels ->
            val maxCompleted = levels.filter { it.isCompleted }.maxOfOrNull { it.levelNumber } ?: 0
            val maxUnlocked = maxCompleted + 1
            val completedLevels = levels.count { it.isCompleted }
            val totalStars = levels.sumOf { it.starsEarned }
            val totalScore = levels.sumOf { it.bestScore.toLong() }

            LevelProgress(
                puzzleType = puzzleType,
                currentLevel = maxUnlocked,
                totalScore = totalScore,
                totalStars = totalStars,
                levelsCompleted = completedLevels,
                isMaxLevelReached = maxUnlocked > 500
            )
        }
    }

    override fun getLevelDetailsFlow(puzzleType: String, levelNumber: Int): Flow<LevelDetails?> {
        return levelProgressDao.getLevelProgressFlow(puzzleType, levelNumber).map { progress ->
            val maxUnlocked = getMaxUnlockedLevel(puzzleType)
            if (levelNumber > maxUnlocked) {
                if (levelNumber in 1..500) {
                    LevelDetails(
                        levelNumber = levelNumber,
                        puzzleType = puzzleType,
                        difficulty = "Locked",
                        isUnlocked = false,
                        isCompleted = false,
                        starsEarned = 0,
                        bestScore = 0,
                        bestTime = null,
                        attempts = 0
                    )
                } else {
                    null
                }
            } else {
                LevelDetails(
                    levelNumber = levelNumber,
                    puzzleType = puzzleType,
                    difficulty = "Level $levelNumber",
                    isUnlocked = true,
                    isCompleted = progress?.isCompleted ?: false,
                    starsEarned = progress?.starsEarned ?: 0,
                    bestScore = progress?.bestScore ?: 0,
                    bestTime = progress?.bestTime,
                    attempts = progress?.attempts ?: 0
                )
            }
        }
    }

    private fun calculateBestTime(currentBest: Long?, newTime: Long?): Long? {
        return when {
            newTime == null -> currentBest
            currentBest == null -> newTime
            else -> minOf(currentBest, newTime)
        }
    }
}