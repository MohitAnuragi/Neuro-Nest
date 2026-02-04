package com.neuronest.neuronest.kakuro

object KakuroPuzzleDataPart1 {
    fun getPuzzles(): List<KakuroPuzzle> = listOf(
        KakuroPuzzle(
            rows = 3,
            cols = 3,
            grid = listOf(
                listOf(
                    KakuroCell.ClueCell(downSum = 0, acrossSum = 0),
                    KakuroCell.ClueCell(downSum = 3, acrossSum = 0),
                    KakuroCell.ClueCell(downSum = 8, acrossSum = 0)
                ),
                listOf(
                    KakuroCell.ClueCell(downSum = 0, acrossSum = 4),
                    KakuroCell.PlayCell(downRunId = 0, acrossRunId = 2),
                    KakuroCell.PlayCell(downRunId = 1, acrossRunId = 2)
                ),
                listOf(
                    KakuroCell.ClueCell(downSum = 0, acrossSum = 7),
                    KakuroCell.PlayCell(downRunId = 0, acrossRunId = 3),
                    KakuroCell.PlayCell(downRunId = 1, acrossRunId = 3)
                )
            ),
            runs = listOf(
                KakuroRun(id = 0, targetSum = 3, cells = listOf(Pair(1, 1), Pair(2, 1)), isVertical = true),
                KakuroRun(id = 1, targetSum = 8, cells = listOf(Pair(1, 2), Pair(2, 2)), isVertical = true),
                KakuroRun(id = 2, targetSum = 4, cells = listOf(Pair(1, 1), Pair(1, 2)), isVertical = false),
                KakuroRun(id = 3, targetSum = 7, cells = listOf(Pair(2, 1), Pair(2, 2)), isVertical = false)
            ),
            solution = mapOf(
                Pair(1, 1) to 1,
                Pair(1, 2) to 3,
                Pair(2, 1) to 2,
                Pair(2, 2) to 5
            )
        ),

        KakuroPuzzle(
            rows = 3,
            cols = 3,
            grid = listOf(
                listOf(
                    KakuroCell.ClueCell(downSum = 0, acrossSum = 0),
                    KakuroCell.ClueCell(downSum = 4, acrossSum = 0),
                    KakuroCell.ClueCell(downSum = 7, acrossSum = 0)
                ),
                listOf(
                    KakuroCell.ClueCell(downSum = 0, acrossSum = 3),
                    KakuroCell.PlayCell(downRunId = 0, acrossRunId = 2),
                    KakuroCell.PlayCell(downRunId = 1, acrossRunId = 2)
                ),
                listOf(
                    KakuroCell.ClueCell(downSum = 0, acrossSum = 8),
                    KakuroCell.PlayCell(downRunId = 0, acrossRunId = 3),
                    KakuroCell.PlayCell(downRunId = 1, acrossRunId = 3)
                )
            ),
            runs = listOf(
                KakuroRun(id = 0, targetSum = 4, cells = listOf(Pair(1, 1), Pair(2, 1)), isVertical = true),
                KakuroRun(id = 1, targetSum = 7, cells = listOf(Pair(1, 2), Pair(2, 2)), isVertical = true),
                KakuroRun(id = 2, targetSum = 3, cells = listOf(Pair(1, 1), Pair(1, 2)), isVertical = false),
                KakuroRun(id = 3, targetSum = 8, cells = listOf(Pair(2, 1), Pair(2, 2)), isVertical = false)
            ),
            solution = mapOf(
                Pair(1, 1) to 1,
                Pair(1, 2) to 2,
                Pair(2, 1) to 3,
                Pair(2, 2) to 5
            )
        ),

        KakuroPuzzle(
            rows = 3,
            cols = 3,
            grid = listOf(
                listOf(
                    KakuroCell.ClueCell(downSum = 0, acrossSum = 0),
                    KakuroCell.ClueCell(downSum = 6, acrossSum = 0),
                    KakuroCell.ClueCell(downSum = 9, acrossSum = 0)
                ),
                listOf(
                    KakuroCell.ClueCell(downSum = 0, acrossSum = 5),
                    KakuroCell.PlayCell(downRunId = 0, acrossRunId = 2),
                    KakuroCell.PlayCell(downRunId = 1, acrossRunId = 2)
                ),
                listOf(
                    KakuroCell.ClueCell(downSum = 0, acrossSum = 10),
                    KakuroCell.PlayCell(downRunId = 0, acrossRunId = 3),
                    KakuroCell.PlayCell(downRunId = 1, acrossRunId = 3)
                )
            ),
            runs = listOf(
                KakuroRun(id = 0, targetSum = 6, cells = listOf(Pair(1, 1), Pair(2, 1)), isVertical = true),
                KakuroRun(id = 1, targetSum = 9, cells = listOf(Pair(1, 2), Pair(2, 2)), isVertical = true),
                KakuroRun(id = 2, targetSum = 5, cells = listOf(Pair(1, 1), Pair(1, 2)), isVertical = false),
                KakuroRun(id = 3, targetSum = 10, cells = listOf(Pair(2, 1), Pair(2, 2)), isVertical = false)
            ),
            solution = mapOf(
                Pair(1, 1) to 2,
                Pair(1, 2) to 3,
                Pair(2, 1) to 4,
                Pair(2, 2) to 6
            )
        ),

        KakuroPuzzle(
            rows = 3,
            cols = 3,
            grid = listOf(
                listOf(
                    KakuroCell.ClueCell(downSum = 0, acrossSum = 0),
                    KakuroCell.ClueCell(downSum = 7, acrossSum = 0),
                    KakuroCell.ClueCell(downSum = 7, acrossSum = 0)
                ),
                listOf(
                    KakuroCell.ClueCell(downSum = 0, acrossSum = 6),
                    KakuroCell.PlayCell(downRunId = 0, acrossRunId = 2),
                    KakuroCell.PlayCell(downRunId = 1, acrossRunId = 2)
                ),
                listOf(
                    KakuroCell.ClueCell(downSum = 0, acrossSum = 8),
                    KakuroCell.PlayCell(downRunId = 0, acrossRunId = 3),
                    KakuroCell.PlayCell(downRunId = 1, acrossRunId = 3)
                )
            ),
            runs = listOf(
                KakuroRun(id = 0, targetSum = 7, cells = listOf(Pair(1, 1), Pair(2, 1)), isVertical = true),
                KakuroRun(id = 1, targetSum = 7, cells = listOf(Pair(1, 2), Pair(2, 2)), isVertical = true),
                KakuroRun(id = 2, targetSum = 6, cells = listOf(Pair(1, 1), Pair(1, 2)), isVertical = false),
                KakuroRun(id = 3, targetSum = 8, cells = listOf(Pair(2, 1), Pair(2, 2)), isVertical = false)
            ),
            solution = mapOf(
                Pair(1, 1) to 4,
                Pair(1, 2) to 2,
                Pair(2, 1) to 3,
                Pair(2, 2) to 5
            )
        ),

        KakuroPuzzle(
            rows = 3,
            cols = 3,
            grid = listOf(
                listOf(
                    KakuroCell.ClueCell(downSum = 0, acrossSum = 0),
                    KakuroCell.ClueCell(downSum = 8, acrossSum = 0),
                    KakuroCell.ClueCell(downSum = 6, acrossSum = 0)
                ),
                listOf(
                    KakuroCell.ClueCell(downSum = 0, acrossSum = 7),
                    KakuroCell.PlayCell(downRunId = 0, acrossRunId = 2),
                    KakuroCell.PlayCell(downRunId = 1, acrossRunId = 2)
                ),
                listOf(
                    KakuroCell.ClueCell(downSum = 0, acrossSum = 7),
                    KakuroCell.PlayCell(downRunId = 0, acrossRunId = 3),
                    KakuroCell.PlayCell(downRunId = 1, acrossRunId = 3)
                )
            ),
            runs = listOf(
                KakuroRun(id = 0, targetSum = 8, cells = listOf(Pair(1, 1), Pair(2, 1)), isVertical = true),
                KakuroRun(id = 1, targetSum = 6, cells = listOf(Pair(1, 2), Pair(2, 2)), isVertical = true),
                KakuroRun(id = 2, targetSum = 7, cells = listOf(Pair(1, 1), Pair(1, 2)), isVertical = false),
                KakuroRun(id = 3, targetSum = 7, cells = listOf(Pair(2, 1), Pair(2, 2)), isVertical = false)
            ),
            solution = mapOf(
                Pair(1, 1) to 5,
                Pair(1, 2) to 2,
                Pair(2, 1) to 3,
                Pair(2, 2) to 4
            )
        ),

        KakuroPuzzle(
            rows = 3,
            cols = 3,
            grid = listOf(
                listOf(
                    KakuroCell.ClueCell(downSum = 0, acrossSum = 0),
                    KakuroCell.ClueCell(downSum = 5, acrossSum = 0),
                    KakuroCell.ClueCell(downSum = 13, acrossSum = 0)
                ),
                listOf(
                    KakuroCell.ClueCell(downSum = 0, acrossSum = 8),
                    KakuroCell.PlayCell(downRunId = 0, acrossRunId = 2),
                    KakuroCell.PlayCell(downRunId = 1, acrossRunId = 2)
                ),
                listOf(
                    KakuroCell.ClueCell(downSum = 0, acrossSum = 10),
                    KakuroCell.PlayCell(downRunId = 0, acrossRunId = 3),
                    KakuroCell.PlayCell(downRunId = 1, acrossRunId = 3)
                )
            ),
            runs = listOf(
                KakuroRun(id = 0, targetSum = 5, cells = listOf(Pair(1, 1), Pair(2, 1)), isVertical = true),
                KakuroRun(id = 1, targetSum = 13, cells = listOf(Pair(1, 2), Pair(2, 2)), isVertical = true),
                KakuroRun(id = 2, targetSum = 8, cells = listOf(Pair(1, 1), Pair(1, 2)), isVertical = false),
                KakuroRun(id = 3, targetSum = 10, cells = listOf(Pair(2, 1), Pair(2, 2)), isVertical = false)
            ),
            solution = mapOf(
                Pair(1, 1) to 2,
                Pair(1, 2) to 6,
                Pair(2, 1) to 3,
                Pair(2, 2) to 7
            )
        ),

        KakuroPuzzle(
            rows = 3,
            cols = 3,
            grid = listOf(
                listOf(
                    KakuroCell.ClueCell(downSum = 0, acrossSum = 0),
                    KakuroCell.ClueCell(downSum = 9, acrossSum = 0),
                    KakuroCell.ClueCell(downSum = 7, acrossSum = 0)
                ),
                listOf(
                    KakuroCell.ClueCell(downSum = 0, acrossSum = 8),
                    KakuroCell.PlayCell(downRunId = 0, acrossRunId = 2),
                    KakuroCell.PlayCell(downRunId = 1, acrossRunId = 2)
                ),
                listOf(
                    KakuroCell.ClueCell(downSum = 0, acrossSum = 8),
                    KakuroCell.PlayCell(downRunId = 0, acrossRunId = 3),
                    KakuroCell.PlayCell(downRunId = 1, acrossRunId = 3)
                )
            ),
            runs = listOf(
                KakuroRun(id = 0, targetSum = 9, cells = listOf(Pair(1, 1), Pair(2, 1)), isVertical = true),
                KakuroRun(id = 1, targetSum = 7, cells = listOf(Pair(1, 2), Pair(2, 2)), isVertical = true),
                KakuroRun(id = 2, targetSum = 8, cells = listOf(Pair(1, 1), Pair(1, 2)), isVertical = false),
                KakuroRun(id = 3, targetSum = 8, cells = listOf(Pair(2, 1), Pair(2, 2)), isVertical = false)
            ),
            solution = mapOf(
                Pair(1, 1) to 6,
                Pair(1, 2) to 2,
                Pair(2, 1) to 3,
                Pair(2, 2) to 5
            )
        ),

        KakuroPuzzle(
            rows = 3,
            cols = 3,
            grid = listOf(
                listOf(
                    KakuroCell.ClueCell(downSum = 0, acrossSum = 0),
                    KakuroCell.ClueCell(downSum = 10, acrossSum = 0),
                    KakuroCell.ClueCell(downSum = 6, acrossSum = 0)
                ),
                listOf(
                    KakuroCell.ClueCell(downSum = 0, acrossSum = 11),
                    KakuroCell.PlayCell(downRunId = 0, acrossRunId = 2),
                    KakuroCell.PlayCell(downRunId = 1, acrossRunId = 2)
                ),
                listOf(
                    KakuroCell.ClueCell(downSum = 0, acrossSum = 5),
                    KakuroCell.PlayCell(downRunId = 0, acrossRunId = 3),
                    KakuroCell.PlayCell(downRunId = 1, acrossRunId = 3)
                )
            ),
            runs = listOf(
                KakuroRun(id = 0, targetSum = 10, cells = listOf(Pair(1, 1), Pair(2, 1)), isVertical = true),
                KakuroRun(id = 1, targetSum = 6, cells = listOf(Pair(1, 2), Pair(2, 2)), isVertical = true),
                KakuroRun(id = 2, targetSum = 11, cells = listOf(Pair(1, 1), Pair(1, 2)), isVertical = false),
                KakuroRun(id = 3, targetSum = 5, cells = listOf(Pair(2, 1), Pair(2, 2)), isVertical = false)
            ),
            solution = mapOf(
                Pair(1, 1) to 7,
                Pair(1, 2) to 4,
                Pair(2, 1) to 3,
                Pair(2, 2) to 2
            )
        ),

        KakuroPuzzle(
            rows = 3,
            cols = 3,
            grid = listOf(
                listOf(
                    KakuroCell.ClueCell(downSum = 0, acrossSum = 0),
                    KakuroCell.ClueCell(downSum = 11, acrossSum = 0),
                    KakuroCell.ClueCell(downSum = 8, acrossSum = 0)
                ),
                listOf(
                    KakuroCell.ClueCell(downSum = 0, acrossSum = 12),
                    KakuroCell.PlayCell(downRunId = 0, acrossRunId = 2),
                    KakuroCell.PlayCell(downRunId = 1, acrossRunId = 2)
                ),
                listOf(
                    KakuroCell.ClueCell(downSum = 0, acrossSum = 7),
                    KakuroCell.PlayCell(downRunId = 0, acrossRunId = 3),
                    KakuroCell.PlayCell(downRunId = 1, acrossRunId = 3)
                )
            ),
            runs = listOf(
                KakuroRun(id = 0, targetSum = 11, cells = listOf(Pair(1, 1), Pair(2, 1)), isVertical = true),
                KakuroRun(id = 1, targetSum = 8, cells = listOf(Pair(1, 2), Pair(2, 2)), isVertical = true),
                KakuroRun(id = 2, targetSum = 12, cells = listOf(Pair(1, 1), Pair(1, 2)), isVertical = false),
                KakuroRun(id = 3, targetSum = 7, cells = listOf(Pair(2, 1), Pair(2, 2)), isVertical = false)
            ),
            solution = mapOf(
                Pair(1, 1) to 7,
                Pair(1, 2) to 5,
                Pair(2, 1) to 4,
                Pair(2, 2) to 3
            )
        ),

        KakuroPuzzle(
            rows = 3,
            cols = 3,
            grid = listOf(
                listOf(
                    KakuroCell.ClueCell(downSum = 0, acrossSum = 0),
                    KakuroCell.ClueCell(downSum = 12, acrossSum = 0),
                    KakuroCell.ClueCell(downSum = 11, acrossSum = 0)
                ),
                listOf(
                    KakuroCell.ClueCell(downSum = 0, acrossSum = 13),
                    KakuroCell.PlayCell(downRunId = 0, acrossRunId = 2),
                    KakuroCell.PlayCell(downRunId = 1, acrossRunId = 2)
                ),
                listOf(
                    KakuroCell.ClueCell(downSum = 0, acrossSum = 10),
                    KakuroCell.PlayCell(downRunId = 0, acrossRunId = 3),
                    KakuroCell.PlayCell(downRunId = 1, acrossRunId = 3)
                )
            ),
            runs = listOf(
                KakuroRun(id = 0, targetSum = 12, cells = listOf(Pair(1, 1), Pair(2, 1)), isVertical = true),
                KakuroRun(id = 1, targetSum = 11, cells = listOf(Pair(1, 2), Pair(2, 2)), isVertical = true),
                KakuroRun(id = 2, targetSum = 13, cells = listOf(Pair(1, 1), Pair(1, 2)), isVertical = false),
                KakuroRun(id = 3, targetSum = 10, cells = listOf(Pair(2, 1), Pair(2, 2)), isVertical = false)
            ),
            solution = mapOf(
                Pair(1, 1) to 8,
                Pair(1, 2) to 5,
                Pair(2, 1) to 4,
                Pair(2, 2) to 6
            )
        ),

        KakuroPuzzle(
            rows = 3,
            cols = 3,
            grid = listOf(
                listOf(
                    KakuroCell.ClueCell(downSum = 0, acrossSum = 0),
                    KakuroCell.ClueCell(downSum = 13, acrossSum = 0),
                    KakuroCell.ClueCell(downSum = 8, acrossSum = 0)
                ),
                listOf(
                    KakuroCell.ClueCell(downSum = 0, acrossSum = 14),
                    KakuroCell.PlayCell(downRunId = 0, acrossRunId = 2),
                    KakuroCell.PlayCell(downRunId = 1, acrossRunId = 2)
                ),
                listOf(
                    KakuroCell.ClueCell(downSum = 0, acrossSum = 7),
                    KakuroCell.PlayCell(downRunId = 0, acrossRunId = 3),
                    KakuroCell.PlayCell(downRunId = 1, acrossRunId = 3)
                )
            ),
            runs = listOf(
                KakuroRun(id = 0, targetSum = 13, cells = listOf(Pair(1, 1), Pair(2, 1)), isVertical = true),
                KakuroRun(id = 1, targetSum = 8, cells = listOf(Pair(1, 2), Pair(2, 2)), isVertical = true),
                KakuroRun(id = 2, targetSum = 14, cells = listOf(Pair(1, 1), Pair(1, 2)), isVertical = false),
                KakuroRun(id = 3, targetSum = 7, cells = listOf(Pair(2, 1), Pair(2, 2)), isVertical = false)
            ),
            solution = mapOf(
                Pair(1, 1) to 8,
                Pair(1, 2) to 6,
                Pair(2, 1) to 5,
                Pair(2, 2) to 2
            )
        ),

        KakuroPuzzle(
            rows = 3,
            cols = 3,
            grid = listOf(
                listOf(
                    KakuroCell.ClueCell(downSum = 0, acrossSum = 0),
                    KakuroCell.ClueCell(downSum = 14, acrossSum = 0),
                    KakuroCell.ClueCell(downSum = 13, acrossSum = 0)
                ),
                listOf(
                    KakuroCell.ClueCell(downSum = 0, acrossSum = 15),
                    KakuroCell.PlayCell(downRunId = 0, acrossRunId = 2),
                    KakuroCell.PlayCell(downRunId = 1, acrossRunId = 2)
                ),
                listOf(
                    KakuroCell.ClueCell(downSum = 0, acrossSum = 12),
                    KakuroCell.PlayCell(downRunId = 0, acrossRunId = 3),
                    KakuroCell.PlayCell(downRunId = 1, acrossRunId = 3)
                )
            ),
            runs = listOf(
                KakuroRun(id = 0, targetSum = 14, cells = listOf(Pair(1, 1), Pair(2, 1)), isVertical = true),
                KakuroRun(id = 1, targetSum = 13, cells = listOf(Pair(1, 2), Pair(2, 2)), isVertical = true),
                KakuroRun(id = 2, targetSum = 15, cells = listOf(Pair(1, 1), Pair(1, 2)), isVertical = false),
                KakuroRun(id = 3, targetSum = 12, cells = listOf(Pair(2, 1), Pair(2, 2)), isVertical = false)
            ),
            solution = mapOf(
                Pair(1, 1) to 9,
                Pair(1, 2) to 6,
                Pair(2, 1) to 5,
                Pair(2, 2) to 7
            )
        ),

        KakuroPuzzle(
            rows = 3,
            cols = 3,
            grid = listOf(
                listOf(
                    KakuroCell.ClueCell(downSum = 0, acrossSum = 0),
                    KakuroCell.ClueCell(downSum = 15, acrossSum = 0),
                    KakuroCell.ClueCell(downSum = 12, acrossSum = 0)
                ),
                listOf(
                    KakuroCell.ClueCell(downSum = 0, acrossSum = 16),
                    KakuroCell.PlayCell(downRunId = 0, acrossRunId = 2),
                    KakuroCell.PlayCell(downRunId = 1, acrossRunId = 2)
                ),
                listOf(
                    KakuroCell.ClueCell(downSum = 0, acrossSum = 11),
                    KakuroCell.PlayCell(downRunId = 0, acrossRunId = 3),
                    KakuroCell.PlayCell(downRunId = 1, acrossRunId = 3)
                )
            ),
            runs = listOf(
                KakuroRun(id = 0, targetSum = 15, cells = listOf(Pair(1, 1), Pair(2, 1)), isVertical = true),
                KakuroRun(id = 1, targetSum = 12, cells = listOf(Pair(1, 2), Pair(2, 2)), isVertical = true),
                KakuroRun(id = 2, targetSum = 16, cells = listOf(Pair(1, 1), Pair(1, 2)), isVertical = false),
                KakuroRun(id = 3, targetSum = 11, cells = listOf(Pair(2, 1), Pair(2, 2)), isVertical = false)
            ),
            solution = mapOf(
                Pair(1, 1) to 9,
                Pair(1, 2) to 7,
                Pair(2, 1) to 6,
                Pair(2, 2) to 5
            )
        ),

        KakuroPuzzle(
            rows = 3,
            cols = 3,
            grid = listOf(
                listOf(
                    KakuroCell.ClueCell(downSum = 0, acrossSum = 0),
                    KakuroCell.ClueCell(downSum = 16, acrossSum = 0),
                    KakuroCell.ClueCell(downSum = 14, acrossSum = 0)
                ),
                listOf(
                    KakuroCell.ClueCell(downSum = 0, acrossSum = 17),
                    KakuroCell.PlayCell(downRunId = 0, acrossRunId = 2),
                    KakuroCell.PlayCell(downRunId = 1, acrossRunId = 2)
                ),
                listOf(
                    KakuroCell.ClueCell(downSum = 0, acrossSum = 13),
                    KakuroCell.PlayCell(downRunId = 0, acrossRunId = 3),
                    KakuroCell.PlayCell(downRunId = 1, acrossRunId = 3)
                )
            ),
            runs = listOf(
                KakuroRun(id = 0, targetSum = 16, cells = listOf(Pair(1, 1), Pair(2, 1)), isVertical = true),
                KakuroRun(id = 1, targetSum = 14, cells = listOf(Pair(1, 2), Pair(2, 2)), isVertical = true),
                KakuroRun(id = 2, targetSum = 17, cells = listOf(Pair(1, 1), Pair(1, 2)), isVertical = false),
                KakuroRun(id = 3, targetSum = 13, cells = listOf(Pair(2, 1), Pair(2, 2)), isVertical = false)
            ),
            solution = mapOf(
                Pair(1, 1) to 9,
                Pair(1, 2) to 8,
                Pair(2, 1) to 7,
                Pair(2, 2) to 6
            )
        ),

        KakuroPuzzle(
            rows = 3,
            cols = 3,
            grid = listOf(
                listOf(
                    KakuroCell.ClueCell(downSum = 0, acrossSum = 0),
                    KakuroCell.ClueCell(downSum = 6, acrossSum = 0),
                    KakuroCell.ClueCell(downSum = 4, acrossSum = 0)
                ),
                listOf(
                    KakuroCell.ClueCell(downSum = 0, acrossSum = 7),
                    KakuroCell.PlayCell(downRunId = 0, acrossRunId = 2),
                    KakuroCell.PlayCell(downRunId = 1, acrossRunId = 2)
                ),
                listOf(
                    KakuroCell.ClueCell(downSum = 0, acrossSum = 3),
                    KakuroCell.PlayCell(downRunId = 0, acrossRunId = 3),
                    KakuroCell.PlayCell(downRunId = 1, acrossRunId = 3)
                )
            ),
            runs = listOf(
                KakuroRun(id = 0, targetSum = 6, cells = listOf(Pair(1, 1), Pair(2, 1)), isVertical = true),
                KakuroRun(id = 1, targetSum = 4, cells = listOf(Pair(1, 2), Pair(2, 2)), isVertical = true),
                KakuroRun(id = 2, targetSum = 7, cells = listOf(Pair(1, 1), Pair(1, 2)), isVertical = false),
                KakuroRun(id = 3, targetSum = 3, cells = listOf(Pair(2, 1), Pair(2, 2)), isVertical = false)
            ),
            solution = mapOf(
                Pair(1, 1) to 4,
                Pair(1, 2) to 3,
                Pair(2, 1) to 2,
                Pair(2, 2) to 1
            )
        ),

        KakuroPuzzle(
            rows = 3,
            cols = 3,
            grid = listOf(
                listOf(
                    KakuroCell.ClueCell(downSum = 0, acrossSum = 0),
                    KakuroCell.ClueCell(downSum = 7, acrossSum = 0),
                    KakuroCell.ClueCell(downSum = 8, acrossSum = 0)
                ),
                listOf(
                    KakuroCell.ClueCell(downSum = 0, acrossSum = 9),
                    KakuroCell.PlayCell(downRunId = 0, acrossRunId = 2),
                    KakuroCell.PlayCell(downRunId = 1, acrossRunId = 2)
                ),
                listOf(
                    KakuroCell.ClueCell(downSum = 0, acrossSum = 6),
                    KakuroCell.PlayCell(downRunId = 0, acrossRunId = 3),
                    KakuroCell.PlayCell(downRunId = 1, acrossRunId = 3)
                )
            ),
            runs = listOf(
                KakuroRun(id = 0, targetSum = 7, cells = listOf(Pair(1, 1), Pair(2, 1)), isVertical = true),
                KakuroRun(id = 1, targetSum = 8, cells = listOf(Pair(1, 2), Pair(2, 2)), isVertical = true),
                KakuroRun(id = 2, targetSum = 9, cells = listOf(Pair(1, 1), Pair(1, 2)), isVertical = false),
                KakuroRun(id = 3, targetSum = 6, cells = listOf(Pair(2, 1), Pair(2, 2)), isVertical = false)
            ),
            solution = mapOf(
                Pair(1, 1) to 3,
                Pair(1, 2) to 6,
                Pair(2, 1) to 4,
                Pair(2, 2) to 2
            )
        ),

        KakuroPuzzle(
            rows = 3,
            cols = 3,
            grid = listOf(
                listOf(
                    KakuroCell.ClueCell(downSum = 0, acrossSum = 0),
                    KakuroCell.ClueCell(downSum = 8, acrossSum = 0),
                    KakuroCell.ClueCell(downSum = 7, acrossSum = 0)
                ),
                listOf(
                    KakuroCell.ClueCell(downSum = 0, acrossSum = 6),
                    KakuroCell.PlayCell(downRunId = 0, acrossRunId = 2),
                    KakuroCell.PlayCell(downRunId = 1, acrossRunId = 2)
                ),
                listOf(
                    KakuroCell.ClueCell(downSum = 0, acrossSum = 9),
                    KakuroCell.PlayCell(downRunId = 0, acrossRunId = 3),
                    KakuroCell.PlayCell(downRunId = 1, acrossRunId = 3)
                )
            ),
            runs = listOf(
                KakuroRun(id = 0, targetSum = 8, cells = listOf(Pair(1, 1), Pair(2, 1)), isVertical = true),
                KakuroRun(id = 1, targetSum = 7, cells = listOf(Pair(1, 2), Pair(2, 2)), isVertical = true),
                KakuroRun(id = 2, targetSum = 6, cells = listOf(Pair(1, 1), Pair(1, 2)), isVertical = false),
                KakuroRun(id = 3, targetSum = 9, cells = listOf(Pair(2, 1), Pair(2, 2)), isVertical = false)
            ),
            solution = mapOf(
                Pair(1, 1) to 2,
                Pair(1, 2) to 4,
                Pair(2, 1) to 6,
                Pair(2, 2) to 3
            )
        ),

        KakuroPuzzle(
            rows = 3,
            cols = 3,
            grid = listOf(
                listOf(
                    KakuroCell.ClueCell(downSum = 0, acrossSum = 0),
                    KakuroCell.ClueCell(downSum = 5, acrossSum = 0),
                    KakuroCell.ClueCell(downSum = 12, acrossSum = 0)
                ),
                listOf(
                    KakuroCell.ClueCell(downSum = 0, acrossSum = 10),
                    KakuroCell.PlayCell(downRunId = 0, acrossRunId = 2),
                    KakuroCell.PlayCell(downRunId = 1, acrossRunId = 2)
                ),
                listOf(
                    KakuroCell.ClueCell(downSum = 0, acrossSum = 7),
                    KakuroCell.PlayCell(downRunId = 0, acrossRunId = 3),
                    KakuroCell.PlayCell(downRunId = 1, acrossRunId = 3)
                )
            ),
            runs = listOf(
                KakuroRun(id = 0, targetSum = 5, cells = listOf(Pair(1, 1), Pair(2, 1)), isVertical = true),
                KakuroRun(id = 1, targetSum = 12, cells = listOf(Pair(1, 2), Pair(2, 2)), isVertical = true),
                KakuroRun(id = 2, targetSum = 10, cells = listOf(Pair(1, 1), Pair(1, 2)), isVertical = false),
                KakuroRun(id = 3, targetSum = 7, cells = listOf(Pair(2, 1), Pair(2, 2)), isVertical = false)
            ),
            solution = mapOf(
                Pair(1, 1) to 2,
                Pair(1, 2) to 8,
                Pair(2, 1) to 3,
                Pair(2, 2) to 4
            )
        ),

        KakuroPuzzle(
            rows = 3,
            cols = 3,
            grid = listOf(
                listOf(
                    KakuroCell.ClueCell(downSum = 0, acrossSum = 0),
                    KakuroCell.ClueCell(downSum = 9, acrossSum = 0),
                    KakuroCell.ClueCell(downSum = 4, acrossSum = 0)
                ),
                listOf(
                    KakuroCell.ClueCell(downSum = 0, acrossSum = 8),
                    KakuroCell.PlayCell(downRunId = 0, acrossRunId = 2),
                    KakuroCell.PlayCell(downRunId = 1, acrossRunId = 2)
                ),
                listOf(
                    KakuroCell.ClueCell(downSum = 0, acrossSum = 5),
                    KakuroCell.PlayCell(downRunId = 0, acrossRunId = 3),
                    KakuroCell.PlayCell(downRunId = 1, acrossRunId = 3)
                )
            ),
            runs = listOf(
                KakuroRun(id = 0, targetSum = 9, cells = listOf(Pair(1, 1), Pair(2, 1)), isVertical = true),
                KakuroRun(id = 1, targetSum = 4, cells = listOf(Pair(1, 2), Pair(2, 2)), isVertical = true),
                KakuroRun(id = 2, targetSum = 8, cells = listOf(Pair(1, 1), Pair(1, 2)), isVertical = false),
                KakuroRun(id = 3, targetSum = 5, cells = listOf(Pair(2, 1), Pair(2, 2)), isVertical = false)
            ),
            solution = mapOf(
                Pair(1, 1) to 5,
                Pair(1, 2) to 3,
                Pair(2, 1) to 4,
                Pair(2, 2) to 1
            )
        ),

        KakuroPuzzle(
            rows = 3,
            cols = 3,
            grid = listOf(
                listOf(
                    KakuroCell.ClueCell(downSum = 0, acrossSum = 0),
                    KakuroCell.ClueCell(downSum = 10, acrossSum = 0),
                    KakuroCell.ClueCell(downSum = 6, acrossSum = 0)
                ),
                listOf(
                    KakuroCell.ClueCell(downSum = 0, acrossSum = 5),
                    KakuroCell.PlayCell(downRunId = 0, acrossRunId = 2),
                    KakuroCell.PlayCell(downRunId = 1, acrossRunId = 2)
                ),
                listOf(
                    KakuroCell.ClueCell(downSum = 0, acrossSum = 11),
                    KakuroCell.PlayCell(downRunId = 0, acrossRunId = 3),
                    KakuroCell.PlayCell(downRunId = 1, acrossRunId = 3)
                )
            ),
            runs = listOf(
                KakuroRun(id = 0, targetSum = 10, cells = listOf(Pair(1, 1), Pair(2, 1)), isVertical = true),
                KakuroRun(id = 1, targetSum = 6, cells = listOf(Pair(1, 2), Pair(2, 2)), isVertical = true),
                KakuroRun(id = 2, targetSum = 5, cells = listOf(Pair(1, 1), Pair(1, 2)), isVertical = false),
                KakuroRun(id = 3, targetSum = 11, cells = listOf(Pair(2, 1), Pair(2, 2)), isVertical = false)
            ),
            solution = mapOf(
                Pair(1, 1) to 4,
                Pair(1, 2) to 1,
                Pair(2, 1) to 6,
                Pair(2, 2) to 5
            )
        ),

        KakuroPuzzle(
            rows = 3,
            cols = 3,
            grid = listOf(
                listOf(
                    KakuroCell.ClueCell(downSum = 0, acrossSum = 0),
                    KakuroCell.ClueCell(downSum = 11, acrossSum = 0),
                    KakuroCell.ClueCell(downSum = 9, acrossSum = 0)
                ),
                listOf(
                    KakuroCell.ClueCell(downSum = 0, acrossSum = 12),
                    KakuroCell.PlayCell(downRunId = 0, acrossRunId = 2),
                    KakuroCell.PlayCell(downRunId = 1, acrossRunId = 2)
                ),
                listOf(
                    KakuroCell.ClueCell(downSum = 0, acrossSum = 8),
                    KakuroCell.PlayCell(downRunId = 0, acrossRunId = 3),
                    KakuroCell.PlayCell(downRunId = 1, acrossRunId = 3)
                )
            ),
            runs = listOf(
                KakuroRun(id = 0, targetSum = 11, cells = listOf(Pair(1, 1), Pair(2, 1)), isVertical = true),
                KakuroRun(id = 1, targetSum = 9, cells = listOf(Pair(1, 2), Pair(2, 2)), isVertical = true),
                KakuroRun(id = 2, targetSum = 12, cells = listOf(Pair(1, 1), Pair(1, 2)), isVertical = false),
                KakuroRun(id = 3, targetSum = 8, cells = listOf(Pair(2, 1), Pair(2, 2)), isVertical = false)
            ),
            solution = mapOf(
                Pair(1, 1) to 3,
                Pair(1, 2) to 9,
                Pair(2, 1) to 8,
                Pair(2, 2) to 1
            )
        ),

        KakuroPuzzle(
            rows = 3,
            cols = 3,
            grid = listOf(
                listOf(
                    KakuroCell.ClueCell(downSum = 0, acrossSum = 0),
                    KakuroCell.ClueCell(downSum = 15, acrossSum = 0),
                    KakuroCell.ClueCell(downSum = 7, acrossSum = 0)
                ),
                listOf(
                    KakuroCell.ClueCell(downSum = 0, acrossSum = 13),
                    KakuroCell.PlayCell(downRunId = 0, acrossRunId = 2),
                    KakuroCell.PlayCell(downRunId = 1, acrossRunId = 2)
                ),
                listOf(
                    KakuroCell.ClueCell(downSum = 0, acrossSum = 9),
                    KakuroCell.PlayCell(downRunId = 0, acrossRunId = 3),
                    KakuroCell.PlayCell(downRunId = 1, acrossRunId = 3)
                )
            ),
            runs = listOf(
                KakuroRun(id = 0, targetSum = 15, cells = listOf(Pair(1, 1), Pair(2, 1)), isVertical = true),
                KakuroRun(id = 1, targetSum = 7, cells = listOf(Pair(1, 2), Pair(2, 2)), isVertical = true),
                KakuroRun(id = 2, targetSum = 13, cells = listOf(Pair(1, 1), Pair(1, 2)), isVertical = false),
                KakuroRun(id = 3, targetSum = 9, cells = listOf(Pair(2, 1), Pair(2, 2)), isVertical = false)
            ),
            solution = mapOf(
                Pair(1, 1) to 6,
                Pair(1, 2) to 7,
                Pair(2, 1) to 9,
                Pair(2, 2) to 2
            )
        ),

        KakuroPuzzle(
            rows = 3,
            cols = 3,
            grid = listOf(
                listOf(
                    KakuroCell.ClueCell(downSum = 0, acrossSum = 0),
                    KakuroCell.ClueCell(downSum = 8, acrossSum = 0),
                    KakuroCell.ClueCell(downSum = 13, acrossSum = 0)
                ),
                listOf(
                    KakuroCell.ClueCell(downSum = 0, acrossSum = 10),
                    KakuroCell.PlayCell(downRunId = 0, acrossRunId = 2),
                    KakuroCell.PlayCell(downRunId = 1, acrossRunId = 2)
                ),
                listOf(
                    KakuroCell.ClueCell(downSum = 0, acrossSum = 11),
                    KakuroCell.PlayCell(downRunId = 0, acrossRunId = 3),
                    KakuroCell.PlayCell(downRunId = 1, acrossRunId = 3)
                )
            ),
            runs = listOf(
                KakuroRun(id = 0, targetSum = 8, cells = listOf(Pair(1, 1), Pair(2, 1)), isVertical = true),
                KakuroRun(id = 1, targetSum = 13, cells = listOf(Pair(1, 2), Pair(2, 2)), isVertical = true),
                KakuroRun(id = 2, targetSum = 10, cells = listOf(Pair(1, 1), Pair(1, 2)), isVertical = false),
                KakuroRun(id = 3, targetSum = 11, cells = listOf(Pair(2, 1), Pair(2, 2)), isVertical = false)
            ),
            solution = mapOf(
                Pair(1, 1) to 2,
                Pair(1, 2) to 8,
                Pair(2, 1) to 6,
                Pair(2, 2) to 5
            )
        ),

        KakuroPuzzle(
            rows = 3,
            cols = 3,
            grid = listOf(
                listOf(
                    KakuroCell.ClueCell(downSum = 0, acrossSum = 0),
                    KakuroCell.ClueCell(downSum = 9, acrossSum = 0),
                    KakuroCell.ClueCell(downSum = 12, acrossSum = 0)
                ),
                listOf(
                    KakuroCell.ClueCell(downSum = 0, acrossSum = 14),
                    KakuroCell.PlayCell(downRunId = 0, acrossRunId = 2),
                    KakuroCell.PlayCell(downRunId = 1, acrossRunId = 2)
                ),
                listOf(
                    KakuroCell.ClueCell(downSum = 0, acrossSum = 7),
                    KakuroCell.PlayCell(downRunId = 0, acrossRunId = 3),
                    KakuroCell.PlayCell(downRunId = 1, acrossRunId = 3)
                )
            ),
            runs = listOf(
                KakuroRun(id = 0, targetSum = 9, cells = listOf(Pair(1, 1), Pair(2, 1)), isVertical = true),
                KakuroRun(id = 1, targetSum = 12, cells = listOf(Pair(1, 2), Pair(2, 2)), isVertical = true),
                KakuroRun(id = 2, targetSum = 14, cells = listOf(Pair(1, 1), Pair(1, 2)), isVertical = false),
                KakuroRun(id = 3, targetSum = 7, cells = listOf(Pair(2, 1), Pair(2, 2)), isVertical = false)
            ),
            solution = mapOf(
                Pair(1, 1) to 5,
                Pair(1, 2) to 9,
                Pair(2, 1) to 4,
                Pair(2, 2) to 3
            )
        ),

        KakuroPuzzle(
            rows = 3,
            cols = 3,
            grid = listOf(
                listOf(
                    KakuroCell.ClueCell(downSum = 0, acrossSum = 0),
                    KakuroCell.ClueCell(downSum = 7, acrossSum = 0),
                    KakuroCell.ClueCell(downSum = 11, acrossSum = 0)
                ),
                listOf(
                    KakuroCell.ClueCell(downSum = 0, acrossSum = 9),
                    KakuroCell.PlayCell(downRunId = 0, acrossRunId = 2),
                    KakuroCell.PlayCell(downRunId = 1, acrossRunId = 2)
                ),
                listOf(
                    KakuroCell.ClueCell(downSum = 0, acrossSum = 9),
                    KakuroCell.PlayCell(downRunId = 0, acrossRunId = 3),
                    KakuroCell.PlayCell(downRunId = 1, acrossRunId = 3)
                )
            ),
            runs = listOf(
                KakuroRun(id = 0, targetSum = 7, cells = listOf(Pair(1, 1), Pair(2, 1)), isVertical = true),
                KakuroRun(id = 1, targetSum = 11, cells = listOf(Pair(1, 2), Pair(2, 2)), isVertical = true),
                KakuroRun(id = 2, targetSum = 9, cells = listOf(Pair(1, 1), Pair(1, 2)), isVertical = false),
                KakuroRun(id = 3, targetSum = 9, cells = listOf(Pair(2, 1), Pair(2, 2)), isVertical = false)
            ),
            solution = mapOf(
                Pair(1, 1) to 1,
                Pair(1, 2) to 8,
                Pair(2, 1) to 6,
                Pair(2, 2) to 3
            )
        )
    )
}


