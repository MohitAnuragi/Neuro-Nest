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
    private val usedPuzzleIndices = mutableSetOf<Int>()

    init {
        problemsRequired = 5 // 5 logic puzzles per level like Arithmetic
    }

    override fun onLevelLoaded(level: Int) {
        usedPuzzleIndices.clear() // Clear used puzzles for new level
        generateNewPuzzle(level)
        puzzleStartTime = System.currentTimeMillis()
    }

    override fun resetLevelState() {
        super.resetLevelState()
        usedPuzzleIndices.clear() // Clear when replaying
        _userAnswer.value = ""
        _feedback.value = ""
        _isCorrect.value = null
        _showHint.value = false
    }

    fun generateNewPuzzle(level: Int) {
        val puzzles = getPuzzlesForLevel(level)

        // Find unused puzzles
        val availableIndices = puzzles.indices.filter { it !in usedPuzzleIndices }

        // If all puzzles used, reset for variety
        val indexToUse = if (availableIndices.isEmpty()) {
            usedPuzzleIndices.clear()
            puzzles.indices.random()
        } else {
            availableIndices.random()
        }

        usedPuzzleIndices.add(indexToUse)
        val puzzle = puzzles[indexToUse]

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
                generateNewPuzzle(_currentLevel.value)
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

        generateNewPuzzle(_currentLevel.value)
    }

    fun toggleHint() {
        if (_isLevelComplete.value) return

        if (!_showHint.value) {
            onHintUsed()
        }
        _showHint.value = !_showHint.value
    }

    private fun getPuzzlesForLevel(level: Int): List<LogicPuzzle> {
        return when {
            level <= 100 -> easyPuzzles
            level <= 200 -> mediumPuzzles
            level <= 300 -> hardPuzzles
            level <= 400 -> expertPuzzles
            else -> masterPuzzles
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

    // Logic Puzzle Banks
    private val easyPuzzles = listOf(
        LogicPuzzle("If you have it, you want to share it. If you share it, you don't have it. What is it?", "SECRET", listOf("SECRET", "MONEY", "KNOWLEDGE"), "Easy", "Something private"),
        LogicPuzzle("The more you take away, the larger it becomes. What is it?", "HOLE", listOf("HOLE", "PROBLEM", "DEBT"), "Easy", "Empty space"),
        LogicPuzzle("What can you catch but not throw?", "COLD", listOf("COLD", "BALL", "BUS"), "Easy", "Illness"),
        LogicPuzzle("What goes up and down but doesn't move?", "STAIRS", listOf("STAIRS", "ELEVATOR", "TEMPERATURE"), "Easy", "Building feature"),
        LogicPuzzle("What has a bottom at the top?", "LEG", listOf("LEG", "BOTTLE", "SHOE"), "Easy", "Body part")
    )

    private val mediumPuzzles = listOf(
        LogicPuzzle("I am always hungry, I must always be fed. The finger I touch, will soon turn red. What am I?", "FIRE", listOf("FIRE", "TIME", "WATER"), "Medium", "Element of combustion"),
        LogicPuzzle("What has a heart that doesn't beat?", "ARTICHOKE", listOf("ARTICHOKE", "ROBOT", "COMPUTER"), "Medium", "Vegetable"),
        LogicPuzzle("What belongs to you but others use it more than you?", "NAME", listOf("NAME", "VOICE", "TIME"), "Medium", "Identity"),
        LogicPuzzle("I'm tall when I'm young and short when I'm old. What am I?", "CANDLE", listOf("CANDLE", "PERSON", "TREE"), "Medium", "Light source"),
        LogicPuzzle("What has words but never speaks?", "BOOK", listOf("BOOK", "SIGN", "LETTER"), "Medium", "Reading material")
    )

    private val hardPuzzles = listOf(
        LogicPuzzle("Two in a corner, one in a room, zero in a house, but one in a shelter. What am I?", "R", listOf("R", "WALL", "DOOR"), "Hard", "Letter in words"),
        LogicPuzzle("What comes once in a minute, twice in a moment, but never in a thousand years?", "M", listOf("M", "TIME", "SECOND"), "Hard", "Letter"),
        LogicPuzzle("Forward I am heavy, backward I am not. What am I?", "TON", listOf("TON", "WEIGHT", "NOT"), "Hard", "Unit of measurement"),
        LogicPuzzle("What word becomes shorter when you add two letters to it?", "SHORT", listOf("SHORT", "LONG", "WORD"), "Hard", "Add ER"),
        LogicPuzzle("I have keys but no locks. I have space but no room. You can enter but can't go inside. What am I?", "KEYBOARD", listOf("KEYBOARD", "PIANO", "COMPUTER"), "Hard", "Input device")
    )

    private val expertPuzzles = listOf(
        LogicPuzzle("A man pushes his car to a hotel and tells the owner he's bankrupt. Why?", "MONOPOLY", listOf("MONOPOLY", "HOTEL", "GAME"), "Expert", "Board game"),
        LogicPuzzle("A woman shoots her husband, then holds him underwater for five minutes. Next, she hangs him. Right after, they enjoy a lovely dinner. Explain.", "PHOTOGRAPH", listOf("PHOTOGRAPH", "PICTURE", "PHOTO"), "Expert", "Developing photos"),
        LogicPuzzle("What always runs but never walks, often murmurs but never talks, has a bed but never sleeps, has a mouth but never eats?", "RIVER", listOf("RIVER", "CLOCK", "TIME"), "Expert", "Water body"),
        LogicPuzzle("I am not alive, but I can die. What am I?", "BATTERY", listOf("BATTERY", "CANDLE", "FIRE"), "Expert", "Power source"),
        LogicPuzzle("What breaks when you say it?", "SILENCE", listOf("SILENCE", "SECRET", "PROMISE"), "Expert", "Absence of sound")
    )

    private val masterPuzzles = listOf(
        LogicPuzzle("Three doctors said that Bill was their brother. Bill says he has no brothers. How many brothers does Bill actually have?", "ZERO", listOf("ZERO", "THREE", "ONE"), "Master", "All sisters"),
        LogicPuzzle("A man lives on the 100th floor. On rainy days he rides the elevator all the way up. On sunny days, he rides to the 70th floor and walks the rest. Why?", "SHORT", listOf("SHORT", "UMBRELLA", "ELEVATOR"), "Master", "Can't reach button"),
        LogicPuzzle("A murderer is condemned to death. He has to choose between three rooms. The first is full of raging fires, the second is full of assassins with loaded guns, and the third is full of lions that haven't eaten in 3 years. Which room is safest?", "LIONS", listOf("LIONS", "FIRE", "GUNS"), "Master", "Dead from starvation"),
        LogicPuzzle("The more there is, the less you see. What is it?", "DARKNESS", listOf("DARKNESS", "FOG", "SMOKE"), "Master", "Absence of light"),
        LogicPuzzle("What walks on four legs in the morning, two legs at noon, and three legs in the evening?", "MAN", listOf("MAN", "ANIMAL", "SHADOW"), "Master", "Riddle of the Sphinx")
    )
}

