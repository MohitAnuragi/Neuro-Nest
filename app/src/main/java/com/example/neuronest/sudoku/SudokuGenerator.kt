package com.example.neuronest.sudoku

import kotlin.random.Random

import kotlin.math.sqrt

class SudokuGenerator {

    /**
     * Generates a solvable Sudoku puzzle.
     * @param size The size of the grid (4 or 9).
     * @param clues The number of initial numbers to place on the grid.
     */
    fun generatePuzzle(size: Int, clues: Int): List<List<Int>> {
        val grid = MutableList(size) { MutableList(size) { 0 } }
        // Use a backtracking algorithm to fill the grid.
        solveGrid(grid, size)

        // Remove numbers to create the puzzle.
        val cellsToRemove = size * size - clues
        val allCells = (0 until size * size).shuffled(Random(System.currentTimeMillis()))

        for (i in 0 until cellsToRemove) {
            val cellIndex = allCells[i]
            val row = cellIndex / size
            val col = cellIndex % size
            grid[row][col] = 0
        }

        return grid.map { it.toList() }
    }

    /**
     * Backtracking algorithm to fill the Sudoku grid.
     */
    fun solveGrid(grid: MutableList<MutableList<Int>>, size: Int): Boolean {
        for (row in 0 until size) {
            for (col in 0 until size) {
                if (grid[row][col] == 0) {
                    val numbers = (1..size).shuffled(Random(System.currentTimeMillis()))
                    for (number in numbers) {
                        if (isValidMove(grid.map { it.toList() }, row, col, number, size)) {
                            grid[row][col] = number
                            if (solveGrid(grid, size)) {
                                return true
                            } else {
                                grid[row][col] = 0 // Backtrack
                            }
                        }
                    }
                    return false
                }
            }
        }
        return true
    }

    /**
     * Checks if a move is valid based on Sudoku rules.
     */
    fun isValidMove(grid: List<List<Int>>, row: Int, col: Int, number: Int, size: Int): Boolean {
        // Check row and column
        for (i in 0 until size) {
            if (grid[row][i] == number || grid[i][col] == number) {
                return false
            }
        }

        // Check subgrid
        val subgridSize = sqrt(size.toDouble()).toInt()
        val startRow = row - row % subgridSize
        val startCol = col - col % subgridSize

        for (i in 0 until subgridSize) {
            for (j in 0 until subgridSize) {
                if (grid[i + startRow][j + startCol] == number) {
                    return false
                }
            }
        }

        return true
    }
}

