package com.example.neuronest.speech

import android.speech.tts.TextToSpeech
import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import java.util.Locale

@Composable
fun rememberTextToSpeech(): Pair<TextToSpeech?, Boolean> {
    val context = LocalContext.current
    var tts: TextToSpeech? by remember { mutableStateOf(null) }
    var isInitialized by remember { mutableStateOf(false) }

    DisposableEffect(context) {
        val listener = TextToSpeech.OnInitListener { status ->
            if (status == TextToSpeech.SUCCESS) {
                val result = tts?.setLanguage(Locale("hi", "IN")) // Set language to Hindi (India)
                tts?.setSpeechRate(0.9f) // Set speech rate

                if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                    Log.e("TTS", "Text-to-Speech language (hi-IN) not supported.")
                    Toast.makeText(context, "Text-to-Speech language not supported.", Toast.LENGTH_SHORT).show()
                    isInitialized = false
                } else {
                    isInitialized = true
                }
            } else {
                Log.e("TTS", "Text-to-Speech initialization failed: Status $status")
                Toast.makeText(context, "Text-to-Speech initialization failed.", Toast.LENGTH_SHORT).show()
                isInitialized = false
            }
        }
        tts = TextToSpeech(context, listener)

        onDispose {
            tts?.stop()
            tts?.shutdown()
        }
    }
    return tts to isInitialized
}
