package com.example.neuronest.profile

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ExitToApp
import androidx.compose.material.icons.filled.Edit
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.example.neuronest.R
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

/**
 * Extension function to format timestamp to user-friendly date
 * Format: "Joined: Aug 2025"
 */
private fun Long.toFormattedJoinDate(): String {
    return try {
        val sdf = SimpleDateFormat("MMM yyyy", Locale.getDefault())
        "Joined: ${sdf.format(Date(this))}"
    } catch (e: Exception) {
        "—"
    }
}

/**
 * Main Profile Screen
 *
 * Displays:
 * - Profile image (circular)
 * - Display name
 * - Join date
 * - Puzzle progress overview (per puzzle type)
 *
 * All data loaded from Room database via ViewModel
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(
    viewModel: ProfileViewModel = hiltViewModel(),
    onBack: () -> Unit = {},
    onSignOut: () -> Unit = {},
    onEditProfile: () -> Unit = {}
) {
    // Observe profile data from ViewModel
    val profile by viewModel.profile.collectAsState()
    val puzzleProgress by viewModel.puzzleProgress.collectAsState()

    // Animation state
    var isContentLoaded by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        viewModel.refresh()
        kotlinx.coroutines.delay(300)
        isContentLoaded = true
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "Your Profile",
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back",
                            tint = Color.White
                        )
                    }
                },
                actions = {
                    IconButton(onClick = onEditProfile) {
                        Icon(
                            imageVector = Icons.Default.Edit,
                            contentDescription = "Edit Profile",
                            tint = Color.White
                        )
                    }
                    IconButton(onClick = onSignOut) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ExitToApp,
                            contentDescription = "Sign Out",
                            tint = Color.White
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF2C1810),
                    titleContentColor = Color.White
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

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                // Profile Header (image, name, join date)
                ProfileHeader(
                    profile = profile,
                    isContentLoaded = isContentLoaded
                )

                // Puzzle Progress Section
                PuzzleProgressSection(
                    puzzleProgress = puzzleProgress,
                    isContentLoaded = isContentLoaded
                )
            }
        }
    }
}

/**
 * Profile Header Component
 *
 * Displays:
 * - Circular profile image (or placeholder)
 * - Display name (bold, centered)
 * - Join date (formatted)
 */
@Composable
fun ProfileHeader(
    profile: UserProfile?,
    isContentLoaded: Boolean
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .shadow(
                elevation = 16.dp,
                shape = RoundedCornerShape(16.dp),
                spotColor = Color(0xFFFFD700)
            )
            .scale(
                animateFloatAsState(
                    targetValue = if (isContentLoaded) 1f else 0.96f,
                    animationSpec = tween(durationMillis = 600),
                    label = "headerScale"
                ).value
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
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                // Profile Image - Circular with golden border
                Box(
                    modifier = Modifier
                        .size(120.dp)
                        .border(
                            width = 3.dp,
                            brush = Brush.linearGradient(
                                colors = listOf(Color(0xFFFFD700), Color(0xFFD4AF37))
                            ),
                            shape = CircleShape
                        )
                        .padding(3.dp)
                        .background(Color(0xFF2C1810), CircleShape)
                        .clip(CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    val imageUri = profile?.profileImageUri
                    if (!imageUri.isNullOrEmpty() && imageUri != "null" && imageUri.isNotBlank()) {
                        Image(
                            painter = rememberAsyncImagePainter(
                                model = imageUri,
                                error = painterResource(id = R.drawable.ic_launcher_foreground)
                            ),
                            contentDescription = "Profile Image",
                            modifier = Modifier
                                .fillMaxSize()
                                .clip(CircleShape),
                            contentScale = ContentScale.Crop
                        )
                    } else {
                        // Placeholder icon when no image
                        Icon(
                            imageVector = Icons.Default.Person,
                            contentDescription = "Default Profile",
                            modifier = Modifier.size(48.dp),
                            tint = Color(0xFFD4AF37)
                        )
                    }
                }

                // Display Name
                Text(
                    text = if (!profile?.displayName.isNullOrBlank() && profile?.displayName != "Guest User") {
                        profile.displayName
                    } else {
                        "Guest User"
                    },
                    style = MaterialTheme.typography.headlineSmall.copy(
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                )

                // Join Date
                Text(
                    text = profile?.joinDate?.toFormattedJoinDate() ?: "—",
                    style = MaterialTheme.typography.bodyMedium.copy(
                        color = Color(0xFFD4AF37)
                    )
                )
            }
        }
    }
}

