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

    private val _needsProfileSetup = MutableStateFlow<Boolean?>(null)
    val needsProfileSetup: StateFlow<Boolean?> = _needsProfileSetup.asStateFlow()

    private val puzzleTypes = listOf(
        "WordScramble",
        "Kakuro",
        "SequenceGenerator",
        "SudokuPuzzle",
        "LogicPuzzles",
        "Connections"
    )

    init {
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
            _needsProfileSetup.value = !userProfile.isProfileSetup
        }
    }


    private fun loadPuzzleProgress() {
        viewModelScope.launch {
            val progressList = puzzleTypes.mapNotNull { puzzleType ->
                try {
                    val completedCount = levelRepository.getCompletedLevelsCount(puzzleType)

                    val totalCount = 500

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
            profileRepository.updateProfileDetails(displayName, imageUri)

            loadProfile()
            checkProfileSetup()
        }
    }
}