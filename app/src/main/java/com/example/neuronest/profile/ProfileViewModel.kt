// viewmodel/ProfileViewModel.kt
package com.example.neuronest.profile

import android.content.Context
import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val profileRepository: ProfileRepository,
    @ApplicationContext private val context: Context
) : ViewModel() {


    private val _profile = MutableStateFlow<UserProfile?>(null)
    val profile: StateFlow<UserProfile?> = _profile.asStateFlow()

    private val _puzzleStats = MutableStateFlow<Map<String, PuzzleTypeStats>>(emptyMap())
    val puzzleStats: StateFlow<Map<String, PuzzleTypeStats>> = _puzzleStats.asStateFlow()

    private val _achievements = MutableStateFlow<List<Achievement>>(emptyList())
    val achievements: StateFlow<List<Achievement>> = _achievements.asStateFlow()

    // Track profile setup status: null = loading, true = needs setup, false = setup complete
    private val _needsProfileSetup = MutableStateFlow<Boolean?>(null)
    val needsProfileSetup: StateFlow<Boolean?> = _needsProfileSetup.asStateFlow()

    init {
        // Load profile from Room and check setup status
        viewModelScope.launch {
            loadProfile()
            checkProfileSetup()
            loadAchievements()
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
    // In ProfileViewModel.kt
    fun getProfileImageUri(): Uri? {
        val profile = _profile.value
        return if (!profile?.profileImageUri.isNullOrEmpty()) {
            try {
                Uri.parse(profile?.profileImageUri)
            } catch (e: Exception) {
                null
            }
        } else {
            null
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

    private fun loadAchievements() {
        viewModelScope.launch {
            _achievements.value = calculateAchievements(_profile.value, _puzzleStats.value)
        }
    }

    fun refresh() {
        viewModelScope.launch {
            loadProfile()
            checkProfileSetup()
            loadAchievements()
        }
    }

    fun resetProfile() {
        viewModelScope.launch {
            profileRepository.resetProfile()
            loadProfile()
            checkProfileSetup()
            loadAchievements()
        }
    }
    // NEW: Methods for updating profile details
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
            loadAchievements()
        }
    }
    private fun calculateAchievements(
        profile: UserProfile?,
        stats: Map<String, PuzzleTypeStats>
    ): List<Achievement> {
        val achievements = mutableListOf<Achievement>()

        // Total puzzles solved achievements
        val totalSolved = profile?.totalPuzzlesSolved ?: 0
        achievements.addAll(listOf(
            Achievement("first_blood", "First Blood", "Solve your first puzzle",
                unlocked = totalSolved >= 1, progress = totalSolved, target = 1),
            Achievement("puzzle_master", "Puzzle Master", "Solve 50 puzzles",
                unlocked = totalSolved >= 50, progress = totalSolved, target = 50),
            Achievement("puzzle_grandmaster", "Puzzle Grandmaster", "Solve 200 puzzles",
                unlocked = totalSolved >= 200, progress = totalSolved, target = 200)
        ))

        // Puzzle type specific achievements
        stats.forEach { (type, typeStats) ->
            achievements.addAll(listOf(
                Achievement("${type}_novice", "$type Novice", "Solve 10 $type puzzles",
                    unlocked = typeStats.solved >= 10, progress = typeStats.solved, target = 10,
                    puzzleType = type),
                Achievement("${type}_expert", "$type Expert", "Solve 50 $type puzzles",
                    unlocked = typeStats.solved >= 50, progress = typeStats.solved, target = 50,
                    puzzleType = type)
            ))
        }

        // Streak achievements
        val streak = profile?.currentStreak ?: 0
        achievements.addAll(listOf(
            Achievement("streak_3", "3-Day Streak", "Play for 3 consecutive days",
                unlocked = streak >= 3, progress = streak, target = 3),
            Achievement("streak_7", "7-Day Streak", "Play for 7 consecutive days",
                unlocked = streak >= 7, progress = streak, target = 7)
        ))

        return achievements
    }
}