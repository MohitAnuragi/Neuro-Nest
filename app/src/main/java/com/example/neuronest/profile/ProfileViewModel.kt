// viewmodel/ProfileViewModel.kt
package com.example.neuronest.profile

import android.content.Context
import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.neuronest.puzzlelevels.LevelRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Profile ViewModel
 *
 * Manages PROFILE data ONLY (identity + current state).
 * Does NOT manage achievements - that's in AchievementsViewModel.
 */
@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val profileRepository: ProfileRepository,
    private val levelRepository: LevelRepository,
    @ApplicationContext private val context: Context
) : ViewModel() {

    private val _profile = MutableStateFlow<UserProfile?>(null)
    val profile: StateFlow<UserProfile?> = _profile.asStateFlow()

    private val _puzzleProgress = MutableStateFlow<List<PuzzleProgressData>>(emptyList())
    val puzzleProgress: StateFlow<List<PuzzleProgressData>> = _puzzleProgress.asStateFlow()

    // Track profile setup status: null = loading, true = needs setup, false = setup complete
    private val _needsProfileSetup = MutableStateFlow<Boolean?>(null)
    val needsProfileSetup: StateFlow<Boolean?> = _needsProfileSetup.asStateFlow()

    // Define the puzzle types in the app - MUST MATCH EXACTLY with navigation system
    private val puzzleTypes = listOf(
        "WordScramble",
        "Kakuro",
        "SequenceGenerator",
        "SudokuPuzzle",
        "LogicPuzzles",
        "Connections"
    )

    init {
        // Load profile from Room and check setup status
        viewModelScope.launch {
            loadProfile()
            checkProfileSetup()
            loadPuzzleProgress()
        }
    }

    private fun checkProfileSetup() {
        viewModelScope.launch {
            try {
                val isSetup = profileRepository.isProfileSetupComplete()
                _needsProfileSetup.value = !isSetup
            } catch (e: Exception) {
                // In case of error, default to showing setup screen
                _needsProfileSetup.value = true
            }
        }
    }

    private fun loadProfile() {
        viewModelScope.launch {
            val userProfile = profileRepository.getOrCreateProfile()
            _profile.value = userProfile
            // Update needsProfileSetup based on the explicit isProfileSetup flag
            _needsProfileSetup.value = !userProfile.isProfileSetup
        }
    }

    /**
     * Load puzzle progress from Room database
     * Aggregates completed levels per puzzle type
     *
     * For PROFILE: Shows solvedCount / 500 (per puzzle type)
     * This is DIFFERENT from achievements which use GLOBAL total
     */
    private fun loadPuzzleProgress() {
        viewModelScope.launch {
            val progressList = puzzleTypes.mapNotNull { puzzleType ->
                try {
                    val completedCount = levelRepository.getCompletedLevelsCount(puzzleType)

                    // For PROFILE: Total is always 500 levels per puzzle type
                    val totalCount = 500

                    // Only include puzzle types that have been played
                    if (completedCount > 0) {
                        PuzzleProgressData(
                            puzzleType = puzzleType,
                            solvedCount = completedCount,
                            totalCount = totalCount
                        )
                    } else {
                        null
                    }
                } catch (e: Exception) {
                    null
                }
            }
            _puzzleProgress.value = progressList
        }
    }

    fun refresh() {
        viewModelScope.launch {
            loadProfile()
            checkProfileSetup()
            loadPuzzleProgress()
        }
    }

    fun resetProfile() {
        viewModelScope.launch {
            profileRepository.resetProfile()
            loadProfile()
            checkProfileSetup()
        }
    }

    // Methods for updating profile details
    fun updateDisplayName(displayName: String) {
        viewModelScope.launch {
            profileRepository.updateProfileDetails(displayName, _profile.value?.profileImageUri ?: "")
            loadProfile()
            checkProfileSetup()
        }
    }

    fun updateProfileImage(imageUri: String) {
        viewModelScope.launch {
            profileRepository.updateProfileDetails(_profile.value?.displayName ?: "", imageUri)
            loadProfile()
        }
    }

    fun updateProfileDetails(displayName: String, imageUri: String) {
        viewModelScope.launch {
            // Save to Room database via repository
            profileRepository.updateProfileDetails(displayName, imageUri)

            // Refresh profile state to reflect changes immediately
            loadProfile()
            checkProfileSetup()
        }
    }
}