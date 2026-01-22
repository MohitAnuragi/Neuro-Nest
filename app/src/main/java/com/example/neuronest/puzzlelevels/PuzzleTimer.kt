package com.example.neuronest.puzzlelevels

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Timer
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay


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
                delay(1000L)
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


private fun formatTime(timeMs: Long): String {
    val seconds = (timeMs / 1000) % 60
    val minutes = (timeMs / 1000) / 60
    return String.format("%02d:%02d", minutes, seconds)
}

