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
        problemsRequired = 3 // 3 Sudoku puzzles per level
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
        // Load puzzle from data based on level and current puzzle within level
        val puzzleIndexBase = (level - 1) * problemsRequired
        val pickIndex = (puzzleIndexBase + (problemsSolved % problemsRequired)) % SudokuPuzzleData.puzzles.size
        val puzzleData = SudokuPuzzleData.puzzles[pickIndex]

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

        // Update the cell value
        val newGrid = _grid.value.map { it.toMutableList() }.toMutableList()
        newGrid[row][col] = cell.copy(value = value, notes = emptySet())

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
                val timeTaken = System.currentTimeMillis() - puzzleStartTime
                val pointsEarned = calculateScore(timeTaken)
                _feedback.value = "Sudoku Complete! +$pointsEarned points"

                // Call onProblemSolved which handles progress and completion
                onProblemSolved(timeTaken, pointsEarned)

                // Generate next puzzle if level not complete
                if (!_isLevelComplete.value) {
                    loadPuzzleForLevel(_currentLevel.value)
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
            loadPuzzleForLevel(_currentLevel.value)
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
                loadPuzzleForLevel(_currentLevel.value)
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
                loadPuzzleForLevel(_currentLevel.value)
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
}
