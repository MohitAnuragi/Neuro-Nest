package com.example.neuronest.bulbSwitch

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.MusicNote
import androidx.compose.material.icons.filled.MusicOff
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RadialGradient
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.neuronest.R
import kotlinx.coroutines.delay

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BulbSwitchPuzzleScreen(
    onBack: () -> Unit = {},
    viewModel: BulbSwitchViewModel = hiltViewModel(),

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
                        "3 Bulbs, 3 Switches Puzzle",
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

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(24.dp)
            ) {
                item {
                    // Instructions
                    InstructionsText(
                        message = uiState.message,
                        isContentLoaded = isContentLoaded
                    )
                }

                item {
                    // Bulbs Display
                    BulbsDisplay(
                        uiState = uiState,
                        isContentLoaded = isContentLoaded
                    )
                }

                item {
                    // Switches Display
                    SwitchesDisplay(
                        uiState = uiState,
                        onToggleSwitch = { viewModel.toggleSwitch(it) },
                        isContentLoaded = isContentLoaded
                    )
                }

                item {
                    // Action Buttons
                    ActionButtons(
                        uiState = uiState,
                        onCheckBulbs = { viewModel.checkBulbs() },
                        onNewPuzzle = { viewModel.generateNewPuzzle() },
                        onShowSolution = { viewModel.showSolution() },
                        isContentLoaded = isContentLoaded
                    )
                }

                if (uiState.hasAttempted && !uiState.isSolved) {
                    item {
                        SolutionPrompt(
                            isContentLoaded = isContentLoaded,
                            onShowSolution = { viewModel.showSolution() }
                        )
                    }
                }

                if (uiState.showSolution) {
                    item {
                        SolutionDisplay(
                            uiState = uiState,
                            onNewPuzzle = { viewModel.generateNewPuzzle() },
                            isContentLoaded = isContentLoaded
                        )
                    }
                }
            }
        }
    }
}






@Composable
fun InstructionsText(message: String, isContentLoaded: Boolean) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .scale(animateFloatAsState(
                targetValue = if (isContentLoaded) 1f else 0.9f,
                animationSpec = androidx.compose.animation.core.tween(durationMillis = 600)
            ).value)
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
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = message,
            fontSize = 16.sp,
            color = Color.White,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Medium
        )
    }
}

@Composable
fun BulbsDisplay(uiState: BulbSwitchUiState, isContentLoaded: Boolean) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .scale(animateFloatAsState(
                targetValue = if (isContentLoaded) 1f else 0.9f,
                animationSpec = androidx.compose.animation.core.tween(durationMillis = 600, delayMillis = 100)
            ).value)
            .shadow(
                elevation = 16.dp,
                shape = RoundedCornerShape(16.dp),
                spotColor = Color(0xFFFFD700)
            ),
        shape = RoundedCornerShape(16.dp)
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
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxWidth()
            ) {
                RealisticBulb(
                    isLit = uiState.revealBulbs && uiState.bulbStates[0],
                    temperature = uiState.bulbTemperatures[0],
                    label = "Bulb 1",
                    isContentLoaded = isContentLoaded,
                    delay = 0
                )
                RealisticBulb(
                    isLit = uiState.revealBulbs && uiState.bulbStates[1],
                    temperature = uiState.bulbTemperatures[1],
                    label = "Bulb 2",
                    isContentLoaded = isContentLoaded,
                    delay = 100
                )
                RealisticBulb(
                    isLit = uiState.revealBulbs && uiState.bulbStates[2],
                    temperature = uiState.bulbTemperatures[2],
                    label = "Bulb 3",
                    isContentLoaded = isContentLoaded,
                    delay = 200
                )
            }
        }
    }
}

