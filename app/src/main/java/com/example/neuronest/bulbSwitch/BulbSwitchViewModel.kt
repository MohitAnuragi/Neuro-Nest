package com.example.neuronest.bulbSwitch

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.neuronest.profile.ProfileRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BulbSwitchViewModel @Inject constructor(
    private val profileRepository: ProfileRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow(BulbSwitchUiState())
    val uiState: StateFlow<BulbSwitchUiState> = _uiState.asStateFlow()

    private var puzzleStartTime: Long = 0
    private var hintsUsed: Int = 0
    private val currentDifficulty: String = "Hard" // This is a complex puzzle
    private var solutionAttempts: Int = 0

    init {
        generateNewPuzzle()
        startPuzzleTimer()
    }

    private fun startPuzzleTimer() {
        puzzleStartTime = System.currentTimeMillis()
        hintsUsed = 0
        solutionAttempts = 0
    }

    fun generateNewPuzzle() {
        val bulbs = (0..2).shuffled()
        val mapping = mapOf(
            0 to bulbs[0],
            1 to bulbs[1],
            2 to bulbs[2]
        )
        _uiState.update {
            it.copy(
                switches = listOf(false, false, false),
                bulbStates = listOf(false, false, false),
                bulbTemperatures = listOf(0, 0, 0),
                switchMapping = mapping,
                message = "Flip the switches in any combination, then press 'Check Bulbs' to see the results.",
                revealBulbs = false,
                hasAttempted = false,
                showSolution = false,
                isSolved = false
            )
        }
        startPuzzleTimer()
    }

    fun toggleSwitch(index: Int) {
        if (uiState.value.hasAttempted || uiState.value.isSolved) return

        val newSwitches = _uiState.value.switches.toMutableList()
        newSwitches[index] = !newSwitches[index]
        _uiState.update { it.copy(switches = newSwitches) }
    }

    fun checkBulbs() {
        if (uiState.value.hasAttempted || uiState.value.isSolved) return

        val onSwitches = uiState.value.switches.mapIndexed { index, state ->
            if (state) index else null
        }.filterNotNull()

        val offSwitches = uiState.value.switches.mapIndexed { index, state ->
            if (!state) index else null
        }.filterNotNull()

        val newBulbStates = MutableList(3) { false }
        val newBulbTemperatures = MutableList(3) { 0 }

        if (onSwitches.isNotEmpty()) {
            val hotBulbIndex = uiState.value.switchMapping[onSwitches[0]] ?: 0
            newBulbStates[hotBulbIndex] = true
            newBulbTemperatures[hotBulbIndex] = 2

            for (i in 1 until onSwitches.size) {
                val warmBulbIndex = uiState.value.switchMapping[onSwitches[i]] ?: continue
                newBulbStates[warmBulbIndex] = true
                newBulbTemperatures[warmBulbIndex] = 1
            }
        }

        _uiState.update {
            it.copy(
                bulbStates = newBulbStates,
                bulbTemperatures = newBulbTemperatures,
                revealBulbs = true,
                hasAttempted = true,
                message = "You've checked the bulbs! Now figure out which switch controls which bulb based on their temperatures."
            )
        }
    }

    fun submitSolution(userSolution: Map<Int, Int>) {
        if (!uiState.value.hasAttempted) {
            _uiState.update { it.copy(message = "You must check the bulbs first!") }
            return
        }

        if (uiState.value.isSolved) {
            _uiState.update { it.copy(message = "Puzzle already solved! Generate a new one.") }
            return
        }

        solutionAttempts++
        val isCorrect = userSolution == uiState.value.switchMapping
        val timeTaken = System.currentTimeMillis() - puzzleStartTime

        if (isCorrect) {
            val scoreEarned = calculateScore(timeTaken, hintsUsed, solutionAttempts)

            // Update profile with successful solution
            viewModelScope.launch {
                profileRepository.updatePuzzleResult(
                    puzzleType = "Bulb Switch",
                    difficulty = currentDifficulty,
                    wasSolved = true,
                    timeTakenMs = timeTaken,
                    hintsUsed = hintsUsed,
                    scoreEarned = scoreEarned
                )
            }

            _uiState.update {
                it.copy(
                    message = "Congratulations! You solved the puzzle! +$scoreEarned points",
                    isSolved = true,
                    showSolution = true
                )
            }
        } else {
            _uiState.update {
                it.copy(
                    message = "Incorrect solution. Try again! (Attempts: $solutionAttempts)",
                    hasAttempted = false,
                    revealBulbs = false,
                    bulbTemperatures = listOf(0, 0, 0)
                )
            }

            // Track failed attempt in profile
            viewModelScope.launch {
                profileRepository.updatePuzzleResult(
                    puzzleType = "Bulb Switch",
                    difficulty = currentDifficulty,
                    wasSolved = false,
                    timeTakenMs = timeTaken,
                    hintsUsed = hintsUsed,
                    scoreEarned = 0
                )
            }
        }
    }

    fun showSolution() {
        val timeTaken = System.currentTimeMillis() - puzzleStartTime

        // Track skipped puzzle in profile
        viewModelScope.launch {
            profileRepository.updatePuzzleResult(
                puzzleType = "Bulb Switch",
                difficulty = currentDifficulty,
                wasSolved = false,
                timeTakenMs = timeTaken,
                hintsUsed = hintsUsed,
                scoreEarned = 0
            )
        }

        _uiState.update { it.copy(showSolution = true) }
    }

    fun useHint() {
        hintsUsed++
        // Provide a helpful hint
        val hintMessage = when (hintsUsed) {
            1 -> "Hint: Turn on one switch for a few minutes, then turn it off and turn on another switch."
            2 -> "Hint: The bulb that's on is controlled by the second switch. The warm bulb is controlled by the first switch."
            3 -> "Hint: The cold bulb is controlled by the switch you didn't touch."
            else -> "No more hints available."
        }

        _uiState.update { it.copy(message = hintMessage) }
    }

    private fun calculateScore(timeTaken: Long, hintsUsed: Int, attempts: Int): Long {
        val baseScore = 200 // High base score for complex puzzle
        val timeBonus = maxOf(0, (60000 - timeTaken) / 200) // 60s max time
        val hintPenalty = hintsUsed * 40
        val attemptPenalty = (attempts - 1) * 30 // Penalty for multiple attempts
        return baseScore + timeBonus - hintPenalty - attemptPenalty
    }

    fun skipPuzzle() {
        val timeTaken = System.currentTimeMillis() - puzzleStartTime

        // Track skipped puzzle in profile
        viewModelScope.launch {
            profileRepository.updatePuzzleResult(
                puzzleType = "Bulb Switch",
                difficulty = currentDifficulty,
                wasSolved = false,
                timeTakenMs = timeTaken,
                hintsUsed = hintsUsed,
                scoreEarned = 0
            )
        }

        _uiState.update {
            it.copy(
                message = "Puzzle skipped! The solution was: ${uiState.value.switchMapping}",
                showSolution = true
            )
        }
    }
}