package com.example.neuronest.Arithematic

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.neuronest.R
import com.example.neuronest.puzzlelevels.LevelCompleteDialog
import com.example.neuronest.puzzlelevels.LevelProgressBar
import com.example.neuronest.puzzlelevels.PuzzleTimer
import kotlinx.coroutines.delay

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ArithmeticPuzzleScreen(
    onBack: () -> Unit = {},
    level: Int = 1,
    onNextLevel: (Int) -> Unit = {},
    onReplay: () -> Unit = {},
    onGoToGrid: () -> Unit = {}
) {
    val viewModel: ArithmeticViewModel = hiltViewModel()

    // Load level when screen opens
    LaunchedEffect(level) {
        viewModel.loadLevel(level)
    }

    val currentLevel by viewModel.currentLevel.collectAsState()
    val score by viewModel.score.collectAsState()
    val currentProblem by viewModel.currentProblem.collectAsState()
    val userAnswer by viewModel.userAnswer.collectAsState()
    val feedback by viewModel.feedback.collectAsState()
    val isCorrect by viewModel.isCorrect.collectAsState()
    val showLevelComplete by viewModel.showLevelCompleteDialog.collectAsState()
    val starsEarned by viewModel.starsEarned.collectAsState()
    val isTimerRunning by viewModel.isTimerRunning.collectAsState()
    val elapsedTime by viewModel.elapsedTimeMs.collectAsState()
    val levelProgress by viewModel.levelProgress.collectAsState()

    var isContentLoaded by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        delay(300)
        isContentLoaded = true
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "Arithmetic Puzzle - Level $currentLevel",
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
                    // Timer display
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
                    .padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(24.dp)
            ) {
                // Level progress bar
                LevelProgressBar(
                    progress = levelProgress,
                    problemsRemaining = viewModel.getProblemsRemaining(),
                    modifier = Modifier.padding(bottom = 8.dp)
                )

                // Score display with beautiful styling
                ScoreDisplay(score = score, isContentLoaded = isContentLoaded)

                // Problem display with golden card
                ProblemDisplay(
                    problem = currentProblem,
                    isContentLoaded = isContentLoaded
                )

                // Feedback message
                if (feedback.isNotEmpty()) {
                    FeedbackMessage(
                        feedback = feedback,
                        isCorrect = isCorrect ?: false,
                        isContentLoaded = isContentLoaded
                    )
                }

                // Answer input with beautiful styling
                AnswerInput(
                    value = userAnswer,
                    onValueChange = { digit ->
                        viewModel.setUserAnswer(digit)
                    },
                    isContentLoaded = isContentLoaded
                )

                // Number pad
                NumberPad(
                    onNumberClick = { number ->
                        viewModel.setUserAnswer(number.toString())
                    },
                    onBackspace = {
                        viewModel.setUserAnswer("BACK")
                    },
                    onClear = {
                        viewModel.setUserAnswer("")
                    }
                )

                // Action buttons
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

    // Level complete dialog with all navigation options
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
fun NumberPad(
    onNumberClick: (Int) -> Unit,
    onBackspace: () -> Unit,
    onClear: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        // Row 1: 1, 2, 3
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            for (i in 1..3) {
                NumberButton(
                    number = i,
                    onClick = { onNumberClick(i) },
                    modifier = Modifier.weight(1f)
                )
            }
        }

        // Row 2: 4, 5, 6
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            for (i in 4..6) {
                NumberButton(
                    number = i,
                    onClick = { onNumberClick(i) },
                    modifier = Modifier.weight(1f)
                )
            }
        }

        // Row 3: 7, 8, 9
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            for (i in 7..9) {
                NumberButton(
                    number = i,
                    onClick = { onNumberClick(i) },
                    modifier = Modifier.weight(1f)
                )
            }
        }

        // Row 4: Clear, 0, Backspace
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Button(
                onClick = onClear,
                modifier = Modifier
                    .weight(1f)
                    .height(56.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF4A2C1D)
                )
            ) {
                Text("C", fontWeight = FontWeight.Bold, fontSize = 18.sp)
            }

            NumberButton(
                number = 0,
                onClick = { onNumberClick(0) },
                modifier = Modifier.weight(1f)
            )

            Button(
                onClick = onBackspace,
                modifier = Modifier
                    .weight(1f)
                    .height(56.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF4A2C1D)
                )
            ) {
                Text("⌫", fontSize = 24.sp)
            }
        }
    }
}

@Composable
fun NumberButton(
    number: Int,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        modifier = modifier.height(56.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF2C1810)
        ),
        shape = RoundedCornerShape(12.dp)
    ) {
        Text(
            text = number.toString(),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
    }
}

@Composable
fun ScoreDisplay(score: Int, isContentLoaded: Boolean) {
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
fun ProblemDisplay(problem: String, isContentLoaded: Boolean) {
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
        ) {
            Text(
                text = problem,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(32.dp),
                fontSize = 36.sp,
                fontWeight = FontWeight.ExtraBold,
                textAlign = TextAlign.Center,
                color = Color(0xFFFFD700)
            )
        }
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
fun AnswerInput(
    value: String,
    onValueChange: (String) -> Unit,
    isContentLoaded: Boolean
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .scale(
                animateFloatAsState(
                    targetValue = if (isContentLoaded) 1f else 0.9f,
                    animationSpec = tween(durationMillis = 600, delayMillis = 150), label = ""
                ).value
            )
            .background(
                color = Color(0xFF2C1810),
                shape = RoundedCornerShape(16.dp)
            )
            .border(
                width = 3.dp,
                color = Color(0xFFD4AF37),
                shape = RoundedCornerShape(16.dp)
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = if (value.isEmpty()) "Enter answer..." else value,
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = if (value.isEmpty()) Color.Gray else Color.White,
            textAlign = TextAlign.Center
        )
    }
}

