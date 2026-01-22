package com.example.neuronest.kakuro


class KakuroGenerator {

    fun generatePuzzle(level: Int): KakuroPuzzle {
        val (rows, cols, runLength) = getDifficultyParams(level)

        return when {
            level <= 100 -> generateEasyPuzzle(rows, cols)
            level <= 200 -> generateMediumPuzzle(rows, cols)
            level <= 300 -> generateHardPuzzle(rows, cols)
            level <= 400 -> generateExpertPuzzle(rows, cols)
            else -> generateMasterPuzzle(rows, cols)
        }
    }

    private fun getDifficultyParams(level: Int): Triple<Int, Int, Int> {
        return when {
            level <= 100 -> Triple(4, 4, 2)  // 4x4 grid, runs of 2
            level <= 200 -> Triple(5, 5, 3)  // 5x5 grid, runs of 3
            level <= 300 -> Triple(6, 6, 3)  // 6x6 grid, runs of 3-4
            level <= 400 -> Triple(7, 7, 4)  // 7x7 grid, runs of 4
            else -> Triple(8, 8, 5)           // 8x8 grid, runs of 4-5
        }
    }

    private fun generateEasyPuzzle(rows: Int, cols: Int): KakuroPuzzle {
        // Simple 4x4 pattern: Cross shape with 2-cell runs
        val grid = mutableListOf<List<KakuroCell>>()
        val runs = mutableListOf<KakuroRun>()
        val solution = mutableMapOf<Pair<Int, Int>, Int>()


        for (r in 0 until rows) {
            val row = mutableListOf<KakuroCell>()
            for (c in 0 until cols) {
                when {
                    (r == 0 && c == 0) || (r == 0 && c == 3) ||
                    (r == 3 && c == 0) || (r == 3 && c == 3) -> {
                        row.add(KakuroCell.ClueCell())
                    }
                    r == 0 && c == 1 -> row.add(KakuroCell.ClueCell(downSum = 3, acrossSum = 0))
                    r == 0 && c == 2 -> row.add(KakuroCell.ClueCell(downSum = 7, acrossSum = 0))
                    c == 0 && r == 1 -> row.add(KakuroCell.ClueCell(downSum = 0, acrossSum = 6))
                    c == 0 && r == 2 -> row.add(KakuroCell.ClueCell(downSum = 0, acrossSum = 7))
                    c == 3 && r == 1 -> row.add(KakuroCell.ClueCell(downSum = 0, acrossSum = 5))
                    c == 3 && r == 2 -> row.add(KakuroCell.ClueCell(downSum = 0, acrossSum = 8))
                    r == 3 && c == 1 -> row.add(KakuroCell.ClueCell(downSum = 0, acrossSum = 3))
                    r == 3 && c == 2 -> row.add(KakuroCell.ClueCell(downSum = 0, acrossSum = 10))
                    else -> {
                        val downRun = if (c == 1) 0 else if (c == 2) 1 else -1
                        val acrossRun = if (r == 1) 2 else if (r == 2) 3 else -1
                        row.add(KakuroCell.PlayCell(downRunId = downRun, acrossRunId = acrossRun))
                    }
                }
            }
            grid.add(row)
        }

        runs.add(KakuroRun(0, 3, listOf(Pair(1, 1), Pair(2, 1)), true))  // Down: 1+2=3
        runs.add(KakuroRun(1, 7, listOf(Pair(1, 2), Pair(2, 2)), true))  // Down: 3+4=7
        runs.add(KakuroRun(2, 6, listOf(Pair(1, 1), Pair(1, 2)), false)) // Across: 1+3=4 (but we need 6, so 2+4=6)
        runs.add(KakuroRun(3, 7, listOf(Pair(2, 1), Pair(2, 2)), false)) // Across: 2+5=7

        solution[Pair(1, 1)] = 2
        solution[Pair(1, 2)] = 4
        solution[Pair(2, 1)] = 1
        solution[Pair(2, 2)] = 3

        return KakuroPuzzle(rows, cols, grid, runs, solution)
    }

    private fun generateMediumPuzzle(rows: Int, cols: Int): KakuroPuzzle {
        val grid = mutableListOf<List<KakuroCell>>()
        val runs = mutableListOf<KakuroRun>()
        val solution = mutableMapOf<Pair<Int, Int>, Int>()

        for (r in 0 until rows) {
            val row = mutableListOf<KakuroCell>()
            for (c in 0 until cols) {
                when {
                    r == 0 && c == 0 -> row.add(KakuroCell.ClueCell())
                    r == 0 && c == 1 -> row.add(KakuroCell.ClueCell(downSum = 6))
                    r == 0 && c == 2 -> row.add(KakuroCell.ClueCell(downSum = 15))
                    r == 0 && c == 3 -> row.add(KakuroCell.ClueCell(downSum = 9))
                    r == 1 && c == 0 -> row.add(KakuroCell.ClueCell(acrossSum = 10))
                    r == 2 && c == 0 -> row.add(KakuroCell.ClueCell(acrossSum = 12))
                    r == 3 && c == 0 -> row.add(KakuroCell.ClueCell(acrossSum = 14))
                    (r in 1..3 && c in 1..3) -> {
                        val downRun = c - 1
                        val acrossRun = r + 2
                        row.add(KakuroCell.PlayCell(downRunId = downRun, acrossRunId = acrossRun))
                    }
                    else -> row.add(KakuroCell.ClueCell())
                }
            }
            grid.add(row)
        }

        runs.add(KakuroRun(0, 6, listOf(Pair(1, 1), Pair(2, 1), Pair(3, 1)), true))
        runs.add(KakuroRun(1, 15, listOf(Pair(1, 2), Pair(2, 2), Pair(3, 2)), true))
        runs.add(KakuroRun(2, 9, listOf(Pair(1, 3), Pair(2, 3), Pair(3, 3)), true))
        runs.add(KakuroRun(3, 10, listOf(Pair(1, 1), Pair(1, 2), Pair(1, 3)), false))
        runs.add(KakuroRun(4, 12, listOf(Pair(2, 1), Pair(2, 2), Pair(2, 3)), false))
        runs.add(KakuroRun(5, 14, listOf(Pair(3, 1), Pair(3, 2), Pair(3, 3)), false))

        solution[Pair(1, 1)] = 1
        solution[Pair(1, 2)] = 4
        solution[Pair(1, 3)] = 5
        solution[Pair(2, 1)] = 2
        solution[Pair(2, 2)] = 6
        solution[Pair(2, 3)] = 4
        solution[Pair(3, 1)] = 3
        solution[Pair(3, 2)] = 5
        solution[Pair(3, 3)] = 6

        return KakuroPuzzle(rows, cols, grid, runs, solution)
    }

    private fun generateHardPuzzle(rows: Int, cols: Int): KakuroPuzzle {
        return generateMediumPuzzle(rows, cols)
    }

    private fun generateExpertPuzzle(rows: Int, cols: Int): KakuroPuzzle {
        return generateMediumPuzzle(rows, cols)
    }

    private fun generateMasterPuzzle(rows: Int, cols: Int): KakuroPuzzle {
        return generateMediumPuzzle(rows, cols)
    }
}

