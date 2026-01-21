// data/Profile.kt
package com.example.neuronest.profile

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


@Entity(tableName = "user_profiles")
data class UserProfile(
    @PrimaryKey val userId: String = "default_user",
    val username: String = "Puzzle Master",
    val displayName: String = "", // User's chosen name
    val profileImageUri: String = "", // Stored image URI
    val isProfileSetup: Boolean = false, // Explicit flag for profile setup completion
    val joinDate: Long = System.currentTimeMillis(),
    val totalScore: Long = 0,
    val totalPuzzlesSolved: Int = 0,
    val totalPuzzlesAttempted: Int = 0,
    val averageAccuracy: Double = 0.0,
    val currentStreak: Int = 0,
    val lastPlayedDate: Long = 0,
    val puzzleStats: String = "{}" // JSON string of Map<String, PuzzleTypeStats>
) {

    fun getPuzzleStatsMap(): Map<String, PuzzleTypeStats> {
        return try {
            Gson().fromJson(puzzleStats, object : TypeToken<Map<String, PuzzleTypeStats>>() {}.type)
        } catch (e: Exception) {
            emptyMap()
        }
    }

    fun toPuzzleStatsJson(stats: Map<String, PuzzleTypeStats>): String {
        return Gson().toJson(stats)
    }
}


data class PuzzleTypeStats(
    val type: String,
    var solved: Int = 0,
    var attempted: Int = 0,
    var totalTimeMs: Long = 0,
    var bestTimeMs: Long = Long.MAX_VALUE,
    var totalHintsUsed: Int = 0
) {
    val accuracy: Double get() = if (attempted > 0) (solved.toDouble() / attempted) * 100 else 0.0
    val averageTimeMs: Long get() = if (solved > 0) totalTimeMs / solved else 0
}

data class Achievement(
    val id: String,
    val title: String,
    val description: String,
    val iconResId: Int? = null,
    val unlocked: Boolean = false,
    val unlockDate: Long? = null,
    val progress: Int = 0,
    val target: Int = 0,
    val puzzleType: String? = null
)

/**
 * Puzzle Progress Data for Profile Screen
 *
 * Contains aggregate progress for a single puzzle type
 * Data comes directly from Room database
 */
data class PuzzleProgressData(
    val puzzleType: String,
    val solvedCount: Int,
    val totalCount: Int
)
