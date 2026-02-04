package com.neuronest.neuronest.Sequence

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
    private var _hintText = ""
    private var puzzleStartTime: Long = 0

    init {
        problemsRequired = 5 // 5 sequences per level
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
        _hint.value = ""
    }

    fun setUserAnswer(answer: String) {
        if (_isLevelComplete.value) return
        _userAnswer.value = answer
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
                loadPuzzleForLevel(_currentLevel.value)
                _userAnswer.value = ""
            }
        } else {
            _feedback.value = "Wrong! Try again"
            _isCorrect.value = false
            onIncorrectMove()
        }
    }
    fun playSoundEffect(soundType: SoundType) {
        soundManager.playSound(soundType)
    }
    fun skipProblem() {
        if (_isLevelComplete.value) return

        _feedback.value = "Skipped! Answer was $_correctAnswer"
        _isCorrect.value = null
        soundManager.playSound(SoundType.TRANSITION)

        loadPuzzleForLevel(_currentLevel.value)
        _userAnswer.value = ""
    }

    fun showHint() {
        if (_isLevelComplete.value) return

        onHintUsed()
        _hint.value = "Hint: $_hintText"
    }

    private fun loadPuzzleForLevel(level: Int) {
        // Use the data file to load puzzles based on the current level and progress within the level
        val puzzleIndexBase = (level - 1) * problemsRequired
        val pickIndex = (puzzleIndexBase + (problemsSolved % problemsRequired)) % SequencePuzzleData.puzzles.size
        val puzzle = SequencePuzzleData.puzzles[pickIndex]

        _sequenceNumbers.value = puzzle.sequence
        _correctAnswer = puzzle.correctAnswer
        _hintText = puzzle.hint
        _feedback.value = ""
        _isCorrect.value = null
        _hint.value = ""
        puzzleStartTime = System.currentTimeMillis()
    }


    private fun calculateScore(timeTaken: Long): Int {
        val baseScore = when (getDifficultyForLevel(_currentLevel.value)) {
            "Easy" -> 10
            "Medium" -> 20
            "Hard" -> 40
            "Expert" -> 60
            "Master" -> 80
            else -> 50
        }

        val timeBonus = maxOf(0, (40000 - timeTaken) / 100).toInt()
        val hintPenalty = hintsUsed * 25
        return baseScore + timeBonus - hintPenalty
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
}

