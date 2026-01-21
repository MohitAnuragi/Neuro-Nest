// repository/ProfileRepository.kt
package com.example.neuronest.profile

import android.content.Context
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Calendar
import javax.inject.Inject
import javax.inject.Singleton


interface ProfileRepository {
    // Existing functions
    suspend fun updatePuzzleResult(
        puzzleType: String,
        difficulty: String,
        wasSolved: Boolean,
        timeTakenMs: Long,
        hintsUsed: Int,
        scoreEarned: Long
    )

    suspend fun isLevelUnlocked(puzzleType: String, levelNumber: Int): Boolean
    suspend fun isLevelCompleted(puzzleType: String, levelNumber: Int): Boolean
    suspend fun getLevelStars(puzzleType: String, levelNumber: Int): Int


    suspend fun getPuzzleStats(puzzleType: String): PuzzleStats
    suspend fun getCurrentStreak(puzzleType: String): Int
    suspend fun getPuzzleAccuracy(puzzleType: String): Double
    suspend fun getTotalAttempts(puzzleType: String): Int

    // NEW: Level system functions
    suspend fun updateLevelProgress(
        puzzleType: String,
        levelNumber: Int,
        score: Int,
        stars: Int
    )

    suspend fun unlockNextLevel(puzzleType: String, currentLevel: Int)
    suspend fun getLevelProgress(puzzleType: String): LevelProgress
    suspend fun getAllLevelsProgress(puzzleType: String): List<LevelProgress>
    suspend fun getLevelDetails(puzzleType: String, levelNumber: Int): LevelDetails?
    suspend fun resetLevelProgress(puzzleType: String)
    suspend fun getOrCreateProfile(): UserProfile

    // NEW: Profile persistence APIs
    suspend fun updateProfileDetails(displayName: String, imageUri: String)
    suspend fun isProfileSetupComplete(): Boolean
    suspend fun resetProfile()
}

// NEW: Data classes for level system
data class LevelProgress(
    val puzzleType: String,
    val currentLevel: Int,
    val totalScore: Long,
    val totalStars: Int,
    val levelsCompleted: Int,
    val isMaxLevelReached: Boolean
)
//@Entity(tableName = "puzzle_results")
//data class PuzzleResultEntity(
//    @PrimaryKey(autoGenerate = true) val id: Long = 0,
//    val puzzleType: String,
//    val difficulty: String,
//    val wasSolved: Boolean,
//    val timeTakenMs: Long,
//    val hintsUsed: Int,
//    val scoreEarned: Long,
//    val timestamp: Long
//)


data class LevelDetails(
    val levelNumber: Int,
    val difficulty: String,
    val isUnlocked: Boolean,
    val isCompleted: Boolean,
    val starsEarned: Int,
    val bestScore: Int,
    val bestTime: Long?,
    val attempts: Int
)

data class PuzzleStats(
    val totalScore: Long,
    val solvedCount: Int,
    val totalAttempts: Int,
    val accuracy: Double,
    val currentStreak: Int
)




















//
//
//private val Context.dataStore by preferencesDataStore(name = "user_preferences")
//
//@Singleton
//class ProfileRepository @Inject constructor(
//    private val profileDao: ProfileDao,
//    private val context: Context
//) {
//    private val dataStore = context.dataStore
//
//    companion object {
//        private  val DEFAULT_USER_ID = "default_user"
//        private val USER_ID_KEY = stringPreferencesKey("user_id")
//    }

//    suspend fun getOrCreateProfile(): UserProfile {
//        var profile = profileDao.getProfile(DEFAULT_USER_ID)
//        if (profile == null) {
//            profile = UserProfile()
//            profileDao.insertProfile(profile)
//        }
//        return profile
//    }
//
//    suspend fun updatePuzzleResult(
//        puzzleType: String,
//        difficulty: String,
//        wasSolved: Boolean,
//        timeTakenMs: Long,
//        hintsUsed: Int = 0,
//        scoreEarned: Long = 0
//    ) {
//        val profile = getOrCreateProfile()
//        var statsMap = profile.getPuzzleStatsMap().toMutableMap()
//
//        // Get or create stats for this puzzle type
//        val stats = statsMap.getOrPut(puzzleType) {
//            PuzzleTypeStats(type = puzzleType)
//        }
//
//        // Update stats
//        stats.attempted++
//        if (wasSolved) {
//            stats.solved++
//            stats.totalTimeMs += timeTakenMs
//            stats.bestTimeMs = minOf(stats.bestTimeMs, timeTakenMs)
//            stats.totalHintsUsed += hintsUsed
//        }
//
//        // Update profile
//        val updatedProfile = profile.copy(
//            totalScore = profile.totalScore + scoreEarned,
//            totalPuzzlesSolved = profile.totalPuzzlesSolved + (if (wasSolved) 1 else 0),
//            totalPuzzlesAttempted = profile.totalPuzzlesAttempted + 1,
//            averageAccuracy = calculateOverallAccuracy(profile, wasSolved),
//            puzzleStats = profile.toPuzzleStatsJson(statsMap),
//            lastPlayedDate = System.currentTimeMillis()
//        )
//
//        // Update streak
//        val newStreak = updateStreak(profile)
//        profileDao.updateProfile(updatedProfile.copy(currentStreak = newStreak))
//    }
//
//    private fun calculateOverallAccuracy(profile: UserProfile, wasSolved: Boolean): Double {
//        val totalAttempted = profile.totalPuzzlesAttempted + 1
//        val totalSolved = profile.totalPuzzlesSolved + (if (wasSolved) 1 else 0)
//        return (totalSolved.toDouble() / totalAttempted) * 100
//    }
//
//    private suspend fun updateStreak(profile: UserProfile): Int {
//        val today = Calendar.getInstance().apply { set(Calendar.HOUR_OF_DAY, 0); set(Calendar.MINUTE, 0); set(Calendar.SECOND, 0) }.timeInMillis
//        val lastPlayed = profile.lastPlayedDate
//
//        return if (lastPlayed < today - 86400000 * 2) { // More than 2 days gap
//            1 // Reset streak
//        } else if (lastPlayed < today - 86400000) { // Yesterday
//            profile.currentStreak + 1
//        } else { // Today
//            profile.currentStreak
//        }
//    }
//
//    suspend fun getPuzzleTypeStats(puzzleType: String): PuzzleTypeStats? {
//        val profile = getOrCreateProfile()
//        return profile.getPuzzleStatsMap()[puzzleType]
//    }
//
//    suspend fun getAllStats(): Map<String, PuzzleTypeStats> {
//        return getOrCreateProfile().getPuzzleStatsMap()
//    }
//    suspend fun updateDisplayName(displayName: String) {
//        profileDao.updateDisplayName(DEFAULT_USER_ID, displayName)
//    }
//    suspend fun updateProfileImage(imageUri: String) {
//        profileDao.updateProfileImage(DEFAULT_USER_ID, imageUri)
//    }
//
//    suspend fun updateProfileDetails(displayName: String, imageUri: String) {
//        profileDao.updateProfileDetails(DEFAULT_USER_ID, displayName, imageUri)
//    }
//
//    suspend fun isProfileSetup(): Boolean {
//        val profile = getOrCreateProfile()
//        return profile.isProfileSetup
//    }
//    suspend fun resetProfile() {
//        val resetProfile = UserProfile(
//            userId = DEFAULT_USER_ID,
//        displayName = "", // Reset name
//        profileImageUri = "", // Reset image
//        joinDate = System.currentTimeMillis() // Keep join date
//        )
//        profileDao.insertProfile(resetProfile)
//    }
//}