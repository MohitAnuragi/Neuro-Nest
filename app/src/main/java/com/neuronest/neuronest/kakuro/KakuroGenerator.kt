package com.neuronest.neuronest.kakuro

import kotlin.random.Random

class KakuroGenerator {

    fun generateValidPuzzle(whiteCellSize: Int, level: Int): KakuroPuzzle? {
        val random = Random(level)

        var attempts = 100
        while (attempts > 0) {
            val puzzle = when (whiteCellSize) {
                2 -> generate2x2Puzzle(random)
                3 -> generate3x3Puzzle(random)
                4 -> generate4x4Puzzle(random)
                5 -> generate5x5Puzzle(random)
                6 -> generate6x6Puzzle(random)
                else -> generate2x2Puzzle(random)
            }

            if (puzzle != null && isValidKakuroPuzzle(puzzle)) {
                return puzzle
            }
            attempts--
        }

        return null
    }

    fun generateFallbackPuzzle(whiteCellSize: Int, level: Int): KakuroPuzzle {
        return when (whiteCellSize) {
            2 -> createFallback2x2(level)
            3 -> createFallback3x3(level)
            4 -> createFallback4x4(level)
            5 -> createFallback5x5(level)
            6 -> createFallback6x6(level)
            else -> createFallback2x2(level)
        }
    }

    private fun isValidKakuroPuzzle(puzzle: KakuroPuzzle): Boolean {
        for (run in puzzle.runs) {
            val values = mutableListOf<Int>()
            var sum = 0

            for ((row, col) in run.cells) {
                val value = puzzle.solution[Pair(row, col)] ?: return false

                if (value < 1 || value > 9) return false
                if (values.contains(value)) return false

                values.add(value)
                sum += value
            }

            if (sum != run.targetSum) return false
        }

        for (row in puzzle.grid.indices) {
            for (col in puzzle.grid[row].indices) {
                if (puzzle.grid[row][col] is KakuroCell.PlayCell) {
                    if (!puzzle.solution.containsKey(Pair(row, col))) {
                        return false
                    }

                    val cell = puzzle.grid[row][col] as KakuroCell.PlayCell
                    val hasHorizontalRun = puzzle.runs.any {
                        it.id == cell.acrossRunId && !it.isVertical
                    }
                    val hasVerticalRun = puzzle.runs.any {
                        it.id == cell.downRunId && it.isVertical
                    }

                    if (!hasHorizontalRun || !hasVerticalRun) {
                        return false
                    }
                }
            }
        }

        return true
    }

    private fun generate2x2Puzzle(random: Random): KakuroPuzzle? {
        val rows = 3
        val cols = 3

        val validCombos = listOf(
            listOf(1, 2) to 3,
            listOf(1, 3) to 4,
            listOf(2, 3) to 5,
            listOf(1, 4) to 5,
            listOf(2, 4) to 6,
            listOf(3, 4) to 7,
            listOf(1, 5) to 6,
            listOf(2, 5) to 7,
            listOf(3, 5) to 8,
            listOf(4, 5) to 9,
            listOf(1, 6) to 7,
            listOf(2, 6) to 8,
            listOf(3, 6) to 9,
            listOf(1, 7) to 8,
            listOf(2, 7) to 9,
            listOf(1, 8) to 9
        )

        var attempts = 50
        while (attempts > 0) {
            val combo1 = validCombos.random(random)
            val combo2 = validCombos.random(random)

            val solution = mutableMapOf<Pair<Int, Int>, Int>()
            solution[Pair(1, 1)] = combo1.first[0]
            solution[Pair(1, 2)] = combo1.first[1]
            solution[Pair(2, 1)] = combo2.first[0]
            solution[Pair(2, 2)] = combo2.first[1]

            val col1Values = listOf(solution[Pair(1, 1)]!!, solution[Pair(2, 1)]!!)
            val col2Values = listOf(solution[Pair(1, 2)]!!, solution[Pair(2, 2)]!!)

            if (col1Values.distinct().size == 2 && col2Values.distinct().size == 2) {
                val downSum1 = col1Values.sum()
                val downSum2 = col2Values.sum()
                val acrossSum1 = solution[Pair(1, 1)]!! + solution[Pair(1, 2)]!!
                val acrossSum2 = solution[Pair(2, 1)]!! + solution[Pair(2, 2)]!!

                val grid = listOf(
                    listOf(
                        KakuroCell.ClueCell(downSum = 0, acrossSum = 0),
                        KakuroCell.ClueCell(downSum = downSum1, acrossSum = 0),
                        KakuroCell.ClueCell(downSum = downSum2, acrossSum = 0)
                    ),
                    listOf(
                        KakuroCell.ClueCell(downSum = 0, acrossSum = acrossSum1),
                        KakuroCell.PlayCell(value = 0, downRunId = 0, acrossRunId = 2),
                        KakuroCell.PlayCell(value = 0, downRunId = 1, acrossRunId = 2)
                    ),
                    listOf(
                        KakuroCell.ClueCell(downSum = 0, acrossSum = acrossSum2),
                        KakuroCell.PlayCell(value = 0, downRunId = 0, acrossRunId = 3),
                        KakuroCell.PlayCell(value = 0, downRunId = 1, acrossRunId = 3)
                    )
                )

                val runs = listOf(
                    KakuroRun(0, downSum1, listOf(Pair(1, 1), Pair(2, 1)), true),
                    KakuroRun(1, downSum2, listOf(Pair(1, 2), Pair(2, 2)), true),
                    KakuroRun(2, acrossSum1, listOf(Pair(1, 1), Pair(1, 2)), false),
                    KakuroRun(3, acrossSum2, listOf(Pair(2, 1), Pair(2, 2)), false)
                )

                return KakuroPuzzle(rows, cols, grid, runs, solution)
            }

            attempts--
        }

        return null
    }

