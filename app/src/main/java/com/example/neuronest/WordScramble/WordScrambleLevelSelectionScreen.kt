package com.example.neuronest.WordScramble

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.neuronest.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WordScrambleLevelSelectionScreen(
    onBack: () -> Unit = {},
    onLevelSelected: (Int) -> Unit = {}
) {
    val viewModel: WordScrambleViewModel = hiltViewModel()
    val maxUnlockedLevel by viewModel.maxUnlockedLevel.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "Select Level - Word Scramble",
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
            Image(
                painter = painterResource(id = R.drawable.wood_texture),
                contentDescription = "Wood background",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )

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
            .clickable(enabled = isUnlocked) { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = level.toString(),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = textColor
        )
    }
}

