package com.neuronest.neuronest.puzzlelevels

import androidx.room.Entity
import androidx.room.Index

@Entity(
    tableName = "level_progress",
    primaryKeys = ["puzzleType", "levelNumber"],
    indices = [Index(value = ["puzzleType", "levelNumber"], unique = true)]
)
data class LevelProgressEntity(
    val puzzleType: String,
    val levelNumber: Int,
    val isCompleted: Boolean = false,
    val starsEarned: Int = 0,
    val bestScore: Int = 0,
    val bestTime: Long? = null,
    val attempts: Int = 0,
    val lastPlayed: Long = System.currentTimeMillis()
)

data class LevelProgress(
    val puzzleType: String,
    val currentLevel: Int,
    val totalScore: Long,
    val totalStars: Int,
    val levelsCompleted: Int,
    val isMaxLevelReached: Boolean
)

data class LevelDetails(
    val levelNumber: Int,
    val puzzleType: String,
    val difficulty: String,
    val isUnlocked: Boolean,
    val isCompleted: Boolean,
    val starsEarned: Int,
    val bestScore: Int,
    val bestTime: Long?,
    val attempts: Int
)

data class LevelCompletionResult(
    val levelNumber: Int,
    val puzzleType: String,
    val starsEarned: Int,
    val score: Int,
    val isNewHighScore: Boolean,
    val isLevelCompleted: Boolean,
    val nextLevelUnlocked: Boolean
)

sealed class PuzzleConfig {
    data class SudokuConfig(val clues: Int, val gridSize: Int = 9) : PuzzleConfig()
    data class WordPuzzleConfig(val wordCount: Int, val gridWidth: Int, val gridHeight: Int) : PuzzleConfig()
    data class MemoryPuzzleConfig(val gridSize: Int, val showTimeSeconds: Int) : PuzzleConfig()
    data class SlidingPuzzleConfig(val gridSize: Int, val shuffleCount: Int) : PuzzleConfig()
    data class KakuroConfig(val gridSize: Int, val difficulty: Int) : PuzzleConfig()
    data class ArithmeticConfig(val operations: List<String>, val range: IntRange, val terms: Int) : PuzzleConfig()
    data class SequenceConfig(val complexity: Int, val length: Int) : PuzzleConfig()
    data class ColorMatchingConfig(val colorCount: Int, val speed: Float) : PuzzleConfig()
    data class GenericConfig(val difficultyLevel: Int, val params: Map<String, String> = emptyMap()) : PuzzleConfig()
}