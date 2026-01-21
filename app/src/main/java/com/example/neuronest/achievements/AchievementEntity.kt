package com.example.neuronest.achievements

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Achievement Entity - Stores unlocked achievements in Room database
 *
 * Achievements are milestone-based and automatically unlocked when conditions are met.
 * They represent what the user has EARNED, not their current state.
 */
@Entity(tableName = "achievements")
data class AchievementEntity(
    @PrimaryKey val achievementId: String,
    val title: String,
    val description: String,
    val isUnlocked: Boolean = false,
    val unlockedAt: Long? = null, // Timestamp when achievement was unlocked
    val progress: Int = 0, // Current progress toward unlocking
    val target: Int = 1 // Target value to unlock
)

/**
 * Achievement Type Enum - Defines all possible achievements
 */
enum class AchievementType(
    val id: String,
    val title: String,
    val description: String,
    val target: Int
) {
    FIRST_10_PUZZLES(
        id = "first_10_puzzles",
        title = "First 10 Puzzles",
        description = "Solve 10 total puzzles",
        target = 10
    ),
    FIRST_200_PUZZLES(
        id = "first_200_puzzles",
        title = "First 200 Puzzles",
        description = "Solve 200 total puzzles",
        target = 200
    ),
    FIRST_500_PUZZLES(
        id = "first_500_puzzles",
        title = "First 500 Puzzles",
        description = "Solve 500 total puzzles",
        target = 500
    ),
    STREAK_7_DAYS(
        id = "streak_7_days",
        title = "7-Day Streak",
        description = "Play on 7 consecutive days",
        target = 7
    ),
    STREAK_30_DAYS(
        id = "streak_30_days",
        title = "30-Day Streak",
        description = "Play on 30 consecutive days",
        target = 30
    ),
    NEURONEST_CHAMPION(
        id = "neuronest_champion",
        title = "NeuroNest Champion 🏆",
        description = "Solve 500 puzzles AND maintain 30-day streak",
        target = 1 // Special compound achievement
    );

    fun toEntity(): AchievementEntity {
        return AchievementEntity(
            achievementId = id,
            title = title,
            description = description,
            isUnlocked = false,
            unlockedAt = null,
            progress = 0,
            target = target
        )
    }
}

