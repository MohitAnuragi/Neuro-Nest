package com.example.neuronest.ColorMatching

import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.widget.Toast
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.MusicNote
import androidx.compose.material.icons.filled.MusicOff
import androidx.compose.material.icons.filled.Person
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.neuronest.R
import com.example.neuronest.speech.rememberTextToSpeech
import kotlinx.coroutines.delay

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ColorPuzzleScreen(
    onBack: () -> Unit = {},
    onAnswerChecked: (isCorrect: Boolean) -> Unit = {}

) {
    val viewModel: ColorPuzzleViewModel = hiltViewModel()
    val uiState by viewModel.uiState.collectAsState()
    val (tts, isTtsInitialized) = rememberTextToSpeech()
    val isCorrect by viewModel.isCorrect.collectAsState()
    val context = LocalContext.current

    val ttsParams = remember {
        Bundle().apply {
            putFloat(TextToSpeech.Engine.KEY_PARAM_VOLUME, 1.0f)
        }
    }

    var isContentLoaded by remember { mutableStateOf(false) }
    var showProfileDialog by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        delay(300)
        isContentLoaded = true
    }

    LaunchedEffect(isCorrect) {
        isCorrect?.let { correct ->
            val message = if (correct) {
                "Correct answer! Go to next puzzle"
            } else {
                "Incorrect answer. Try again!"
            }

            tts?.speak(message, TextToSpeech.QUEUE_FLUSH, ttsParams, null) ?: run {
                Toast.makeText(context, "Text-to-Speech not ready.", Toast.LENGTH_SHORT).show()
            }
            onAnswerChecked(correct)
            viewModel.resetIsCorrectFlag()
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "Color Match",
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
                actions = {


                    // Profile icon
                    IconButton(onClick = { showProfileDialog = true }) {
                        Icon(
                            imageVector = Icons.Default.Person,
                            contentDescription = "Profile Stats",
                            tint = Color.White
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
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            // Wood textured background
            Image(
                painter = painterResource(id = R.drawable.wood_texture),
                contentDescription = "Wood background",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(24.dp)
            ) {
                // Score display
                ScoreDisplay(score = uiState.score, isContentLoaded = isContentLoaded)

                // Instructions
                InstructionsText(isContentLoaded = isContentLoaded)

                // Target color display
                TargetColorDisplay(
                    targetColor = uiState.targetColor,
                    isContentLoaded = isContentLoaded
                )

                // Feedback message
                if (uiState.feedback.isNotEmpty()) {
                    FeedbackMessage(
                        feedback = uiState.feedback,
                        isCorrect = uiState.feedback.startsWith("Correct"),
                        isContentLoaded = isContentLoaded
                    )
                }

                // Color options grid
                ColorOptionsGrid(
                    options = uiState.options,
                    onColorSelected = { viewModel.checkAnswer(it) },
                    isContentLoaded = isContentLoaded
                )

                // Next puzzle button
                NextPuzzleButton(
                    isContentLoaded = isContentLoaded,
                    onClick = {
                        viewModel.generateNewPuzzle()
                        tts?.speak("Please match this colour", TextToSpeech.QUEUE_FLUSH, ttsParams, null)
                            ?: run {
                                Toast.makeText(context, "Text-to-Speech not ready.", Toast.LENGTH_SHORT).show()
                            }
                    }
                )
            }
        }

        // Profile Stats Dialog
        if (showProfileDialog) {
            ProfileStatsDialog(
                score = uiState.score,
                totalPuzzlesSolved = uiState.totalPuzzlesSolved,
                onDismiss = { showProfileDialog = false }
            )
        }
    }
}

@Composable
fun ProfileStatsDialog(
    score: Long,
    totalPuzzlesSolved: Int,
    onDismiss: () -> Unit
) {
    Dialog(onDismissRequest = onDismiss) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFF2C1810)
            )
        ) {
            Column(
                modifier = Modifier
                    .padding(24.dp)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                // Title
                Text(
                    text = "Color Puzzle Stats",
                    color = Color(0xFFFFD700),
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold
                )

                // Stats divider
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(2.dp)
                        .background(
                            brush = Brush.linearGradient(
                                colors = listOf(Color(0xFFD4AF37), Color(0xFFFFD700)),
                                tileMode = TileMode.Repeated
                            )
                        )
                )

                // Total Score
                StatItem(
                    title = "Total Score",
                    value = score.toString(),
                    color = Color(0xFF34D399)
                )

                // Puzzles Solved
                StatItem(
                    title = "Puzzles Solved",
                    value = totalPuzzlesSolved.toString(),
                    color = Color(0xFF60A5FA)
                )

                // Close button
                Button(
                    onClick = onDismiss,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFD4AF37),
                        contentColor = Color(0xFF2C1810)
                    ),
                    elevation = ButtonDefaults.buttonElevation(
                        defaultElevation = 8.dp,
                        pressedElevation = 4.dp
                    )
                ) {
                    Text(
                        "CLOSE",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}

@Composable
fun StatItem(title: String, value: String, color: Color) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = title,
            color = Color.White,
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium
        )

        Text(
            text = value,
            color = color,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun ScoreDisplay(score: Long, isContentLoaded: Boolean) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .scale(animateFloatAsState(
                targetValue = if (isContentLoaded) 1f else 0.8f,
                animationSpec = androidx.compose.animation.core.tween(durationMillis = 600)
            ).value)
            .background(
                color = Color(0xFF2C1810),
                shape = RoundedCornerShape(12.dp)
            )
            .border(
                width = 2.dp,
                brush = Brush.linearGradient(
                    colors = listOf(Color(0xFFD4AF37), Color(0xFFFFD700)),
                    tileMode = TileMode.Repeated
                ),
                shape = RoundedCornerShape(12.dp)
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Score: $score",
            color = Color.White,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            letterSpacing = 1.sp
        )
    }
}

