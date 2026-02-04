package com.neuronest.neuronest.sudoku

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.neuronest.neuronest.puzzlelevels.LevelCompleteDialog
import com.neuronest.neuronest.puzzlelevels.LevelDataStoreManager
import com.neuronest.neuronest.puzzlelevels.PuzzleTimer
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.math.sqrt
import com.neuronest.neuronest.R
import com.neuronest.neuronest.sound.SoundType


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SudokuPuzzleScreen(
    onBack: () -> Unit = {},
    level: Int = 1,
    onNextLevel: (Int) -> Unit = {},
    onReplay: () -> Unit = {},
    onGoToGrid: () -> Unit = {}
) {
    val viewModel: SudokuPuzzleViewModel = hiltViewModel()
    val context = androidx.compose.ui.platform.LocalContext.current
    val dataStoreManager = remember { LevelDataStoreManager(context) }
    val coroutineScope = rememberCoroutineScope()

    // Tutorial state
    val isTutorialCompleted by dataStoreManager.isTutorialCompletedFlow("Sudoku").collectAsState(initial = true)
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
    val grid by viewModel.grid.collectAsState()
    val selectedCell by viewModel.selectedCell.collectAsState()
    val gridSize by viewModel.gridSize.collectAsState()
    val feedback by viewModel.feedback.collectAsState()
    val showLevelComplete by viewModel.showLevelCompleteDialog.collectAsState()
    val starsEarned by viewModel.starsEarned.collectAsState()
    val isTimerRunning by viewModel.isTimerRunning.collectAsState()
    val elapsedTime by viewModel.elapsedTimeMs.collectAsState()

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
                        "Sudoku Puzzle",
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                },
                navigationIcon = {
                    IconButton(onClick = {
                        viewModel.playSoundEffect(SoundType.BUTTON_CLICK)
                        onBack()
                    }) {
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
//                    IconButton(onClick = { viewModel.clearCell() }) {
//                        Icon(
//                            imageVector = Icons.Default.Delete,
//                            contentDescription = "Clear",
//                            tint = Color.White
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
                    .padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                SudokuScoreDisplay(currentLevel = currentLevel, isContentLoaded = isContentLoaded)

                if (feedback.isNotEmpty()) {
                    SudokuFeedback(feedback = feedback, isContentLoaded = isContentLoaded)
                }

                // Sudoku Grid
                SudokuGrid(
                    grid = grid,
                    gridSize = gridSize,
                    selectedCell = selectedCell,
                    onCellClick = { row, col -> viewModel.selectCell(row, col) },
                    onCellValueChange = { row, col, value ->
                        // Ensure cell is selected before setting value
                        if (selectedCell != Pair(row, col)) {
                            viewModel.selectCell(row, col)
                        }

                        if (value.isEmpty()) {
                            // Clear the cell
                            viewModel.clearCell()
                        } else {
                            val num = value.toIntOrNull()
                            if (num != null && num in 1..gridSize) {
                                viewModel.setCellValue(num)
                            }
                        }
                    },
                    isContentLoaded = isContentLoaded
                )

                Spacer(modifier = Modifier.weight(1f))

                // Action buttons (Submit and Skip)
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    OutlinedButton(
                        onClick = {
                            viewModel.playSoundEffect(SoundType.BUTTON_CLICK)
                            viewModel.showHint()
                        },
                        modifier = Modifier
                            .weight(1f)
                            .height(56.dp),
                        colors = ButtonDefaults.outlinedButtonColors(
                            contentColor = Color(0xFFD4AF37)
                        ),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Text("HINT", fontWeight = FontWeight.Bold, fontSize = 16.sp)
                    }

                    Button(
                        onClick = {
                            viewModel.playSoundEffect(SoundType.BUTTON_CLICK)
                            viewModel.checkPuzzle()
                        },
                        modifier = Modifier
                            .weight(1f)
                            .height(56.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFFD4AF37),
                            contentColor = Color(0xFF2C1810)
                        ),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Text("SUBMIT", fontWeight = FontWeight.Bold, fontSize = 16.sp)
                    }
                }

                // Number input buttons