@Composable
fun RealisticBulb(
    isLit: Boolean,
    temperature: Int,
    label: String,
    isContentLoaded: Boolean,
    delay: Int = 0
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.scale(animateFloatAsState(
            targetValue = if (isContentLoaded) 1f else 0.8f,
            animationSpec = androidx.compose.animation.core.tween(durationMillis = 400, delayMillis = delay)
        ).value)
    ) {
        // Bulb socket
        Box(
            modifier = Modifier
                .width(40.dp)
                .height(20.dp)
                .background(Color(0xFF8D8D8D), RoundedCornerShape(4.dp))
        )

        // Bulb glass part
        Box(
            modifier = Modifier
                .size(80.dp)
                .shadow(
                    elevation = if (isLit) 16.dp else 8.dp,
                    shape = RoundedCornerShape(40.dp),
                    spotColor = if (isLit) Color(0xFFFFD700) else Color.Gray
                )
        ) {
            Canvas(modifier = Modifier.fillMaxSize()) {
                // Draw bulb glass
                drawCircle(
                    color = if (isLit) Color(0x88FFFFFF) else Color(0x88E0E0E0),
                    radius = size.minDimension / 2,
                    center = Offset(size.width / 2, size.height / 2),
                    style = Stroke(2.dp.toPx())
                )

                // Draw filament if lit
                if (isLit) {
                    val filamentColor = when (temperature) {
                        2 -> Color(0xFFFF5252) // Hot - red
                        1 -> Color(0xFFFFB74D) // Warm - orange
                        else -> Color(0xFFFFFFFF) // Cold - white
                    }

                    drawCircle(
                        color = filamentColor,
                        radius = size.minDimension / 6,
                        center = Offset(size.width / 2, size.height / 2)
                    )

                    // Draw glow effect
                    if (temperature > 0) {
                        drawCircle(
                            brush = Brush.radialGradient(
                                colors = listOf(filamentColor.copy(alpha = 0.5f), Color.Transparent),
                                center = Offset(size.width / 2, size.height / 2),
                                radius = size.minDimension / 2
                            ),
                            radius = size.minDimension / 2,
                            center = Offset(size.width / 2, size.height / 2)
                        )
                    }
                }
            }
        }

        // Temperature indicator
        Text(
            text = when (temperature) {
                2 -> "Hot"
                1 -> "Warm"
                else -> "Cold"
            },
            color = when (temperature) {
                2 -> Color(0xFFFF5252)
                1 -> Color(0xFFFFB74D)
                else -> Color(0xFF64B5F6)
            },
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold
        )

        // Bulb label
        Text(
            text = label,
            color = Color.White,
            fontSize = 14.sp,
            modifier = Modifier.padding(top = 4.dp)
        )
    }
}

@Composable
fun SwitchesDisplay(
    uiState: BulbSwitchUiState,
    onToggleSwitch: (Int) -> Unit,
    isContentLoaded: Boolean
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .scale(animateFloatAsState(
                targetValue = if (isContentLoaded) 1f else 0.9f,
                animationSpec = androidx.compose.animation.core.tween(durationMillis = 600, delayMillis = 200)
            ).value)
            .shadow(
                elevation = 16.dp,
                shape = RoundedCornerShape(16.dp),
                spotColor = Color(0xFFFFD700)
            ),
        shape = RoundedCornerShape(16.dp)
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
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxWidth()
            ) {
                RealisticSwitch(
                    isToggled = uiState.switches[0],
                    onClick = { onToggleSwitch(0) },
                    label = "Switch 1",
                    enabled = !uiState.hasAttempted && !uiState.isSolved,
                    isContentLoaded = isContentLoaded,
                    delay = 0
                )
                RealisticSwitch(
                    isToggled = uiState.switches[1],
                    onClick = { onToggleSwitch(1) },
                    label = "Switch 2",
                    enabled = !uiState.hasAttempted && !uiState.isSolved,
                    isContentLoaded = isContentLoaded,
                    delay = 100
                )
                RealisticSwitch(
                    isToggled = uiState.switches[2],
                    onClick = { onToggleSwitch(2) },
                    label = "Switch 3",
                    enabled = !uiState.hasAttempted && !uiState.isSolved,
                    isContentLoaded = isContentLoaded,
                    delay = 200
                )
            }
        }
    }
}

