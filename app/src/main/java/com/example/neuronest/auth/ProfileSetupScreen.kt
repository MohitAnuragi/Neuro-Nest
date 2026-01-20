package com.example.neuronest.auth

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.example.neuronest.R
import com.example.neuronest.profile.ProfileViewModel
import com.example.neuronest.profile.UserProfile
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileSetupScreen(
    onBack: () -> Unit = {},
    viewModel: ProfileViewModel = hiltViewModel(),
    onProfileSetupComplete: () -> Unit
) {
    val coroutineScope = rememberCoroutineScope()

    val profile by viewModel.profile.collectAsState()
    var displayName by remember { mutableStateOf(profile?.displayName ?: "") }
    var selectedImageUri by remember { mutableStateOf<Uri?>(null) }
    var showImagePicker by remember { mutableStateOf(false) }

    var isContentLoaded by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        delay(300)
        isContentLoaded = true
    }

    LaunchedEffect(profile) {
        if (profile?.profileImageUri?.isNotEmpty() == true) {
            try {
                selectedImageUri = Uri.parse(profile?.profileImageUri)
            } catch (_: Exception) {
                // Handle error
            }
        }
        // Pre-fill display name if it exists
        profile?.displayName?.let {
            if (it.isNotBlank() && it != "Guest User") {
                displayName = it
            }
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = if (profile?.isProfileSetup == true) "Edit Profile" else "Setup Profile",
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

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(24.dp)
            ) {
                // Profile Image Picker
                ProfileImageSection(
                    selectedImageUri = selectedImageUri,
                    isContentLoaded = isContentLoaded,
                    onImageClick = { showImagePicker = true }
                )

                // Name Input
                NameInputSection(
                    displayName = displayName,
                    isContentLoaded = isContentLoaded,
                    onNameChange = { displayName = it }
                )

                // Action Buttons
                ActionButtonsSection(
                    profile = profile,
                    displayName = displayName,
                    isContentLoaded = isContentLoaded,
                    onSave = {
                        // Save to Room database via ViewModel
                        viewModel.updateProfileDetails(
                            displayName,
                            selectedImageUri?.toString() ?: ""
                        )
                        onProfileSetupComplete()
                    },
                    onSkip = {
                        // Mark as setup complete even when skipping
                        viewModel.updateProfileDetails("Guest User", "")
                        onProfileSetupComplete()
                    }
                )
            }
        }

        // Image Picker Dialog
        if (showImagePicker) {
            val imagePickerLauncher = rememberLauncherForActivityResult(
                contract = ActivityResultContracts.GetContent()
            ) { uri: Uri? ->
                selectedImageUri = uri
                showImagePicker = false
            }

            LaunchedEffect(showImagePicker) {
                imagePickerLauncher.launch("image/*")
                showImagePicker = false
            }
        }
    }
}

