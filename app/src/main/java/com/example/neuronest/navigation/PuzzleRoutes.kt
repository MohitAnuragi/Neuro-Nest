package com.example.neuronest.navigation

import BackgroundMusicPlayer
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
import com.example.neuronest.Arithematic.ArithmeticPuzzleScreen
import com.example.neuronest.Sequence.SequenceGeneratorScreen
import com.example.neuronest.WordScramble.WordScrambleScreen
import com.example.neuronest.kakuro.KakuroScreen
import com.example.neuronest.auth.ProfileSetupScreen
import com.example.neuronest.auth.SplashScreen
import com.example.neuronest.cryptic.CrypticPuzzleScreen
import com.example.neuronest.futoshiki.FutoshikiPuzzleScreen
import com.example.neuronest.logic.LogicRiddlesScreen
import com.example.neuronest.profile.ProfileScreen
import com.example.neuronest.profile.ProfileViewModel
import com.example.neuronest.puzzlelevels.LevelGridScreen
import com.example.neuronest.sudoku.SudokuPuzzleScreen
import com.example.neuronest.R

@Composable
fun PuzzleNavigation() {
    val navController = rememberNavController()
    var isMusicPlaying by remember { mutableStateOf(true) }
    val profileViewModel: ProfileViewModel = hiltViewModel()
    val needsSetup by profileViewModel.needsProfileSetup.collectAsState()

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

        composable(PuzzleRoutes.Selection.route) {
            PuzzleSelectionScreen(
                navController = navController,
                isMusicPlaying = isMusicPlaying,
                onToggleMusic = { isPlaying -> isMusicPlaying = isPlaying }
            )
        }

        composable("${PuzzleRoutes.LevelGrid.route}/{puzzleType}",
            arguments = listOf(navArgument("puzzleType") { type = NavType.StringType })
        ) { backStackEntry ->
            val puzzleType = backStackEntry.arguments?.getString("puzzleType") ?: ""
            LevelGridScreen(
                puzzleType = puzzleType,
                onLevelSelected = { level ->
                    when (puzzleType) {
                        "Arithmetic" -> navController.navigate("${PuzzleRoutes.Arithmetic.route}/$level")
                        "WordScramble" -> navController.navigate("${PuzzleRoutes.WordScramble.route}/$level")
                        "Kakuro" -> navController.navigate("${PuzzleRoutes.Kakuro.route}/$level")
                        "SequenceGenerator" -> navController.navigate("${PuzzleRoutes.SequenceGenerator.route}/$level")
                        "FutoshikiPuzzle" -> navController.navigate("${PuzzleRoutes.Futoshiki.route}/$level")
                        "SudokuPuzzle" -> navController.navigate("${PuzzleRoutes.Sudoku.route}/$level")
                        "CrypticPuzzle" -> navController.navigate("${PuzzleRoutes.Cryptic.route}/$level")
                        "LogicPuzzles" -> navController.navigate("${PuzzleRoutes.Logic.route}/$level")
                        else -> navController.popBackStack()
                    }
                },
                onBack = { navController.popBackStack() }
            )
        }

        composable("${PuzzleRoutes.Arithmetic.route}/{level}",
            arguments = listOf(navArgument("level") { type = NavType.IntType })
        ) { backStackEntry ->
            val level = backStackEntry.arguments?.getInt("level") ?: 1
            val puzzleType = "Arithmetic"

            ArithmeticPuzzleScreen(
                onBack = { navController.popBackStack() },
                level = level,
                onNextLevel = { nextLevel ->
                    navController.navigate("${PuzzleRoutes.Arithmetic.route}/$nextLevel") {
                        popUpTo("${PuzzleRoutes.Arithmetic.route}/$level") { inclusive = true }
                    }
                },
                onReplay = {
                    navController.navigate("${PuzzleRoutes.Arithmetic.route}/$level") {
                        popUpTo("${PuzzleRoutes.Arithmetic.route}/$level") { inclusive = true }
                    }
                },
                onGoToGrid = {
                    navController.navigate("${PuzzleRoutes.LevelGrid.route}/$puzzleType") {
                        popUpTo("${PuzzleRoutes.Arithmetic.route}/$level") { inclusive = true }
                    }
                }
            )
        }

        composable("${PuzzleRoutes.WordScramble.route}/{level}",
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

        composable("${PuzzleRoutes.Kakuro.route}/{level}",
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

        composable("${PuzzleRoutes.SequenceGenerator.route}/{level}",
            arguments = listOf(navArgument("level") { type = NavType.IntType })
        ) { backStackEntry ->
            val level = backStackEntry.arguments?.getInt("level") ?: 1
            val puzzleType = "SequenceGenerator"

            SequenceGeneratorScreen(
                onBack = { navController.popBackStack() },
                level = level,
                onNextLevel = { nextLevel ->
                    navController.navigate("${PuzzleRoutes.SequenceGenerator.route}/$nextLevel") {
                        popUpTo("${PuzzleRoutes.SequenceGenerator.route}/$level") { inclusive = true }
                    }
                },
                onReplay = {
                    navController.navigate("${PuzzleRoutes.SequenceGenerator.route}/$level") {
                        popUpTo("${PuzzleRoutes.SequenceGenerator.route}/$level") { inclusive = true }
                    }
                },
                onGoToGrid = {
                    navController.navigate("${PuzzleRoutes.LevelGrid.route}/$puzzleType") {
                        popUpTo("${PuzzleRoutes.SequenceGenerator.route}/$level") { inclusive = true }
                    }
                }
            )
        }

        composable("${PuzzleRoutes.Futoshiki.route}/{level}",
            arguments = listOf(navArgument("level") { type = NavType.IntType })
        ) { backStackEntry ->
            val level = backStackEntry.arguments?.getInt("level") ?: 1
            val puzzleType = "FutoshikiPuzzle"

            FutoshikiPuzzleScreen(
                onBack = { navController.popBackStack() },
                level = level,
                onNextLevel = { nextLevel ->
                    navController.navigate("${PuzzleRoutes.Futoshiki.route}/$nextLevel") {
                        popUpTo("${PuzzleRoutes.Futoshiki.route}/$level") { inclusive = true }
                    }
                },
                onReplay = {
                    navController.navigate("${PuzzleRoutes.Futoshiki.route}/$level") {
                        popUpTo("${PuzzleRoutes.Futoshiki.route}/$level") { inclusive = true }
                    }
                },
                onGoToGrid = {
                    navController.navigate("${PuzzleRoutes.LevelGrid.route}/$puzzleType") {
                        popUpTo("${PuzzleRoutes.Futoshiki.route}/$level") { inclusive = true }
                    }
                }
            )
        }

        composable("${PuzzleRoutes.Sudoku.route}/{level}",
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

        composable("${PuzzleRoutes.Cryptic.route}/{level}",
            arguments = listOf(navArgument("level") { type = NavType.IntType })
        ) { backStackEntry ->
            val level = backStackEntry.arguments?.getInt("level") ?: 1
            val puzzleType = "CrypticPuzzle"

            CrypticPuzzleScreen(
                onBack = { navController.popBackStack() },
                level = level,
                onNextLevel = { nextLevel ->
                    navController.navigate("${PuzzleRoutes.Cryptic.route}/$nextLevel") {
                        popUpTo("${PuzzleRoutes.Cryptic.route}/$level") { inclusive = true }
                    }
                },
                onReplay = {
                    navController.navigate("${PuzzleRoutes.Cryptic.route}/$level") {
                        popUpTo("${PuzzleRoutes.Cryptic.route}/$level") { inclusive = true }
                    }
                },
                onGoToGrid = {
                    navController.navigate("${PuzzleRoutes.LevelGrid.route}/$puzzleType") {
                        popUpTo("${PuzzleRoutes.Cryptic.route}/$level") { inclusive = true }
                    }
                }
            )
        }

        composable("${PuzzleRoutes.Logic.route}/{level}",
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
    object Arithmetic : PuzzleRoutes("arithmetic")
    object WordScramble : PuzzleRoutes("word_scramble")
    object Kakuro : PuzzleRoutes("kakuro")
    object SequenceGenerator : PuzzleRoutes("sequence_generator")
    object Futoshiki : PuzzleRoutes("futoshiki")
    object Sudoku : PuzzleRoutes("sudoku")
    object Cryptic : PuzzleRoutes("cryptic")
    object Logic : PuzzleRoutes("logic")
    object Profile : PuzzleRoutes("profile")
    object splash : PuzzleRoutes("splash")
    object ProfileSetup : PuzzleRoutes("profile_setup")
    object ColorMatching : PuzzleRoutes("color_matching")
    object BulbSwitch : PuzzleRoutes("bulb_switch")
}

data class PuzzleItem(
    val title: String,
    val route: PuzzleRoutes,
    @DrawableRes val iconRes: Int,
    val puzzleType: String
)