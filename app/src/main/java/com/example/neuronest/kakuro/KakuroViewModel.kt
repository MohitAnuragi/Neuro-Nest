package com.example.neuronest.kakuro

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

    private var puzzleStartTime: Long = 0

    init {
        problemsRequired = 3 // 3 Kakuro puzzles per level like other puzzles
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
        // Load puzzle from data based on level and current puzzle within level
        val puzzleIndexBase = (level - 1) * problemsRequired
        val pickIndex = (puzzleIndexBase + (problemsSolved % problemsRequired)) % KakuroPuzzleData.puzzles.size
        val puzzle = KakuroPuzzleData.puzzles[pickIndex]

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

        // Validate input
        val puzzle = _currentPuzzle.value ?: return
        val isValid = validateMove(row, col, value, puzzle)

        val newGrid = _grid.value.map { it.toMutableList() }.toMutableList()

        if (isValid) {
            newGrid[row][col] = cell.copy(value = value, isError = false)
            _grid.value = newGrid.map { it.toList() }
            soundManager.playSound(SoundType.CORRECT_MOVE)
            _feedback.value = "Good move!"
            _isCorrect.value = true

            // Check if puzzle is complete
            if (isPuzzleComplete(newGrid.map { it.toList() }, puzzle)) {
                val timeTaken = System.currentTimeMillis() - puzzleStartTime
                val pointsEarned = calculateScore(timeTaken)
                _feedback.value = "Kakuro Complete! +$pointsEarned points"

                onProblemSolved(timeTaken, pointsEarned)

                // Generate next puzzle if level not complete
                if (!_isLevelComplete.value) {
                    loadPuzzleForLevel(_currentLevel.value)
                }
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
            _feedback.value = "Select a cell first!"
            return
        }

        onHintUsed()
        val puzzle = _currentPuzzle.value ?: return
        val correctValue = puzzle.solution[selected] ?: 0

        val (row, col) = selected
        val cell = _grid.value[row][col]
        if (cell !is KakuroCell.PlayCell) return

        val newGrid = _grid.value.map { it.toMutableList() }.toMutableList()
        newGrid[row][col] = cell.copy(value = correctValue, isError = false)
        _grid.value = newGrid.map { it.toList() }

        soundManager.playSound(SoundType.HINT)
        _feedback.value = "Hint: The answer is $correctValue"

        // Check if puzzle is now complete
        if (isPuzzleComplete(newGrid.map { it.toList() }, puzzle)) {
            val timeTaken = System.currentTimeMillis() - puzzleStartTime
            val pointsEarned = calculateScore(timeTaken)
            _feedback.value = "Kakuro Complete! +$pointsEarned points"
            onProblemSolved(timeTaken, pointsEarned)

            if (!_isLevelComplete.value) {
                loadPuzzleForLevel(_currentLevel.value)
            }
        }
    }

    fun skipPuzzle() {
        if (_isLevelComplete.value) return

        _feedback.value = "Puzzle skipped!"
        soundManager.playSound(SoundType.TRANSITION)

        onProblemSolved(0L, 0) // Skip gives no points

        if (!_isLevelComplete.value) {
            loadPuzzleForLevel(_currentLevel.value)
        }
    }

    fun checkPuzzle() {
        if (_isLevelComplete.value) return

        val puzzle = _currentPuzzle.value ?: return
        val grid = _grid.value

        if (isPuzzleComplete(grid, puzzle)) {
            val timeTaken = System.currentTimeMillis() - puzzleStartTime
            val pointsEarned = calculateScore(timeTaken)
            _feedback.value = "Kakuro Complete! +$pointsEarned points"
            onProblemSolved(timeTaken, pointsEarned)

            if (!_isLevelComplete.value) {
                loadPuzzleForLevel(_currentLevel.value)
            }
        } else {
            _feedback.value = "Puzzle not complete or has errors!"
            soundManager.playSound(SoundType.INCORRECT_MOVE)
        }
    }

    private fun validateMove(row: Int, col: Int, value: Int, puzzle: KakuroPuzzle): Boolean {
        if (value < 1 || value > 9) return false

        val cell = puzzle.grid[row][col]
        if (cell !is KakuroCell.PlayCell) return false

        // Check for duplicates in horizontal run
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

        // Check for duplicates in vertical run
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

        // Check partial sums don't exceed target
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
        // Check all play cells are filled
        for (row in grid) {
            for (cell in row) {
                if (cell is KakuroCell.PlayCell && cell.value == 0) {
                    return false
                }
            }
        }

        // Check all runs sum correctly
        for (run in puzzle.runs) {
            val sum = run.cells.sumOf { (r, c) ->
                (grid[r][c] as? KakuroCell.PlayCell)?.value ?: 0
            }
            if (sum != run.targetSum) return false

            // Check no duplicates
            val values = run.cells.mapNotNull { (r, c) ->
                (grid[r][c] as? KakuroCell.PlayCell)?.value?.takeIf { it > 0 }
            }
            if (values.size != values.distinct().size) return false
        }

        return true
    }

    private fun calculateScore(timeTaken: Long): Int {
        val level = _currentLevel.value
        val baseScore = when {
            level <= 100 -> 150
            level <= 200 -> 200
            level <= 300 -> 250
            level <= 400 -> 300
            else -> 350
        }

        val timeBonus = maxOf(0, (180000 - timeTaken) / 300).toInt()
        val hintPenalty = hintsUsed * 30
        return baseScore + timeBonus - hintPenalty
    }

    override fun calculateStars(timeTakenMs: Long, hintsUsed: Int, score: Int): Int {
        val avgTimePerPuzzle = timeTakenMs / problemsRequired
        return when {
            avgTimePerPuzzle < 60000 && hintsUsed == 0 && score >= 500 -> 3
            avgTimePerPuzzle < 120000 && hintsUsed <= 2 && score >= 350 -> 2
            else -> 1
        }
    }
}

