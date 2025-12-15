package com.example.neuronest.futoshiki

data class FutoshikiPuzzle(
    val size: Int,
    val initialGrid: List<List<Int>>,
    val constraints: List<FutoshikiConstraint>,
    val solution: List<List<Int>>
)

data class Constraint(
    val row1: Int,
    val col1: Int,
    val direction: Int,
    val type: Char
)

data class FutoshikiConstraint(
    val row: Int,
    val col: Int,
    val direction: String, // "right" or "down"
    val symbol: String // ">" or "<"
)
