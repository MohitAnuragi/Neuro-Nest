package com.example.neuronest.puzzlelevels

import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Timer
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay

/**
 * Timer composable to display elapsed time during puzzle gameplay
 */
@Composable
fun PuzzleTimer(
    isRunning: Boolean,
    modifier: Modifier = Modifier,
    onTimeUpdate: (Long) -> Unit = {}
) {
    var elapsedTime by remember { mutableStateOf(0L) }
    var startTime by remember { mutableStateOf(System.currentTimeMillis()) }

    LaunchedEffect(isRunning) {
        if (isRunning) {
            startTime = System.currentTimeMillis()
            while (isRunning) {
                delay(1000L) // Update every second
                elapsedTime = System.currentTimeMillis() - startTime
                onTimeUpdate(elapsedTime)
            }
        }
    }

    Card(
        modifier = modifier,
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF2C1810)
        ),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Timer,
                contentDescription = "Timer",
                tint = Color(0xFFD4AF37),
                modifier = Modifier.size(20.dp)
            )
            Text(
                text = formatTime(elapsedTime),
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }
    }
}

/**
 * Compact timer for smaller spaces
 */
@Composable
fun CompactTimer(
    elapsedTimeMs: Long,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Icon(
            imageVector = Icons.Default.Timer,
            contentDescription = "Timer",
            tint = Color(0xFFD4AF37),
            modifier = Modifier.size(16.dp)
        )
        Text(
            text = formatTime(elapsedTimeMs),
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium,
            color = Color.White
        )
    }
}

private fun formatTime(timeMs: Long): String {
    val seconds = (timeMs / 1000) % 60
    val minutes = (timeMs / 1000) / 60
    return String.format("%02d:%02d", minutes, seconds)
}