@Composable
fun ProfileImageSection(
    selectedImageUri: Uri?,
    isContentLoaded: Boolean,
    onImageClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .scale(
                animateFloatAsState(
                    targetValue = if (isContentLoaded) 1f else 0.9f,
                    animationSpec = androidx.compose.animation.core.tween(durationMillis = 600)
                ).value
            )
            .shadow(
                elevation = 16.dp,
                shape = RoundedCornerShape(24.dp),
                spotColor = Color(0xFFFFD700)
            ),
        shape = RoundedCornerShape(24.dp)
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
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Text(
                    text = "Profile Picture",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )

                Box(
                    modifier = Modifier
                        .size(140.dp)
                        .clip(CircleShape)
                        .clickable(onClick = onImageClick)
                        .shadow(
                            elevation = 12.dp,
                            shape = CircleShape,
                            spotColor = Color(0xFFFFD700)
                        )
                        .background(
                            brush = Brush.radialGradient(
                                colors = listOf(Color(0xFF2C1810), Color(0xFF4A2C1D)),
                                center = androidx.compose.ui.geometry.Offset(0.3f, 0.3f),
                                radius = 200f
                            )
                        )
                        .border(
                            width = 3.dp,
                            brush = Brush.linearGradient(
                                colors = listOf(Color(0xFFFFD700), Color(0xFFD4AF37)),
                                tileMode = TileMode.Repeated
                            ),
                            shape = CircleShape
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    if (selectedImageUri != null) {
                        Image(
                            painter = rememberAsyncImagePainter(selectedImageUri),
                            contentDescription = "Profile Image",
                            modifier = Modifier
                                .fillMaxSize()
                                .clip(CircleShape),
                            contentScale = ContentScale.Crop
                        )
                    } else {
                        Icon(
                            imageVector = Icons.Default.Person,
                            contentDescription = "Add Profile Image",
                            modifier = Modifier.size(60.dp),
                            tint = Color(0xFFD4AF37)
                        )
                    }
                }

                Text(
                    modifier = Modifier.clickable(onClick = onImageClick),
                    text = "Tap to change photo",
                    fontSize = 14.sp,
                    color = Color(0xFFD4AF37),
                    fontWeight = FontWeight.Medium
                )
            }
        }
    }
}

@Composable
fun NameInputSection(
    displayName: String,
    isContentLoaded: Boolean,
    onNameChange: (String) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .scale(
                animateFloatAsState(
                    targetValue = if (isContentLoaded) 1f else 0.9f,
                    animationSpec = androidx.compose.animation.core.tween(durationMillis = 600, delayMillis = 100)
                ).value
            )
            .shadow(
                elevation = 16.dp,
                shape = RoundedCornerShape(24.dp),
                spotColor = Color(0xFFFFD700)
            ),
        shape = RoundedCornerShape(24.dp)
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
            Column(
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text(
                    text = "Your Name",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp)
                        .background(
                            color = Color(0xFF1A0F0A),
                            shape = RoundedCornerShape(12.dp)
                        )
                        .border(
                            width = 2.dp,
                            color = Color(0xFFD4AF37),
                            shape = RoundedCornerShape(12.dp)
                        )
                        .padding(horizontal = 16.dp),
                    contentAlignment = Alignment.CenterStart
                ) {
                    BasicTextField(
                        value = displayName,
                        onValueChange = onNameChange,
                        textStyle = TextStyle(
                            color = Color.White,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Medium
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp),
                        singleLine = true,
                        decorationBox = { innerTextField ->
                            Box(
                                contentAlignment = Alignment.CenterStart,
                                modifier = Modifier.fillMaxSize()
                            ) {
                                if (displayName.isEmpty()) {
                                    Text(
                                        text = "Enter your name",
                                        color = Color(0xFFD4AF37).copy(alpha = 0.7f),
                                        fontSize = 16.sp
                                    )
                                }
                                innerTextField()
                            }
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun ActionButtonsSection(
    profile: UserProfile?,
    displayName: String,
    isContentLoaded: Boolean,
    onSave: () -> Unit,
    onSkip: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .scale(animateFloatAsState(
                targetValue = if (isContentLoaded) 1f else 0.9f,
                animationSpec = androidx.compose.animation.core.tween(durationMillis = 600, delayMillis = 200)
            ).value),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Save Button
        Button(
            onClick = onSave,
            enabled = displayName.isNotBlank(),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFD4AF37),
                contentColor = Color.White
            ),
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp),
            elevation = ButtonDefaults.buttonElevation(
                defaultElevation = 8.dp,
                pressedElevation = 4.dp
            )
        ) {
            Text(
                text = if (profile?.isProfileSetup == true) "UPDATE PROFILE" else "SAVE PROFILE",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        }

        // Skip button for first-time setup
        if (profile?.isProfileSetup != true) {
            Text(
                text = "Skip for now",
                modifier = Modifier
                    .clickable(onClick = onSkip)
                    .padding(8.dp),
                color = Color(0xFFD4AF37),
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium
            )
        }
    }
}

