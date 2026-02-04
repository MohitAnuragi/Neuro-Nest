package com.neuronest.neuronest.connection

data class ConnectionPuzzle(
    val level: Int,
    val words: List<String>,
    val categories: List<ConnectionCategory>,
    val difficulty: String
)

data class ConnectionCategory(
    val name: String,
    val words: Set<String>,
    val color: CategoryColor
)

enum class CategoryColor {
    YELLOW,
    GREEN,
    BLUE,
    PURPLE
}

