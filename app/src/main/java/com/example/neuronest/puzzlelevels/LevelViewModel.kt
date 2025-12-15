package com.example.neuronest.puzzlelevels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LevelViewModel @Inject constructor(
    private val repository: LevelRepository
) : ViewModel() {

    private val _levels = MutableStateFlow<List<LevelDetails>>(emptyList())
    val levels: StateFlow<List<LevelDetails>> = _levels.asStateFlow()

    private val _currentPuzzleType = MutableStateFlow("")
    val currentPuzzleType: StateFlow<String> = _currentPuzzleType.asStateFlow()

    private val _totalStars = MutableStateFlow(0)
    val totalStars: StateFlow<Int> = _totalStars.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    fun loadLevels(puzzleType: String) {
        _currentPuzzleType.value = puzzleType
        _isLoading.value = true
        
        viewModelScope.launch {
            try {
                // Subscribe to live updates from the database
                repository.getLevelProgressFlow(puzzleType).collect { levelProgress ->
                    val maxUnlocked = levelProgress.currentLevel

                    // Load level details for all 500 levels
                    val levelDetailsList = (1..500).map { levelNum ->
                        val isUnlocked = levelNum <= maxUnlocked

                        if (isUnlocked) {
                            // For unlocked levels, get actual details from repository
                            repository.getLevelDetails(puzzleType, levelNum) ?: LevelDetails(
                                levelNumber = levelNum,
                                puzzleType = puzzleType,
                                difficulty = "Level $levelNum",
                                isUnlocked = true,
                                isCompleted = false,
                                starsEarned = 0,
                                bestScore = 0,
                                bestTime = null,
                                attempts = 0
                            )
                        } else {
                            // Locked levels
                            LevelDetails(
                                levelNumber = levelNum,
                                puzzleType = puzzleType,
                                difficulty = "Locked",
                                isUnlocked = false,
                                isCompleted = false,
                                starsEarned = 0,
                                bestScore = 0,
                                bestTime = null,
                                attempts = 0
                            )
                        }
                    }

                    _levels.value = levelDetailsList
                    _totalStars.value = levelProgress.totalStars
                    _isLoading.value = false
                }
            } catch (e: Exception) {
                _isLoading.value = false
                // Handle error if needed
            }
        }
    }

    fun refreshLevels() {
        val currentPuzzleType = _currentPuzzleType.value
        if (currentPuzzleType.isNotEmpty()) {
            loadLevels(currentPuzzleType)
        }
    }

    fun completeLevel(level: Int, score: Int, stars: Int, timeTaken: Long) {
        val type = _currentPuzzleType.value
        if (type.isEmpty()) return

        viewModelScope.launch {
            repository.completeLevel(type, level, score, stars, timeTaken)
            // No need to manually reload - the Flow will automatically update
        }
    }
    
    fun getPuzzleConfig(level: Int): PuzzleConfig {
        return DifficultyGenerator.generateConfig(_currentPuzzleType.value, level)
    }
}