/**
 * Puzzle Progress Section
 *
 * Displays progress for each puzzle type from the database
 */
@Composable
fun PuzzleProgressSection(
    puzzleProgress: List<PuzzleProgressData>,
    isContentLoaded: Boolean
) {
    if (puzzleProgress.isEmpty()) {
        // Empty state - no progress yet
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .shadow(
                    elevation = 12.dp,
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
                            colors = listOf(Color(0xFF2C1810), Color(0xFF4A2C1D))
                        )
                    )
                    .padding(24.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    "No puzzle progress yet. Start playing to see your stats!",
                    style = MaterialTheme.typography.bodyMedium.copy(
                        color = Color(0xFFD4AF37)
                    )
                )
            }
        }
        return
    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .shadow(
                elevation = 12.dp,
                shape = RoundedCornerShape(16.dp),
                spotColor = Color(0xFFFFD700)
            )
            .scale(
                animateFloatAsState(
                    targetValue = if (isContentLoaded) 1f else 0.96f,
                    animationSpec = tween(durationMillis = 600, delayMillis = 100),
                    label = "progressScale"
                ).value
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
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Text(
                    "Puzzle Progress",
                    style = MaterialTheme.typography.headlineSmall.copy(
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    ),
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )

                Spacer(modifier = Modifier.height(8.dp))

                puzzleProgress.forEachIndexed { index, progress ->
                    PuzzleProgressItem(
                        puzzleProgress = progress,
                        isContentLoaded = isContentLoaded,
                        delay = index * 100
                    )
                }
            }
        }
    }
}

/**
 * Individual Puzzle Progress Item
 *
 * Shows:
 * - Puzzle type name
 * - Solved / Total count
 * - Progress bar
 */
@Composable
fun PuzzleProgressItem(
    puzzleProgress: PuzzleProgressData,
    isContentLoaded: Boolean,
    delay: Int = 0
) {
    val progress = if (puzzleProgress.totalCount > 0) {
        puzzleProgress.solvedCount.toFloat() / puzzleProgress.totalCount.toFloat()
    } else {
        0f
    }

    val animatedProgress = animateFloatAsState(
        targetValue = if (isContentLoaded) progress else 0f,
        animationSpec = tween(durationMillis = 800, delayMillis = delay + 200),
        label = "progress_${puzzleProgress.puzzleType}"
    )

    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        // Puzzle name and count
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = puzzleProgress.puzzleType,
                style = MaterialTheme.typography.bodyLarge.copy(
                    color = Color.White,
                    fontWeight = FontWeight.Medium
                )
            )

            Text(
                text = "${puzzleProgress.solvedCount} / ${puzzleProgress.totalCount}",
                style = MaterialTheme.typography.bodyMedium.copy(
                    color = Color(0xFFD4AF37),
                    fontWeight = FontWeight.Bold
                )
            )
        }

        // Progress bar
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(8.dp)
                .clip(RoundedCornerShape(4.dp))
                .background(Color(0xFF3D3D3D))
        ) {
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(animatedProgress.value)
                    .clip(RoundedCornerShape(4.dp))
                    .background(
                        brush = Brush.horizontalGradient(
                            colors = listOf(Color(0xFFFFD700), Color(0xFFD4AF37))
                        )
                    )
            )
        }
    }
}
