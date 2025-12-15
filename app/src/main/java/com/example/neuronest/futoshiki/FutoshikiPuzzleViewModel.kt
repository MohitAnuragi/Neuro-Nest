package com.example.neuronest.futoshiki

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

data class FutoshikiCell(
    val value: Int = 0,
    val isFixed: Boolean = false,
    val isError: Boolean = false,
    val isSelected: Boolean = false
)

@HiltViewModel
class FutoshikiPuzzleViewModel @Inject constructor(
    private val profileRepository: ProfileRepository,
    levelRepository: LevelRepository,
    soundManager: SoundManager
) : BasePuzzleViewModel(levelRepository, profileRepository, soundManager) {

    override val puzzleType: String = "FutoshikiPuzzle"

    private val _grid = MutableStateFlow<List<List<FutoshikiCell>>>(emptyList())
    val grid: StateFlow<List<List<FutoshikiCell>>> = _grid.asStateFlow()

    private val _constraints = MutableStateFlow<List<FutoshikiConstraint>>(emptyList())
    val constraints: StateFlow<List<FutoshikiConstraint>> = _constraints.asStateFlow()

    private val _selectedCell = MutableStateFlow<Pair<Int, Int>?>(null)
    val selectedCell: StateFlow<Pair<Int, Int>?> = _selectedCell.asStateFlow()

    private val _gridSize = MutableStateFlow(4)
    val gridSize: StateFlow<Int> = _gridSize.asStateFlow()

    private val _feedback = MutableStateFlow("")
    val feedback: StateFlow<String> = _feedback.asStateFlow()

    private var solutionGrid: List<List<Int>> = emptyList()
    private val generator = FutoshikiGenerator()
    private var puzzleStartTime: Long = 0

    init {
        problemsRequired = 1 // One complete puzzle per level
    }

    override fun onLevelLoaded(level: Int) {
        generatePuzzle(level)
        puzzleStartTime = System.currentTimeMillis()
    }

    override fun resetLevelState() {
        super.resetLevelState()
        _selectedCell.value = null
        _feedback.value = ""
    }

    private fun generatePuzzle(level: Int) {
        val (size, clues, constraintCount) = getDifficultyParams(level)
        _gridSize.value = size

        val puzzleData = generator.generatePuzzle(size, clues, constraintCount)
        solutionGrid = puzzleData.solution

        // Convert to FutoshikiCell format
        val cells = puzzleData.initialGrid.mapIndexed { rowIndex, row ->
            row.mapIndexed { colIndex, value ->
                FutoshikiCell(
                    value = value,
                    isFixed = value != 0,
                    isError = false,
                    isSelected = false
                )
            }
        }

        _grid.value = cells
        _constraints.value = puzzleData.constraints
        _feedback.value = ""
    }

    private fun getDifficultyParams(level: Int): Triple<Int, Int, Int> {
        return when {
            level <= 100 -> Triple(4, 8, 4) // 4x4 grid, 8 clues, 4 constraints
            level <= 200 -> Triple(5, 10, 6) // 5x5 grid
            level <= 300 -> Triple(5, 8, 8) // 5x5, fewer clues, more constraints
            level <= 400 -> Triple(6, 12, 10) // 6x6 grid
            else -> Triple(6, 10, 12) // 6x6, fewer clues, more constraints
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
        newGrid[row][col] = cell.copy(value = value)

        // Validate the move
        val gridValues = newGrid.map { row -> row.map { it.value } }
        val isValidMove = validateGrid(gridValues, _constraints.value)

        if (isValidMove) {
            _grid.value = newGrid.map { it.toList() }
            soundManager.playSound(SoundType.CORRECT_MOVE)
            _feedback.value = "Good move!"

            // Check if puzzle is complete
            if (isPuzzleComplete(gridValues)) {
                val timeTaken = System.currentTimeMillis() - puzzleStartTime
                val pointsEarned = calculateScore(timeTaken)
                _feedback.value = "Puzzle Complete! +$pointsEarned points"

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
            _feedback.value = "Invalid move! Check the constraints."
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
            _feedback.value = "Puzzle Complete! +$pointsEarned points"
            onProblemSolved(timeTaken, pointsEarned)

            // Generate next puzzle if level not complete
            if (!_isLevelComplete.value) {
                generatePuzzle(_currentLevel.value)
                _selectedCell.value = null
            }
        }
    }

    private fun validateGrid(grid: List<List<Int>>, constraints: List<FutoshikiConstraint>): Boolean {
        val size = grid.size

        // Check rows - no duplicates
        for (row in grid) {
            val nonZero = row.filter { it != 0 }
            if (nonZero.size != nonZero.distinct().size) return false
        }

        // Check columns - no duplicates
        for (col in 0 until size) {
            val column = grid.map { it[col] }.filter { it != 0 }
            if (column.size != column.distinct().size) return false
        }

        // Check constraints
        for (constraint in constraints) {
            val value1 = grid[constraint.row][constraint.col]
            if (value1 == 0) continue

            val (row2, col2) = when (constraint.direction) {
                "right" -> Pair(constraint.row, constraint.col + 1)
                "down" -> Pair(constraint.row + 1, constraint.col)
                else -> continue
            }

            if (row2 >= size || col2 >= size) continue
            val value2 = grid[row2][col2]
            if (value2 == 0) continue

            val isValid = when (constraint.symbol) {
                ">" -> value1 > value2
                "<" -> value1 < value2
                else -> true
            }

            if (!isValid) return false
        }

        return true
    }

    private fun isPuzzleComplete(grid: List<List<Int>>): Boolean {
        // All cells must be filled
        if (grid.any { row -> row.any { it == 0 } }) return false

        // Must be valid
        return validateGrid(grid, _constraints.value)
    }

    private fun calculateScore(timeTaken: Long): Int {
        val level = _currentLevel.value
        val baseScore = when {
            level <= 100 -> 200
            level <= 200 -> 300
            level <= 300 -> 400
            level <= 400 -> 500
            else -> 600
        }

        val timeBonus = maxOf(0, (120000 - timeTaken) / 200).toInt()
        val hintPenalty = hintsUsed * 50
        return baseScore + timeBonus - hintPenalty
    }

    override fun calculateStars(timeTakenMs: Long, hintsUsed: Int, score: Int): Int {
        return when {
            timeTakenMs < 60000 && hintsUsed == 0 && score >= 500 -> 3
            timeTakenMs < 120000 && hintsUsed <= 2 && score >= 300 -> 2
            else -> 1
        }
    }
}

