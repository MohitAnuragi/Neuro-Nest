package com.example.neuronest.sound

import android.content.Context
import android.media.AudioAttributes
import android.media.SoundPool
import androidx.annotation.RawRes
import com.example.neuronest.R
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class SoundManager @Inject constructor(
    @ApplicationContext private val context: Context
) {
    private var soundPool: SoundPool? = null
    private val soundIds = mutableMapOf<SoundType, Int>()

    private val _isSoundEnabled = MutableStateFlow(true)
    val isSoundEnabled: StateFlow<Boolean> = _isSoundEnabled.asStateFlow()

    private val _volume = MutableStateFlow(1.0f)
    val volume: StateFlow<Float> = _volume.asStateFlow()

    init {
        initializeSoundPool()
        loadAllSounds()
    }

    private fun initializeSoundPool() {
        val audioAttributes = AudioAttributes.Builder()
            .setUsage(AudioAttributes.USAGE_GAME)
            .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
            .build()

        soundPool = SoundPool.Builder()
            .setMaxStreams(5)
            .setAudioAttributes(audioAttributes)
            .build()
    }

    private fun loadAllSounds() {
        soundPool?.let { pool ->
            soundIds[SoundType.CORRECT_MOVE] = pool.load(context, R.raw.move, 1)
            soundIds[SoundType.INCORRECT_MOVE] = pool.load(context, R.raw.incorrect_move, 1)
            soundIds[SoundType.LEVEL_COMPLETE] = pool.load(context, R.raw.levelcompleted, 1)
            soundIds[SoundType.BUTTON_CLICK] = pool.load(context, R.raw.buttonclicked, 1)
            soundIds[SoundType.UNLOCK] = pool.load(context, R.raw.unlock_level, 1)
            soundIds[SoundType.LOCK] = pool.load(context, R.raw.lock, 1)
            soundIds[SoundType.TRANSITION] = pool.load(context, R.raw.transition, 1)
            soundIds[SoundType.HINT] = pool.load(context, R.raw.hint_sound, 1)
            soundIds[SoundType.STAR_EARNED] = pool.load(context, R.raw.star, 1)
        }
    }

    fun playSound(soundType: SoundType) {
        if (!_isSoundEnabled.value) return

        soundPool?.let { pool ->
            soundIds[soundType]?.let { soundId ->
                pool.play(soundId, _volume.value, _volume.value, 1, 0, 1.0f)
            }
        }
    }

    fun setSoundEnabled(enabled: Boolean) {
        _isSoundEnabled.value = enabled
    }

    fun setVolume(volume: Float) {
        _volume.value = volume.coerceIn(0f, 1f)
    }

    fun release() {
        soundPool?.release()
        soundPool = null
        soundIds.clear()
    }
}

enum class SoundType {
    CORRECT_MOVE,
    INCORRECT_MOVE,
    LEVEL_COMPLETE,
    BUTTON_CLICK,
    UNLOCK,
    LOCK,
    TRANSITION,
    HINT,
    STAR_EARNED
}

