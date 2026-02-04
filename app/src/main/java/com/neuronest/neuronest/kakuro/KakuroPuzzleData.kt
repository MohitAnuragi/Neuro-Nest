package com.neuronest.neuronest.kakuro

object KakuroPuzzleData {
    private val predefinedPuzzles = KakuroPuzzleDataPart1.getPuzzles()

    fun getPuzzleForLevel(level: Int): KakuroPuzzle {
        val index = ((level - 1) % predefinedPuzzles.size)
        return predefinedPuzzles[index]
    }
}

