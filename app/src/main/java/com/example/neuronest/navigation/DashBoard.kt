package com.example.neuronest.navigation

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.neuronest.R
import kotlinx.coroutines.delay

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PuzzleSelectionScreen(
    navController: NavController, isMusicPlaying: Boolean,
    onToggleMusic: (Boolean) -> Unit
) {
    val puzzles = listOf(
        PuzzleItem("Arithmetic", PuzzleRoutes.Arithmetic, R.drawable.arithmatic,"Arithmetic"),
        PuzzleItem("Word Scramble", PuzzleRoutes.WordScramble, R.drawable.scramble,"WordScramble"),
        PuzzleItem("Kakuro Puzzle", PuzzleRoutes.Kakuro, R.drawable.kakuro,"Kakuro"),
        PuzzleItem("Sequence Generator", PuzzleRoutes.SequenceGenerator, R.drawable.sequencepuzzle,"SequenceGenerator"),
        PuzzleItem("Futoshiki Puzzle", PuzzleRoutes.Futoshiki, R.drawable.futoshiki,"FutoshikiPuzzle"),
        PuzzleItem("Sudoku Puzzle", PuzzleRoutes.Sudoku, R.drawable.sudoku,"SudokuPuzzle"),
        PuzzleItem("Cryptic Puzzle", PuzzleRoutes.Cryptic, R.drawable.cryptic,"CrypticPuzzle"),
        PuzzleItem("Logic Puzzles", PuzzleRoutes.Logic, R.drawable.logicpuzzle,"LogicPuzzles")
    )

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
                        text = "SELECT PUZZLE",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center
                    )
                },
                navigationIcon = {
                    IconButton(
                        onClick = { navController.navigate(PuzzleRoutes.ProfileSetup.route) },
                        modifier = Modifier.scale(
                            animateFloatAsState(
                                targetValue = if (isContentLoaded) 1f else 0.8f
                            ).value
                        )
                    ) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back",
                            tint = Color.White
                        )
                    }
                },
                actions = {
                    IconButton(onClick = { onToggleMusic(!isMusicPlaying) }) {
                        Icon(
                            imageVector = if (isMusicPlaying) Icons.Default.MusicNote else Icons.Default.MusicOff,
                            contentDescription = "Toggle Music",
                            tint = Color.White
                        )
                    }
                    IconButton(
                        onClick = { navController.navigate(PuzzleRoutes.Profile.route) },
                        modifier = Modifier.scale(
                            animateFloatAsState(
                                targetValue = if (isContentLoaded) 1f else 0.8f
                            ).value
                        )
                    ) {
                        Icon(
                            imageVector = Icons.Default.Person,
                            contentDescription = "Profile",
                            tint = Color.White
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF2C1810),
                    titleContentColor = Color.White,
                    actionIconContentColor = Color.White
                )
            )
        }
    ) { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            // Wood textured background
            Image(
                painter = painterResource(id = R.drawable.wood_texture),
                contentDescription = "Wood background",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )

            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(puzzles) { puzzle ->
                    PuzzleGridItem(
                        puzzle = puzzle,
                        onClick = {  navController.navigate("${PuzzleRoutes.LevelGrid.route}/${puzzle.puzzleType}") },
                        isContentLoaded = isContentLoaded,
                        delay = puzzles.indexOf(puzzle) * 100
                    )
                }
            }
        }
    }
}

@Composable
fun PuzzleGridItem(
    puzzle: PuzzleItem,
    onClick: (PuzzleRoutes) -> Unit,
    isContentLoaded: Boolean,
    delay: Int = 0
) {
    Card(
        onClick = { onClick(puzzle.route) },
        modifier = Modifier
            .fillMaxWidth()
            .scale(
                animateFloatAsState(
                    targetValue = if (isContentLoaded) 1f else 0.8f,
                    animationSpec = androidx.compose.animation.core.tween(
                        durationMillis = 600,
                        delayMillis = delay
                    )
                ).value
            )
            .shadow(
                elevation = 16.dp,
                shape = RoundedCornerShape(20.dp),
                spotColor = Color(0xFFFFD700)
            ),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.Transparent
        )
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(Color(0xFF2C1810), Color(0xFF4A2C1D)),
                        tileMode = TileMode.Repeated
                    )
                )
                .clip(RoundedCornerShape(20.dp))
                .border(
                    width = 2.dp,
                    brush = Brush.linearGradient(
                        colors = listOf(Color(0xFFFFD700), Color(0xFFD4AF37)),
                        tileMode = TileMode.Repeated
                    ),
                    shape = RoundedCornerShape(20.dp)
                )
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .padding(20.dp)
                    .fillMaxSize()
            ) {
                // Puzzle icon with golden border
                Box(
                    modifier = Modifier
                        .size(80.dp)
                        .shadow(
                            elevation = 12.dp,
                            shape = RoundedCornerShape(16.dp),
                            spotColor = Color(0xFFFFD700)
                        )
                        .clip(RoundedCornerShape(16.dp))
                        .background(Color(0xFF2C1810))
                        .border(
                            width = 2.dp,
                            brush = Brush.linearGradient(
                                colors = listOf(Color(0xFFFFD700), Color(0xFFD4AF37)),
                                tileMode = TileMode.Repeated
                            ),
                            shape = RoundedCornerShape(16.dp)
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = puzzle.iconRes),
                        contentDescription = puzzle.title,
                        modifier = Modifier
                            .size(50.dp)
                            .scale(
                                animateFloatAsState(
                                    targetValue = if (isContentLoaded) 1f else 0.5f,
                                    animationSpec = androidx.compose.animation.core.tween(
                                        durationMillis = 400,
                                        delayMillis = delay + 200
                                    )
                                ).value
                            ),
                        contentScale = ContentScale.Fit
                    )
                }

                Spacer(modifier = Modifier.height(12.dp))

                // Puzzle title
                Text(
                    text = puzzle.title,
                    style = MaterialTheme.typography.titleMedium.copy(
                        color = Color(0xFFFFD700),
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        fontSize = 14.sp
                    ),
                    modifier = Modifier.fillMaxWidth()
                )

                // Subtle decorative elements
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(2.dp)
                        .padding(horizontal = 20.dp)
                        .background(
                            brush = Brush.horizontalGradient(
                                colors = listOf(
                                    Color.Transparent,
                                    Color(0x55FFD700),
                                    Color.Transparent
                                )
                            )
                        )
                )
            }
        }
    }
}
