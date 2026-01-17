package com.example.neuronest.Sequence

data class SequencePuzzle(
    val level: Int,
    val sequence: List<Int>,
    val correctAnswer: Int,
    val sequenceType: String,
    val hint: String
)

