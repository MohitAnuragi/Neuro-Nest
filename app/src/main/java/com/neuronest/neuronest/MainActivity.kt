package com.neuronest.neuronest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.neuronest.neuronest.navigation.PuzzleNavigation
import com.neuronest.neuronest.puzzlelevels.LevelManager
import com.neuronest.neuronest.ui.theme.NeuroNestTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        LevelManager.initialize(this)
        setContent {
            NeuroNestTheme {

                PuzzleNavigation()
            }
        }
    }
}

