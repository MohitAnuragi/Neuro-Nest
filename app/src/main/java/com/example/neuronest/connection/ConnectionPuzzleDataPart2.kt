package com.example.neuronest.connection

object ConnectionPuzzleDataPart2 {
    fun getPuzzles(): List<ConnectionPuzzle> = listOf(
        ConnectionPuzzle(101,
            listOf("PRIME","EVEN","ODD","SQUARE","ADD","SUB","MUL","DIV","SUN","MOON","STAR","PLANET","DOG","CAT","FOX","WOLF"),
            listOf(
                ConnectionCategory("Number Properties", setOf("PRIME","EVEN","ODD","SQUARE"), CategoryColor.YELLOW),
                ConnectionCategory("Math Operations", setOf("ADD","SUB","MUL","DIV"), CategoryColor.GREEN),
                ConnectionCategory("Space Objects", setOf("SUN","MOON","STAR","PLANET"), CategoryColor.BLUE),
                ConnectionCategory("Animals", setOf("DOG","CAT","FOX","WOLF"), CategoryColor.PURPLE)
            ),
            "Medium+"
        ),

        ConnectionPuzzle(102,
            listOf("LINE","RAY","ANGLE","POINT","SECOND","MINUTE","HOUR","DAY","READ","WRITE","DRAW","PAINT","CAR","BUS","TRAIN","PLANE"),
            listOf(
                ConnectionCategory("Geometry Basics", setOf("LINE","RAY","ANGLE","POINT"), CategoryColor.YELLOW),
                ConnectionCategory("Time Units", setOf("SECOND","MINUTE","HOUR","DAY"), CategoryColor.GREEN),
                ConnectionCategory("Creative Actions", setOf("READ","WRITE","DRAW","PAINT"), CategoryColor.BLUE),
                ConnectionCategory("Transport", setOf("CAR","BUS","TRAIN","PLANE"), CategoryColor.PURPLE)
            ),
            "Medium+"
        ),

        ConnectionPuzzle(103,
            listOf("BYTE","KILOBYTE","MEGABYTE","GIGABYTE","ONE","TEN","HUNDRED","THOUSAND","APPLE","BANANA","ORANGE","GRAPE","RED","GREEN","BLUE","YELLOW"),
            listOf(
                ConnectionCategory("Data Units", setOf("BYTE","KILOBYTE","MEGABYTE","GIGABYTE"), CategoryColor.YELLOW),
                ConnectionCategory("Number Scales", setOf("ONE","TEN","HUNDRED","THOUSAND"), CategoryColor.GREEN),
                ConnectionCategory("Fruits", setOf("APPLE","BANANA","ORANGE","GRAPE"), CategoryColor.BLUE),
                ConnectionCategory("Colors", setOf("RED","GREEN","BLUE","YELLOW"), CategoryColor.PURPLE)
            ),
            "Medium+"
        ),

        ConnectionPuzzle(104,
            listOf("ADD","PLUS","SUM","TOTAL","FAST","SLOW","EARLY","LATE","DOG","CAT","HORSE","COW","CHAIR","TABLE","BED","SOFA"),
            listOf(
                ConnectionCategory("Addition Words", setOf("ADD","PLUS","SUM","TOTAL"), CategoryColor.YELLOW),
                ConnectionCategory("Time Descriptors", setOf("FAST","SLOW","EARLY","LATE"), CategoryColor.GREEN),
                ConnectionCategory("Animals", setOf("DOG","CAT","HORSE","COW"), CategoryColor.BLUE),
                ConnectionCategory("Furniture", setOf("CHAIR","TABLE","BED","SOFA"), CategoryColor.PURPLE)
            ),
            "Medium+"
        ),

        ConnectionPuzzle(105,
            listOf("CIRCLE","SQUARE","TRIANGLE","RECTANGLE","BUY","SELL","RENT","LEASE","SUN","RAIN","SNOW","WIND","PEN","PENCIL","ERASER","RULER"),
            listOf(
                ConnectionCategory("Shapes", setOf("CIRCLE","SQUARE","TRIANGLE","RECTANGLE"), CategoryColor.YELLOW),
                ConnectionCategory("Property Actions", setOf("BUY","SELL","RENT","LEASE"), CategoryColor.GREEN),
                ConnectionCategory("Weather", setOf("SUN","RAIN","SNOW","WIND"), CategoryColor.BLUE),
                ConnectionCategory("Stationery", setOf("PEN","PENCIL","ERASER","RULER"), CategoryColor.PURPLE)
            ),
            "Medium+"
        ),

        // ---------- MEDIUM+ CONTINUED (106–120) ----------
        ConnectionPuzzle(106,
            listOf("ROOT","SQUARE","CUBE","POWER","SECOND","MINUTE","HOUR","DAY","DOG","CAT","BIRD","FISH","RED","BLACK","WHITE","GRAY"),
            listOf(
                ConnectionCategory("Math Functions", setOf("ROOT","SQUARE","CUBE","POWER"), CategoryColor.YELLOW),
                ConnectionCategory("Time Units", setOf("SECOND","MINUTE","HOUR","DAY"), CategoryColor.GREEN),
                ConnectionCategory("Pets", setOf("DOG","CAT","BIRD","FISH"), CategoryColor.BLUE),
                ConnectionCategory("Neutral Colors", setOf("RED","BLACK","WHITE","GRAY"), CategoryColor.PURPLE)
            ),
            "Medium+"
        ),

        ConnectionPuzzle(107,
            listOf("LOGIN","LOGOUT","UPLOAD","DOWNLOAD","ONE","TWO","FOUR","EIGHT","CAR","BUS","TRAIN","PLANE","BOOK","PAGE","LINE","WORD"),
            listOf(
                ConnectionCategory("Computer Actions", setOf("LOGIN","LOGOUT","UPLOAD","DOWNLOAD"), CategoryColor.YELLOW),
                ConnectionCategory("Powers of Two", setOf("ONE","TWO","FOUR","EIGHT"), CategoryColor.GREEN),
                ConnectionCategory("Transport", setOf("CAR","BUS","TRAIN","PLANE"), CategoryColor.BLUE),
                ConnectionCategory("Text Units", setOf("BOOK","PAGE","LINE","WORD"), CategoryColor.PURPLE)
            ),
            "Medium+"
        ),

        ConnectionPuzzle(108,
            listOf("EVEN","ODD","PRIME","COMPOSITE","SUN","MOON","STAR","PLANET","BUY","SELL","TRADE","BARTER","HAND","FOOT","ARM","LEG"),
            listOf(
                ConnectionCategory("Number Types", setOf("EVEN","ODD","PRIME","COMPOSITE"), CategoryColor.YELLOW),
                ConnectionCategory("Space Objects", setOf("SUN","MOON","STAR","PLANET"), CategoryColor.GREEN),
                ConnectionCategory("Trade Actions", setOf("BUY","SELL","TRADE","BARTER"), CategoryColor.BLUE),
                ConnectionCategory("Body Parts", setOf("HAND","FOOT","ARM","LEG"), CategoryColor.PURPLE)
            ),
            "Medium+"
        ),

        ConnectionPuzzle(109,
            listOf("POINT","LINE","RAY","PLANE","COUNT","ADD","TOTAL","SUM","DOG","CAT","FOX","WOLF","SPRING","SUMMER","FALL","WINTER"),
            listOf(
                ConnectionCategory("Geometry Terms", setOf("POINT","LINE","RAY","PLANE"), CategoryColor.YELLOW),
                ConnectionCategory("Math Verbs", setOf("COUNT","ADD","TOTAL","SUM"), CategoryColor.GREEN),
                ConnectionCategory("Animals", setOf("DOG","CAT","FOX","WOLF"), CategoryColor.BLUE),
                ConnectionCategory("Seasons", setOf("SPRING","SUMMER","FALL","WINTER"), CategoryColor.PURPLE)
            ),
            "Medium+"
        ),

        ConnectionPuzzle(110,
            listOf("BYTE","CACHE","STACK","QUEUE","SECOND","MINUTE","HOUR","DAY","PEN","PENCIL","MARKER","CHALK","MILK","CHEESE","BUTTER","YOGURT"),
            listOf(
                ConnectionCategory("Data Structures", setOf("BYTE","CACHE","STACK","QUEUE"), CategoryColor.YELLOW),
                ConnectionCategory("Time Units", setOf("SECOND","MINUTE","HOUR","DAY"), CategoryColor.GREEN),
                ConnectionCategory("Writing Tools", setOf("PEN","PENCIL","MARKER","CHALK"), CategoryColor.BLUE),
                ConnectionCategory("Dairy Products", setOf("MILK","CHEESE","BUTTER","YOGURT"), CategoryColor.PURPLE)
            ),
            "Medium+"
        ),


        ConnectionPuzzle(111,
            listOf("PRIME","FACTOR","MULTIPLE","DIVISOR","ADD","SUB","MUL","DIV","CAR","TRUCK","BUS","VAN","RED","GREEN","BLUE","YELLOW"),
            listOf(
                ConnectionCategory("Number Theory", setOf("PRIME","FACTOR","MULTIPLE","DIVISOR"), CategoryColor.YELLOW),
                ConnectionCategory("Math Operations", setOf("ADD","SUB","MUL","DIV"), CategoryColor.GREEN),
                ConnectionCategory("Vehicles", setOf("CAR","TRUCK","BUS","VAN"), CategoryColor.BLUE),
                ConnectionCategory("Colors", setOf("RED","GREEN","BLUE","YELLOW"), CategoryColor.PURPLE)
            ),
            "Medium+"
        ),


        ConnectionPuzzle(112,
            listOf("FRACTION","DECIMAL","PERCENT","RATIO","SUN","MOON","STAR","PLANET","DOG","CAT","FOX","WOLF","CAR","BUS","TRAIN","PLANE"),
            listOf(
                ConnectionCategory("Math Representations", setOf("FRACTION","DECIMAL","PERCENT","RATIO"), CategoryColor.YELLOW),
                ConnectionCategory("Space Objects", setOf("SUN","MOON","STAR","PLANET"), CategoryColor.GREEN),
                ConnectionCategory("Animals", setOf("DOG","CAT","FOX","WOLF"), CategoryColor.BLUE),
                ConnectionCategory("Transport", setOf("CAR","BUS","TRAIN","PLANE"), CategoryColor.PURPLE)
            ),
            "Medium+"
        ),

        ConnectionPuzzle(113,
            listOf("AREA","PERIMETER","VOLUME","SURFACE","ADD","SUB","MUL","DIV","APPLE","BANANA","ORANGE","GRAPE","RED","GREEN","BLUE","YELLOW"),
            listOf(
                ConnectionCategory("Measurement Terms", setOf("AREA","PERIMETER","VOLUME","SURFACE"), CategoryColor.YELLOW),
                ConnectionCategory("Math Operations", setOf("ADD","SUB","MUL","DIV"), CategoryColor.GREEN),
                ConnectionCategory("Fruits", setOf("APPLE","BANANA","ORANGE","GRAPE"), CategoryColor.BLUE),
                ConnectionCategory("Colors", setOf("RED","GREEN","BLUE","YELLOW"), CategoryColor.PURPLE)
            ),
            "Medium+"
        ),

        ConnectionPuzzle(114,
            listOf("ODD","EVEN","PRIME","SQUARE","SECOND","MINUTE","HOUR","DAY","CHAIR","TABLE","BED","SOFA","DOG","CAT","COW","GOAT"),
            listOf(
                ConnectionCategory("Number Properties", setOf("ODD","EVEN","PRIME","SQUARE"), CategoryColor.YELLOW),
                ConnectionCategory("Time Units", setOf("SECOND","MINUTE","HOUR","DAY"), CategoryColor.GREEN),
                ConnectionCategory("Furniture", setOf("CHAIR","TABLE","BED","SOFA"), CategoryColor.BLUE),
                ConnectionCategory("Animals", setOf("DOG","CAT","COW","GOAT"), CategoryColor.PURPLE)
            ),
            "Medium+"
        ),

        ConnectionPuzzle(115,
            listOf("BYTE","KILOBYTE","MEGABYTE","GIGABYTE","ONE","TEN","HUNDRED","THOUSAND","READ","WRITE","DRAW","PAINT","SUN","RAIN","SNOW","WIND"),
            listOf(
                ConnectionCategory("Data Units", setOf("BYTE","KILOBYTE","MEGABYTE","GIGABYTE"), CategoryColor.YELLOW),
                ConnectionCategory("Number Scales", setOf("ONE","TEN","HUNDRED","THOUSAND"), CategoryColor.GREEN),
                ConnectionCategory("Creative Actions", setOf("READ","WRITE","DRAW","PAINT"), CategoryColor.BLUE),
                ConnectionCategory("Weather", setOf("SUN","RAIN","SNOW","WIND"), CategoryColor.PURPLE)
            ),
            "Medium+"
        ),

        ConnectionPuzzle(116,
            listOf("SINE","COSINE","TANGENT","SECANT","POINT","LINE","RAY","PLANE","CAR","BUS","TRAIN","BIKE","MILK","CHEESE","BUTTER","YOGURT"),
            listOf(
                ConnectionCategory("Trigonometry", setOf("SINE","COSINE","TANGENT","SECANT"), CategoryColor.YELLOW),
                ConnectionCategory("Geometry Basics", setOf("POINT","LINE","RAY","PLANE"), CategoryColor.GREEN),
                ConnectionCategory("Transport", setOf("CAR","BUS","TRAIN","BIKE"), CategoryColor.BLUE),
                ConnectionCategory("Dairy Products", setOf("MILK","CHEESE","BUTTER","YOGURT"), CategoryColor.PURPLE)
            ),
            "Medium+"
        ),

        ConnectionPuzzle(117,
            listOf("LOGIN","LOGOUT","UPLOAD","DOWNLOAD","HALF","DOUBLE","SUM","TOTAL","DOG","CAT","BIRD","FISH","SPRING","SUMMER","FALL","WINTER"),
            listOf(
                ConnectionCategory("System Actions", setOf("LOGIN","LOGOUT","UPLOAD","DOWNLOAD"), CategoryColor.YELLOW),
                ConnectionCategory("Math Words", setOf("HALF","DOUBLE","SUM","TOTAL"), CategoryColor.GREEN),
                ConnectionCategory("Pets", setOf("DOG","CAT","BIRD","FISH"), CategoryColor.BLUE),
                ConnectionCategory("Seasons", setOf("SPRING","SUMMER","FALL","WINTER"), CategoryColor.PURPLE)
            ),
            "Medium+"
        ),

        ConnectionPuzzle(118,
            listOf("ROOT","SQUARE","CUBE","POWER","SECOND","MINUTE","HOUR","DAY","BOOK","PAGE","CHAPTER","WORD","RED","BLACK","WHITE","GRAY"),
            listOf(
                ConnectionCategory("Math Functions", setOf("ROOT","SQUARE","CUBE","POWER"), CategoryColor.YELLOW),
                ConnectionCategory("Time Units", setOf("SECOND","MINUTE","HOUR","DAY"), CategoryColor.GREEN),
                ConnectionCategory("Book Parts", setOf("BOOK","PAGE","CHAPTER","WORD"), CategoryColor.BLUE),
                ConnectionCategory("Neutral Colors", setOf("RED","BLACK","WHITE","GRAY"), CategoryColor.PURPLE)
            ),
            "Medium+"
        ),

        ConnectionPuzzle(119,
            listOf("BUY","SELL","RENT","LEASE","EVEN","ODD","ZERO","ONE","SUN","MOON","STAR","PLANET","PEN","PENCIL","MARKER","CHALK"),
            listOf(
                ConnectionCategory("Property Actions", setOf("BUY","SELL","RENT","LEASE"), CategoryColor.YELLOW),
                ConnectionCategory("Number Words", setOf("EVEN","ODD","ZERO","ONE"), CategoryColor.GREEN),
                ConnectionCategory("Space Objects", setOf("SUN","MOON","STAR","PLANET"), CategoryColor.BLUE),
                ConnectionCategory("Writing Tools", setOf("PEN","PENCIL","MARKER","CHALK"), CategoryColor.PURPLE)
            ),
            "Medium+"
        ),

        ConnectionPuzzle(120,
            listOf("AREA","VOLUME","DENSITY","SPEED","CAR","TRUCK","BUS","VAN","ADD","SUB","MUL","DIV","HAND","FOOT","ARM","LEG"),
            listOf(
                ConnectionCategory("Physics Quantities", setOf("AREA","VOLUME","DENSITY","SPEED"), CategoryColor.YELLOW),
                ConnectionCategory("Vehicles", setOf("CAR","TRUCK","BUS","VAN"), CategoryColor.GREEN),
                ConnectionCategory("Math Operations", setOf("ADD","SUB","MUL","DIV"), CategoryColor.BLUE),
                ConnectionCategory("Body Parts", setOf("HAND","FOOT","ARM","LEG"), CategoryColor.PURPLE)
            ),
            "Medium+"
        ),

        // ---------- CONTINUED MEDIUM+ (121–150) ----------
        ConnectionPuzzle(121,
            listOf("PRIME","FACTOR","MULTIPLE","DIVISOR","SUN","RAIN","SNOW","WIND","DOG","CAT","FOX","WOLF","CIRCLE","SQUARE","TRIANGLE","RECTANGLE"),
            listOf(
                ConnectionCategory("Number Theory", setOf("PRIME","FACTOR","MULTIPLE","DIVISOR"), CategoryColor.YELLOW),
                ConnectionCategory("Weather", setOf("SUN","RAIN","SNOW","WIND"), CategoryColor.GREEN),
                ConnectionCategory("Animals", setOf("DOG","CAT","FOX","WOLF"), CategoryColor.BLUE),
                ConnectionCategory("Shapes", setOf("CIRCLE","SQUARE","TRIANGLE","RECTANGLE"), CategoryColor.PURPLE)
            ),
            "Medium+"
        ),

        ConnectionPuzzle(122,
            listOf("SECOND","MINUTE","HOUR","DAY","LOGIN","LOGOUT","AUTH","VERIFY","APPLE","BANANA","ORANGE","GRAPE","RED","GREEN","BLUE","YELLOW"),
            listOf(
                ConnectionCategory("Time Units", setOf("SECOND","MINUTE","HOUR","DAY"), CategoryColor.YELLOW),
                ConnectionCategory("Authentication", setOf("LOGIN","LOGOUT","AUTH","VERIFY"), CategoryColor.GREEN),
                ConnectionCategory("Fruits", setOf("APPLE","BANANA","ORANGE","GRAPE"), CategoryColor.BLUE),
                ConnectionCategory("Colors", setOf("RED","GREEN","BLUE","YELLOW"), CategoryColor.PURPLE)
            ),
            "Medium+"
        ),

        ConnectionPuzzle(123,
            listOf("LINE","RAY","ANGLE","POINT","ADD","PLUS","SUM","TOTAL","CAR","BUS","TRAIN","PLANE","MILK","CHEESE","BUTTER","YOGURT"),
            listOf(
                ConnectionCategory("Geometry Basics", setOf("LINE","RAY","ANGLE","POINT"), CategoryColor.YELLOW),
                ConnectionCategory("Addition Words", setOf("ADD","PLUS","SUM","TOTAL"), CategoryColor.GREEN),
                ConnectionCategory("Transport", setOf("CAR","BUS","TRAIN","PLANE"), CategoryColor.BLUE),
                ConnectionCategory("Dairy Products", setOf("MILK","CHEESE","BUTTER","YOGURT"), CategoryColor.PURPLE)
            ),
            "Medium+"
        ),

        ConnectionPuzzle(124,
            listOf("EVEN","ODD","PRIME","SQUARE","READ","WRITE","DRAW","PAINT","SUN","MOON","STAR","SKY","CHAIR","TABLE","BED","SOFA"),
            listOf(
                ConnectionCategory("Number Properties", setOf("EVEN","ODD","PRIME","SQUARE"), CategoryColor.YELLOW),
                ConnectionCategory("Creative Actions", setOf("READ","WRITE","DRAW","PAINT"), CategoryColor.GREEN),
                ConnectionCategory("Sky Objects", setOf("SUN","MOON","STAR","SKY"), CategoryColor.BLUE),
                ConnectionCategory("Furniture", setOf("CHAIR","TABLE","BED","SOFA"), CategoryColor.PURPLE)
            ),
            "Medium+"
        ),

        ConnectionPuzzle(125,
            listOf("ONE","TEN","HUNDRED","THOUSAND","BYTE","CACHE","STACK","QUEUE","DOG","CAT","BIRD","FISH","SPRING","SUMMER","FALL","WINTER"),
            listOf(
                ConnectionCategory("Number Scales", setOf("ONE","TEN","HUNDRED","THOUSAND"), CategoryColor.YELLOW),
                ConnectionCategory("Data Structures", setOf("BYTE","CACHE","STACK","QUEUE"), CategoryColor.GREEN),
                ConnectionCategory("Pets", setOf("DOG","CAT","BIRD","FISH"), CategoryColor.BLUE),
                ConnectionCategory("Seasons", setOf("SPRING","SUMMER","FALL","WINTER"), CategoryColor.PURPLE)
            ),
            "Medium+"
        ),

        ConnectionPuzzle(126,
            listOf("FRACTION","DECIMAL","PERCENT","RATIO","CAR","BUS","TRAIN","PLANE","SUN","MOON","STAR","PLANET","DOG","CAT","FOX","WOLF"),
            listOf(
                ConnectionCategory("Math Representations", setOf("FRACTION","DECIMAL","PERCENT","RATIO"), CategoryColor.YELLOW),
                ConnectionCategory("Transport", setOf("CAR","BUS","TRAIN","PLANE"), CategoryColor.GREEN),
                ConnectionCategory("Space Objects", setOf("SUN","MOON","STAR","PLANET"), CategoryColor.BLUE),
                ConnectionCategory("Animals", setOf("DOG","CAT","FOX","WOLF"), CategoryColor.PURPLE)
            ),
            "Medium+"
        ),

        ConnectionPuzzle(127,
            listOf("AREA","PERIMETER","VOLUME","DENSITY","ADD","SUB","MUL","DIV","RED","GREEN","BLUE","YELLOW","CHAIR","TABLE","BED","SOFA"),
            listOf(
                ConnectionCategory("Measurement Terms", setOf("AREA","PERIMETER","VOLUME","DENSITY"), CategoryColor.YELLOW),
                ConnectionCategory("Math Operations", setOf("ADD","SUB","MUL","DIV"), CategoryColor.GREEN),
                ConnectionCategory("Colors", setOf("RED","GREEN","BLUE","YELLOW"), CategoryColor.BLUE),
                ConnectionCategory("Furniture", setOf("CHAIR","TABLE","BED","SOFA"), CategoryColor.PURPLE)
            ),
            "Medium+"
        ),

        ConnectionPuzzle(128,
            listOf("ODD","EVEN","PRIME","COMPOSITE","SECOND","MINUTE","HOUR","DAY","APPLE","BANANA","ORANGE","GRAPE","HAND","FOOT","ARM","LEG"),
            listOf(
                ConnectionCategory("Number Types", setOf("ODD","EVEN","PRIME","COMPOSITE"), CategoryColor.YELLOW),
                ConnectionCategory("Time Units", setOf("SECOND","MINUTE","HOUR","DAY"), CategoryColor.GREEN),
                ConnectionCategory("Fruits", setOf("APPLE","BANANA","ORANGE","GRAPE"), CategoryColor.BLUE),
                ConnectionCategory("Body Parts", setOf("HAND","FOOT","ARM","LEG"), CategoryColor.PURPLE)
            ),
            "Medium+"
        ),

        ConnectionPuzzle(129,
            listOf("ROOT","POWER","SQUARE","CUBE","BOOK","PAGE","CHAPTER","WORD","CAR","TRUCK","BUS","VAN","SUN","RAIN","SNOW","WIND"),
            listOf(
                ConnectionCategory("Math Functions", setOf("ROOT","POWER","SQUARE","CUBE"), CategoryColor.YELLOW),
                ConnectionCategory("Book Parts", setOf("BOOK","PAGE","CHAPTER","WORD"), CategoryColor.GREEN),
                ConnectionCategory("Vehicles", setOf("CAR","TRUCK","BUS","VAN"), CategoryColor.BLUE),
                ConnectionCategory("Weather", setOf("SUN","RAIN","SNOW","WIND"), CategoryColor.PURPLE)
            ),
            "Medium+"
        ),

        ConnectionPuzzle(130,
            listOf("LOGIN","LOGOUT","UPLOAD","DOWNLOAD","ONE","TWO","FOUR","EIGHT","MILK","CHEESE","BUTTER","YOGURT","DOG","CAT","BIRD","FISH"),
            listOf(
                ConnectionCategory("System Actions", setOf("LOGIN","LOGOUT","UPLOAD","DOWNLOAD"), CategoryColor.YELLOW),
                ConnectionCategory("Powers of Two", setOf("ONE","TWO","FOUR","EIGHT"), CategoryColor.GREEN),
                ConnectionCategory("Dairy Products", setOf("MILK","CHEESE","BUTTER","YOGURT"), CategoryColor.BLUE),
                ConnectionCategory("Pets", setOf("DOG","CAT","BIRD","FISH"), CategoryColor.PURPLE)
            ),
            "Medium+"
        ),

        ConnectionPuzzle(131,
            listOf("LINE","RAY","ANGLE","PLANE","COUNT","ADD","SUM","TOTAL","SPRING","SUMMER","FALL","WINTER","PEN","PENCIL","MARKER","CHALK"),
            listOf(
                ConnectionCategory("Geometry Terms", setOf("LINE","RAY","ANGLE","PLANE"), CategoryColor.YELLOW),
                ConnectionCategory("Math Verbs", setOf("COUNT","ADD","SUM","TOTAL"), CategoryColor.GREEN),
                ConnectionCategory("Seasons", setOf("SPRING","SUMMER","FALL","WINTER"), CategoryColor.BLUE),
                ConnectionCategory("Writing Tools", setOf("PEN","PENCIL","MARKER","CHALK"), CategoryColor.PURPLE)
            ),
            "Medium+"
        ),

        ConnectionPuzzle(132,
            listOf("BYTE","CACHE","STACK","QUEUE","SECOND","MINUTE","HOUR","DAY","RED","BLACK","WHITE","GRAY","CAR","BUS","TRAIN","PLANE"),
            listOf(
                ConnectionCategory("Data Structures", setOf("BYTE","CACHE","STACK","QUEUE"), CategoryColor.YELLOW),
                ConnectionCategory("Time Units", setOf("SECOND","MINUTE","HOUR","DAY"), CategoryColor.GREEN),
                ConnectionCategory("Neutral Colors", setOf("RED","BLACK","WHITE","GRAY"), CategoryColor.BLUE),
                ConnectionCategory("Transport", setOf("CAR","BUS","TRAIN","PLANE"), CategoryColor.PURPLE)
            ),
            "Medium+"
        ),

        ConnectionPuzzle(133,
            listOf("PRIME","FACTOR","MULTIPLE","DIVISOR","SUN","MOON","STAR","SKY","CHAIR","TABLE","BED","SOFA","DOG","CAT","FOX","WOLF"),
            listOf(
                ConnectionCategory("Number Theory", setOf("PRIME","FACTOR","MULTIPLE","DIVISOR"), CategoryColor.YELLOW),
                ConnectionCategory("Sky Objects", setOf("SUN","MOON","STAR","SKY"), CategoryColor.GREEN),
                ConnectionCategory("Furniture", setOf("CHAIR","TABLE","BED","SOFA"), CategoryColor.BLUE),
                ConnectionCategory("Animals", setOf("DOG","CAT","FOX","WOLF"), CategoryColor.PURPLE)
            ),
            "Medium+"
        ),

        ConnectionPuzzle(134,
            listOf("AREA","VOLUME","SPEED","TIME","ADD","SUB","MUL","DIV","APPLE","MANGO","PEAR","PLUM","LEFT","RIGHT","UP","DOWN"),
            listOf(
                ConnectionCategory("Physics Quantities", setOf("AREA","VOLUME","SPEED","TIME"), CategoryColor.YELLOW),
                ConnectionCategory("Math Operations", setOf("ADD","SUB","MUL","DIV"), CategoryColor.GREEN),
                ConnectionCategory("Fruits", setOf("APPLE","MANGO","PEAR","PLUM"), CategoryColor.BLUE),
                ConnectionCategory("Directions", setOf("LEFT","RIGHT","UP","DOWN"), CategoryColor.PURPLE)
            ),
            "Medium+"
        ),

        ConnectionPuzzle(135,
            listOf("EVEN","ODD","ZERO","ONE","READ","WRITE","DRAW","PAINT","CAR","TRUCK","BUS","VAN","SUN","RAIN","SNOW","WIND"),
            listOf(
                ConnectionCategory("Number Words", setOf("EVEN","ODD","ZERO","ONE"), CategoryColor.YELLOW),
                ConnectionCategory("Creative Actions", setOf("READ","WRITE","DRAW","PAINT"), CategoryColor.GREEN),
                ConnectionCategory("Vehicles", setOf("CAR","TRUCK","BUS","VAN"), CategoryColor.BLUE),
                ConnectionCategory("Weather", setOf("SUN","RAIN","SNOW","WIND"), CategoryColor.PURPLE)
            ),
            "Medium+"
        ),

        ConnectionPuzzle(136,
            listOf("FRACTION","DECIMAL","PERCENT","RATIO","SECOND","MINUTE","HOUR","DAY","DOG","CAT","BIRD","FISH","RED","GREEN","BLUE","YELLOW"),
            listOf(
                ConnectionCategory("Math Forms", setOf("FRACTION","DECIMAL","PERCENT","RATIO"), CategoryColor.YELLOW),
                ConnectionCategory("Time Units", setOf("SECOND","MINUTE","HOUR","DAY"), CategoryColor.GREEN),
                ConnectionCategory("Pets", setOf("DOG","CAT","BIRD","FISH"), CategoryColor.BLUE),
                ConnectionCategory("Colors", setOf("RED","GREEN","BLUE","YELLOW"), CategoryColor.PURPLE)
            ),
            "Medium+"
        ),

        ConnectionPuzzle(137,
            listOf("ROOT","POWER","SQUARE","CUBE","LOGIN","LOGOUT","UPLOAD","DOWNLOAD","BOOK","PAGE","NOTE","WORD","SPRING","SUMMER","FALL","WINTER"),
            listOf(
                ConnectionCategory("Math Functions", setOf("ROOT","POWER","SQUARE","CUBE"), CategoryColor.YELLOW),
                ConnectionCategory("System Actions", setOf("LOGIN","LOGOUT","UPLOAD","DOWNLOAD"), CategoryColor.GREEN),
                ConnectionCategory("Writing Terms", setOf("BOOK","PAGE","NOTE","WORD"), CategoryColor.BLUE),
                ConnectionCategory("Seasons", setOf("SPRING","SUMMER","FALL","WINTER"), CategoryColor.PURPLE)
            ),
            "Medium+"
        ),

        ConnectionPuzzle(138,
            listOf("LINE","RAY","ANGLE","POINT","ADD","PLUS","SUM","TOTAL","CAR","BUS","TRAIN","PLANE","MILK","WATER","TEA","JUICE"),
            listOf(
                ConnectionCategory("Geometry Basics", setOf("LINE","RAY","ANGLE","POINT"), CategoryColor.YELLOW),
                ConnectionCategory("Addition Words", setOf("ADD","PLUS","SUM","TOTAL"), CategoryColor.GREEN),
                ConnectionCategory("Transport", setOf("CAR","BUS","TRAIN","PLANE"), CategoryColor.BLUE),
                ConnectionCategory("Drinks", setOf("MILK","WATER","TEA","JUICE"), CategoryColor.PURPLE)
            ),
            "Medium+"
        ),

        ConnectionPuzzle(139,
            listOf("PRIME","ODD","EVEN","SQUARE","SUN","MOON","STAR","PLANET","PEN","PENCIL","ERASER","RULER","HAND","FOOT","ARM","LEG"),
            listOf(
                ConnectionCategory("Number Properties", setOf("PRIME","ODD","EVEN","SQUARE"), CategoryColor.YELLOW),
                ConnectionCategory("Space Objects", setOf("SUN","MOON","STAR","PLANET"), CategoryColor.GREEN),
                ConnectionCategory("Stationery", setOf("PEN","PENCIL","ERASER","RULER"), CategoryColor.BLUE),
                ConnectionCategory("Body Parts", setOf("HAND","FOOT","ARM","LEG"), CategoryColor.PURPLE)
            ),
            "Medium+"
        ),

        ConnectionPuzzle(140,
            listOf("AREA","PERIMETER","VOLUME","SURFACE","BUY","SELL","RENT","LEASE","DOG","CAT","FOX","WOLF","RED","BLACK","WHITE","GRAY"),
            listOf(
                ConnectionCategory("Measurement Terms", setOf("AREA","PERIMETER","VOLUME","SURFACE"), CategoryColor.YELLOW),
                ConnectionCategory("Property Actions", setOf("BUY","SELL","RENT","LEASE"), CategoryColor.GREEN),
                ConnectionCategory("Animals", setOf("DOG","CAT","FOX","WOLF"), CategoryColor.BLUE),
                ConnectionCategory("Neutral Colors", setOf("RED","BLACK","WHITE","GRAY"), CategoryColor.PURPLE)
            ),
            "Medium+"
        ),

        ConnectionPuzzle(141,
            listOf("BYTE","KILOBYTE","MEGABYTE","GIGABYTE","ONE","TEN","HUNDRED","THOUSAND","SUN","RAIN","SNOW","WIND","CHAIR","TABLE","BED","SOFA"),
            listOf(
                ConnectionCategory("Data Units", setOf("BYTE","KILOBYTE","MEGABYTE","GIGABYTE"), CategoryColor.YELLOW),
                ConnectionCategory("Number Scales", setOf("ONE","TEN","HUNDRED","THOUSAND"), CategoryColor.GREEN),
                ConnectionCategory("Weather", setOf("SUN","RAIN","SNOW","WIND"), CategoryColor.BLUE),
                ConnectionCategory("Furniture", setOf("CHAIR","TABLE","BED","SOFA"), CategoryColor.PURPLE)
            ),
            "Medium+"
        ),

        ConnectionPuzzle(142,
            listOf("EVEN","ODD","PRIME","COMPOSITE","READ","WRITE","DRAW","PAINT","CAR","TRUCK","BUS","VAN","APPLE","BANANA","ORANGE","GRAPE"),
            listOf(
                ConnectionCategory("Number Types", setOf("EVEN","ODD","PRIME","COMPOSITE"), CategoryColor.YELLOW),
                ConnectionCategory("Creative Actions", setOf("READ","WRITE","DRAW","PAINT"), CategoryColor.GREEN),
                ConnectionCategory("Vehicles", setOf("CAR","TRUCK","BUS","VAN"), CategoryColor.BLUE),
                ConnectionCategory("Fruits", setOf("APPLE","BANANA","ORANGE","GRAPE"), CategoryColor.PURPLE)
            ),
            "Medium+"
        ),

        ConnectionPuzzle(143,
            listOf("ROOT","POWER","SQUARE","CUBE","SECOND","MINUTE","HOUR","DAY","DOG","CAT","BIRD","FISH","LEFT","RIGHT","UP","DOWN"),
            listOf(
                ConnectionCategory("Math Functions", setOf("ROOT","POWER","SQUARE","CUBE"), CategoryColor.YELLOW),
                ConnectionCategory("Time Units", setOf("SECOND","MINUTE","HOUR","DAY"), CategoryColor.GREEN),
                ConnectionCategory("Pets", setOf("DOG","CAT","BIRD","FISH"), CategoryColor.BLUE),
                ConnectionCategory("Directions", setOf("LEFT","RIGHT","UP","DOWN"), CategoryColor.PURPLE)
            ),
            "Medium+"
        ),

        ConnectionPuzzle(144,
            listOf("LINE","RAY","ANGLE","PLANE","ADD","SUB","MUL","DIV","SUN","MOON","STAR","SKY","PEN","PENCIL","MARKER","CHALK"),
            listOf(
                ConnectionCategory("Geometry Terms", setOf("LINE","RAY","ANGLE","PLANE"), CategoryColor.YELLOW),
                ConnectionCategory("Math Operations", setOf("ADD","SUB","MUL","DIV"), CategoryColor.GREEN),
                ConnectionCategory("Sky Objects", setOf("SUN","MOON","STAR","SKY"), CategoryColor.BLUE),
                ConnectionCategory("Writing Tools", setOf("PEN","PENCIL","MARKER","CHALK"), CategoryColor.PURPLE)
            ),
            "Medium+"
        ),

        ConnectionPuzzle(145,
            listOf("FRACTION","DECIMAL","PERCENT","RATIO","CAR","BUS","TRAIN","PLANE","SPRING","SUMMER","FALL","WINTER","HAND","FOOT","ARM","LEG"),
            listOf(
                ConnectionCategory("Math Representations", setOf("FRACTION","DECIMAL","PERCENT","RATIO"), CategoryColor.YELLOW),
                ConnectionCategory("Transport", setOf("CAR","BUS","TRAIN","PLANE"), CategoryColor.GREEN),
                ConnectionCategory("Seasons", setOf("SPRING","SUMMER","FALL","WINTER"), CategoryColor.BLUE),
                ConnectionCategory("Body Parts", setOf("HAND","FOOT","ARM","LEG"), CategoryColor.PURPLE)
            ),
            "Medium+"
        ),

        ConnectionPuzzle(146,
            listOf("PRIME","FACTOR","MULTIPLE","DIVISOR","LOGIN","LOGOUT","UPLOAD","DOWNLOAD","RED","GREEN","BLUE","YELLOW","MILK","WATER","TEA","JUICE"),
            listOf(
                ConnectionCategory("Number Theory", setOf("PRIME","FACTOR","MULTIPLE","DIVISOR"), CategoryColor.YELLOW),
                ConnectionCategory("System Actions", setOf("LOGIN","LOGOUT","UPLOAD","DOWNLOAD"), CategoryColor.GREEN),
                ConnectionCategory("Colors", setOf("RED","GREEN","BLUE","YELLOW"), CategoryColor.BLUE),
                ConnectionCategory("Drinks", setOf("MILK","WATER","TEA","JUICE"), CategoryColor.PURPLE)
            ),
            "Medium+"
        ),

        ConnectionPuzzle(147,
            listOf("AREA","VOLUME","SPEED","TIME","ONE","TEN","HUNDRED","THOUSAND","DOG","CAT","FOX","WOLF","CHAIR","TABLE","BED","SOFA"),
            listOf(
                ConnectionCategory("Physics Quantities", setOf("AREA","VOLUME","SPEED","TIME"), CategoryColor.YELLOW),
                ConnectionCategory("Number Scales", setOf("ONE","TEN","HUNDRED","THOUSAND"), CategoryColor.GREEN),
                ConnectionCategory("Animals", setOf("DOG","CAT","FOX","WOLF"), CategoryColor.BLUE),
                ConnectionCategory("Furniture", setOf("CHAIR","TABLE","BED","SOFA"), CategoryColor.PURPLE)
            ),
            "Medium+"
        ),

        ConnectionPuzzle(148,
            listOf("EVEN","ODD","ZERO","ONE","ADD","PLUS","SUM","TOTAL","SUN","RAIN","SNOW","WIND","BOOK","PAGE","NOTE","WORD"),
            listOf(
                ConnectionCategory("Number Words", setOf("EVEN","ODD","ZERO","ONE"), CategoryColor.YELLOW),
                ConnectionCategory("Addition Words", setOf("ADD","PLUS","SUM","TOTAL"), CategoryColor.GREEN),
                ConnectionCategory("Weather", setOf("SUN","RAIN","SNOW","WIND"), CategoryColor.BLUE),
                ConnectionCategory("Writing Terms", setOf("BOOK","PAGE","NOTE","WORD"), CategoryColor.PURPLE)
            ),
            "Medium+"
        ),

        ConnectionPuzzle(149,
            listOf("ROOT","POWER","SQUARE","CUBE","CAR","TRUCK","BUS","VAN","RED","BLACK","WHITE","GRAY","DOG","CAT","BIRD","FISH"),
            listOf(
                ConnectionCategory("Math Functions", setOf("ROOT","POWER","SQUARE","CUBE"), CategoryColor.YELLOW),
                ConnectionCategory("Vehicles", setOf("CAR","TRUCK","BUS","VAN"), CategoryColor.GREEN),
                ConnectionCategory("Neutral Colors", setOf("RED","BLACK","WHITE","GRAY"), CategoryColor.BLUE),
                ConnectionCategory("Pets", setOf("DOG","CAT","BIRD","FISH"), CategoryColor.PURPLE)
            ),
            "Medium+"
        ),

        ConnectionPuzzle(150,
            listOf("FRACTION","DECIMAL","PERCENT","RATIO","LINE","RAY","ANGLE","POINT","SUN","MOON","STAR","PLANET","APPLE","BANANA","ORANGE","GRAPE"),
            listOf(
                ConnectionCategory("Math Representations", setOf("FRACTION","DECIMAL","PERCENT","RATIO"), CategoryColor.YELLOW),
                ConnectionCategory("Geometry Basics", setOf("LINE","RAY","ANGLE","POINT"), CategoryColor.GREEN),
                ConnectionCategory("Space Objects", setOf("SUN","MOON","STAR","PLANET"), CategoryColor.BLUE),
                ConnectionCategory("Fruits", setOf("APPLE","BANANA","ORANGE","GRAPE"), CategoryColor.PURPLE)
            ),
            "Medium+"
        ),

        ConnectionPuzzle(151,
            listOf("FACTORIAL","EXPONENT","LOGARITHM","ROOT",
                "INPUT","PROCESS","OUTPUT","FEEDBACK",
                "SEED","SPROUT","PLANT","TREE",
                "ORE","INGOT","ALLOY","STEEL"),
            listOf(
                ConnectionCategory("Advanced Math Functions", setOf("FACTORIAL","EXPONENT","LOGARITHM","ROOT"), CategoryColor.YELLOW),
                ConnectionCategory("System Cycle", setOf("INPUT","PROCESS","OUTPUT","FEEDBACK"), CategoryColor.GREEN),
                ConnectionCategory("Plant Growth Stages", setOf("SEED","SPROUT","PLANT","TREE"), CategoryColor.BLUE),
                ConnectionCategory("Metal Processing", setOf("ORE","INGOT","ALLOY","STEEL"), CategoryColor.PURPLE)
            ),
            "Hard"
        ),

        ConnectionPuzzle(152,
            listOf("INTEGER","RATIONAL","IRRATIONAL","REAL",
                "PUSH","POP","PEEK","STACK",
                "SOURCE","RIVER","DELTA","SEA",
                "IDEA","PLAN","DESIGN","BUILD"),
            listOf(
                ConnectionCategory("Number Sets", setOf("INTEGER","RATIONAL","IRRATIONAL","REAL"), CategoryColor.YELLOW),
                ConnectionCategory("Stack Operations", setOf("PUSH","POP","PEEK","STACK"), CategoryColor.GREEN),
                ConnectionCategory("River System", setOf("SOURCE","RIVER","DELTA","SEA"), CategoryColor.BLUE),
                ConnectionCategory("Creation Stages", setOf("IDEA","PLAN","DESIGN","BUILD"), CategoryColor.PURPLE)
            ),
            "Hard"
        ),

        ConnectionPuzzle(153,
            listOf("THEOREM","PROOF","LEMMA","COROLLARY",
                "LOGIN","SESSION","TOKEN","AUTH",
                "PRODUCER","CONSUMER","QUEUE","BUFFER",
                "SCRIPT","ACT","SCENE","PLAY"),
            listOf(
                ConnectionCategory("Mathematical Reasoning", setOf("THEOREM","PROOF","LEMMA","COROLLARY"), CategoryColor.YELLOW),
                ConnectionCategory("Authentication Flow", setOf("LOGIN","SESSION","TOKEN","AUTH"), CategoryColor.GREEN),
                ConnectionCategory("Concurrency Model", setOf("PRODUCER","CONSUMER","QUEUE","BUFFER"), CategoryColor.BLUE),
                ConnectionCategory("Drama Structure", setOf("SCRIPT","ACT","SCENE","PLAY"), CategoryColor.PURPLE)
            ),
            "Hard"
        ),

        ConnectionPuzzle(154,
            listOf("VECTOR","MATRIX","SCALAR","TENSOR",
                "FETCH","DECODE","EXECUTE","WRITEBACK",
                "BUDGET","EXPENSE","PROFIT","LOSS",
                "WORD","PHRASE","SENTENCE","PARAGRAPH"),
            listOf(
                ConnectionCategory("Linear Algebra", setOf("VECTOR","MATRIX","SCALAR","TENSOR"), CategoryColor.YELLOW),
                ConnectionCategory("CPU Instruction Cycle", setOf("FETCH","DECODE","EXECUTE","WRITEBACK"), CategoryColor.GREEN),
                ConnectionCategory("Finance Terms", setOf("BUDGET","EXPENSE","PROFIT","LOSS"), CategoryColor.BLUE),
                ConnectionCategory("Language Structure", setOf("WORD","PHRASE","SENTENCE","PARAGRAPH"), CategoryColor.PURPLE)
            ),
            "Hard"
        ),

        ConnectionPuzzle(155,
            listOf("MEAN","MEDIAN","MODE","RANGE",
                "THREAD","PROCESS","DEADLOCK","STARVATION",
                "SOURCE","COMPILE","LINK","EXECUTE",
                "SEED","SOIL","WATER","SUN"),
            listOf(
                ConnectionCategory("Statistics Measures", setOf("MEAN","MEDIAN","MODE","RANGE"), CategoryColor.YELLOW),
                ConnectionCategory("OS Concepts", setOf("THREAD","PROCESS","DEADLOCK","STARVATION"), CategoryColor.GREEN),
                ConnectionCategory("Program Lifecycle", setOf("SOURCE","COMPILE","LINK","EXECUTE"), CategoryColor.BLUE),
                ConnectionCategory("Plant Requirements", setOf("SEED","SOIL","WATER","SUN"), CategoryColor.PURPLE)
            ),
            "Hard"
        ),

        ConnectionPuzzle(156,
            listOf("DERIVATIVE","INTEGRAL","LIMIT","FUNCTION",
                "CLIENT","SERVER","REQUEST","RESPONSE",
                "INTRO","BODY","CONCLUSION","ESSAY",
                "INPUT","FILTER","TRANSFORM","OUTPUT"),
            listOf(
                ConnectionCategory("Calculus Concepts", setOf("DERIVATIVE","INTEGRAL","LIMIT","FUNCTION"), CategoryColor.YELLOW),
                ConnectionCategory("Web Architecture", setOf("CLIENT","SERVER","REQUEST","RESPONSE"), CategoryColor.GREEN),
                ConnectionCategory("Essay Structure", setOf("INTRO","BODY","CONCLUSION","ESSAY"), CategoryColor.BLUE),
                ConnectionCategory("Data Pipeline", setOf("INPUT","FILTER","TRANSFORM","OUTPUT"), CategoryColor.PURPLE)
            ),
            "Hard"
        ),

        ConnectionPuzzle(157,
            listOf("PRIME","COPRIME","COMPOSITE","DIVISIBLE",
                "ENQUEUE","DEQUEUE","FRONT","REAR",
                "IDEA","DRAFT","EDIT","PUBLISH",
                "CLOUD","RAIN","RUNOFF","OCEAN"),
            listOf(
                ConnectionCategory("Divisibility Concepts", setOf("PRIME","COPRIME","COMPOSITE","DIVISIBLE"), CategoryColor.YELLOW),
                ConnectionCategory("Queue Operations", setOf("ENQUEUE","DEQUEUE","FRONT","REAR"), CategoryColor.GREEN),
                ConnectionCategory("Writing Process", setOf("IDEA","DRAFT","EDIT","PUBLISH"), CategoryColor.BLUE),
                ConnectionCategory("Water Cycle Flow", setOf("CLOUD","RAIN","RUNOFF","OCEAN"), CategoryColor.PURPLE)
            ),
            "Hard"
        ),

        ConnectionPuzzle(158,
            listOf("AXIOM","POSTULATE","DEFINITION","THEORY",
                "NODE","EDGE","GRAPH","PATH",
                "INPUT","VALIDATE","SAVE","CONFIRM",
                "SCRIPT","DIRECT","ACT","FILM"),
            listOf(
                ConnectionCategory("Foundations of Logic", setOf("AXIOM","POSTULATE","DEFINITION","THEORY"), CategoryColor.YELLOW),
                ConnectionCategory("Graph Theory", setOf("NODE","EDGE","GRAPH","PATH"), CategoryColor.GREEN),
                ConnectionCategory("Form Submission Flow", setOf("INPUT","VALIDATE","SAVE","CONFIRM"), CategoryColor.BLUE),
                ConnectionCategory("Movie Production", setOf("SCRIPT","DIRECT","ACT","FILM"), CategoryColor.PURPLE)
            ),
            "Hard"
        ),

        ConnectionPuzzle(159,
            listOf("VARIABLE","CONSTANT","PARAMETER","EXPRESSION",
                "CACHE","HIT","MISS","MEMORY",
                "BIRTH","GROWTH","PEAK","DECLINE",
                "QUERY","FILTER","SORT","RESULT"),
            listOf(
                ConnectionCategory("Programming Concepts", setOf("VARIABLE","CONSTANT","PARAMETER","EXPRESSION"), CategoryColor.YELLOW),
                ConnectionCategory("Caching System", setOf("CACHE","HIT","MISS","MEMORY"), CategoryColor.GREEN),
                ConnectionCategory("Lifecycle Phases", setOf("BIRTH","GROWTH","PEAK","DECLINE"), CategoryColor.BLUE),
                ConnectionCategory("Data Query Steps", setOf("QUERY","FILTER","SORT","RESULT"), CategoryColor.PURPLE)
            ),
            "Hard"
        ),

        ConnectionPuzzle(160,
            listOf("INTEGER","FLOAT","DOUBLE","BOOLEAN",
                "PARSE","VALIDATE","STORE","RETRIEVE",
                "IDEA","MODEL","PROTOTYPE","PRODUCT",
                "INTRO","RISING","CLIMAX","RESOLUTION"),
            listOf(
                ConnectionCategory("Data Types", setOf("INTEGER","FLOAT","DOUBLE","BOOLEAN"), CategoryColor.YELLOW),
                ConnectionCategory("Data Handling Flow", setOf("PARSE","VALIDATE","STORE","RETRIEVE"), CategoryColor.GREEN),
                ConnectionCategory("Product Development", setOf("IDEA","MODEL","PROTOTYPE","PRODUCT"), CategoryColor.BLUE),
                ConnectionCategory("Story Arc", setOf("INTRO","RISING","CLIMAX","RESOLUTION"), CategoryColor.PURPLE)
            ),
            "Hard"
        ),

        ConnectionPuzzle(161,
            listOf("SYMMETRY","ROTATION","REFLECTION","TRANSLATION",
                "CLIENT","REQUEST","SERVER","RESPONSE",
                "OUTLINE","DRAFT","REVISE","FINAL",
                "SOURCE","STREAM","RIVER","OCEAN"),
            listOf(
                ConnectionCategory("Geometric Transformations", setOf("SYMMETRY","ROTATION","REFLECTION","TRANSLATION"), CategoryColor.YELLOW),
                ConnectionCategory("Web Request Cycle", setOf("CLIENT","REQUEST","SERVER","RESPONSE"), CategoryColor.GREEN),
                ConnectionCategory("Writing Stages", setOf("OUTLINE","DRAFT","REVISE","FINAL"), CategoryColor.BLUE),
                ConnectionCategory("Water Flow", setOf("SOURCE","STREAM","RIVER","OCEAN"), CategoryColor.PURPLE)
            ),
            "Hard"
        ),

        ConnectionPuzzle(162,
            listOf("LATITUDE","LONGITUDE","EQUATOR","MERIDIAN",
                "TOKEN","SESSION","COOKIE","CACHE",
                "SEED","GERMINATE","GROW","HARVEST",
                "IDEA","SCRIPT","SHOOT","EDIT"),
            listOf(
                ConnectionCategory("Geographic Coordinates", setOf("LATITUDE","LONGITUDE","EQUATOR","MERIDIAN"), CategoryColor.YELLOW),
                ConnectionCategory("Web State Management", setOf("TOKEN","SESSION","COOKIE","CACHE"), CategoryColor.GREEN),
                ConnectionCategory("Plant Lifecycle", setOf("SEED","GERMINATE","GROW","HARVEST"), CategoryColor.BLUE),
                ConnectionCategory("Film Production", setOf("IDEA","SCRIPT","SHOOT","EDIT"), CategoryColor.PURPLE)
            ),
            "Hard"
        ),

        ConnectionPuzzle(163,
            listOf("AXIS","ORIGIN","QUADRANT","PLANE",
                "ENCRYPT","HASH","VERIFY","AUTH",
                "PROBLEM","ANALYSIS","SOLUTION","REVIEW",
                "IGNITION","THRUST","ORBIT","LANDING"),
            listOf(
                ConnectionCategory("Coordinate Geometry", setOf("AXIS","ORIGIN","QUADRANT","PLANE"), CategoryColor.YELLOW),
                ConnectionCategory("Security Flow", setOf("ENCRYPT","HASH","VERIFY","AUTH"), CategoryColor.GREEN),
                ConnectionCategory("Problem Solving Steps", setOf("PROBLEM","ANALYSIS","SOLUTION","REVIEW"), CategoryColor.BLUE),
                ConnectionCategory("Space Mission Phases", setOf("IGNITION","THRUST","ORBIT","LANDING"), CategoryColor.PURPLE)
            ),
            "Hard"
        ),

        ConnectionPuzzle(164,
            listOf("MEAN","VARIANCE","STDDEV","DISTRIBUTION",
                "NODE","EDGE","TREE","GRAPH",
                "PITCH","TONE","RHYTHM","HARMONY",
                "PLAN","BUDGET","EXECUTE","AUDIT"),
            listOf(
                ConnectionCategory("Statistics Concepts", setOf("MEAN","VARIANCE","STDDEV","DISTRIBUTION"), CategoryColor.YELLOW),
                ConnectionCategory("Graph Structures", setOf("NODE","EDGE","TREE","GRAPH"), CategoryColor.GREEN),
                ConnectionCategory("Music Elements", setOf("PITCH","TONE","RHYTHM","HARMONY"), CategoryColor.BLUE),
                ConnectionCategory("Project Lifecycle", setOf("PLAN","BUDGET","EXECUTE","AUDIT"), CategoryColor.PURPLE)
            ),
            "Hard"
        ),

        ConnectionPuzzle(165,
            listOf("LIMIT","CONTINUITY","DERIVATIVE","INTEGRAL",
                "COMMIT","PUSH","MERGE","DEPLOY",
                "INTRO","CONFLICT","CLIMAX","RESOLUTION",
                "SEED","ROOT","TRUNK","BRANCH"),
            listOf(
                ConnectionCategory("Calculus Foundations", setOf("LIMIT","CONTINUITY","DERIVATIVE","INTEGRAL"), CategoryColor.YELLOW),
                ConnectionCategory("Version Control Flow", setOf("COMMIT","PUSH","MERGE","DEPLOY"), CategoryColor.GREEN),
                ConnectionCategory("Narrative Arc", setOf("INTRO","CONFLICT","CLIMAX","RESOLUTION"), CategoryColor.BLUE),
                ConnectionCategory("Tree Structure", setOf("SEED","ROOT","TRUNK","BRANCH"), CategoryColor.PURPLE)
            ),
            "Hard"
        ),

        ConnectionPuzzle(166,
            listOf("SCALAR","VECTOR","MATRIX","TENSOR",
                "FETCH","QUEUE","EXECUTE","COMPLETE",
                "IDEA","SKETCH","MODEL","PROTOTYPE",
                "SOURCE","CHANNEL","SIGNAL","RECEIVER"),
            listOf(
                ConnectionCategory("Linear Algebra Objects", setOf("SCALAR","VECTOR","MATRIX","TENSOR"), CategoryColor.YELLOW),
                ConnectionCategory("Task Processing Flow", setOf("FETCH","QUEUE","EXECUTE","COMPLETE"), CategoryColor.GREEN),
                ConnectionCategory("Design Process", setOf("IDEA","SKETCH","MODEL","PROTOTYPE"), CategoryColor.BLUE),
                ConnectionCategory("Communication System", setOf("SOURCE","CHANNEL","SIGNAL","RECEIVER"), CategoryColor.PURPLE)
            ),
            "Hard"
        ),

        ConnectionPuzzle(167,
            listOf("INTEGER","RATIONAL","IRRATIONAL","REAL",
                "REQUEST","AUTHORIZE","PROCESS","RESPOND",
                "INPUT","CLEAN","TRANSFORM","STORE",
                "IGNITE","ACCELERATE","CRUISE","DECELERATE"),
            listOf(
                ConnectionCategory("Number Sets", setOf("INTEGER","RATIONAL","IRRATIONAL","REAL"), CategoryColor.YELLOW),
                ConnectionCategory("API Lifecycle", setOf("REQUEST","AUTHORIZE","PROCESS","RESPOND"), CategoryColor.GREEN),
                ConnectionCategory("Data Pipeline", setOf("INPUT","CLEAN","TRANSFORM","STORE"), CategoryColor.BLUE),
                ConnectionCategory("Motion Phases", setOf("IGNITE","ACCELERATE","CRUISE","DECELERATE"), CategoryColor.PURPLE)
            ),
            "Hard"
        ),

        ConnectionPuzzle(168,
            listOf("AXIOM","POSTULATE","LEMMA","THEOREM",
                "NODE","ROUTE","SWITCH","PACKET",
                "IDEA","VALIDATE","REFINE","RELEASE",
                "DEPOSIT","SEDIMENT","PRESSURE","ROCK"),
            listOf(
                ConnectionCategory("Mathematical Logic", setOf("AXIOM","POSTULATE","LEMMA","THEOREM"), CategoryColor.YELLOW),
                ConnectionCategory("Network Routing", setOf("NODE","ROUTE","SWITCH","PACKET"), CategoryColor.GREEN),
                ConnectionCategory("Product Refinement", setOf("IDEA","VALIDATE","REFINE","RELEASE"), CategoryColor.BLUE),
                ConnectionCategory("Rock Formation", setOf("DEPOSIT","SEDIMENT","PRESSURE","ROCK"), CategoryColor.PURPLE)
            ),
            "Hard"
        ),

        ConnectionPuzzle(169,
            listOf("VARIABLE","PARAMETER","ARGUMENT","RETURN",
                "CACHE","EVICT","MISS","HIT",
                "INTRO","RISING","CLIMAX","FALL",
                "SEED","SOIL","ROOT","PLANT"),
            listOf(
                ConnectionCategory("Function Components", setOf("VARIABLE","PARAMETER","ARGUMENT","RETURN"), CategoryColor.YELLOW),
                ConnectionCategory("Cache Behavior", setOf("CACHE","EVICT","MISS","HIT"), CategoryColor.GREEN),
                ConnectionCategory("Story Tension Curve", setOf("INTRO","RISING","CLIMAX","FALL"), CategoryColor.BLUE),
                ConnectionCategory("Plant Development", setOf("SEED","SOIL","ROOT","PLANT"), CategoryColor.PURPLE)
            ),
            "Hard"
        ),

        ConnectionPuzzle(170,
            listOf("BIT","BYTE","WORD","REGISTER",
                "DISCOVER","DESIGN","IMPLEMENT","TEST",
                "SOURCE","STREAM","DELTA","SEA",
                "IDEA","PILOT","LAUNCH","SCALE"),
            listOf(
                ConnectionCategory("Computer Memory Units", setOf("BIT","BYTE","WORD","REGISTER"), CategoryColor.YELLOW),
                ConnectionCategory("Software Development Cycle", setOf("DISCOVER","DESIGN","IMPLEMENT","TEST"), CategoryColor.GREEN),
                ConnectionCategory("River Progression", setOf("SOURCE","STREAM","DELTA","SEA"), CategoryColor.BLUE),
                ConnectionCategory("Business Growth Stages", setOf("IDEA","PILOT","LAUNCH","SCALE"), CategoryColor.PURPLE)
            ),
            "Hard"
        ),

        ConnectionPuzzle(171,
            listOf("SET","SUBSET","INTERSECTION","UNION",
                "QUEUE","PRIORITY","SCHEDULE","EXECUTE",
                "INTRO","BODY","CONCLUSION","ESSAY",
                "SEED","GERMINATE","SPROUT","PLANT"),
            listOf(
                ConnectionCategory("Set Theory", setOf("SET","SUBSET","INTERSECTION","UNION"), CategoryColor.YELLOW),
                ConnectionCategory("Task Scheduling", setOf("QUEUE","PRIORITY","SCHEDULE","EXECUTE"), CategoryColor.GREEN),
                ConnectionCategory("Essay Structure", setOf("INTRO","BODY","CONCLUSION","ESSAY"), CategoryColor.BLUE),
                ConnectionCategory("Plant Growth", setOf("SEED","GERMINATE","SPROUT","PLANT"), CategoryColor.PURPLE)
            ),
            "Hard"
        ),

        ConnectionPuzzle(172,
            listOf("DERIVATIVE","GRADIENT","SLOPE","TANGENT",
                "INPUT","VALIDATE","QUEUE","PROCESS",
                "IDEA","STORYBOARD","ANIMATE","RENDER",
                "IGNITION","ASCENT","ORBIT","REENTRY"),
            listOf(
                ConnectionCategory("Rate of Change", setOf("DERIVATIVE","GRADIENT","SLOPE","TANGENT"), CategoryColor.YELLOW),
                ConnectionCategory("Processing Pipeline", setOf("INPUT","VALIDATE","QUEUE","PROCESS"), CategoryColor.GREEN),
                ConnectionCategory("Animation Workflow", setOf("IDEA","STORYBOARD","ANIMATE","RENDER"), CategoryColor.BLUE),
                ConnectionCategory("Spaceflight Phases", setOf("IGNITION","ASCENT","ORBIT","REENTRY"), CategoryColor.PURPLE)
            ),
            "Hard"
        ),

        ConnectionPuzzle(173,
            listOf("INTEGER","FLOAT","DOUBLE","BOOLEAN",
                "PARSE","SANITIZE","STORE","RETRIEVE",
                "INTRO","MIDDLE","END","STORY",
                "SOURCE","CHANNEL","NOISE","RECEIVER"),
            listOf(
                ConnectionCategory("Data Types", setOf("INTEGER","FLOAT","DOUBLE","BOOLEAN"), CategoryColor.YELLOW),
                ConnectionCategory("Data Handling", setOf("PARSE","SANITIZE","STORE","RETRIEVE"), CategoryColor.GREEN),
                ConnectionCategory("Story Structure", setOf("INTRO","MIDDLE","END","STORY"), CategoryColor.BLUE),
                ConnectionCategory("Signal Transmission", setOf("SOURCE","CHANNEL","NOISE","RECEIVER"), CategoryColor.PURPLE)
            ),
            "Hard"
        ),

        ConnectionPuzzle(174,
            listOf("AXIS","ORIGIN","VECTOR","PLANE",
                "LOGIN","AUTHORIZE","ACCESS","LOGOUT",
                "IDEA","PITCH","FUND","SCALE",
                "RAIN","RUNOFF","RIVER","OCEAN"),
            listOf(
                ConnectionCategory("Vector Geometry", setOf("AXIS","ORIGIN","VECTOR","PLANE"), CategoryColor.YELLOW),
                ConnectionCategory("Access Control Flow", setOf("LOGIN","AUTHORIZE","ACCESS","LOGOUT"), CategoryColor.GREEN),
                ConnectionCategory("Startup Lifecycle", setOf("IDEA","PITCH","FUND","SCALE"), CategoryColor.BLUE),
                ConnectionCategory("Water Movement", setOf("RAIN","RUNOFF","RIVER","OCEAN"), CategoryColor.PURPLE)
            ),
            "Hard"
        ),

        ConnectionPuzzle(175,
            listOf("PROBABILITY","LIKELIHOOD","OUTCOME","EVENT",
                "NODE","EDGE","PATH","CYCLE",
                "INTRO","CONFLICT","CLIMAX","ENDING",
                "ORE","INGOT","ALLOY","PRODUCT"),
            listOf(
                ConnectionCategory("Probability Concepts", setOf("PROBABILITY","LIKELIHOOD","OUTCOME","EVENT"), CategoryColor.YELLOW),
                ConnectionCategory("Graph Traversal", setOf("NODE","EDGE","PATH","CYCLE"), CategoryColor.GREEN),
                ConnectionCategory("Story Plot", setOf("INTRO","CONFLICT","CLIMAX","ENDING"), CategoryColor.BLUE),
                ConnectionCategory("Manufacturing Stages", setOf("ORE","INGOT","ALLOY","PRODUCT"), CategoryColor.PURPLE)
            ),
            "Hard"
        ),

        ConnectionPuzzle(176,
            listOf("SET","MAP","LIST","QUEUE",
                "DISCOVER","DESIGN","BUILD","DEPLOY",
                "SOURCE","FILTER","TRANSFORM","OUTPUT",
                "SEED","ROOT","BRANCH","LEAF"),
            listOf(
                ConnectionCategory("Data Structures", setOf("SET","MAP","LIST","QUEUE"), CategoryColor.YELLOW),
                ConnectionCategory("Development Cycle", setOf("DISCOVER","DESIGN","BUILD","DEPLOY"), CategoryColor.GREEN),
                ConnectionCategory("Data Flow", setOf("SOURCE","FILTER","TRANSFORM","OUTPUT"), CategoryColor.BLUE),
                ConnectionCategory("Tree Anatomy", setOf("SEED","ROOT","BRANCH","LEAF"), CategoryColor.PURPLE)
            ),
            "Hard"
        ),

        ConnectionPuzzle(177,
            listOf("LIMIT","BOUND","RANGE","DOMAIN",
                "INPUT","ENCODE","TRANSMIT","DECODE",
                "IDEA","DRAFT","EDIT","PUBLISH",
                "IGNITION","THRUST","CRUISE","LAND"),
            listOf(
                ConnectionCategory("Function Properties", setOf("LIMIT","BOUND","RANGE","DOMAIN"), CategoryColor.YELLOW),
                ConnectionCategory("Communication Flow", setOf("INPUT","ENCODE","TRANSMIT","DECODE"), CategoryColor.GREEN),
                ConnectionCategory("Writing Workflow", setOf("IDEA","DRAFT","EDIT","PUBLISH"), CategoryColor.BLUE),
                ConnectionCategory("Flight Phases", setOf("IGNITION","THRUST","CRUISE","LAND"), CategoryColor.PURPLE)
            ),
            "Hard"
        ),

        ConnectionPuzzle(178,
            listOf("INTEGER","MODULUS","REMAINDER","DIVISOR",
                "QUEUE","STACK","HEAP","BUFFER",
                "INTRO","SETUP","PAYOFF","FINALE",
                "CLOUD","RAIN","RUNOFF","RIVER"),
            listOf(
                ConnectionCategory("Division Concepts", setOf("INTEGER","MODULUS","REMAINDER","DIVISOR"), CategoryColor.YELLOW),
                ConnectionCategory("Memory Structures", setOf("QUEUE","STACK","HEAP","BUFFER"), CategoryColor.GREEN),
                ConnectionCategory("Story Payoff", setOf("INTRO","SETUP","PAYOFF","FINALE"), CategoryColor.BLUE),
                ConnectionCategory("Water Cycle", setOf("CLOUD","RAIN","RUNOFF","RIVER"), CategoryColor.PURPLE)
            ),
            "Hard"
        ),

        ConnectionPuzzle(179,
            listOf("LOG","EXP","POWER","ROOT",
                "REQUEST","QUEUE","PROCESS","RESPOND",
                "IDEA","MODEL","PROTOTYPE","PRODUCT",
                "SOURCE","CHANNEL","SIGNAL","DESTINATION"),
            listOf(
                ConnectionCategory("Exponential Math", setOf("LOG","EXP","POWER","ROOT"), CategoryColor.YELLOW),
                ConnectionCategory("Request Handling", setOf("REQUEST","QUEUE","PROCESS","RESPOND"), CategoryColor.GREEN),
                ConnectionCategory("Product Creation", setOf("IDEA","MODEL","PROTOTYPE","PRODUCT"), CategoryColor.BLUE),
                ConnectionCategory("Signal Flow", setOf("SOURCE","CHANNEL","SIGNAL","DESTINATION"), CategoryColor.PURPLE)
            ),
            "Hard"
        ),

        ConnectionPuzzle(180,
            listOf("INTEGER","FLOAT","DOUBLE","STRING",
                "PARSE","VALIDATE","STORE","QUERY",
                "INTRO","BUILDUP","CLIMAX","RESOLVE",
                "SEED","SOIL","SPROUT","PLANT"),
            listOf(
                ConnectionCategory("Data Types", setOf("INTEGER","FLOAT","DOUBLE","STRING"), CategoryColor.YELLOW),
                ConnectionCategory("Data Processing", setOf("PARSE","VALIDATE","STORE","QUERY"), CategoryColor.GREEN),
                ConnectionCategory("Narrative Flow", setOf("INTRO","BUILDUP","CLIMAX","RESOLVE"), CategoryColor.BLUE),
                ConnectionCategory("Plant Growth", setOf("SEED","SOIL","SPROUT","PLANT"), CategoryColor.PURPLE)
            ),
            "Hard"
        ),

        ConnectionPuzzle(181,
            listOf("AXIOM","LEMMA","PROPOSITION","THEOREM",
                "NODE","EDGE","WEIGHT","PATH",
                "IDEA","PITCH","FUND","EXIT",
                "RAIN","RIVER","DELTA","SEA"),
            listOf(
                ConnectionCategory("Logical Foundations", setOf("AXIOM","LEMMA","PROPOSITION","THEOREM"), CategoryColor.YELLOW),
                ConnectionCategory("Weighted Graphs", setOf("NODE","EDGE","WEIGHT","PATH"), CategoryColor.GREEN),
                ConnectionCategory("Startup Journey", setOf("IDEA","PITCH","FUND","EXIT"), CategoryColor.BLUE),
                ConnectionCategory("River Lifecycle", setOf("RAIN","RIVER","DELTA","SEA"), CategoryColor.PURPLE)
            ),
            "Hard"
        ),

        ConnectionPuzzle(182,
            listOf("LIMIT","CONTINUITY","SMOOTHNESS","CURVATURE",
                "INPUT","BUFFER","QUEUE","PROCESS",
                "INTRO","ACT","SCENE","PLAY",
                "SOURCE","STREAM","CHANNEL","OUTPUT"),
            listOf(
                ConnectionCategory("Calculus Properties", setOf("LIMIT","CONTINUITY","SMOOTHNESS","CURVATURE"), CategoryColor.YELLOW),
                ConnectionCategory("Processing Flow", setOf("INPUT","BUFFER","QUEUE","PROCESS"), CategoryColor.GREEN),
                ConnectionCategory("Theater Structure", setOf("INTRO","ACT","SCENE","PLAY"), CategoryColor.BLUE),
                ConnectionCategory("Signal Output", setOf("SOURCE","STREAM","CHANNEL","OUTPUT"), CategoryColor.PURPLE)
            ),
            "Hard"
        ),

        ConnectionPuzzle(183,
            listOf("PRIME","COPRIME","FACTOR","DIVISOR",
                "REQUEST","AUTH","PROCESS","REPLY",
                "IDEA","DRAFT","REVIEW","FINAL",
                "SEED","ROOT","TRUNK","BRANCH"),
            listOf(
                ConnectionCategory("Number Relationships", setOf("PRIME","COPRIME","FACTOR","DIVISOR"), CategoryColor.YELLOW),
                ConnectionCategory("Request Lifecycle", setOf("REQUEST","AUTH","PROCESS","REPLY"), CategoryColor.GREEN),
                ConnectionCategory("Document Revision", setOf("IDEA","DRAFT","REVIEW","FINAL"), CategoryColor.BLUE),
                ConnectionCategory("Tree Growth", setOf("SEED","ROOT","TRUNK","BRANCH"), CategoryColor.PURPLE)
            ),
            "Hard"
        ),

        ConnectionPuzzle(184,
            listOf("VECTOR","MAGNITUDE","DIRECTION","COMPONENT",
                "NODE","ROUTE","HOP","DESTINATION",
                "INTRO","HOOK","BUILD","PAYOFF",
                "ORE","SMELT","ALLOY","PRODUCT"),
            listOf(
                ConnectionCategory("Vector Properties", setOf("VECTOR","MAGNITUDE","DIRECTION","COMPONENT"), CategoryColor.YELLOW),
                ConnectionCategory("Network Routing", setOf("NODE","ROUTE","HOP","DESTINATION"), CategoryColor.GREEN),
                ConnectionCategory("Story Hook", setOf("INTRO","HOOK","BUILD","PAYOFF"), CategoryColor.BLUE),
                ConnectionCategory("Metal Production", setOf("ORE","SMELT","ALLOY","PRODUCT"), CategoryColor.PURPLE)
            ),
            "Hard"
        ),

        ConnectionPuzzle(185,
            listOf("INTEGER","MODULUS","DIVISION","REMAINDER",
                "QUEUE","PRIORITY","EXECUTE","COMPLETE",
                "IDEA","MODEL","TEST","RELEASE",
                "RAIN","RUNOFF","RIVER","DELTA"),
            listOf(
                ConnectionCategory("Arithmetic Division", setOf("INTEGER","MODULUS","DIVISION","REMAINDER"), CategoryColor.YELLOW),
                ConnectionCategory("Task Execution", setOf("QUEUE","PRIORITY","EXECUTE","COMPLETE"), CategoryColor.GREEN),
                ConnectionCategory("Product Testing", setOf("IDEA","MODEL","TEST","RELEASE"), CategoryColor.BLUE),
                ConnectionCategory("Water Flow", setOf("RAIN","RUNOFF","RIVER","DELTA"), CategoryColor.PURPLE)
            ),
            "Hard"
        ),

        ConnectionPuzzle(186,
            listOf("LIMIT","DERIVATIVE","GRADIENT","CURVE",
                "INPUT","ENCODE","SEND","RECEIVE",
                "INTRO","RISING","TURN","CLIMAX",
                "SOURCE","FILTER","CHANNEL","OUTPUT"),
            listOf(
                ConnectionCategory("Calculus Change", setOf("LIMIT","DERIVATIVE","GRADIENT","CURVE"), CategoryColor.YELLOW),
                ConnectionCategory("Data Transmission", setOf("INPUT","ENCODE","SEND","RECEIVE"), CategoryColor.GREEN),
                ConnectionCategory("Story Turning Point", setOf("INTRO","RISING","TURN","CLIMAX"), CategoryColor.BLUE),
                ConnectionCategory("Signal Pipeline", setOf("SOURCE","FILTER","CHANNEL","OUTPUT"), CategoryColor.PURPLE)
            ),
            "Hard"
        ),

        ConnectionPuzzle(187,
            listOf("AXIOM","RULE","INFERENCE","CONCLUSION",
                "NODE","EDGE","CYCLE","TREE",
                "IDEA","PROTOTYPE","ITERATE","OPTIMIZE",
                "SEED","SPROUT","PLANT","HARVEST"),
            listOf(
                ConnectionCategory("Logical Reasoning", setOf("AXIOM","RULE","INFERENCE","CONCLUSION"), CategoryColor.YELLOW),
                ConnectionCategory("Graph Types", setOf("NODE","EDGE","CYCLE","TREE"), CategoryColor.GREEN),
                ConnectionCategory("Product Iteration", setOf("IDEA","PROTOTYPE","ITERATE","OPTIMIZE"), CategoryColor.BLUE),
                ConnectionCategory("Crop Cycle", setOf("SEED","SPROUT","PLANT","HARVEST"), CategoryColor.PURPLE)
            ),
            "Hard"
        ),

        ConnectionPuzzle(188,
            listOf("INTEGER","FLOAT","DOUBLE","BOOLEAN",
                "PARSE","FILTER","SORT","OUTPUT",
                "INTRO","MIDDLE","CLIMAX","END",
                "RAIN","RIVER","DELTA","OCEAN"),
            listOf(
                ConnectionCategory("Primitive Types", setOf("INTEGER","FLOAT","DOUBLE","BOOLEAN"), CategoryColor.YELLOW),
                ConnectionCategory("Data Transformation", setOf("PARSE","FILTER","SORT","OUTPUT"), CategoryColor.GREEN),
                ConnectionCategory("Story Progression", setOf("INTRO","MIDDLE","CLIMAX","END"), CategoryColor.BLUE),
                ConnectionCategory("River Path", setOf("RAIN","RIVER","DELTA","OCEAN"), CategoryColor.PURPLE)
            ),
            "Hard"
        ),

        ConnectionPuzzle(189,
            listOf("SET","ELEMENT","SUBSET","UNION",
                "REQUEST","QUEUE","PROCESS","REPLY",
                "IDEA","PLAN","EXECUTE","REVIEW",
                "SOURCE","SIGNAL","NOISE","RECEIVER"),
            listOf(
                ConnectionCategory("Set Concepts", setOf("SET","ELEMENT","SUBSET","UNION"), CategoryColor.YELLOW),
                ConnectionCategory("Message Handling", setOf("REQUEST","QUEUE","PROCESS","REPLY"), CategoryColor.GREEN),
                ConnectionCategory("Execution Cycle", setOf("IDEA","PLAN","EXECUTE","REVIEW"), CategoryColor.BLUE),
                ConnectionCategory("Signal Theory", setOf("SOURCE","SIGNAL","NOISE","RECEIVER"), CategoryColor.PURPLE)
            ),
            "Hard"
        ),

        ConnectionPuzzle(190,
            listOf("LOG","EXP","POWER","ROOT",
                "NODE","QUEUE","EXECUTE","COMPLETE",
                "INTRO","SETUP","CONFLICT","RESOLUTION",
                "SEED","ROOT","BRANCH","LEAF"),
            listOf(
                ConnectionCategory("Exponential Concepts", setOf("LOG","EXP","POWER","ROOT"), CategoryColor.YELLOW),
                ConnectionCategory("Task Flow", setOf("NODE","QUEUE","EXECUTE","COMPLETE"), CategoryColor.GREEN),
                ConnectionCategory("Plot Structure", setOf("INTRO","SETUP","CONFLICT","RESOLUTION"), CategoryColor.BLUE),
                ConnectionCategory("Tree Anatomy", setOf("SEED","ROOT","BRANCH","LEAF"), CategoryColor.PURPLE)
            ),
            "Hard"
        ),

        ConnectionPuzzle(191,
            listOf("INTEGER","MODULUS","DIVISOR","REMAINDER",
                "PARSE","VALIDATE","STORE","QUERY",
                "IDEA","DESIGN","BUILD","LAUNCH",
                "RAIN","RUNOFF","RIVER","SEA"),
            listOf(
                ConnectionCategory("Division Math", setOf("INTEGER","MODULUS","DIVISOR","REMAINDER"), CategoryColor.YELLOW),
                ConnectionCategory("Data Lifecycle", setOf("PARSE","VALIDATE","STORE","QUERY"), CategoryColor.GREEN),
                ConnectionCategory("Product Launch", setOf("IDEA","DESIGN","BUILD","LAUNCH"), CategoryColor.BLUE),
                ConnectionCategory("Water Journey", setOf("RAIN","RUNOFF","RIVER","SEA"), CategoryColor.PURPLE)
            ),
            "Hard"
        ),

        ConnectionPuzzle(192,
            listOf("AXIOM","POSTULATE","LEMMA","THEOREM",
                "NODE","EDGE","WEIGHT","GRAPH",
                "INTRO","BODY","CONCLUSION","ESSAY",
                "SOURCE","FILTER","CHANNEL","OUTPUT"),
            listOf(
                ConnectionCategory("Proof Structure", setOf("AXIOM","POSTULATE","LEMMA","THEOREM"), CategoryColor.YELLOW),
                ConnectionCategory("Weighted Graphs", setOf("NODE","EDGE","WEIGHT","GRAPH"), CategoryColor.GREEN),
                ConnectionCategory("Essay Parts", setOf("INTRO","BODY","CONCLUSION","ESSAY"), CategoryColor.BLUE),
                ConnectionCategory("Signal Processing", setOf("SOURCE","FILTER","CHANNEL","OUTPUT"), CategoryColor.PURPLE)
            ),
            "Hard"
        ),

        ConnectionPuzzle(193,
            listOf("VECTOR","DOT","CROSS","MAGNITUDE",
                "QUEUE","PRIORITY","SCHEDULE","RUN",
                "IDEA","SCRIPT","ACT","PERFORM",
                "SEED","GERMINATE","GROW","HARVEST"),
            listOf(
                ConnectionCategory("Vector Operations", setOf("VECTOR","DOT","CROSS","MAGNITUDE"), CategoryColor.YELLOW),
                ConnectionCategory("Scheduling System", setOf("QUEUE","PRIORITY","SCHEDULE","RUN"), CategoryColor.GREEN),
                ConnectionCategory("Performance Flow", setOf("IDEA","SCRIPT","ACT","PERFORM"), CategoryColor.BLUE),
                ConnectionCategory("Crop Lifecycle", setOf("SEED","GERMINATE","GROW","HARVEST"), CategoryColor.PURPLE)
            ),
            "Hard"
        ),

        ConnectionPuzzle(194,
            listOf("LIMIT","DERIVATIVE","INTEGRAL","CURVE",
                "REQUEST","AUTH","PROCESS","RESPOND",
                "INTRO","CONFLICT","CLIMAX","ENDING",
                "SOURCE","STREAM","DELTA","SEA"),
            listOf(
                ConnectionCategory("Calculus Tools", setOf("LIMIT","DERIVATIVE","INTEGRAL","CURVE"), CategoryColor.YELLOW),
                ConnectionCategory("API Request Flow", setOf("REQUEST","AUTH","PROCESS","RESPOND"), CategoryColor.GREEN),
                ConnectionCategory("Story Plot", setOf("INTRO","CONFLICT","CLIMAX","ENDING"), CategoryColor.BLUE),
                ConnectionCategory("River System", setOf("SOURCE","STREAM","DELTA","SEA"), CategoryColor.PURPLE)
            ),
            "Hard"
        ),

        ConnectionPuzzle(195,
            listOf("SET","MAP","LIST","TREE",
                "PARSE","FILTER","AGGREGATE","OUTPUT",
                "IDEA","PITCH","FUND","EXIT",
                "RAIN","RUNOFF","RIVER","DELTA"),
            listOf(
                ConnectionCategory("Data Structures", setOf("SET","MAP","LIST","TREE"), CategoryColor.YELLOW),
                ConnectionCategory("Data Processing", setOf("PARSE","FILTER","AGGREGATE","OUTPUT"), CategoryColor.GREEN),
                ConnectionCategory("Startup Stages", setOf("IDEA","PITCH","FUND","EXIT"), CategoryColor.BLUE),
                ConnectionCategory("Water Cycle", setOf("RAIN","RUNOFF","RIVER","DELTA"), CategoryColor.PURPLE)
            ),
            "Hard"
        ),

        ConnectionPuzzle(196,
            listOf("INTEGER","FLOAT","DOUBLE","STRING",
                "ENCODE","SEND","RECEIVE","DECODE",
                "INTRO","MIDDLE","TURN","END",
                "SEED","ROOT","TRUNK","BRANCH"),
            listOf(
                ConnectionCategory("Primitive Types", setOf("INTEGER","FLOAT","DOUBLE","STRING"), CategoryColor.YELLOW),
                ConnectionCategory("Communication Flow", setOf("ENCODE","SEND","RECEIVE","DECODE"), CategoryColor.GREEN),
                ConnectionCategory("Story Structure", setOf("INTRO","MIDDLE","TURN","END"), CategoryColor.BLUE),
                ConnectionCategory("Tree Growth", setOf("SEED","ROOT","TRUNK","BRANCH"), CategoryColor.PURPLE)
            ),
            "Hard"
        ),

        ConnectionPuzzle(197,
            listOf("AXIOM","RULE","INFERENCE","CONCLUSION",
                "NODE","EDGE","PATH","CYCLE",
                "IDEA","DESIGN","IMPLEMENT","TEST",
                "SOURCE","SIGNAL","NOISE","RECEIVER"),
            listOf(
                ConnectionCategory("Logical Deduction", setOf("AXIOM","RULE","INFERENCE","CONCLUSION"), CategoryColor.YELLOW),
                ConnectionCategory("Graph Theory", setOf("NODE","EDGE","PATH","CYCLE"), CategoryColor.GREEN),
                ConnectionCategory("Software Cycle", setOf("IDEA","DESIGN","IMPLEMENT","TEST"), CategoryColor.BLUE),
                ConnectionCategory("Signal System", setOf("SOURCE","SIGNAL","NOISE","RECEIVER"), CategoryColor.PURPLE)
            ),
            "Hard"
        ),

        ConnectionPuzzle(198,
            listOf("VECTOR","MATRIX","TENSOR","SCALAR",
                "QUEUE","STACK","HEAP","BUFFER",
                "INTRO","SETUP","PAYOFF","FINALE",
                "SEED","SPROUT","PLANT","HARVEST"),
            listOf(
                ConnectionCategory("Linear Algebra", setOf("VECTOR","MATRIX","TENSOR","SCALAR"), CategoryColor.YELLOW),
                ConnectionCategory("Memory Models", setOf("QUEUE","STACK","HEAP","BUFFER"), CategoryColor.GREEN),
                ConnectionCategory("Story Payoff", setOf("INTRO","SETUP","PAYOFF","FINALE"), CategoryColor.BLUE),
                ConnectionCategory("Agriculture Cycle", setOf("SEED","SPROUT","PLANT","HARVEST"), CategoryColor.PURPLE)
            ),
            "Hard"
        ),

        ConnectionPuzzle(199,
            listOf("LOG","EXP","POWER","ROOT",
                "REQUEST","QUEUE","EXECUTE","RESPOND",
                "IDEA","MODEL","PROTOTYPE","PRODUCT",
                "RAIN","RIVER","DELTA","SEA"),
            listOf(
                ConnectionCategory("Logarithmic Math", setOf("LOG","EXP","POWER","ROOT"), CategoryColor.YELLOW),
                ConnectionCategory("Request Processing", setOf("REQUEST","QUEUE","EXECUTE","RESPOND"), CategoryColor.GREEN),
                ConnectionCategory("Product Lifecycle", setOf("IDEA","MODEL","PROTOTYPE","PRODUCT"), CategoryColor.BLUE),
                ConnectionCategory("Water Flow", setOf("RAIN","RIVER","DELTA","SEA"), CategoryColor.PURPLE)
            ),
            "Hard"
        ),

        ConnectionPuzzle(200,
            listOf("SET","ELEMENT","SUBSET","UNION",
                "PARSE","VALIDATE","STORE","QUERY",
                "INTRO","CONFLICT","CLIMAX","RESOLUTION",
                "SOURCE","STREAM","DELTA","OCEAN"),
            listOf(
                ConnectionCategory("Set Theory", setOf("SET","ELEMENT","SUBSET","UNION"), CategoryColor.YELLOW),
                ConnectionCategory("Data Lifecycle", setOf("PARSE","VALIDATE","STORE","QUERY"), CategoryColor.GREEN),
                ConnectionCategory("Narrative Resolution", setOf("INTRO","CONFLICT","CLIMAX","RESOLUTION"), CategoryColor.BLUE),
                ConnectionCategory("River Endpoints", setOf("SOURCE","STREAM","DELTA","OCEAN"), CategoryColor.PURPLE)
            ),
            "Hard"
        )
    )
}
