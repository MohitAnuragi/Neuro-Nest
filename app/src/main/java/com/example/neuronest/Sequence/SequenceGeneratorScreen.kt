package com.example.neuronest.Sequence

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Lightbulb
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.neuronest.R
import com.example.neuronest.WordScramble.ScoreDisplay
import com.example.neuronest.puzzlelevels.LevelCompleteDialog
import com.example.neuronest.puzzlelevels.LevelProgressBar
import com.example.neuronest.puzzlelevels.PuzzleTimer
import kotlinx.coroutines.delay

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SequenceGeneratorScreen(
    onBack: () -> Unit = {},
    level: Int = 1,
    onNextLevel: (Int) -> Unit = {},
    onReplay: () -> Unit = {},
    onGoToGrid: () -> Unit = {}
) {
    val viewModel: SequenceGeneratorViewModel = hiltViewModel()

    LaunchedEffect(level) {
        viewModel.loadLevel(level)
    }

    val currentLevel by viewModel.currentLevel.collectAsState()
    val score by viewModel.score.collectAsState()
    val sequenceNumbers by viewModel.sequenceNumbers.collectAsState()
    val userAnswer by viewModel.userAnswer.collectAsState()
    val feedback by viewModel.feedback.collectAsState()
    val isCorrect by viewModel.isCorrect.collectAsState()
    val hint by viewModel.hint.collectAsState()
    val showLevelComplete by viewModel.showLevelCompleteDialog.collectAsState()
    val starsEarned by viewModel.starsEarned.collectAsState()
    val isTimerRunning by viewModel.isTimerRunning.collectAsState()
    val elapsedTime by viewModel.elapsedTimeMs.collectAsState()
    val levelProgress by viewModel.levelProgress.collectAsState()

    var isContentLoaded by remember { mutableStateOf(false) }
    val scrollState = rememberScrollState()

    LaunchedEffect(Unit) {
        delay(300)
        isContentLoaded = true
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "Sequence Generator - Level $currentLevel",
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
//                    IconButton(onClick = { viewModel.showHint() }) {
//                        Icon(
//                            imageVector = Icons.Default.Lightbulb,
//                            contentDescription = "Hint",
//                            tint = Color(0xFFFFD700)
//                        )
//                    }
                    PuzzleTimer(
                        isRunning = isTimerRunning,
                        onTimeUpdate = { timeMs ->
                            viewModel.updateElapsedTime(timeMs)
                        }
                    )
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
            Image(
                painter = painterResource(id = R.drawable.wood_texture),
                contentDescription = "Wood background",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(scrollState)
                    .padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(24.dp)
            ) {
                LevelProgressBar(
                    progress = levelProgress,
                    problemsRemaining = viewModel.getProblemsRemaining(),
                    modifier = Modifier.padding(bottom = 8.dp)
                )

                ScoreDisplay(score = score, isContentLoaded = isContentLoaded)

                Text(
                    text = "What's the next number?",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )

                SequenceDisplay(
                    sequence = sequenceNumbers,
                    isContentLoaded = isContentLoaded
                )

                if (hint.isNotEmpty()) {
                    HintDisplay(hint = hint, isContentLoaded = isContentLoaded)
                }

                if (feedback.isNotEmpty()) {
                    FeedbackMessage(
                        feedback = feedback,
                        isCorrect = isCorrect ?: false,
                        isContentLoaded = isContentLoaded
                    )
                }

                SequenceGeneratorAnswerInput(
                    value = userAnswer,
                    onValueChange = { viewModel.setUserAnswer(it) },
                    isContentLoaded = isContentLoaded
                )


                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    OutlinedButton(
                        onClick = { viewModel.skipProblem() },
                        modifier = Modifier
                            .weight(1f)
                            .height(56.dp),
                        colors = ButtonDefaults.outlinedButtonColors(
                            contentColor = Color(0xFFD4AF37)
                        )
                    ) {
                        Text("SKIP", fontWeight = FontWeight.Bold)
                    }

                    Button(
                        onClick = { viewModel.checkAnswer() },
                        enabled = userAnswer.isNotEmpty(),
                        modifier = Modifier
                            .weight(1f)
                            .height(56.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFFD4AF37),
                            contentColor = Color(0xFF2C1810)
                        )
                    ) {
                        Text("SUBMIT", fontWeight = FontWeight.Bold, fontSize = 16.sp)
                    }
                }
            }
        }
    }

    if (showLevelComplete) {
        LevelCompleteDialog(
            level = currentLevel,
            stars = starsEarned,
            score = score,
            timeTakenMs = elapsedTime,
            isNewBestTime = viewModel.isNewBestTime(),
            onDismiss = { viewModel.dismissLevelCompleteDialog() },
            onNextLevel = {
                viewModel.dismissLevelCompleteDialog()
                val nextLevel = currentLevel + 1
                if (nextLevel <= 500) {
                    onNextLevel(nextLevel)
                } else {
                    onGoToGrid()
                }
            },
            onReplay = {
                viewModel.dismissLevelCompleteDialog()
                onReplay()
            },
            onGoToGrid = {
                viewModel.dismissLevelCompleteDialog()
                onGoToGrid()
            },
            showNextButton = currentLevel < 500,
            isLastLevel = currentLevel >= 500
        )
    }
}

