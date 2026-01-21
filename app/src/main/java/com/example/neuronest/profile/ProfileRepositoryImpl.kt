package com.example.neuronest.profile


import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ProfileRepositoryImpl @Inject constructor(
    private val profileDao: ProfileDao,
    private val context: Context
) : ProfileRepository {

    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "user_profile")

    private val DEFAULT_USER_ID = "default_user"

    // Keys for level system
    private object LevelKeys {
        // Pattern: "LEVEL_{puzzleType}_{levelNumber}_{property}"
        fun levelUnlockedKey(puzzleType: String, level: Int) = stringPreferencesKey("LEVEL_${puzzleType}_${level}_UNLOCKED")
        fun levelStarsKey(puzzleType: String, level: Int) = intPreferencesKey("LEVEL_${puzzleType}_${level}_STARS")
        fun levelScoreKey(puzzleType: String, level: Int) = intPreferencesKey("LEVEL_${puzzleType}_${level}_SCORE")
        fun levelTimeKey(puzzleType: String, level: Int) = longPreferencesKey("LEVEL_${puzzleType}_${level}_TIME")
        fun levelAttemptsKey(puzzleType: String, level: Int) = intPreferencesKey("LEVEL_${puzzleType}_${level}_ATTEMPTS")

        // Current level for each puzzle type
        fun currentLevelKey(puzzleType: String) = intPreferencesKey("CURRENT_LEVEL_$puzzleType")

        // Total stats
        fun totalScoreKey(puzzleType: String) = longPreferencesKey("TOTAL_SCORE_$puzzleType")
        fun totalStarsKey(puzzleType: String) = intPreferencesKey("TOTAL_STARS_$puzzleType")
    }

    override suspend fun updateLevelProgress(
        puzzleType: String,
        levelNumber: Int,
        score: Int,
        stars: Int
    ) {
        context.dataStore.edit { preferences ->
            // Just unlock the next level - NO CONDITIONS!
            val nextLevel = levelNumber + 1
            if (nextLevel <= 500) {
                preferences[LevelKeys.levelUnlockedKey(puzzleType, nextLevel)] = "UNLOCKED"
            }
        }
    }

    override suspend fun unlockNextLevel(puzzleType: String, currentLevel: Int) {
        TODO("Not yet implemented")
    }

    override suspend fun getLevelProgress(puzzleType: String): LevelProgress {
        return context.dataStore.data.map { preferences ->
            // Find the highest unlocked level
            var highestUnlocked = 1
            for (level in 1..500) {
                val isUnlocked = preferences[LevelKeys.levelUnlockedKey(puzzleType, level)] == "UNLOCKED"
                if (isUnlocked) highestUnlocked = level
            }

            LevelProgress(
                puzzleType = puzzleType,
                currentLevel = highestUnlocked,
                totalScore = 0, // Remove if not needed
                totalStars = 0, // Remove if not needed
                levelsCompleted = highestUnlocked - 1, // Levels completed = unlocked levels - 1
                isMaxLevelReached = highestUnlocked >= 500
            )
        }.first()
    }

    // Add this function to check if a level is unlocked
    override suspend fun isLevelUnlocked(puzzleType: String, levelNumber: Int): Boolean {
        return context.dataStore.data.map { preferences ->
            if (levelNumber == 1) return@map true // Level 1 is always unlocked

            val status = preferences[LevelKeys.levelUnlockedKey(puzzleType, levelNumber)]
            status == "UNLOCKED" || status == "COMPLETED"
        }.first()
    }

    override suspend fun isLevelCompleted(
        puzzleType: String,
        levelNumber: Int
    ): Boolean {
        return context.dataStore.data.map { preferences ->
            preferences[stringPreferencesKey("${puzzleType}_LEVEL_${levelNumber}_COMPLETED")] == "YES"
        }.first()
    }

    override suspend fun getLevelStars(
        puzzleType: String,
        levelNumber: Int
    ): Int {
        return context.dataStore.data.map { preferences ->
            preferences[LevelKeys.levelStarsKey(puzzleType, levelNumber)] ?: 0
        }.first()
    }

    override suspend fun getAllLevelsProgress(puzzleType: String): List<LevelProgress> {
        // For future use if you want to show progress for multiple puzzle types
        return emptyList()
    }

    override suspend fun getLevelDetails(puzzleType: String, levelNumber: Int): LevelDetails? {
        return context.dataStore.data.map { preferences ->
            val stars = preferences[LevelKeys.levelStarsKey(puzzleType, levelNumber)] ?: 0
            val score = preferences[LevelKeys.levelScoreKey(puzzleType, levelNumber)] ?: 0
            val time = preferences[LevelKeys.levelTimeKey(puzzleType, levelNumber)]
            val attempts = preferences[LevelKeys.levelAttemptsKey(puzzleType, levelNumber)] ?: 0

            val status = preferences[LevelKeys.levelUnlockedKey(puzzleType, levelNumber)]
            val isUnlocked = status != null
            val isCompleted = stars > 0

            LevelDetails(
                levelNumber = levelNumber,
                difficulty = getDifficultyForLevel(levelNumber),
                isUnlocked = isUnlocked,
                isCompleted = isCompleted,
                starsEarned = stars,
                bestScore = score,
                bestTime = time,
                attempts = attempts
            )
        }.first()
    }

    override suspend fun resetLevelProgress(puzzleType: String) {
        context.dataStore.edit { preferences ->
            // Reset all level data for this puzzle type
            for (level in 1..500) {
                preferences.remove(LevelKeys.levelUnlockedKey(puzzleType, level))
                preferences.remove(LevelKeys.levelStarsKey(puzzleType, level))
                preferences.remove(LevelKeys.levelScoreKey(puzzleType, level))
                preferences.remove(LevelKeys.levelTimeKey(puzzleType, level))
                preferences.remove(LevelKeys.levelAttemptsKey(puzzleType, level))
            }

            // Reset current level
            preferences.remove(LevelKeys.currentLevelKey(puzzleType))
            preferences.remove(LevelKeys.totalScoreKey(puzzleType))
            preferences.remove(LevelKeys.totalStarsKey(puzzleType))
        }
    }

    // Helper function to determine difficulty based on level
    private fun getDifficultyForLevel(level: Int): String {
        return when {
            level <= 100 -> "Easy"
            level <= 200 -> "Medium"
            level <= 300 -> "Hard"
            level <= 400 -> "Expert"
            else -> "Master"
        }
    }

    // Existing functions (keep these as they were)
