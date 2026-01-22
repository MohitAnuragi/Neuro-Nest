package com.example.neuronest.puzzlelevels

import kotlin.math.min
import kotlin.math.max

object DifficultyGenerator {

    fun generateConfig(puzzleType: String, level: Int): PuzzleConfig {
        val safeLevel = level.coerceIn(1, 500)
        
        return when (puzzleType) {
            "Sudoku" -> generateSudokuConfig(safeLevel)
            "WordScramble" -> generateWordPuzzleConfig(safeLevel)
            "Memory" -> generateMemoryPuzzleConfig(safeLevel)
            "Sliding" -> generateSlidingPuzzleConfig(safeLevel)
            "Kakuro" -> generateKakuroConfig(safeLevel)
            "Arithmetic" -> generateArithmeticConfig(safeLevel)
            "Sequence" -> generateSequenceConfig(safeLevel)
            "ColorMatching" -> generateColorMatchingConfig(safeLevel)
            else -> PuzzleConfig.GenericConfig(safeLevel)
        }
    }

    private fun generateSudokuConfig(level: Int): PuzzleConfig.SudokuConfig {
        val clues = 45 - ((level.toFloat() / 500f) * (45 - 17)).toInt()
        return PuzzleConfig.SudokuConfig(clues = clues)
    }

    private fun generateWordPuzzleConfig(level: Int): PuzzleConfig.WordPuzzleConfig {
        val size = 5 + (level / 70)
        val wordCount = 3 + (level / 40)
        return PuzzleConfig.WordPuzzleConfig(
            wordCount = min(wordCount, 15),
            gridWidth = min(size, 12),
            gridHeight = min(size, 12)
        )
    }

    private fun generateMemoryPuzzleConfig(level: Int): PuzzleConfig.MemoryPuzzleConfig {

        val gridSize = when {
            level < 20 -> 2 // 2x2
            level < 50 -> 4 // 4x4 (Wait, 2x2=4, 4x4=16. Need even numbers for pairs)
            level < 100 -> 4
            level < 200 -> 6
            else -> 6
        }
        
        // Refined grid logic for pairs
        val columns = when {
            level < 20 -> 2
            level < 60 -> 3
            level < 150 -> 4
            level < 300 -> 5
            else -> 6
        }
        val rows = when {
            level < 40 -> 2
            level < 100 -> 4
            level < 250 -> 4 // 4x4 or 5x4
            else -> 6
        }
        
        // Ensure even number of cards
        val adjustedRows = if ((columns * rows) % 2 != 0) rows + 1 else rows
        
        val showTime = max(1, 5 - (level / 100))
        
        return PuzzleConfig.MemoryPuzzleConfig(
            gridSize = columns * adjustedRows, // Simplified, actual implementation might need rows/cols
            showTimeSeconds = showTime
        )
    }

    private fun generateSlidingPuzzleConfig(level: Int): PuzzleConfig.SlidingPuzzleConfig {
        // Grid: 3x3 to 5x5
        // Shuffles: 10 to 100
        val gridSize = when {
            level < 100 -> 3
            level < 300 -> 4
            else -> 5
        }
        val shuffles = 10 + (level / 5)
        return PuzzleConfig.SlidingPuzzleConfig(gridSize = gridSize, shuffleCount = shuffles)
    }

    private fun generateKakuroConfig(level: Int): PuzzleConfig.KakuroConfig {
        val gridSize = when {
            level < 100 -> 5
            level < 300 -> 7
            else -> 9
        }
        return PuzzleConfig.KakuroConfig(gridSize = gridSize, difficulty = level)
    }

    private fun generateArithmeticConfig(level: Int): PuzzleConfig.ArithmeticConfig {
        val operations = mutableListOf("ADD")
        if (level > 20) operations.add("SUB")
        if (level > 50) operations.add("MUL")
        if (level > 100) operations.add("DIV")
        
        val maxVal = 10 + level
        val terms = 2 + (level / 100)
        
        return PuzzleConfig.ArithmeticConfig(
            operations = operations,
            range = 1..maxVal,
            terms = min(terms, 5)
        )
    }
    
    private fun generateSequenceConfig(level: Int): PuzzleConfig.SequenceConfig {
        return PuzzleConfig.SequenceConfig(
            complexity = level,
            length = 4 + (level / 50)
        )
    }
    
    private fun generateColorMatchingConfig(level: Int): PuzzleConfig.ColorMatchingConfig {
        return PuzzleConfig.ColorMatchingConfig(
            colorCount = 3 + (level / 100),
            speed = 1.0f + (level.toFloat() / 200f)
        )
    }
}
