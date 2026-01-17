package com.example.neuronest.connection

// Predefined Connection puzzles with 100 levels
object ConnectionPuzzleData {
    val puzzles: List<ConnectionPuzzle> = listOf(
        // Level 1: Easy - Simple Categories
        ConnectionPuzzle(
            level = 1,
            words = listOf("LION", "TIGER", "BEAR", "WOLF", "APPLE", "BANANA", "ORANGE", "GRAPE", "RED", "BLUE", "GREEN", "YELLOW", "ONE", "TWO", "THREE", "FOUR"),
            categories = listOf(
                ConnectionCategory("Wild Animals", setOf("LION", "TIGER", "BEAR", "WOLF"), CategoryColor.YELLOW),
                ConnectionCategory("Fruits", setOf("APPLE", "BANANA", "ORANGE", "GRAPE"), CategoryColor.GREEN),
                ConnectionCategory("Colors", setOf("RED", "BLUE", "GREEN", "YELLOW"), CategoryColor.BLUE),
                ConnectionCategory("Numbers", setOf("ONE", "TWO", "THREE", "FOUR"), CategoryColor.PURPLE)
            ),
            difficulty = "Easy"
        ),

        // Level 2: Easy - Common Items
        ConnectionPuzzle(
            level = 2,
            words = listOf("CHAIR", "TABLE", "SOFA", "BED", "DOCTOR", "NURSE", "TEACHER", "ENGINEER", "MONDAY", "TUESDAY", "FRIDAY", "SUNDAY", "SPRING", "SUMMER", "FALL", "WINTER"),
            categories = listOf(
                ConnectionCategory("Furniture", setOf("CHAIR", "TABLE", "SOFA", "BED"), CategoryColor.YELLOW),
                ConnectionCategory("Professions", setOf("DOCTOR", "NURSE", "TEACHER", "ENGINEER"), CategoryColor.GREEN),
                ConnectionCategory("Days of Week", setOf("MONDAY", "TUESDAY", "FRIDAY", "SUNDAY"), CategoryColor.BLUE),
                ConnectionCategory("Seasons", setOf("SPRING", "SUMMER", "FALL", "WINTER"), CategoryColor.PURPLE)
            ),
            difficulty = "Easy"
        ),

        // Level 3: Easy - Body & Sports
        ConnectionPuzzle(
            level = 3,
            words = listOf("HAND", "FOOT", "HEAD", "ARM", "SOCCER", "TENNIS", "GOLF", "CRICKET", "DOG", "CAT", "FISH", "BIRD", "BOOK", "PEN", "PAPER", "RULER"),
            categories = listOf(
                ConnectionCategory("Body Parts", setOf("HAND", "FOOT", "HEAD", "ARM"), CategoryColor.YELLOW),
                ConnectionCategory("Sports", setOf("SOCCER", "TENNIS", "GOLF", "CRICKET"), CategoryColor.GREEN),
                ConnectionCategory("Pets", setOf("DOG", "CAT", "FISH", "BIRD"), CategoryColor.BLUE),
                ConnectionCategory("School Items", setOf("BOOK", "PEN", "PAPER", "RULER"), CategoryColor.PURPLE)
            ),
            difficulty = "Easy"
        ),

        // Level 4: Medium - Words with Multiple Meanings
        ConnectionPuzzle(
            level = 4,
            words = listOf("BANK", "WAVE", "MINE", "WATCH", "ROSE", "IRIS", "LILY", "DAISY", "TRUMPET", "VIOLIN", "PIANO", "DRUM", "BEEF", "PORK", "LAMB", "CHICKEN"),
            categories = listOf(
                ConnectionCategory("Can Be Verbs", setOf("BANK", "WAVE", "MINE", "WATCH"), CategoryColor.YELLOW),
                ConnectionCategory("Flowers", setOf("ROSE", "IRIS", "LILY", "DAISY"), CategoryColor.GREEN),
                ConnectionCategory("Musical Instruments", setOf("TRUMPET", "VIOLIN", "PIANO", "DRUM"), CategoryColor.BLUE),
                ConnectionCategory("Types of Meat", setOf("BEEF", "PORK", "LAMB", "CHICKEN"), CategoryColor.PURPLE)
            ),
            difficulty = "Medium"
        ),

        // Level 5: Medium - Related Words
        ConnectionPuzzle(
            level = 5,
            words = listOf("KING", "QUEEN", "JACK", "ACE", "CIRCLE", "SQUARE", "TRIANGLE", "RECTANGLE", "MERCURY", "VENUS", "MARS", "EARTH", "GOLD", "SILVER", "BRONZE", "COPPER"),
            categories = listOf(
                ConnectionCategory("Playing Cards", setOf("KING", "QUEEN", "JACK", "ACE"), CategoryColor.YELLOW),
                ConnectionCategory("Shapes", setOf("CIRCLE", "SQUARE", "TRIANGLE", "RECTANGLE"), CategoryColor.GREEN),
                ConnectionCategory("Planets", setOf("MERCURY", "VENUS", "MARS", "EARTH"), CategoryColor.BLUE),
                ConnectionCategory("Metals", setOf("GOLD", "SILVER", "BRONZE", "COPPER"), CategoryColor.PURPLE)
            ),
            difficulty = "Medium"
        ),

        // Continue with more levels...
        *generateMorePuzzles(6, 100)
    )

