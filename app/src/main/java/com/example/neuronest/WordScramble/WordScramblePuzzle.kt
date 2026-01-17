package com.example.neuronest.WordScramble

// Simple data model for a Word Scramble puzzle level
data class WordScramblePuzzle(
    val level: Int,
    val correctWord: String,
    val scrambledWord: String,
    val category: String? = null
)

