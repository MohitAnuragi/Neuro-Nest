package com.neuronest.neuronest.connection

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
class ConnectionPuzzleViewModel @Inject constructor(
    private val profileRepository: ProfileRepository,
    levelRepository: LevelRepository,
    soundManager: SoundManager
) : BasePuzzleViewModel(levelRepository, profileRepository, soundManager) {

    override val puzzleType: String = "Connections"


    private val _currentPuzzle = MutableStateFlow<ConnectionPuzzle?>(null)
    val currentPuzzle: StateFlow<ConnectionPuzzle?> = _currentPuzzle.asStateFlow()

    private val _availableWords = MutableStateFlow<List<String>>(emptyList())
    val availableWords: StateFlow<List<String>> = _availableWords.asStateFlow()

    private val _selectedWords = MutableStateFlow<Set<String>>(emptySet())
    val selectedWords: StateFlow<Set<String>> = _selectedWords.asStateFlow()

    private val _solvedCategories = MutableStateFlow<List<ConnectionCategory>>(emptyList())
    val solvedCategories: StateFlow<List<ConnectionCategory>> = _solvedCategories.asStateFlow()

    private val _feedback = MutableStateFlow("")
    val feedback: StateFlow<String> = _feedback.asStateFlow()

    private val _isCorrect = MutableStateFlow<Boolean?>(null)
    val isCorrect: StateFlow<Boolean?> = _isCorrect.asStateFlow()

    private val _mistakesRemaining = MutableStateFlow(4)
    val mistakesRemaining: StateFlow<Int> = _mistakesRemaining.asStateFlow()

    private var puzzleStartTime: Long = 0

    init {
        problemsRequired = 1
    }

    override fun onLevelLoaded(level: Int) {
        loadPuzzleForLevel(level)
        puzzleStartTime = System.currentTimeMillis()
    }

    override fun resetLevelState() {
        super.resetLevelState()
        _selectedWords.value = emptySet()
        _solvedCategories.value = emptyList()
        _feedback.value = ""
        _isCorrect.value = null
        _mistakesRemaining.value = 4
    }
    fun playSoundEffect(soundType: SoundType) {
        soundManager.playSound(soundType)
    }
    private fun loadPuzzleForLevel(level: Int) {
        val puzzleIndex = (level - 1).coerceIn(0, ConnectionPuzzleData.puzzles.size - 1)
        val puzzle = ConnectionPuzzleData.puzzles[puzzleIndex]

        if (puzzle.level != level && level <= ConnectionPuzzleData.puzzles.size) {
            android.util.Log.e("ConnectionPuzzle", "⚠️ Level mismatch! Requested: $level, Got: ${puzzle.level}")
        } else {
            android.util.Log.d("ConnectionPuzzle", "✅ Loading Level $level - Puzzle ID: ${puzzle.level}")
        }

        _currentPuzzle.value = puzzle
        _availableWords.value = puzzle.words.shuffled()
        _selectedWords.value = emptySet()
        _solvedCategories.value = emptyList()
        _feedback.value = ""
        _isCorrect.value = null
        _mistakesRemaining.value = 4
        puzzleStartTime = System.currentTimeMillis()
    }

    fun toggleWordSelection(word: String) {
        if (_isLevelComplete.value) return

        val current = _selectedWords.value.toMutableSet()
        if (word in current) {
            current.remove(word)
            soundManager.playSound(SoundType.BUTTON_CLICK)
        } else {
            if (current.size < 4) {
                current.add(word)
                soundManager.playSound(SoundType.BUTTON_CLICK)
            }
        }
        _selectedWords.value = current
    }

    fun deselectAll() {
        _selectedWords.value = emptySet()
        soundManager.playSound(SoundType.BUTTON_CLICK)
    }

    fun shuffleWords() {
        _availableWords.value = _availableWords.value.shuffled()
        soundManager.playSound(SoundType.TRANSITION)
    }

    fun submitGuess() {
        if (_isLevelComplete.value) return
        if (_selectedWords.value.size != 4) {
            _feedback.value = "Select exactly 4 words!"
            return
        }

        val puzzle = _currentPuzzle.value ?: return
        val guess = _selectedWords.value

        val matchingCategory = puzzle.categories.find { category ->
            category !in _solvedCategories.value && category.words == guess
        }

        if (matchingCategory != null) {
            _solvedCategories.value = _solvedCategories.value + matchingCategory
            _availableWords.value = _availableWords.value.filter { it !in guess }
            _selectedWords.value = emptySet()
            _feedback.value = "Correct! ${matchingCategory.name}"
            _isCorrect.value = true
            soundManager.playSound(SoundType.CORRECT_MOVE)

            if (_solvedCategories.value.size == 4) {
                val timeTaken = System.currentTimeMillis() - puzzleStartTime
                val pointsEarned = calculateScore(timeTaken)
                _feedback.value = "Puzzle Complete! +$pointsEarned points"

                onProblemSolved(timeTaken, pointsEarned)

            }
        } else {
            _mistakesRemaining.value = maxOf(0, _mistakesRemaining.value - 1)
            _feedback.value = "Not quite! ${_mistakesRemaining.value} mistakes remaining"
            _isCorrect.value = false
            soundManager.playSound(SoundType.INCORRECT_MOVE)
            onIncorrectMove()


        }
    }


    fun showHint() {
        if (_isLevelComplete.value) return

        val puzzle = _currentPuzzle.value ?: return
        val unsolvedCategories = puzzle.categories.filter { it !in _solvedCategories.value }

        if (unsolvedCategories.isEmpty()) return

        onHintUsed()

        val hintCategory = unsolvedCategories.sortedBy { it.color }.first()
        val hintWord = hintCategory.words.first()

        _feedback.value = "Hint: Try '$hintWord' - it belongs to ${hintCategory.name}"
        soundManager.playSound(SoundType.HINT)
    }

    private fun calculateScore(timeTaken: Long): Int {
        val level = _currentLevel.value
        val baseScore = when {
            level <= 100 -> 20
            level <= 200 -> 40
            level <= 300 -> 60
            level <= 400 -> 80
            else -> 10
        }

        val timeBonus = maxOf(0, (120000 - timeTaken) / 300).toInt()
        val mistakePenalty = (4 - _mistakesRemaining.value) * 50
        val hintPenalty = hintsUsed * 40

        return baseScore + timeBonus - mistakePenalty - hintPenalty
    }

    override fun calculateStars(timeTakenMs: Long, hintsUsed: Int, score: Int): Int {
        val avgTimePerPuzzle = timeTakenMs / problemsRequired
        return when {
            avgTimePerPuzzle < 60000 && hintsUsed == 0 && score >= 700 -> 3
            avgTimePerPuzzle < 100000 && hintsUsed <= 2 && score >= 450 -> 2
            else -> 1
        }
    }
}
