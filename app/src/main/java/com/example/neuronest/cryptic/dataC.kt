package com.example.neuronest.cryptic


data class RiddlesUiState(
    val currentRiddle: Riddle = Riddle("", ""),
    val userAnswer: String = "",
    val feedbackMessage: String = "Type your answer and check it!",
    val isAnswerRevealed: Boolean = false,
    val isCorrect: Boolean = false,
    val isLoading: Boolean = false,
    val score: Long = 0,
    val totalAttempts: Int = 0,
    val showHint: Boolean = false,
    val totalPuzzlesSolved : Int = 0,
    val debugInfo: String = "" // Added for debugging
)

data class Riddle(
    val riddle: String,
    val answer: String,
    val difficulty: String = "Medium",
    val options: List<String> = emptyList()
)