    private fun generate3x3Puzzle(random: Random): KakuroPuzzle? {
        val rows = 4
        val cols = 4

        val solution = mutableMapOf<Pair<Int, Int>, Int>()

        var attempts = 200
        while (attempts > 0) {
            solution.clear()

            val row1 = generateUniqueValues(3, random)
            val row2 = generateUniqueValues(3, random)
            val row3 = generateUniqueValues(3, random)

            solution[Pair(1, 1)] = row1[0]
            solution[Pair(1, 2)] = row1[1]
            solution[Pair(1, 3)] = row1[2]
            solution[Pair(2, 1)] = row2[0]
            solution[Pair(2, 2)] = row2[1]
            solution[Pair(2, 3)] = row2[2]
            solution[Pair(3, 1)] = row3[0]
            solution[Pair(3, 2)] = row3[1]
            solution[Pair(3, 3)] = row3[2]

            val col1 = listOf(solution[Pair(1, 1)]!!, solution[Pair(2, 1)]!!, solution[Pair(3, 1)]!!)
            val col2 = listOf(solution[Pair(1, 2)]!!, solution[Pair(2, 2)]!!, solution[Pair(3, 2)]!!)
            val col3 = listOf(solution[Pair(1, 3)]!!, solution[Pair(2, 3)]!!, solution[Pair(3, 3)]!!)

            if (col1.distinct().size == 3 && col2.distinct().size == 3 && col3.distinct().size == 3) {
                val downSum1 = col1.sum()
                val downSum2 = col2.sum()
                val downSum3 = col3.sum()
                val acrossSum1 = row1.sum()
                val acrossSum2 = row2.sum()
                val acrossSum3 = row3.sum()

                val grid = listOf(
                    listOf(
                        KakuroCell.ClueCell(downSum = 0, acrossSum = 0),
                        KakuroCell.ClueCell(downSum = downSum1, acrossSum = 0),
                        KakuroCell.ClueCell(downSum = downSum2, acrossSum = 0),
                        KakuroCell.ClueCell(downSum = downSum3, acrossSum = 0)
                    ),
                    listOf(
                        KakuroCell.ClueCell(downSum = 0, acrossSum = acrossSum1),
                        KakuroCell.PlayCell(value = 0, downRunId = 0, acrossRunId = 0),
                        KakuroCell.PlayCell(value = 0, downRunId = 1, acrossRunId = 0),
                        KakuroCell.PlayCell(value = 0, downRunId = 2, acrossRunId = 0)
                    ),
                    listOf(
                        KakuroCell.ClueCell(downSum = 0, acrossSum = acrossSum2),
                        KakuroCell.PlayCell(value = 0, downRunId = 0, acrossRunId = 1),
                        KakuroCell.PlayCell(value = 0, downRunId = 1, acrossRunId = 1),
                        KakuroCell.PlayCell(value = 0, downRunId = 2, acrossRunId = 1)
                    ),
                    listOf(
                        KakuroCell.ClueCell(downSum = 0, acrossSum = acrossSum3),
                        KakuroCell.PlayCell(value = 0, downRunId = 0, acrossRunId = 2),
                        KakuroCell.PlayCell(value = 0, downRunId = 1, acrossRunId = 2),
                        KakuroCell.PlayCell(value = 0, downRunId = 2, acrossRunId = 2)
                    )
                )

                val runs = listOf(
                    KakuroRun(0, downSum1, listOf(Pair(1, 1), Pair(2, 1), Pair(3, 1)), true),
                    KakuroRun(1, downSum2, listOf(Pair(1, 2), Pair(2, 2), Pair(3, 2)), true),
                    KakuroRun(2, downSum3, listOf(Pair(1, 3), Pair(2, 3), Pair(3, 3)), true),
                    KakuroRun(3, acrossSum1, listOf(Pair(1, 1), Pair(1, 2), Pair(1, 3)), false),
                    KakuroRun(4, acrossSum2, listOf(Pair(2, 1), Pair(2, 2), Pair(2, 3)), false),
                    KakuroRun(5, acrossSum3, listOf(Pair(3, 1), Pair(3, 2), Pair(3, 3)), false)
                )

                return KakuroPuzzle(rows, cols, grid, runs, solution)
            }

            attempts--
        }

        return null
    }

