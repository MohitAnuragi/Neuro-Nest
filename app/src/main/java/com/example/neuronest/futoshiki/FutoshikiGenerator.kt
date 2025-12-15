package com.example.neuronest.futoshiki

class FutoshikiGenerator {

    fun generatePuzzle(size: Int, clueCount: Int, constraintCount: Int): FutoshikiPuzzle {
        // Step 1: Generate a fully solved Sudoku-style grid.
        val solvedGrid = generateSolvedGrid(size)

        // Step 2: Generate a list of random inequality constraints.
        val constraints = generateConstraints(solvedGrid, constraintCount)

        // Step 3: Remove numbers from the solved grid to create clues.
        val initialGrid = generateInitialGrid(solvedGrid, clueCount)

        return FutoshikiPuzzle(size, initialGrid, constraints, solvedGrid)
    }

    /**
     * Generates a solved grid using a backtracking algorithm to ensure validity.
     */
    private fun generateSolvedGrid(size: Int): List<List<Int>> {
        val grid = MutableList(size) { MutableList(size) { 0 } }
        solveGrid(grid, 0, 0, size)
        return grid.map { it.toList() }
    }

    /**
     * Recursive backtracking algorithm to solve the grid.
     */
    private fun solveGrid(grid: MutableList<MutableList<Int>>, row: Int, col: Int, size: Int): Boolean {
        if (row == size) return true // Reached the end of the grid

        var nextRow = row
        var nextCol = col + 1
        if (nextCol == size) {
            nextRow++
            nextCol = 0
        }

        if (grid[row][col] != 0) {
            return solveGrid(grid, nextRow, nextCol, size)
        }

        val numbers = (1..size).shuffled()
        for (num in numbers) {
            if (isValidPlacement(grid, row, col, num, size)) {
                grid[row][col] = num
                if (solveGrid(grid, nextRow, nextCol, size)) {
                    return true
                }
                grid[row][col] = 0
            }
        }

        return false
    }

    private fun isValidPlacement(grid: List<List<Int>>, row: Int, col: Int, num: Int, size: Int): Boolean {
        // Check row
        for (i in 0 until size) {
            if (grid[row][i] == num) return false
        }

        // Check column
        for (i in 0 until size) {
            if (grid[i][col] == num) return false
        }

        return true
    }

    private fun generateConstraints(solvedGrid: List<List<Int>>, count: Int): List<FutoshikiConstraint> {
        val size = solvedGrid.size
        val allPossibleConstraints = mutableListOf<FutoshikiConstraint>()

        // Generate all possible horizontal constraints (right direction)
        for (i in 0 until size) {
            for (j in 0 until size - 1) {
                val value1 = solvedGrid[i][j]
                val value2 = solvedGrid[i][j + 1]
                if (value1 != value2) {
                    val symbol = if (value1 > value2) ">" else "<"
                    allPossibleConstraints.add(FutoshikiConstraint(i, j, "right", symbol))
                }
            }
        }

        // Generate all possible vertical constraints (down direction)
        for (i in 0 until size - 1) {
            for (j in 0 until size) {
                val value1 = solvedGrid[i][j]
                val value2 = solvedGrid[i + 1][j]
                if (value1 != value2) {
                    val symbol = if (value1 > value2) ">" else "<"
                    allPossibleConstraints.add(FutoshikiConstraint(i, j, "down", symbol))
                }
            }
        }

        // Shuffle and take a limited number of constraints.
        return allPossibleConstraints.shuffled().take(count)
    }


    private fun generateInitialGrid(solvedGrid: List<List<Int>>, clueCount: Int): List<List<Int>> {
        val size = solvedGrid.size
        val initialGrid = solvedGrid.map { it.toMutableList() }
        val allCells = (0 until size * size).shuffled()

        // Remove numbers from all cells except for the clueCount.
        for (i in clueCount until allCells.size) {
            val cellIndex = allCells[i]
            val row = cellIndex / size
            val col = cellIndex % size
            initialGrid[row][col] = 0
        }
        return initialGrid.map { it.toList() }
    }
}
