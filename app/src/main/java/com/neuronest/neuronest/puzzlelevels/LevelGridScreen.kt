package com.neuronest.neuronest.puzzlelevels

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.neuronest.neuronest.R
import com.neuronest.neuronest.sound.SoundManager
import com.neuronest.neuronest.sound.SoundType


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LevelGridScreen(
    puzzleType: String,
    onLevelSelected: (Int) -> Unit,
    onBack: () -> Unit,
    soundManager: SoundManager,
    viewModel: LevelViewModel = hiltViewModel()
) {
    val levels by viewModel.levels.collectAsState()
    val totalStars by viewModel.totalStars.collectAsState()

    LaunchedEffect(puzzleType) {
        viewModel.loadLevels(puzzleType)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "$puzzleType Levels",
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                },
                navigationIcon = {
                    IconButton(onClick = {
                        soundManager.playSound(SoundType.BUTTON_CLICK)
                        onBack()
                    }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back",
                            tint = Color.White
                        )
                    }
                },
                actions = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .padding(end = 16.dp)
                            .background(
                                color = Color(0x40000000),
                                shape = RoundedCornerShape(20.dp)
                            )
                            .padding(horizontal = 12.dp, vertical = 6.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Star,
                            contentDescription = "Stars",
                            tint = Color(0xFFFFD700),
                            modifier = Modifier.size(20.dp)
                        )
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                            text = "$totalStars",
                            style = MaterialTheme.typography.titleMedium,
                            color = Color.White,
                            fontWeight = FontWeight.Bold
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF2C1810),
                    titleContentColor = Color.White,
                    actionIconContentColor = Color.White
                )
            )
        }
    ) { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            Image(
                painter = painterResource(id = R.drawable.wood_texture),
                contentDescription = "Wood background",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )

            LazyVerticalGrid(
                columns = GridCells.Fixed(5),
                contentPadding = PaddingValues(16.dp),
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(levels) { level ->
                    LevelItem(level = level, onClick = {
                        if (level.isUnlocked) {
                            soundManager.playSound(SoundType.BUTTON_CLICK)
                            onLevelSelected(level.levelNumber)
                        }
                    })
                }
            }
        }
    }
}

@Composable
fun LevelItem(
    level: LevelDetails,
    onClick: () -> Unit
) {
    val backgroundGradient = when {
        level.isCompleted -> Brush.linearGradient(
            colors = listOf(Color(0xFF2D5016), Color(0xFF4A7C2F))
        )
        level.isUnlocked -> Brush.linearGradient(
            colors = listOf(Color(0xFF2C1810), Color(0xFF4A2C1D))
        )
        else -> Brush.linearGradient(
            colors = listOf(Color(0xFF3D3D3D), Color(0xFF2A2A2A))
        )
    }

    val borderColor = when {
        level.isCompleted -> Color(0xFF6BBF47)
        level.isUnlocked -> Color(0xFFFFD700)
        else -> Color(0xFF666666)
    }

    val textColor = when {
        level.isCompleted -> Color(0xFFB8E994)
        level.isUnlocked -> Color(0xFFFFD700)
        else -> Color(0xFF888888)
    }

    Box(
        modifier = Modifier
            .aspectRatio(1f)
            .shadow(
                elevation = if (level.isUnlocked) 8.dp else 2.dp,
                shape = RoundedCornerShape(16.dp),
                spotColor = if (level.isCompleted) Color(0xFF6BBF47) else Color(0xFFFFD700)
            )
            .clip(RoundedCornerShape(16.dp))
            .background(brush = backgroundGradient)
            .border(
                width = if (level.isUnlocked) 3.dp else 1.dp,
                color = borderColor,
                shape = RoundedCornerShape(16.dp)
            )
            .clickable(enabled = level.isUnlocked, onClick = onClick)
            .padding(8.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            if (level.isUnlocked) {
                Text(
                    text = "${level.levelNumber}",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    color = textColor,
                    fontSize = 20.sp
                )

                if (level.starsEarned > 0) {
                    Spacer(modifier = Modifier.height(4.dp))
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        repeat(3) { index ->
                            Icon(
                                imageVector = Icons.Default.Star,
                                contentDescription = null,
                                tint = if (index < level.starsEarned) Color(0xFFFFD700) else Color(0x40FFFFFF),
                                modifier = Modifier.size(14.dp)
                            )
                        }
                    }
                }
            } else {
                Icon(
                    imageVector = Icons.Default.Lock,
                    contentDescription = "Locked",
                    tint = Color(0xFF888888),
                    modifier = Modifier.size(32.dp)
                )
            }
        }
    }
}
