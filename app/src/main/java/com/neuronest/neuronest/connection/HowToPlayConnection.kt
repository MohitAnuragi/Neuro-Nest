package com.neuronest.neuronest.connection

import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.neuronest.neuronest.sound.SoundManager
import com.neuronest.neuronest.sound.SoundType
import kotlinx.coroutines.delay
import com.neuronest.neuronest.R


@Composable
fun ConnectionsTutorialOverlay(
    soundManager: SoundManager,
    onDismiss: () -> Unit
) {
    var currentStep by remember { mutableIntStateOf(0) }
    val totalSteps = 4

    val tutorialWords = listOf(
        "Apple", "Banana", "Orange", "Grape",
        "Rose", "Tulip", "Daisy", "Lily",
        "Oak", "Pine", "Maple", "Birch",
        "Lion", "Tiger", "Bear", "Wolf"
    )

    val highlightedWords = setOf("Apple", "Banana", "Orange", "Grape")

    LaunchedEffect(currentStep) {
        when (currentStep) {
            1 -> {
                delay(500)
                soundManager.playSound(SoundType.BUTTON_CLICK)
            }

            3 -> {
                delay(300)
                soundManager.playSound(SoundType.CORRECT_MOVE)
                delay(800)
                soundManager.playSound(SoundType.LEVEL_COMPLETE)
            }
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black.copy(alpha = 0.85f))
            .zIndex(100f),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                IconButton(onClick = {
                    soundManager.playSound(SoundType.BUTTON_CLICK)
                    onDismiss()
                }) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = "Close tutorial",
                        tint = Color.White,
                        modifier = Modifier.size(32.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            AnimatedContent(
                targetState = currentStep,
                transitionSpec = {
                    fadeIn(animationSpec = tween(500)) togetherWith
                            fadeOut(animationSpec = tween(300))
                },
                label = "tutorial_step"
            ) { step ->
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(32.dp)
                ) {
                    TutorialStepText(step = step)

                    TutorialGrid(
                        words = tutorialWords,
                        highlightedWords = if (step >= 1) highlightedWords else emptySet(),
                        showLocked = step >= 3
                    )

                    if (step == 2) {
                        TutorialSubmitButton()
                    }

                    if (step == 3) {
                        LockedGroupDisplay()
                    }
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    repeat(totalSteps) { index ->
                        StepDot(isActive = index == currentStep)
                    }
                }

                if (currentStep < totalSteps - 1) {
                    Button(
                        onClick = {
                            soundManager.playSound(SoundType.BUTTON_CLICK)
                            currentStep++
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFFD4AF37)
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(56.dp),
                        shape = RoundedCornerShape(16.dp)
                    ) {
                        Text(
                            "Next",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    }
                } else {
                    Button(
                        onClick = {
                            soundManager.playSound(SoundType.LEVEL_COMPLETE)
                            onDismiss()
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF4CAF50)
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(56.dp),
                        shape = RoundedCornerShape(16.dp)
                    ) {
                        Text(
                            "Got it! Start Playing",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    }
                }

                if (currentStep > 0) {
                    TextButton(onClick = {
                        soundManager.playSound(SoundType.BUTTON_CLICK)
                        currentStep--
                    }) {
                        Text("Back", color = Color.White.copy(alpha = 0.7f))
                    }
                }
            }
        }
    }
}

@Composable
private fun TutorialStepText(step: Int) {
    val (title, description) = when (step) {
        0 -> "Welcome to Connections!" to "Group words that share a connection"
        1 -> "Select Related Words" to "These 4 words all belong to the same category"
        2 -> "Submit Your Group" to "Select 4 related words and tap Submit"
        3 -> "Group Locked!" to "Correct! The group locks together and you continue"
        else -> "" to ""
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = title,
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFFD4AF37),
            textAlign = TextAlign.Center
        )
        Text(
            text = description,
            fontSize = 16.sp,
            color = Color.White.copy(alpha = 0.9f),
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(horizontal = 16.dp)
        )
    }
}

