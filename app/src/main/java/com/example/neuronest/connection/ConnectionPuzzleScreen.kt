package com.example.neuronest.connection

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Lightbulb
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.neuronest.R
import com.example.neuronest.puzzlelevels.LevelCompleteDialog
import com.example.neuronest.puzzlelevels.LevelProgressBar
import com.example.neuronest.puzzlelevels.PuzzleTimer
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

private val android.content.Context.connectionTutorialDataStore by preferencesDataStore(name = "connection_tutorial_prefs")
private val TUTORIAL_COMPLETED_KEY = booleanPreferencesKey("connection_tutorial_completed")

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ConnectionPuzzleScreen(
    onBack: () -> Unit = {},
    level: Int = 1,
    onNextLevel: (Int) -> Unit = {},
    onReplay: () -> Unit = {},
    onGoToGrid: () -> Unit = {}
) {
    val viewModel: ConnectionPuzzleViewModel = hiltViewModel()
    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()

    // Tutorial state
    var showTutorial by remember { mutableStateOf(false) }
    var tutorialCheckDone by remember { mutableStateOf(false) }

    // Check if tutorial was already shown
    LaunchedEffect(Unit) {
        val tutorialCompleted = context.connectionTutorialDataStore.data.map { prefs ->
            prefs[TUTORIAL_COMPLETED_KEY] ?: false
        }.first()

        if (!tutorialCompleted && level == 1) {
            showTutorial = true
        }
        tutorialCheckDone = true
    }

    LaunchedEffect(level) {
        viewModel.loadLevel(level)
    }

    val currentLevel by viewModel.currentLevel.collectAsState()
    val score by viewModel.score.collectAsState()
    val availableWords by viewModel.availableWords.collectAsState()
    val selectedWords by viewModel.selectedWords.collectAsState()
    val solvedCategories by viewModel.solvedCategories.collectAsState()
    val feedback by viewModel.feedback.collectAsState()
    val isCorrect by viewModel.isCorrect.collectAsState()
    val mistakesRemaining by viewModel.mistakesRemaining.collectAsState()
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
                        "Connections Puzzle",
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
                    IconButton(onClick = { viewModel.showHint() }) {
                        Icon(
                            imageVector = Icons.Default.Lightbulb,
                            contentDescription = "Hint",
                            tint = Color(0xFFFFD700)
                        )
                    }
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
                    .verticalScroll(rememberScrollState())
                    .padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                LevelProgressBar(
                    progress = levelProgress,
                    problemsRemaining = viewModel.getProblemsRemaining(),
                    modifier = Modifier.padding(bottom = 8.dp)
                )

                ConnectionScoreDisplay(
                    currentLevel = currentLevel,
                    mistakes = mistakesRemaining,
                    isContentLoaded = isContentLoaded
                )

                if (feedback.isNotEmpty()) {
                    ConnectionFeedback(
                        feedback = feedback,
                        isCorrect = isCorrect ?: false,
                        isContentLoaded = isContentLoaded
                    )
                }

                // Solved Categories
                solvedCategories.forEach { category ->
                    SolvedCategoryDisplay(category = category)
                }

                // Available Words Grid
                if (availableWords.isNotEmpty()) {
                    LazyVerticalGrid(
                        columns = GridCells.Fixed(4),
                        modifier = Modifier
                            .fillMaxWidth()
                            .heightIn(max = 400.dp),
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        items(availableWords) { word ->
                            WordCard(
                                word = word,
                                isSelected = word in selectedWords,
                                onClick = { viewModel.toggleWordSelection(word) }
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(8.dp))

                // Action buttons
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    OutlinedButton(
                        onClick = { viewModel.deselectAll() },
                        modifier = Modifier
                            .weight(1f)
                            .height(56.dp),
                        colors = ButtonDefaults.outlinedButtonColors(
                            contentColor = Color(0xFFD4AF37)
                        ),
                        shape = RoundedCornerShape(12.dp),
                        enabled = selectedWords.isNotEmpty()
                    ) {
                        Text("CLEAR", fontWeight = FontWeight.Bold)
                    }

                    OutlinedButton(
                        onClick = { viewModel.skipPuzzle() },
                        modifier = Modifier
                            .weight(1f)
                            .height(56.dp),
                        colors = ButtonDefaults.outlinedButtonColors(
                            contentColor = Color(0xFFD4AF37)
                        ),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Text("SKIP", fontWeight = FontWeight.Bold)
                    }

                    Button(
                        onClick = { viewModel.submitGuess() },
                        enabled = selectedWords.size == 4,
                        modifier = Modifier
                            .weight(1f)
                            .height(56.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFFD4AF37),
                            contentColor = Color(0xFF2C1810)
                        ),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Text("SUBMIT", fontWeight = FontWeight.Bold)
                    }
                }
//                Button(
//                    onClick = {  },
//                    enabled = selectedWords.size == 4,
//                    modifier = Modifier
//                        .weight(1f)
//                        .height(56.dp),
//                    colors = ButtonDefaults.buttonColors(
//                        containerColor = Color(0xFFD4AF37),
//                        contentColor = Color(0xFF2C1810)
//                    ),
//                    shape = RoundedCornerShape(12.dp)
//                ) {
//                    Text("HOW TO PLAY", fontWeight = FontWeight.Bold)
//                }
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

    // Show tutorial overlay if first time playing
    if (showTutorial && tutorialCheckDone) {
        ConnectionsTutorialOverlay(
            soundManager = viewModel.soundManager,
            onDismiss = {
                showTutorial = false
                // Mark tutorial as completed
                coroutineScope.launch {
                    context.connectionTutorialDataStore.edit { prefs ->
                        prefs[TUTORIAL_COMPLETED_KEY] = true
                    }
                }
            }
        )
    }
}

@Composable
fun WordCard(
    word: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .aspectRatio(1f)
            .background(
                color = if (isSelected) Color(0xFFD4AF37) else Color(0xFF2C1810),
                shape = RoundedCornerShape(12.dp)
            )
            .border(
                width = 2.dp,
                color = if (isSelected) Color(0xFFFFD700) else Color(0xFF6A4C3D),
                shape = RoundedCornerShape(12.dp)
            )
            .clickable(onClick = onClick),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = word,
            color = if (isSelected) Color(0xFF2C1810) else Color.White,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(4.dp)
        )
    }
}

