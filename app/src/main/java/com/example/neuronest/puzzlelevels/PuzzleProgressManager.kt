package com.example.neuronest.puzzlelevels




// LevelManager.kt
object LevelManager {
    private const val PREFS_NAME = "puzzle_levels"
    private const val KEY_SUDOKU_LEVEL = "sudoku_level"
    private const val KEY_FUTOSHIKI_LEVEL = "futoshiki_level"
    private const val KEY_TOWER_LEVEL = "tower_level"
    private const val KEY_RIDDLE_LEVEL = "riddle_level"
    private const val KEY_BULB_LEVEL = "bulb_level"
    private const val KEY_ARITHMETIC_LEVEL = "arithmetic_level"
    private const val KEY_COLOR_LEVEL = "color_level"
    private const val KEY_WORD_LEVEL = "word_level"
    private const val KEY_MISSING_LEVEL = "missing_level"
    private const val KEY_SEQUENCE_LEVEL = "sequence_level"
    private const val KEY_LOGIC_LEVEL = "logic_level"

    // Store application context
    private var context: android.content.Context? = null

    fun initialize(context: android.content.Context) {
        this.context = context.applicationContext
    }

    private fun getSharedPreferences(): android.content.SharedPreferences {
        return context?.getSharedPreferences(PREFS_NAME, android.content.Context.MODE_PRIVATE)
            ?: throw IllegalStateException("LevelManager not initialized. Call initialize() first.")
    }

    fun getCurrentLevel(puzzleType: String): Int {
        val prefs = getSharedPreferences()
        return when (puzzleType) {
            "Sudoku" -> prefs.getInt(KEY_SUDOKU_LEVEL, 1)
            "Futoshiki" -> prefs.getInt(KEY_FUTOSHIKI_LEVEL, 1)
            "Tower of Hanoi" -> prefs.getInt(KEY_TOWER_LEVEL, 1)
            "Hard Riddles" -> prefs.getInt(KEY_RIDDLE_LEVEL, 1)
            "3 Bulbs Puzzle" -> prefs.getInt(KEY_BULB_LEVEL, 1)
            "Arithmetic" -> prefs.getInt(KEY_ARITHMETIC_LEVEL, 1)
            "ColorMatching" -> prefs.getInt(KEY_COLOR_LEVEL, 1)
            "WordScramble" -> prefs.getInt(KEY_WORD_LEVEL, 1)
            "MissingNumber" -> prefs.getInt(KEY_MISSING_LEVEL, 1)
            "Sequence" -> prefs.getInt(KEY_SEQUENCE_LEVEL, 1)
            "Logic" -> prefs.getInt(KEY_LOGIC_LEVEL, 1)
            else -> 1
        }
    }

    fun completeLevel(puzzleType: String, level: Int, stars: Int = 1) {
        val prefs = getSharedPreferences()
        val editor = prefs.edit()

        when (puzzleType) {
            "Sudoku" -> updateLevel(editor, KEY_SUDOKU_LEVEL, level)
            "Futoshiki" -> updateLevel(editor, KEY_FUTOSHIKI_LEVEL, level)
            "Tower of Hanoi" -> updateLevel(editor, KEY_TOWER_LEVEL, level)
            "Hard Riddles" -> updateLevel(editor, KEY_RIDDLE_LEVEL, level)
            "3 Bulbs Puzzle" -> updateLevel(editor, KEY_BULB_LEVEL, level)
            "Arithmetic" -> updateLevel(editor, KEY_ARITHMETIC_LEVEL, level)
            "ColorMatching" -> updateLevel(editor, KEY_COLOR_LEVEL, level)
            "WordScramble" -> updateLevel(editor, KEY_WORD_LEVEL, level)
            "MissingNumber" -> updateLevel(editor, KEY_MISSING_LEVEL, level)
            "Sequence" -> updateLevel(editor, KEY_SEQUENCE_LEVEL, level)
            "Logic" -> updateLevel(editor, KEY_LOGIC_LEVEL, level)
        }
        editor.apply()
    }

    private fun updateLevel(editor: android.content.SharedPreferences.Editor, key: String, level: Int) {
        val currentMax = getSharedPreferences().getInt(key, 1)
        if (level >= currentMax) {
            editor.putInt(key, level + 1)
        }
    }

    fun resetAllProgress() {
        val editor = getSharedPreferences().edit()
        editor.clear()
        editor.apply()
    }

    fun getLevelProgress(puzzleType: String): Pair<Int, Int> {
        val currentLevel = getCurrentLevel(puzzleType)
        return Pair(currentLevel, 50) // 50 levels total
    }
}
