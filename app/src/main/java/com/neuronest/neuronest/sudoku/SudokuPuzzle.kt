package com.neuronest.neuronest.sudoku

data class SudokuPuzzle(
    val level: Int,
    val size: Int, // 4x4 or 9x9
    val puzzle: List<List<Int>>, // 0 means empty cell
    val solution: List<List<Int>>, // Complete solution
    val difficulty: String
)


