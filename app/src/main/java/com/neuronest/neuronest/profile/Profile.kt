package com.neuronest.neuronest.profile

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


@Entity(tableName = "user_profiles")
data class UserProfile(
    @PrimaryKey val userId: String = "default_user",
    val username: String = "Puzzle Master",
    val displayName: String = "",
    val profileImageUri: String = "",
    val isProfileSetup: Boolean = false,
    val joinDate: Long = System.currentTimeMillis(),
    val totalScore: Long = 0,
    val totalPuzzlesSolved: Int = 0,
    val totalPuzzlesAttempted: Int = 0,
    val averageAccuracy: Double = 0.0,
    val currentStreak: Int = 0,
    val lastPlayedDate: Long = 0,
    val puzzleStats: String = "{}"
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


data class PuzzleProgressData(
    val puzzleType: String,
    val solvedCount: Int,
    val totalCount: Int
)
