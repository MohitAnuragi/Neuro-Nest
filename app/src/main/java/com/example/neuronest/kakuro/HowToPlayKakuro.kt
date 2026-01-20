package com.example.neuronest.kakuro

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay

/**
 * Interactive tutorial overlay for Kakuro puzzle
 * Shows step-by-step guide with highlights and animations
 */
@Composable
fun HowToPlayKakuroOverlay(
    onDismiss: () -> Unit,
    onPlaySound: () -> Unit
) {
    var currentStep by remember { mutableStateOf(0) }
    val totalSteps = 4

    var isVisible by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        delay(200)
        isVisible = true
    }

    AnimatedVisibility(
        visible = isVisible,
        enter = fadeIn(animationSpec = tween(400)),
        exit = fadeOut(animationSpec = tween(400))
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black.copy(alpha = 0.85f)),
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Spacer(modifier = Modifier.height(40.dp))

                // Visual demonstration area
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    contentAlignment = Alignment.Center
                ) {
                    when (currentStep) {
                        0 -> TutorialStep1_ClueCell()
                        1 -> TutorialStep2_PlayCells()
                        2 -> TutorialStep3_NoRepeats()
                        3 -> TutorialStep4_Complete()
                    }
                }

                // Instruction card
                AnimatedVisibility(
                    visible = true,
                    enter = slideInVertically(
                        animationSpec = tween(600),
                        initialOffsetY = { it }
                    ),
                    exit = slideOutVertically(
                        animationSpec = tween(400),
                        targetOffsetY = { it }
                    )
                ) {
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp),
                        shape = RoundedCornerShape(20.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = Color(0xFF2C1810)
                        ),
                        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
                    ) {
                        Column(
                            modifier = Modifier
                                .padding(24.dp)
                                .fillMaxWidth(),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = when (currentStep) {
                                    0 -> "Black cells show the sum"
                                    1 -> "Fill white cells to match the sum"
                                    2 -> "Numbers 1–9, no repeats"
                                    3 -> "Complete the puzzle!"
                                    else -> ""
                                },
                                fontSize = 22.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFFFFD700),
                                textAlign = TextAlign.Center,
                                modifier = Modifier.padding(bottom = 12.dp)
                            )

                            Text(
                                text = when (currentStep) {
                                    0 -> "Each black cell contains clues:\n• Top-right: vertical sum ↓\n• Bottom-left: horizontal sum →"
                                    1 -> "Add numbers in white cells so they equal the clue.\nEach group adds to the given sum."
                                    2 -> "Within each group:\n• Use only digits 1–9\n• No duplicate numbers allowed"
                                    3 -> "Fill all cells correctly to win!\nUse logic to find the solution."
                                    else -> ""
                                },
                                fontSize = 16.sp,
                                color = Color.White.copy(alpha = 0.9f),
                                textAlign = TextAlign.Center,
                                lineHeight = 24.sp
                            )

                            Spacer(modifier = Modifier.height(20.dp))

                            // Progress indicator
                            Row(
                                horizontalArrangement = Arrangement.spacedBy(8.dp),
                                modifier = Modifier.padding(bottom = 16.dp)
                            ) {
                                repeat(totalSteps) { index ->
                                    Box(
                                        modifier = Modifier
                                            .size(10.dp)
                                            .background(
                                                color = if (index == currentStep)
                                                    Color(0xFFFFD700)
                                                else
                                                    Color.White.copy(alpha = 0.3f),
                                                shape = RoundedCornerShape(5.dp)
                                            )
                                    )
                                }
                            }

                            // Navigation buttons
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.spacedBy(12.dp)
                            ) {
                                if (currentStep > 0) {
                                    OutlinedButton(
                                        onClick = {
                                            currentStep--
                                            onPlaySound()
                                        },
                                        modifier = Modifier.weight(1f),
                                        colors = ButtonDefaults.outlinedButtonColors(
                                            contentColor = Color(0xFFD4AF37)
                                        ),
                                        shape = RoundedCornerShape(12.dp)
                                    ) {
                                        Text("Previous", fontWeight = FontWeight.Bold)
                                    }
                                }

                                Button(
                                    onClick = {
                                        onPlaySound()
                                        if (currentStep < totalSteps - 1) {
                                            currentStep++
                                        } else {
                                            onDismiss()
                                        }
                                    },
                                    modifier = Modifier.weight(1f),
                                    colors = ButtonDefaults.buttonColors(
                                        containerColor = Color(0xFFD4AF37),
                                        contentColor = Color(0xFF2C1810)
                                    ),
                                    shape = RoundedCornerShape(12.dp)
                                ) {
                                    Text(
                                        text = if (currentStep < totalSteps - 1) "Next" else "Start Playing",
                                        fontWeight = FontWeight.Bold
                                    )
                                }
                            }
                        }
                    }
                }

                Spacer(modifier = Modifier.height(40.dp))
            }
        }
    }
}

/**
 * Step 1: Highlight black clue cells
 */