//                SudokuNumberPad(
//                    gridSize = gridSize,
//                    onNumberClick = { number ->
//                        viewModel.setCellValue(number)
//                    }
//                )
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
        HowToPlaySudokuOverlay(
            onDismiss = {
                showTutorial = false
                coroutineScope.launch {
                    dataStoreManager.saveTutorialCompleted("Sudoku")
                }
            },
            onPlaySound = {
                viewModel.playSoundEffect(com.neuronest.neuronest.sound.SoundType.BUTTON_CLICK)
            }
        )
    }
}

@Composable
fun SudokuGrid(
    grid: List<List<SudokuCell>>,
    gridSize: Int,
    selectedCell: Pair<Int, Int>?,
    onCellClick: (Int, Int) -> Unit,
    onCellValueChange: (Int, Int, String) -> Unit,
    isContentLoaded: Boolean
) {
    if (grid.isEmpty()) return

    val subgridSize = sqrt(gridSize.toDouble()).toInt()

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
                width = 4.dp,
                color = Color(0xFFD4AF37),
                shape = RoundedCornerShape(16.dp)
            )
            .padding(4.dp),
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        for (rowIndex in grid.indices) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                for (colIndex in grid[rowIndex].indices) {
                    val cell = grid[rowIndex][colIndex]

                    // Add thicker borders for subgrid boundaries
                    val topBorder = if (rowIndex % subgridSize == 0 && rowIndex != 0) 3.dp else 1.dp
                    val leftBorder = if (colIndex % subgridSize == 0 && colIndex != 0) 3.dp else 1.dp

                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .aspectRatio(1f)
                            .border(
                                width = topBorder,
                                color = Color(0xFF6A4C3D),
                                shape = RoundedCornerShape(0.dp)
                            )
                            .padding(start = if (colIndex > 0) leftBorder else 0.dp)
                    ) {
                        SudokuCell(
                            cell = cell,
                            isSelected = selectedCell == Pair(rowIndex, colIndex),
                            onClick = { onCellClick(rowIndex, colIndex) },
                            onValueChange = { value ->
                                onCellValueChange(rowIndex, colIndex, value)
                            },
                            gridSize = gridSize
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun SudokuCell(
    cell: SudokuCell,
    isSelected: Boolean,
    onClick: () -> Unit,
    onValueChange: (String) -> Unit,
    gridSize: Int
) {
    val backgroundColor = when {
        cell.isError -> Color(0x55FF4444)
        isSelected -> Color(0x88D4AF37)
        cell.isFixed -> Color(0xFF4A2C1D)
        else -> Color(0xFF2C1810)
    }

    val borderColor = when {
        isSelected -> Color(0xFFFFD700)
        cell.isError -> Color(0xFFFF4444)
        else -> Color(0xFF6A4C3D)
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
            .border(1.dp, borderColor)
            .clickable(enabled = !cell.isFixed) { onClick() },
        contentAlignment = Alignment.Center
    ) {
        if (cell.isFixed) {
            Text(
                text = if (cell.value == 0) "" else cell.value.toString(),
                color = Color(0xFFFFD700),
                fontSize = when (gridSize) {
                    4 -> 28.sp
                    6 -> 20.sp
                    else -> 18.sp
                },
                fontWeight = FontWeight.ExtraBold,
                textAlign = TextAlign.Center
            )
        } else {
            var textValue by remember(cell.value) {
                mutableStateOf(if (cell.value == 0) "" else cell.value.toString())
            }

            BasicTextField(
                value = textValue,
                onValueChange = { newValue ->
                    if (newValue.isEmpty() || (newValue.length == 1 && newValue.toIntOrNull()?.let { it in 1..gridSize } == true)) {
                        textValue = newValue
                        onValueChange(newValue)
                    }
                },
                textStyle = TextStyle(
                    color = Color.White,
                    fontSize = when (gridSize) {
                        4 -> 28.sp
                        6 -> 20.sp
                        else -> 18.sp
                    },
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                ),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                singleLine = true,
                modifier = Modifier.fillMaxSize(),
                decorationBox = { innerTextField ->
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        innerTextField()
                    }
                }
            )
        }
    }
}

@Composable
fun SudokuScoreDisplay(currentLevel: Int, isContentLoaded: Boolean) {
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
fun SudokuFeedback(feedback: String, isContentLoaded: Boolean) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .scale(
                animateFloatAsState(
                    targetValue = if (isContentLoaded) 1f else 0.8f,
                    animationSpec = tween(durationMillis = 600), label = ""
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

