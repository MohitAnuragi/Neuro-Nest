package com.example.neuronest.Arithematic

import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.widget.Toast
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.MusicNote
import androidx.compose.material.icons.filled.MusicOff
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.neuronest.R



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ArithmeticLevelSelectionScreen(
    onBack: () -> Unit = {},
    onLevelSelected: (Int) -> Unit = {}
) {
    val viewModel: ArithmeticViewModel = hiltViewModel()
    val maxUnlockedLevel by viewModel.maxUnlockedLevel.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "Select Level - Arithmetic",
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back",
                            tint = Color.White
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF2C1810)
                )
            )
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            // Background
            Image(
                painter = painterResource(id = R.drawable.wood_texture),
                contentDescription = "Wood background",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )

            // Level Grid
            LevelGrid(
                maxUnlockedLevel = maxUnlockedLevel,
                onLevelSelected = onLevelSelected,
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}

@Composable
fun LevelGrid(
    maxUnlockedLevel: Int,
    onLevelSelected: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    val totalLevels = 500
    val levelsPerRow = 5

    LazyVerticalGrid(
        columns = GridCells.Fixed(levelsPerRow),
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(totalLevels) { index ->
            val level = index + 1
            LevelButton(
                level = level,
                isUnlocked = level <= maxUnlockedLevel,
                onClick = { onLevelSelected(level) }
            )
        }
    }
}

@Composable
fun LevelButton(
    level: Int,
    isUnlocked: Boolean,
    onClick: () -> Unit
) {
    val buttonColor = if (isUnlocked) {
        Color(0xFFD4AF37)
    } else {
        Color(0xFF666666)
    }

    val textColor = if (isUnlocked) {
        Color(0xFF2C1810)
    } else {
        Color(0xFF999999)
    }

    Box(
        modifier = Modifier
            .aspectRatio(1f)
            .background(
                color = buttonColor,
                shape = RoundedCornerShape(12.dp)
            )
            .border(
                width = 2.dp,
                color = if (isUnlocked) Color(0xFFFFD700) else Color(0xFF444444),
                shape = RoundedCornerShape(12.dp)
            )
            .clickable(
                enabled = isUnlocked,
                onClick = onClick
            ),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "$level",
                color = textColor,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )

            if (!isUnlocked) {
                Icon(
                    painter = painterResource(id = android.R.drawable.ic_menu_view),
                    contentDescription = "Locked",
                    tint = textColor,
                    modifier = Modifier.size(16.dp)
                )
            }
        }
    }
}

@Composable
fun LevelDisplay(
    currentLevel: Int,
    levelProgress: Float,
    isContentLoaded: Boolean
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .scale(animateFloatAsState(
                targetValue = if (isContentLoaded) 1f else 0.8f,
                animationSpec = androidx.compose.animation.core.tween(durationMillis = 400)
            ).value),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF2C1810)
        )
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Level $currentLevel",
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Progress bar
            LinearProgressIndicator(
                progress = levelProgress,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(8.dp),
                color = Color(0xFFD4AF37),
                trackColor = Color(0xFF555555)
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = "${(levelProgress * 100).toInt()}% Complete",
                color = Color(0xFFD4AF37),
                fontSize = 12.sp
            )
        }
    }
}