@Composable
private fun TutorialStep1_ClueCell() {
    val scale by animateFloatAsState(
        targetValue = 1f,
        animationSpec = tween(durationMillis = 600), label = ""
    )

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .size(160.dp)
                .scale(scale)
        ) {
            // Black clue cell example
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xFF1A1A1A), RoundedCornerShape(12.dp))
                    .border(3.dp, Color(0xFFFFD700), RoundedCornerShape(12.dp))
            ) {
                // Diagonal line
                Canvas(modifier = Modifier.fillMaxSize()) {
                    drawLine(
                        color = Color(0xFF666666),
                        start = androidx.compose.ui.geometry.Offset(0f, size.height),
                        end = androidx.compose.ui.geometry.Offset(size.width, 0f),
                        strokeWidth = 4f
                    )
                }

                // Down sum (top-right)
                Text(
                    text = "6",
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFFFFD700),
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(12.dp)
                )

                // Across sum (bottom-left)
                Text(
                    text = "5",
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFFFFD700),
                    modifier = Modifier
                        .align(Alignment.BottomStart)
                        .padding(12.dp)
                )
            }
        }
    }
}

/**
 * Step 2: Show white play cells with a clue
 */
@Composable
private fun TutorialStep2_PlayCells() {
    val scale by animateFloatAsState(
        targetValue = 1f,
        animationSpec = tween(durationMillis = 600), label = ""
    )

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Clue cell
        Box(
            modifier = Modifier
                .size(100.dp)
                .scale(scale)
                .background(Color(0xFF1A1A1A), RoundedCornerShape(8.dp))
                .border(2.dp, Color(0xFFD4AF37), RoundedCornerShape(8.dp))
        ) {
            Canvas(modifier = Modifier.fillMaxSize()) {
                drawLine(
                    color = Color(0xFF666666),
                    start = androidx.compose.ui.geometry.Offset(0f, size.height),
                    end = androidx.compose.ui.geometry.Offset(size.width, 0f),
                    strokeWidth = 3f
                )
            }
            Text(
                text = "7",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFFFFD700),
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(8.dp)
            )
        }

        // Play cells (horizontal run)
        Row(
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.scale(scale)
        ) {
            TutorialPlayCell("2")
            TutorialPlayCell("5")
        }

        Text(
            text = "2 + 5 = 7 ✓",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF10B981),
            modifier = Modifier.padding(top = 8.dp)
        )
    }
}

/**
 * Step 3: Show no repeats rule
 */
@Composable
private fun TutorialStep3_NoRepeats() {
    val scale by animateFloatAsState(
        targetValue = 1f,
        animationSpec = tween(durationMillis = 600), label = ""
    )

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        // Correct example
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier.scale(scale)
            ) {
                TutorialPlayCell("3", isCorrect = true)
                TutorialPlayCell("5", isCorrect = true)
            }
            Text(
                text = "✓ Different numbers",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF10B981)
            )
        }

        Divider(
            color = Color.White.copy(alpha = 0.3f),
            modifier = Modifier
                .width(200.dp)
                .padding(vertical = 8.dp)
        )

        // Incorrect example
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier.scale(scale)
            ) {
                TutorialPlayCell("4", isCorrect = false)
                TutorialPlayCell("4", isCorrect = false)
            }
            Text(
                text = "✗ No repeats allowed",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFFEF4444)
            )
        }
    }
}

/**
 * Step 4: Show completed puzzle celebration
 */
@Composable
private fun TutorialStep4_Complete() {
    val scale by animateFloatAsState(
        targetValue = 1f,
        animationSpec = tween(durationMillis = 600), label = ""
    )

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Mini completed grid
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.scale(scale)
        ) {
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                TutorialPlayCell("1", isCorrect = true, size = 80.dp)
                TutorialPlayCell("2", isCorrect = true, size = 80.dp)
            }
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                TutorialPlayCell("3", isCorrect = true, size = 80.dp)
                TutorialPlayCell("4", isCorrect = true, size = 80.dp)
            }
        }

        Text(
            text = "🎉",
            fontSize = 60.sp,
            modifier = Modifier.padding(top = 16.dp)
        )

        Text(
            text = "All correct!",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFFFFD700)
        )
    }
}

/**
 * Helper composable for tutorial play cells
 */
@Composable
private fun TutorialPlayCell(
    value: String,
    isCorrect: Boolean? = null,
    size: androidx.compose.ui.unit.Dp = 100.dp
) {
    val backgroundColor = when (isCorrect) {
        true -> Color(0xFF2C1810)
        false -> Color(0x55FF4444)
        null -> Color(0xFF2C1810)
    }

    val borderColor = when (isCorrect) {
        true -> Color(0xFF10B981)
        false -> Color(0xFFFF4444)
        null -> Color(0xFFD4AF37)
    }

    Box(
        modifier = Modifier
            .size(size)
            .background(backgroundColor, RoundedCornerShape(8.dp))
            .border(3.dp, borderColor, RoundedCornerShape(8.dp)),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = value,
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
    }
}

