package com.example.neuronest.logic

data class LogicRiddle(
    val riddle: String,
    val answer: String,
    val difficulty: String = "Medium",
    val options: List<String> = emptyList(),
    val puzzleType: String = "Logic" // New field to track puzzle type
)

data class LogicRiddlesUiState(
    val currentRiddle: LogicRiddle = LogicRiddle("", ""),
    val userAnswer: String = "",
    val feedbackMessage: String = "Type your answer and check it!",
    val isAnswerRevealed: Boolean = false,
    val isCorrect: Boolean = false,
    val isLoading: Boolean = false,
    val score: Long = 0,
    val totalAttempts: Int = 0,
    val showHint: Boolean = false,
    val currentPuzzleType: String = "Logic" // Track current puzzle type
)