//    override suspend fun updatePuzzleResult(
//        puzzleType: String,
//        difficulty: String,
//        wasSolved: Boolean,
//        timeTakenMs: Long,
//        hintsUsed: Int,
//        scoreEarned: Long
//    ) {
//        // Your existing implementation
//    }

    override suspend fun getPuzzleStats(puzzleType: String): PuzzleStats {
        // Your existing implementation
        return PuzzleStats(0L, 0, 0, 0.0, 0)
    }

    override suspend fun getCurrentStreak(puzzleType: String): Int {
        // Your existing implementation
        return 0
    }

    override suspend fun getPuzzleAccuracy(puzzleType: String): Double {
        // Your existing implementation
        return 0.0
    }

    override suspend fun getTotalAttempts(puzzleType: String): Int {
        // Your existing implementation
        return 0
    }

    // NEW: Add these functions to your ProfileDao
    override suspend fun updatePuzzleResult(
        puzzleType: String,
        difficulty: String,
        wasSolved: Boolean,
        timeTakenMs: Long,
        hintsUsed: Int,
        scoreEarned: Long
    ) {
        // Use DAO to store in database
//        ProfileDao.insertPuzzleResult(
//            PuzzleResultEntity(
//                puzzleType = puzzleType,
//                difficulty = difficulty,
//                wasSolved = wasSolved,
//                timeTakenMs = timeTakenMs,
//                hintsUsed = hintsUsed,
//                scoreEarned = scoreEarned,
//                timestamp = System.currentTimeMillis()
//            )
//        )
    }



    override suspend fun getOrCreateProfile(): UserProfile {
        var profile = profileDao.getProfile(DEFAULT_USER_ID)
        if (profile == null) {
            // Create new profile with isProfileSetup = false
            profile = UserProfile(
                userId = DEFAULT_USER_ID,
                isProfileSetup = false,
                joinDate = System.currentTimeMillis()
            )
            profileDao.insertProfile(profile)
        }
        return profile
    }

    // NEW: Room-based profile persistence methods
    override suspend fun updateProfileDetails(displayName: String, imageUri: String) {
        // Get or create profile first
        val currentProfile = getOrCreateProfile()

        // Determine if profile should be marked as setup complete
        val isSetupComplete = displayName.isNotBlank()

        // Update profile with new details and setup flag
        profileDao.updateProfileDetails(DEFAULT_USER_ID, displayName, imageUri, isSetupComplete)
    }

    override suspend fun isProfileSetupComplete(): Boolean {
        val profile = profileDao.getProfile(DEFAULT_USER_ID)
        // Check the explicit isProfileSetup flag
        return profile?.isProfileSetup == true
    }

    override suspend fun resetProfile() {
        val resetProfile = UserProfile(
            userId = DEFAULT_USER_ID,
            displayName = "",
            profileImageUri = "",
            isProfileSetup = false,
            joinDate = System.currentTimeMillis()
        )
        profileDao.insertProfile(resetProfile)
    }

}