@Composable
fun SolvedCategoryDisplay(category: ConnectionCategory) {
    val bgColor = when (category.color) {
        CategoryColor.YELLOW -> Color(0xFFF9DF6D)
        CategoryColor.GREEN -> Color(0xFFA0C35A)
        CategoryColor.BLUE -> Color(0xFFB0C4EF)
        CategoryColor.PURPLE -> Color(0xFFBA81C5)
    }

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(bgColor)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = category.name.uppercase(),
                fontSize = 14.sp,
                fontWeight = FontWeight.ExtraBold,
                color = Color(0xFF2C1810)
            )
            Text(
                text = category.words.joinToString(", "),
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF2C1810),
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
fun ConnectionScoreDisplay(currentLevel: Int, mistakes: Int, isContentLoaded: Boolean) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Box(
            modifier = Modifier
                .weight(1f)
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
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Box(
            modifier = Modifier
                .weight(1f)
                .height(60.dp)
                .scale(
                    animateFloatAsState(
                        targetValue = if (isContentLoaded) 1f else 0.8f,
                        animationSpec = tween(durationMillis = 600), label = ""
                    ).value
                )
                .background(
                    color = if (mistakes > 0) Color(0xFF2C1810) else Color(0x55FF4444),
                    shape = RoundedCornerShape(12.dp)
                )
                .border(
                    width = 2.dp,
                    color = if (mistakes > 0) Color(0xFFD4AF37) else Color(0xFFFF4444),
                    shape = RoundedCornerShape(12.dp)
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Mistakes: $mistakes",
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
fun ConnectionFeedback(feedback: String, isCorrect: Boolean, isContentLoaded: Boolean) {
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
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

