package com.example.neuronest.WordScramble

// Predefined Word Scramble puzzles.
// For brevity, this file includes 25 sample puzzles; extend to 100 as required.
object WordScramblePuzzleData {
    val puzzles: List<WordScramblePuzzle> = listOf(
        WordScramblePuzzle(1, "CAT", "TAC", "Animals"),
        WordScramblePuzzle(2, "DOG", "GDO", "Animals"),
        WordScramblePuzzle(3, "APPLE", "PAPEL", "Food"),
        WordScramblePuzzle(4, "BREAD", "REABD", "Food"),
        WordScramblePuzzle(5, "CHAIR", "RCHAI", "Home"),
        WordScramblePuzzle(6, "DANCE", "CADNE", "Leisure"),
        WordScramblePuzzle(7, "EAGLE", "GLEAE", "Animals"),
        WordScramblePuzzle(8, "FRUIT", "RFTIU", "Food"),
        WordScramblePuzzle(9, "GRAPE", "PARGE", "Food"),
        WordScramblePuzzle(10, "HOUSE", "SEHOU", "Home"),
        WordScramblePuzzle(11, "ISLAND", "SLIDNA", "Places"),
        WordScramblePuzzle(12, "JACKET", "KJACET", "Clothing"),
        WordScramblePuzzle(13, "KITTEN", "TIKTEN", "Animals"),
        WordScramblePuzzle(14, "LAPTOP", "PTALOP", "Technology"),
        WordScramblePuzzle(15, "MONKEY", "NOKMEY", "Animals"),
        WordScramblePuzzle(16, "NUMBER", "MBRENU", "Concepts"),
        WordScramblePuzzle(17, "ORANGE", "GRAENO", "Food"),
        WordScramblePuzzle(18, "PLANET", "LPNETA", "Science"),
        WordScramblePuzzle(19, "RABBIT", "TBARBI", "Animals"),
        WordScramblePuzzle(20, "SMILE", "MILES", "Emotion"),
        WordScramblePuzzle(21, "TIGER", "GRITE", "Animals"),
        WordScramblePuzzle(22, "VIOLIN", "LOVINI", "Music"),
        WordScramblePuzzle(23, "WATER", "TERAW", "Nature"),
        WordScramblePuzzle(24, "YELLOW", "OWYELL", "Colors"),
        WordScramblePuzzle(25, "ZEBRA", "BRAZE", "Animals")
        // ... add up to 100 entries
    )

    fun getPuzzleForLevel(level: Int): WordScramblePuzzle {
        // Levels may exceed the size of puzzles list; wrap around or clamp as needed.
        val idx = (level - 1).coerceIn(0, puzzles.size - 1)
        return puzzles[idx]
    }
}

