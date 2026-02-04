package com.neuronest.neuronest.kakuro

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


@Composable
fun HowToPlayKakuroOverlay(
    onDismiss: () -> Unit,
    onPlaySound: () -> Unit
) {
    var currentStep by remember { mutableStateOf(0) }
    val totalSteps = 5

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

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    contentAlignment = Alignment.Center
                ) {
                    when (currentStep) {
                        0 -> TutorialStep0_Rules()
                        1 -> TutorialStep1_ValidExample()
                        2 -> TutorialStep2_DuplicateError()
                        3 -> TutorialStep3_SumMismatchError()
                        4 -> TutorialStep4_Complete()
                    }
                }

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
                                    0 -> "How to Play Kakuro"
                                    1 -> "Example 1: Valid Solution ✓"
                                    2 -> "Example 2: Duplicate Error ✗"
                                    3 -> "Example 3: Sum Mismatch ✗"
                                    4 -> "Complete the puzzle!"
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
                                    0 -> "Rules:\n• Fill white cells using numbers 1–9\n• Numbers must add up to the clue\n• No duplicates within the same group\n• Each cell belongs to one horizontal & one vertical group"
                                    1 -> "A simple 2×2 Kakuro:\n• Horizontal: 1 + 2 = 3 ✓\n• Vertical: 1 + 3 = 4 ✓\n• All sums match, no duplicates!"
                                    2 -> "Duplicate numbers in the same group:\n• Both cells have 4\n• This is NOT allowed!\n• Each group must have unique numbers"
                                    3 -> "Numbers don't match the clue:\n• 2 + 2 = 4, but clue says 7\n• This is INVALID!\n• Sum must match exactly"
                                    4 -> "Fill all cells correctly to win!\nUse logic to find the solution."
                                    else -> ""
                                },
                                fontSize = 16.sp,
                                color = Color.White.copy(alpha = 0.9f),
                                textAlign = TextAlign.Center,
                                lineHeight = 24.sp
                            )

                            Spacer(modifier = Modifier.height(20.dp))

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
                                        Text("Back", fontWeight = FontWeight.Bold)
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
                                        text = if (currentStep < totalSteps - 1) "Next" else "Play",
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

@Composable
private fun TutorialStep0_Rules() {
    val scale by animateFloatAsState(
        targetValue = 1f,
        animationSpec = tween(durationMillis = 600), label = ""
    )

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.scale(scale)
    ) {
        Box(
            modifier = Modifier
                .size(160.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xFF1A1A1A), RoundedCornerShape(12.dp))
                    .border(3.dp, Color(0xFFFFD700), RoundedCornerShape(12.dp))
            ) {
                Canvas(modifier = Modifier.fillMaxSize()) {
                    drawLine(
                        color = Color(0xFF666666),
                        start = androidx.compose.ui.geometry.Offset(0f, size.height),
                        end = androidx.compose.ui.geometry.Offset(size.width, 0f),
                        strokeWidth = 4f
                    )
                }

                Text(
                    text = "6",
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFFFFD700),
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(12.dp)
                )

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

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "↓ Down sum    → Across sum",
            fontSize = 14.sp,
            color = Color(0xFFFFD700),
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
private fun TutorialStep1_ValidExample() {
    val scale by animateFloatAsState(
        targetValue = 1f,
        animationSpec = tween(durationMillis = 600), label = ""
    )

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier.scale(scale)
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                Box(
                    modifier = Modifier
                        .size(80.dp)
                        .background(Color(0xFF1A1A1A), RoundedCornerShape(8.dp))
                        .border(2.dp, Color(0xFF666666), RoundedCornerShape(8.dp))
                ) {
                    Canvas(modifier = Modifier.fillMaxSize()) {
                        drawLine(
                            color = Color(0xFF666666),
                            start = androidx.compose.ui.geometry.Offset(0f, size.height),
                            end = androidx.compose.ui.geometry.Offset(size.width, 0f),
                            strokeWidth = 2f
                        )
                    }
                }
                Box(
                    modifier = Modifier
                        .size(80.dp)
                        .background(Color(0xFF1A1A1A), RoundedCornerShape(8.dp))
                        .border(2.dp, Color(0xFF666666), RoundedCornerShape(8.dp))
                ) {
                    Canvas(modifier = Modifier.fillMaxSize()) {
                        drawLine(
                            color = Color(0xFF666666),
                            start = androidx.compose.ui.geometry.Offset(0f, size.height),
                            end = androidx.compose.ui.geometry.Offset(size.width, 0f),
                            strokeWidth = 2f
                        )
                    }
                    Text(
                        text = "4",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFFFFD700),
                        modifier = Modifier
                            .align(Alignment.TopEnd)
                            .padding(6.dp)
                    )
                }
            }
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                Box(
                    modifier = Modifier
                        .size(80.dp)
                        .background(Color(0xFF1A1A1A), RoundedCornerShape(8.dp))
                        .border(2.dp, Color(0xFF666666), RoundedCornerShape(8.dp))
                ) {
                    Canvas(modifier = Modifier.fillMaxSize()) {
                        drawLine(
                            color = Color(0xFF666666),
                            start = androidx.compose.ui.geometry.Offset(0f, size.height),
                            end = androidx.compose.ui.geometry.Offset(size.width, 0f),
                            strokeWidth = 2f
                        )
                    }
                    Text(
                        text = "3",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFFFFD700),
                        modifier = Modifier
                            .align(Alignment.BottomStart)
                            .padding(6.dp)
                    )
                }
                TutorialPlayCell("1", isCorrect = true, size = 80.dp)
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                TutorialPlayCell("1", isCorrect = true, size = 80.dp)
                TutorialPlayCell("2", isCorrect = true, size = 80.dp)
            }
        }

        Text(
            text = "1 + 2 = 3 ✓",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF10B981)
        )
    }
}

@Composable
private fun TutorialStep2_DuplicateError() {
    val scale by animateFloatAsState(
        targetValue = 1f,
        animationSpec = tween(durationMillis = 600), label = ""
    )

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(24.dp),
        modifier = Modifier.scale(scale)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                TutorialPlayCell("4", isCorrect = false, size = 100.dp)
                TutorialPlayCell("4", isCorrect = false, size = 100.dp)
            }

            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(top = 8.dp)
            ) {
                Text(
                    text = "✗",
                    fontSize = 40.sp,
                    color = Color(0xFFEF4444),
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.width(12.dp))
                Text(
                    text = "DUPLICATE",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFFEF4444)
                )
            }

            Text(
                text = "Repeating numbers\nare NOT allowed!",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White.copy(alpha = 0.8f),
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
private fun TutorialStep3_SumMismatchError() {
    val scale by animateFloatAsState(
        targetValue = 1f,
        animationSpec = tween(durationMillis = 600), label = ""
    )

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier.scale(scale)
    ) {
        Box(
            modifier = Modifier
                .size(100.dp)
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

        Row(
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            TutorialPlayCell("2", isCorrect = false, size = 100.dp)
            TutorialPlayCell("2", isCorrect = false, size = 100.dp)
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = "2 + 2 = 4",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
            Text(
                text = "≠",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFFEF4444)
            )
            Text(
                text = "Clue = 7",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFFFFD700)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "✗",
                    fontSize = 32.sp,
                    color = Color(0xFFEF4444),
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "SUM MISMATCH",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFFEF4444)
                )
            }
        }
    }
}

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

