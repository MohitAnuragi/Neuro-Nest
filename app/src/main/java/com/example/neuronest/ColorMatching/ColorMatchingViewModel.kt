package com.example.neuronest.ColorMatching

import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.neuronest.profile.ProfileRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlin.random.Random

@HiltViewModel
class ColorPuzzleViewModel @Inject constructor(
    private val profileRepository: ProfileRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow(ColorPuzzleUiState())
    val uiState: StateFlow<ColorPuzzleUiState> = _uiState.asStateFlow()

    private val _isCorrect = MutableStateFlow<Boolean?>(null)
    val isCorrect: StateFlow<Boolean?> = _isCorrect.asStateFlow()

    private var _correctColor: Color = Color.Unspecified
    private var puzzleStartTime: Long = 0
    private var hintsUsed: Int = 0
    private val currentDifficulty: String = "Medium"

    init {
        generateNewPuzzle()
        startPuzzleTimer()
//        loadInitialStats()
    }

//    private fun loadInitialStats() {
//        viewModelScope.launch {
////            val colorMatchingStats = profileRepository.getPuzzleTypeStats("Color Matching") // Fetches PuzzleTypeStats?
////            val userProfile = profileRepository.getOrCreateProfile() // Fetches the main UserProfile
//
//            _uiState.value = _uiState.value.copy(
//                score = userProfile.totalScore, // Use totalScore from the UserProfile
//                totalPuzzlesSolved = colorMatchingStats?.solved ?: 0 // Safely access 'solved' from PuzzleTypeStats, defaulting to 0 if null
//            )
//        }
//    }

    private fun startPuzzleTimer() {
        puzzleStartTime = System.currentTimeMillis()
        hintsUsed = 0
    }

    fun generateNewPuzzle() {
        val allColors = listOf(
            Color(0xFF6200EE), Color(0xFF03DAC6), Color(0xFFFFD600),
            Color(0xFFFF0266), Color(0xFF3700B3), Color(0xFF018786),
            Color(0xFFFFAB00), Color(0xFFBB86FC), Color(0xFF03A9F4),
            Color(0xFFFF5252), Color(0xFF62000E), Color(0xFF03DAC6),
            Color(0xFFEFD680), Color(0xFFFF0066), Color(0xFF27E7B0),
            Color(0xFF010786), Color(0xFFFFAB99), Color(0xFFBB22FC),
            Color(0xFF66A9F4), Color(0xFFEF5252), Color(0xFF620033),
            Color(0xFF03DA11), Color(0xFFFFD99E), Color(0xFF7FE363),
            Color(0xFF3700B3), Color(0xFF55EE86), Color(0xFFFFA550),
            Color(0xFFBB8E6C), Color(0xFF03A094), Color(0xFFFF5EE2)
        )

        val shuffledColors = allColors.shuffled(Random)
        _correctColor = shuffledColors.first()
        val options = shuffledColors.take(4).shuffled(Random)

        _uiState.value = _uiState.value.copy(
            targetColor = _correctColor,
            options = options,
            feedback = ""
        )
        _isCorrect.value = null
        startPuzzleTimer()
    }

    fun checkAnswer(selectedColor: Color) {
        val isCorrectAnswer = selectedColor == _correctColor
        val timeTaken = System.currentTimeMillis() - puzzleStartTime
        val scoreEarned = if (isCorrectAnswer) calculateScore(timeTaken, hintsUsed) else 0

        if (isCorrectAnswer) {
            // Update local state first
            _uiState.value = _uiState.value.copy(
                feedback = "Correct! +$scoreEarned points",
                score = _uiState.value.score + scoreEarned,
                totalPuzzlesSolved = _uiState.value.totalPuzzlesSolved + 1
            )
            _isCorrect.value = true
            generateNewPuzzle()
        } else {
            _uiState.value = _uiState.value.copy(
                feedback = "Incorrect. Try again!"
            )
            _isCorrect.value = false
        }

        // Update profile repository with the result
        viewModelScope.launch {
            profileRepository.updatePuzzleResult(
                puzzleType = "Color Matching",
                difficulty = currentDifficulty,
                wasSolved = isCorrectAnswer,
                timeTakenMs = timeTaken,
                hintsUsed = hintsUsed,
                scoreEarned = scoreEarned
            )
        }
    }

    fun resetIsCorrectFlag() {
        _isCorrect.value = null
    }

    private fun calculateScore(timeTaken: Long, hintsUsed: Int): Long {
        val baseScore = 10 // Increased from 0 to give meaningful scores
        val timeBonus = maxOf(0, (1000 - timeTaken) / 50) // 10s max time, more generous
        val hintPenalty = hintsUsed * 15 // Reduced penalty
        return baseScore + timeBonus - hintPenalty
    }

}

data class ColorPuzzleUiState(
    val targetColor: Color = Color.Red,
    val options: List<Color> = listOf(),
    val feedback: String = "",
    val score: Long = 0,
    val totalPuzzlesSolved: Int = 0,
    val currentStreak: Int = 0,
    val accuracy: Double = 0.0
)