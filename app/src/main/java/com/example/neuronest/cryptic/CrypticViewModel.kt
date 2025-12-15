package com.example.neuronest.cryptic

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
class RiddlesViewModel @Inject constructor(
    private val profileRepository: ProfileRepository
) : ViewModel() {

    private var allRiddles = listOf(
        Riddle(
            "I have cities, but no houses. I have mountains, but no trees. I have water, but no fish. What am I?",
            "A MAP",
            options = listOf("A MAP", "A GLOBE", "A DREAM")
        ),
        Riddle(
            "What has keys but can't open locks?",
            "PIANO",
            options = listOf("PIANO", "DOOR", "COMPUTER")
        ),
        Riddle(
            "I speak without a mouth and hear without ears. I have no body, but I come alive with wind. What am I?",
            "ECHO",
            options = listOf("ECHO", "WHISPER", "SHADOW")
        ),
        Riddle(
            "The more you take, the more you leave behind. What am I?",
            "FOOTSTEPS",
            options = listOf("FOOTSTEPS", "PHOTOGRAPHS", "IMPRESSIONS")
        ),
        Riddle(
            "What has a head, a tail, is brown, and has no legs?",
            "PENNY",
            options = listOf("PENNY", "SNAKE","COIN")
        )
    )

    private val _uiState = MutableStateFlow(RiddlesUiState())
    val uiState: StateFlow<RiddlesUiState> = _uiState.asStateFlow()

    // Profile tracking variables
    private var puzzleStartTime: Long = 0
    private var hintsUsed: Int = 0
    private val currentDifficulty: String = "Hard"
    var totalPuzzlesSolved: Int = 0

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
            _uiState.update { it.copy(feedbackMessage = "No riddles available!") }
            return
        }
        val newRiddle = allRiddles.random(Random(System.currentTimeMillis()))
        _uiState.update {
            it.copy(
                currentRiddle = newRiddle,
                userAnswer = "",
                feedbackMessage = "Type your answer or select an option!",
                isAnswerRevealed = false,
                isCorrect = false,
                showHint = false,
                totalAttempts = it.totalAttempts + 1,
                totalPuzzlesSolved = totalPuzzlesSolved+1

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
                puzzleType = "Cryptic Riddles",
                difficulty = currentDifficulty,
                wasSolved = isCorrect,
                timeTakenMs = timeTaken,
                hintsUsed = hintsUsed,
                scoreEarned = if (isCorrect) calculateScore(timeTaken, hintsUsed) else 0,

            )
        }

        if (isCorrect) {
            val pointsEarned = calculateScore(timeTaken, hintsUsed)
            _uiState.update {
                it.copy(
                    feedbackMessage = "Correct! +$pointsEarned points!",
                    isCorrect = true,
                    score = it.score + pointsEarned,
                    totalPuzzlesSolved = totalPuzzlesSolved+1

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
                puzzleType = "Cryptic Riddles",
                difficulty = currentDifficulty,
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

    private fun calculateScore(timeTaken: Long, hintsUsed: Int): Long {
        val baseScore = 10
        val timeBonus = maxOf(0, (4000 - timeTaken) / 100) // 45s max time for riddles
        val hintPenalty = hintsUsed * 25
        return baseScore + timeBonus - hintPenalty
    }

    // Update API call to generate options
    fun fetchRiddlesFromApi() {
        viewModelScope.launch(Dispatchers.IO) {
            _uiState.update { it.copy(isLoading = true, feedbackMessage = "Generating new riddles...") }
            try {
                val apiKey = "AIzaSyA68pHaop08jL8D9Myz2dOZGsW_7wKfvl4"
                val apiUrl = "https://generativelanguage.googleapis.com/v1beta/models/gemini-1.5-flash:generateContent?key=$apiKey"

                val payload = JSONObject().apply {
                    put("contents", JSONArray().apply {
                        put(JSONObject().apply {
                            put("parts", JSONArray().apply {
                                put(JSONObject().apply {
                                    put("text", """
                                Generate 40 challenging riddles with one-word or short answers. 
                                For each riddle, provide 3 multiple choice options including the correct answer.
                                Return ONLY a valid JSON array in this exact format:
                                [
                                    {
                                        "riddle": "What has keys but can't open locks?",
                                        "answer": "PIANO",
                                        "options": ["PIANO", "DOOR", "COMPUTER"]
                                    },
                                    {
                                        "riddle": "I speak without a mouth and hear without ears. What am I?",
                                        "answer": "ECHO", 
                                        "options": ["ECHO", "WHISPER", "SHADOW"]
                                    }
                                ]
                                No additional text or explanations.
                            """.trimIndent())
                                })
                            })
                        })
                    })
                    put("generationConfig", JSONObject().apply {
                        put("temperature", 0.8)
                        put("maxOutputTokens", 2048) // Increased for options
                        put("responseMimeType", "application/json")
                    })
                }

                val url = URL(apiUrl)
                val connection = url.openConnection() as HttpURLConnection
                connection.requestMethod = "POST"
                connection.setRequestProperty("Content-Type", "application/json")
                connection.doOutput = true
                connection.connectTimeout = 15000
                connection.readTimeout = 15000

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

                            // Clean the response - remove markdown code blocks if present
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
                                val newRiddles = mutableListOf<Riddle>()

                                for (i in 0 until newRiddlesJson.length()) {
                                    val obj = newRiddlesJson.getJSONObject(i)
                                    val optionsArray = obj.getJSONArray("options")
                                    val optionsList = mutableListOf<String>()

                                    for (j in 0 until optionsArray.length()) {
                                        optionsList.add(optionsArray.getString(j))
                                    }

                                    newRiddles.add(
                                        Riddle(
                                            obj.getString("riddle"),
                                            obj.getString("answer").uppercase(),
                                            "Hard",
                                            optionsList
                                        )
                                    )
                                }

                                allRiddles = newRiddles
                                _uiState.update {
                                    it.copy(
                                        isLoading = false,
                                        feedbackMessage = "✓ ${newRiddles.size} new riddles loaded!",
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
                            feedbackMessage = "Unexpected API response format. Using default riddles."
                        )
                    }
                } else {
                    val errorText = connection.errorStream?.bufferedReader()?.use { it.readText() } ?: "No error details"
                    _uiState.update {
                        it.copy(
                            isLoading = false,
                            feedbackMessage = "API error: $responseCode. Using default riddles."
                        )
                    }
                    println("API Error $responseCode: $errorText")
                }
            } catch (e: Exception) {
                _uiState.update {
                    it.copy(
                        isLoading = false,
                        feedbackMessage = "Error: ${e.message ?: "Unknown error"}. Using default riddles."
                    )
                }
                println("API Error: ${e.message}")
                e.printStackTrace()
            }
        }
    }
}
