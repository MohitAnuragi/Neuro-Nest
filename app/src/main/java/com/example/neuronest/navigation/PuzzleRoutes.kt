package com.example.neuronest.navigation

import android.R.attr.level
import com.example.neuronest.backgroundMusic.BackgroundMusicPlayer
import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.neuronest.Sequence.SequenceGeneratorScreen
import com.example.neuronest.WordScramble.WordScrambleScreen
import com.example.neuronest.kakuro.KakuroScreen
import com.example.neuronest.auth.ProfileSetupScreen
import com.example.neuronest.auth.SplashScreen
import com.example.neuronest.logic.LogicRiddlesScreen
import com.example.neuronest.profile.AchievementsScreen
import com.example.neuronest.profile.ProfileScreen
import com.example.neuronest.profile.ProfileViewModel
import com.example.neuronest.puzzlelevels.LevelGridScreen
import com.example.neuronest.sudoku.SudokuPuzzleScreen
import com.example.neuronest.R
import com.example.neuronest.connection.ConnectionPuzzleScreen

@Composable
fun PuzzleNavigation() {
    val navController = rememberNavController()
    var isMusicPlaying by remember { mutableStateOf(true) }
    val profileViewModel: ProfileViewModel = hiltViewModel()
    val needsSetup by profileViewModel.needsProfileSetup.collectAsState()

    // Track if profile check is complete
    var profileCheckComplete by remember { mutableStateOf(false) }

    // Wait a moment for profile check to complete
    LaunchedEffect(Unit) {
        kotlinx.coroutines.delay(500) // Give time for DataStore to load
        profileCheckComplete = true
    }

    BackgroundMusicPlayer(
        audioResId = R.raw.neuroback,
        isMusicPlaying = isMusicPlaying
    )

    NavHost(
        navController = navController,
        startDestination = PuzzleRoutes.splash.route
    ) {
        composable(PuzzleRoutes.splash.route) {
            SplashScreen {
                // Only navigate after profile check is complete
                if (profileCheckComplete) {
                    if (needsSetup) {
                        navController.navigate(PuzzleRoutes.ProfileSetup.route) {
                            popUpTo(PuzzleRoutes.splash.route) { inclusive = true }
                        }
                    } else {
                        navController.navigate(PuzzleRoutes.Selection.route) {
                            popUpTo(PuzzleRoutes.splash.route) { inclusive = true }
                        }
                    }
                }
            }
        }

        composable(PuzzleRoutes.Selection.route) {
            PuzzleSelectionScreen(
                navController = navController,
                isMusicPlaying = isMusicPlaying,
                onToggleMusic = { isPlaying -> isMusicPlaying = isPlaying }
            )
        }

        composable(
            "${PuzzleRoutes.LevelGrid.route}/{puzzleType}",
            arguments = listOf(navArgument("puzzleType") { type = NavType.StringType })
        ) { backStackEntry ->
            val puzzleType = backStackEntry.arguments?.getString("puzzleType") ?: ""
            LevelGridScreen(
                puzzleType = puzzleType,
                onLevelSelected = { level ->
                    when (puzzleType) {
                        "WordScramble" -> navController.navigate("${PuzzleRoutes.WordScramble.route}/$level")
                        "Kakuro" -> navController.navigate("${PuzzleRoutes.Kakuro.route}/$level")
                        "SequenceGenerator" -> navController.navigate("${PuzzleRoutes.SequenceGenerator.route}/$level")
                        "FutoshikiPuzzle" -> navController.navigate("${PuzzleRoutes.Futoshiki.route}/$level")
                        "SudokuPuzzle" -> navController.navigate("${PuzzleRoutes.Sudoku.route}/$level")
                        "LogicPuzzles" -> navController.navigate("${PuzzleRoutes.Logic.route}/$level")
                        "Connections" -> navController.navigate("${PuzzleRoutes.Connection.route}/$level")
                        else -> navController.popBackStack()
                    }
                },
                onBack = { navController.popBackStack() }
            )
        }

        composable(
            "${PuzzleRoutes.WordScramble.route}/{level}",
            arguments = listOf(navArgument("level") { type = NavType.IntType })
        ) { backStackEntry ->
            val level = backStackEntry.arguments?.getInt("level") ?: 1
            val puzzleType = "WordScramble"

            WordScrambleScreen(
                onBack = { navController.popBackStack() },
                level = level,
                onNextLevel = { nextLevel ->
                    navController.navigate("${PuzzleRoutes.WordScramble.route}/$nextLevel") {
                        popUpTo("${PuzzleRoutes.WordScramble.route}/$level") { inclusive = true }
                    }
                },
                onReplay = {
                    navController.navigate("${PuzzleRoutes.WordScramble.route}/$level") {
                        popUpTo("${PuzzleRoutes.WordScramble.route}/$level") { inclusive = true }
                    }
                },
                onGoToGrid = {
                    navController.navigate("${PuzzleRoutes.LevelGrid.route}/$puzzleType") {
                        popUpTo("${PuzzleRoutes.WordScramble.route}/$level") { inclusive = true }
                    }
                }
            )
        }

        composable(
            "${PuzzleRoutes.Kakuro.route}/{level}",
            arguments = listOf(navArgument("level") { type = NavType.IntType })
        ) { backStackEntry ->
            val level = backStackEntry.arguments?.getInt("level") ?: 1
            val puzzleType = "Kakuro"

            KakuroScreen(
                onBack = { navController.popBackStack() },
                level = level,
                onNextLevel = { nextLevel ->
                    navController.navigate("${PuzzleRoutes.Kakuro.route}/$nextLevel") {
                        popUpTo("${PuzzleRoutes.Kakuro.route}/$level") { inclusive = true }
                    }
                },
                onReplay = {
                    navController.navigate("${PuzzleRoutes.Kakuro.route}/$level") {
                        popUpTo("${PuzzleRoutes.Kakuro.route}/$level") { inclusive = true }
                    }
                },
                onGoToGrid = {
                    navController.navigate("${PuzzleRoutes.LevelGrid.route}/$puzzleType") {
                        popUpTo("${PuzzleRoutes.Kakuro.route}/$level") { inclusive = true }
                    }
                }
            )
        }

        composable(
            "${PuzzleRoutes.SequenceGenerator.route}/{level}",
            arguments = listOf(navArgument("level") { type = NavType.IntType })
        ) { backStackEntry ->
            val level = backStackEntry.arguments?.getInt("level") ?: 1
            val puzzleType = "SequenceGenerator"

            SequenceGeneratorScreen(
                onBack = { navController.popBackStack() },
                level = level,
                onNextLevel = { nextLevel ->
                    navController.navigate("${PuzzleRoutes.SequenceGenerator.route}/$nextLevel") {
                        popUpTo("${PuzzleRoutes.SequenceGenerator.route}/$level") {
                            inclusive = true
                        }
                    }
                },
                onReplay = {
                    navController.navigate("${PuzzleRoutes.SequenceGenerator.route}/$level") {
                        popUpTo("${PuzzleRoutes.SequenceGenerator.route}/$level") {
                            inclusive = true
                        }
                    }
                },
                onGoToGrid = {
                    navController.navigate("${PuzzleRoutes.LevelGrid.route}/$puzzleType") {
                        popUpTo("${PuzzleRoutes.SequenceGenerator.route}/$level") {
                            inclusive = true
                        }
                    }
                }
            )
        }


        composable(
            "${PuzzleRoutes.Sudoku.route}/{level}",
            arguments = listOf(navArgument("level") { type = NavType.IntType })
        ) { backStackEntry ->
            val level = backStackEntry.arguments?.getInt("level") ?: 1
            val puzzleType = "SudokuPuzzle"

            SudokuPuzzleScreen(
                onBack = { navController.popBackStack() },
                level = level,
                onNextLevel = { nextLevel ->
                    navController.navigate("${PuzzleRoutes.Sudoku.route}/$nextLevel") {
                        popUpTo("${PuzzleRoutes.Sudoku.route}/$level") { inclusive = true }
                    }
                },
                onReplay = {
                    navController.navigate("${PuzzleRoutes.Sudoku.route}/$level") {
                        popUpTo("${PuzzleRoutes.Sudoku.route}/$level") { inclusive = true }
                    }
                },
                onGoToGrid = {
                    navController.navigate("${PuzzleRoutes.LevelGrid.route}/$puzzleType") {
                        popUpTo("${PuzzleRoutes.Sudoku.route}/$level") { inclusive = true }
                    }
                }
            )
        }


        composable(
            "${PuzzleRoutes.Logic.route}/{level}",
            arguments = listOf(navArgument("level") { type = NavType.IntType })
        ) { backStackEntry ->
            val level = backStackEntry.arguments?.getInt("level") ?: 1
            val puzzleType = "LogicPuzzles"

            LogicRiddlesScreen(
                onBack = { navController.popBackStack() },
                level = level,
                onNextLevel = { nextLevel ->
                    navController.navigate("${PuzzleRoutes.Logic.route}/$nextLevel") {
                        popUpTo("${PuzzleRoutes.Logic.route}/$level") { inclusive = true }
                    }
                },
                onReplay = {
                    navController.navigate("${PuzzleRoutes.Logic.route}/$level") {
                        popUpTo("${PuzzleRoutes.Logic.route}/$level") { inclusive = true }
                    }
                },
                onGoToGrid = {
                    navController.navigate("${PuzzleRoutes.LevelGrid.route}/$puzzleType") {
                        popUpTo("${PuzzleRoutes.Logic.route}/$level") { inclusive = true }
                    }
                }
            )
        }

        composable(PuzzleRoutes.Profile.route) {
            ProfileScreen(
                onSignOut = {
                    profileViewModel.resetProfile()
                    navController.navigate(PuzzleRoutes.splash.route) {
                        popUpTo(PuzzleRoutes.splash.route) { inclusive = true }
                    }
                }
            )
        }

        composable(PuzzleRoutes.Achievements.route) {
            AchievementsScreen(
                onBack = { navController.popBackStack() }
            )
        }

        composable("${PuzzleRoutes.Connection.route}/{level}",
            arguments = listOf(navArgument("level") { type = NavType.IntType })
        ) { backStackEntry ->
            val level = backStackEntry.arguments?.getInt("level") ?: 1
            val puzzleType = "Connections"

            ConnectionPuzzleScreen(
                onBack = { navController.popBackStack() },
                level = level,
                onNextLevel = { nextLevel ->
                    navController.navigate("${PuzzleRoutes.Connection.route}/$nextLevel") {
                        popUpTo("${PuzzleRoutes.Connection.route}/$level") { inclusive = true }
                    }
                },
                onReplay = {
                    navController.navigate("${PuzzleRoutes.Connection.route}/$level") {
                        popUpTo("${PuzzleRoutes.Connection.route}/$level") { inclusive = true }
                    }
                },
                onGoToGrid = {
                    navController.navigate("${PuzzleRoutes.LevelGrid.route}/$puzzleType") {
                        popUpTo("${PuzzleRoutes.Connection.route}/$level") { inclusive = true }
                    }
                }
            )
        }

        composable(PuzzleRoutes.ProfileSetup.route) {
            ProfileSetupScreen(
                onProfileSetupComplete = {
                    navController.navigate(PuzzleRoutes.Selection.route) {
                        popUpTo(PuzzleRoutes.ProfileSetup.route) { inclusive = true }
                    }
                }
            )
        }
    }
}

sealed class PuzzleRoutes(val route: String) {
    object Selection : PuzzleRoutes("puzzle_selection")
    object LevelGrid : PuzzleRoutes("level_grid")
    object WordScramble : PuzzleRoutes("word_scramble")
    object Kakuro : PuzzleRoutes("kakuro")
    object Connection : PuzzleRoutes("connection")
    object Futoshiki : PuzzleRoutes("futoshiki")
    object SequenceGenerator : PuzzleRoutes("sequence_generator")
    object Sudoku : PuzzleRoutes("sudoku")
    object Logic : PuzzleRoutes("logic")
    object Profile : PuzzleRoutes("profile")
    object Achievements : PuzzleRoutes("achievements")
    object splash : PuzzleRoutes("splash")
    object ProfileSetup : PuzzleRoutes("profile_setup")

}

data class PuzzleItem(
    val title: String,
    val route: PuzzleRoutes,
    @DrawableRes val iconRes: Int,
    val puzzleType: String
)