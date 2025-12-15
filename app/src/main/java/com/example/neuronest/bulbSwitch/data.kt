package com.example.neuronest.bulbSwitch

data class BulbSwitchUiState(
    val switches: List<Boolean> = listOf(false, false, false),
    val bulbStates: List<Boolean> = listOf(false, false, false),
    val bulbTemperatures: List<Int> = listOf(0, 0, 0), // 0 = cold, 1 = warm, 2 = hot
    val switchMapping: Map<Int, Int> = emptyMap(),
    val message: String = "Welcome! Flip the switches, then check the bulbs.",
    val revealBulbs: Boolean = false,
    val hasAttempted: Boolean = false,
    val showSolution: Boolean = false,
    val isSolved: Boolean = false
)