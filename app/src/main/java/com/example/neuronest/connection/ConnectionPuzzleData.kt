package com.example.neuronest.connection
object ConnectionPuzzleData {
    val puzzles: List<ConnectionPuzzle> by lazy {
        ConnectionPuzzleDataPart1.getPuzzles() +
        ConnectionPuzzleDataPart2.getPuzzles() +
        ConnectionPuzzleDataPart3.getPuzzles() +
        ConnectionPuzzleDataPart4.getPuzzles() +
        ConnectionPuzzleDataPart5.getPuzzles()
    }
}