    private fun generate4x4Puzzle(random: Random): KakuroPuzzle? {
        val rows = 5
        val cols = 5

        val solution = mutableMapOf<Pair<Int, Int>, Int>()

        var attempts = 200
        while (attempts > 0) {
            solution.clear()

            for (r in 1..4) {
                val rowValues = generateUniqueValues(4, random)
                for (c in 1..4) {
                    solution[Pair(r, c)] = rowValues[c - 1]
                }
            }

            var valid = true
            for (c in 1..4) {
                val colValues = (1..4).map { r -> solution[Pair(r, c)]!! }
                if (colValues.distinct().size != 4) {
                    valid = false
                    break
                }
            }

            if (valid) {
                val grid = MutableList(rows) { MutableList<KakuroCell>(cols) { KakuroCell.ClueCell() } }

                grid[0][0] = KakuroCell.ClueCell()
                for (c in 1..4) {
                    val sum = (1..4).sumOf { r -> solution[Pair(r, c)]!! }
                    grid[0][c] = KakuroCell.ClueCell(downSum = sum)
                }

                for (r in 1..4) {
                    val sum = (1..4).sumOf { c -> solution[Pair(r, c)]!! }
                    grid[r][0] = KakuroCell.ClueCell(acrossSum = sum)

                    for (c in 1..4) {
                        grid[r][c] = KakuroCell.PlayCell(downRunId = c - 1, acrossRunId = r + 3)
                    }
                }

                val runs = mutableListOf<KakuroRun>()

                for (c in 1..4) {
                    val sum = (1..4).sumOf { r -> solution[Pair(r, c)]!! }
                    runs.add(KakuroRun(c - 1, sum, (1..4).map { r -> Pair(r, c) }, true))
                }

                for (r in 1..4) {
                    val sum = (1..4).sumOf { c -> solution[Pair(r, c)]!! }
                    runs.add(KakuroRun(r + 3, sum, (1..4).map { c -> Pair(r, c) }, false))
                }

                return KakuroPuzzle(rows, cols, grid.map { it.toList() }, runs, solution)
            }
            attempts--
        }

        return null
    }

    private fun generate5x5Puzzle(random: Random): KakuroPuzzle? {
        return generateNxNPuzzle(5, random)
    }

    private fun generate6x6Puzzle(random: Random): KakuroPuzzle? {
        return generateNxNPuzzle(6, random)
    }