@Composable
fun InstructionsText(isContentLoaded: Boolean) {
    Text(
        text = "Match this color:",
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        color = Color.White,
        modifier = Modifier.scale(animateFloatAsState(
            targetValue = if (isContentLoaded) 1f else 0.9f,
            animationSpec = androidx.compose.animation.core.tween(durationMillis = 600, delayMillis = 100)
        ).value)
    )
}

@Composable
fun TargetColorDisplay(targetColor: Color, isContentLoaded: Boolean) {
    Box(
        modifier = Modifier
            .size(150.dp)
            .scale(animateFloatAsState(
                targetValue = if (isContentLoaded) 1f else 0.9f,
                animationSpec = androidx.compose.animation.core.tween(durationMillis = 600, delayMillis = 200)
            ).value)
            .shadow(
                elevation = 16.dp,
                shape = RoundedCornerShape(16.dp),
                spotColor = Color(0xFFFFD700)
            )
            .clip(RoundedCornerShape(16.dp))
            .background(targetColor)
            .border(
                width = 4.dp,
                brush = Brush.linearGradient(
                    colors = listOf(Color(0xFFFFD700), Color(0xFFD4AF37)),
                    tileMode = TileMode.Repeated
                ),
                shape = RoundedCornerShape(16.dp)
            )
    )
}

@Composable
fun FeedbackMessage(feedback: String, isCorrect: Boolean, isContentLoaded: Boolean) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .scale(animateFloatAsState(
                targetValue = if (isContentLoaded) 1f else 0.8f,
                animationSpec = androidx.compose.animation.core.tween(durationMillis = 600, delayMillis = 300)
            ).value)
            .background(
                color = if (isCorrect) Color(0x5510B981) else Color(0x55EF4444),
                shape = RoundedCornerShape(12.dp)
            )
            .border(
                width = 2.dp,
                brush = Brush.linearGradient(
                    colors = if (isCorrect) {
                        listOf(Color(0xFF10B981), Color(0xFF34D399))
                    } else {
                        listOf(Color(0xFFEF4444), Color(0xFFF87171))
                    },
                    tileMode = TileMode.Repeated
                ),
                shape = RoundedCornerShape(12.dp)
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = feedback,
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold,
            color = if (isCorrect) Color(0xFF065F46) else Color(0xFF991B1B)
        )
    }
}

@Composable
fun ColorOptionsGrid(
    options: List<Color>,
    onColorSelected: (Color) -> Unit,
    isContentLoaded: Boolean
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .scale(animateFloatAsState(
                targetValue = if (isContentLoaded) 1f else 0.9f,
                animationSpec = androidx.compose.animation.core.tween(durationMillis = 600, delayMillis = 400)
            ).value),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Select the matching color:",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )

        // Options grid rows
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            options.take(2).forEachIndexed { index, color ->
                ColorOption(
                    color = color,
                    isContentLoaded = isContentLoaded,
                    delay = index * 100,
                    onClick = { onColorSelected(color) }
                )
            }
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            options.drop(2).forEachIndexed { index, color ->
                ColorOption(
                    color = color,
                    isContentLoaded = isContentLoaded,
                    delay = (index + 2) * 100,
                    onClick = { onColorSelected(color) }
                )
            }
        }
    }
}

@Composable
fun ColorOption(
    color: Color,
    isContentLoaded: Boolean,
    delay: Int = 0,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .size(100.dp)
            .scale(animateFloatAsState(
                targetValue = if (isContentLoaded) 1f else 0.8f,
                animationSpec = androidx.compose.animation.core.tween(durationMillis = 400, delayMillis = delay)
            ).value)
            .shadow(
                elevation = 12.dp,
                shape = RoundedCornerShape(16.dp),
                spotColor = Color(0xFFFFD700)
            )
            .clip(RoundedCornerShape(16.dp))
            .background(color)
            .border(
                width = 3.dp,
                brush = Brush.linearGradient(
                    colors = listOf(Color(0xFFFFD700), Color(0xFFD4AF37)),
                    tileMode = TileMode.Repeated
                ),
                shape = RoundedCornerShape(16.dp)
            )
            .clickable(onClick = onClick)
    )
}

@Composable
fun NextPuzzleButton(isContentLoaded: Boolean, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .scale(animateFloatAsState(
                targetValue = if (isContentLoaded) 1f else 0.9f,
                animationSpec = androidx.compose.animation.core.tween(durationMillis = 600, delayMillis = 500)
            ).value),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF2C1810),
            contentColor = Color.White
        ),
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 8.dp,
            pressedElevation = 4.dp
        )
    ) {
        Text(
            "NEXT PUZZLE",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )
    }
}