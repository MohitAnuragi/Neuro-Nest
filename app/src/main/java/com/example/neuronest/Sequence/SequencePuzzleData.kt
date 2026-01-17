package com.example.neuronest.Sequence

// Predefined Sequence puzzles with 100 levels
object SequencePuzzleData {
    val puzzles: List<SequencePuzzle> = listOf(
        // Easy Arithmetic Sequences (Levels 1-20)
        SequencePuzzle(1, listOf(2, 4, 6, 8), 10, "Arithmetic", "Add 2 each time"),
        SequencePuzzle(2, listOf(5, 10, 15, 20), 25, "Arithmetic", "Add 5 each time"),
        SequencePuzzle(3, listOf(3, 6, 9, 12), 15, "Arithmetic", "Add 3 each time"),
        SequencePuzzle(4, listOf(10, 20, 30, 40), 50, "Arithmetic", "Add 10 each time"),
        SequencePuzzle(5, listOf(1, 3, 5, 7), 9, "Arithmetic", "Add 2 each time"),
        SequencePuzzle(6, listOf(4, 8, 12, 16), 20, "Arithmetic", "Add 4 each time"),
        SequencePuzzle(7, listOf(7, 14, 21, 28), 35, "Arithmetic", "Add 7 each time"),
        SequencePuzzle(8, listOf(6, 12, 18, 24), 30, "Arithmetic", "Add 6 each time"),
        SequencePuzzle(9, listOf(11, 22, 33, 44), 55, "Arithmetic", "Add 11 each time"),
        SequencePuzzle(10, listOf(8, 16, 24, 32), 40, "Arithmetic", "Add 8 each time"),
        SequencePuzzle(11, listOf(9, 18, 27, 36), 45, "Arithmetic", "Add 9 each time"),
        SequencePuzzle(12, listOf(12, 24, 36, 48), 60, "Arithmetic", "Add 12 each time"),
        SequencePuzzle(13, listOf(15, 30, 45, 60), 75, "Arithmetic", "Add 15 each time"),
        SequencePuzzle(14, listOf(13, 26, 39, 52), 65, "Arithmetic", "Add 13 each time"),
        SequencePuzzle(15, listOf(14, 28, 42, 56), 70, "Arithmetic", "Add 14 each time"),
        SequencePuzzle(16, listOf(16, 32, 48, 64), 80, "Arithmetic", "Add 16 each time"),
        SequencePuzzle(17, listOf(17, 34, 51, 68), 85, "Arithmetic", "Add 17 each time"),
        SequencePuzzle(18, listOf(19, 38, 57, 76), 95, "Arithmetic", "Add 19 each time"),
        SequencePuzzle(19, listOf(20, 40, 60, 80), 100, "Arithmetic", "Add 20 each time"),
        SequencePuzzle(20, listOf(25, 50, 75, 100), 125, "Arithmetic", "Add 25 each time"),

        // Geometric Sequences (Levels 21-35)
        SequencePuzzle(21, listOf(2, 4, 8, 16), 32, "Geometric", "Multiply by 2"),
        SequencePuzzle(22, listOf(3, 9, 27, 81), 243, "Geometric", "Multiply by 3"),
        SequencePuzzle(23, listOf(1, 2, 4, 8), 16, "Geometric", "Multiply by 2"),
        SequencePuzzle(24, listOf(5, 10, 20, 40), 80, "Geometric", "Multiply by 2"),
        SequencePuzzle(25, listOf(2, 6, 18, 54), 162, "Geometric", "Multiply by 3"),
        SequencePuzzle(26, listOf(4, 8, 16, 32), 64, "Geometric", "Multiply by 2"),
        SequencePuzzle(27, listOf(1, 3, 9, 27), 81, "Geometric", "Multiply by 3"),
        SequencePuzzle(28, listOf(2, 8, 32, 128), 512, "Geometric", "Multiply by 4"),
        SequencePuzzle(29, listOf(3, 6, 12, 24), 48, "Geometric", "Multiply by 2"),
        SequencePuzzle(30, listOf(5, 15, 45, 135), 405, "Geometric", "Multiply by 3"),
        SequencePuzzle(31, listOf(1, 4, 16, 64), 256, "Geometric", "Multiply by 4"),
        SequencePuzzle(32, listOf(2, 10, 50, 250), 1250, "Geometric", "Multiply by 5"),
        SequencePuzzle(33, listOf(4, 12, 36, 108), 324, "Geometric", "Multiply by 3"),
        SequencePuzzle(34, listOf(6, 12, 24, 48), 96, "Geometric", "Multiply by 2"),
        SequencePuzzle(35, listOf(7, 14, 28, 56), 112, "Geometric", "Multiply by 2"),

        // Square Sequences (Levels 36-45)
        SequencePuzzle(36, listOf(1, 4, 9, 16), 25, "Square", "Square numbers: n²"),
        SequencePuzzle(37, listOf(4, 9, 16, 25), 36, "Square", "Square numbers: n²"),
        SequencePuzzle(38, listOf(9, 16, 25, 36), 49, "Square", "Square numbers: n²"),
        SequencePuzzle(39, listOf(16, 25, 36, 49), 64, "Square", "Square numbers: n²"),
        SequencePuzzle(40, listOf(25, 36, 49, 64), 81, "Square", "Square numbers: n²"),
        SequencePuzzle(41, listOf(1, 4, 9, 16, 25), 36, "Square", "Square numbers: n²"),
        SequencePuzzle(42, listOf(4, 9, 16, 25, 36), 49, "Square", "Square numbers: n²"),
        SequencePuzzle(43, listOf(9, 16, 25, 36, 49), 64, "Square", "Square numbers: n²"),
        SequencePuzzle(44, listOf(16, 25, 36, 49, 64), 81, "Square", "Square numbers: n²"),
        SequencePuzzle(45, listOf(25, 36, 49, 64, 81), 100, "Square", "Square numbers: n²"),

        // Fibonacci Sequences (Levels 46-55)
        SequencePuzzle(46, listOf(1, 1, 2, 3), 5, "Fibonacci", "Sum of previous two"),
        SequencePuzzle(47, listOf(1, 1, 2, 3, 5), 8, "Fibonacci", "Sum of previous two"),
        SequencePuzzle(48, listOf(1, 2, 3, 5, 8), 13, "Fibonacci", "Sum of previous two"),
        SequencePuzzle(49, listOf(2, 3, 5, 8, 13), 21, "Fibonacci", "Sum of previous two"),
        SequencePuzzle(50, listOf(3, 5, 8, 13, 21), 34, "Fibonacci", "Sum of previous two"),
        SequencePuzzle(51, listOf(5, 8, 13, 21, 34), 55, "Fibonacci", "Sum of previous two"),
        SequencePuzzle(52, listOf(8, 13, 21, 34, 55), 89, "Fibonacci", "Sum of previous two"),
        SequencePuzzle(53, listOf(13, 21, 34, 55, 89), 144, "Fibonacci", "Sum of previous two"),
        SequencePuzzle(54, listOf(21, 34, 55, 89, 144), 233, "Fibonacci", "Sum of previous two"),
        SequencePuzzle(55, listOf(34, 55, 89, 144, 233), 377, "Fibonacci", "Sum of previous two"),

        // Cube Sequences (Levels 56-65)
        SequencePuzzle(56, listOf(1, 8, 27, 64), 125, "Cube", "Cube numbers: n³"),
        SequencePuzzle(57, listOf(8, 27, 64, 125), 216, "Cube", "Cube numbers: n³"),
        SequencePuzzle(58, listOf(27, 64, 125, 216), 343, "Cube", "Cube numbers: n³"),
        SequencePuzzle(59, listOf(64, 125, 216, 343), 512, "Cube", "Cube numbers: n³"),
        SequencePuzzle(60, listOf(125, 216, 343, 512), 729, "Cube", "Cube numbers: n³"),
        SequencePuzzle(61, listOf(1, 8, 27, 64, 125), 216, "Cube", "Cube numbers: n³"),
        SequencePuzzle(62, listOf(8, 27, 64, 125, 216), 343, "Cube", "Cube numbers: n³"),
        SequencePuzzle(63, listOf(27, 64, 125, 216, 343), 512, "Cube", "Cube numbers: n³"),
        SequencePuzzle(64, listOf(64, 125, 216, 343, 512), 729, "Cube", "Cube numbers: n³"),
        SequencePuzzle(65, listOf(125, 216, 343, 512, 729), 1000, "Cube", "Cube numbers: n³"),

        // Alternating Sequences (Levels 66-75)
        SequencePuzzle(66, listOf(1, 3, 2, 4, 3), 5, "Alternating", "Odd positions +1, even +1"),
        SequencePuzzle(67, listOf(2, 5, 4, 7, 6), 9, "Alternating", "Pattern: +3, -1"),
        SequencePuzzle(68, listOf(3, 6, 5, 8, 7), 10, "Alternating", "Pattern: +3, -1"),
        SequencePuzzle(69, listOf(1, 4, 3, 6, 5), 8, "Alternating", "Pattern: +3, -1"),
        SequencePuzzle(70, listOf(5, 10, 8, 13, 11), 16, "Alternating", "Pattern: +5, -2"),
        SequencePuzzle(71, listOf(2, 6, 4, 8, 6), 10, "Alternating", "Pattern: +4, -2"),
        SequencePuzzle(72, listOf(4, 8, 6, 10, 8), 12, "Alternating", "Pattern: +4, -2"),
        SequencePuzzle(73, listOf(3, 9, 6, 12, 9), 15, "Alternating", "Pattern: +6, -3"),
        SequencePuzzle(74, listOf(7, 14, 10, 17, 13), 20, "Alternating", "Pattern: +7, -4"),
        SequencePuzzle(75, listOf(10, 20, 15, 25, 20), 30, "Alternating", "Pattern: +10, -5"),

        // Increasing Difference Sequences (Levels 76-85)
        SequencePuzzle(76, listOf(1, 2, 4, 7), 11, "Increasing Difference", "Difference increases by 1"),
        SequencePuzzle(77, listOf(2, 3, 5, 8), 12, "Increasing Difference", "Difference increases by 1"),
        SequencePuzzle(78, listOf(1, 3, 6, 10), 15, "Increasing Difference", "Difference increases by 1"),
        SequencePuzzle(79, listOf(3, 5, 8, 12), 17, "Increasing Difference", "Difference increases by 1"),
        SequencePuzzle(80, listOf(5, 7, 10, 14), 19, "Increasing Difference", "Difference increases by 1"),
        SequencePuzzle(81, listOf(2, 4, 7, 11, 16), 22, "Increasing Difference", "Difference increases by 1"),
        SequencePuzzle(82, listOf(1, 3, 6, 10, 15), 21, "Increasing Difference", "Difference increases by 1"),
        SequencePuzzle(83, listOf(4, 6, 9, 13, 18), 24, "Increasing Difference", "Difference increases by 1"),
        SequencePuzzle(84, listOf(5, 8, 12, 17, 23), 30, "Increasing Difference", "Difference increases by 1"),
        SequencePuzzle(85, listOf(10, 13, 17, 22, 28), 35, "Increasing Difference", "Difference increases by 1"),

        // Mixed Complex Sequences (Levels 86-100)
        SequencePuzzle(86, listOf(2, 6, 12, 20), 30, "Triangular", "n(n+1)"),
        SequencePuzzle(87, listOf(6, 12, 20, 30), 42, "Triangular", "n(n+1)"),
        SequencePuzzle(88, listOf(1, 5, 14, 30), 55, "Pentagonal", "n(3n-1)/2"),
        SequencePuzzle(89, listOf(5, 14, 30, 55), 91, "Pentagonal", "n(3n-1)/2"),
        SequencePuzzle(90, listOf(3, 7, 15, 31), 63, "Power of 2", "2^n - 1"),
        SequencePuzzle(91, listOf(7, 15, 31, 63), 127, "Power of 2", "2^n - 1"),
        SequencePuzzle(92, listOf(1, 3, 7, 15), 31, "Power of 2", "2^n - 1"),
        SequencePuzzle(93, listOf(2, 5, 11, 23), 47, "Double + 1", "2n + 1"),
        SequencePuzzle(94, listOf(5, 11, 23, 47), 95, "Double + 1", "2n + 1"),
        SequencePuzzle(95, listOf(3, 8, 18, 38), 78, "Double + 2", "2n + 2"),
        SequencePuzzle(96, listOf(8, 18, 38, 78), 158, "Double + 2", "2n + 2"),
        SequencePuzzle(97, listOf(4, 10, 22, 46), 94, "Double + 2", "2n + 2"),
        SequencePuzzle(98, listOf(1, 4, 13, 40), 121, "Triple + 1", "3n + 1"),
        SequencePuzzle(99, listOf(4, 13, 40, 121), 364, "Triple + 1", "3n + 1"),
        SequencePuzzle(100, listOf(2, 7, 22, 67), 202, "Triple + 1", "3n + 1")
    )

    fun getPuzzleForLevel(level: Int): SequencePuzzle {
        val idx = (level - 1).coerceIn(0, puzzles.size - 1)
        return puzzles[idx]
    }
}

