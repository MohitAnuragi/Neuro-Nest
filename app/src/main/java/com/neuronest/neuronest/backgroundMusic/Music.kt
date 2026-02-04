package com.neuronest.neuronest.backgroundMusic

import android.media.MediaPlayer
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner

@Composable
fun BackgroundMusicPlayer(
    audioResId: Int,
    isMusicPlaying: Boolean
) {
    val context = LocalContext.current

    val mediaPlayer = remember {
        MediaPlayer.create(context, audioResId).apply {
            isLooping = true
        }
    }

    LaunchedEffect(isMusicPlaying) {
        if (isMusicPlaying) {
            mediaPlayer.start()
        } else {
            mediaPlayer.pause()
        }
    }

    DisposableEffect(Unit) {
        val lifecycleObserver = LifecycleEventObserver { _: LifecycleOwner, event: Lifecycle.Event ->
            when (event) {
                Lifecycle.Event.ON_RESUME -> if (isMusicPlaying) mediaPlayer.start()
                Lifecycle.Event.ON_PAUSE -> mediaPlayer.pause()
                else -> {}
            }
        }
        val lifecycleOwner = context as? LifecycleOwner
        lifecycleOwner?.lifecycle?.addObserver(lifecycleObserver)

        onDispose {
            mediaPlayer.stop()
            mediaPlayer.release()
            lifecycleOwner?.lifecycle?.removeObserver(lifecycleObserver)
        }
    }
}