package com.example.neuronest.puzzlelevels


import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class LevelModule {

    @Binds
    @Singleton
    abstract fun bindLevelRepository(
        levelRepositoryImpl: LevelRepositoryImpl
    ): LevelRepository
}