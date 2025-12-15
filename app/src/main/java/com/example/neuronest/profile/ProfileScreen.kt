package com.example.neuronest.profile

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import androidx.compose.animation.core.animateDpAsState
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
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.neuronest.R
import java.io.InputStream
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import kotlin.math.round

// Extension functions for formatting
private fun Long.toFormattedDate(): String {
    return SimpleDateFormat("MMM dd, yyyy", Locale.getDefault()).format(Date(this))
}

private fun Double.format(decimalPlaces: Int): String {
    val factor = Math.pow(10.0, decimalPlaces.toDouble())
    return (round(this * factor) / factor).toString()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(
    viewModel: ProfileViewModel = hiltViewModel(),
    onSignOut: () -> Unit = {}
) {
    val profile by viewModel.profile.collectAsState()
    val achievements by viewModel.achievements.collectAsState()
    var isContentLoaded by rememberSaveable { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        // Simulate loading delay for animations
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
                actions = {
                    IconButton(
                        onClick = onSignOut,
                        modifier = Modifier.scale(animateFloatAsState(
                            targetValue = if (isContentLoaded) 1f else 0.8f,
                            animationSpec = tween(durationMillis = 500)
                        ).value)
                    ) {
                        Icon(
                            imageVector = Icons.Default.ExitToApp,
                            contentDescription = "Sign Out",
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
                painter = rememberAsyncImagePainter(R.drawable.wood_texture),
                contentDescription = "Wood background",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Animated entrance for profile header
                val headerPadding by animateDpAsState(
                    targetValue = if (isContentLoaded) 0.dp else 100.dp,
                    animationSpec = tween(durationMillis = 800)
                )

                Box(
                    modifier = Modifier
                        .offset(y = headerPadding)
                        .alpha(animateFloatAsState(
                            targetValue = if (isContentLoaded) 1f else 0f,
                            animationSpec = tween(durationMillis = 800)
                        ).value)
                ) {
                    ProfileHeader(profile, isContentLoaded)
                }

                Spacer(modifier = Modifier.height(24.dp))

                // Stats overview with staggered animation
                StatsOverview(profile, isContentLoaded)

                Spacer(modifier = Modifier.height(24.dp))

                // Puzzle type stats
                PuzzleTypeStats(profile, isContentLoaded)

                Spacer(modifier = Modifier.height(24.dp))

                // Achievements section
                AchievementsSection(achievements, isContentLoaded)

                Spacer(modifier = Modifier.height(24.dp))
            }
        }
    }
}

@Composable
fun ProfileHeader(profile: UserProfile?, isContentLoaded: Boolean) {
    val context = LocalContext.current
    val profileImageUri by remember(profile?.profileImageUri) {
        derivedStateOf {
            if (!profile?.profileImageUri.isNullOrEmpty()) {
                try {
                    Uri.parse(profile?.profileImageUri)
                } catch (e: Exception) {
                    null
                }
            } else {
                null
            }
        }
    }

    val bitmapState = remember(profileImageUri) { mutableStateOf<Bitmap?>(null) }
    val isLoading = remember(profileImageUri) { mutableStateOf(false) }

    LaunchedEffect(profileImageUri) {
        if (profileImageUri != null) {
            isLoading.value = true
            try {
                val inputStream: InputStream? = context.contentResolver.openInputStream(profileImageUri!!)
                inputStream?.use { stream ->
                    bitmapState.value = BitmapFactory.decodeStream(stream)
                }
            } catch (e: Exception) {
                e.printStackTrace()
                bitmapState.value = null
            } finally {
                isLoading.value = false
            }
        } else {
            bitmapState.value = null
        }
    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .shadow(
                elevation = 16.dp,
                shape = RoundedCornerShape(16.dp),
                spotColor = Color(0xFFFFD700)
            )
            .scale(animateFloatAsState(
                targetValue = if (isContentLoaded) 1f else 0.9f,
                animationSpec = tween(durationMillis = 600)
            ).value),
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
                    .padding(24.dp)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Profile Image with golden border
                Box(
                    modifier = Modifier
                        .size(120.dp)
                        .border(
                            width = 3.dp,
                            brush = Brush.linearGradient(
                                colors = listOf(Color(0xFFFFD700), Color(0xFFD4AF37)),
                                tileMode = TileMode.Repeated
                            ),
                            shape = CircleShape
                        )
                        .padding(3.dp)
                        .background(Color(0xFF2C1810), CircleShape)
                        .clip(CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    if (isLoading.value) {
                        CircularProgressIndicator(
                            color = Color(0xFFD4AF37),
                            modifier = Modifier.size(24.dp)
                        )
                    } else if (bitmapState.value != null) {
                        Image(
                            bitmap = bitmapState.value!!.asImageBitmap(),
                            contentDescription = "Profile Image",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop
                        )
                    } else {
                        Icon(
                            imageVector = Icons.Default.Person,
                            contentDescription = "Default Profile",
                            modifier = Modifier.size(48.dp),
                            tint = Color(0xFFD4AF37)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Display name
                Text(
                    text = if (!profile?.displayName.isNullOrEmpty()) {
                        profile?.displayName ?: "Puzzle Solver"
                    } else {
                        profile?.username ?: "Puzzle Solver"
                    },
                    style = MaterialTheme.typography.headlineSmall.copy(
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    ),
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )

                Spacer(modifier = Modifier.height(8.dp))

                // Join date
                Text(
                    text = "Joined: ${profile?.joinDate?.toFormattedDate() ?: "Today"}",
                    style = MaterialTheme.typography.bodySmall.copy(
                        color = Color(0xFFD4AF37)
                    ),
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
            }
        }
    }
}

@Composable
fun StatsOverview(profile: UserProfile?, isContentLoaded: Boolean) {
    val items = listOf(
        "Total Puzzles Solved" to (profile?.totalPuzzlesSolved?.toString() ?: "0"),
        "Total Score" to (profile?.totalScore?.toString() ?: "0"),
        "Accuracy" to "${profile?.averageAccuracy?.format(1) ?: "0"}%",
        "Current Streak" to "${profile?.currentStreak ?: 0} days"
    )

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .shadow(
                elevation = 12.dp,
                shape = RoundedCornerShape(16.dp),
                spotColor = Color(0xFFFFD700)
            )
            .scale(animateFloatAsState(
                targetValue = if (isContentLoaded) 1f else 0.9f,
                animationSpec = tween(durationMillis = 600, delayMillis = 100)
            ).value),
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
                    .padding(24.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    "Overall Stats",
                    style = MaterialTheme.typography.headlineSmall.copy(
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    ),
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )

                Spacer(modifier = Modifier.height(16.dp))

                items.forEachIndexed { index, (label, value) ->
                    StatItem(
                        label = label,
                        value = value,
                        isContentLoaded = isContentLoaded,
                        delay = index * 100
                    )
                    if (index < items.size - 1) {
                        Spacer(modifier = Modifier.height(12.dp))
                    }
                }
            }
        }
    }
}

@Composable
fun StatItem(label: String, value: String, isContentLoaded: Boolean, delay: Int = 0) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
            .alpha(animateFloatAsState(
                targetValue = if (isContentLoaded) 1f else 0f,
                animationSpec = tween(durationMillis = 400, delayMillis = delay)
            ).value)
            .offset(x = animateDpAsState(
                targetValue = if (isContentLoaded) 0.dp else 20.dp,
                animationSpec = tween(durationMillis = 400, delayMillis = delay)
            ).value),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "$label:",
            style = MaterialTheme.typography.bodyMedium.copy(
                color = Color.White
            ),
            modifier = Modifier.weight(1f)
        )
        Text(
            text = value,
            style = MaterialTheme.typography.bodyLarge.copy(
                fontWeight = FontWeight.Bold,
                color = Color(0xFFD4AF37)
            )
        )
    }
}

