package com.example.neuronest.puzzlelevels


import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "level_preferences")

@Singleton
class LevelDataStoreManager @Inject constructor(
    private val context: Context
) {

    suspend fun getMaxUnlockedLevel(puzzleType: String): Any {
        val key = intPreferencesKey("max_unlocked_${puzzleType}")
        return context.dataStore.data.map { preferences ->
            preferences[key] ?: 1 // Default to level 1
        }
        return 1
    }

    suspend fun saveMaxUnlockedLevel(puzzleType: String, level: Int) {
        val key = intPreferencesKey("max_unlocked_${puzzleType}")
        context.dataStore.edit { preferences ->
            preferences[key] = level
        }
    }

    fun getMaxUnlockedLevelFlow(puzzleType: String): Flow<Int> {
        val key = intPreferencesKey("max_unlocked_${puzzleType}")
        return context.dataStore.data.map { preferences ->
            preferences[key] ?: 1
        }
    }
}