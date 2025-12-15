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
    private val generator = SudokuGenerator()
    private var puzzleStartTime: Long = 0

    init {
        problemsRequired = 3 // 3 puzzles per level like Arithmetic
    }

    override fun onLevelLoaded(level: Int) {
        generatePuzzle(level)
        puzzleStartTime = System.currentTimeMillis()
    }

    override fun resetLevelState() {
        super.resetLevelState()
        _selectedCell.value = null
        _feedback.value = ""
        puzzleStartTime = System.currentTimeMillis()
    }

    private fun generatePuzzle(level: Int) {
        val (size, clues) = getDifficultyParams(level)
        _gridSize.value = size

        // Generate a complete solution first
        val completeSolution = MutableList(size) { MutableList(size) { 0 } }
        generator.solveGrid(completeSolution, size)
        solutionGrid = completeSolution.map { it.toList() }

        // Create puzzle with clues
        val puzzleGrid = generator.generatePuzzle(size, clues)

        // Convert to SudokuCell format
        val cells = puzzleGrid.mapIndexed { _, row ->
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
        puzzleStartTime = System.currentTimeMillis()
    }

    private fun getDifficultyParams(level: Int): Pair<Int, Int> {
        return when {
            // Levels 1-100: 4x4 grids (easy to medium)
            level <= 50 -> Pair(4, 10)  // 4x4 with 10 clues
            level <= 100 -> Pair(4, 8)   // 4x4 with 8 clues
            // Levels 101-200: 6x6 grids (medium)
            level <= 150 -> Pair(6, 20)  // 6x6 with 20 clues (not standard, but works)
            level <= 200 -> Pair(6, 16)  // 6x6 with 16 clues
            // Levels 201-300: 9x9 grids (medium to hard)
            level <= 250 -> Pair(9, 40)  // 9x9 with 40 clues
            level <= 300 -> Pair(9, 35)  // 9x9 with 35 clues
            // Levels 301-400: 9x9 harder
            level <= 350 -> Pair(9, 30)  // 9x9 with 30 clues
            level <= 400 -> Pair(9, 27)  // 9x9 with 27 clues
            // Levels 401-500: 9x9 expert
            else -> Pair(9, 25)          // 9x9 with 25 clues
        }
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

        // Update the cell value
        val newGrid = _grid.value.map { it.toMutableList() }.toMutableList()
        newGrid[row][col] = cell.copy(value = value, notes = emptySet())

        // Validate the move
        val gridValues = newGrid.map { row -> row.map { it.value } }
        val isValidMove = generator.isValidMove(gridValues, row, col, value, _gridSize.value)

        if (isValidMove) {
            _grid.value = newGrid.map { it.toList() }
            soundManager.playSound(SoundType.CORRECT_MOVE)
            _feedback.value = "Good move!"

            // Check if puzzle is complete
            if (isPuzzleComplete(gridValues)) {
                val timeTaken = System.currentTimeMillis() - puzzleStartTime
                val pointsEarned = calculateScore(timeTaken)
                _feedback.value = "Sudoku Complete! +$pointsEarned points"

                // Call onProblemSolved which handles progress and completion
                onProblemSolved(timeTaken, pointsEarned)

                // Generate next puzzle if level not complete
                if (!_isLevelComplete.value) {
                    generatePuzzle(_currentLevel.value)
                    _selectedCell.value = null
                }
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

        // Generate next puzzle or complete level
        onProblemSolved(0L, 0) // Skip gives no points

        if (!_isLevelComplete.value) {
            generatePuzzle(_currentLevel.value)
            _selectedCell.value = null
        }
    }

    fun checkPuzzle() {
        if (_isLevelComplete.value) return

        val gridValues = _grid.value.map { row -> row.map { it.value } }

        if (isPuzzleComplete(gridValues)) {
            val timeTaken = System.currentTimeMillis() - puzzleStartTime
            val pointsEarned = calculateScore(timeTaken)
            _feedback.value = "Sudoku Complete! +$pointsEarned points"
            onProblemSolved(timeTaken, pointsEarned)

            if (!_isLevelComplete.value) {
                generatePuzzle(_currentLevel.value)
                _selectedCell.value = null
            }
        } else {
            _feedback.value = "Puzzle not complete or has errors!"
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

            // Generate next puzzle if level not complete
            if (!_isLevelComplete.value) {
                generatePuzzle(_currentLevel.value)
                _selectedCell.value = null
            }
        }
    }

    private fun isPuzzleComplete(grid: List<List<Int>>): Boolean {
        // All cells must be filled
        if (grid.any { row -> row.any { it == 0 } }) return false

        val size = grid.size
        val subgridSize = sqrt(size.toDouble()).toInt()

        // Check all rows
        for (row in grid) {
            if (row.distinct().size != size) return false
        }

        // Check all columns
        for (col in 0 until size) {
            val column = grid.map { it[col] }
            if (column.distinct().size != size) return false
        }

        // Check all subgrids
        for (boxRow in 0 until size step subgridSize) {
            for (boxCol in 0 until size step subgridSize) {
                val box = mutableListOf<Int>()
                for (r in 0 until subgridSize) {
                    for (c in 0 until subgridSize) {
                        box.add(grid[boxRow + r][boxCol + c])
                    }
                }
                if (box.distinct().size != size) return false
            }
        }

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

    // Public method for generator (needed by screen)
    fun isValidMove(grid: List<List<Int>>, row: Int, col: Int, number: Int): Boolean {
        return generator.isValidMove(grid, row, col, number, _gridSize.value)
    }
}
