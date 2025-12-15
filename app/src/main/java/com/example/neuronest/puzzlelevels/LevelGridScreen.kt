package com.example.neuronest.puzzlelevels

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LevelGridScreen(
    puzzleType: String,
    onLevelSelected: (Int) -> Unit,
    onBack: () -> Unit,
    viewModel: LevelViewModel = hiltViewModel()
) {
    val levels by viewModel.levels.collectAsState()
    val totalStars by viewModel.totalStars.collectAsState()

    // Always refresh levels when this screen becomes active
    // This ensures UI updates after completing a level
    LaunchedEffect(puzzleType) {
        viewModel.loadLevels(puzzleType)
    }


    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("$puzzleType Levels") },
                navigationIcon = {
                    // Back button logic here if needed, or handled by scaffold
                },
                actions = {
                    Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(end = 16.dp)) {
                        Icon(Icons.Default.Star, contentDescription = "Stars", tint = Color(0xFFFFD700))
                        Spacer(modifier = Modifier.width(4.dp))
                        Text("$totalStars", style = MaterialTheme.typography.titleMedium)
                    }
                }
            )
        }
    ) { padding ->
        LazyVerticalGrid(
            columns = GridCells.Fixed(5),
            contentPadding = PaddingValues(16.dp),
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(levels) { level ->
                LevelItem(level = level, onClick = {
                    if (level.isUnlocked) {
                        onLevelSelected(level.levelNumber)
                    }
                })
            }
        }
    }
}

@Composable
fun LevelItem(
    level: LevelDetails,
    onClick: () -> Unit
) {
    val backgroundColor = if (level.isUnlocked) {
        if (level.isCompleted) MaterialTheme.colorScheme.primaryContainer else MaterialTheme.colorScheme.surfaceVariant
    } else {
        MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f)
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .clip(RoundedCornerShape(12.dp))
            .background(backgroundColor)
            .clickable(enabled = level.isUnlocked, onClick = onClick)
            .padding(8.dp)
            .aspectRatio(1f), // Square items
        verticalArrangement = Arrangement.Center
    ) {
        if (level.isUnlocked) {
            Text(
                text = "${level.levelNumber}",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                color = if (level.isCompleted) MaterialTheme.colorScheme.onPrimaryContainer else MaterialTheme.colorScheme.onSurfaceVariant
            )
            
            if (level.starsEarned > 0) {
                Row(modifier = Modifier.padding(top = 4.dp)) {
                    repeat(level.starsEarned) {
                        Icon(
                            imageVector = Icons.Default.Star,
                            contentDescription = null,
                            tint = Color(0xFFFFD700),
                            modifier = Modifier.size(12.dp)
                        )
                    }
                }
            }
        } else {
            Icon(
                imageVector = Icons.Default.Lock,
                contentDescription = "Locked",
                tint = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.5f)
            )
        }
    }
}
