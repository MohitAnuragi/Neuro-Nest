package com.example.neuronest.puzzlelevels


interface LevelRepository {

    suspend fun getMaxUnlockedLevel(puzzleType: String): Int
    suspend fun unlockNextLevel(puzzleType: String, currentLevel: Int)
    suspend fun isLevelUnlocked(puzzleType: String, levelNumber: Int): Boolean

    suspend fun completeLevel(
        puzzleType: String,
        levelNumber: Int,
        score: Int,
        stars: Int,
        timeTaken: Long? = null
    ): LevelCompletionResult

    suspend fun isLevelCompleted(puzzleType: String, levelNumber: Int): Boolean
    suspend fun getLevelStars(puzzleType: String, levelNumber: Int): Int
    suspend fun getLevelDetails(puzzleType: String, levelNumber: Int): LevelDetails?

    suspend fun getLevelProgress(puzzleType: String): LevelProgress
    suspend fun getAllLevelsProgress(puzzleType: String): List<LevelProgress>
    suspend fun getCompletedLevelsCount(puzzleType: String): Int
    suspend fun getTotalStars(puzzleType: String): Int
    suspend fun getTotalScore(puzzleType: String): Long

    suspend fun resetLevelProgress(puzzleType: String)
    suspend fun resetAllProgress()
    suspend fun saveMaxUnlockedLevel(puzzleType: String, levelNumber: Int)


    fun getLevelProgressFlow(puzzleType: String): kotlinx.coroutines.flow.Flow<LevelProgress>
    fun getLevelDetailsFlow(puzzleType: String, levelNumber: Int): kotlinx.coroutines.flow.Flow<LevelDetails?>
}