    private fun generateMorePuzzles(startLevel: Int, endLevel: Int): Array<ConnectionPuzzle> {
        val morePuzzles = mutableListOf<ConnectionPuzzle>()

        // Level 6-20: Easy-Medium
        morePuzzles.addAll(listOf(
            ConnectionPuzzle(
                level = 6,
                words = listOf("MILK", "WATER", "JUICE", "SODA", "LONDON", "PARIS", "ROME", "TOKYO", "HAPPY", "SAD", "ANGRY", "EXCITED", "FAST", "SLOW", "BIG", "SMALL"),
                categories = listOf(
                    ConnectionCategory("Beverages", setOf("MILK", "WATER", "JUICE", "SODA"), CategoryColor.YELLOW),
                    ConnectionCategory("Cities", setOf("LONDON", "PARIS", "ROME", "TOKYO"), CategoryColor.GREEN),
                    ConnectionCategory("Emotions", setOf("HAPPY", "SAD", "ANGRY", "EXCITED"), CategoryColor.BLUE),
                    ConnectionCategory("Adjectives", setOf("FAST", "SLOW", "BIG", "SMALL"), CategoryColor.PURPLE)
                ),
                difficulty = "Easy"
            ),
            ConnectionPuzzle(
                level = 7,
                words = listOf("PIZZA", "BURGER", "PASTA", "SUSHI", "BICYCLE", "CAR", "TRAIN", "PLANE", "SALT", "PEPPER", "SUGAR", "FLOUR", "RAIN", "SNOW", "HAIL", "SLEET"),
                categories = listOf(
                    ConnectionCategory("Foods", setOf("PIZZA", "BURGER", "PASTA", "SUSHI"), CategoryColor.YELLOW),
                    ConnectionCategory("Transportation", setOf("BICYCLE", "CAR", "TRAIN", "PLANE"), CategoryColor.GREEN),
                    ConnectionCategory("Kitchen Ingredients", setOf("SALT", "PEPPER", "SUGAR", "FLOUR"), CategoryColor.BLUE),
                    ConnectionCategory("Precipitation", setOf("RAIN", "SNOW", "HAIL", "SLEET"), CategoryColor.PURPLE)
                ),
                difficulty = "Easy"
            )
        ))

        // Generate remaining puzzles with varied themes
        for (level in 8..endLevel) {
            morePuzzles.add(generateRandomPuzzle(level))
        }

        return morePuzzles.toTypedArray()
    }

    private fun generateRandomPuzzle(level: Int): ConnectionPuzzle {
        val themes = listOf(
            // Tech Theme
            listOf(
                ConnectionCategory("Tech Companies", setOf("APPLE", "GOOGLE", "AMAZON", "MICROSOFT"), CategoryColor.YELLOW),
                ConnectionCategory("Programming Languages", setOf("JAVA", "PYTHON", "RUBY", "SWIFT"), CategoryColor.GREEN),
                ConnectionCategory("Social Media", setOf("FACEBOOK", "TWITTER", "INSTAGRAM", "TIKTOK"), CategoryColor.BLUE),
                ConnectionCategory("Browsers", setOf("CHROME", "FIREFOX", "SAFARI", "EDGE"), CategoryColor.PURPLE)
            ),
            // Nature Theme
            listOf(
                ConnectionCategory("Trees", setOf("OAK", "PINE", "MAPLE", "BIRCH"), CategoryColor.YELLOW),
                ConnectionCategory("Oceans", setOf("PACIFIC", "ATLANTIC", "INDIAN", "ARCTIC"), CategoryColor.GREEN),
                ConnectionCategory("Mountains", setOf("EVEREST", "ALPS", "ROCKIES", "ANDES"), CategoryColor.BLUE),
                ConnectionCategory("Deserts", setOf("SAHARA", "GOBI", "MOJAVE", "KALAHARI"), CategoryColor.PURPLE)
            ),
            // Entertainment Theme
            listOf(
                ConnectionCategory("Movie Genres", setOf("ACTION", "COMEDY", "DRAMA", "HORROR"), CategoryColor.YELLOW),
                ConnectionCategory("Music Genres", setOf("ROCK", "JAZZ", "POP", "CLASSICAL"), CategoryColor.GREEN),
                ConnectionCategory("Board Games", setOf("CHESS", "CHECKERS", "MONOPOLY", "SCRABBLE"), CategoryColor.BLUE),
                ConnectionCategory("Card Games", setOf("POKER", "BRIDGE", "SOLITAIRE", "HEARTS"), CategoryColor.PURPLE)
            )
        )

        val selectedTheme = themes[level % themes.size]
        val allWords = selectedTheme.flatMap { it.words }.shuffled()

        return ConnectionPuzzle(
            level = level,
            words = allWords,
            categories = selectedTheme,
            difficulty = when {
                level <= 30 -> "Easy"
                level <= 70 -> "Medium"
                else -> "Hard"
            }
        )
    }

    fun getPuzzleForLevel(level: Int): ConnectionPuzzle {
        val idx = (level - 1).coerceIn(0, puzzles.size - 1)
        return puzzles[idx]
    }
}

