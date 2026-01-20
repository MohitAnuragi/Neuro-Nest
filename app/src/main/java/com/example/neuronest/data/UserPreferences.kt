package com.example.neuronest.data

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val Context.dataStore by preferencesDataStore(name = "user_preferences")

class UserPreferences(context: Context) {

    private val dataStore = context.dataStore

    companion object {
        private val USER_NAME_KEY = stringPreferencesKey("user_name")
        private val PROFILE_IMAGE_URI_KEY = stringPreferencesKey("profile_image_uri")
        private val IS_PROFILE_SETUP_KEY = booleanPreferencesKey("is_profile_setup")
    }

    val userName: Flow<String?> = dataStore.data
        .map { preferences ->
            preferences[USER_NAME_KEY]
        }

    val profileImageUri: Flow<String?> = dataStore.data
        .map { preferences ->
            preferences[PROFILE_IMAGE_URI_KEY]
        }

    val isProfileSetup: Flow<Boolean> = dataStore.data
        .map { preferences ->
            preferences[IS_PROFILE_SETUP_KEY] ?: false
        }

    suspend fun saveUserName(name: String) {
        dataStore.edit { preferences ->
            preferences[USER_NAME_KEY] = name
            // Mark profile as setup when name is saved (but not for Guest User)
            if (name.isNotEmpty() && name != "Guest User") {
                preferences[IS_PROFILE_SETUP_KEY] = true
            }
        }
    }

    suspend fun saveProfileImageUri(uri: String) {
        dataStore.edit { preferences ->
            preferences[PROFILE_IMAGE_URI_KEY] = uri
        }
    }

    suspend fun markProfileAsSetup() {
        dataStore.edit { preferences ->
            preferences[IS_PROFILE_SETUP_KEY] = true
        }
    }

    suspend fun clearProfileData() {
        dataStore.edit { preferences ->
            preferences.remove(USER_NAME_KEY)
            preferences.remove(PROFILE_IMAGE_URI_KEY)
            preferences.remove(IS_PROFILE_SETUP_KEY)
        }
    }
}
