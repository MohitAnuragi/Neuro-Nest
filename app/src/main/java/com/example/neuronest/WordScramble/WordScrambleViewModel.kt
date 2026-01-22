package com.example.neuronest.WordScramble

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
import kotlin.collections.get
import kotlin.inc
import kotlin.plus
import kotlin.text.compareTo
import kotlin.text.get
import kotlin.toString

@HiltViewModel
class WordScrambleViewModel @Inject constructor(
    private val profileRepository: ProfileRepository,
    levelRepository: LevelRepository,
    soundManager: SoundManager
) : BasePuzzleViewModel(levelRepository, profileRepository, soundManager) {

    override val puzzleType: String = "WordScramble"

    private val _currentWord = MutableStateFlow("")
    val currentWord: StateFlow<String> = _currentWord.asStateFlow()

    private val _scrambledWord = MutableStateFlow("")
    val scrambledWord: StateFlow<String> = _scrambledWord.asStateFlow()

    private val _userAnswer = MutableStateFlow("")
    val userAnswer: StateFlow<String> = _userAnswer.asStateFlow()

    private val _feedback = MutableStateFlow("")
    val feedback: StateFlow<String> = _feedback.asStateFlow()

    private val _isCorrect = MutableStateFlow<Boolean?>(null)
    val isCorrect: StateFlow<Boolean?> = _isCorrect.asStateFlow()

    private val _hint = MutableStateFlow("")
    val hint: StateFlow<String> = _hint.asStateFlow()



    private var puzzleStartTime: Long = 0

    init {
        problemsRequired = 5
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
        _userAnswer.value = ""
        _feedback.value = ""
        _isCorrect.value = null
    }

    fun setUserAnswer(answer: String) {
        if (_isLevelComplete.value) return
        _userAnswer.value = answer.uppercase()
        soundManager.playSound(SoundType.BUTTON_CLICK)
    }

    fun addLetter(letter: Char) {
        if (_isLevelComplete.value) return
        _userAnswer.value += letter.uppercaseChar()
        soundManager.playSound(SoundType.BUTTON_CLICK)
    }

    fun removeLetter() {
        if (_isLevelComplete.value || _userAnswer.value.isEmpty()) return
        _userAnswer.value = _userAnswer.value.dropLast(1)
        soundManager.playSound(SoundType.BUTTON_CLICK)
    }

    fun clearAnswer() {
        _userAnswer.value = ""
        soundManager.playSound(SoundType.BUTTON_CLICK)
    }

    fun checkAnswer() {
        if (_isLevelComplete.value) return

        val userAns = _userAnswer.value.trim().uppercase()
        if (userAns.isEmpty()) {
            _feedback.value = "Please enter an answer!"
            _isCorrect.value = false
            onIncorrectMove()
            return
        }

        val isCorrectAnswer = userAns == _currentWord.value

        if (isCorrectAnswer) {
            val timeTaken = System.currentTimeMillis() - puzzleStartTime
            val pointsEarned = calculateScore(timeTaken)

            _score.value += pointsEarned
            _feedback.value = "Correct! +$pointsEarned points"
            _isCorrect.value = true

            onProblemSolved(timeTaken, pointsEarned)

            if (!_isLevelComplete.value) {
                // Load next puzzle within same level (problemsRequired)
                loadPuzzleForLevel(_currentLevel.value)
                _userAnswer.value = ""
            }
        } else {
            _feedback.value = "Wrong! Try again"
            _isCorrect.value = false
            onIncorrectMove()
        }
    }

    fun showHint() {
        if (_isLevelComplete.value) return

        val currentAnswer = _userAnswer.value
        val correctAnswer = _currentWord.value

        // If user hasn't started typing, reveal first letter
        if (currentAnswer.isEmpty()) {
            _userAnswer.value = correctAnswer[0].toString()
            _feedback.value = "Hint: First letter revealed!"
            hintsUsed++
            soundManager.playSound(SoundType.HINT)
            return
        }

        // If user has typed something, find next correct letter to reveal
        if (currentAnswer.length < correctAnswer.length) {
            val nextPosition = currentAnswer.length
            val nextLetter = correctAnswer[nextPosition]
            _userAnswer.value = currentAnswer + nextLetter
            _feedback.value = "Hint: Next letter revealed!"
            hintsUsed++
            soundManager.playSound(SoundType.HINT)
            return
        }

        // If answer is complete length but wrong, show feedback about wrong positions
        if (currentAnswer.length == correctAnswer.length) {
            val wrongPositions = currentAnswer.indices.filter {
                currentAnswer[it] != correctAnswer[it]
            }

            if (wrongPositions.isNotEmpty()) {
                val firstWrongPos = wrongPositions.first()
                _feedback.value = "Hint: Letter at position ${firstWrongPos + 1} is wrong!"
                hintsUsed++
                soundManager.playSound(SoundType.HINT)
            } else {
                _feedback.value = "Your answer looks correct! Try submitting."
            }
        }
    }


    private fun loadPuzzleForLevel(level: Int) {
        // Use the data file to load puzzles based on the current level and progress within the level
        // For each call (problemsRequired times), we will pick entries deterministically based on level and solveCount
        val puzzleIndexBase = (level - 1) * problemsRequired
        // use the protected 'problemsSolved' from BasePuzzleViewModel (no underscore)
        val pickIndex = (puzzleIndexBase + (problemsSolved % problemsRequired)) % WordScramblePuzzleData.puzzles.size
        val puzzle = WordScramblePuzzleData.puzzles[pickIndex]

        _currentWord.value = puzzle.correctWord.uppercase()
        // If the data provided scrambledWord is empty, generate one safely
        _scrambledWord.value = if (puzzle.scrambledWord.isNotBlank()) puzzle.scrambledWord.uppercase() else scrambleWord(_currentWord.value)
        _feedback.value = ""
        _isCorrect.value = null
        puzzleStartTime = System.currentTimeMillis()
    }

    private fun scrambleWord(word: String): String {
        var scrambled = word.toList().shuffled().joinToString("")
        var attempts = 0
        // Ensure scrambled word is different from original
        while (scrambled == word && attempts < 10) {
            scrambled = word.toList().shuffled().joinToString("")
            attempts++
        }
        return scrambled
    }

    private fun getDifficultyForLevel(level: Int): String {
        return when {
            level <= 50 -> "Easy"
            level <= 100 -> "Medium"
            level <= 200 -> "Hard"
            level <= 300 -> "Expert"
            else -> "Master"
        }
    }

    private fun calculateScore(timeTaken: Long): Int {
        val baseScore = when (getDifficultyForLevel(_currentLevel.value)) {
            "Easy" -> 20
            "Medium" -> 40
            "Hard" -> 60
            "Expert" -> 80
            "Master" -> 100
            else -> 50
        }

        val timeBonus = maxOf(0, (40000 - timeTaken) / 100).toInt()
        val hintPenalty = hintsUsed * 25
        return baseScore + timeBonus - hintPenalty
    }

    override fun calculateStars(timeTakenMs: Long, hintsUsed: Int, score: Int): Int {
        val avgTimePerWord = timeTakenMs / problemsRequired
        return when {
            avgTimePerWord < 15000 && hintsUsed == 0 && score >= 600 -> 3
            avgTimePerWord < 30000 && hintsUsed <= 1 && score >= 400 -> 2
            else -> 1
        }
    }
}
