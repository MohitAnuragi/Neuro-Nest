package com.example.neuronest.kakuro

object KakuroPuzzleData {
    val puzzles: List<KakuroPuzzle> = listOf(
        KakuroPuzzle(
            rows = 3,
            cols = 3,
            grid = listOf(
                listOf(
                    KakuroCell.ClueCell(downSum = 0, acrossSum = 0),
                    KakuroCell.ClueCell(downSum = 4, acrossSum = 0),
                    KakuroCell.ClueCell(downSum = 3, acrossSum = 0)
                ),
                listOf(
                    KakuroCell.ClueCell(downSum = 0, acrossSum = 3),
                    KakuroCell.PlayCell(value = 0, downRunId = 0, acrossRunId = 0),
                    KakuroCell.PlayCell(value = 0, downRunId = 1, acrossRunId = 0)
                ),
                listOf(
                    KakuroCell.ClueCell(downSum = 0, acrossSum = 4),
                    KakuroCell.PlayCell(value = 0, downRunId = 0, acrossRunId = 1),
                    KakuroCell.PlayCell(value = 0, downRunId = 1, acrossRunId = 1)
                )
            ),
            runs = listOf(
                KakuroRun(0, 4, listOf(Pair(1, 1), Pair(2, 1)), true),   // Down 4
                KakuroRun(1, 3, listOf(Pair(1, 2), Pair(2, 2)), true),   // Down 3
                KakuroRun(2, 3, listOf(Pair(1, 1), Pair(1, 2)), false),  // Across 3
                KakuroRun(3, 4, listOf(Pair(2, 1), Pair(2, 2)), false)   // Across 4
            ),
            solution = mapOf(
                Pair(1, 1) to 1,
                Pair(1, 2) to 2,
                Pair(2, 1) to 3,
                Pair(2, 2) to 1
            )
        ),

        KakuroPuzzle(
            rows = 3,
            cols = 3,
            grid = listOf(
                listOf(
                    KakuroCell.ClueCell(downSum = 0, acrossSum = 0),
                    KakuroCell.ClueCell(downSum = 3, acrossSum = 0),
                    KakuroCell.ClueCell(downSum = 6, acrossSum = 0)
                ),
                listOf(
                    KakuroCell.ClueCell(downSum = 0, acrossSum = 4),
                    KakuroCell.PlayCell(value = 0, downRunId = 0, acrossRunId = 0),
                    KakuroCell.PlayCell(value = 0, downRunId = 1, acrossRunId = 0)
                ),
                listOf(
                    KakuroCell.ClueCell(downSum = 0, acrossSum = 5),
                    KakuroCell.PlayCell(value = 0, downRunId = 0, acrossRunId = 1),
                    KakuroCell.PlayCell(value = 0, downRunId = 1, acrossRunId = 1)
                )
            ),
            runs = listOf(
                KakuroRun(0, 3, listOf(Pair(1, 1), Pair(2, 1)), true),
                KakuroRun(1, 6, listOf(Pair(1, 2), Pair(2, 2)), true),
                KakuroRun(2, 4, listOf(Pair(1, 1), Pair(1, 2)), false),
                KakuroRun(3, 5, listOf(Pair(2, 1), Pair(2, 2)), false)
            ),
            solution = mapOf(
                Pair(1, 1) to 1,
                Pair(1, 2) to 3,
                Pair(2, 1) to 2,
                Pair(2, 2) to 3
            )
        ),

        KakuroPuzzle(
            rows = 4,
            cols = 4,
            grid = listOf(
                listOf(
                    KakuroCell.ClueCell(downSum = 0, acrossSum = 0),
                    KakuroCell.ClueCell(downSum = 6, acrossSum = 0),
                    KakuroCell.ClueCell(downSum = 3, acrossSum = 0),
                    KakuroCell.ClueCell(downSum = 0, acrossSum = 0)
                ),
                listOf(
                    KakuroCell.ClueCell(downSum = 0, acrossSum = 7),
                    KakuroCell.PlayCell(value = 0, downRunId = 0, acrossRunId = 0),
                    KakuroCell.PlayCell(value = 0, downRunId = 1, acrossRunId = 0),
                    KakuroCell.ClueCell(downSum = 0, acrossSum = 0)
                ),
                listOf(
                    KakuroCell.ClueCell(downSum = 0, acrossSum = 3),
                    KakuroCell.PlayCell(value = 0, downRunId = 0, acrossRunId = 1),
                    KakuroCell.PlayCell(value = 0, downRunId = 1, acrossRunId = 1),
                    KakuroCell.ClueCell(downSum = 0, acrossSum = 0)
                ),
                listOf(
                    KakuroCell.ClueCell(downSum = 0, acrossSum = 0),
                    KakuroCell.ClueCell(downSum = 0, acrossSum = 0),
                    KakuroCell.ClueCell(downSum = 0, acrossSum = 0),
                    KakuroCell.ClueCell(downSum = 0, acrossSum = 0)
                )
            ),
            runs = listOf(
                KakuroRun(0, 6, listOf(Pair(1, 1), Pair(2, 1)), true),
                KakuroRun(1, 3, listOf(Pair(1, 2), Pair(2, 2)), true),
                KakuroRun(2, 7, listOf(Pair(1, 1), Pair(1, 2)), false),
                KakuroRun(3, 3, listOf(Pair(2, 1), Pair(2, 2)), false)
            ),
            solution = mapOf(
                Pair(1, 1) to 4,
                Pair(1, 2) to 3,
                Pair(2, 1) to 2,
                Pair(2, 2) to 1
            )
        ),

        *generateValidKakuroPuzzles(4, 20, "Easy", 3),
        *generateValidKakuroPuzzles(21, 40, "Easy", 4),
        *generateValidKakuroPuzzles(41, 60, "Medium", 4),
        *generateValidKakuroPuzzles(61, 80, "Medium", 5),
        *generateValidKakuroPuzzles(81, 100, "Hard", 5)
    )

    private fun generateValidKakuroPuzzles(
        startLevel: Int,
        endLevel: Int,
        difficulty: String,
        gridSize: Int
    ): Array<KakuroPuzzle> {
        val generator = KakuroGenerator()
        return (startLevel..endLevel).map { level ->
            generator.generatePuzzle(level)
        }.toTypedArray()
    }

    fun getPuzzleForLevel(level: Int): KakuroPuzzle {
        val idx = (level - 1).coerceIn(0, puzzles.size - 1)
        return puzzles[idx]
    }
}

