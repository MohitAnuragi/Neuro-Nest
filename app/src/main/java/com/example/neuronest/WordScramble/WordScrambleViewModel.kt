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

    private var puzzleStartTime: Long = 0

    init {
        problemsRequired = 5 // 5 words per level
    }

    override fun onLevelLoaded(level: Int) {
        generateNewWord()
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
                generateNewWord()
                _userAnswer.value = ""
            }
        } else {
            _feedback.value = "Wrong! Try again"
            _isCorrect.value = false
            onIncorrectMove()
        }
    }

    fun skipWord() {
        if (_isLevelComplete.value) return

        _feedback.value = "Skipped! Word was ${_currentWord.value}"
        _isCorrect.value = null
        soundManager.playSound(SoundType.TRANSITION)

        generateNewWord()
        _userAnswer.value = ""
    }

    fun generateNewWord() {
        val level = _currentLevel.value
        val wordList = getWordsForLevel(level)
        _currentWord.value = wordList.random()
        _scrambledWord.value = scrambleWord(_currentWord.value)
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

    private fun getWordsForLevel(level: Int): List<String> {
        return when {
            level <= 50 -> easyWords
            level <= 100 -> mediumWords
            level <= 200 -> hardWords
            level <= 300 -> expertWords
            else -> masterWords
        }
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
        val avgTimePerWord = timeTakenMs / problemsRequired
        return when {
            avgTimePerWord < 15000 && hintsUsed == 0 && score >= 600 -> 3
            avgTimePerWord < 30000 && hintsUsed <= 1 && score >= 400 -> 2
            else -> 1
        }
    }

    fun resetIsCorrectFlag() {
        _isCorrect.value = null
    }

    // Word banks categorized by difficulty
    private val easyWords = listOf(
        "CAT", "DOG", "FISH", "BIRD", "TREE", "SUN", "MOON", "STAR", "BOOK", "DOOR",
        "BALL", "CAKE", "MILK", "HOME", "RAIN", "SNOW", "WIND", "FIRE", "JUMP", "PLAY",
        "HAND", "FOOT", "HEAD", "EYES", "NOSE", "EARS", "HAIR", "BABY", "MAMA", "PAPA",
        "ROSE", "LEAF", "SEED", "BOAT", "KITE", "LOCK", "KEYS", "SALT", "MILK", "EGGS"
    )

    private val mediumWords = listOf(
        "APPLE", "BREAD", "CHAIR", "DANCE", "EAGLE", "FRUIT", "GRAPE", "HAPPY", "JUNGLE", "KOALA",
        "LEMON", "MAGIC", "NIGHT", "OCEAN", "PANDA", "QUEEN", "RIVER", "SMILE", "TIGER", "UNIQUE",
        "VIOLIN", "WATER", "YELLOW", "ZEBRA", "BRIGHT", "CLOUD", "DRAGON", "FOREST", "GARDEN", "HORSE",
        "ISLAND", "JACKET", "KITTEN", "LAPTOP", "MONKEY", "NUMBER", "ORANGE", "PLANET", "RABBIT", "STORM"
    )

    private val hardWords = listOf(
        "ADVENTURE", "BEAUTIFUL", "CHALLENGE", "DANGEROUS", "EDUCATION", "FANTASTIC", "GEOGRAPHY", "HAPPINESS",
        "IMPORTANT", "KNOWLEDGE", "LIGHTNING", "MOUNTAINS", "NEWSPAPER", "ORGANIZED", "PRESIDENT", "QUESTION",
        "RECOGNIZE", "SOMETHING", "TRANSPORT", "UNDERSTANDING", "WONDERFUL", "BUTTERFLY", "CELEBRATE", "DIFFERENT",
        "EMERGENCY", "FURNITURE", "GUARDIANS", "HURRICANE", "INTERFACE", "JELLYFISH", "KANGAROO", "LANDSCAPE"
    )

    private val expertWords = listOf(
        "ACCOMPLISH", "BACKGROUND", "CALCULABLE", "DICTIONARY", "EXCITEMENT", "FASCINATING", "GOVERNMENT",
        "HAMBURGERS", "INCREDIBLE", "JOURNALISM", "KINDERGARTEN", "LABORATORY", "MAGNIFICENT", "NEGOTIATE",
        "OCCUPATION", "PERSONALITY", "QUICKSILVER", "RESTAURANT", "STRAWBERRY", "TEMPERATURE", "UNDERSTAND",
        "VOCABULARY", "WATERMELON", "XYLOPHONE", "YESTERDAY", "ZOOLOGICAL", "ATMOSPHERE", "BASKETBALL"
    )

    private val masterWords = listOf(
        "ACCOMPLISHMENT", "BREAKTHROUGH", "CATASTROPHIC", "DETERMINATION", "EXTRAORDINARY", "FUNDAMENTALLY",
        "GROUNDBREAKING", "HUMANITARIAN", "INFRASTRUCTURE", "KINDERGARTEN", "LABYRINTHINE", "MANIFESTATION",
        "NEVERTHELESS", "OPTIMIZATION", "PHILOSOPHICAL", "QUINTESSENTIAL", "REVOLUTIONARY", "SOPHISTICATED",
        "TRANSFORMATION", "UNCONDITIONAL", "VISUALIZATION", "ACKNOWLEDGMENT", "BIODEGRADABLE", "CIRCUMSTANTIAL"
    )
}

