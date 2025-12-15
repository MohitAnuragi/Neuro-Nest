package com.example.neuronest.logic

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.neuronest.profile.ProfileRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.json.JSONArray
import org.json.JSONObject
import java.io.OutputStreamWriter
import java.net.HttpURLConnection
import java.net.URL
import kotlin.random.Random
import javax.inject.Inject

@HiltViewModel
class LogicRiddlesViewModel @Inject constructor(
    private val profileRepository: ProfileRepository
) : ViewModel() {
    private var allRiddles = listOf(
        LogicRiddle(
            "If you have it, you want to share it. If you share it, you don't have it. What is it?",
            "SECRET",
            "Medium",
            listOf("SECRET", "MONEY", "KNOWLEDGE", "HAPPINESS"),
            "Classic Riddle"
        ),
        LogicRiddle(
            "The more you take away, the larger it becomes. What is it?",
            "HOLE",
            "Easy",
            listOf("HOLE", "PROBLEM",  "DEBT"),
            "Classic Riddle"
        ),
        LogicRiddle(
            "I am always hungry, I must always be fed. The finger I touch, will soon turn red. What am I?",
            "FIRE",
            "Medium",
            listOf("FIRE", "TIME",  "WATER"),
            "Classic Riddle"
        ),
        LogicRiddle(
            "What can travel around the world while staying in a corner?",
            "STAMP",
            "Hard",
            listOf("STAMP", "THOUGHT",  "SOUND"),
            "Classic Riddle"
        ),
        LogicRiddle(
            "What has a heart that doesn't beat?",
            "ARTICHOKE",
            "Hard",
            listOf("ARTICHOKE", "ROBOT", "COMPUTER"),
            "Classic Riddle"
        )
    )

    private val _uiState = MutableStateFlow(LogicRiddlesUiState())
    val uiState: StateFlow<LogicRiddlesUiState> = _uiState.asStateFlow()

    private var currentPuzzleTypes = setOf("All Types")

    // Profile tracking variables
    private var puzzleStartTime: Long = 0
    private var hintsUsed: Int = 0

    init {
        loadNewRiddle()
        startPuzzleTimer()
    }

    private fun startPuzzleTimer() {
        puzzleStartTime = System.currentTimeMillis()
        hintsUsed = 0
    }

    fun loadNewRiddle() {
        if (allRiddles.isEmpty()) {
            _uiState.update { it.copy(feedbackMessage = "No logic riddles available!") }
            return
        }
        val newRiddle = allRiddles.random(Random(System.currentTimeMillis()))
        _uiState.update {
            it.copy(
                currentRiddle = newRiddle,
                userAnswer = "",
                feedbackMessage = "Solve this logical puzzle!",
                isAnswerRevealed = false,
                isCorrect = false,
                showHint = false,
                totalAttempts = it.totalAttempts + 1,
                currentPuzzleType = newRiddle.puzzleType
            )
        }
        startPuzzleTimer()
    }

    fun onUserAnswerChange(answer: String) {
        if (!uiState.value.isCorrect) {
            _uiState.update { it.copy(userAnswer = answer) }
        }
    }

    fun checkAnswer() {
        val userAnswer = uiState.value.userAnswer.trim().uppercase()
        val correctAnswer = uiState.value.currentRiddle.answer.uppercase()
        val timeTaken = System.currentTimeMillis() - puzzleStartTime
        val isCorrect = userAnswer == correctAnswer

        // Update profile with the result
        viewModelScope.launch {
            profileRepository.updatePuzzleResult(
                puzzleType = "Logic Riddles",
                difficulty = uiState.value.currentRiddle.difficulty,
                wasSolved = isCorrect,
                timeTakenMs = timeTaken,
                hintsUsed = hintsUsed,
                scoreEarned = if (isCorrect) calculateScore(timeTaken, hintsUsed, uiState.value.currentRiddle.difficulty) else 0
            )
        }

        if (isCorrect) {
            val pointsEarned = calculateScore(timeTaken, hintsUsed, uiState.value.currentRiddle.difficulty)
            _uiState.update {
                it.copy(
                    feedbackMessage = "Correct! +$pointsEarned points!",
                    isCorrect = true,
                    score = it.score + pointsEarned
                )
            }
        } else {
            _uiState.update {
                it.copy(
                    feedbackMessage = "That's not it. Try again!",
                    isCorrect = false,
                )
            }
        }
    }

    fun revealAnswer() {
        val timeTaken = System.currentTimeMillis() - puzzleStartTime

        // Track revealed answer in profile (counts as not solved)
        viewModelScope.launch {
            profileRepository.updatePuzzleResult(
                puzzleType = "Logic Riddles",
                difficulty = uiState.value.currentRiddle.difficulty,
                wasSolved = false,
                timeTakenMs = timeTaken,
                hintsUsed = hintsUsed,
                scoreEarned = 0
            )
        }

        _uiState.update {
            it.copy(
                feedbackMessage = "The correct answer is: ${it.currentRiddle.answer}",
                isAnswerRevealed = true,
                isCorrect = true,
            )
        }
    }

    fun toggleHint() {
        hintsUsed++
        _uiState.update { it.copy(showHint = !it.showHint) }
    }

    fun getHint(): String {
        val answer = uiState.value.currentRiddle.answer
        return if (answer.length > 3) {
            val firstChar = answer.first()
            val lastChar = answer.last()
            "Starts with '$firstChar' and ends with '$lastChar' (${answer.length} letters)"
        } else {
            "The answer has ${answer.length} letters"
        }
    }

    fun setPuzzleTypes(types: Set<String>) {
        currentPuzzleTypes = types
        loadNewRiddle() // Reload with new filter
    }

    fun getAvailablePuzzleTypes(): List<String> {
        return listOf("All Types", "Formal Logic", "Informal Logic", "Syllogisms",
            "Mathematical", "Pattern Recognition", "Deductive", "Inductive", "Classic Riddle")
    }

    fun fetchRiddlesFromApi() {
        viewModelScope.launch(Dispatchers.IO) {
            _uiState.update { it.copy(isLoading = true, feedbackMessage = "Generating diverse logical puzzles...") }
            try {
                val apiKey = "AIzaSyCwt8CBrmiuNpv8lKXD3y_Au1r-5Zxzveo"
                val apiUrl = "https://generativelanguage.googleapis.com/v1beta/models/gemini-1.5-flash:generateContent?key=$apiKey"

                val payload = JSONObject().apply {
                    put("contents", JSONArray().apply {
                        put(JSONObject().apply {
                            put("parts", JSONArray().apply {
                                put(JSONObject().apply {
                                    put("text", """
                                    Generate 40 diverse logical puzzles including these types:
                                    - Formal Logic (syllogisms, deductive reasoning)
                                    - Informal Logic (everyday reasoning, paradoxes)
                                    - Mathematical Puzzles (equations, sequences)
                                    - Pattern Recognition (sequences, visual patterns)
                                    - Deductive Reasoning (puzzle solving)
                                    - Inductive Reasoning (generalizations)
                                    - Classic Logic Riddles
                                    
                    For each puzzle, provide 3 multiple choice options including the correct answer.
                    Also categorize it with a 'type' field.
                    Return ONLY a valid JSON array in this exact format:
                    [
                        {
                            "riddle": "All men are mortal. Socrates is a man. Therefore, what is Socrates?",
                            "answer": "MORTAL",
                            "type": "Formal Logic",
                            "options": ["MORTAL", "IMMORTAL","GREEK"]
                        },
                        {
                            "riddle": "What number comes next: 1, 4, 9, 16, ___?",
                            "answer": "25",
                            "type": "Mathematical",
                            "options": ["25", "36",  "64"]
                        },
                        {
                            "riddle": "If it rains, the ground gets wet. The ground is wet. Did it rain?",
                            "answer": "NOT NECESSARILY",
                            "type": "Deductive",
                            "options": ["NOT NECESSARILY", "YES", "NO"]
                        }
                    ]
                    No additional text or explanations.
                """.trimIndent())
                                })
                            })
                        })
                    })
                    put("generationConfig", JSONObject().apply {
                        put("temperature", 0.9) // Higher temperature for more diversity
                        put("maxOutputTokens", 3072) // More tokens for options
                        put("responseMimeType", "application/json")
                    })
                }

                val url = URL(apiUrl)
                val connection = url.openConnection() as HttpURLConnection
                connection.requestMethod = "POST"
                connection.setRequestProperty("Content-Type", "application/json")
                connection.doOutput = true
                connection.connectTimeout = 20000 // Longer timeout for complex generation
                connection.readTimeout = 20000

                OutputStreamWriter(connection.outputStream).use { writer ->
                    writer.write(payload.toString())
                    writer.flush()
                }

                val responseCode = connection.responseCode
                if (responseCode == HttpURLConnection.HTTP_OK) {
                    val responseText = connection.inputStream.bufferedReader().use { it.readText() }

                    // Parse the JSON response
                    val responseJson = JSONObject(responseText)
                    val candidates = responseJson.getJSONArray("candidates")
                    if (candidates.length() > 0) {
                        val content = candidates.getJSONObject(0).getJSONObject("content")
                        val parts = content.getJSONArray("parts")
                        if (parts.length() > 0) {
                            val textContent = parts.getJSONObject(0).getString("text")

                            // Clean the response
                            val cleanText = textContent
                                .replace("```json", "")
                                .replace("```", "")
                                .trim()

                            // Extract JSON from the response
                            val jsonStart = cleanText.indexOf('[')
                            val jsonEnd = cleanText.lastIndexOf(']') + 1

                            if (jsonStart >= 0 && jsonEnd > jsonStart) {
                                val jsonArrayStr = cleanText.substring(jsonStart, jsonEnd)
                                val newRiddlesJson = JSONArray(jsonArrayStr)
                                val newRiddles = mutableListOf<LogicRiddle>()

                                for (i in 0 until newRiddlesJson.length()) {
                                    val obj = newRiddlesJson.getJSONObject(i)
                                    val type = if (obj.has("type")) {
                                        obj.getString("type")
                                    } else {
                                        // Auto-categorize based on content
                                        categorizePuzzle(obj.getString("riddle"))
                                    }

                                    // Extract options if available, otherwise generate them
                                    val optionsList = if (obj.has("options")) {
                                        val optionsArray = obj.getJSONArray("options")
                                        val options = mutableListOf<String>()
                                        for (j in 0 until optionsArray.length()) {
                                            options.add(optionsArray.getString(j))
                                        }
                                        options
                                    } else {
                                        // Generate default options if not provided
                                        generateOptions(obj.getString("answer"))
                                    }

                                    newRiddles.add(
                                        LogicRiddle(
                                            obj.getString("riddle"),
                                            obj.getString("answer").uppercase(),
                                            determineDifficulty(obj.getString("riddle")),
                                            optionsList,
                                            type
                                        )
                                    )
                                }

                                allRiddles = newRiddles
                                _uiState.update {
                                    it.copy(
                                        isLoading = false,
                                        feedbackMessage = "✓ ${newRiddles.size} diverse logic puzzles loaded!",
                                        isCorrect = false,
                                        userAnswer = ""
                                    )
                                }
                                loadNewRiddle()
                                return@launch
                            }
                        }
                    }
                    _uiState.update {
                        it.copy(
                            isLoading = false,
                            feedbackMessage = "Unexpected API response format. Using default puzzles."
                        )
                    }
                } else {
                    _uiState.update {
                        it.copy(
                            isLoading = false,
                            feedbackMessage = "API error: $responseCode. Using default puzzles."
                        )
                    }
                }
            } catch (e: Exception) {
                _uiState.update {
                    it.copy(
                        isLoading = false,
                        feedbackMessage = "Error: ${e.message ?: "Unknown error"}. Using default puzzles."
                    )
                }
                println("API Error: ${e.message}")
                e.printStackTrace()
            }
        }
    }

    // Helper function to generate options if not provided by API
    private fun generateOptions(correctAnswer: String): List<String> {
        val options = mutableListOf(correctAnswer.uppercase())

        // Add some common logical puzzle distractors
        val commonDistractors = listOf("TRUE", "FALSE", "YES", "NO", "MAYBE", "ALWAYS", "NEVER", "SOMETIMES")

        // Add 3 more options
        repeat(3) {
            val distractor = commonDistractors.random()
            if (!options.contains(distractor)) {
                options.add(distractor)
            } else {
                // If duplicate, add a numbered option
                options.add("OPTION_${it + 1}")
            }
        }

        return options.shuffled()
    }

    // Helper function to auto-categorize puzzles
    private fun categorizePuzzle(riddle: String): String {
        val riddleLower = riddle.lowercase()
        return when {
            riddleLower.contains(Regex("all|every|no|some|only")) -> "Formal Logic"
            riddleLower.contains(Regex("if|then|therefore|thus|hence")) -> "Deductive"
            riddleLower.contains(Regex("sequence|pattern|next|series")) -> "Pattern Recognition"
            riddle.contains(Regex("\\d")) -> "Mathematical"
            riddleLower.contains(Regex("probably|likely|usually|often")) -> "Inductive"
            else -> "Informal Logic"
        }
    }

    // Helper function to determine difficulty
    private fun determineDifficulty(riddle: String): String {
        val wordCount = riddle.split(" ").size
        return when {
            wordCount < 10 -> "Easy"
            wordCount < 20 -> "Medium"
            else -> "Hard"
        }
    }

    private fun calculateScore(timeTaken: Long, hintsUsed: Int, difficulty: String): Long {
        val baseScore = when (difficulty) {
            "Easy" -> 80
            "Medium" -> 100
            "Hard" -> 120
            else -> 100
        }
        val timeBonus = maxOf(0, (45000 - timeTaken) / 150) // 45s max time
        val hintPenalty = hintsUsed * 25
        return baseScore + timeBonus - hintPenalty
    }
}