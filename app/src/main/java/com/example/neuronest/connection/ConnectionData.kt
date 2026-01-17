package com.example.neuronest.connection

// Data model for Connection puzzle
data class ConnectionPuzzle(
    val level: Int,
    val words: List<String>, // 16 words total
    val categories: List<ConnectionCategory>, // 4 categories
    val difficulty: String
)

data class ConnectionCategory(
    val name: String,
    val words: Set<String>, // 4 words in this category
    val color: CategoryColor
)

enum class CategoryColor {
    YELLOW,  // Easiest
    GREEN,   // Easy
    BLUE,    // Medium
    PURPLE   // Hardest
}

