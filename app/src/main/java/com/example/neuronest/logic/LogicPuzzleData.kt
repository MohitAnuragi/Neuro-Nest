package com.example.neuronest.logic

// Predefined Logic Puzzle data with 100 levels - includes logic questions, math, and unit conversions
object LogicPuzzleData {
    val puzzles: List<LogicPuzzle> = listOf(
        // Easy Logic Questions (Levels 1-20)
        LogicPuzzle("What has keys but no locks, space but no room, and you can enter but can't go inside?", "KEYBOARD", listOf("KEYBOARD", "PIANO", "COMPUTER"), "Easy", "Input device"),
        LogicPuzzle("The more you take away, the larger it becomes. What is it?", "HOLE", listOf("HOLE", "PROBLEM", "DEBT"), "Easy", "Empty space"),
        LogicPuzzle("What can you catch but not throw?", "COLD", listOf("COLD", "BALL", "BUS"), "Easy", "Illness"),
        LogicPuzzle("What goes up but never comes down?", "AGE", listOf("AGE", "BALLOON", "TIME"), "Easy", "Gets older"),
        LogicPuzzle("If you have it, you want to share it. If you share it, you don't have it. What is it?", "SECRET", listOf("SECRET", "MONEY", "KNOWLEDGE"), "Easy", "Private information"),

        // Easy Math Problems (Levels 6-10)
        LogicPuzzle("What is 15 + 27?", "42", listOf("42", "40", "44"), "Easy", "Addition"),
        LogicPuzzle("What is 100 - 45?", "55", listOf("55", "65", "45"), "Easy", "Subtraction"),
        LogicPuzzle("What is 8 × 7?", "56", listOf("56", "54", "63"), "Easy", "Multiplication"),
        LogicPuzzle("What is 81 ÷ 9?", "9", listOf("9", "8", "10"), "Easy", "Division"),
        LogicPuzzle("What is 12 + 18 - 5?", "25", listOf("25", "30", "20"), "Easy", "Mixed operations"),

        // Easy Unit Conversions (Levels 11-20)
        LogicPuzzle("How many centimeters in 1 meter?", "100", listOf("100", "10", "1000"), "Easy", "1 m = 100 cm"),
        LogicPuzzle("How many minutes in 1 hour?", "60", listOf("60", "24", "100"), "Easy", "Basic time"),
        LogicPuzzle("How many seconds in 1 minute?", "60", listOf("60", "100", "30"), "Easy", "Basic time"),
        LogicPuzzle("How many hours in 1 day?", "24", listOf("24", "12", "48"), "Easy", "Day cycle"),
        LogicPuzzle("How many days in 1 week?", "7", listOf("7", "5", "10"), "Easy", "Week days"),
        LogicPuzzle("How many months in 1 year?", "12", listOf("12", "10", "365"), "Easy", "Calendar"),
        LogicPuzzle("How many grams in 1 kilogram?", "1000", listOf("1000", "100", "10"), "Easy", "1 kg = 1000 g"),
        LogicPuzzle("How many milliliters in 1 liter?", "1000", listOf("1000", "100", "500"), "Easy", "1 L = 1000 mL"),
        LogicPuzzle("How many meters in 1 kilometer?", "1000", listOf("1000", "100", "10"), "Easy", "1 km = 1000 m"),
        LogicPuzzle("How many cents in 1 dollar?", "100", listOf("100", "10", "1000"), "Easy", "Currency"),

        // Medium Logic Questions (Levels 21-35)
        LogicPuzzle("I'm tall when I'm young and short when I'm old. What am I?", "CANDLE", listOf("CANDLE", "PERSON", "TREE"), "Medium", "Light source"),
        LogicPuzzle("What has words but never speaks?", "BOOK", listOf("BOOK", "SIGN", "LETTER"), "Medium", "Reading material"),
        LogicPuzzle("What belongs to you but others use it more than you?", "NAME", listOf("NAME", "VOICE", "TIME"), "Medium", "Identity"),
        LogicPuzzle("What has a heart that doesn't beat?", "ARTICHOKE", listOf("ARTICHOKE", "ROBOT", "DECK"), "Medium", "Vegetable"),
        LogicPuzzle("Forward I am heavy, backward I am not. What am I?", "TON", listOf("TON", "WEIGHT", "NOT"), "Medium", "Unit reversed = NOT"),

        // Medium Math Problems (Levels 26-35)
        LogicPuzzle("What is 15% of 200?", "30", listOf("30", "15", "40"), "Medium", "Percentage calculation"),
        LogicPuzzle("If a car travels 60 km/h for 3 hours, how far does it go?", "180", listOf("180", "60", "20"), "Medium", "Distance = Speed × Time"),
        LogicPuzzle("What is the square root of 144?", "12", listOf("12", "14", "10"), "Medium", "√144"),
        LogicPuzzle("What is 2³ (2 to the power of 3)?", "8", listOf("8", "6", "9"), "Medium", "2×2×2"),
        LogicPuzzle("A shirt costs $40 after a 20% discount. What was the original price?", "50", listOf("50", "48", "32"), "Medium", "40 is 80% of original"),
        LogicPuzzle("If 5 apples cost $10, how much do 8 apples cost?", "16", listOf("16", "15", "20"), "Medium", "$2 per apple"),
        LogicPuzzle("What is the next number: 2, 4, 8, 16, __?", "32", listOf("32", "24", "20"), "Medium", "×2 each time"),
        LogicPuzzle("What is the average of 10, 20, and 30?", "20", listOf("20", "15", "25"), "Medium", "Sum ÷ 3"),
        LogicPuzzle("A rectangle has length 12 and width 5. What is its area?", "60", listOf("60", "17", "34"), "Medium", "Length × Width"),
        LogicPuzzle("What is 3/4 as a decimal?", "0.75", listOf("0.75", "0.34", "0.43"), "Medium", "Fraction to decimal"),

        // Medium Unit Conversions (Levels 36-50)
        LogicPuzzle("Convert 2.5 hours to minutes", "150", listOf("150", "125", "250"), "Medium", "2.5 × 60"),
        LogicPuzzle("Convert 5 kilometers to meters", "5000", listOf("5000", "500", "50"), "Medium", "1 km = 1000 m"),
        LogicPuzzle("Convert 2 liters to milliliters", "2000", listOf("2000", "200", "20"), "Medium", "1 L = 1000 mL"),
        LogicPuzzle("Convert 3 kilograms to grams", "3000", listOf("3000", "300", "30"), "Medium", "1 kg = 1000 g"),
        LogicPuzzle("How many seconds in 5 minutes?", "300", listOf("300", "500", "250"), "Medium", "5 × 60"),
        LogicPuzzle("Convert 500 centimeters to meters", "5", listOf("5", "50", "0.5"), "Medium", "÷ 100"),
        LogicPuzzle("How many days in 4 weeks?", "28", listOf("28", "30", "24"), "Medium", "4 × 7"),
        LogicPuzzle("Convert 72 hours to days", "3", listOf("3", "2", "4"), "Medium", "72 ÷ 24"),
        LogicPuzzle("Convert 1/2 hour to minutes", "30", listOf("30", "50", "15"), "Medium", "60 ÷ 2"),
        LogicPuzzle("How many millimeters in 5 centimeters?", "50", listOf("50", "5", "500"), "Medium", "1 cm = 10 mm"),
        LogicPuzzle("Convert 2000 grams to kilograms", "2", listOf("2", "20", "200"), "Medium", "÷ 1000"),
        LogicPuzzle("How many minutes in 1.5 hours?", "90", listOf("90", "60", "150"), "Medium", "1.5 × 60"),
        LogicPuzzle("Convert 3 feet to inches", "36", listOf("36", "12", "30"), "Medium", "1 ft = 12 in"),
        LogicPuzzle("Convert 2 yards to feet", "6", listOf("6", "2", "3"), "Medium", "1 yd = 3 ft"),
        LogicPuzzle("How many ounces in 1 pound?", "16", listOf("16", "12", "10"), "Medium", "1 lb = 16 oz"),

        // Hard Logic Questions (Levels 51-60)
        LogicPuzzle("What comes once in a minute, twice in a moment, but never in a thousand years?", "M", listOf("M", "TIME", "SECOND"), "Hard", "Letter M"),
        LogicPuzzle("Two in a corner, one in a room, zero in a house, but one in a shelter. What am I?", "R", listOf("R", "WALL", "DOOR"), "Hard", "Letter R"),
        LogicPuzzle("What word becomes shorter when you add two letters to it?", "SHORT", listOf("SHORT", "LONG", "WORD"), "Hard", "Add ER = SHORTER"),
        LogicPuzzle("I have cities but no houses, forests but no trees, water but no fish. What am I?", "MAP", listOf("MAP", "GLOBE", "WORLD"), "Hard", "Geography tool"),
        LogicPuzzle("What has a neck but no head?", "BOTTLE", listOf("BOTTLE", "GIRAFFE", "SHIRT"), "Hard", "Container"),
        LogicPuzzle("The more it dries, the wetter it gets. What is it?", "TOWEL", listOf("TOWEL", "SPONGE", "CLOTH"), "Hard", "Bathroom item"),
        LogicPuzzle("What breaks when you say it?", "SILENCE", listOf("SILENCE", "SECRET", "PROMISE"), "Hard", "Absence of sound"),
        LogicPuzzle("What runs but never walks, has a mouth but never talks?", "RIVER", listOf("RIVER", "CLOCK", "TIME"), "Hard", "Water body"),
        LogicPuzzle("What has 13 hearts but no other organs?", "DECK", listOf("DECK", "CARDS", "KING"), "Hard", "Playing cards"),
        LogicPuzzle("What can fill a room but takes no space?", "LIGHT", listOf("LIGHT", "AIR", "SOUND"), "Hard", "Illumination"),

        // Hard Math Problems (Levels 61-75)
        LogicPuzzle("What is 25% of 80?", "20", listOf("20", "25", "15"), "Hard", "80 × 0.25"),
        LogicPuzzle("If x + 5 = 12, what is x?", "7", listOf("7", "17", "5"), "Hard", "12 - 5"),
        LogicPuzzle("What is the square of 15?", "225", listOf("225", "125", "150"), "Hard", "15 × 15"),
        LogicPuzzle("A train travels 120 km in 2 hours. What is its speed in km/h?", "60", listOf("60", "240", "120"), "Hard", "Distance ÷ Time"),
        LogicPuzzle("What is 3/5 as a percentage?", "60", listOf("60", "35", "53"), "Hard", "3÷5 × 100"),
        LogicPuzzle("If 3x = 24, what is x?", "8", listOf("8", "27", "21"), "Hard", "24 ÷ 3"),
        LogicPuzzle("What is the perimeter of a square with side 7?", "28", listOf("28", "49", "14"), "Hard", "4 × 7"),
        LogicPuzzle("What is 40% of 150?", "60", listOf("60", "40", "110"), "Hard", "150 × 0.4"),
        LogicPuzzle("A circle has radius 7. What is its diameter?", "14", listOf("14", "7", "21"), "Hard", "Radius × 2"),
        LogicPuzzle("What is the cube of 4?", "64", listOf("64", "16", "12"), "Hard", "4³ = 4×4×4"),
        LogicPuzzle("If y - 8 = 15, what is y?", "23", listOf("23", "7", "120"), "Hard", "15 + 8"),
        LogicPuzzle("What is the next prime number after 7?", "11", listOf("11", "9", "8"), "Hard", "Not divisible"),
        LogicPuzzle("What is 2/5 + 1/5?", "0.6", listOf("0.6", "0.4", "0.25"), "Hard", "3/5 = 0.6"),
        LogicPuzzle("What is 10% of 250?", "25", listOf("25", "50", "10"), "Hard", "250 × 0.1"),
        LogicPuzzle("If 2x + 3 = 11, what is x?", "4", listOf("4", "8", "14"), "Hard", "(11-3) ÷ 2"),

        // Expert Logic Questions (Levels 76-85)
        LogicPuzzle("A man pushes his car to a hotel and tells the owner he's bankrupt. Why?", "MONOPOLY", listOf("MONOPOLY", "HOTEL", "GAME"), "Expert", "Board game scenario"),
        LogicPuzzle("What always runs but never walks, often murmurs but never talks, has a bed but never sleeps?", "RIVER", listOf("RIVER", "CLOCK", "TIME"), "Expert", "Water flows"),
        LogicPuzzle("I am not alive, but I can die. What am I?", "BATTERY", listOf("BATTERY", "CANDLE", "FIRE"), "Expert", "Power source"),
        LogicPuzzle("A woman shoots her husband, holds him underwater for 5 minutes, then hangs him. Later they enjoy dinner. How?", "PHOTOGRAPH", listOf("PHOTOGRAPH", "PICTURE", "PHOTO"), "Expert", "Developing photos"),
        LogicPuzzle("Three doctors said Bill was their brother. Bill says he has no brothers. How many brothers does Bill have?", "ZERO", listOf("ZERO", "THREE", "ONE"), "Expert", "Bill is female"),
        LogicPuzzle("What walks on four legs in morning, two at noon, three in evening?", "MAN", listOf("MAN", "ANIMAL", "SHADOW"), "Expert", "Riddle of Sphinx"),
        LogicPuzzle("The more there is, the less you see. What is it?", "DARKNESS", listOf("DARKNESS", "FOG", "SMOKE"), "Expert", "Lack of light"),
        LogicPuzzle("A man lives on 100th floor. Rainy days: elevator to top. Sunny days: 70th floor and walks. Why?", "SHORT", listOf("SHORT", "UMBRELLA", "EXERCISE"), "Expert", "Can't reach button"),
        LogicPuzzle("A murderer chooses: fire room, gun room, or lions (3 years no food). Safest?", "LIONS", listOf("LIONS", "FIRE", "GUNS"), "Expert", "Lions dead"),
        LogicPuzzle("What can you keep after giving to someone?", "WORD", listOf("WORD", "PROMISE", "LOVE"), "Expert", "Your word/promise"),

        // Expert Math & Conversions (Levels 86-100)
        LogicPuzzle("Convert 2.5 miles to kilometers (1 mile ≈ 1.6 km)", "4", listOf("4", "2.5", "3.2"), "Expert", "2.5 × 1.6"),
        LogicPuzzle("What is 15% of 60 plus 20% of 80?", "25", listOf("25", "21", "29"), "Expert", "9 + 16"),
        LogicPuzzle("A store offers 30% discount. Item is $200. How much after discount?", "140", listOf("140", "170", "60"), "Expert", "70% of 200"),
        LogicPuzzle("Convert 100°C to Fahrenheit (F = C×9/5+32)", "212", listOf("212", "180", "100"), "Expert", "Boiling point"),
        LogicPuzzle("If 5 workers complete a job in 10 days, how many days for 10 workers?", "5", listOf("5", "20", "10"), "Expert", "Inverse proportion"),
        LogicPuzzle("What is the area of a triangle with base 10 and height 8?", "40", listOf("40", "80", "18"), "Expert", "(b×h) ÷ 2"),
        LogicPuzzle("Convert 5000 milliliters to liters", "5", listOf("5", "50", "500"), "Expert", "÷ 1000"),
        LogicPuzzle("If x² = 49, what is x?", "7", listOf("7", "14", "49"), "Expert", "√49"),
        LogicPuzzle("What is 3/4 of 120?", "90", listOf("90", "40", "80"), "Expert", "120 × 0.75"),
        LogicPuzzle("A recipe for 4 people needs 3 cups flour. How much for 6 people?", "4.5", listOf("4.5", "4", "5"), "Expert", "3 ÷ 4 × 6"),
        LogicPuzzle("Convert 36 inches to feet", "3", listOf("3", "12", "432"), "Expert", "36 ÷ 12"),
        LogicPuzzle("What is the volume of a cube with side 5?", "125", listOf("125", "25", "15"), "Expert", "5³"),
        LogicPuzzle("If price increases from $50 to $60, what is the % increase?", "20", listOf("20", "10", "12"), "Expert", "(10÷50) × 100"),
        LogicPuzzle("Convert 2 gallons to quarts (1 gal = 4 qt)", "8", listOf("8", "2", "16"), "Expert", "2 × 4"),
        LogicPuzzle("What is the next number: 1, 1, 2, 3, 5, 8, __?", "13", listOf("13", "10", "11"), "Expert", "Fibonacci")
    )

    fun getPuzzleForLevel(level: Int): LogicPuzzle {
        val idx = (level - 1).coerceIn(0, puzzles.size - 1)
        return puzzles[idx]
    }
}

