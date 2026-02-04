package com.neuronest.neuronest.logic

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lightbulb
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
fun HowToPlayLogicOverlay(
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

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    contentAlignment = Alignment.Center
                ) {
                    when (currentStep) {
                        0 -> TutorialStep1_ReadQuestion()
                        1 -> TutorialStep2_ChooseAnswer()
                        2 -> TutorialStep3_UseHint()
                        3 -> TutorialStep4_Complete()
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
                                    0 -> "Read the question"
                                    1 -> "Choose your answer"
                                    2 -> "Use hints if needed"
                                    3 -> "Solve and earn stars!"
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
                                    0 -> "Each puzzle presents a logic question, riddle, or math problem."
                                    1 -> "Select from multiple choice options or type your answer directly."
                                    2 -> "Tap the Hint Button for a helpful hint when you're stuck."
                                    3 -> "Solve puzzles quickly with fewer hints to earn more stars!"
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
private fun TutorialStep1_ReadQuestion() {
    val scale by animateFloatAsState(
        targetValue = 1f,
        animationSpec = tween(durationMillis = 600), label = ""
    )

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.padding(16.dp)
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .scale(scale),
            shape = RoundedCornerShape(16.dp),
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
                    text = "❓",
                    fontSize = 48.sp,
                    modifier = Modifier.padding(bottom = 16.dp)
                )

                Text(
                    text = "What has keys but no locks, space but no room?",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    lineHeight = 26.sp
                )
            }
        }

        Text(
            text = "Read carefully",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFFFFD700),
            modifier = Modifier.padding(top = 16.dp)
        )
    }
}


@Composable
private fun TutorialStep2_ChooseAnswer() {
    val scale by animateFloatAsState(
        targetValue = 1f,
        animationSpec = tween(durationMillis = 600), label = ""
    )

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(12.dp),
        modifier = Modifier
            .padding(16.dp)
            .scale(scale)
    ) {
        Text(
            text = "Select your answer:",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFFFFD700),
            modifier = Modifier.padding(bottom = 8.dp)
        )

        listOf("KEYBOARD", "PIANO", "COMPUTER").forEach { option ->
            TutorialOptionButton(
                text = option,
                isCorrect = option == "KEYBOARD"
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Or type your answer directly",
            fontSize = 14.sp,
            color = Color.White.copy(alpha = 0.7f)
        )
    }
}


@Composable
private fun TutorialStep3_UseHint() {
    val scale by animateFloatAsState(
        targetValue = 1f,
        animationSpec = tween(durationMillis = 600), label = ""
    )

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(24.dp),
        modifier = Modifier.padding(16.dp)
    ) {
        Box(
            modifier = Modifier
                .scale(scale)
                .size(80.dp)
                .background(Color(0xFFFFD700), RoundedCornerShape(40.dp))
                .border(4.dp, Color(0xFFD4AF37), RoundedCornerShape(40.dp)),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Default.Lightbulb,
                contentDescription = "Hint",
                tint = Color(0xFF2C1810),
                modifier = Modifier.size(40.dp)
            )
        }

        Text(
            text = "💡",
            fontSize = 48.sp
        )

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .scale(scale),
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFF2C1810)
            )
        ) {
            Text(
                text = "Hint: Input device",
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                color = Color(0xFFFFD700),
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )
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
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier.padding(16.dp)
    ) {
        Text(
            text = "🎉",
            fontSize = 80.sp,
            modifier = Modifier.scale(scale)
        )

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .scale(scale),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFF10B981)
            )
        ) {
            Column(
                modifier = Modifier
                    .padding(24.dp)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Correct!",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                Spacer(modifier = Modifier.height(8.dp))

            }
        }

        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.padding(top = 8.dp)
        ) {
            repeat(3) {
                Text(
                    text = "⭐",
                    fontSize = 36.sp
                )
            }
        }

        Text(
            text = "Solve faster for more stars!",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFFFFD700)
        )
    }
}

@Composable
private fun TutorialOptionButton(
    text: String,
    isCorrect: Boolean = false
) {
    val backgroundColor = if (isCorrect) Color(0x5510B981) else Color(0xFF2C1810)
    val borderColor = if (isCorrect) Color(0xFF10B981) else Color(0xFFD4AF37)

    Button(
        onClick = { },
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColor
        ),
        shape = RoundedCornerShape(12.dp),
        border = BorderStroke(2.dp, borderColor)
    ) {
        Text(
            text = text,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )

        if (isCorrect) {
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "✓",
                fontSize = 20.sp,
                color = Color(0xFF10B981)
            )
        }
    }
}

