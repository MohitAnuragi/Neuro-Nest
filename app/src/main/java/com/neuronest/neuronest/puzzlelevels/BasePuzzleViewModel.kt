package com.neuronest.neuronest.puzzlelevels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.neuronest.neuronest.profile.ProfileRepository
import com.neuronest.neuronest.sound.SoundManager
import com.neuronest.neuronest.sound.SoundType
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch


abstract class BasePuzzleViewModel(
    private val levelRepository: LevelRepository,
    private val profileRepository: ProfileRepository,
    val soundManager: SoundManager
) : ViewModel() {

    abstract val puzzleType: String
    
    protected val _currentLevel = MutableStateFlow(1)
    val currentLevel: StateFlow<Int> = _currentLevel.asStateFlow()

    protected val _maxUnlockedLevel = MutableStateFlow(1)
    val maxUnlockedLevel: StateFlow<Int> = _maxUnlockedLevel.asStateFlow()

    protected val _score = MutableStateFlow(0)
    val score: StateFlow<Int> = _score.asStateFlow()

    protected val _starsEarned = MutableStateFlow(0)
    val starsEarned: StateFlow<Int> = _starsEarned.asStateFlow()

    protected val _isLevelComplete = MutableStateFlow(false)
    val isLevelComplete: StateFlow<Boolean> = _isLevelComplete.asStateFlow()

    protected val _showLevelCompleteDialog = MutableStateFlow(false)
    val showLevelCompleteDialog: StateFlow<Boolean> = _showLevelCompleteDialog.asStateFlow()

    protected val _elapsedTimeMs = MutableStateFlow(0L)
    val elapsedTimeMs: StateFlow<Long> = _elapsedTimeMs.asStateFlow()

    protected val _isTimerRunning = MutableStateFlow(false)
    val isTimerRunning: StateFlow<Boolean> = _isTimerRunning.asStateFlow()

    protected val _levelProgress = MutableStateFlow(0f)
    val levelProgress: StateFlow<Float> = _levelProgress.asStateFlow()

    protected var levelStartTime: Long = 0
    protected var problemsSolved = 0
    protected var problemsRequired = 5
    protected open var hintsUsed = 0
    protected var bestTimeForLevel: Long? = null

    init {
        loadMaxUnlockedLevel()
    }

    fun loadLevel(level: Int) {
        _currentLevel.value = level
        resetLevelState()
        levelStartTime = System.currentTimeMillis()
        _isTimerRunning.value = true
        loadBestTime(level)
        onLevelLoaded(level)
        soundManager.playSound(SoundType.TRANSITION)
    }


    protected abstract fun onLevelLoaded(level: Int)

    fun updateElapsedTime(timeMs: Long) {
        _elapsedTimeMs.value = timeMs
    }

    protected open fun onProblemSolved(timeTaken: Long, pointsEarned: Int = 100) {
        problemsSolved++
        _score.value += pointsEarned

        val progress = problemsSolved.toFloat() / problemsRequired
        _levelProgress.value = progress

        soundManager.playSound(SoundType.CORRECT_MOVE)

        if (problemsSolved >= problemsRequired) {
            markLevelComplete()
        }
    }

    protected open fun onIncorrectMove() {
        soundManager.playSound(SoundType.INCORRECT_MOVE)
    }

    protected open fun onHintUsed() {
        hintsUsed++
        soundManager.playSound(SoundType.HINT)
    }

    protected open fun calculateStars(timeTakenMs: Long, hintsUsed: Int, score: Int): Int {
        val timeSeconds = timeTakenMs / 1000
        return when {
            timeSeconds < 30 && hintsUsed == 0 && score >= 400 -> 3
            timeSeconds < 60 && hintsUsed <= 1 && score >= 300 -> 2
            else -> 1
        }.coerceIn(1, 3)
    }

    protected open fun markLevelComplete() {
        if (_isLevelComplete.value) return

        _isTimerRunning.value = false
        val totalTime = System.currentTimeMillis() - levelStartTime
        _elapsedTimeMs.value = totalTime

        val stars = calculateStars(totalTime, hintsUsed, _score.value)
        _starsEarned.value = stars

        viewModelScope.launch {
            val result = levelRepository.completeLevel(
                puzzleType = puzzleType,
                levelNumber = _currentLevel.value,
                score = _score.value,
                stars = stars,
                timeTaken = totalTime
            )

            profileRepository.updateLevelProgress(
                puzzleType = puzzleType,
                levelNumber = _currentLevel.value,
                score = _score.value,
                stars = stars
            )

            _maxUnlockedLevel.value = levelRepository.getMaxUnlockedLevel(puzzleType)
            
            _isLevelComplete.value = true
            _showLevelCompleteDialog.value = true

            soundManager.playSound(SoundType.LEVEL_COMPLETE)
            if (stars >= 3) {
                soundManager.playSound(SoundType.STAR_EARNED)
            }
        }
    }

    private fun loadMaxUnlockedLevel() {
        viewModelScope.launch {
            _maxUnlockedLevel.value = levelRepository.getMaxUnlockedLevel(puzzleType)
        }
    }

    private fun loadBestTime(level: Int) {
        viewModelScope.launch {
            val details = levelRepository.getLevelDetails(puzzleType, level)
            bestTimeForLevel = details?.bestTime
        }
    }

    protected open fun resetLevelState() {
        _score.value = 0
        _starsEarned.value = 0
        problemsSolved = 0
        hintsUsed = 0
        _isLevelComplete.value = false
        _showLevelCompleteDialog.value = false
        _elapsedTimeMs.value = 0L
        _isTimerRunning.value = false
        _levelProgress.value = 0f
    }

    fun dismissLevelCompleteDialog() {
        _showLevelCompleteDialog.value = false
    }

    fun getLevelProgress(): Float {
        return if (problemsRequired > 0) {
            problemsSolved.toFloat() / problemsRequired
        } else {
            0f
        }
    }

    fun getProblemsRemaining(): Int {
        return (problemsRequired - problemsSolved).coerceAtLeast(0)
    }

    fun replayLevel() {
        loadLevel(_currentLevel.value)
    }

    fun goToNextLevel() {
        val nextLevel = _currentLevel.value + 1
        if (nextLevel <= 500 && nextLevel <= _maxUnlockedLevel.value) {
            loadLevel(nextLevel)
        }
    }

    fun isNewBestTime(): Boolean {
        return bestTimeForLevel?.let { best ->
            _elapsedTimeMs.value < best
        } ?: true
    }

    override fun onCleared() {
        super.onCleared()
        _isTimerRunning.value = false
    }
}
