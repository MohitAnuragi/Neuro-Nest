package com.example.neuronest.Arithematic

import com.example.neuronest.profile.ProfileRepository
import com.example.neuronest.puzzlelevels.BasePuzzleViewModel
import com.example.neuronest.puzzlelevels.LevelRepository
import com.example.neuronest.sound.SoundManager
import com.example.neuronest.sound.SoundType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlin.math.roundToInt
import kotlin.random.Random
import javax.inject.Inject

@HiltViewModel
class ArithmeticViewModel @Inject constructor(
    private val profileRepository: ProfileRepository,
    levelRepository: LevelRepository,
    soundManager: SoundManager
) : BasePuzzleViewModel(levelRepository, profileRepository, soundManager) {

    override val puzzleType: String = "Arithmetic"

    private val _currentProblem = MutableStateFlow("1 + 1 = ?")
    val currentProblem: StateFlow<String> = _currentProblem.asStateFlow()

    private val _userAnswer = MutableStateFlow("")
    val userAnswer: StateFlow<String> = _userAnswer.asStateFlow()

    private val _feedback = MutableStateFlow("")
    val feedback: StateFlow<String> = _feedback.asStateFlow()

    private val _isCorrect = MutableStateFlow<Boolean?>(null)
    val isCorrect: StateFlow<Boolean?> = _isCorrect.asStateFlow()

    private var _correctAnswer = 2
    private var puzzleStartTime: Long = 0

    init {
        problemsRequired = 5 // 5 problems per level for arithmetic
    }

    override fun onLevelLoaded(level: Int) {
        generateNewProblem()
        puzzleStartTime = System.currentTimeMillis()
    }

    override fun resetLevelState() {
        super.resetLevelState()
        _userAnswer.value = ""
        _feedback.value = ""
        _isCorrect.value = null
    }

    fun setUserAnswer(answer: String) {
        if (_isLevelComplete.value) return

        _userAnswer.value = if (answer == "BACK") {
            _userAnswer.value.dropLast(1)
        } else {
            _userAnswer.value + answer
        }
        soundManager.playSound(SoundType.BUTTON_CLICK)
    }

    fun checkAnswer() {
        if (_isLevelComplete.value) return

        val userAns = _userAnswer.value.toIntOrNull() ?: run {
            _feedback.value = "Please enter a valid number!"
            _isCorrect.value = false
            onIncorrectMove()
            return
        }

        val isCorrectAnswer = userAns == _correctAnswer

        if (isCorrectAnswer) {
            val timeTaken = System.currentTimeMillis() - puzzleStartTime
            val pointsEarned = calculateScore(timeTaken)

            _score.value += pointsEarned
            _feedback.value = "Correct! +$pointsEarned points"
            _isCorrect.value = true

            onProblemSolved(timeTaken, pointsEarned)

            // Generate next problem after a short delay (handled in UI)
            if (!_isLevelComplete.value) {
                generateNewProblem()
                _userAnswer.value = ""
            }
        } else {
            _feedback.value = "Wrong! Try again"
            _isCorrect.value = false
            onIncorrectMove()
        }
    }

    fun skipProblem() {
        if (_isLevelComplete.value) return

        _feedback.value = "Skipped! Answer was $_correctAnswer"
        _isCorrect.value = null
        soundManager.playSound(SoundType.TRANSITION)

        generateNewProblem()
        _userAnswer.value = ""
    }

    fun generateNewProblem() {
        val level = _currentLevel.value
        val (minNum, maxNum) = getNumberRangeForLevel(level)

        val num1 = Random.nextInt(minNum, maxNum)
        val operator = getOperatorsForLevel(level).random()

        val num2 = when (operator) {
            "÷" -> {
                var tempNum2 = Random.nextInt(1, maxNum / 2)
                while (tempNum2 == 0 || num1 % tempNum2 != 0) {
                    tempNum2 = Random.nextInt(1, maxNum / 2)
                }
                tempNum2
            }
            else -> Random.nextInt(1, maxNum)
        }

        _correctAnswer = when (operator) {
            "+" -> num1 + num2
            "-" -> num1 - num2
            "×" -> num1 * num2
            "÷" -> (num1.toDouble() / num2).roundToInt()
            else -> 0
        }

        _currentProblem.value = "$num1 $operator $num2 = ?"
        _feedback.value = ""
        _isCorrect.value = null
        puzzleStartTime = System.currentTimeMillis()
    }

    private fun getNumberRangeForLevel(level: Int): Pair<Int, Int> {
        return when {
            level <= 100 -> Pair(1, 50)
            level <= 200 -> Pair(10, 100)
            level <= 300 -> Pair(50, 200)
            level <= 400 -> Pair(100, 500)
            else -> Pair(200, 1000)
        }
    }

    private fun getOperatorsForLevel(level: Int): List<String> {
        return when {
            level <= 50 -> listOf("+", "-")
            level <= 100 -> listOf("+", "-", "×")
            else -> listOf("+", "-", "×", "÷")
        }
    }

    private fun getDifficultyForLevel(level: Int): String {
        return when {
            level <= 100 -> "Easy"
            level <= 200 -> "Medium"
            level <= 300 -> "Hard"
            level <= 400 -> "Expert"
            else -> "Master"
        }
    }

    private fun calculateScore(timeTaken: Long): Int {
        val baseScore = when (getDifficultyForLevel(_currentLevel.value)) {
            "Easy" -> 100
            "Medium" -> 150
            "Hard" -> 200
            "Expert" -> 250
            "Master" -> 300
            else -> 100
        }

        val timeBonus = maxOf(0, (30000 - timeTaken) / 100).toInt()
        val hintPenalty = hintsUsed * 25
        return baseScore + timeBonus - hintPenalty
    }

    override fun calculateStars(timeTakenMs: Long, hintsUsed: Int, score: Int): Int {
        val avgTimePerProblem = timeTakenMs / problemsRequired
        return when {
            avgTimePerProblem < 10000 && hintsUsed == 0 && score >= 500 -> 3
            avgTimePerProblem < 20000 && hintsUsed <= 1 && score >= 300 -> 2
            else -> 1
        }
    }

    fun resetIsCorrectFlag() {
        _isCorrect.value = null
    }
}

