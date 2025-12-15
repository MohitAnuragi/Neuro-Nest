package com.example.neuronest.Sequence

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

@HiltViewModel
class SequenceGeneratorViewModel @Inject constructor(
    private val profileRepository: ProfileRepository,
    levelRepository: LevelRepository,
    soundManager: SoundManager
) : BasePuzzleViewModel(levelRepository, profileRepository, soundManager) {

    override val puzzleType: String = "SequenceGenerator"

    private val _sequenceNumbers = MutableStateFlow<List<Int>>(emptyList())
    val sequenceNumbers: StateFlow<List<Int>> = _sequenceNumbers.asStateFlow()

    private val _userAnswer = MutableStateFlow("")
    val userAnswer: StateFlow<String> = _userAnswer.asStateFlow()

    private val _feedback = MutableStateFlow("")
    val feedback: StateFlow<String> = _feedback.asStateFlow()

    private val _isCorrect = MutableStateFlow<Boolean?>(null)
    val isCorrect: StateFlow<Boolean?> = _isCorrect.asStateFlow()

    private val _hint = MutableStateFlow("")
    val hint: StateFlow<String> = _hint.asStateFlow()

    private var _correctAnswer = 0
    private var _sequenceType = ""
    private var puzzleStartTime: Long = 0

    init {
        problemsRequired = 5 // 5 sequences per level
    }

    override fun onLevelLoaded(level: Int) {
        generateNewSequence()
        puzzleStartTime = System.currentTimeMillis()
    }

    override fun resetLevelState() {
        super.resetLevelState()
        _userAnswer.value = ""
        _feedback.value = ""
        _isCorrect.value = null
        _hint.value = ""
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

            if (!_isLevelComplete.value) {
                generateNewSequence()
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

        generateNewSequence()
        _userAnswer.value = ""
    }

    fun showHint() {
        if (_isLevelComplete.value) return

        onHintUsed()
        _hint.value = "Hint: This is a $_sequenceType sequence"
    }

    fun generateNewSequence() {
        val level = _currentLevel.value
        val sequenceType = getSequenceTypeForLevel(level)
        val (sequence, answer, typeName) = generateSequenceByType(sequenceType, level)

        _sequenceNumbers.value = sequence
        _correctAnswer = answer
        _sequenceType = typeName
        _feedback.value = ""
        _isCorrect.value = null
        _hint.value = ""
        puzzleStartTime = System.currentTimeMillis()
    }

    private fun generateSequenceByType(type: SequenceType, level: Int): Triple<List<Int>, Int, String> {
        val sequenceLength = when {
            level <= 100 -> 4
            level <= 200 -> 5
            level <= 300 -> 6
            else -> 7
        }

        return when (type) {
            SequenceType.ARITHMETIC -> {
                val start = Random.nextInt(1, 20)
                val diff = Random.nextInt(1, if (level <= 100) 5 else 10)
                val sequence = (0 until sequenceLength).map { start + it * diff }
                val nextValue = start + sequenceLength * diff
                Triple(sequence, nextValue, "Arithmetic (add $diff each time)")
            }
            SequenceType.GEOMETRIC -> {
                val start = Random.nextInt(2, 5)
                val ratio = Random.nextInt(2, if (level <= 200) 3 else 4)
                val sequence = (0 until sequenceLength).map { (start * Math.pow(ratio.toDouble(), it.toDouble())).toInt() }
                val nextValue = (start * Math.pow(ratio.toDouble(), sequenceLength.toDouble())).toInt()
                Triple(sequence, nextValue, "Geometric (multiply by $ratio)")
            }
            SequenceType.FIBONACCI -> {
                val fib = mutableListOf(1, 1)
                while (fib.size < sequenceLength + 1) {
                    fib.add(fib[fib.size - 1] + fib[fib.size - 2])
                }
                val sequence = fib.take(sequenceLength)
                val nextValue = fib[sequenceLength]
                Triple(sequence, nextValue, "Fibonacci (sum of previous two)")
            }
            SequenceType.SQUARE -> {
                val start = Random.nextInt(1, 5)
                val sequence = (0 until sequenceLength).map { val n = start + it; n * n }
                val nextNum = start + sequenceLength
                val nextValue = nextNum * nextNum
                Triple(sequence, nextValue, "Square (n²)")
            }
            SequenceType.CUBE -> {
                val start = Random.nextInt(1, 4)
                val sequence = (0 until sequenceLength).map { val n = start + it; n * n * n }
                val nextNum = start + sequenceLength
                val nextValue = nextNum * nextNum * nextNum
                Triple(sequence, nextValue, "Cube (n³)")
            }
            SequenceType.ALTERNATING -> {
                val start = Random.nextInt(1, 10)
                val diff1 = Random.nextInt(2, 8)
                val diff2 = Random.nextInt(2, 8)
                val sequence = (0 until sequenceLength).map { i ->
                    if (i % 2 == 0) start + (i / 2) * diff1
                    else start + ((i - 1) / 2) * diff1 + diff2
                }
                val nextValue = if (sequenceLength % 2 == 0) {
                    start + (sequenceLength / 2) * diff1
                } else {
                    start + ((sequenceLength - 1) / 2) * diff1 + diff2
                }
                Triple(sequence, nextValue, "Alternating pattern")
            }
            SequenceType.DOUBLE_ADD -> {
                val start = Random.nextInt(1, 10)
                val increment = Random.nextInt(1, 5)
                val sequence = mutableListOf(start)
                var current = start
                var currentIncrement = increment
                while (sequence.size < sequenceLength) {
                    current += currentIncrement
                    sequence.add(current)
                    currentIncrement += increment
                }
                val nextValue = current + (currentIncrement + increment)
                Triple(sequence, nextValue, "Increasing difference (+$increment each step)")
            }
        }
    }

    private fun getSequenceTypeForLevel(level: Int): SequenceType {
        return when {
            level <= 50 -> listOf(SequenceType.ARITHMETIC).random()
            level <= 100 -> listOf(SequenceType.ARITHMETIC, SequenceType.GEOMETRIC).random()
            level <= 200 -> listOf(SequenceType.ARITHMETIC, SequenceType.GEOMETRIC, SequenceType.SQUARE).random()
            level <= 300 -> listOf(SequenceType.ARITHMETIC, SequenceType.GEOMETRIC, SequenceType.SQUARE, SequenceType.FIBONACCI).random()
            level <= 400 -> listOf(SequenceType.ARITHMETIC, SequenceType.GEOMETRIC, SequenceType.SQUARE, SequenceType.FIBONACCI, SequenceType.CUBE, SequenceType.ALTERNATING).random()
            else -> SequenceType.entries.random()
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

        val timeBonus = maxOf(0, (40000 - timeTaken) / 100).toInt()
        val hintPenalty = hintsUsed * 25
        return baseScore + timeBonus - hintPenalty
    }

    override fun calculateStars(timeTakenMs: Long, hintsUsed: Int, score: Int): Int {
        val avgTimePerProblem = timeTakenMs / problemsRequired
        return when {
            avgTimePerProblem < 15000 && hintsUsed == 0 && score >= 550 -> 3
            avgTimePerProblem < 30000 && hintsUsed <= 1 && score >= 350 -> 2
            else -> 1
        }
    }

    fun resetIsCorrectFlag() {
        _isCorrect.value = null
    }

    enum class SequenceType {
        ARITHMETIC,
        GEOMETRIC,
        FIBONACCI,
        SQUARE,
        CUBE,
        ALTERNATING,
        DOUBLE_ADD
    }
}

