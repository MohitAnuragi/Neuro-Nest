package com.example.neuronest.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.neuronest.achievements.AchievementEntity
import com.example.neuronest.achievements.AchievementRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Achievements ViewModel
 *
 * Manages achievement state from Room database.
 * Achievements are automatically unlocked based on real puzzle progress.
 */
@HiltViewModel
class AchievementsViewModel @Inject constructor(
    private val achievementRepository: AchievementRepository
) : ViewModel() {

    private val _achievements = MutableStateFlow<List<AchievementEntity>>(emptyList())
    val achievements: StateFlow<List<AchievementEntity>> = _achievements.asStateFlow()

    private val _unlockedCount = MutableStateFlow(0)
    val unlockedCount: StateFlow<Int> = _unlockedCount.asStateFlow()

    private val _totalCount = MutableStateFlow(0)
    val totalCount: StateFlow<Int> = _totalCount.asStateFlow()

    init {
        // Automatically load and check achievements when ViewModel is created
        loadAchievements()
    }

    /**
     * Load achievements from database and check for new unlocks
     */
    fun loadAchievements() {
        viewModelScope.launch {
            // Check and update achievements based on current progress
            achievementRepository.checkAndUpdateAchievements()

            // Load updated achievements
            _achievements.value = achievementRepository.getAllAchievements()
            _unlockedCount.value = achievementRepository.getUnlockedCount()
            _totalCount.value = achievementRepository.getTotalCount()
        }
    }
}

