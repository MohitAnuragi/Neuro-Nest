package com.example.neuronest.sudoku

import com.example.neuronest.profile.ProfileRepository
import com.example.neuronest.puzzlelevels.BasePuzzleViewModel
import com.example.neuronest.puzzlelevels.LevelRepository
import com.example.neuronest.sound.SoundManager
import com.example.neuronest.sound.SoundType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject
import kotlin.math.sqrt

data class SudokuCell(
    val value: Int = 0,
    val isFixed: Boolean = false,
    val isError: Boolean = false,
    val isSelected: Boolean = false,
    val notes: Set<Int> = emptySet()
)

@HiltViewModel
class SudokuPuzzleViewModel @Inject constructor(
    private val profileRepository: ProfileRepository,
    levelRepository: LevelRepository,
    soundManager: SoundManager
) : BasePuzzleViewModel(levelRepository, profileRepository, soundManager) {

    override val puzzleType: String = "SudokuPuzzle"

    private val _grid = MutableStateFlow<List<List<SudokuCell>>>(emptyList())
    val grid: StateFlow<List<List<SudokuCell>>> = _grid.asStateFlow()

    private val _selectedCell = MutableStateFlow<Pair<Int, Int>?>(null)
    val selectedCell: StateFlow<Pair<Int, Int>?> = _selectedCell.asStateFlow()

    private val _gridSize = MutableStateFlow(4)
    val gridSize: StateFlow<Int> = _gridSize.asStateFlow()

    private val _feedback = MutableStateFlow("")
    val feedback: StateFlow<String> = _feedback.asStateFlow()

    private var solutionGrid: List<List<Int>> = emptyList()
    private var puzzleStartTime: Long = 0

    init {
        problemsRequired = 1 // 1 Sudoku puzzle per level
    }

    // Public method to play sounds from UI
    fun playSoundEffect(soundType: SoundType) {
        soundManager.playSound(soundType)
    }

    override fun onLevelLoaded(level: Int) {
        loadPuzzleForLevel(level)
        puzzleStartTime = System.currentTimeMillis()
    }

    override fun resetLevelState() {
        super.resetLevelState()
        _selectedCell.value = null
        _feedback.value = ""
        puzzleStartTime = System.currentTimeMillis()
    }

    private fun loadPuzzleForLevel(level: Int) {
        // Load puzzle directly based on level number (1 puzzle per level)
        val puzzleIndex = (level - 1) % SudokuPuzzleData.puzzles.size
        val puzzleData = SudokuPuzzleData.puzzles[puzzleIndex]

        _gridSize.value = puzzleData.size
        solutionGrid = puzzleData.solution

        // Convert to SudokuCell format
        val cells = puzzleData.puzzle.mapIndexed { _, row ->
            row.mapIndexed { _, value ->
                SudokuCell(
                    value = value,
                    isFixed = value != 0,
                    isError = false,
                    isSelected = false
                )
            }
        }

        _grid.value = cells
        _feedback.value = ""
        _selectedCell.value = null
        puzzleStartTime = System.currentTimeMillis()
    }


    fun selectCell(row: Int, col: Int) {
        if (_isLevelComplete.value) return

        val cell = _grid.value.getOrNull(row)?.getOrNull(col) ?: return
        if (cell.isFixed) {
            soundManager.playSound(SoundType.LOCK)
            _feedback.value = "This cell is fixed!"
            return
        }

        soundManager.playSound(SoundType.BUTTON_CLICK)
        _selectedCell.value = Pair(row, col)
        updateCellSelection(row, col)
    }

    private fun updateCellSelection(selectedRow: Int, selectedCol: Int) {
        _grid.value = _grid.value.mapIndexed { rowIndex, row ->
            row.mapIndexed { colIndex, cell ->
                cell.copy(isSelected = rowIndex == selectedRow && colIndex == selectedCol)
            }
        }
    }

    fun setCellValue(value: Int) {
        val selected = _selectedCell.value ?: return
        if (_isLevelComplete.value) return

        val (row, col) = selected
        val cell = _grid.value[row][col]
        if (cell.isFixed) return

        // Update the cell value and clear any previous error
        val newGrid = _grid.value.map { it.toMutableList() }.toMutableList()
        newGrid[row][col] = cell.copy(value = value, notes = emptySet(), isError = false)

        // Validate the move using generator
        val gridValues = newGrid.map { row -> row.map { it.value } }
        val generator = SudokuGenerator()
        val isValidMove = generator.isValidMove(gridValues, row, col, value, _gridSize.value)

        if (isValidMove) {
            _grid.value = newGrid.map { it.toList() }
            soundManager.playSound(SoundType.CORRECT_MOVE)
            _feedback.value = "Good move!"

            // Check if puzzle is complete
            if (isPuzzleComplete(gridValues)) {
                println("✓✓✓ Sudoku puzzle completed via setCellValue!")
                println("Current level: ${_currentLevel.value}")
                println("Problems solved: $problemsSolved / $problemsRequired")

                val timeTaken = System.currentTimeMillis() - puzzleStartTime
                val pointsEarned = calculateScore(timeTaken)
                _feedback.value = "Sudoku Complete! +$pointsEarned points"

                // Call onProblemSolved which handles progress and completion
                onProblemSolved(timeTaken, pointsEarned)

                println("After onProblemSolved - Problems solved: $problemsSolved / $problemsRequired")
                println("Is level complete: ${_isLevelComplete.value}")
                println("Show dialog: ${_showLevelCompleteDialog.value}")

                // Don't load next puzzle - let the dialog handle navigation
            }
        } else {
            // Mark cell with error
            newGrid[row][col] = cell.copy(value = value, isError = true)
            _grid.value = newGrid.map { it.toList() }
            soundManager.playSound(SoundType.INCORRECT_MOVE)
            _feedback.value = "Invalid move! Check rows, columns, and boxes."
            onIncorrectMove()
        }
    }

    fun clearCell() {
        val selected = _selectedCell.value ?: return
        if (_isLevelComplete.value) return

        val (row, col) = selected
        val cell = _grid.value[row][col]
        if (cell.isFixed) return

        val newGrid = _grid.value.map { it.toMutableList() }.toMutableList()
        newGrid[row][col] = cell.copy(value = 0, isError = false)
        _grid.value = newGrid.map { it.toList() }

        soundManager.playSound(SoundType.BUTTON_CLICK)
        _feedback.value = "Cell cleared"
    }

    fun skipPuzzle() {
        if (_isLevelComplete.value) return

        _feedback.value = "Puzzle skipped!"
        soundManager.playSound(SoundType.TRANSITION)

        // Skip gives no points, but completes the level
        onProblemSolved(0L, 0)

        // Don't load next puzzle - let the dialog handle navigation
    }

    fun checkPuzzle() {
        if (_isLevelComplete.value) return

        val gridValues = _grid.value.map { row -> row.map { it.value } }

        // Debug: Print current grid state
        println("=== Sudoku Grid Debug ===")
        println("Grid size: ${gridValues.size}")
        for (i in gridValues.indices) {
            println("Row $i: ${gridValues[i].joinToString(", ")}")
        }

        // Quick check: Are there any empty cells?
        val emptyCells = mutableListOf<Pair<Int, Int>>()
        for (row in gridValues.indices) {
            for (col in gridValues[row].indices) {
                if (gridValues[row][col] == 0) {
                    emptyCells.add(Pair(row, col))
                }
            }
        }

        if (emptyCells.isNotEmpty()) {
            _feedback.value = "Fill all empty cells! ${emptyCells.size} cells remaining."
            soundManager.playSound(SoundType.INCORRECT_MOVE)
            println("INCOMPLETE: ${emptyCells.size} empty cells found at: $emptyCells")
            return
        }

        if (isPuzzleComplete(gridValues)) {
            println("✓✓✓ Sudoku puzzle completed via checkPuzzle!")
            println("Current level: ${_currentLevel.value}")
            println("Problems solved: $problemsSolved / $problemsRequired")

            val timeTaken = System.currentTimeMillis() - puzzleStartTime
            val pointsEarned = calculateScore(timeTaken)
            _feedback.value = "Sudoku Complete! +$pointsEarned points"
            soundManager.playSound(SoundType.LEVEL_COMPLETE)
            onProblemSolved(timeTaken, pointsEarned)

            println("After onProblemSolved - Problems solved: $problemsSolved / $problemsRequired")
            println("Is level complete: ${_isLevelComplete.value}")
            println("Show dialog: ${_showLevelCompleteDialog.value}")

            // Don't load next puzzle - let the dialog handle navigation
        } else {
            _feedback.value = "Puzzle has errors! Check rows, columns, and boxes."
            soundManager.playSound(SoundType.INCORRECT_MOVE)
        }
    }

    fun showHint() {
        if (_isLevelComplete.value) return

        val selected = _selectedCell.value
        if (selected == null) {
            _feedback.value = "Select a cell first!"
            return
        }

        onHintUsed()
        val (row, col) = selected
        val correctValue = solutionGrid[row][col]

        val newGrid = _grid.value.map { it.toMutableList() }.toMutableList()
        newGrid[row][col] = _grid.value[row][col].copy(value = correctValue, isError = false)
        _grid.value = newGrid.map { it.toList() }

        soundManager.playSound(SoundType.HINT)
        _feedback.value = "Hint: The answer is $correctValue"

        // Check if puzzle is now complete
        val gridValues = _grid.value.map { row -> row.map { it.value } }
        if (isPuzzleComplete(gridValues)) {
            val timeTaken = System.currentTimeMillis() - puzzleStartTime
            val pointsEarned = calculateScore(timeTaken)
            _feedback.value = "Sudoku Complete! +$pointsEarned points"
            onProblemSolved(timeTaken, pointsEarned)

            // Don't load next puzzle - let the dialog handle navigation
        }
    }

    private fun isPuzzleComplete(grid: List<List<Int>>): Boolean {
        val size = grid.size
        val subgridSize = sqrt(size.toDouble()).toInt()

        println("=== isPuzzleComplete Debug ===")
        println("Grid size: $size, Subgrid size: $subgridSize")

        // Step 1: Check all cells are filled with valid numbers (1 to size)
        for (rowIndex in grid.indices) {
            for (colIndex in grid[rowIndex].indices) {
                val cell = grid[rowIndex][colIndex]
                if (cell < 1 || cell > size) {
                    println("FAIL: Cell ($rowIndex,$colIndex) has invalid value: $cell (expected 1-$size)")
                    return false
                }
            }
        }
        println("✓ Step 1 passed: All cells have valid values 1-$size")

        // Step 2: Check all rows have all numbers 1 to size exactly once
        for (rowIndex in grid.indices) {
            val row = grid[rowIndex]
            println("Checking row $rowIndex: ${row.joinToString(", ")}")

            // Check if row has all distinct values
            if (row.distinct().size != size) {
                println("FAIL: Row $rowIndex has duplicates. Distinct count: ${row.distinct().size}")
                return false
            }

            // Check if row contains exactly numbers 1 to size
            val sortedRow = row.sorted()
            for (i in 0 until size) {
                if (sortedRow[i] != i + 1) {
                    println("FAIL: Row $rowIndex missing number ${i+1}. Sorted: ${sortedRow.joinToString(", ")}")
                    return false
                }
            }
        }
        println("✓ Step 2 passed: All rows valid")

        // Step 3: Check all columns have all numbers 1 to size exactly once
        for (col in 0 until size) {
            val column = grid.map { it[col] }
            println("Checking column $col: ${column.joinToString(", ")}")

            // Check if column has all distinct values
            if (column.distinct().size != size) {
                println("FAIL: Column $col has duplicates. Distinct count: ${column.distinct().size}")
                return false
            }

            // Check if column contains exactly numbers 1 to size
            val sortedColumn = column.sorted()
            for (i in 0 until size) {
                if (sortedColumn[i] != i + 1) {
                    println("FAIL: Column $col missing number ${i+1}. Sorted: ${sortedColumn.joinToString(", ")}")
                    return false
                }
            }
        }
        println("✓ Step 3 passed: All columns valid")

        // Step 4: Check all subgrids have all numbers 1 to size exactly once
        for (boxRow in 0 until size step subgridSize) {
            for (boxCol in 0 until size step subgridSize) {
                val box = mutableListOf<Int>()
                for (r in 0 until subgridSize) {
                    for (c in 0 until subgridSize) {
                        box.add(grid[boxRow + r][boxCol + c])
                    }
                }

                println("Checking box at ($boxRow,$boxCol): ${box.joinToString(", ")}")

                // Check if box has all distinct values
                if (box.distinct().size != size) {
                    println("FAIL: Box at ($boxRow,$boxCol) has duplicates. Distinct count: ${box.distinct().size}")
                    return false
                }

                // Check if box contains exactly numbers 1 to size
                val sortedBox = box.sorted()
                for (i in 0 until size) {
                    if (sortedBox[i] != i + 1) {
                        println("FAIL: Box at ($boxRow,$boxCol) missing number ${i+1}. Sorted: ${sortedBox.joinToString(", ")}")
                        return false
                    }
                }
            }
        }
        println("✓ Step 4 passed: All boxes valid")
        println("✓✓✓ Puzzle is COMPLETE! ✓✓✓")

        return true
    }

    private fun calculateScore(timeTaken: Long): Int {
        val level = _currentLevel.value
        val baseScore = when {
            level <= 100 -> 200
            level <= 200 -> 300
            level <= 300 -> 500
            level <= 400 -> 700
            else -> 900
        }

        val timeBonus = maxOf(0, (300000 - timeTaken) / 500).toInt()
        val hintPenalty = hintsUsed * 50
        return baseScore + timeBonus - hintPenalty
    }

    override fun calculateStars(timeTakenMs: Long, hintsUsed: Int, score: Int): Int {
        return when {
            timeTakenMs < 180000 && hintsUsed == 0 && score >= 700 -> 3
            timeTakenMs < 300000 && hintsUsed <= 3 && score >= 400 -> 2
            else -> 1
        }
    }
}
