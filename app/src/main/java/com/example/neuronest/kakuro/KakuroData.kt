package com.example.neuronest.kakuro


sealed class KakuroCell {
    data class ClueCell(
        val downSum: Int = 0,
        val acrossSum: Int = 0
    ) : KakuroCell()

    data class PlayCell(
        val value: Int = 0,
        val isError: Boolean = false,
        val isSelected: Boolean = false,
        val downRunId: Int = -1,
        val acrossRunId: Int = -1
    ) : KakuroCell()
}

data class KakuroRun(
    val id: Int,
    val targetSum: Int,
    val cells: List<Pair<Int, Int>>,
    val isVertical: Boolean
)

data class KakuroPuzzle(
    val rows: Int,
    val cols: Int,
    val grid: List<List<KakuroCell>>,
    val runs: List<KakuroRun>,
    val solution: Map<Pair<Int, Int>, Int>
)

