package com.neuronest.neuronest.kakuro

import com.neuronest.neuronest.profile.ProfileRepository
import com.neuronest.neuronest.puzzlelevels.BasePuzzleViewModel
import com.neuronest.neuronest.puzzlelevels.LevelRepository
import com.neuronest.neuronest.sound.SoundManager
import com.neuronest.neuronest.sound.SoundType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class KakuroViewModel @Inject constructor(
    private val profileRepository: ProfileRepository,
    levelRepository: LevelRepository,
    soundManager: SoundManager
) : BasePuzzleViewModel(levelRepository, profileRepository, soundManager) {

    override val puzzleType: String = "Kakuro"

    private val _currentPuzzle = MutableStateFlow<KakuroPuzzle?>(null)
    val currentPuzzle: StateFlow<KakuroPuzzle?> = _currentPuzzle.asStateFlow()

    private val _grid = MutableStateFlow<List<List<KakuroCell>>>(emptyList())
    val grid: StateFlow<List<List<KakuroCell>>> = _grid.asStateFlow()

    private val _selectedCell = MutableStateFlow<Pair<Int, Int>?>(null)
    val selectedCell: StateFlow<Pair<Int, Int>?> = _selectedCell.asStateFlow()

    private val _feedback = MutableStateFlow("")
    val feedback: StateFlow<String> = _feedback.asStateFlow()

    private val _isCorrect = MutableStateFlow<Boolean?>(null)
    val isCorrect: StateFlow<Boolean?> = _isCorrect.asStateFlow()

    private val _showMaintenanceDialog = MutableStateFlow(false)
    val showMaintenanceDialog: StateFlow<Boolean> = _showMaintenanceDialog.asStateFlow()

    private var puzzleStartTime: Long = 0

    companion object {
        const val MAX_AVAILABLE_LEVELS = 25
    }

    init {
        problemsRequired = 1
    }

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
        _isCorrect.value = null
    }

    private fun loadPuzzleForLevel(level: Int) {
        val puzzle = KakuroPuzzleData.getPuzzleForLevel(level)

        _currentPuzzle.value = puzzle
        _grid.value = puzzle.grid
        _selectedCell.value = null
        _feedback.value = ""
        _isCorrect.value = null
        puzzleStartTime = System.currentTimeMillis()
    }

    fun selectCell(row: Int, col: Int) {
        if (_isLevelComplete.value) return

        val cell = _grid.value.getOrNull(row)?.getOrNull(col)
        if (cell is KakuroCell.ClueCell) {
            soundManager.playSound(SoundType.LOCK)
            _feedback.value = "This is a clue cell!"
            return
        }

        soundManager.playSound(SoundType.BUTTON_CLICK)
        _selectedCell.value = Pair(row, col)
        updateCellSelection(row, col)
    }

    private fun updateCellSelection(selectedRow: Int, selectedCol: Int) {
        _grid.value = _grid.value.mapIndexed { rowIndex, row ->
            row.mapIndexed { colIndex, cell ->
                when (cell) {
                    is KakuroCell.PlayCell -> {
                        cell.copy(isSelected = rowIndex == selectedRow && colIndex == selectedCol)
                    }
                    is KakuroCell.ClueCell -> cell
                }
            }
        }
    }

    fun setCellValue(value: Int) {
        val selected = _selectedCell.value ?: return
        if (_isLevelComplete.value) return

        val (row, col) = selected
        val cell = _grid.value[row][col]

        if (cell !is KakuroCell.PlayCell) return

        val puzzle = _currentPuzzle.value ?: return
        val isValid = validateMove(row, col, value, puzzle)

        val newGrid = _grid.value.map { it.toMutableList() }.toMutableList()

        if (isValid) {
            newGrid[row][col] = cell.copy(value = value, isError = false)
            _grid.value = newGrid.map { it.toList() }
            soundManager.playSound(SoundType.CORRECT_MOVE)
            _feedback.value = "Good move!"
            _isCorrect.value = true

            if (isPuzzleComplete(newGrid.map { it.toList() }, puzzle)) {
                val timeTaken = System.currentTimeMillis() - puzzleStartTime
                val pointsEarned = calculateScore(timeTaken)
                _feedback.value = "Kakuro Complete! +$pointsEarned points"
                soundManager.playSound(SoundType.LEVEL_COMPLETE)
                onProblemSolved(timeTaken, pointsEarned)
            }
        } else {
            newGrid[row][col] = cell.copy(value = value, isError = true)
            _grid.value = newGrid.map { it.toList() }
            soundManager.playSound(SoundType.INCORRECT_MOVE)
            _feedback.value = "Invalid move! Check sums and duplicates."
            _isCorrect.value = false
            onIncorrectMove()
        }
    }

    fun clearCell() {
        val selected = _selectedCell.value ?: return
        if (_isLevelComplete.value) return

        val (row, col) = selected
        val cell = _grid.value[row][col]

        if (cell !is KakuroCell.PlayCell) return

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
            soundManager.playSound(SoundType.LOCK)
            _feedback.value = "please fill a value first!"
            _isCorrect.value = false
            return
        }

        onHintUsed()

        val (row, col) = selected
        val puzzle = _currentPuzzle.value ?: return
        val correctValue = puzzle.solution[selected] ?: return

        val newGrid = _grid.value.map { it.toMutableList() }.toMutableList()
        val cell = newGrid[row][col]

        if (cell !is KakuroCell.PlayCell) {
            soundManager.playSound(SoundType.LOCK)
            _feedback.value = "Cannot show hint for clue cells!"
            _isCorrect.value = false
            return
        }

        newGrid[row][col] = cell.copy(value = correctValue, isError = false)
        _grid.value = newGrid.map { it.toList() }

        soundManager.playSound(SoundType.HINT)
        _feedback.value = "Hint: The answer is $correctValue"
        _isCorrect.value = true

        if (isPuzzleComplete(newGrid.map { it.toList() }, puzzle)) {
            val timeTaken = System.currentTimeMillis() - puzzleStartTime
            val pointsEarned = calculateScore(timeTaken)
            _feedback.value = "Kakuro Complete! +$pointsEarned points"
            soundManager.playSound(SoundType.LEVEL_COMPLETE)
            onProblemSolved(timeTaken, pointsEarned)
        }
    }

    fun checkPuzzle() {
        if (_isLevelComplete.value) return

        val puzzle = _currentPuzzle.value ?: return
        val grid = _grid.value

        println("=== Kakuro Validation Debug ===")
        println("Grid size: ${grid.size} x ${grid.firstOrNull()?.size ?: 0}")
        println("Puzzle rows: ${puzzle.rows}, cols: ${puzzle.cols}")

        // Print current grid state
        for (row in grid.indices) {
            for (col in grid[row].indices) {
                val cell = grid[row][col]
                if (cell is KakuroCell.PlayCell) {
                    println("Cell ($row, $col): value=${cell.value}, expected=${puzzle.solution[Pair(row, col)]}")
                }
            }
        }

        if (isPuzzleComplete(grid, puzzle)) {
            val timeTaken = System.currentTimeMillis() - puzzleStartTime
            val pointsEarned = calculateScore(timeTaken)
            _feedback.value = "Kakuro Complete! +$pointsEarned points"
            soundManager.playSound(SoundType.LEVEL_COMPLETE)
            onProblemSolved(timeTaken, pointsEarned)
        } else {
            _feedback.value = "Puzzle not complete or has errors!"
            soundManager.playSound(SoundType.INCORRECT_MOVE)
        }
    }

    private fun validateMove(row: Int, col: Int, value: Int, puzzle: KakuroPuzzle): Boolean {
        if (value < 1 || value > 9) return false

        val cell = puzzle.grid[row][col]
        if (cell !is KakuroCell.PlayCell) return false

        val acrossRun = puzzle.runs.find { it.id == cell.acrossRunId && !it.isVertical }
        if (acrossRun != null) {
            for ((r, c) in acrossRun.cells) {
                if (r == row && c == col) continue
                val otherCell = _grid.value[r][c]
                if (otherCell is KakuroCell.PlayCell && otherCell.value == value) {
                    return false
                }
            }
        }

        val downRun = puzzle.runs.find { it.id == cell.downRunId && it.isVertical }
        if (downRun != null) {
            for ((r, c) in downRun.cells) {
                if (r == row && c == col) continue
                val otherCell = _grid.value[r][c]
                if (otherCell is KakuroCell.PlayCell && otherCell.value == value) {
                    return false
                }
            }
        }

        if (acrossRun != null) {
            val currentSum = acrossRun.cells.sumOf { (r, c) ->
                val gridCell = if (r == row && c == col) value else {
                    (_grid.value[r][c] as? KakuroCell.PlayCell)?.value ?: 0
                }
                gridCell
            }
            if (currentSum > acrossRun.targetSum) return false
        }

        if (downRun != null) {
            val currentSum = downRun.cells.sumOf { (r, c) ->
                val gridCell = if (r == row && c == col) value else {
                    (_grid.value[r][c] as? KakuroCell.PlayCell)?.value ?: 0
                }
                gridCell
            }
            if (currentSum > downRun.targetSum) return false
        }

        return true
    }

    private fun isPuzzleComplete(grid: List<List<KakuroCell>>, puzzle: KakuroPuzzle): Boolean {
        // Step 1: Check all play cells are filled
        for (row in grid.indices) {
            for (col in grid[row].indices) {
                val cell = grid[row][col]
                if (cell is KakuroCell.PlayCell && cell.value == 0) {
                    println("FAIL: Empty cell at ($row, $col)")
                    return false
                }
            }
        }

        // Step 2: Validate against predefined solution
        for ((pos, correctValue) in puzzle.solution) {
            val (row, col) = pos
            val cell = grid[row][col]
            if (cell is KakuroCell.PlayCell) {
                if (cell.value != correctValue) {
                    println("FAIL: Cell ($row, $col) has ${cell.value}, expected $correctValue")
                    return false
                }
            }
        }

        // Step 3: Validate run sums
        for (run in puzzle.runs) {
            val sum = run.cells.sumOf { (r, c) ->
                (grid[r][c] as? KakuroCell.PlayCell)?.value ?: 0
            }
            if (sum != run.targetSum) {
                println("FAIL: Run ${run.id} sum is $sum, expected ${run.targetSum}")
                return false
            }

            // Step 4: Check for duplicates within run
            val values = run.cells.mapNotNull { (r, c) ->
                (grid[r][c] as? KakuroCell.PlayCell)?.value?.takeIf { it > 0 }
            }
            if (values.size != values.distinct().size) {
                println("FAIL: Run ${run.id} has duplicate values: $values")
                return false
            }
        }

        println("✓✓✓ Kakuro puzzle COMPLETE!")
        return true
    }

    private fun calculateScore(timeTaken: Long): Int {
        val level = _currentLevel.value
        val baseScore = when {
            level <= 100 -> 20
            level <= 200 -> 40
            level <= 300 -> 60
            level <= 400 -> 100
            else -> 50
        }

        val timeBonus = maxOf(0, (180000 - timeTaken) / 300).toInt()
        val hintPenalty = hintsUsed * 30
        return baseScore + timeBonus - hintPenalty
    }

    override fun calculateStars(timeTakenMs: Long, hintsUsed: Int, score: Int): Int {
        return when {
            timeTakenMs < 60000 && hintsUsed == 0 && score >= 100 -> 3
            timeTakenMs < 120000 && hintsUsed <= 2 && score >= 70 -> 2
            else -> 1
        }
    }

    override fun markLevelComplete() {
        if (_currentLevel.value >= MAX_AVAILABLE_LEVELS) {
            super.markLevelComplete()
            _showMaintenanceDialog.value = true
        } else {
            super.markLevelComplete()
        }
    }

    fun dismissMaintenanceDialog() {
        _showMaintenanceDialog.value = false
    }
}
