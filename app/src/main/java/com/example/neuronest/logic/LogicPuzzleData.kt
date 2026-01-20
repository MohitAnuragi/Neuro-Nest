package com.example.neuronest.logic

// Predefined Logic Puzzle data with 100 levels - includes logic questions, math, and unit conversions
object LogicPuzzleData {
    val puzzles: List<LogicPuzzle> = listOf(

        // ---------- EASY (1–30) ----------
        LogicPuzzle("What has keys but can’t open locks?", "KEYBOARD", listOf("KEYBOARD","PIANO","MAP"), "Easy", "Used to type"),
        LogicPuzzle("What gets wetter as it dries?", "TOWEL", listOf("TOWEL","SPONGE","CLOUD"), "Easy", "Bathroom item"),
        LogicPuzzle("What has a face and two hands but no arms or legs?", "CLOCK", listOf("CLOCK","PERSON","ROBOT"), "Easy", "Tells time"),
        LogicPuzzle("What can travel around the world while staying in a corner?", "STAMP", listOf("STAMP","COIN","MAP"), "Easy", "On letters"),
        LogicPuzzle("What has one eye but can’t see?", "NEEDLE", listOf("NEEDLE","CAMERA","STORM"), "Easy", "Sewing tool"),

        LogicPuzzle("What is 10 + 15?", "25", listOf("25","20","30"), "Easy", "Addition"),
        LogicPuzzle("What is 20 − 8?", "12", listOf("12","10","14"), "Easy", "Subtraction"),
        LogicPuzzle("What is 6 × 5?", "30", listOf("30","35","25"), "Easy", "Multiplication"),
        LogicPuzzle("What is 40 ÷ 8?", "5", listOf("5","8","6"), "Easy", "Division"),
        LogicPuzzle("What is 9 + 9?", "18", listOf("18","16","20"), "Easy", "Addition"),

        LogicPuzzle("How many days are in a week?", "7", listOf("7","5","10"), "Easy", "Calendar"),
        LogicPuzzle("How many hours are in a day?", "24", listOf("24","12","48"), "Easy", "Time"),
        LogicPuzzle("How many minutes are in an hour?", "60", listOf("60","100","30"), "Easy", "Time"),
        LogicPuzzle("How many months are in a year?", "12", listOf("12","10","365"), "Easy", "Calendar"),
        LogicPuzzle("How many centimeters are in a meter?", "100", listOf("100","10","1000"), "Easy", "Metric system"),

        LogicPuzzle("Which number comes next: 2, 4, 6, __?", "8", listOf("8","10","6"), "Easy", "Add 2"),
        LogicPuzzle("Which number comes next: 1, 3, 5, __?", "7", listOf("7","9","6"), "Easy", "Odd numbers"),
        LogicPuzzle("Which number comes next: 5, 10, 15, __?", "20", listOf("20","25","30"), "Easy", "Add 5"),
        LogicPuzzle("Which number comes next: 10, 20, 30, __?", "40", listOf("40","50","35"), "Easy", "Add 10"),
        LogicPuzzle("Which number comes next: 3, 6, 9, __?", "12", listOf("12","15","10"), "Easy", "Multiply by 1"),

        // ---------- MEDIUM (31–65) ----------
        LogicPuzzle("What has a heart but doesn’t beat?", "ARTICHOKE", listOf("ARTICHOKE","ROBOT","CLOCK"), "Medium", "Vegetable"),
        LogicPuzzle("What belongs to you but others use it more?", "NAME", listOf("NAME","MONEY","PHONE"), "Medium", "Identity"),
        LogicPuzzle("What has many teeth but can’t bite?", "COMB", listOf("COMB","DOG","ZIPPER"), "Medium", "Hair tool"),
        LogicPuzzle("What has words but never speaks?", "BOOK", listOf("BOOK","LETTER","SIGN"), "Medium", "Reading"),
        LogicPuzzle("Forward I am heavy, backward I am not.", "TON", listOf("TON","WEIGHT","IRON"), "Medium", "Spelling trick"),

        LogicPuzzle("What is 25% of 200?", "50", listOf("50","25","75"), "Medium", "Percentage"),
        LogicPuzzle("What is the square root of 81?", "9", listOf("9","8","7"), "Medium", "√81"),
        LogicPuzzle("What is 15 × 4?", "60", listOf("60","45","75"), "Medium", "Multiplication"),
        LogicPuzzle("What is 120 ÷ 6?", "20", listOf("20","24","18"), "Medium", "Division"),
        LogicPuzzle("What is the average of 10, 20, 30?", "20", listOf("20","15","25"), "Medium", "Average"),

        LogicPuzzle("Convert 2 hours to minutes", "120", listOf("120","60","180"), "Medium", "Time"),
        LogicPuzzle("Convert 3 km to meters", "3000", listOf("3000","300","30"), "Medium", "Metric"),
        LogicPuzzle("Convert 500 grams to kilograms", "0.5", listOf("0.5","5","50"), "Medium", "Metric"),
        LogicPuzzle("Convert 1.5 hours to minutes", "90", listOf("90","60","120"), "Medium", "Time"),
        LogicPuzzle("Convert 250 cm to meters", "2.5", listOf("2.5","25","0.25"), "Medium", "Metric"),

        LogicPuzzle("Next number: 2, 4, 8, 16, __", "32", listOf("32","24","20"), "Medium", "×2"),
        LogicPuzzle("Next number: 1, 4, 9, __", "16", listOf("16","12","18"), "Medium", "Squares"),
        LogicPuzzle("Next number: 5, 15, 45, __", "135", listOf("135","90","120"), "Medium", "×3"),
        LogicPuzzle("Next number: 1, 1, 2, 3, __", "5", listOf("5","6","4"), "Medium", "Fibonacci"),
        LogicPuzzle("Next number: 10, 20, 40, __", "80", listOf("80","60","100"), "Medium", "×2"),

        // ---------- HARD (66–85) ----------
        LogicPuzzle("What breaks when you say it?", "SILENCE", listOf("SILENCE","GLASS","SECRET"), "Hard", "Sound"),
        LogicPuzzle("What comes once in a minute, twice in a moment?", "M", listOf("M","O","T"), "Hard", "Letter"),
        LogicPuzzle("What has 13 hearts but no organs?", "DECK", listOf("DECK","CARDS","KING"), "Hard", "Cards"),
        LogicPuzzle("What has a neck but no head?", "BOTTLE", listOf("BOTTLE","SHIRT","GIRAFFE"), "Hard", "Container"),
        LogicPuzzle("What runs but never walks?", "RIVER", listOf("RIVER","CLOCK","TIME"), "Hard", "Nature"),

        LogicPuzzle("If 3x = 27, x = ?", "9", listOf("9","6","12"), "Hard", "Algebra"),
        LogicPuzzle("What is 40% of 150?", "60", listOf("60","40","100"), "Hard", "Percentage"),
        LogicPuzzle("What is the cube of 3?", "27", listOf("27","9","18"), "Hard", "Cube"),
        LogicPuzzle("What is 7²?", "49", listOf("49","42","56"), "Hard", "Square"),
        LogicPuzzle("What is 2/5 as decimal?", "0.4", listOf("0.4","0.5","0.2"), "Hard", "Fraction"),

        // ---------- EXPERT (86–100) ----------
        LogicPuzzle("A man pushes his car to a hotel and goes bankrupt. Why?", "MONOPOLY", listOf("MONOPOLY","CASINO","HOTEL"), "Expert", "Board game"),
        LogicPuzzle("What can fill a room but takes no space?", "LIGHT", listOf("LIGHT","AIR","SOUND"), "Expert", "Physics"),
        LogicPuzzle("I am not alive but I grow. What am I?", "FIRE", listOf("FIRE","PLANT","SHADOW"), "Expert", "Needs fuel"),
        LogicPuzzle("What disappears as soon as you say its name?", "SILENCE", listOf("SILENCE","SHADOW","AIR"), "Expert", "Sound"),
        LogicPuzzle("What has cities but no houses?", "MAP", listOf("MAP","GLOBE","COUNTRY"), "Expert", "Geography"),

        LogicPuzzle("Convert 100°C to Fahrenheit", "212", listOf("212","180","100"), "Expert", "Formula"),
        LogicPuzzle("If 5 people take 10 days, 10 people take?", "5", listOf("5","10","20"), "Expert", "Inverse proportion"),
        LogicPuzzle("Area of triangle (b=10,h=6)?", "30", listOf("30","60","16"), "Expert", "½bh"),
        LogicPuzzle("What is 3/4 of 200?", "150", listOf("150","100","120"), "Expert", "Fraction"),
        LogicPuzzle("Next number: 1, 1, 2, 3, 5, __", "8", listOf("8","7","6"), "Expert", "Fibonacci"),


        LogicPuzzle("What has a head, a tail, but no body?", "COIN", listOf("COIN","SNAKE","COMET"), "Medium", "Currency"),
        LogicPuzzle("What can run but never walks?", "WATER", listOf("WATER","DOG","CLOCK"), "Medium", "Natural flow"),
        LogicPuzzle("What has hands but can’t clap?", "CLOCK", listOf("CLOCK","STATUE","ROBOT"), "Medium", "Time"),
        LogicPuzzle("What has a ring but no finger?", "PHONE", listOf("PHONE","BELL","TREE"), "Medium", "Sound"),
        LogicPuzzle("What has legs but doesn’t walk?", "TABLE", listOf("TABLE","DOG","CHAIR"), "Medium", "Furniture"),

        LogicPuzzle("What is 18 × 6?", "108", listOf("108","96","112"), "Medium", "Multiplication"),
        LogicPuzzle("What is 144 ÷ 12?", "12", listOf("12","14","10"), "Medium", "Division"),
        LogicPuzzle("What is 30% of 200?", "60", listOf("60","30","90"), "Medium", "Percentage"),
        LogicPuzzle("What is the square root of 196?", "14", listOf("14","16","12"), "Medium", "√196"),
        LogicPuzzle("What is 45 + 55?", "100", listOf("100","90","110"), "Medium", "Addition"),

        LogicPuzzle("Convert 4 hours to minutes", "240", listOf("240","200","180"), "Medium", "4×60"),
        LogicPuzzle("Convert 3.5 kilometers to meters", "3500", listOf("3500","3000","35"), "Medium", "Metric"),
        LogicPuzzle("Convert 750 grams to kilograms", "0.75", listOf("0.75","7.5","75"), "Medium", "Metric"),
        LogicPuzzle("Convert 2 days to hours", "48", listOf("48","24","36"), "Medium", "Time"),
        LogicPuzzle("Convert 90 minutes to hours", "1.5", listOf("1.5","1","2"), "Medium", "Time"),

        LogicPuzzle("Next number: 3, 6, 12, 24, __", "48", listOf("48","36","60"), "Medium", "×2"),
        LogicPuzzle("Next number: 1, 4, 9, 16, __", "25", listOf("25","20","36"), "Medium", "Squares"),
        LogicPuzzle("Next number: 2, 5, 10, 17, __", "26", listOf("26","24","30"), "Medium", "Add increasing"),
        LogicPuzzle("Next number: 100, 90, 80, __", "70", listOf("70","60","75"), "Medium", "Subtract 10"),
        LogicPuzzle("Next number: 5, 10, 20, 40, __", "80", listOf("80","60","100"), "Medium", "×2"),

        LogicPuzzle("If x + 9 = 25, what is x?", "16", listOf("16","14","34"), "Medium", "Equation"),
        LogicPuzzle("What is the perimeter of a square with side 6?", "24", listOf("24","36","12"), "Medium", "4×side"),
        LogicPuzzle("What is the area of a rectangle (8×7)?", "56", listOf("56","15","28"), "Medium", "Area"),
        LogicPuzzle("What is 2³ + 2²?", "12", listOf("12","10","8"), "Medium", "Powers"),
        LogicPuzzle("What is the average of 5, 10, 15?", "10", listOf("10","15","8"), "Medium", "Average"),

        // ---------- HARD (141–180) ----------
        LogicPuzzle("What word is always spelled incorrectly?", "INCORRECTLY", listOf("INCORRECTLY","WRONG","ERROR"), "Hard", "Wordplay"),
        LogicPuzzle("What has an eye but can’t see?", "HURRICANE", listOf("HURRICANE","NEEDLE","CAMERA"), "Hard", "Storm"),
        LogicPuzzle("What has a thumb but no fingers?", "GLOVE", listOf("GLOVE","MITTEN","HAND"), "Hard", "Clothing"),
        LogicPuzzle("What can you hold without touching?", "BREATH", listOf("BREATH","ROPE","WATER"), "Hard", "You breathe"),
        LogicPuzzle("What has one head, one foot, and four legs?", "BED", listOf("BED","TABLE","COW"), "Hard", "Furniture"),

        LogicPuzzle("If 4x = 64, what is x?", "16", listOf("16","8","12"), "Hard", "Algebra"),
        LogicPuzzle("What is 75% of 160?", "120", listOf("120","100","140"), "Hard", "Percentage"),
        LogicPuzzle("What is the cube of 5?", "125", listOf("125","25","75"), "Hard", "Cube"),
        LogicPuzzle("What is 9² + 7²?", "130", listOf("130","81","98"), "Hard", "Squares"),
        LogicPuzzle("What is 1/8 as a decimal?", "0.125", listOf("0.125","0.25","0.8"), "Hard", "Fraction"),

        LogicPuzzle("Convert 5.5 hours to minutes", "330", listOf("330","300","360"), "Hard", "5.5×60"),
        LogicPuzzle("Convert 2.25 kg to grams", "2250", listOf("2250","250","225"), "Hard", "Metric"),
        LogicPuzzle("Convert 144 inches to feet", "12", listOf("12","14","10"), "Hard", "÷12"),
        LogicPuzzle("Convert 3.5 liters to milliliters", "3500", listOf("3500","300","35"), "Hard", "Metric"),
        LogicPuzzle("Convert 2.5 days to hours", "60", listOf("60","48","72"), "Hard", "Time"),

        LogicPuzzle("Next number: 1, 3, 6, 10, __", "15", listOf("15","14","16"), "Hard", "Triangular"),
        LogicPuzzle("Next number: 2, 4, 8, 16, 32, __", "64", listOf("64","48","128"), "Hard", "×2"),
        LogicPuzzle("Next number: 7, 14, 28, 56, __", "112", listOf("112","84","96"), "Hard", "×2"),
        LogicPuzzle("Next number: 1, 2, 4, 7, 11, __", "16", listOf("16","15","18"), "Hard", "Add increasing"),
        LogicPuzzle("Next number: 81, 27, 9, 3, __", "1", listOf("1","0","6"), "Hard", "÷3"),

        // ---------- HARD+ (181–200) ----------
        LogicPuzzle("What disappears as soon as you say its name?", "SILENCE", listOf("SILENCE","SHADOW","AIR"), "Hard+", "Sound"),
        LogicPuzzle("What can’t be used until it’s broken?", "EGG", listOf("EGG","GLASS","SEAL"), "Hard+", "Cooking"),
        LogicPuzzle("What gets sharper the more you use it?", "BRAIN", listOf("BRAIN","KNIFE","PENCIL"), "Hard+", "Thinking"),
        LogicPuzzle("What has many keys but opens no doors?", "PIANO", listOf("PIANO","KEYBOARD","LOCK"), "Hard+", "Music"),
        LogicPuzzle("What comes down but never goes up?", "RAIN", listOf("RAIN","SNOW","SUN"), "Hard+", "Weather"),

        LogicPuzzle("If 2x + 5 = 19, x = ?", "7", listOf("7","12","14"), "Hard+", "Equation"),
        LogicPuzzle("What is 12.5% of 400?", "50", listOf("50","40","60"), "Hard+", "Percentage"),
        LogicPuzzle("What is the diameter of a circle with radius 9?", "18", listOf("18","9","27"), "Hard+", "Geometry"),
        LogicPuzzle("What is 7³ − 2³?", "335", listOf("335","343","329"), "Hard+", "Cubes"),
        LogicPuzzle("What is the next prime after 19?", "23", listOf("23","21","25"), "Hard+", "Prime numbers"),

        LogicPuzzle("What has branches but no fruit, trunk, or leaves?", "BANK", listOf("BANK","TREE","RIVER"), "Hard", "Money"),
        LogicPuzzle("What can fly without wings?", "TIME", listOf("TIME","BIRD","PLANE"), "Hard", "Passes quickly"),
        LogicPuzzle("What has a mouth but never eats?", "RIVER", listOf("RIVER","BABY","CAVE"), "Hard", "Geography"),
        LogicPuzzle("What has an eye but cannot see?", "NEEDLE", listOf("NEEDLE","HURRICANE","CAMERA"), "Hard", "Sewing"),
        LogicPuzzle("What has a spine but no bones?", "BOOK", listOf("BOOK","FISH","HUMAN"), "Hard", "Reading"),

        LogicPuzzle("If 5x = 45, what is x?", "9", listOf("9","5","40"), "Hard", "Algebra"),
        LogicPuzzle("What is 60% of 250?", "150", listOf("150","125","175"), "Hard", "Percentage"),
        LogicPuzzle("What is the square root of 256?", "16", listOf("16","14","18"), "Hard", "Square root"),
        LogicPuzzle("What is 7 × 8 + 4?", "60", listOf("60","56","64"), "Hard", "Order of operations"),
        LogicPuzzle("What is the average of 12, 18, and 30?", "20", listOf("20","18","22"), "Hard", "Average"),

        LogicPuzzle("Convert 4.5 hours to minutes", "270", listOf("270","240","300"), "Hard", "Time"),
        LogicPuzzle("Convert 2.75 km to meters", "2750", listOf("2750","2700","2500"), "Hard", "Metric"),
        LogicPuzzle("Convert 1.2 kg to grams", "1200", listOf("1200","12","1000"), "Hard", "Metric"),
        LogicPuzzle("Convert 360 minutes to hours", "6", listOf("6","5","4"), "Hard", "Time"),
        LogicPuzzle("Convert 84 inches to feet", "7", listOf("7","6","8"), "Hard", "÷12"),

        LogicPuzzle("Next number: 2, 6, 12, 20, __", "30", listOf("30","28","32"), "Hard", "n(n+1)"),
        LogicPuzzle("Next number: 1, 4, 9, 16, 25, __", "36", listOf("36","49","30"), "Hard", "Squares"),
        LogicPuzzle("Next number: 3, 9, 27, 81, __", "243", listOf("243","162","324"), "Hard", "×3"),
        LogicPuzzle("Next number: 100, 81, 64, 49, __", "36", listOf("36","25","30"), "Hard", "Reverse squares"),
        LogicPuzzle("Next number: 1, 2, 4, 8, 16, __", "32", listOf("32","24","64"), "Hard", "×2"),

        LogicPuzzle("If x − 7 = 18, x = ?", "25", listOf("25","11","21"), "Hard", "Equation"),
        LogicPuzzle("What is the perimeter of a rectangle (10×6)?", "32", listOf("32","60","16"), "Hard", "Perimeter"),
        LogicPuzzle("What is 9³?", "729", listOf("729","81","243"), "Hard", "Cube"),
        LogicPuzzle("What is 5/8 as a decimal?", "0.625", listOf("0.625","0.58","0.8"), "Hard", "Fraction"),
        LogicPuzzle("What is the next prime after 23?", "29", listOf("29","27","31"), "Hard", "Prime"),

        // ---------- EXPERT (241–300) ----------
        LogicPuzzle("What word reads the same forward and backward?", "PALINDROME", listOf("PALINDROME","ANAGRAM","SYMMETRY"), "Expert", "Word type"),
        LogicPuzzle("What has four fingers and a thumb but is not alive?", "GLOVE", listOf("GLOVE","HAND","ROBOT"), "Expert", "Clothing"),
        LogicPuzzle("What comes once in a year, twice in a week, but never in a day?", "E", listOf("E","A","O"), "Expert", "Letter"),
        LogicPuzzle("What can be cracked, made, told, and played?", "JOKE", listOf("JOKE","CODE","GLASS"), "Expert", "Humor"),
        LogicPuzzle("What has many holes but still holds water?", "SPONGE", listOf("SPONGE","BUCKET","NET"), "Expert", "Household"),

        LogicPuzzle("If 3x + 7 = 34, x = ?", "9", listOf("9","11","27"), "Expert", "Equation"),
        LogicPuzzle("What is 18% of 250?", "45", listOf("45","40","50"), "Expert", "Percentage"),
        LogicPuzzle("What is the area of a circle with radius 7? (π≈3.14)", "153.94", listOf("153.94","49","98"), "Expert", "πr²"),
        LogicPuzzle("What is 2⁵ + 2⁴?", "48", listOf("48","32","64"), "Expert", "Powers"),
        LogicPuzzle("What is the LCM of 4 and 6?", "12", listOf("12","24","6"), "Expert", "LCM"),

        LogicPuzzle("Convert 1.75 hours to minutes", "105", listOf("105","90","120"), "Expert", "Time"),
        LogicPuzzle("Convert 3.2 liters to milliliters", "3200", listOf("3200","32","3000"), "Expert", "Metric"),
        LogicPuzzle("Convert 2.5 miles to kilometers (1 mile ≈ 1.6 km)", "4", listOf("4","3.5","5"), "Expert", "Approximation"),
        LogicPuzzle("Convert 540 seconds to minutes", "9", listOf("9","8","10"), "Expert", "÷60"),
        LogicPuzzle("Convert 0.75 kg to grams", "750", listOf("750","75","700"), "Expert", "Metric"),

        LogicPuzzle("Next number: 1, 1, 2, 6, 24, __", "120", listOf("120","60","720"), "Expert", "Factorial"),
        LogicPuzzle("Next number: 2, 3, 5, 7, 11, __", "13", listOf("13","15","17"), "Expert", "Prime"),
        LogicPuzzle("Next number: 1, 4, 13, 40, __", "121", listOf("121","120","160"), "Expert", "×3+1"),
        LogicPuzzle("Next number: 5, 25, 125, __", "625", listOf("625","250","500"), "Expert", "×5"),
        LogicPuzzle("Next number: 81, 16, 25, 36, __", "49", listOf("49","64","81"), "Expert", "Squares mixed"),

        LogicPuzzle("If the cost price is $80 and selling price is $100, profit %?", "25", listOf("25","20","15"), "Expert", "Profit"),
        LogicPuzzle("What is the volume of a cube with side 6?", "216", listOf("216","36","120"), "Expert", "Volume"),
        LogicPuzzle("What is the next Fibonacci number after 21?", "34", listOf("34","32","36"), "Expert", "Fibonacci"),
        LogicPuzzle("What is 7! (7 factorial)?", "5040", listOf("5040","720","840"), "Expert", "Factorial"),
        LogicPuzzle("If a number is divisible by both 3 and 4, smallest such number?", "12", listOf("12","6","24"), "Expert", "LCM"),



        LogicPuzzle("What has a lock but no key, space but no room?", "KEYBOARD", listOf("KEYBOARD","PIANO","SAFE"), "Expert", "Computer device"),
        LogicPuzzle("What can you hear but not touch or see?", "VOICE", listOf("VOICE","AIR","WIND"), "Expert", "Sound"),
        LogicPuzzle("What has a ring but no finger?", "BELL", listOf("BELL","PHONE","TREE"), "Expert", "Sound"),
        LogicPuzzle("What has a bottom at the top?", "LEG", listOf("LEG","MOUNTAIN","BOTTLE"), "Expert", "Body part"),
        LogicPuzzle("What has an end but no beginning?", "STICK", listOf("STICK","CIRCLE","LINE"), "Expert", "Object"),

        LogicPuzzle("If 5x − 10 = 40, x = ?", "10", listOf("10","8","12"), "Expert", "Algebra"),
        LogicPuzzle("What is 22% of 250?", "55", listOf("55","50","60"), "Expert", "Percentage"),
        LogicPuzzle("What is the square root of 361?", "19", listOf("19","21","17"), "Expert", "√361"),
        LogicPuzzle("What is 6³ + 4²?", "232", listOf("232","216","220"), "Expert", "Powers"),
        LogicPuzzle("What is the LCM of 8 and 12?", "24", listOf("24","48","12"), "Expert", "LCM"),

        LogicPuzzle("Convert 2.4 hours to minutes", "144", listOf("144","120","160"), "Expert", "Time"),
        LogicPuzzle("Convert 1.25 km to meters", "1250", listOf("1250","1200","1500"), "Expert", "Metric"),
        LogicPuzzle("Convert 3.75 kg to grams", "3750", listOf("3750","350","3000"), "Expert", "Metric"),
        LogicPuzzle("Convert 900 seconds to minutes", "15", listOf("15","10","20"), "Expert", "÷60"),
        LogicPuzzle("Convert 5 feet to inches", "60", listOf("60","50","72"), "Expert", "×12"),

        LogicPuzzle("Next number: 2, 10, 30, 68, __", "130", listOf("130","126","140"), "Expert", "n³ + 2"),
        LogicPuzzle("Next number: 1, 3, 6, 10, 15, __", "21", listOf("21","20","22"), "Expert", "Triangular"),
        LogicPuzzle("Next number: 4, 9, 16, 25, __", "36", listOf("36","49","30"), "Expert", "Squares"),
        LogicPuzzle("Next number: 5, 11, 23, 47, __", "95", listOf("95","94","97"), "Expert", "×2 + 1"),
        LogicPuzzle("Next number: 81, 64, 49, 36, __", "25", listOf("25","16","30"), "Expert", "Reverse squares"),

        // ---------- VERY HARD (341–400) ----------
        LogicPuzzle("What English word has three consecutive double letters?", "BOOKKEEPER", listOf("BOOKKEEPER","COMMITTEE","MISSPELL"), "Very Hard", "Spelling"),
        LogicPuzzle("What disappears when you stand up?", "LAP", listOf("LAP","SHADOW","CHAIR"), "Very Hard", "Body position"),
        LogicPuzzle("What is always in front of you but can’t be seen?", "FUTURE", listOf("FUTURE","AIR","TIME"), "Very Hard", "Time"),
        LogicPuzzle("What can bring back the dead, make you cry, make you laugh?", "MEMORY", listOf("MEMORY","BOOK","PHOTO"), "Very Hard", "Mind"),
        LogicPuzzle("What has no weight but can be heavy?", "BURDEN", listOf("BURDEN","CLOUD","STONE"), "Very Hard", "Emotional"),

        LogicPuzzle("If 7x + 3 = 52, x = ?", "7", listOf("7","5","9"), "Very Hard", "Algebra"),
        LogicPuzzle("What is 17² − 8²?", "225", listOf("225","289","81"), "Very Hard", "Difference of squares"),
        LogicPuzzle("What is the cube root of 512?", "8", listOf("8","16","64"), "Very Hard", "Cube root"),
        LogicPuzzle("What is 3/8 as a decimal?", "0.375", listOf("0.375","0.38","0.35"), "Very Hard", "Fraction"),
        LogicPuzzle("What is the HCF of 18 and 24?", "6", listOf("6","12","3"), "Very Hard", "HCF"),

        LogicPuzzle("Convert 2.75 hours to minutes", "165", listOf("165","150","180"), "Very Hard", "Time"),
        LogicPuzzle("Convert 4.2 liters to milliliters", "4200", listOf("4200","400","420"), "Very Hard", "Metric"),
        LogicPuzzle("Convert 1.6 km to meters", "1600", listOf("1600","1400","1200"), "Very Hard", "Metric"),
        LogicPuzzle("Convert 2.5 weeks to days", "17.5", listOf("17.5","14","21"), "Very Hard", "Time"),
        LogicPuzzle("Convert 0.9 kg to grams", "900", listOf("900","90","9000"), "Very Hard", "Metric"),

        LogicPuzzle("Next number: 1, 2, 6, 24, 120, __", "720", listOf("720","600","840"), "Very Hard", "Factorial"),
        LogicPuzzle("Next number: 2, 5, 14, 41, __", "122", listOf("122","120","125"), "Very Hard", "×3 − 1"),
        LogicPuzzle("Next number: 3, 6, 11, 18, __", "27", listOf("27","26","29"), "Very Hard", "Add odd numbers"),
        LogicPuzzle("Next number: 1000, 500, 250, 125, __", "62.5", listOf("62.5","60","75"), "Very Hard", "÷2"),
        LogicPuzzle("Next number: 1, 4, 9, 16, 25, 36, __", "49", listOf("49","64","42"), "Very Hard", "Squares"),

        LogicPuzzle("If profit is 20% and cost price is $200, selling price?", "240", listOf("240","220","260"), "Very Hard", "Profit"),
        LogicPuzzle("Area of a circle with diameter 14? (π≈3.14)", "153.94", listOf("153.94","196","98"), "Very Hard", "Geometry"),
        LogicPuzzle("What is the next prime after 47?", "53", listOf("53","51","49"), "Very Hard", "Prime"),
        LogicPuzzle("What is 8! (factorial)?", "40320", listOf("40320","720","5040"), "Very Hard", "Factorial"),
        LogicPuzzle("If a number is divisible by 9, sum of digits must be?", "MULTIPLE_OF_9", listOf("MULTIPLE_OF_9","EVEN","ODD"), "Very Hard", "Divisibility rule"),

        LogicPuzzle("What word becomes shorter when you add two letters to it?", "SHORT", listOf("SHORT","SMALL","LONG"), "Legendary", "Add ER"),
        LogicPuzzle("What has letters but never reads?", "MAILBOX", listOf("MAILBOX","BOOK","EMAIL"), "Legendary", "Receives mail"),
        LogicPuzzle("What can go up and down without moving?", "STAIRS", listOf("STAIRS","ELEVATOR","TEMPERATURE"), "Legendary", "In buildings"),
        LogicPuzzle("What has an eye but can’t see, and a needle but can’t sew?", "HURRICANE", listOf("HURRICANE","NEEDLE","CAMERA"), "Legendary", "Storm"),
        LogicPuzzle("What has a tongue but cannot taste?", "SHOE", listOf("SHOE","MOUTH","FIRE"), "Legendary", "Footwear"),

        LogicPuzzle("What gets bigger the more you remove from it?", "HOLE", listOf("HOLE","PROBLEM","DEBT"), "Legendary", "Digging"),
        LogicPuzzle("What can’t talk but will reply when spoken to?", "ECHO", listOf("ECHO","PHONE","MIRROR"), "Legendary", "Sound"),
        LogicPuzzle("What has one voice but speaks four languages?", "PIANO", listOf("PIANO","SINGER","RADIO"), "Legendary", "Musical keys"),
        LogicPuzzle("What word is pronounced the same when you remove four letters?", "QUEUE", listOf("QUEUE","LINE","WAIT"), "Legendary", "Silent letters"),
        LogicPuzzle("What is always coming but never arrives?", "TOMORROW", listOf("TOMORROW","FUTURE","TIME"), "Legendary", "Time"),

        LogicPuzzle("What can be seen once in a minute, twice in a moment, but never in a year?", "M", listOf("M","E","O"), "Legendary", "Letter"),
        LogicPuzzle("What has no beginning, end, or middle?", "CIRCLE", listOf("CIRCLE","LINE","RING"), "Legendary", "Shape"),
        LogicPuzzle("What breaks without being touched?", "PROMISE", listOf("PROMISE","GLASS","ICE"), "Legendary", "Words"),
        LogicPuzzle("What runs faster the longer it runs?", "TIME", listOf("TIME","RIVER","CLOCK"), "Legendary", "Always moving"),
        LogicPuzzle("What has a face and two hands but no arms?", "CLOCK", listOf("CLOCK","STATUE","ROBOT"), "Legendary", "Time"),

        // ---------- LEGENDARY MATH & LOGIC (431–460) ----------
        LogicPuzzle("If 1=3, 2=3, 3=5, 4=4, then 5=?", "4", listOf("4","5","3"), "Legendary", "Letters in word"),
        LogicPuzzle("A bat and ball cost $1.10. Bat costs $1 more than ball. Ball costs?", "0.05", listOf("0.05","0.10","0.50"), "Legendary", "Classic trick"),
        LogicPuzzle("If you multiply all numbers on a phone keypad, result?", "0", listOf("0","1","10"), "Legendary", "Zero present"),
        LogicPuzzle("Which is heavier: a pound of feathers or a pound of steel?", "EQUAL", listOf("EQUAL","STEEL","FEATHERS"), "Legendary", "Same weight"),
        LogicPuzzle("If it takes 5 machines 5 minutes to make 5 items, how long for 100 machines to make 100 items?", "5", listOf("5","100","10"), "Legendary", "Rate logic"),

        LogicPuzzle("What number comes next: 1, 11, 21, 1211, 111221, __?", "312211", listOf("312211","111221","212321"), "Legendary", "Look-and-say"),
        LogicPuzzle("What is the only number with letters in alphabetical order?", "FORTY", listOf("FORTY","FIVE","EIGHT"), "Legendary", "Spelling"),
        LogicPuzzle("I am an odd number. Remove one letter and I become even. What am I?", "SEVEN", listOf("SEVEN","THREE","NINE"), "Legendary", "Remove S"),
        LogicPuzzle("What has 8 bits but is not a computer byte?", "OCTOPUS", listOf("OCTOPUS","BYTE","SPIDER"), "Legendary", "Tentacles"),
        LogicPuzzle("If today is Saturday, what day is 100 days from today?", "MONDAY", listOf("MONDAY","SUNDAY","TUESDAY"), "Legendary", "Modulo 7"),

        LogicPuzzle("What number is missing: 2, 3, 5, 7, 11, __?", "13", listOf("13","15","17"), "Legendary", "Primes"),
        LogicPuzzle("If you spell numbers, which comes first alphabetically?", "EIGHT", listOf("EIGHT","FIVE","FOUR"), "Legendary", "Spelling"),
        LogicPuzzle("How many times can you subtract 5 from 25?", "ONCE", listOf("ONCE","FIVE","TWICE"), "Legendary", "Trick"),
        LogicPuzzle("Which month has 28 days?", "ALL", listOf("ALL","FEBRUARY","ONE"), "Legendary", "Calendar"),
        LogicPuzzle("What comes next: J, F, M, A, M, J, J, A, __?", "S", listOf("S","O","N"), "Legendary", "Months initials"),

        // ---------- FINAL BOSS (461–500) ----------
        LogicPuzzle("A man looks at a portrait and says: Brothers and sisters I have none, but that man’s father is my father’s son. Who is in the portrait?", "SON", listOf("SON","FATHER","NEPHEW"), "Legendary", "Family logic"),
        LogicPuzzle("You see a boat filled with people. It hasn’t sunk, but when you look again you don’t see a single person. Why?", "MARRIED", listOf("MARRIED","DROWNED","INVISIBLE"), "Legendary", "Word trick"),
        LogicPuzzle("What can travel faster than light but has no mass?", "SHADOW", listOf("SHADOW","THOUGHT","TIME"), "Legendary", "Physics trick"),
        LogicPuzzle("A man is found dead in a room with 53 bicycles. What happened?", "CARDS", listOf("CARDS","ACCIDENT","GYM"), "Legendary", "Deck of cards"),
        LogicPuzzle("Which word would you remove to make this sentence correct: ‘This sentence is incorrect’?", "INCORRECT", listOf("INCORRECT","SENTENCE","THIS"), "Legendary", "Paradox"),

        LogicPuzzle("What question can you never answer yes to?", "ARE_YOU_ASLEEP", listOf("ARE_YOU_ASLEEP","ARE_YOU_HUNGRY","ARE_YOU_HAPPY"), "Legendary", "Logic"),
        LogicPuzzle("If you have me, you want to share me. If you share me, you lose me. What am I?", "SECRET", listOf("SECRET","MONEY","TIME"), "Legendary", "Confidential"),
        LogicPuzzle("What gets sharper the more you use it?", "BRAIN", listOf("BRAIN","KNIFE","PENCIL"), "Legendary", "Thinking"),
        LogicPuzzle("What word contains all letters but is empty?", "ALPHABET", listOf("ALPHABET","DICTIONARY","ZERO"), "Legendary", "Wordplay"),
        LogicPuzzle("What can be broken but never held?", "PROMISE", listOf("PROMISE","GLASS","RULE"), "Legendary", "Abstract"),

        LogicPuzzle("I speak without a mouth and hear without ears. What am I?", "ECHO", listOf("ECHO","WIND","MEMORY"), "Legendary", "Sound"),
        LogicPuzzle("What flies without wings and cries without eyes?", "CLOUD", listOf("CLOUD","BIRD","RAIN"), "Legendary", "Weather"),
        LogicPuzzle("What has a beginning but no end?", "CIRCLE", listOf("CIRCLE","LINE","RAY"), "Legendary", "Geometry"),
        LogicPuzzle("What word starts and ends with E but contains only one letter?", "ENVELOPE", listOf("ENVELOPE","EYE","EDGE"), "Legendary", "Mail"),
        LogicPuzzle("What is the answer to this question?", "THIS", listOf("THIS","THAT","UNKNOWN"), "Legendary", "Meta"),

        LogicPuzzle("Final puzzle: What is harder to catch the faster you run?", "BREATH", listOf("BREATH","TIME","SHADOW"), "Legendary", "Running"),
        LogicPuzzle("What exists only when you look at it?", "REFLECTION", listOf("REFLECTION","SHADOW","LIGHT"), "Legendary", "Mirror"),
        LogicPuzzle("What weighs nothing but can kill you?", "WATER", listOf("WATER","AIR","FEAR"), "Legendary", "Drowning"),
        LogicPuzzle("What question has no answer?", "WHY", listOf("WHY","WHAT","HOW"), "Legendary", "Philosophy"),
        LogicPuzzle("You finish this game. What did you just unlock?", "LEGENDARY", listOf("LEGENDARY","LEVEL","END"), "Legendary", "Completion")



    )

    fun getPuzzleForLevel(level: Int): LogicPuzzle {
        val idx = (level - 1).coerceIn(0, puzzles.size - 1)
        return puzzles[idx]
    }
}

