package com.example.neuronest.logic

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.MusicNote
import androidx.compose.material.icons.filled.MusicOff
import androidx.compose.material.icons.rounded.CheckCircle
import androidx.compose.material.icons.rounded.Error
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.neuronest.R
import kotlinx.coroutines.delay

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LogicRiddlesScreen(
    onBack: () -> Unit = {},
    viewModel: LogicRiddlesViewModel = hiltViewModel(),

) {
    val uiState by viewModel.uiState.collectAsState()
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
                        "Logic Puzzles",
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
                    // Music control
//                    IconButton(onClick = { onToggleMusic(!isMusicPlaying) }) {
//                        Icon(
//                            imageVector = if (isMusicPlaying) Icons.Default.MusicNote else Icons.Default.MusicOff,
//                            contentDescription = "Toggle Music",
//                            tint = Color.White
//                        )
//                    }

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
                    .padding(16.dp)
                    .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(24.dp)
            ) {
                // Score and difficulty display
                ScoreAndDifficultyDisplay(
                    score = uiState.score,
                    totalAttempts = uiState.totalAttempts,
                    difficulty = uiState.currentRiddle.difficulty,
                    puzzleType = uiState.currentPuzzleType,
                    isContentLoaded = isContentLoaded
                )

                // Riddle card
                RiddleCard(
                    riddle = uiState.currentRiddle.riddle,
                    showHint = uiState.showHint,
                    hint = viewModel.getHint(),
                    isLoading = uiState.isLoading,
                    isContentLoaded = isContentLoaded
                )

                // MCQ Options section
                if (!uiState.isLoading && uiState.currentRiddle.options.isNotEmpty()) {
                    MCQOptions(
                        options = uiState.currentRiddle.options,
                        selectedAnswer = uiState.userAnswer,
                        onOptionSelected = { viewModel.onUserAnswerChange(it) },
                        isContentLoaded = isContentLoaded
                    )
                }

                // Answer input (for manual entry)
                AnswerInput(
                    userAnswer = uiState.userAnswer,
                    onAnswerChange = { viewModel.onUserAnswerChange(it) },
                    isCorrect = uiState.isCorrect,
                    isLoading = uiState.isLoading,
                    isContentLoaded = isContentLoaded
                )

                // Action buttons
                ActionButtons(
                    uiState = uiState,
                    onCheckAnswer = { viewModel.checkAnswer() },
                    onToggleHint = { viewModel.toggleHint() },
                    onRevealAnswer = { viewModel.revealAnswer() },
                    onLoadNewRiddle = { viewModel.loadNewRiddle() },
                    onFetchNewPuzzle = { viewModel.fetchRiddlesFromApi() },
                    isContentLoaded = isContentLoaded
                )

                // Feedback message
                FeedbackMessage(
                    message = uiState.feedbackMessage,
                    isLoading = uiState.isLoading,
                    isCorrect = uiState.isCorrect,
                    isContentLoaded = isContentLoaded
                )
            }
        }
    }
}

@Composable
fun ScoreAndDifficultyDisplay(
    score: Long,
    totalAttempts: Int,
    difficulty: String,
    puzzleType: String,
    isContentLoaded: Boolean
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .scale(animateFloatAsState(
                targetValue = if (isContentLoaded) 1f else 0.9f,
                animationSpec = tween(durationMillis = 600)
            ).value),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        // Score display
        Box(
            modifier = Modifier
                .weight(1f)
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
                )
                .padding(12.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Score: $score/$totalAttempts",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }

        Spacer(modifier = Modifier.width(8.dp))

        // Difficulty display
        Box(
            modifier = Modifier
                .weight(1f)
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
                )
                .padding(12.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = difficulty,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFFFFD700)
            )
        }

        Spacer(modifier = Modifier.width(8.dp))

        // Puzzle type display
        Box(
            modifier = Modifier
                .weight(1f)
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
                )
                .padding(12.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = puzzleType,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFFFFD700),
                maxLines = 1
            )
        }
    }
}

