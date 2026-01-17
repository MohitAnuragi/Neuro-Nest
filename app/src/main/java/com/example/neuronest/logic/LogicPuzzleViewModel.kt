package com.example.neuronest.logic

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
import kotlin.random.Random

data class LogicPuzzle(
    val question: String,
    val answer: String,
    val options: List<String>,
    val difficulty: String,
    val hint: String = ""
)

@HiltViewModel
class LogicPuzzleViewModel @Inject constructor(
    private val profileRepository: ProfileRepository,
    levelRepository: LevelRepository,
    soundManager: SoundManager
) : BasePuzzleViewModel(levelRepository, profileRepository, soundManager) {

    override val puzzleType: String = "LogicPuzzles"

    private val _currentPuzzle = MutableStateFlow<LogicPuzzle?>(null)
    val currentPuzzle: StateFlow<LogicPuzzle?> = _currentPuzzle.asStateFlow()

    private val _userAnswer = MutableStateFlow("")
    val userAnswer: StateFlow<String> = _userAnswer.asStateFlow()

    private val _feedback = MutableStateFlow("")
    val feedback: StateFlow<String> = _feedback.asStateFlow()

    private val _isCorrect = MutableStateFlow<Boolean?>(null)
    val isCorrect: StateFlow<Boolean?> = _isCorrect.asStateFlow()

    private val _showHint = MutableStateFlow(false)
    val showHint: StateFlow<Boolean> = _showHint.asStateFlow()

    private var puzzleStartTime: Long = 0

    init {
        problemsRequired = 5 // 5 logic puzzles per level
    }

    override fun onLevelLoaded(level: Int) {
        loadPuzzleForLevel(level)
        puzzleStartTime = System.currentTimeMillis()
    }

    override fun resetLevelState() {
        super.resetLevelState()
        _userAnswer.value = ""
        _feedback.value = ""
        _isCorrect.value = null
        _showHint.value = false
    }

    private fun loadPuzzleForLevel(level: Int) {
        // Load puzzle from data based on level and current puzzle within level
        val puzzleIndexBase = (level - 1) * problemsRequired
        val pickIndex = (puzzleIndexBase + (problemsSolved % problemsRequired)) % LogicPuzzleData.puzzles.size
        val puzzle = LogicPuzzleData.puzzles[pickIndex]

        _currentPuzzle.value = puzzle
        _userAnswer.value = ""
        _feedback.value = ""
        _isCorrect.value = null
        _showHint.value = false
        puzzleStartTime = System.currentTimeMillis()
    }

    fun setUserAnswer(answer: String) {
        if (_isLevelComplete.value) return
        _userAnswer.value = answer.uppercase()
        soundManager.playSound(SoundType.BUTTON_CLICK)
    }

    fun selectOption(option: String) {
        if (_isLevelComplete.value) return
        _userAnswer.value = option.uppercase()
        soundManager.playSound(SoundType.BUTTON_CLICK)
    }

    fun checkAnswer() {
        if (_isLevelComplete.value) return

        val puzzle = _currentPuzzle.value ?: return
        val userAns = _userAnswer.value.trim().uppercase()

        if (userAns.isEmpty()) {
            _feedback.value = "Please enter or select an answer!"
            _isCorrect.value = false
            onIncorrectMove()
            return
        }

        val isCorrectAnswer = userAns == puzzle.answer.uppercase()

        if (isCorrectAnswer) {
            val timeTaken = System.currentTimeMillis() - puzzleStartTime
            val pointsEarned = calculateScore(timeTaken)

            _feedback.value = "Correct! +$pointsEarned points"
            _isCorrect.value = true

            onProblemSolved(timeTaken, pointsEarned)

            // Generate next puzzle if level not complete
            if (!_isLevelComplete.value) {
                loadPuzzleForLevel(_currentLevel.value)
            }
        } else {
            _feedback.value = "Wrong! Think logically"
            _isCorrect.value = false
            onIncorrectMove()
        }
    }

    fun skipPuzzle() {
        if (_isLevelComplete.value) return

        val puzzle = _currentPuzzle.value ?: return
        _feedback.value = "Skipped! Answer was ${puzzle.answer}"
        _isCorrect.value = null
        soundManager.playSound(SoundType.TRANSITION)

        loadPuzzleForLevel(_currentLevel.value)
    }

    fun toggleHint() {
        if (_isLevelComplete.value) return

        if (!_showHint.value) {
            onHintUsed()
        }
        _showHint.value = !_showHint.value
    }

    private fun calculateScore(timeTaken: Long): Int {
        val level = _currentLevel.value
        val baseScore = when {
            level <= 100 -> 100
            level <= 200 -> 150
            level <= 300 -> 200
            level <= 400 -> 250
            else -> 300
        }

        val timeBonus = maxOf(0, (50000 - timeTaken) / 200).toInt()
        val hintPenalty = if (_showHint.value) 25 else 0
        return baseScore + timeBonus - hintPenalty - (hintsUsed * 15)
    }

    override fun calculateStars(timeTakenMs: Long, hintsUsed: Int, score: Int): Int {
        val avgTimePerPuzzle = timeTakenMs / problemsRequired
        return when {
            avgTimePerPuzzle < 25000 && hintsUsed == 0 && score >= 600 -> 3
            avgTimePerPuzzle < 45000 && hintsUsed <= 2 && score >= 400 -> 2
            else -> 1
        }
    }
}

