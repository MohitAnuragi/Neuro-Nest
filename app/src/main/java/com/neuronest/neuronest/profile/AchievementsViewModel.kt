package com.neuronest.neuronest.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.neuronest.neuronest.achievements.AchievementEntity
import com.neuronest.neuronest.achievements.AchievementRepository
import com.neuronest.neuronest.sound.SoundManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class AchievementsViewModel @Inject constructor(
    private val achievementRepository: AchievementRepository,
    val soundManager: SoundManager
) : ViewModel() {

    private val _achievements = MutableStateFlow<List<AchievementEntity>>(emptyList())
    val achievements: StateFlow<List<AchievementEntity>> = _achievements.asStateFlow()

    private val _unlockedCount = MutableStateFlow(0)
    val unlockedCount: StateFlow<Int> = _unlockedCount.asStateFlow()

    private val _totalCount = MutableStateFlow(0)
    val totalCount: StateFlow<Int> = _totalCount.asStateFlow()

    init {
        loadAchievements()
    }


    fun loadAchievements() {
        viewModelScope.launch {
            achievementRepository.checkAndUpdateAchievements()

            _achievements.value = achievementRepository.getAllAchievements()
            _unlockedCount.value = achievementRepository.getUnlockedCount()
            _totalCount.value = achievementRepository.getTotalCount()
        }
    }
}