@Composable
fun RealisticSwitch(
    isToggled: Boolean,
    onClick: () -> Unit,
    label: String,
    enabled: Boolean,
    isContentLoaded: Boolean,
    delay: Int = 0
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .clickable(enabled = enabled) { onClick() }
            .scale(animateFloatAsState(
                targetValue = if (isContentLoaded) 1f else 0.8f,
                animationSpec = androidx.compose.animation.core.tween(durationMillis = 400, delayMillis = delay)
            ).value)
    ) {
        // Switch base
        Box(
            modifier = Modifier
                .width(50.dp)
                .height(80.dp)
                .background(Color(0xFF8D8D8D), RoundedCornerShape(8.dp))
                .border(
                    width = 2.dp,
                    brush = Brush.linearGradient(
                        colors = listOf(Color(0xFFFFD700), Color(0xFFD4AF37)),
                        tileMode = TileMode.Repeated
                    ),
                    shape = RoundedCornerShape(8.dp)
                )
        ) {
            // Switch lever
            Box(
                modifier = Modifier
                    .width(30.dp)
                    .height(40.dp)
                    .background(
                        if (isToggled) Color(0xFF4CAF50) else Color(0xFFF44336),
                        RoundedCornerShape(4.dp)
                    )
                    .align(if (isToggled) Alignment.TopCenter else Alignment.BottomCenter)
            )
        }

        // Switch label
        Text(
            text = label,
            color = Color.White,
            fontSize = 14.sp,
            modifier = Modifier.padding(top = 8.dp)
        )

        // Status indicator
        Text(
            text = if (isToggled) "ON" else "OFF",
            color = if (isToggled) Color(0xFF4CAF50) else Color(0xFFF44336),
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun ActionButtons(
    uiState: BulbSwitchUiState,
    onCheckBulbs: () -> Unit,
    onNewPuzzle: () -> Unit,
    onShowSolution: () -> Unit,
    isContentLoaded: Boolean
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier
            .fillMaxWidth()
            .scale(animateFloatAsState(
                targetValue = if (isContentLoaded) 1f else 0.9f,
                animationSpec = androidx.compose.animation.core.tween(durationMillis = 600, delayMillis = 300)
            ).value)
    ) {
        Button(
            onClick = onCheckBulbs,
            enabled = !uiState.hasAttempted && !uiState.isSolved,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFD4AF37),
                contentColor = Color.White
            ),
            modifier = Modifier.weight(1f),
            elevation = ButtonDefaults.buttonElevation(
                defaultElevation = 8.dp,
                pressedElevation = 4.dp
            )
        ) {
            Text("CHECK BULBS", fontWeight = FontWeight.Bold)
        }

        Button(
            onClick = onNewPuzzle,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF2C1810),
                contentColor = Color.White
            ),
            modifier = Modifier.weight(1f),
            elevation = ButtonDefaults.buttonElevation(
                defaultElevation = 8.dp,
                pressedElevation = 4.dp
            )
        ) {
            Text("NEW PUZZLE", fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
fun SolutionPrompt(isContentLoaded: Boolean, onShowSolution: () -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier
            .fillMaxWidth()
            .scale(animateFloatAsState(
                targetValue = if (isContentLoaded) 1f else 0.9f,
                animationSpec = androidx.compose.animation.core.tween(durationMillis = 600, delayMillis = 400)
            ).value)
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
            .padding(16.dp)
    ) {
        Text(
            text = "Submit your solution:",
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.White,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        Button(
            onClick = onShowSolution,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFA0522D),
                contentColor = Color.White
            ),
            elevation = ButtonDefaults.buttonElevation(
                defaultElevation = 8.dp,
                pressedElevation = 4.dp
            )
        ) {
            Text("REVEAL SOLUTION", fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
fun SolutionDisplay(
    uiState: BulbSwitchUiState,
    onNewPuzzle: () -> Unit,
    isContentLoaded: Boolean
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .scale(animateFloatAsState(
                targetValue = if (isContentLoaded) 1f else 0.9f,
                animationSpec = androidx.compose.animation.core.tween(durationMillis = 600, delayMillis = 500)
            ).value)
            .background(
                color = Color(0xFF2C1810),
                shape = RoundedCornerShape(16.dp)
            )
            .border(
                width = 2.dp,
                brush = Brush.linearGradient(
                    colors = listOf(Color(0xFFD4AF37), Color(0xFFFFD700)),
                    tileMode = TileMode.Repeated
                ),
                shape = RoundedCornerShape(16.dp)
            )
            .padding(24.dp)
    ) {
        Text(
            text = "Solution:",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFFFFD700),
            modifier = Modifier.padding(bottom = 16.dp)
        )

        uiState.switchMapping.entries.sortedBy { it.key }.forEach { (switch, bulb) ->
            Text(
                text = "Switch ${switch + 1} controls Bulb ${bulb + 1}",
                fontSize = 16.sp,
                color = Color.White,
                modifier = Modifier.padding(vertical = 8.dp)
            )
        }

        if (!uiState.isSolved) {
            Button(
                onClick = onNewPuzzle,
                modifier = Modifier.padding(top = 16.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFD4AF37),
                    contentColor = Color.White
                ),
                elevation = ButtonDefaults.buttonElevation(
                    defaultElevation = 8.dp,
                    pressedElevation = 4.dp
                )
            ) {
                Text("TRY ANOTHER PUZZLE", fontWeight = FontWeight.Bold)
            }
        }
    }
}