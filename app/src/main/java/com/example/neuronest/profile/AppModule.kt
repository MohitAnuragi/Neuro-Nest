package com.example.neuronest.profile

import android.content.Context
import com.example.neuronest.achievements.AchievementDao
import com.example.neuronest.achievements.AchievementRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import com.example.neuronest.puzzlelevels.LevelProgressDao

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return AppDatabase.getDatabase(context)
    }

    @Provides
    @Singleton
    fun provideProfileRepository(
        database: AppDatabase,
        @ApplicationContext context: Context
    ): ProfileRepository {
        return ProfileRepositoryImpl(
            database.profileDao(), context
        )
    }

    @Provides
    @Singleton
    fun provideLevelProgressDao(database: AppDatabase): LevelProgressDao {
        return database.levelProgressDao()
    }

    @Provides
    @Singleton
    fun provideAchievementDao(database: AppDatabase): AchievementDao {
        return database.achievementDao()
    }

    @Provides
    @Singleton
    fun provideAchievementRepository(
        achievementDao: AchievementDao,
        levelProgressDao: LevelProgressDao
    ): AchievementRepository {
        return AchievementRepository(achievementDao, levelProgressDao)
    }
}