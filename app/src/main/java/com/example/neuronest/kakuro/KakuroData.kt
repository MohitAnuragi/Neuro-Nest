package com.example.neuronest.kakuro

/**
 * Represents a cell in the Kakuro grid
 */
sealed class KakuroCell {
    // Black cell containing clues
    data class ClueCell(
        val downSum: Int = 0,  // Sum for vertical run (0 means no clue)
        val acrossSum: Int = 0  // Sum for horizontal run (0 means no clue)
    ) : KakuroCell()

    // White cell where player enters numbers
    data class PlayCell(
        val value: Int = 0,  // Current value (0 = empty)
        val isError: Boolean = false,  // Visual error state
        val isSelected: Boolean = false,  // Currently selected
        val downRunId: Int = -1,  // Which vertical run this belongs to
        val acrossRunId: Int = -1  // Which horizontal run this belongs to
    ) : KakuroCell()
}

/**
 * Represents a run (sequence of white cells)
 */
data class KakuroRun(
    val id: Int,
    val targetSum: Int,
    val cells: List<Pair<Int, Int>>,  // List of (row, col) positions
    val isVertical: Boolean
)

/**
 * Complete Kakuro puzzle data
 */
data class KakuroPuzzle(
    val rows: Int,
    val cols: Int,
    val grid: List<List<KakuroCell>>,
    val runs: List<KakuroRun>,
    val solution: Map<Pair<Int, Int>, Int>  // (row, col) -> correct value
)

