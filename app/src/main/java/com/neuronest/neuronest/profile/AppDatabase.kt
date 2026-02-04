package com.neuronest.neuronest.profile

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.neuronest.neuronest.achievements.AchievementDao
import com.neuronest.neuronest.achievements.AchievementEntity
import com.neuronest.neuronest.puzzlelevels.LevelProgressDao
import com.neuronest.neuronest.puzzlelevels.LevelProgressEntity

@Database(
    entities = [UserProfile::class, LevelProgressEntity::class, AchievementEntity::class],
    version = 6,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun profileDao(): ProfileDao
    abstract fun levelProgressDao(): LevelProgressDao
    abstract fun achievementDao(): AchievementDao

    companion object {
        @Volatile
        private var Instance: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(
                    context,
                    AppDatabase::class.java,
                    "puzzle_app_database"
                )
                    .fallbackToDestructiveMigration()
                    .build().also { Instance = it }
            }
        }
    }
}
