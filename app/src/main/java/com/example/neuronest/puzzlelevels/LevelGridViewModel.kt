//package com.example.neuronest.puzzlelevels
//
//
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope
//import com.example.neuronest.profile.ProfileRepository
//import dagger.hilt.android.lifecycle.HiltViewModel
//import kotlinx.coroutines.flow.MutableStateFlow
//import kotlinx.coroutines.flow.StateFlow
//import kotlinx.coroutines.flow.asStateFlow
//import kotlinx.coroutines.launch
//import javax.inject.Inject
//
//@HiltViewModel
//class PuzzleViewModel(private val progressManager: PuzzleProgressManager) : ViewModel() {
//
//    private val _completedLevel = MutableStateFlow(0)
//    val completedLevel = _completedLevel.asStateFlow()
//    val  puzzleName = ""
//
//    init {
//        viewModelScope.launch {
//            progressManager.getCompletedLevel(
//                puzzleName = p
//            ).collect {
//                _completedLevel.value = it
//            }
//        }
//    }
//
//    fun markLevelComplete(level: Int) {
//        viewModelScope.launch {
//            if (level > _completedLevel.value) {
//                progressManager.saveCompletedLevel(
//                    puzzleName =  puzzleName,
//                    level = level
//                )
//            }
//        }
//    }
//
//
//    fun isLevelUnlocked(level: Int): Boolean {
//        return level <= _completedLevel.value + 1
//    }
//
//}