@Composable
fun SequenceDisplay(sequence: List<Int>, isContentLoaded: Boolean) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .scale(
                animateFloatAsState(
                    targetValue = if (isContentLoaded) 1f else 0.9f,
                    animationSpec = tween(durationMillis = 600, delayMillis = 100), label = ""
                ).value
            )
            .shadow(
                elevation = 16.dp,
                shape = RoundedCornerShape(16.dp),
                spotColor = Color(0xFFFFD700)
            ),
        shape = RoundedCornerShape(16.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(Color(0xFF2C1810), Color(0xFF4A2C1D)),
                        tileMode = TileMode.Repeated
                    )
                )
                .padding(24.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp, Alignment.CenterHorizontally)
            ) {
                sequence.forEach { num ->
                    Box(
                        modifier = Modifier
                            .size(56.dp)
                            .background(
                                color = Color(0xFF4A2C1D),
                                shape = RoundedCornerShape(12.dp)
                            )
                            .border(
                                width = 2.dp,
                                color = Color(0xFF6A4C3D),
                                shape = RoundedCornerShape(12.dp)
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = num.toString(),
                            fontSize = 24.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = Color(0xFFFFD700)
                        )
                    }
                }
                // Question mark box for next number
                Box(
                    modifier = Modifier
                        .size(56.dp)
                        .background(
                            color = Color(0xFFD4AF37),
                            shape = RoundedCornerShape(12.dp)
                        )
                        .border(
                            width = 2.dp,
                            color = Color(0xFFFFD700),
                            shape = RoundedCornerShape(12.dp)
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "?",
                        fontSize = 32.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color(0xFF2C1810)
                    )
                }
            }
        }
    }
}

@Composable
fun HintDisplay(hint: String, isContentLoaded: Boolean) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .scale(
                animateFloatAsState(
                    targetValue = if (isContentLoaded) 1f else 0.8f,
                    animationSpec = tween(durationMillis = 600, delayMillis = 150), label = ""
                ).value
            )
            .background(
                color = Color(0x55FFD700),
                shape = RoundedCornerShape(12.dp)
            )
            .border(
                width = 2.dp,
                color = Color(0xFFFFD700),
                shape = RoundedCornerShape(12.dp)
            )
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = hint,
            color = Color.White,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
    }
}


@Composable
fun SequenceGeneratorScoreDisplay(score: Int, isContentLoaded: Boolean) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .scale(
                animateFloatAsState(
                    targetValue = if (isContentLoaded) 1f else 0.8f,
                    animationSpec = tween(durationMillis = 600), label = ""
                ).value
            )
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
fun FeedbackMessage(feedback: String, isCorrect: Boolean, isContentLoaded: Boolean) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .scale(
                animateFloatAsState(
                    targetValue = if (isContentLoaded) 1f else 0.8f,
                    animationSpec = tween(durationMillis = 600, delayMillis = 200), label = ""
                ).value
            )
            .background(
                color = if (isCorrect) Color(0x5510B981) else Color(0x55EF4444),
                shape = RoundedCornerShape(12.dp)
            )
            .border(
                width = 2.dp,
                color = if (isCorrect) Color(0xFF10B981) else Color(0xFFEF4444),
                shape = RoundedCornerShape(12.dp)
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = feedback,
            color = Color.White,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun SequenceGeneratorAnswerInput(
    value: String,
    onValueChange: (String) -> Unit,
    isContentLoaded: Boolean
) {
    OutlinedTextField(
        value = value,
        onValueChange = { newValue ->
            // Only allow numbers and negative sign
            if (newValue.isEmpty() || newValue.matches(Regex("^-?\\d*$"))) {
                onValueChange(newValue)
            }
        },
        modifier = Modifier
            .fillMaxWidth()
            .scale(
                animateFloatAsState(
                    targetValue = if (isContentLoaded) 1f else 0.9f,
                    animationSpec = tween(durationMillis = 600, delayMillis = 150), label = ""
                ).value
            ),
        label = {
            Text(
                "Enter Answer",
                color = Color(0xFFD4AF37)
            )
        },
        placeholder = {
            Text(
                "Type the next number...",
                color = Color.Gray
            )
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number
        ),
        singleLine = true,
        textStyle = LocalTextStyle.current.copy(
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            textAlign = TextAlign.Center
        ),
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = Color(0xFFD4AF37),
            unfocusedBorderColor = Color(0xFF6A4C3D),
            focusedLabelColor = Color(0xFFD4AF37),
            unfocusedLabelColor = Color(0xFF8A6C5D),
            cursorColor = Color(0xFFD4AF37),
            focusedTextColor = Color.White,
            unfocusedTextColor = Color.White
        ),
        shape = RoundedCornerShape(16.dp)
    )
}