    private fun generateNxNPuzzle(n: Int, random: Random): KakuroPuzzle? {
        val rows = n + 1
        val cols = n + 1

        val solution = mutableMapOf<Pair<Int, Int>, Int>()

        var attempts = 200
        while (attempts > 0) {
            solution.clear()

            for (r in 1..n) {
                val rowValues = generateUniqueValuesLarge(n, random)
                for (c in 1..n) {
                    solution[Pair(r, c)] = rowValues[c - 1]
                }
            }

            var valid = true
            for (c in 1..n) {
                val colValues = (1..n).map { r -> solution[Pair(r, c)]!! }
                if (colValues.distinct().size != n) {
                    valid = false
                    break
                }
            }

            if (valid) {
                val grid = MutableList(rows) { MutableList<KakuroCell>(cols) { KakuroCell.ClueCell() } }

                grid[0][0] = KakuroCell.ClueCell()
                for (c in 1..n) {
                    val sum = (1..n).sumOf { r -> solution[Pair(r, c)]!! }
                    grid[0][c] = KakuroCell.ClueCell(downSum = sum)
                }

                for (r in 1..n) {
                    val sum = (1..n).sumOf { c -> solution[Pair(r, c)]!! }
                    grid[r][0] = KakuroCell.ClueCell(acrossSum = sum)

                    for (c in 1..n) {
                        grid[r][c] = KakuroCell.PlayCell(downRunId = c - 1, acrossRunId = r + n - 1)
                    }
                }

                val runs = mutableListOf<KakuroRun>()

                for (c in 1..n) {
                    val sum = (1..n).sumOf { r -> solution[Pair(r, c)]!! }
                    runs.add(KakuroRun(c - 1, sum, (1..n).map { r -> Pair(r, c) }, true))
                }

                for (r in 1..n) {
                    val sum = (1..n).sumOf { c -> solution[Pair(r, c)]!! }
                    runs.add(KakuroRun(r + n - 1, sum, (1..n).map { c -> Pair(r, c) }, false))
                }

                return KakuroPuzzle(rows, cols, grid.map { it.toList() }, runs, solution)
            }
            attempts--
        }

        return null
    }

    private fun generateUniqueValues(count: Int, random: Random): List<Int> {
        return (1..9).shuffled(random).take(count)
    }

    private fun generateUniqueValuesLarge(count: Int, random: Random): List<Int> {
        return (1..9).shuffled(random).take(count.coerceAtMost(9))
    }

    private fun createFallback2x2(level: Int): KakuroPuzzle {
        val rows = 3
        val cols = 3

        val combos = listOf(
            listOf(1, 2, 3, 4),
            listOf(1, 3, 2, 5),
            listOf(2, 3, 4, 1),
            listOf(1, 4, 5, 2),
            listOf(2, 4, 3, 5),
            listOf(3, 4, 5, 1),
            listOf(1, 5, 6, 2),
            listOf(2, 5, 4, 6),
            listOf(3, 5, 7, 1),
            listOf(4, 5, 8, 2)
        )

        val combo = combos[level % combos.size]
        val solution = mapOf(
            Pair(1, 1) to combo[0],
            Pair(1, 2) to combo[1],
            Pair(2, 1) to combo[2],
            Pair(2, 2) to combo[3]
        )

        val downSum1 = solution[Pair(1, 1)]!! + solution[Pair(2, 1)]!!
        val downSum2 = solution[Pair(1, 2)]!! + solution[Pair(2, 2)]!!
        val acrossSum1 = solution[Pair(1, 1)]!! + solution[Pair(1, 2)]!!
        val acrossSum2 = solution[Pair(2, 1)]!! + solution[Pair(2, 2)]!!

        val grid = listOf(
            listOf(
                KakuroCell.ClueCell(),
                KakuroCell.ClueCell(downSum = downSum1),
                KakuroCell.ClueCell(downSum = downSum2)
            ),
            listOf(
                KakuroCell.ClueCell(acrossSum = acrossSum1),
                KakuroCell.PlayCell(downRunId = 0, acrossRunId = 2),
                KakuroCell.PlayCell(downRunId = 1, acrossRunId = 2)
            ),
            listOf(
                KakuroCell.ClueCell(acrossSum = acrossSum2),
                KakuroCell.PlayCell(downRunId = 0, acrossRunId = 3),
                KakuroCell.PlayCell(downRunId = 1, acrossRunId = 3)
            )
        )

        val runs = listOf(
            KakuroRun(0, downSum1, listOf(Pair(1, 1), Pair(2, 1)), true),
            KakuroRun(1, downSum2, listOf(Pair(1, 2), Pair(2, 2)), true),
            KakuroRun(2, acrossSum1, listOf(Pair(1, 1), Pair(1, 2)), false),
            KakuroRun(3, acrossSum2, listOf(Pair(2, 1), Pair(2, 2)), false)
        )

        return KakuroPuzzle(rows, cols, grid, runs, solution)
    }

