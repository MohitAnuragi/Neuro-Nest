package com.neuronest.neuronest.profile


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

    private object LevelKeys {
        fun levelUnlockedKey(puzzleType: String, level: Int) = stringPreferencesKey("LEVEL_${puzzleType}_${level}_UNLOCKED")
        fun levelStarsKey(puzzleType: String, level: Int) = intPreferencesKey("LEVEL_${puzzleType}_${level}_STARS")
        fun levelScoreKey(puzzleType: String, level: Int) = intPreferencesKey("LEVEL_${puzzleType}_${level}_SCORE")
        fun levelTimeKey(puzzleType: String, level: Int) = longPreferencesKey("LEVEL_${puzzleType}_${level}_TIME")
        fun levelAttemptsKey(puzzleType: String, level: Int) = intPreferencesKey("LEVEL_${puzzleType}_${level}_ATTEMPTS")

        fun currentLevelKey(puzzleType: String) = intPreferencesKey("CURRENT_LEVEL_$puzzleType")

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

    override suspend fun isLevelUnlocked(puzzleType: String, levelNumber: Int): Boolean {
        return context.dataStore.data.map { preferences ->
            if (levelNumber == 1) return@map true

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

    private fun getDifficultyForLevel(level: Int): String {
        return when {
            level <= 100 -> "Easy"
            level <= 200 -> "Medium"
            level <= 300 -> "Hard"
            level <= 400 -> "Expert"
            else -> "Master"
        }
    }

    override suspend fun getPuzzleStats(puzzleType: String): PuzzleStats {
        return PuzzleStats(0L, 0, 0, 0.0, 0)
    }

    override suspend fun getCurrentStreak(puzzleType: String): Int {
        return 0
    }

    override suspend fun getPuzzleAccuracy(puzzleType: String): Double {
        return 0.0
    }

    override suspend fun getTotalAttempts(puzzleType: String): Int {
        return 0
    }

    override suspend fun updatePuzzleResult(
        puzzleType: String,
        difficulty: String,
        wasSolved: Boolean,
        timeTakenMs: Long,
        hintsUsed: Int,
        scoreEarned: Long
    ) {

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

    override suspend fun updateProfileDetails(displayName: String, imageUri: String) {
        val currentProfile = getOrCreateProfile()

        val isSetupComplete = displayName.isNotBlank()

        profileDao.updateProfileDetails(DEFAULT_USER_ID, displayName, imageUri, isSetupComplete)
    }

    override suspend fun isProfileSetupComplete(): Boolean {
        val profile = profileDao.getProfile(DEFAULT_USER_ID)
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