@Composable
private fun TutorialGrid(
    words: List<String>,
    highlightedWords: Set<String>,
    showLocked: Boolean
) {
    val infiniteTransition = rememberInfiniteTransition(label = "pulse")
    val pulseScale = infiniteTransition.animateFloat(
        initialValue = 1f,
        targetValue = 1.05f,
        animationSpec = infiniteRepeatable(
            animation = tween(800),
            repeatMode = RepeatMode.Reverse
        ),
        label = "pulse"
    )

    if (showLocked) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .background(
                    color = Color(0xFF4CAF50).copy(alpha = 0.3f),
                    shape = RoundedCornerShape(16.dp)
                )
                .border(
                    width = 3.dp,
                    color = Color(0xFF4CAF50),
                    shape = RoundedCornerShape(16.dp)
                )
                .padding(16.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = "FRUITS",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF4CAF50)
                )
                Text(
                    text = highlightedWords.joinToString(" • "),
                    fontSize = 14.sp,
                    color = Color.White,
                    textAlign = TextAlign.Center
                )
            }
        }
    } else {
        LazyVerticalGrid(
            columns = GridCells.Fixed(4),
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(max = 300.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(words) { word ->
                val isHighlighted = word in highlightedWords

                Box(
                    modifier = Modifier
                        .aspectRatio(1f)
                        .scale(if (isHighlighted) pulseScale.value else 1f)
                        .background(
                            color = if (isHighlighted)
                                Color(0xFFD4AF37).copy(alpha = 0.4f)
                            else
                                Color(0xFF2C1810),
                            shape = RoundedCornerShape(8.dp)
                        )
                        .border(
                            width = if (isHighlighted) 3.dp else 1.dp,
                            color = if (isHighlighted)
                                Color(0xFFD4AF37)
                            else
                                Color(0xFF5A4A3A),
                            shape = RoundedCornerShape(8.dp)
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = word,
                        fontSize = 12.sp,
                        fontWeight = if (isHighlighted) FontWeight.Bold else FontWeight.Normal,
                        color = Color.White,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(4.dp)
                    )
                }
            }
        }
    }
}

@Composable
private fun TutorialSubmitButton() {
    val infiniteTransition = rememberInfiniteTransition(label = "glow")
    val glowAlpha = infiniteTransition.animateFloat(
        initialValue = 0.5f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(600),
            repeatMode = RepeatMode.Reverse
        ),
        label = "glow"
    )

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Button(
            onClick = { },
            enabled = false,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFD4AF37).copy(alpha = glowAlpha.value),
                disabledContainerColor = Color(0xFFD4AF37).copy(alpha = glowAlpha.value)
            ),
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            shape = RoundedCornerShape(12.dp)
        ) {
            Text(
                "SUBMIT",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }
    }
}

@Composable
private fun LockedGroupDisplay() {
    val scale = remember { Animatable(0.8f) }

    LaunchedEffect(Unit) {
        scale.animateTo(
            targetValue = 1f,
            animationSpec = spring(
                dampingRatio = Spring.DampingRatioMediumBouncy,
                stiffness = Spring.StiffnessLow
            )
        )
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .scale(scale.value)
            .padding(16.dp)
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        Color(0xFF4CAF50),
                        Color(0xFF66BB6A)
                    )
                ),
                shape = RoundedCornerShape(16.dp)
            )
            .padding(24.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = "✓",
                fontSize = 48.sp,
                color = Color.White
            )
            Text(
                text = "Perfect!",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }
    }
}

@Composable
private fun StepDot(isActive: Boolean) {
    Box(
        modifier = Modifier
            .size(if (isActive) 12.dp else 8.dp)
            .background(
                color = if (isActive) Color(0xFFD4AF37) else Color.White.copy(alpha = 0.3f),
                shape = RoundedCornerShape(50)
            )
    )
}
