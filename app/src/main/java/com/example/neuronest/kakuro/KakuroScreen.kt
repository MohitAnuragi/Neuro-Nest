package com.example.neuronest.kakuro

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Lightbulb
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
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
fun KakuroScreen(
    onBack: () -> Unit = {},
    level: Int = 1,
    onNextLevel: (Int) -> Unit = {},
    onReplay: () -> Unit = {},
    onGoToGrid: () -> Unit = {}
) {
    val viewModel: KakuroViewModel = hiltViewModel()

    LaunchedEffect(level) {
        viewModel.loadLevel(level)
    }

    val currentLevel by viewModel.currentLevel.collectAsState()
    val score by viewModel.score.collectAsState()
    val grid by viewModel.grid.collectAsState()
    val selectedCell by viewModel.selectedCell.collectAsState()
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
                        "Kakuro - Level $currentLevel",
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
                    IconButton(onClick = { viewModel.clearCell() }) {
                        Icon(
                            imageVector = Icons.Default.Delete,
                            contentDescription = "Clear",
                            tint = Color.White
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
                    .padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                LevelProgressBar(
                    progress = levelProgress,
                    problemsRemaining = viewModel.getProblemsRemaining(),
                    modifier = Modifier.padding(bottom = 8.dp)
                )

                KakuroScoreDisplay(score = score, isContentLoaded = isContentLoaded)

                if (feedback.isNotEmpty()) {
                    KakuroFeedback(
                        feedback = feedback,
                        isCorrect = isCorrect ?: false,
                        isContentLoaded = isContentLoaded
                    )
                }

                // Kakuro Grid
                KakuroGrid(
                    grid = grid,
                    selectedCell = selectedCell,
                    onCellClick = { row, col -> viewModel.selectCell(row, col) },
                    isContentLoaded = isContentLoaded
                )

                Spacer(modifier = Modifier.weight(1f))

                // Action buttons
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
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
                        Text("SKIP", fontWeight = FontWeight.Bold, fontSize = 16.sp)
                    }
                }

                // Number pad
                KakuroNumberPad(
                    onNumberClick = { number ->
                        viewModel.setCellValue(number)
                    }
                )
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
fun KakuroGrid(
    grid: List<List<KakuroCell>>,
    selectedCell: Pair<Int, Int>?,
    onCellClick: (Int, Int) -> Unit,
    isContentLoaded: Boolean
) {
    if (grid.isEmpty()) return

    Column(
        modifier = Modifier
            .scale(
                animateFloatAsState(
                    targetValue = if (isContentLoaded) 1f else 0.9f,
                    animationSpec = tween(durationMillis = 600), label = ""
                ).value
            )
            .fillMaxWidth()
            .aspectRatio(1f)
            .background(
                color = Color(0xFF2C1810),
                shape = RoundedCornerShape(16.dp)
            )
            .border(
                width = 3.dp,
                color = Color(0xFFD4AF37),
                shape = RoundedCornerShape(16.dp)
            )
            .padding(8.dp),
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        grid.forEachIndexed { rowIndex, row ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                row.forEachIndexed { colIndex, cell ->
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .aspectRatio(1f)
                            .padding(1.dp)
                    ) {
                        when (cell) {
                            is KakuroCell.ClueCell -> {
                                KakuroClueCell(cell)
                            }
                            is KakuroCell.PlayCell -> {
                                KakuroPlayCell(
                                    cell = cell,
                                    isSelected = selectedCell == Pair(rowIndex, colIndex),
                                    onClick = { onCellClick(rowIndex, colIndex) }
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun KakuroClueCell(cell: KakuroCell.ClueCell) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF1A1A1A), RoundedCornerShape(4.dp))
            .border(1.dp, Color(0xFF444444), RoundedCornerShape(4.dp))
    ) {
        // Diagonal line
        Canvas(modifier = Modifier.fillMaxSize()) {
            drawLine(
                color = androidx.compose.ui.graphics.Color(0xFF666666),
                start = androidx.compose.ui.geometry.Offset(0f, size.height),
                end = androidx.compose.ui.geometry.Offset(size.width, 0f),
                strokeWidth = 2f
            )
        }

        // Down sum (top-right)
        if (cell.downSum > 0) {
            Text(
                text = cell.downSum.toString(),
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(2.dp),
                color = Color(0xFFFFD700),
                fontSize = 10.sp,
                fontWeight = FontWeight.Bold
            )
        }

        // Across sum (bottom-left)
        if (cell.acrossSum > 0) {
            Text(
                text = cell.acrossSum.toString(),
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(2.dp),
                color = Color(0xFFFFD700),
                fontSize = 10.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
fun KakuroPlayCell(
    cell: KakuroCell.PlayCell,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    val backgroundColor = when {
        cell.isError -> Color(0x55FF4444)
        isSelected -> Color(0x88D4AF37)
        else -> Color(0xFFFFFFFF)
    }

    val borderColor = when {
        isSelected -> Color(0xFFFFD700)
        cell.isError -> Color(0xFFFF4444)
        else -> Color(0xFF6A4C3D)
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor, RoundedCornerShape(4.dp))
            .border(2.dp, borderColor, RoundedCornerShape(4.dp))
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        if (cell.value > 0) {
            Text(
                text = cell.value.toString(),
                color = Color(0xFF2C1810),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
fun KakuroNumberPad(
    onNumberClick: (Int) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        // First row: 1-5
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally)
        ) {
            (1..5).forEach { number ->
                Button(
                    onClick = { onNumberClick(number) },
                    modifier = Modifier.size(56.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF2C1810)
                    ),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Text(
                        text = number.toString(),
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                }
            }
        }

        // Second row: 6-9
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally)
        ) {
            (6..9).forEach { number ->
                Button(
                    onClick = { onNumberClick(number) },
                    modifier = Modifier.size(56.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF2C1810)
                    ),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Text(
                        text = number.toString(),
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                }
            }
        }
    }
}

@Composable
fun KakuroScoreDisplay(score: Int, isContentLoaded: Boolean) {
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
fun KakuroFeedback(feedback: String, isCorrect: Boolean, isContentLoaded: Boolean) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
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

