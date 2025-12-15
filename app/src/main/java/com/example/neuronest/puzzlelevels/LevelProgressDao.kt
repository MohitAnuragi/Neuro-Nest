// dao/LevelProgressDao.kt
package com.example.neuronest.puzzlelevels

import androidx.room.*
import com.example.neuronest.puzzlelevels.LevelProgressEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface LevelProgressDao {

    @Query("SELECT * FROM level_progress WHERE puzzleType = :puzzleType AND levelNumber = :levelNumber")
    suspend fun getLevelProgress(puzzleType: String, levelNumber: Int): LevelProgressEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLevelProgress(progress: LevelProgressEntity)

    @Query("SELECT * FROM level_progress WHERE puzzleType = :puzzleType ORDER BY levelNumber")
    suspend fun getAllLevelsProgress(puzzleType: String): List<LevelProgressEntity>

    @Query("SELECT MAX(levelNumber) FROM level_progress WHERE puzzleType = :puzzleType AND isCompleted = 1")
    suspend fun getMaxCompletedLevel(puzzleType: String?): Int?

    @Query("DELETE FROM level_progress WHERE puzzleType = :puzzleType")
    suspend fun resetLevelProgress(puzzleType: String)

    @Query("SELECT COUNT(*) FROM level_progress WHERE puzzleType = :puzzleType AND isCompleted = 1")
    suspend fun getCompletedLevelsCount(puzzleType: String): Int

    @Query("SELECT SUM(starsEarned) FROM level_progress WHERE puzzleType = :puzzleType")
    suspend fun getTotalStars(puzzleType: String): Int

    @Query("SELECT SUM(bestScore) FROM level_progress WHERE puzzleType = :puzzleType")
    suspend fun getTotalScore(puzzleType: String): Long

    // Flow versions for real-time updates
    @Query("SELECT * FROM level_progress WHERE puzzleType = :puzzleType AND levelNumber = :levelNumber")
    fun getLevelProgressFlow(puzzleType: String, levelNumber: Int): Flow<LevelProgressEntity?>

    @Query("SELECT * FROM level_progress WHERE puzzleType = :puzzleType ORDER BY levelNumber")
    fun getAllLevelsProgressFlow(puzzleType: String): Flow<List<LevelProgressEntity>>
}