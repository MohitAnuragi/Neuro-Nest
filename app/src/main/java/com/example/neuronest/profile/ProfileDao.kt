package com.example.neuronest.profile

import androidx.room.*

@Dao
interface ProfileDao {
    @Query("SELECT * FROM user_profiles WHERE userId = :userId")
    suspend fun getProfile(userId: String): UserProfile?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProfile(profile: UserProfile)

    @Update
    suspend fun updateProfile(profile: UserProfile)

    @Query("UPDATE user_profiles SET totalScore = totalScore + :score WHERE userId = :userId")
    suspend fun addToScore(userId: String, score: Int)

    @Query("UPDATE user_profiles SET totalPuzzlesSolved = totalPuzzlesSolved + 1 WHERE userId = :userId")
    suspend fun incrementPuzzlesSolved(userId: String)

    @Query("UPDATE user_profiles SET totalPuzzlesAttempted = totalPuzzlesAttempted + 1 WHERE userId = :userId")
    suspend fun incrementPuzzlesAttempted(userId: String)

    @Query("UPDATE user_profiles SET averageAccuracy = :accuracy WHERE userId = :userId")
    suspend fun updateAccuracy(userId: String, accuracy: Double)

    @Query("UPDATE user_profiles SET currentStreak = :streak WHERE userId = :userId")
    suspend fun updateStreak(userId: String, streak: Int)

    @Query("UPDATE user_profiles SET lastPlayedDate = :date WHERE userId = :userId")
    suspend fun updateLastPlayed(userId: String, date: Long)

    // NEW: Methods for name and image updates
    @Query("UPDATE user_profiles SET displayName = :displayName WHERE userId = :userId")
    suspend fun updateDisplayName(userId: String, displayName: String)

    @Query("UPDATE user_profiles SET profileImageUri = :imageUri WHERE userId = :userId")
    suspend fun updateProfileImage(userId: String, imageUri: String)

    @Query("UPDATE user_profiles SET displayName = :displayName, profileImageUri = :imageUri, isProfileSetup = :isSetup WHERE userId = :userId")
    suspend fun updateProfileDetails(userId: String, displayName: String, imageUri: String, isSetup: Boolean)
}