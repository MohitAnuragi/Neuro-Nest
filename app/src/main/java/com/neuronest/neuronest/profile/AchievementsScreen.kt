package com.neuronest.neuronest.profile

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.neuronest.neuronest.achievements.AchievementEntity
import kotlinx.coroutines.delay
import com.neuronest.neuronest.R



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AchievementsScreen(
    onBack: () -> Unit = {},
    viewModel: AchievementsViewModel = hiltViewModel()
) {
    val achievements by viewModel.achievements.collectAsState()
    val unlockedCount by viewModel.unlockedCount.collectAsState()
    val totalCount by viewModel.totalCount.collectAsState()

    var isContentLoaded by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        viewModel.loadAchievements()
        delay(300)
        isContentLoaded = true
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "Achievements",
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                },
                navigationIcon = {
                    IconButton(onClick = {
                        viewModel.soundManager.playSound(com.neuronest.neuronest.sound.SoundType.BUTTON_CLICK)
                        onBack()
                    }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back",
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
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                AchievementsSummary(
                    unlockedCount = unlockedCount,
                    totalCount = totalCount,
                    isContentLoaded = isContentLoaded
                )

                Spacer(modifier = Modifier.height(24.dp))

                AchievementsSection(
                    achievements = achievements,
                    isContentLoaded = isContentLoaded
                )

                Spacer(modifier = Modifier.height(24.dp))
            }
        }
    }
}

@Composable
fun AchievementsSummary(
    unlockedCount: Int,
    totalCount: Int,
    isContentLoaded: Boolean
) {
    val progress = if (totalCount > 0) (unlockedCount.toFloat() / totalCount) else 0f

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
                    animationSpec = tween(durationMillis = 600),
                    label = "summaryScale"
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
                    .padding(24.dp)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    imageVector = Icons.Default.Star,
                    contentDescription = "Achievements",
                    tint = Color(0xFFFFD700),
                    modifier = Modifier.size(48.dp)
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "$unlockedCount / $totalCount",
                    style = MaterialTheme.typography.headlineMedium.copy(
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                )

                Text(
                    text = "Achievements Unlocked",
                    style = MaterialTheme.typography.bodyMedium.copy(
                        color = Color(0xFFD4AF37)
                    )
                )

                Spacer(modifier = Modifier.height(16.dp))

                LinearProgressIndicator(
                    progress = { progress },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(8.dp),
                    color = Color(0xFFFFD700),
                    trackColor = Color(0xFF4A2C1D),
                )
            }
        }
    }
}

@Composable
fun AchievementsSection(
    achievements: List<AchievementEntity>,
    isContentLoaded: Boolean
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        achievements.forEachIndexed { index, achievement ->
            AchievementItem(
                achievement = achievement,
                isContentLoaded = isContentLoaded,
                delay = index * 50
            )
        }
    }
}

@Composable
fun AchievementItem(
    achievement: AchievementEntity,
    isContentLoaded: Boolean,
    delay: Int = 0
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .scale(
                animateFloatAsState(
                    targetValue = if (isContentLoaded) 1f else 0.96f,
                    animationSpec = tween(durationMillis = 400, delayMillis = delay),
                    label = "achievementScale_${achievement.achievementId}"
                ).value
            ),
        colors = CardDefaults.cardColors(
            containerColor = if (achievement.isUnlocked) Color(0xFF2D5016) else Color(0xFF2C1810)
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = achievement.title,
                    style = MaterialTheme.typography.titleMedium.copy(
                        color = if (achievement.isUnlocked) Color(0xFFB8E994) else Color.White,
                        fontWeight = FontWeight.Bold
                    )
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = achievement.description,
                    style = MaterialTheme.typography.bodySmall.copy(
                        color = if (achievement.isUnlocked) Color(0xFF88CC66) else Color(0xFFD4AF37)
                    )
                )

                // Show progress if not unlocked
                if (!achievement.isUnlocked && achievement.progress > 0) {
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Progress: ${achievement.progress} / ${achievement.target}",
                        style = MaterialTheme.typography.bodySmall.copy(
                            color = Color(0xFFD4AF37)
                        )
                    )
                }
            }

            if (achievement.isUnlocked) {
                Icon(
                    imageVector = Icons.Default.CheckCircle,
                    contentDescription = "Unlocked",
                    tint = Color(0xFFB8E994),
                    modifier = Modifier.size(28.dp)
                )
            } else {
                Icon(
                    imageVector = Icons.Default.Lock,
                    contentDescription = "Locked",
                    tint = Color(0xFF666666),
                    modifier = Modifier.size(28.dp)
                )
            }
        }
    }
}