    private fun createFallback3x3(level: Int): KakuroPuzzle {
        val rows = 4
        val cols = 4

        val templates = listOf(
            listOf(1, 2, 3, 4, 5, 6, 7, 8, 9),
            listOf(2, 3, 4, 5, 6, 7, 8, 9, 1),
            listOf(3, 4, 5, 6, 7, 8, 9, 1, 2),
            listOf(4, 5, 6, 7, 8, 9, 1, 2, 3),
            listOf(5, 6, 7, 8, 9, 1, 2, 3, 4)
        )

        val template = templates[level % templates.size]
        val solution = mapOf(
            Pair(1, 1) to template[0], Pair(1, 2) to template[1], Pair(1, 3) to template[2],
            Pair(2, 1) to template[3], Pair(2, 2) to template[4], Pair(2, 3) to template[5],
            Pair(3, 1) to template[6], Pair(3, 2) to template[7], Pair(3, 3) to template[8]
        )

        val downSum1 = solution[Pair(1, 1)]!! + solution[Pair(2, 1)]!! + solution[Pair(3, 1)]!!
        val downSum2 = solution[Pair(1, 2)]!! + solution[Pair(2, 2)]!! + solution[Pair(3, 2)]!!
        val downSum3 = solution[Pair(1, 3)]!! + solution[Pair(2, 3)]!! + solution[Pair(3, 3)]!!
        val acrossSum1 = solution[Pair(1, 1)]!! + solution[Pair(1, 2)]!! + solution[Pair(1, 3)]!!
        val acrossSum2 = solution[Pair(2, 1)]!! + solution[Pair(2, 2)]!! + solution[Pair(2, 3)]!!
        val acrossSum3 = solution[Pair(3, 1)]!! + solution[Pair(3, 2)]!! + solution[Pair(3, 3)]!!

        val grid = listOf(
            listOf(
                KakuroCell.ClueCell(),
                KakuroCell.ClueCell(downSum = downSum1),
                KakuroCell.ClueCell(downSum = downSum2),
                KakuroCell.ClueCell(downSum = downSum3)
            ),
            listOf(
                KakuroCell.ClueCell(acrossSum = acrossSum1),
                KakuroCell.PlayCell(downRunId = 0, acrossRunId = 3),
                KakuroCell.PlayCell(downRunId = 1, acrossRunId = 3),
                KakuroCell.PlayCell(downRunId = 2, acrossRunId = 3)
            ),
            listOf(
                KakuroCell.ClueCell(acrossSum = acrossSum2),
                KakuroCell.PlayCell(downRunId = 0, acrossRunId = 4),
                KakuroCell.PlayCell(downRunId = 1, acrossRunId = 4),
                KakuroCell.PlayCell(downRunId = 2, acrossRunId = 4)
            ),
            listOf(
                KakuroCell.ClueCell(acrossSum = acrossSum3),
                KakuroCell.PlayCell(downRunId = 0, acrossRunId = 5),
                KakuroCell.PlayCell(downRunId = 1, acrossRunId = 5),
                KakuroCell.PlayCell(downRunId = 2, acrossRunId = 5)
            )
        )

        val runs = listOf(
            KakuroRun(0, downSum1, listOf(Pair(1, 1), Pair(2, 1), Pair(3, 1)), true),
            KakuroRun(1, downSum2, listOf(Pair(1, 2), Pair(2, 2), Pair(3, 2)), true),
            KakuroRun(2, downSum3, listOf(Pair(1, 3), Pair(2, 3), Pair(3, 3)), true),
            KakuroRun(3, acrossSum1, listOf(Pair(1, 1), Pair(1, 2), Pair(1, 3)), false),
            KakuroRun(4, acrossSum2, listOf(Pair(2, 1), Pair(2, 2), Pair(2, 3)), false),
            KakuroRun(5, acrossSum3, listOf(Pair(3, 1), Pair(3, 2), Pair(3, 3)), false)
        )

        return KakuroPuzzle(rows, cols, grid, runs, solution)
    }

