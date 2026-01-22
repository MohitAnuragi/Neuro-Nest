package com.example.neuronest.auth

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.neuronest.R
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: () -> Unit) {
    var contentVisible by remember { mutableStateOf(false) }
    var logoScale by remember { mutableStateOf(0f) }
    var textScale by remember { mutableStateOf(0f) }
    var progressVisible by remember { mutableStateOf(false) }

    val animatedLogoScale by animateFloatAsState(
        targetValue = logoScale,
        animationSpec = tween(durationMillis = 700, easing = androidx.compose.animation.core.FastOutSlowInEasing)
    )

    val animatedTextScale by animateFloatAsState(
        targetValue = textScale,
        animationSpec = tween(durationMillis = 1000, easing = androidx.compose.animation.core.EaseOutBack)
    )

    LaunchedEffect(key1 = true) {
        // Show content with delay
        delay(300)
        contentVisible = true

        // Animate logo
        delay(200)
        logoScale = 1f

        // Animate text
        delay(200)
        textScale = 1f

        // Show progress
        delay(600)
        progressVisible = true

        // Wait for 3 seconds total and navigate
        delay(1500)
        navController()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.radialGradient(
                    colors = listOf(Color(0xFF2C1810), Color(0xFF4A2C1D)),
                    center = androidx.compose.ui.geometry.Offset.Unspecified,
                    radius = 800f,
                    tileMode = TileMode.Clamp
                )
            ),
        contentAlignment = Alignment.Center
    ) {
        // Wood texture background
        Image(
            painter = painterResource(id = R.drawable.wood_texture),
            contentDescription = "Wood background",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop,
            alpha = 0.7f
        )

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            // Animated logo
            AnimatedVisibility(
                visible = contentVisible,
                enter = fadeIn(animationSpec = tween(600)) +
                        slideInVertically(
                            animationSpec = tween(600),
                            initialOffsetY = { it / 6 }
                        )

            ) {
                Box(
                    modifier = Modifier
                        .size(150.dp)
                        .scale(animatedLogoScale)
                        .shadow(
                            elevation = 24.dp,
                            shape = RoundedCornerShape(32.dp),
                            spotColor = Color(0xFFFFD700)
                        )
                        .clip(RoundedCornerShape(32.dp))
                        .background(
                            brush = Brush.linearGradient(
                                colors = listOf(Color(0xFF2C1810), Color(0xFF4A2C1D)),
                                tileMode = TileMode.Repeated
                            )
                        )
                        .border(
                            width = 3.dp,
                            brush = Brush.linearGradient(
                                colors = listOf(Color(0xFFFFD700), Color(0xFFD4AF37)),
                                tileMode = TileMode.Repeated
                            ),
                            shape = RoundedCornerShape(32.dp)
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.logoneuro),
                        contentDescription = "Neuro Nest Logo",
                        modifier = Modifier.size(120.dp)
                    )

                }
            }

            // Animated app name
            AnimatedVisibility(
                visible = contentVisible,
                enter = fadeIn(animationSpec = tween(durationMillis = 1000, delayMillis = 500))
            ) {
                TypingText(
                    text = "NEURO NEST",
                    modifier = Modifier.scale(animatedTextScale),
                    typingSpeed = 70L,
                    textStyle = androidx.compose.ui.text.TextStyle(
                        fontSize = 36.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color(0xFFFFD700),
                        letterSpacing = 2.sp
                    )
                )

            }

            // Animated tagline
            AnimatedVisibility(
                visible = contentVisible,
                enter = fadeIn(animationSpec = tween(durationMillis = 1000, delayMillis = 800))
            ) {
                TypingText(
                    text = "Brain Training Puzzles",
                    modifier = Modifier.scale(animatedTextScale * 0.9f),
                    typingSpeed = 35L,
                    textStyle = androidx.compose.ui.text.TextStyle(
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color(0xFFD4AF37)
                    )
                )

            }

            // Animated progress indicator
            AnimatedVisibility(
                visible = progressVisible,
                enter = fadeIn(animationSpec = tween(durationMillis = 800))
            ) {
                Box(
                    modifier = Modifier
                        .width(200.dp)
                        .height(4.dp)
                        .clip(RoundedCornerShape(2.dp))
                        .background(Color(0x55FFFFFF)),
                    contentAlignment = Alignment.CenterStart
                ) {
                    // Animated progress bar
                    Box(
                        modifier = Modifier
                            .fillMaxHeight()
                            .width(animateFloatAsState(
                                targetValue = if (progressVisible) 200.dp.value else 0.dp.value,
                                animationSpec = tween(durationMillis = 2500, delayMillis = 200)
                            ).value.dp)
                            .clip(RoundedCornerShape(2.dp))
                            .background(
                                brush = Brush.horizontalGradient(
                                    colors = listOf(Color(0xFFFFD700), Color(0xFFD4AF37)),
                                    tileMode = TileMode.Repeated
                                )
                            )
                    )
                }
            }

            // Loading text with pulsing animation
            AnimatedVisibility(
                visible = progressVisible,
                enter = fadeIn(animationSpec = tween(durationMillis = 800, delayMillis = 300))
            ) {
                TypingText(
                    text = "Loading puzzles...",
                    modifier = Modifier.scale(
                        animateFloatAsState(
                            targetValue = if (progressVisible) 1f else 0.8f,
                            animationSpec = tween(durationMillis = 1000, delayMillis = 500)
                        ).value
                    ),
                    typingSpeed = 45L,
                    textStyle = androidx.compose.ui.text.TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color(0xAAFFFFFF)
                    )
                )

            }
        }

        // Golden particles effect (optional decorative elements)
        if (contentVisible) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.TopEnd
            ) {
                // Decorative golden elements
                Box(
                    modifier = Modifier
                        .size(80.dp)
                        .offset(x = (-20).dp, y = 60.dp)
                        .background(
                            brush = Brush.radialGradient(
                                colors = listOf(Color(0x55FFD700), Color(0x00FFD700)),
                                center = androidx.compose.ui.geometry.Offset(0.3f, 0.3f),
                                radius = 100f
                            ),
                            shape = RoundedCornerShape(40.dp)
                        )
                )
            }

            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.BottomStart
            ) {
                Box(
                    modifier = Modifier
                        .size(60.dp)
                        .offset(x = 40.dp, y = (-80).dp)
                        .background(
                            brush = Brush.radialGradient(
                                colors = listOf(Color(0x33D4AF37), Color(0x00D4AF37)),
                                center = androidx.compose.ui.geometry.Offset(0.7f, 0.7f),
                                radius = 80f
                            ),
                            shape = RoundedCornerShape(30.dp)
                        )
                )
            }
        }
    }
}


@Composable
fun TypingText(
    text: String,
    modifier: Modifier = Modifier,
    textStyle: androidx.compose.ui.text.TextStyle,
    typingSpeed: Long = 40L // ms per character
) {
    var displayedText by remember { mutableStateOf("") }

    LaunchedEffect(text) {
        displayedText = ""
        text.forEach { char ->
            displayedText += char
            delay(typingSpeed)
        }
    }

    Text(
        text = displayedText,
        modifier = modifier,
        style = textStyle
    )
}
