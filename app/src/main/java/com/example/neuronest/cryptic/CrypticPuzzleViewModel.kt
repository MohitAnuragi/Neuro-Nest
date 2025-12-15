package com.example.neuronest.cryptic

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

data class CrypticRiddle(
    val question: String,
    val answer: String,
    val options: List<String>,
    val hint: String = ""
)

@HiltViewModel
class CrypticPuzzleViewModel @Inject constructor(
    private val profileRepository: ProfileRepository,
    levelRepository: LevelRepository,
    soundManager: SoundManager
) : BasePuzzleViewModel(levelRepository, profileRepository, soundManager) {

    override val puzzleType: String = "CrypticPuzzle"

    private val _currentRiddle = MutableStateFlow<CrypticRiddle?>(null)
    val currentRiddle: StateFlow<CrypticRiddle?> = _currentRiddle.asStateFlow()

    private val _userAnswer = MutableStateFlow("")
    val userAnswer: StateFlow<String> = _userAnswer.asStateFlow()

    private val _feedback = MutableStateFlow("")
    val feedback: StateFlow<String> = _feedback.asStateFlow()

    private val _isCorrect = MutableStateFlow<Boolean?>(null)
    val isCorrect: StateFlow<Boolean?> = _isCorrect.asStateFlow()

    private val _showHint = MutableStateFlow(false)
    val showHint: StateFlow<Boolean> = _showHint.asStateFlow()

    private var puzzleStartTime: Long = 0
    private val usedRiddleIndices = mutableSetOf<Int>()

    init {
        problemsRequired = 5 // 5 riddles per level like Arithmetic
    }

    override fun onLevelLoaded(level: Int) {
        usedRiddleIndices.clear() // Clear used riddles for new level
        generateNewRiddle(level)
        puzzleStartTime = System.currentTimeMillis()
    }

    override fun resetLevelState() {
        super.resetLevelState()
        usedRiddleIndices.clear() // Clear when replaying
        _userAnswer.value = ""
        _feedback.value = ""
        _isCorrect.value = null
        _showHint.value = false
    }

    fun generateNewRiddle(level: Int) {
        val riddles = getRiddlesForLevel(level)

        // Find unused riddles
        val availableIndices = riddles.indices.filter { it !in usedRiddleIndices }

        // If all riddles used, reset for variety
        val indexToUse = if (availableIndices.isEmpty()) {
            usedRiddleIndices.clear()
            riddles.indices.random()
        } else {
            availableIndices.random()
        }

        usedRiddleIndices.add(indexToUse)
        val riddle = riddles[indexToUse]

        _currentRiddle.value = riddle
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

        val riddle = _currentRiddle.value ?: return
        val userAns = _userAnswer.value.trim().uppercase()

        if (userAns.isEmpty()) {
            _feedback.value = "Please enter or select an answer!"
            _isCorrect.value = false
            onIncorrectMove()
            return
        }

        val isCorrectAnswer = userAns == riddle.answer.uppercase()

        if (isCorrectAnswer) {
            val timeTaken = System.currentTimeMillis() - puzzleStartTime
            val pointsEarned = calculateScore(timeTaken)

            _feedback.value = "Correct! +$pointsEarned points"
            _isCorrect.value = true

            onProblemSolved(timeTaken, pointsEarned)

            // Generate next riddle if level not complete
            if (!_isLevelComplete.value) {
                generateNewRiddle(_currentLevel.value)
            }
        } else {
            _feedback.value = "Wrong! Try again or use hint"
            _isCorrect.value = false
            onIncorrectMove()
        }
    }

    fun skipRiddle() {
        if (_isLevelComplete.value) return

        val riddle = _currentRiddle.value ?: return
        _feedback.value = "Skipped! Answer was ${riddle.answer}"
        _isCorrect.value = null
        soundManager.playSound(SoundType.TRANSITION)

        generateNewRiddle(_currentLevel.value)
    }

    fun toggleHint() {
        if (_isLevelComplete.value) return

        if (!_showHint.value) {
            onHintUsed()
        }
        _showHint.value = !_showHint.value
    }

    private fun getRiddlesForLevel(level: Int): List<CrypticRiddle> {
        return when {
            level <= 100 -> easyRiddles
            level <= 200 -> mediumRiddles
            level <= 300 -> hardRiddles
            level <= 400 -> expertRiddles
            else -> masterRiddles
        }
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

        val timeBonus = maxOf(0, (45000 - timeTaken) / 150).toInt()
        val hintPenalty = if (_showHint.value) 25 else 0
        return baseScore + timeBonus - hintPenalty - (hintsUsed * 15)
    }

    override fun calculateStars(timeTakenMs: Long, hintsUsed: Int, score: Int): Int {
        val avgTimePerRiddle = timeTakenMs / problemsRequired
        return when {
            avgTimePerRiddle < 20000 && hintsUsed == 0 && score >= 600 -> 3
            avgTimePerRiddle < 40000 && hintsUsed <= 2 && score >= 400 -> 2
            else -> 1
        }
    }

    // Riddle Banks
    private val easyRiddles = listOf(
        CrypticRiddle("I have cities, but no houses. I have mountains, but no trees. I have water, but no fish. What am I?", "MAP", listOf("MAP", "GLOBE", "DREAM"), "Think about representations"),
        CrypticRiddle("What has keys but can't open locks?", "PIANO", listOf("PIANO", "DOOR", "COMPUTER"), "Musical instrument"),
        CrypticRiddle("What has a head, a tail, is brown, and has no legs?", "PENNY", listOf("PENNY", "SNAKE", "COIN"), "Currency"),
        CrypticRiddle("What can travel around the world while staying in a corner?", "STAMP", listOf("STAMP", "LETTER", "SOUND"), "Used for mail"),
        CrypticRiddle("What has hands but can't clap?", "CLOCK", listOf("CLOCK", "WATCH", "STATUE"), "Tells time")
    )

    private val mediumRiddles = listOf(
        CrypticRiddle("I speak without a mouth and hear without ears. I have no body, but I come alive with wind. What am I?", "ECHO", listOf("ECHO", "WHISPER", "SHADOW"), "Sound reflection"),
        CrypticRiddle("The more you take, the more you leave behind. What am I?", "FOOTSTEPS", listOf("FOOTSTEPS", "PHOTOGRAPHS", "IMPRESSIONS"), "Walking traces"),
        CrypticRiddle("What can fill a room but takes up no space?", "LIGHT", listOf("LIGHT", "AIR", "SOUND"), "Illumination"),
        CrypticRiddle("What goes up but never comes down?", "AGE", listOf("AGE", "TIME", "BALLOON"), "Growing older"),
        CrypticRiddle("What has a neck but no head?", "BOTTLE", listOf("BOTTLE", "SHIRT", "GIRAFFE"), "Container")
    )

    private val hardRiddles = listOf(
        CrypticRiddle("I am not alive, but I grow; I don't have lungs, but I need air; I don't have a mouth, but water kills me. What am I?", "FIRE", listOf("FIRE", "PLANT", "CLOUD"), "Element of combustion"),
        CrypticRiddle("What can run but never walks, has a mouth but never talks, has a head but never weeps, has a bed but never sleeps?", "RIVER", listOf("RIVER", "CLOCK", "SNAKE"), "Water body"),
        CrypticRiddle("I have branches, but no fruit, trunk or leaves. What am I?", "BANK", listOf("BANK", "TREE", "COMPANY"), "Financial institution"),
        CrypticRiddle("What is seen in the middle of March and April that can't be seen at the beginning or end of either month?", "R", listOf("R", "SPRING", "RAIN"), "Letter in the word"),
        CrypticRiddle("What disappears as soon as you say its name?", "SILENCE", listOf("SILENCE", "SECRET", "DARKNESS"), "Absence of sound")
    )

    private val expertRiddles = listOf(
        CrypticRiddle("Forward I am heavy, but backward I am not. What am I?", "TON", listOf("TON", "WEIGHT", "NOT"), "Unit of measurement"),
        CrypticRiddle("I have cities, but no people live in them. I have forests, but no trees grow in them. I have water, but no fish swim in it. What am I?", "MAP", listOf("MAP", "BOOK", "COMPUTER"), "Navigation tool"),
        CrypticRiddle("What word becomes shorter when you add two letters to it?", "SHORT", listOf("SHORT", "LONG", "WORD"), "Add 'ER' to it"),
        CrypticRiddle("I am always in front of you but can't be seen. What am I?", "FUTURE", listOf("FUTURE", "AIR", "DESTINY"), "Time ahead"),
        CrypticRiddle("What has many teeth but cannot bite?", "COMB", listOf("COMB", "SAW", "ZIPPER"), "Hair tool")
    )

    private val masterRiddles = listOf(
        CrypticRiddle("I am taken from a mine and shut up in a wooden case, from which I am never released, and yet I am used by almost everybody. What am I?", "PENCIL LEAD", listOf("PENCIL LEAD", "COAL", "DIAMOND"), "Writing material"),
        CrypticRiddle("What walks on four legs in the morning, two legs at noon, and three legs in the evening?", "MAN", listOf("MAN", "ANIMAL", "SHADOW"), "Riddle of the Sphinx"),
        CrypticRiddle("I can be cracked, made, told, and played. What am I?", "JOKE", listOf("JOKE", "CODE", "RIDDLE"), "Something funny"),
        CrypticRiddle("What begins with T, ends with T, and has T in it?", "TEAPOT", listOf("TEAPOT", "TEXT", "TENT"), "Tea container"),
        CrypticRiddle("The man who made it doesn't want it. The man who bought it doesn't need it. The man who needs it doesn't know it. What is it?", "COFFIN", listOf("COFFIN", "GIFT", "HOUSE"), "Final resting place")
    )
}

