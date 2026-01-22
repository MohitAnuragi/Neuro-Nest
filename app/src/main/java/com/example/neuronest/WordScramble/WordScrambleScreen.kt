package com.example.neuronest.WordScramble

import android.R.attr.hint
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
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
import com.example.neuronest.Sequence.HintDisplay
import com.example.neuronest.puzzlelevels.LevelCompleteDialog
import com.example.neuronest.puzzlelevels.LevelDataStoreManager
import com.example.neuronest.puzzlelevels.LevelProgressBar
import com.example.neuronest.puzzlelevels.PuzzleTimer
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

data class LetterItem(
    val letter: Char,
    val id: Int,
    val isUsed: Boolean = false
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WordScrambleScreen(
    onBack: () -> Unit = {},
    level: Int = 1,
    onNextLevel: (Int) -> Unit = {},
    onReplay: () -> Unit = {},
    onGoToGrid: () -> Unit = {}
) {
    val viewModel: WordScrambleViewModel = hiltViewModel()
    val context = androidx.compose.ui.platform.LocalContext.current
    val dataStoreManager = remember { LevelDataStoreManager(context) }
    val coroutineScope = rememberCoroutineScope()

    // Tutorial state
    val isTutorialCompleted by dataStoreManager.isTutorialCompletedFlow("WordScramble").collectAsState(initial = true)
    var showTutorial by remember { mutableStateOf(false) }

    // Show tutorial only on first launch and level 1
    LaunchedEffect(level, isTutorialCompleted) {
        if (level == 1 && !isTutorialCompleted) {
            delay(500) // Brief delay before showing tutorial
            showTutorial = true
        }
    }

    LaunchedEffect(level) {
        viewModel.loadLevel(level)
    }

    val currentLevel by viewModel.currentLevel.collectAsState()
    val score by viewModel.score.collectAsState()
    val currentWord by viewModel.currentWord.collectAsState()
    val scrambledWord by viewModel.scrambledWord.collectAsState()
    val userAnswer by viewModel.userAnswer.collectAsState()
    val feedback by viewModel.feedback.collectAsState()
    val isCorrect by viewModel.isCorrect.collectAsState()
    val showLevelComplete by viewModel.showLevelCompleteDialog.collectAsState()
    val starsEarned by viewModel.starsEarned.collectAsState()
    val isTimerRunning by viewModel.isTimerRunning.collectAsState()
    val elapsedTime by viewModel.elapsedTimeMs.collectAsState()
    val levelProgress by viewModel.levelProgress.collectAsState()
    val hint by viewModel.hint.collectAsState()



    // Letter state management
    var letterItems by remember { mutableStateOf<List<LetterItem>>(emptyList()) }
    var usedLetterIds by remember { mutableStateOf<List<Int>>(emptyList()) }

    // Update letter items when scrambled word changes
    LaunchedEffect(scrambledWord) {
        letterItems = scrambledWord.mapIndexed { index, char ->
            LetterItem(letter = char, id = index, isUsed = false)
        }
        usedLetterIds = emptyList()
        viewModel.clearAnswer()
    }

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
                        "Word Scramble",
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
                    .padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(24.dp)
            ) {
                LevelProgressBar(
                    progress = levelProgress,
                    problemsRemaining = viewModel.getProblemsRemaining(),
                    modifier = Modifier.padding(bottom = 8.dp)
                )

                ScoreDisplay(currentLevel = currentLevel, isContentLoaded = isContentLoaded)

                Text(
                    text = "Unscramble the word:",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )

                ScrambledWordDisplay(
                    scrambledWord = scrambledWord,
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

                AnswerInputDisplay(
                    value = userAnswer,
                    isContentLoaded = isContentLoaded
                )

                LetterButtons(
                    letterItems = letterItems,
                    onLetterClick = { letterId ->
                        val letter = letterItems.find { it.id == letterId }?.letter
                        if (letter != null) {
                            viewModel.addLetter(letter)
                            usedLetterIds = usedLetterIds + letterId
                            letterItems = letterItems.map {
                                if (it.id == letterId) it.copy(isUsed = true) else it
                            }
                        }
                    }
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    OutlinedButton(
                        onClick = {
                            viewModel.clearAnswer()
                            // Reset all letters to unused
                            letterItems = letterItems.map { it.copy(isUsed = false) }
                            usedLetterIds = emptyList()
                        },
                        modifier = Modifier
                            .weight(1f)
                            .height(56.dp),
                        colors = ButtonDefaults.outlinedButtonColors(
                            contentColor = Color(0xFFD4AF37)
                        )
                    ) {
                        Text("CLEAR", fontWeight = FontWeight.Bold)
                    }

                    OutlinedButton(
                        onClick = {
                            if (usedLetterIds.isNotEmpty()) {
                                viewModel.removeLetter()
                                // Restore the last used letter
                                val lastUsedId = usedLetterIds.last()
                                letterItems = letterItems.map {
                                    if (it.id == lastUsedId) it.copy(isUsed = false) else it
                                }
                                usedLetterIds = usedLetterIds.dropLast(1)
                            }
                        },
                        modifier = Modifier
                            .weight(1f)
                            .height(56.dp),
                        colors = ButtonDefaults.outlinedButtonColors(
                            contentColor = Color(0xFFD4AF37)
                        )
                    ) {
                        Text("⌫", fontSize = 24.sp)
                    }
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    OutlinedButton(
                        onClick = { viewModel.showHint() },
                        modifier = Modifier
                            .weight(1f)
                            .height(56.dp),
                        colors = ButtonDefaults.outlinedButtonColors(
                            contentColor = Color(0xFFD4AF37)
                        )
                    ) {
                        Text("HINT", fontWeight = FontWeight.Bold)
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

    // Tutorial overlay
    if (showTutorial) {
        HowToPlayWordScrambleOverlay(
            onDismiss = {
                showTutorial = false
                coroutineScope.launch {
                    dataStoreManager.saveTutorialCompleted("WordScramble")
                }
            },
            onPlaySound = {
                viewModel.playSoundEffect(com.example.neuronest.sound.SoundType.BUTTON_CLICK)
            }
        )
    }
}

@Composable
fun ScrambledWordDisplay(scrambledWord: String, isContentLoaded: Boolean) {
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
                text = scrambledWord,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(32.dp),
                fontSize = 36.sp,
                fontWeight = FontWeight.ExtraBold,
                textAlign = TextAlign.Center,
                color = Color(0xFFFFD700),
                letterSpacing = 4.sp
            )
        }
    }
}

@Composable
fun LetterButtons(
    letterItems: List<LetterItem>,
    onLetterClick: (Int) -> Unit
) {
    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally),
        contentPadding = PaddingValues(horizontal = 4.dp)
    ) {
        items(letterItems, key = { it.id }) { letterItem ->
            Button(
                onClick = { onLetterClick(letterItem.id) },
                enabled = !letterItem.isUsed,
                modifier = Modifier
                    .size(56.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (letterItem.isUsed) Color(0xFF666666) else Color(0xFF2C1810),
                    disabledContainerColor = Color(0xFF666666)
                ),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text(
                    text = letterItem.letter.toString(),
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = if (letterItem.isUsed) Color(0xFF999999) else Color.White
                )
            }
        }
    }
}

@Composable
fun ScoreDisplay(currentLevel: Int, isContentLoaded: Boolean) {
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
            text = "Level: $currentLevel",
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
fun AnswerInputDisplay(
    value: String,
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
            text = if (value.isEmpty()) "Your answer..." else value,
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = if (value.isEmpty()) Color.Gray else Color.White,
            textAlign = TextAlign.Center,
            letterSpacing = 2.sp
        )
    }
}