@Composable
fun RiddleCard(
    riddle: String,
    showHint: Boolean,
    hint: String,
    isLoading: Boolean,
    isContentLoaded: Boolean
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .scale(animateFloatAsState(
                targetValue = if (isContentLoaded) 1f else 0.9f,
                animationSpec = tween(durationMillis = 600, delayMillis = 100)
            ).value)
            .shadow(
                elevation = 16.dp,
                shape = RoundedCornerShape(20.dp),
                spotColor = Color(0xFFFFD700)
            ),
        shape = RoundedCornerShape(20.dp)
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
            if (isLoading) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    CircularProgressIndicator(color = Color(0xFFFFD700))
                    Text(
                        text = "Loading puzzle...",
                        color = Color(0xFFD4AF37),
                        fontSize = 16.sp
                    )
                }
            } else {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Text(
                        text = riddle,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color.White,
                        textAlign = TextAlign.Center,
                        lineHeight = 28.sp
                    )

                    if (showHint) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(
                                    color = Color(0x552C1810),
                                    shape = RoundedCornerShape(12.dp)
                                )
                                .border(
                                    width = 1.dp,
                                    color = Color(0x55FFD700),
                                    shape = RoundedCornerShape(12.dp)
                                )
                                .padding(16.dp)
                        ) {
                            Text(
                                text = "💡 Hint: $hint",
                                color = Color(0xFFFFD700),
                                fontStyle = androidx.compose.ui.text.font.FontStyle.Italic,
                                fontSize = 14.sp
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun MCQOptions(
    options: List<String>,
    selectedAnswer: String,
    onOptionSelected: (String) -> Unit,
    isContentLoaded: Boolean,
    modifier: Modifier = Modifier
) {
    val animatedAlpha by animateFloatAsState(
        targetValue = if (isContentLoaded) 1f else 0f,
        animationSpec = tween(durationMillis = 800),
        label = "optionsAlphaAnimation"
    )

    Column(
        modifier = modifier
            .fillMaxWidth()
            .alpha(animatedAlpha)
            .padding(vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        options.forEach { option ->
            val isSelected = selectedAnswer.equals(option, ignoreCase = true)

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .clickable { onOptionSelected(option) },
                shape = RoundedCornerShape(12.dp),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = if (isSelected) 6.dp else 2.dp
                ),
                colors = CardDefaults.cardColors(
                    containerColor = if (isSelected) {
                        Color(0xFFD4AF37).copy(alpha = 0.9f)
                    } else {
                        Color(0xFF2C1810).copy(alpha = 0.8f)
                    }
                )
            ) {
                Row(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = option,
                        style = MaterialTheme.typography.bodyLarge,
                        color = if (isSelected) {
                            Color(0xFF2C1810)
                        } else {
                            Color.White
                        },
                        modifier = Modifier.weight(1f),
                        fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium
                    )

                    if (isSelected) {
                        Icon(
                            imageVector = Icons.Rounded.CheckCircle,
                            contentDescription = "Selected",
                            tint = Color(0xFF2C1810),
                            modifier = Modifier.size(20.dp)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun AnswerInput(
    userAnswer: String,
    onAnswerChange: (String) -> Unit,
    isCorrect: Boolean,
    isLoading: Boolean,
    isContentLoaded: Boolean
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .scale(animateFloatAsState(
                targetValue = if (isContentLoaded) 1f else 0.9f,
                animationSpec = tween(durationMillis = 600, delayMillis = 300)
            ).value)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
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
                )
                .padding(4.dp)
        ) {
            BasicTextField(
                value = userAnswer,
                onValueChange = onAnswerChange,
                enabled = !isCorrect && !isLoading,
                textStyle = TextStyle(
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .padding(horizontal = 16.dp),
                singleLine = true,
                decorationBox = { innerTextField ->
                    Box(
                        contentAlignment = Alignment.CenterStart,
                        modifier = Modifier.fillMaxSize()
                    ) {
                        if (userAnswer.isEmpty()) {
                            Text(
                                text = "Or type your answer here...",
                                color = Color(0xFFD4AF37).copy(alpha = 0.7f),
                                fontSize = 16.sp
                            )
                        }
                        innerTextField()
                    }
                }
            )
        }
    }
}

@Composable
fun ActionButtons(
    uiState: LogicRiddlesUiState,
    onCheckAnswer: () -> Unit,
    onToggleHint: () -> Unit,
    onRevealAnswer: () -> Unit,
    onLoadNewRiddle: () -> Unit,
    onFetchNewPuzzle: () -> Unit,
    isContentLoaded: Boolean
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .scale(animateFloatAsState(
                targetValue = if (isContentLoaded) 1f else 0.9f,
                animationSpec = tween(durationMillis = 600, delayMillis = 400)
            ).value),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        if (!uiState.isCorrect) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                ActionButton(
                    onClick = onCheckAnswer,
                    text = "SUBMIT",
                    enabled = !uiState.isLoading && uiState.userAnswer.isNotBlank(),
                    modifier = Modifier.weight(1f),
                    containerColor = Color(0xFFD4AF37)
                )

                ActionButton(
                    onClick = onToggleHint,
                    text = if (uiState.showHint) "HIDE" else "HINT",
                    enabled = !uiState.isLoading,
                    modifier = Modifier.weight(1f),
                    containerColor = Color(0xFFA0522D)
                )

                ActionButton(
                    onClick = onRevealAnswer,
                    text = "ANS",
                    enabled = !uiState.isLoading,
                    modifier = Modifier.weight(1f),
                    containerColor = Color(0xFF2C1810)
                )
            }
        }

        ActionButton(
            onClick = onFetchNewPuzzle,
            text = "GENERATE NEW PUZZLES",
            enabled = !uiState.isLoading,
            modifier = Modifier.fillMaxWidth(),
            containerColor = Color(0xFF4A2C1D)
        )
    }
}

@Composable
fun ActionButton(
    onClick: () -> Unit,
    text: String,
    enabled: Boolean = true,
    modifier: Modifier = Modifier,
    containerColor: Color
) {
    Button(
        onClick = onClick,
        modifier = modifier.height(50.dp),
        enabled = enabled,
        colors = ButtonDefaults.buttonColors(
            containerColor = containerColor,
            contentColor = Color.White
        ),
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 8.dp,
            pressedElevation = 4.dp
        )
    ) {
        Text(text, fontWeight = FontWeight.Bold, fontSize = 14.sp)
    }
}



@Composable
fun FeedbackMessage(
    message: String,
    isLoading: Boolean,
    isCorrect: Boolean,
    isContentLoaded: Boolean,
    modifier: Modifier = Modifier
) {
    val animatedScale by animateFloatAsState(
        targetValue = if (isContentLoaded) 1f else 0.8f,
        animationSpec = tween(durationMillis = 600, delayMillis = 500),
        label = "scaleAnimation"
    )

    val animatedAlpha by animateFloatAsState(
        targetValue = if (isContentLoaded) 1f else 0f,
        animationSpec = tween(durationMillis = 800),
        label = "alphaAnimation"
    )

    if (message.isNotEmpty() || isLoading) {
        Box(
            modifier = modifier
                .fillMaxWidth()
                .scale(animatedScale)
                .alpha(animatedAlpha)
                .padding(horizontal = 16.dp, vertical = 8.dp)
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                shape = RoundedCornerShape(12.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                colors = CardDefaults.cardColors(
                    containerColor = when {
                        isLoading -> MaterialTheme.colorScheme.surfaceContainer
                        isCorrect -> MaterialTheme.colorScheme.tertiaryContainer.copy(alpha = 0.9f)
                        else -> MaterialTheme.colorScheme.errorContainer.copy(alpha = 0.9f)
                    }
                )
            ) {
                Row(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    // Icon based on state
                    when {
                        isLoading -> {
                            CircularProgressIndicator(
                                modifier = Modifier.size(24.dp),
                                strokeWidth = 2.dp,
                                color = MaterialTheme.colorScheme.primary
                            )
                        }
                        isCorrect -> {
                            Icon(
                                imageVector = Icons.Rounded.CheckCircle,
                                contentDescription = "Correct",
                                modifier = Modifier.size(24.dp),
                                tint = MaterialTheme.colorScheme.tertiary
                            )
                        }
                        else -> {
                            Icon(
                                imageVector = Icons.Rounded.Error,
                                contentDescription = "Error",
                                modifier = Modifier.size(24.dp),
                                tint = MaterialTheme.colorScheme.error
                            )
                        }
                    }

                    if (isLoading) {
                        Text(
                            text = "Processing...",
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    } else {
                        Text(
                            text = message,
                            style = MaterialTheme.typography.bodyMedium,
                            color = when {
                                isCorrect -> MaterialTheme.colorScheme.onTertiaryContainer
                                else -> MaterialTheme.colorScheme.onErrorContainer
                            }
                        )
                    }
                }
            }
        }
    }
}