@Composable
fun PuzzleTypeStats(profile: UserProfile?, isContentLoaded: Boolean) {
    val stats = profile?.getPuzzleStatsMap() ?: emptyMap()

    if (stats.isNotEmpty()) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .shadow(
                    elevation = 12.dp,
                    shape = RoundedCornerShape(16.dp),
                    spotColor = Color(0xFFFFD700)
                )
                .scale(animateFloatAsState(
                    targetValue = if (isContentLoaded) 1f else 0.9f,
                    animationSpec = tween(durationMillis = 600, delayMillis = 200)
                ).value),
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
                        .padding(24.dp)
                        .fillMaxWidth()
                ) {
                    Text(
                        "Puzzle Type Stats",
                        style = MaterialTheme.typography.headlineSmall.copy(
                            color = Color.White,
                            fontWeight = FontWeight.Bold
                        ),
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    stats.entries.forEachIndexed { index, (type, typeStats) ->
                        StatItem(
                            label = type,
                            value = "${typeStats.solved}/${typeStats.attempted} (${typeStats.accuracy.format(1)}%)",
                            isContentLoaded = isContentLoaded,
                            delay = 200 + index * 100
                        )
                        if (index < stats.size - 1) {
                            Spacer(modifier = Modifier.height(8.dp))
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun AchievementsSection(achievements: List<Achievement>, isContentLoaded: Boolean) {
    if (achievements.isNotEmpty()) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .shadow(
                    elevation = 12.dp,
                    shape = RoundedCornerShape(16.dp),
                    spotColor = Color(0xFFFFD700)
                )
                .scale(animateFloatAsState(
                    targetValue = if (isContentLoaded) 1f else 0.9f,
                    animationSpec = tween(durationMillis = 600, delayMillis = 300)
                ).value),
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
                        .padding(24.dp)
                        .fillMaxWidth()
                ) {
                    Text(
                        "Achievements",
                        style = MaterialTheme.typography.headlineSmall.copy(
                            color = Color.White,
                            fontWeight = FontWeight.Bold
                        ),
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    achievements.forEachIndexed { index, achievement ->
                        AchievementItem(
                            achievement = achievement,
                            isContentLoaded = isContentLoaded,
                            delay = 300 + index * 100
                        )
                        if (index < achievements.size - 1) {
                            Spacer(modifier = Modifier.height(12.dp))
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun AchievementItem(achievement: Achievement, isContentLoaded: Boolean, delay: Int = 0) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .alpha(animateFloatAsState(
                targetValue = if (isContentLoaded) 1f else 0f,
                animationSpec = tween(durationMillis = 400, delayMillis = delay)
            ).value)
            .offset(x = animateDpAsState(
                targetValue = if (isContentLoaded) 0.dp else 20.dp,
                animationSpec = tween(durationMillis = 400, delayMillis = delay)
            ).value),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.Default.Star,
            contentDescription = "Achievement",
            tint = if (achievement.unlocked) Color(0xFFFFD700) else Color(0xFF666666),
            modifier = Modifier.size(28.dp)
        )

        Spacer(modifier = Modifier.size(16.dp))

        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = achievement.title,
                style = MaterialTheme.typography.bodyLarge.copy(
                    color = if (achievement.unlocked) Color.White else Color(0xFFAAAAAA),
                    fontWeight = FontWeight.Medium
                )
            )
            Text(
                text = achievement.description,
                style = MaterialTheme.typography.bodySmall.copy(
                    color = if (achievement.unlocked) Color(0xFFD4AF37) else Color(0xFF888888)
                )
            )
            if (achievement.target > 1) {
                Text(
                    text = "${achievement.progress}/${achievement.target}",
                    style = MaterialTheme.typography.bodySmall.copy(
                        color = Color(0xFFFFD700)
                    )
                )
            }
        }
    }
}

// Helper extension for alpha animation
//@Composable
//private fun Modifier.alpha(alpha: Float): Modifier = this.then(
//    graphicsLayer(alpha = alpha)
//)