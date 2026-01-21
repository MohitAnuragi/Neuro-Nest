package com.example.neuronest.profile

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.neuronest.puzzlelevels.LevelProgressDao
import com.example.neuronest.puzzlelevels.LevelProgressEntity

@Database(
    entities = [UserProfile::class, LevelProgressEntity::class], 
    version = 5,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun profileDao(): ProfileDao
    abstract fun levelProgressDao(): LevelProgressDao

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
