package com.example.neuronest.sudoku

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
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
 * Interactive tutorial overlay for Sudoku puzzle
 * Shows step-by-step guide with highlights and animations
 */
@Composable
fun HowToPlaySudokuOverlay(
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
                        0 -> TutorialStep1_Row()
                        1 -> TutorialStep2_Column()
                        2 -> TutorialStep3_Box()
                        3 -> TutorialStep4_Fixed()
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
                                    0 -> "Fill each row"
                                    1 -> "Fill each column"
                                    2 -> "Fill each 3×3 box"
                                    3 -> "Fixed vs Editable cells"
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
                                    0 -> "Each row must contain numbers 1–9 without repetition."
                                    1 -> "Each column must also contain numbers 1–9 without repetition."
                                    2 -> "Each 3×3 box must contain all digits 1–9 once."
                                    3 -> "Golden numbers are fixed. White cells are editable."
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
 * Step 1: Highlight a row with numbers 1-9
 */
@Composable
private fun TutorialStep1_Row() {
    val scale by animateFloatAsState(
        targetValue = 1f,
        animationSpec = tween(durationMillis = 600), label = ""
    )

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Show a highlighted row
        Row(
            horizontalArrangement = Arrangement.spacedBy(6.dp),
            modifier = Modifier.scale(scale)
        ) {
            listOf(1, 2, 3, 4, 5, 6, 7, 8, 9).forEach { num ->
                TutorialSudokuCell(
                    value = num.toString(),
                    isHighlighted = true
                )
            }
        }

        Text(
            text = "No repeats in a row ✓",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF10B981),
            modifier = Modifier.padding(top = 16.dp)
        )
    }
}

/**
 * Step 2: Highlight a column with numbers 1-9
 */
@Composable
private fun TutorialStep2_Column() {
    val scale by animateFloatAsState(
        targetValue = 1f,
        animationSpec = tween(durationMillis = 600), label = ""
    )

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Show a highlighted column
        Column(
            verticalArrangement = Arrangement.spacedBy(6.dp),
            modifier = Modifier.scale(scale)
        ) {
            listOf(1, 2, 3, 4, 5, 6, 7, 8, 9).forEach { num ->
                TutorialSudokuCell(
                    value = num.toString(),
                    isHighlighted = true
                )
            }
        }

        Text(
            text = "No repeats in a column ✓",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF10B981),
            modifier = Modifier.padding(top = 16.dp)
        )
    }
}

/**
 * Step 3: Highlight a 3×3 box
 */
@Composable
private fun TutorialStep3_Box() {
    val scale by animateFloatAsState(
        targetValue = 1f,
        animationSpec = tween(durationMillis = 600), label = ""
    )

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Show a 3x3 box
        Column(
            verticalArrangement = Arrangement.spacedBy(6.dp),
            modifier = Modifier
                .scale(scale)
                .border(4.dp, Color(0xFFFFD700), RoundedCornerShape(8.dp))
                .padding(8.dp)
        ) {
            listOf(
                listOf(1, 2, 3),
                listOf(4, 5, 6),
                listOf(7, 8, 9)
            ).forEach { row ->
                Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                    row.forEach { num ->
                        TutorialSudokuCell(
                            value = num.toString(),
                            isHighlighted = true
                        )
                    }
                }
            }
        }

        Text(
            text = "No repeats in a Subgrid 2×2 box ✓",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF10B981),
            modifier = Modifier.padding(top = 16.dp)
        )
    }
}

/**
 * Step 4: Show fixed vs editable cells
 */
@Composable
private fun TutorialStep4_Fixed() {
    val scale by animateFloatAsState(
        targetValue = 1f,
        animationSpec = tween(durationMillis = 600), label = ""
    )

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        // Fixed cell example
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            TutorialSudokuCell(
                value = "5",
                isFixed = true,
                modifier = Modifier.scale(scale)
            )
            Text(
                text = "Fixed (cannot change)",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFFFFD700)
            )
        }

        HorizontalDivider(
            color = Color.White.copy(alpha = 0.3f),
            modifier = Modifier
                .width(200.dp)
                .padding(vertical = 8.dp)
        )

        // Editable cell example
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            TutorialSudokuCell(
                value = "3",
                isFixed = false,
                modifier = Modifier.scale(scale)
            )
            Text(
                text = "Editable (you fill this)",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }
    }
}

/**
 * Helper composable for tutorial Sudoku cells
 */
@Composable
private fun TutorialSudokuCell(
    value: String,
    isHighlighted: Boolean = false,
    isFixed: Boolean = true,
    modifier: Modifier = Modifier
) {
    val backgroundColor = when {
        isHighlighted -> Color(0x88D4AF37)
        isFixed -> Color(0xFF4A2C1D)
        else -> Color(0xFF2C1810)
    }

    val textColor = if (isFixed) Color(0xFFFFD700) else Color.White

    Box(
        modifier = modifier
            .size(50.dp)
            .background(backgroundColor, RoundedCornerShape(6.dp))
            .border(2.dp, Color(0xFF6A4C3D), RoundedCornerShape(6.dp)),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = value,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = textColor
        )
    }
}