    private fun createFallback4x4(level: Int): KakuroPuzzle {
        val rows = 5
        val cols = 5

        val offset = level % 6
        val solution = mutableMapOf<Pair<Int, Int>, Int>()
        for (r in 1..4) {
            for (c in 1..4) {
                solution[Pair(r, c)] = ((r + c + offset - 2) % 9) + 1
            }
        }

        val grid = MutableList(rows) { MutableList<KakuroCell>(cols) { KakuroCell.ClueCell() } }
        grid[0][0] = KakuroCell.ClueCell()

        for (c in 1..4) {
            val sum = (1..4).sumOf { r -> solution[Pair(r, c)]!! }
            grid[0][c] = KakuroCell.ClueCell(downSum = sum)
        }

        for (r in 1..4) {
            val sum = (1..4).sumOf { c -> solution[Pair(r, c)]!! }
            grid[r][0] = KakuroCell.ClueCell(acrossSum = sum)

            for (c in 1..4) {
                grid[r][c] = KakuroCell.PlayCell(downRunId = c - 1, acrossRunId = r + 3)
            }
        }

        val runs = listOf(
            KakuroRun(0, (1..4).sumOf { r -> solution[Pair(r, 1)]!! }, (1..4).map { r -> Pair(r, 1) }, true),
            KakuroRun(1, (1..4).sumOf { r -> solution[Pair(r, 2)]!! }, (1..4).map { r -> Pair(r, 2) }, true),
            KakuroRun(2, (1..4).sumOf { r -> solution[Pair(r, 3)]!! }, (1..4).map { r -> Pair(r, 3) }, true),
            KakuroRun(3, (1..4).sumOf { r -> solution[Pair(r, 4)]!! }, (1..4).map { r -> Pair(r, 4) }, true),
            KakuroRun(4, (1..4).sumOf { c -> solution[Pair(1, c)]!! }, (1..4).map { c -> Pair(1, c) }, false),
            KakuroRun(5, (1..4).sumOf { c -> solution[Pair(2, c)]!! }, (1..4).map { c -> Pair(2, c) }, false),
            KakuroRun(6, (1..4).sumOf { c -> solution[Pair(3, c)]!! }, (1..4).map { c -> Pair(3, c) }, false),
            KakuroRun(7, (1..4).sumOf { c -> solution[Pair(4, c)]!! }, (1..4).map { c -> Pair(4, c) }, false)
        )

        return KakuroPuzzle(rows, cols, grid.map { it.toList() }, runs, solution)
    }

    private fun createFallback5x5(level: Int): KakuroPuzzle {
        return generateFallbackNxN(5, level)
    }

    private fun createFallback6x6(level: Int): KakuroPuzzle {
        return generateFallbackNxN(6, level)
    }

    private fun generateFallbackNxN(n: Int, level: Int): KakuroPuzzle {
        val rows = n + 1
        val cols = n + 1
        val solution = mutableMapOf<Pair<Int, Int>, Int>()

        val offset = level % 6

        for (r in 1..n) {
            for (c in 1..n) {
                solution[Pair(r, c)] = ((r + c + offset - 2) % 9) + 1
            }
        }

        val grid = MutableList(rows) { MutableList<KakuroCell>(cols) { KakuroCell.ClueCell() } }

        grid[0][0] = KakuroCell.ClueCell()
        for (c in 1..n) {
            val sum = (1..n).sumOf { r -> solution[Pair(r, c)]!! }
            grid[0][c] = KakuroCell.ClueCell(downSum = sum)
        }

        for (r in 1..n) {
            val sum = (1..n).sumOf { c -> solution[Pair(r, c)]!! }
            grid[r][0] = KakuroCell.ClueCell(acrossSum = sum)

            for (c in 1..n) {
                grid[r][c] = KakuroCell.PlayCell(downRunId = c - 1, acrossRunId = r + n - 1)
            }
        }

        val runs = mutableListOf<KakuroRun>()

        for (c in 1..n) {
            val sum = (1..n).sumOf { r -> solution[Pair(r, c)]!! }
            runs.add(KakuroRun(c - 1, sum, (1..n).map { r -> Pair(r, c) }, true))
        }

        for (r in 1..n) {
            val sum = (1..n).sumOf { c -> solution[Pair(r, c)]!! }
            runs.add(KakuroRun(r + n - 1, sum, (1..n).map { c -> Pair(r, c) }, false))
        }

        return KakuroPuzzle(rows, cols, grid.map { it.toList() }, runs, solution)
    }
}

