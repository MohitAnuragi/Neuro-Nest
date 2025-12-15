package com.example.neuronest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.neuronest.navigation.PuzzleNavigation
import com.example.neuronest.puzzlelevels.LevelManager
import com.example.neuronest.ui.theme.NeuroNestTheme
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

