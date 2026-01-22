package com.example.neuronest.connection

object ConnectionPuzzleDataPart1 {
    fun getPuzzles(): List<ConnectionPuzzle> = listOf(
        ConnectionPuzzle(
            1,
            listOf(
                "LION",
                "TIGER",
                "BEAR",
                "WOLF",
                "APPLE",
                "BANANA",
                "ORANGE",
                "GRAPE",
                "RED",
                "BLUE",
                "GREEN",
                "YELLOW",
                "ONE",
                "TWO",
                "THREE",
                "FOUR"
            ),
            listOf(
                ConnectionCategory(
                    "Animals",
                    setOf("LION", "TIGER", "BEAR", "WOLF"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Fruits",
                    setOf("APPLE", "BANANA", "ORANGE", "GRAPE"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Colors",
                    setOf("RED", "BLUE", "GREEN", "YELLOW"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Numbers",
                    setOf("ONE", "TWO", "THREE", "FOUR"),
                    CategoryColor.PURPLE
                )
            ),
            "Easy"
        ),

        ConnectionPuzzle(
            2,
            listOf(
                "CHAIR",
                "TABLE",
                "SOFA",
                "BED",
                "DOCTOR",
                "NURSE",
                "TEACHER",
                "ENGINEER",
                "MONDAY",
                "TUESDAY",
                "FRIDAY",
                "SUNDAY",
                "SPRING",
                "SUMMER",
                "FALL",
                "WINTER"
            ),
            listOf(
                ConnectionCategory(
                    "Furniture",
                    setOf("CHAIR", "TABLE", "SOFA", "BED"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Professions",
                    setOf("DOCTOR", "NURSE", "TEACHER", "ENGINEER"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Days",
                    setOf("MONDAY", "TUESDAY", "FRIDAY", "SUNDAY"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Seasons",
                    setOf("SPRING", "SUMMER", "FALL", "WINTER"),
                    CategoryColor.PURPLE
                )
            ),
            "Easy"
        ),

        ConnectionPuzzle(
            3,
            listOf(
                "DOG",
                "CAT",
                "FISH",
                "BIRD",
                "PEN",
                "PENCIL",
                "ERASER",
                "RULER",
                "CAR",
                "BUS",
                "TRAIN",
                "BIKE",
                "SUN",
                "MOON",
                "STAR",
                "SKY"
            ),
            listOf(
                ConnectionCategory(
                    "Pets",
                    setOf("DOG", "CAT", "FISH", "BIRD"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Stationery",
                    setOf("PEN", "PENCIL", "ERASER", "RULER"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Transport",
                    setOf("CAR", "BUS", "TRAIN", "BIKE"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Sky Objects",
                    setOf("SUN", "MOON", "STAR", "SKY"),
                    CategoryColor.PURPLE
                )
            ),
            "Easy"
        ),

        ConnectionPuzzle(
            4,
            listOf(
                "HAND",
                "FOOT",
                "HEAD",
                "ARM",
                "SOCCER",
                "CRICKET",
                "GOLF",
                "TENNIS",
                "BOOK",
                "PAPER",
                "PEN",
                "INK",
                "MILK",
                "WATER",
                "JUICE",
                "TEA"
            ),
            listOf(
                ConnectionCategory(
                    "Body Parts",
                    setOf("HAND", "FOOT", "HEAD", "ARM"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Sports",
                    setOf("SOCCER", "CRICKET", "GOLF", "TENNIS"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Writing Items",
                    setOf("BOOK", "PAPER", "PEN", "INK"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Drinks",
                    setOf("MILK", "WATER", "JUICE", "TEA"),
                    CategoryColor.PURPLE
                )
            ),
            "Easy"
        ),

        ConnectionPuzzle(
            5,
            listOf(
                "CIRCLE",
                "SQUARE",
                "TRIANGLE",
                "RECTANGLE",
                "GOLD",
                "SILVER",
                "IRON",
                "COPPER",
                "KING",
                "QUEEN",
                "JACK",
                "ACE",
                "EARTH",
                "MARS",
                "VENUS",
                "MERCURY"
            ),
            listOf(
                ConnectionCategory(
                    "Shapes",
                    setOf("CIRCLE", "SQUARE", "TRIANGLE", "RECTANGLE"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Metals",
                    setOf("GOLD", "SILVER", "IRON", "COPPER"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Cards",
                    setOf("KING", "QUEEN", "JACK", "ACE"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Planets",
                    setOf("EARTH", "MARS", "VENUS", "MERCURY"),
                    CategoryColor.PURPLE
                )
            ),
            "Easy"
        ),

        // ---------- MEDIUM (6–25) ----------
        ConnectionPuzzle(
            6,
            listOf(
                "ADD",
                "SUBTRACT",
                "MULTIPLY",
                "DIVIDE",
                "JAVA",
                "PYTHON",
                "KOTLIN",
                "SWIFT",
                "RED",
                "CYAN",
                "MAGENTA",
                "YELLOW",
                "NOSE",
                "EYE",
                "EAR",
                "HAND"
            ),
            listOf(
                ConnectionCategory(
                    "Math Operations",
                    setOf("ADD", "SUBTRACT", "MULTIPLY", "DIVIDE"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Programming Languages",
                    setOf("JAVA", "PYTHON", "KOTLIN", "SWIFT"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Printing Colors",
                    setOf("CYAN", "MAGENTA", "YELLOW", "RED"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Body Parts",
                    setOf("NOSE", "EYE", "EAR", "HAND"),
                    CategoryColor.PURPLE
                )
            ),
            "Medium"
        ),

        ConnectionPuzzle(
            7,
            listOf(
                "BIT",
                "BYTE",
                "CACHE",
                "STACK",
                "RUN",
                "JUMP",
                "PLAY",
                "WORK",
                "RAIN",
                "SNOW",
                "FOG",
                "WIND",
                "CUP",
                "PLATE",
                "SPOON",
                "BOWL"
            ),
            listOf(
                ConnectionCategory(
                    "Computer Terms",
                    setOf("BIT", "BYTE", "CACHE", "STACK"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Verbs",
                    setOf("RUN", "JUMP", "PLAY", "WORK"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Weather",
                    setOf("RAIN", "SNOW", "FOG", "WIND"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Kitchen Items",
                    setOf("CUP", "PLATE", "SPOON", "BOWL"),
                    CategoryColor.PURPLE
                )
            ),
            "Medium"
        ),

        ConnectionPuzzle(
            8,
            listOf(
                "ROME",
                "PARIS",
                "BERLIN",
                "MADRID",
                "MONDAY",
                "TUESDAY",
                "WEDNESDAY",
                "THURSDAY",
                "DOG",
                "WOLF",
                "FOX",
                "LION",
                "COTTON",
                "SILK",
                "WOOL",
                "LINEN"
            ),
            listOf(
                ConnectionCategory(
                    "European Capitals",
                    setOf("ROME", "PARIS", "BERLIN", "MADRID"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Weekdays",
                    setOf("MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Wild Animals",
                    setOf("DOG", "WOLF", "FOX", "LION"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Fabrics",
                    setOf("COTTON", "SILK", "WOOL", "LINEN"),
                    CategoryColor.PURPLE
                )
            ),
            "Medium"
        ),

        ConnectionPuzzle(
            9,
            listOf(
                "EVEN",
                "ODD",
                "PRIME",
                "COMPOSITE",
                "ONE",
                "TWO",
                "THREE",
                "FOUR",
                "RED",
                "BLUE",
                "GREEN",
                "BLACK",
                "CAR",
                "TRUCK",
                "BUS",
                "VAN"
            ),
            listOf(
                ConnectionCategory(
                    "Number Types",
                    setOf("EVEN", "ODD", "PRIME", "COMPOSITE"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Numbers",
                    setOf("ONE", "TWO", "THREE", "FOUR"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Colors",
                    setOf("RED", "BLUE", "GREEN", "BLACK"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Vehicles",
                    setOf("CAR", "TRUCK", "BUS", "VAN"),
                    CategoryColor.PURPLE
                )
            ),
            "Medium"
        ),

        ConnectionPuzzle(
            10,
            listOf(
                "BAT",
                "BALL",
                "GLOVE",
                "HELMET",
                "BANK",
                "LOAN",
                "INTEREST",
                "CREDIT",
                "MOUSE",
                "KEYBOARD",
                "SCREEN",
                "PRINTER",
                "HOUR",
                "MINUTE",
                "SECOND",
                "DAY"
            ),
            listOf(
                ConnectionCategory(
                    "Sports Gear",
                    setOf("BAT", "BALL", "GLOVE", "HELMET"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Finance Terms",
                    setOf("BANK", "LOAN", "INTEREST", "CREDIT"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Computer Hardware",
                    setOf("MOUSE", "KEYBOARD", "SCREEN", "PRINTER"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Time Units",
                    setOf("HOUR", "MINUTE", "SECOND", "DAY"),
                    CategoryColor.PURPLE
                )
            ),
            "Medium"
        ),

        ConnectionPuzzle(
            11,
            listOf(
                "APPLE",
                "WINDOW",
                "ANDROID",
                "LINUX",
                "DOG",
                "CAT",
                "HORSE",
                "COW",
                "PINK",
                "GRAY",
                "BROWN",
                "BLACK",
                "COLD",
                "HOT",
                "WARM",
                "COOL"
            ),
            listOf(
                ConnectionCategory(
                    "Operating Systems / Tech Brands",
                    setOf("APPLE", "WINDOW", "ANDROID", "LINUX"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Animals",
                    setOf("DOG", "CAT", "HORSE", "COW"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Colors",
                    setOf("PINK", "GRAY", "BROWN", "BLACK"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Temperature Words",
                    setOf("COLD", "HOT", "WARM", "COOL"),
                    CategoryColor.PURPLE
                )
            ),
            "Medium"
        ),

        ConnectionPuzzle(
            12,
            listOf(
                "RUN",
                "WALK",
                "JUMP",
                "SIT",
                "FORK",
                "KNIFE",
                "SPOON",
                "PLATE",
                "JANUARY",
                "FEBRUARY",
                "MARCH",
                "APRIL",
                "GUITAR",
                "DRUM",
                "PIANO",
                "FLUTE"
            ),
            listOf(
                ConnectionCategory(
                    "Actions",
                    setOf("RUN", "WALK", "JUMP", "SIT"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Cutlery",
                    setOf("FORK", "KNIFE", "SPOON", "PLATE"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Months",
                    setOf("JANUARY", "FEBRUARY", "MARCH", "APRIL"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Musical Instruments",
                    setOf("GUITAR", "DRUM", "PIANO", "FLUTE"),
                    CategoryColor.PURPLE
                )
            ),
            "Medium"
        ),

        ConnectionPuzzle(
            13,
            listOf(
                "EAST",
                "WEST",
                "NORTH",
                "SOUTH",
                "CLOUD",
                "RAIN",
                "SNOW",
                "STORM",
                "IRON",
                "GOLD",
                "SILVER",
                "COPPER",
                "CHAIR",
                "DESK",
                "BED",
                "SOFA"
            ),
            listOf(
                ConnectionCategory(
                    "Directions",
                    setOf("EAST", "WEST", "NORTH", "SOUTH"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Weather",
                    setOf("CLOUD", "RAIN", "SNOW", "STORM"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Metals",
                    setOf("IRON", "GOLD", "SILVER", "COPPER"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Furniture",
                    setOf("CHAIR", "DESK", "BED", "SOFA"),
                    CategoryColor.PURPLE
                )
            ),
            "Medium"
        ),

        ConnectionPuzzle(
            14,
            listOf(
                "EYE",
                "EAR",
                "NOSE",
                "TONGUE",
                "READ",
                "WRITE",
                "DRAW",
                "PAINT",
                "BIT",
                "BYTE",
                "PIXEL",
                "FRAME",
                "CAR",
                "SHIP",
                "PLANE",
                "TRAIN"
            ),
            listOf(
                ConnectionCategory(
                    "Sense Organs",
                    setOf("EYE", "EAR", "NOSE", "TONGUE"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Creative Actions",
                    setOf("READ", "WRITE", "DRAW", "PAINT"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Digital Units",
                    setOf("BIT", "BYTE", "PIXEL", "FRAME"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Transport",
                    setOf("CAR", "SHIP", "PLANE", "TRAIN"),
                    CategoryColor.PURPLE
                )
            ),
            "Medium"
        ),

        ConnectionPuzzle(
            15,
            listOf(
                "SALT",
                "SUGAR",
                "PEPPER",
                "SPICE",
                "KING",
                "QUEEN",
                "PRINCE",
                "PRINCESS",
                "CIRCLE",
                "CUBE",
                "SPHERE",
                "CONE",
                "JAVA",
                "KOTLIN",
                "SWIFT",
                "PYTHON"
            ),
            listOf(
                ConnectionCategory(
                    "Seasonings",
                    setOf("SALT", "SUGAR", "PEPPER", "SPICE"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Royal Titles",
                    setOf("KING", "QUEEN", "PRINCE", "PRINCESS"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "3D Shapes",
                    setOf("CIRCLE", "CUBE", "SPHERE", "CONE"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Programming Languages",
                    setOf("JAVA", "KOTLIN", "SWIFT", "PYTHON"),
                    CategoryColor.PURPLE
                )
            ),
            "Medium"
        ),

        // ---------- MEDIUM+ (16–20) ----------
        ConnectionPuzzle(
            16,
            listOf(
                "EVEN",
                "ODD",
                "PRIME",
                "FACTOR",
                "ADD",
                "SUB",
                "MUL",
                "DIV",
                "RED",
                "GREEN",
                "BLUE",
                "YELLOW",
                "DOG",
                "CAT",
                "MOUSE",
                "HORSE"
            ),
            listOf(
                ConnectionCategory(
                    "Number Properties",
                    setOf("EVEN", "ODD", "PRIME", "FACTOR"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Math Operations (Short)",
                    setOf("ADD", "SUB", "MUL", "DIV"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Colors",
                    setOf("RED", "GREEN", "BLUE", "YELLOW"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Animals",
                    setOf("DOG", "CAT", "MOUSE", "HORSE"),
                    CategoryColor.PURPLE
                )
            ),
            "Medium+"
        ),

        ConnectionPuzzle(
            17,
            listOf(
                "LOGIN",
                "LOGOUT",
                "UPLOAD",
                "DOWNLOAD",
                "FIRE",
                "WATER",
                "AIR",
                "EARTH",
                "MONDAY",
                "WEDNESDAY",
                "FRIDAY",
                "SUNDAY",
                "PEN",
                "PENCIL",
                "MARKER",
                "CHALK"
            ),
            listOf(
                ConnectionCategory(
                    "Computer Actions",
                    setOf("LOGIN", "LOGOUT", "UPLOAD", "DOWNLOAD"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Elements",
                    setOf("FIRE", "WATER", "AIR", "EARTH"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Days",
                    setOf("MONDAY", "WEDNESDAY", "FRIDAY", "SUNDAY"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Writing Tools",
                    setOf("PEN", "PENCIL", "MARKER", "CHALK"),
                    CategoryColor.PURPLE
                )
            ),
            "Medium+"
        ),

        ConnectionPuzzle(
            18,
            listOf(
                "SQUARE",
                "CUBE",
                "POWER",
                "ROOT",
                "NOON",
                "MIDNIGHT",
                "DAWN",
                "DUSK",
                "BITCOIN",
                "ETHEREUM",
                "DOGE",
                "LITECOIN",
                "CARROT",
                "POTATO",
                "ONION",
                "TOMATO"
            ),
            listOf(
                ConnectionCategory(
                    "Math Terms",
                    setOf("SQUARE", "CUBE", "POWER", "ROOT"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Times of Day",
                    setOf("NOON", "MIDNIGHT", "DAWN", "DUSK"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Cryptocurrencies",
                    setOf("BITCOIN", "ETHEREUM", "DOGE", "LITECOIN"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Vegetables",
                    setOf("CARROT", "POTATO", "ONION", "TOMATO"),
                    CategoryColor.PURPLE
                )
            ),
            "Medium+"
        ),

        ConnectionPuzzle(
            19,
            listOf(
                "FAST",
                "SLOW",
                "HEAVY",
                "LIGHT",
                "ATOM",
                "CELL",
                "MOLECULE",
                "TISSUE",
                "BUY",
                "SELL",
                "RENT",
                "LEASE",
                "EARTH",
                "MARS",
                "JUPITER",
                "SATURN"
            ),
            listOf(
                ConnectionCategory(
                    "Opposite Descriptors",
                    setOf("FAST", "SLOW", "HEAVY", "LIGHT"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Biology Units",
                    setOf("ATOM", "CELL", "MOLECULE", "TISSUE"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Commerce Actions",
                    setOf("BUY", "SELL", "RENT", "LEASE"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Planets",
                    setOf("EARTH", "MARS", "JUPITER", "SATURN"),
                    CategoryColor.PURPLE
                )
            ),
            "Medium+"
        ),

        ConnectionPuzzle(
            20,
            listOf(
                "LINE",
                "RAY",
                "ANGLE",
                "PLANE",
                "RAM",
                "ROM",
                "CPU",
                "GPU",
                "SUM",
                "AVERAGE",
                "MEDIAN",
                "MODE",
                "FORK",
                "SPOON",
                "KNIFE",
                "PLATE"
            ),
            listOf(
                ConnectionCategory(
                    "Geometry Terms",
                    setOf("LINE", "RAY", "ANGLE", "PLANE"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Computer Hardware",
                    setOf("RAM", "ROM", "CPU", "GPU"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Statistics Terms",
                    setOf("SUM", "AVERAGE", "MEDIAN", "MODE"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Dining Items",
                    setOf("FORK", "SPOON", "KNIFE", "PLATE"),
                    CategoryColor.PURPLE
                )
            ),
            "Medium+"
        ),

        // ---------- HARD-LEANING (21–25) ----------
        ConnectionPuzzle(
            21,
            listOf(
                "BAT",
                "CLUB",
                "RACKET",
                "STICK",
                "JAVA",
                "PYTHON",
                "KOTLIN",
                "RUST",
                "BANK",
                "LOAN",
                "CREDIT",
                "INTEREST",
                "FILE",
                "FOLDER",
                "PATH",
                "ROOT"
            ),
            listOf(
                ConnectionCategory(
                    "Sports Equipment",
                    setOf("BAT", "CLUB", "RACKET", "STICK"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Programming Languages",
                    setOf("JAVA", "PYTHON", "KOTLIN", "RUST"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Finance Terms",
                    setOf("BANK", "LOAN", "CREDIT", "INTEREST"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "File System Terms",
                    setOf("FILE", "FOLDER", "PATH", "ROOT"),
                    CategoryColor.PURPLE
                )
            ),
            "Hard"
        ),

        ConnectionPuzzle(
            22,
            listOf(
                "PRIME",
                "EVEN",
                "ODD",
                "SQUARE",
                "RUN",
                "PLAY",
                "WATCH",
                "WORK",
                "RED",
                "GREEN",
                "BLUE",
                "CYAN",
                "DOG",
                "FOX",
                "WOLF",
                "CAT"
            ),
            listOf(
                ConnectionCategory(
                    "Number Types",
                    setOf("PRIME", "EVEN", "ODD", "SQUARE"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Verbs",
                    setOf("RUN", "PLAY", "WATCH", "WORK"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "RGB/CMY Colors",
                    setOf("RED", "GREEN", "BLUE", "CYAN"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Animals",
                    setOf("DOG", "FOX", "WOLF", "CAT"),
                    CategoryColor.PURPLE
                )
            ),
            "Hard"
        ),

        ConnectionPuzzle(
            23,
            listOf(
                "SINE",
                "COSINE",
                "TANGENT",
                "SECANT",
                "BYTE",
                "KILOBYTE",
                "MEGABYTE",
                "GIGABYTE",
                "HOUR",
                "MINUTE",
                "SECOND",
                "DAY",
                "POINT",
                "LINE",
                "RAY",
                "PLANE"
            ),
            listOf(
                ConnectionCategory(
                    "Trigonometry",
                    setOf("SINE", "COSINE", "TANGENT", "SECANT"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Data Units",
                    setOf("BYTE", "KILOBYTE", "MEGABYTE", "GIGABYTE"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Time Units",
                    setOf("HOUR", "MINUTE", "SECOND", "DAY"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Geometry Terms",
                    setOf("POINT", "LINE", "RAY", "PLANE"),
                    CategoryColor.PURPLE
                )
            ),
            "Hard"
        ),

        ConnectionPuzzle(
            24,
            listOf(
                "ROOT",
                "BRANCH",
                "LEAF",
                "TREE",
                "LOGIN",
                "LOGOUT",
                "SIGNUP",
                "VERIFY",
                "PAST",
                "PRESENT",
                "FUTURE",
                "NOW",
                "ONE",
                "TWO",
                "FOUR",
                "EIGHT"
            ),
            listOf(
                ConnectionCategory(
                    "Tree Structure",
                    setOf("ROOT", "BRANCH", "LEAF", "TREE"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Auth Actions",
                    setOf("LOGIN", "LOGOUT", "SIGNUP", "VERIFY"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Time Concepts",
                    setOf("PAST", "PRESENT", "FUTURE", "NOW"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Powers of Two",
                    setOf("ONE", "TWO", "FOUR", "EIGHT"),
                    CategoryColor.PURPLE
                )
            ),
            "Hard"
        ),

        ConnectionPuzzle(
            25,
            listOf(
                "MERGE",
                "SORT",
                "SEARCH",
                "FILTER",
                "EARTH",
                "WATER",
                "AIR",
                "FIRE",
                "MONDAY",
                "TUESDAY",
                "WEDNESDAY",
                "THURSDAY",
                "CIRCLE",
                "SQUARE",
                "TRIANGLE",
                "RECTANGLE"
            ),
            listOf(
                ConnectionCategory(
                    "Algorithms",
                    setOf("MERGE", "SORT", "SEARCH", "FILTER"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Elements",
                    setOf("EARTH", "WATER", "AIR", "FIRE"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Weekdays",
                    setOf("MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Shapes",
                    setOf("CIRCLE", "SQUARE", "TRIANGLE", "RECTANGLE"),
                    CategoryColor.PURPLE
                )
            ),
            "Hard"
        ),

        ConnectionPuzzle(
            26,
            listOf(
                "SPEED",
                "DISTANCE",
                "TIME",
                "VELOCITY",
                "CPU",
                "RAM",
                "ROM",
                "GPU",
                "BUY",
                "SELL",
                "TRADE",
                "BARTER",
                "CAT",
                "DOG",
                "HORSE",
                "COW"
            ),
            listOf(
                ConnectionCategory(
                    "Physics Terms",
                    setOf("SPEED", "DISTANCE", "TIME", "VELOCITY"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Computer Hardware",
                    setOf("CPU", "RAM", "ROM", "GPU"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Commerce Actions",
                    setOf("BUY", "SELL", "TRADE", "BARTER"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Animals",
                    setOf("CAT", "DOG", "HORSE", "COW"),
                    CategoryColor.PURPLE
                )
            ),
            "Hard"
        ),

        ConnectionPuzzle(
            27,
            listOf(
                "PRIME",
                "EVEN",
                "ODD",
                "COMPOSITE",
                "LINE",
                "RAY",
                "ANGLE",
                "POINT",
                "DO",
                "RE",
                "MI",
                "FA",
                "JAVA",
                "KOTLIN",
                "SWIFT",
                "GO"
            ),
            listOf(
                ConnectionCategory(
                    "Number Types",
                    setOf("PRIME", "EVEN", "ODD", "COMPOSITE"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Geometry Basics",
                    setOf("LINE", "RAY", "ANGLE", "POINT"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Musical Notes",
                    setOf("DO", "RE", "MI", "FA"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Programming Languages",
                    setOf("JAVA", "KOTLIN", "SWIFT", "GO"),
                    CategoryColor.PURPLE
                )
            ),
            "Hard"
        ),

        ConnectionPuzzle(
            28,
            listOf(
                "MERCURY",
                "VENUS",
                "EARTH",
                "MARS",
                "SQUARE",
                "CUBE",
                "ROOT",
                "POWER",
                "LOGIN",
                "LOGOUT",
                "UPLOAD",
                "DOWNLOAD",
                "FAST",
                "SLOW",
                "HEAVY",
                "LIGHT"
            ),
            listOf(
                ConnectionCategory(
                    "Inner Planets",
                    setOf("MERCURY", "VENUS", "EARTH", "MARS"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Math Operations",
                    setOf("SQUARE", "CUBE", "ROOT", "POWER"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Computer Actions",
                    setOf("LOGIN", "LOGOUT", "UPLOAD", "DOWNLOAD"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Opposites",
                    setOf("FAST", "SLOW", "HEAVY", "LIGHT"),
                    CategoryColor.PURPLE
                )
            ),
            "Hard"
        ),

        ConnectionPuzzle(
            29,
            listOf(
                "BYTE",
                "CACHE",
                "STACK",
                "QUEUE",
                "WIND",
                "RAIN",
                "SNOW",
                "FOG",
                "GOLD",
                "SILVER",
                "BRONZE",
                "COPPER",
                "READ",
                "WRITE",
                "DRAW",
                "PAINT"
            ),
            listOf(
                ConnectionCategory(
                    "CS Terms",
                    setOf("BYTE", "CACHE", "STACK", "QUEUE"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Weather",
                    setOf("WIND", "RAIN", "SNOW", "FOG"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Metals",
                    setOf("GOLD", "SILVER", "BRONZE", "COPPER"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Creative Actions",
                    setOf("READ", "WRITE", "DRAW", "PAINT"),
                    CategoryColor.PURPLE
                )
            ),
            "Hard"
        ),

        ConnectionPuzzle(
            30,
            listOf(
                "ANGLE",
                "TRIANGLE",
                "SQUARE",
                "CIRCLE",
                "SECOND",
                "MINUTE",
                "HOUR",
                "DAY",
                "RAM",
                "DISK",
                "CACHE",
                "BUFFER",
                "EAT",
                "DRINK",
                "SLEEP",
                "RUN"
            ),
            listOf(
                ConnectionCategory(
                    "Geometry Shapes",
                    setOf("ANGLE", "TRIANGLE", "SQUARE", "CIRCLE"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Time Units",
                    setOf("SECOND", "MINUTE", "HOUR", "DAY"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Memory Related",
                    setOf("RAM", "DISK", "CACHE", "BUFFER"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Daily Actions",
                    setOf("EAT", "DRINK", "SLEEP", "RUN"),
                    CategoryColor.PURPLE
                )
            ),
            "Hard"
        ),

        // ---------- HARD+ (31–40) ----------
        ConnectionPuzzle(
            31,
            listOf(
                "BANK",
                "INTEREST",
                "LOAN",
                "CREDIT",
                "BAT",
                "BALL",
                "GLOVE",
                "HELMET",
                "ATOM",
                "CELL",
                "MOLECULE",
                "TISSUE",
                "ADD",
                "SUB",
                "MUL",
                "DIV"
            ),
            listOf(
                ConnectionCategory(
                    "Finance Terms",
                    setOf("BANK", "INTEREST", "LOAN", "CREDIT"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Sports Gear",
                    setOf("BAT", "BALL", "GLOVE", "HELMET"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Biology Levels",
                    setOf("ATOM", "CELL", "MOLECULE", "TISSUE"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Math Operations",
                    setOf("ADD", "SUB", "MUL", "DIV"),
                    CategoryColor.PURPLE
                )
            ),
            "Hard+"
        ),

        ConnectionPuzzle(
            32,
            listOf(
                "ROOT",
                "STEM",
                "LEAF",
                "FLOWER",
                "PAST",
                "PRESENT",
                "FUTURE",
                "NOW",
                "SORT",
                "MERGE",
                "SEARCH",
                "FILTER",
                "RED",
                "GREEN",
                "BLUE",
                "YELLOW"
            ),
            listOf(
                ConnectionCategory(
                    "Plant Parts",
                    setOf("ROOT", "STEM", "LEAF", "FLOWER"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Time Concepts",
                    setOf("PAST", "PRESENT", "FUTURE", "NOW"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Algorithms",
                    setOf("SORT", "MERGE", "SEARCH", "FILTER"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Colors",
                    setOf("RED", "GREEN", "BLUE", "YELLOW"),
                    CategoryColor.PURPLE
                )
            ),
            "Hard+"
        ),

        ConnectionPuzzle(
            33,
            listOf(
                "POINT",
                "LINE",
                "RAY",
                "PLANE",
                "BIT",
                "BYTE",
                "KILOBYTE",
                "MEGABYTE",
                "BUY",
                "SELL",
                "RENT",
                "LEASE",
                "CAT",
                "DOG",
                "FOX",
                "WOLF"
            ),
            listOf(
                ConnectionCategory(
                    "Geometry Terms",
                    setOf("POINT", "LINE", "RAY", "PLANE"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Data Units",
                    setOf("BIT", "BYTE", "KILOBYTE", "MEGABYTE"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Property Actions",
                    setOf("BUY", "SELL", "RENT", "LEASE"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Animals",
                    setOf("CAT", "DOG", "FOX", "WOLF"),
                    CategoryColor.PURPLE
                )
            ),
            "Hard+"
        ),

        ConnectionPuzzle(
            34,
            listOf(
                "CPU",
                "GPU",
                "TPU",
                "ASIC",
                "SINE",
                "COSINE",
                "TANGENT",
                "SECANT",
                "NORTH",
                "SOUTH",
                "EAST",
                "WEST",
                "PEN",
                "PENCIL",
                "INK",
                "MARKER"
            ),
            listOf(
                ConnectionCategory(
                    "Processors",
                    setOf("CPU", "GPU", "TPU", "ASIC"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Trigonometry",
                    setOf("SINE", "COSINE", "TANGENT", "SECANT"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Directions",
                    setOf("NORTH", "SOUTH", "EAST", "WEST"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Writing Tools",
                    setOf("PEN", "PENCIL", "INK", "MARKER"),
                    CategoryColor.PURPLE
                )
            ),
            "Hard+"
        ),

        ConnectionPuzzle(
            35,
            listOf(
                "PRIME",
                "SQUARE",
                "CUBE",
                "FACTOR",
                "MONDAY",
                "TUESDAY",
                "WEDNESDAY",
                "THURSDAY",
                "FIRE",
                "WATER",
                "AIR",
                "EARTH",
                "READ",
                "LISTEN",
                "SPEAK",
                "WRITE"
            ),
            listOf(
                ConnectionCategory(
                    "Number Properties",
                    setOf("PRIME", "SQUARE", "CUBE", "FACTOR"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Weekdays",
                    setOf("MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Elements",
                    setOf("FIRE", "WATER", "AIR", "EARTH"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Language Skills",
                    setOf("READ", "LISTEN", "SPEAK", "WRITE"),
                    CategoryColor.PURPLE
                )
            ),
            "Hard+"
        ),

        // ---------- VERY HARD (36–50) ----------
        ConnectionPuzzle(
            36,
            listOf(
                "EVEN",
                "ODD",
                "PRIME",
                "ZERO",
                "LOGIN",
                "LOGOUT",
                "UPLOAD",
                "DOWNLOAD",
                "SOLID",
                "LIQUID",
                "GAS",
                "PLASMA",
                "DOG",
                "CAT",
                "HORSE",
                "MOUSE"
            ),
            listOf(
                ConnectionCategory(
                    "Number Types",
                    setOf("EVEN", "ODD", "PRIME", "ZERO"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "System Actions",
                    setOf("LOGIN", "LOGOUT", "UPLOAD", "DOWNLOAD"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "States of Matter",
                    setOf("SOLID", "LIQUID", "GAS", "PLASMA"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Animals",
                    setOf("DOG", "CAT", "HORSE", "MOUSE"),
                    CategoryColor.PURPLE
                )
            ),
            "Very Hard"
        ),

        ConnectionPuzzle(
            37,
            listOf(
                "BYTE",
                "NIBBLE",
                "WORD",
                "BLOCK",
                "SUN",
                "MOON",
                "EARTH",
                "STAR",
                "BUY",
                "SELL",
                "HOLD",
                "TRADE",
                "FAST",
                "SLOW",
                "EARLY",
                "LATE"
            ),
            listOf(
                ConnectionCategory(
                    "Data Sizes",
                    setOf("BYTE", "NIBBLE", "WORD", "BLOCK"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Space Objects",
                    setOf("SUN", "MOON", "EARTH", "STAR"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Stock Actions",
                    setOf("BUY", "SELL", "HOLD", "TRADE"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Time Descriptors",
                    setOf("FAST", "SLOW", "EARLY", "LATE"),
                    CategoryColor.PURPLE
                )
            ),
            "Very Hard"
        ),

        ConnectionPuzzle(
            38,
            listOf(
                "LINEAR",
                "QUADRATIC",
                "CUBIC",
                "EXPONENTIAL",
                "RAM",
                "CACHE",
                "BUFFER",
                "QUEUE",
                "CIRCLE",
                "SQUARE",
                "TRIANGLE",
                "RECTANGLE",
                "READ",
                "WRITE",
                "EXECUTE",
                "DELETE"
            ),
            listOf(
                ConnectionCategory(
                    "Functions",
                    setOf("LINEAR", "QUADRATIC", "CUBIC", "EXPONENTIAL"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Memory Structures",
                    setOf("RAM", "CACHE", "BUFFER", "QUEUE"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Shapes",
                    setOf("CIRCLE", "SQUARE", "TRIANGLE", "RECTANGLE"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "File Permissions",
                    setOf("READ", "WRITE", "EXECUTE", "DELETE"),
                    CategoryColor.PURPLE
                )
            ),
            "Very Hard"
        ),

        ConnectionPuzzle(
            39,
            listOf(
                "ROOT",
                "SQUARE",
                "CUBE",
                "LOG",
                "SECOND",
                "MINUTE",
                "HOUR",
                "DAY",
                "JAVA",
                "PYTHON",
                "GO",
                "RUST",
                "DOG",
                "CAT",
                "FOX",
                "WOLF"
            ),
            listOf(
                ConnectionCategory(
                    "Math Functions",
                    setOf("ROOT", "SQUARE", "CUBE", "LOG"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Time Units",
                    setOf("SECOND", "MINUTE", "HOUR", "DAY"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Languages",
                    setOf("JAVA", "PYTHON", "GO", "RUST"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Animals",
                    setOf("DOG", "CAT", "FOX", "WOLF"),
                    CategoryColor.PURPLE
                )
            ),
            "Very Hard"
        ),

        ConnectionPuzzle(
            40,
            listOf(
                "INPUT",
                "OUTPUT",
                "PROCESS",
                "MEMORY",
                "EARTH",
                "MARS",
                "JUPITER",
                "SATURN",
                "ADD",
                "SUB",
                "MUL",
                "DIV",
                "POINT",
                "LINE",
                "RAY",
                "PLANE"
            ),
            listOf(
                ConnectionCategory(
                    "Computer Cycle",
                    setOf("INPUT", "OUTPUT", "PROCESS", "MEMORY"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Planets",
                    setOf("EARTH", "MARS", "JUPITER", "SATURN"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Math Operations",
                    setOf("ADD", "SUB", "MUL", "DIV"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Geometry",
                    setOf("POINT", "LINE", "RAY", "PLANE"),
                    CategoryColor.PURPLE
                )
            ),
            "Very Hard"
        ),

        ConnectionPuzzle(
            41,
            listOf(
                "SORT",
                "MERGE",
                "BINARY",
                "LINEAR",
                "ICE",
                "WATER",
                "STEAM",
                "VAPOR",
                "BUY",
                "SELL",
                "RENT",
                "LEASE",
                "RED",
                "GREEN",
                "BLUE",
                "CYAN"
            ),
            listOf(
                ConnectionCategory(
                    "Search / Sort Types",
                    setOf("SORT", "MERGE", "BINARY", "LINEAR"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Water States",
                    setOf("ICE", "WATER", "STEAM", "VAPOR"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Commerce Actions",
                    setOf("BUY", "SELL", "RENT", "LEASE"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Colors",
                    setOf("RED", "GREEN", "BLUE", "CYAN"),
                    CategoryColor.PURPLE
                )
            ),
            "Very Hard"
        ),

        ConnectionPuzzle(
            42,
            listOf(
                "POINT",
                "EDGE",
                "FACE",
                "VERTEX",
                "CPU",
                "GPU",
                "TPU",
                "NPU",
                "MONDAY",
                "TUESDAY",
                "WEDNESDAY",
                "THURSDAY",
                "SINE",
                "COSINE",
                "TANGENT",
                "SECANT"
            ),
            listOf(
                ConnectionCategory(
                    "3D Geometry Parts",
                    setOf("POINT", "EDGE", "FACE", "VERTEX"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "AI Chips",
                    setOf("CPU", "GPU", "TPU", "NPU"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Weekdays",
                    setOf("MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Trigonometry",
                    setOf("SINE", "COSINE", "TANGENT", "SECANT"),
                    CategoryColor.PURPLE
                )
            ),
            "Very Hard"
        ),

        ConnectionPuzzle(
            43,
            listOf(
                "PRIME",
                "FACTOR",
                "MULTIPLE",
                "DIVISOR",
                "JAVA",
                "KOTLIN",
                "SWIFT",
                "DART",
                "DOG",
                "CAT",
                "MOUSE",
                "RAT",
                "FAST",
                "SLOW",
                "EARLY",
                "LATE"
            ),
            listOf(
                ConnectionCategory(
                    "Number Theory",
                    setOf("PRIME", "FACTOR", "MULTIPLE", "DIVISOR"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Mobile Languages",
                    setOf("JAVA", "KOTLIN", "SWIFT", "DART"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Rodents",
                    setOf("DOG", "CAT", "MOUSE", "RAT"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Time Descriptors",
                    setOf("FAST", "SLOW", "EARLY", "LATE"),
                    CategoryColor.PURPLE
                )
            ),
            "Very Hard"
        ),

        ConnectionPuzzle(
            44,
            listOf(
                "ANGLE",
                "ARC",
                "CHORD",
                "RADIUS",
                "BYTE",
                "WORD",
                "BLOCK",
                "PAGE",
                "BUY",
                "SELL",
                "HOLD",
                "TRADE",
                "SPRING",
                "SUMMER",
                "FALL",
                "WINTER"
            ),
            listOf(
                ConnectionCategory(
                    "Circle Geometry",
                    setOf("ANGLE", "ARC", "CHORD", "RADIUS"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Memory Units",
                    setOf("BYTE", "WORD", "BLOCK", "PAGE"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Market Actions",
                    setOf("BUY", "SELL", "HOLD", "TRADE"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Seasons",
                    setOf("SPRING", "SUMMER", "FALL", "WINTER"),
                    CategoryColor.PURPLE
                )
            ),
            "Very Hard"
        ),

        ConnectionPuzzle(
            45,
            listOf(
                "INPUT",
                "OUTPUT",
                "STATE",
                "TRANSITION",
                "ATOM",
                "ION",
                "PROTON",
                "ELECTRON",
                "LINE",
                "RAY",
                "PLANE",
                "ANGLE",
                "READ",
                "WRITE",
                "EXECUTE",
                "DELETE"
            ),
            listOf(
                ConnectionCategory(
                    "State Machine Terms",
                    setOf("INPUT", "OUTPUT", "STATE", "TRANSITION"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Atomic Particles",
                    setOf("ATOM", "ION", "PROTON", "ELECTRON"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Geometry Terms",
                    setOf("LINE", "RAY", "PLANE", "ANGLE"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Permissions",
                    setOf("READ", "WRITE", "EXECUTE", "DELETE"),
                    CategoryColor.PURPLE
                )
            ),
            "Very Hard"
        ),

        ConnectionPuzzle(
            46,
            listOf(
                "SPEED",
                "VELOCITY",
                "ACCELERATION",
                "TIME",
                "JAVA",
                "GO",
                "RUST",
                "C",
                "SQUARE",
                "CUBE",
                "POWER",
                "ROOT",
                "EARTH",
                "AIR",
                "FIRE",
                "WATER"
            ),
            listOf(
                ConnectionCategory(
                    "Physics Terms",
                    setOf("SPEED", "VELOCITY", "ACCELERATION", "TIME"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "System Languages",
                    setOf("JAVA", "GO", "RUST", "C"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Math Operations",
                    setOf("SQUARE", "CUBE", "POWER", "ROOT"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Elements",
                    setOf("EARTH", "AIR", "FIRE", "WATER"),
                    CategoryColor.PURPLE
                )
            ),
            "Very Hard"
        ),

        ConnectionPuzzle(
            47,
            listOf(
                "LOGIN",
                "LOGOUT",
                "AUTH",
                "VERIFY",
                "POINT",
                "LINE",
                "RAY",
                "PLANE",
                "BUY",
                "SELL",
                "RENT",
                "LEASE",
                "DOG",
                "CAT",
                "FOX",
                "WOLF"
            ),
            listOf(
                ConnectionCategory(
                    "Authentication",
                    setOf("LOGIN", "LOGOUT", "AUTH", "VERIFY"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Geometry Basics",
                    setOf("POINT", "LINE", "RAY", "PLANE"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Property Actions",
                    setOf("BUY", "SELL", "RENT", "LEASE"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Animals",
                    setOf("DOG", "CAT", "FOX", "WOLF"),
                    CategoryColor.PURPLE
                )
            ),
            "Very Hard"
        ),

        ConnectionPuzzle(
            48,
            listOf(
                "PRIME",
                "EVEN",
                "ODD",
                "SQUARE",
                "BYTE",
                "CACHE",
                "QUEUE",
                "STACK",
                "SUN",
                "MOON",
                "STAR",
                "PLANET",
                "READ",
                "WRITE",
                "DRAW",
                "PAINT"
            ),
            listOf(
                ConnectionCategory(
                    "Number Properties",
                    setOf("PRIME", "EVEN", "ODD", "SQUARE"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Data Structures",
                    setOf("BYTE", "CACHE", "QUEUE", "STACK"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Space Objects",
                    setOf("SUN", "MOON", "STAR", "PLANET"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Creative Actions",
                    setOf("READ", "WRITE", "DRAW", "PAINT"),
                    CategoryColor.PURPLE
                )
            ),
            "Very Hard"
        ),

        ConnectionPuzzle(
            49,
            listOf(
                "ROOT",
                "BRANCH",
                "LEAF",
                "TREE",
                "ADD",
                "SUB",
                "MUL",
                "DIV",
                "SECOND",
                "MINUTE",
                "HOUR",
                "DAY",
                "CAR",
                "BUS",
                "TRAIN",
                "PLANE"
            ),
            listOf(
                ConnectionCategory(
                    "Tree Structure",
                    setOf("ROOT", "BRANCH", "LEAF", "TREE"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Math Operations",
                    setOf("ADD", "SUB", "MUL", "DIV"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Time Units",
                    setOf("SECOND", "MINUTE", "HOUR", "DAY"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Transport",
                    setOf("CAR", "BUS", "TRAIN", "PLANE"),
                    CategoryColor.PURPLE
                )
            ),
            "Very Hard"
        ),

        ConnectionPuzzle(
            50,
            listOf(
                "LINEAR",
                "QUADRATIC",
                "CUBIC",
                "LOGARITHMIC",
                "CPU",
                "RAM",
                "ROM",
                "GPU",
                "PRIME",
                "FACTOR",
                "MULTIPLE",
                "DIVISOR",
                "RED",
                "GREEN",
                "BLUE",
                "YELLOW"
            ),
            listOf(
                ConnectionCategory(
                    "Function Types",
                    setOf("LINEAR", "QUADRATIC", "CUBIC", "LOGARITHMIC"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Computer Hardware",
                    setOf("CPU", "RAM", "ROM", "GPU"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Number Theory",
                    setOf("PRIME", "FACTOR", "MULTIPLE", "DIVISOR"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Colors",
                    setOf("RED", "GREEN", "BLUE", "YELLOW"),
                    CategoryColor.PURPLE
                )
            ),
            "Very Hard"
        ),
        ConnectionPuzzle(
            51,
            listOf(
                "ONE",
                "TWO",
                "THREE",
                "FOUR",
                "ADD",
                "SUB",
                "MUL",
                "DIV",
                "RED",
                "BLUE",
                "GREEN",
                "YELLOW",
                "DOG",
                "CAT",
                "COW",
                "GOAT"
            ),
            listOf(
                ConnectionCategory(
                    "Numbers",
                    setOf("ONE", "TWO", "THREE", "FOUR"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Math Operations",
                    setOf("ADD", "SUB", "MUL", "DIV"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Colors",
                    setOf("RED", "BLUE", "GREEN", "YELLOW"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Animals",
                    setOf("DOG", "CAT", "COW", "GOAT"),
                    CategoryColor.PURPLE
                )
            ),
            "Easy"
        ),

        ConnectionPuzzle(
            52,
            listOf(
                "FIVE",
                "SIX",
                "SEVEN",
                "EIGHT",
                "EVEN",
                "ODD",
                "PRIME",
                "ZERO",
                "CAR",
                "BUS",
                "TRAIN",
                "BIKE",
                "APPLE",
                "BANANA",
                "ORANGE",
                "GRAPE"
            ),
            listOf(
                ConnectionCategory(
                    "Numbers",
                    setOf("FIVE", "SIX", "SEVEN", "EIGHT"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Number Types",
                    setOf("EVEN", "ODD", "PRIME", "ZERO"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Transport",
                    setOf("CAR", "BUS", "TRAIN", "BIKE"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Fruits",
                    setOf("APPLE", "BANANA", "ORANGE", "GRAPE"),
                    CategoryColor.PURPLE
                )
            ),
            "Easy"
        ),

        ConnectionPuzzle(
            53,
            listOf(
                "TEN",
                "TWENTY",
                "THIRTY",
                "FORTY",
                "CIRCLE",
                "SQUARE",
                "TRIANGLE",
                "RECTANGLE",
                "PEN",
                "PENCIL",
                "ERASER",
                "RULER",
                "SUN",
                "MOON",
                "STAR",
                "SKY"
            ),
            listOf(
                ConnectionCategory(
                    "Multiples of Ten",
                    setOf("TEN", "TWENTY", "THIRTY", "FORTY"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Shapes",
                    setOf("CIRCLE", "SQUARE", "TRIANGLE", "RECTANGLE"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Stationery",
                    setOf("PEN", "PENCIL", "ERASER", "RULER"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Sky Objects",
                    setOf("SUN", "MOON", "STAR", "SKY"),
                    CategoryColor.PURPLE
                )
            ),
            "Easy"
        ),

        ConnectionPuzzle(
            54,
            listOf(
                "HALF",
                "DOUBLE",
                "SUM",
                "TOTAL",
                "SECOND",
                "MINUTE",
                "HOUR",
                "DAY",
                "CHAIR",
                "TABLE",
                "BED",
                "SOFA",
                "MILK",
                "WATER",
                "TEA",
                "JUICE"
            ),
            listOf(
                ConnectionCategory(
                    "Math Words",
                    setOf("HALF", "DOUBLE", "SUM", "TOTAL"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Time Units",
                    setOf("SECOND", "MINUTE", "HOUR", "DAY"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Furniture",
                    setOf("CHAIR", "TABLE", "BED", "SOFA"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Drinks",
                    setOf("MILK", "WATER", "TEA", "JUICE"),
                    CategoryColor.PURPLE
                )
            ),
            "Easy"
        ),

        ConnectionPuzzle(
            55,
            listOf(
                "ONE",
                "EVEN",
                "TWO",
                "ODD",
                "RED",
                "BLUE",
                "BLACK",
                "WHITE",
                "FORK",
                "SPOON",
                "KNIFE",
                "PLATE",
                "CAR",
                "TRUCK",
                "BUS",
                "VAN"
            ),
            listOf(
                ConnectionCategory(
                    "Number Words",
                    setOf("ONE", "TWO", "EVEN", "ODD"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Colors",
                    setOf("RED", "BLUE", "BLACK", "WHITE"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Dining Items",
                    setOf("FORK", "SPOON", "KNIFE", "PLATE"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Vehicles",
                    setOf("CAR", "TRUCK", "BUS", "VAN"),
                    CategoryColor.PURPLE
                )
            ),
            "Easy"
        ),

        // ---------- EASY CONTINUED (56–75) ----------
        ConnectionPuzzle(
            56,
            listOf(
                "ADD",
                "PLUS",
                "MORE",
                "SUM",
                "COLD",
                "HOT",
                "WARM",
                "COOL",
                "DOG",
                "CAT",
                "BIRD",
                "FISH",
                "BOOK",
                "PAPER",
                "PEN",
                "INK"
            ),
            listOf(
                ConnectionCategory(
                    "Addition Words",
                    setOf("ADD", "PLUS", "MORE", "SUM"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Temperature",
                    setOf("COLD", "HOT", "WARM", "COOL"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory("Pets", setOf("DOG", "CAT", "BIRD", "FISH"), CategoryColor.BLUE),
                ConnectionCategory(
                    "Writing Items",
                    setOf("BOOK", "PAPER", "PEN", "INK"),
                    CategoryColor.PURPLE
                )
            ),
            "Easy"
        ),

        ConnectionPuzzle(
            57,
            listOf(
                "SMALL",
                "MEDIUM",
                "LARGE",
                "BIG",
                "ONE",
                "TWO",
                "THREE",
                "FOUR",
                "APPLE",
                "MANGO",
                "PEAR",
                "PLUM",
                "SPRING",
                "SUMMER",
                "FALL",
                "WINTER"
            ),
            listOf(
                ConnectionCategory(
                    "Size Words",
                    setOf("SMALL", "MEDIUM", "LARGE", "BIG"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Numbers",
                    setOf("ONE", "TWO", "THREE", "FOUR"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Fruits",
                    setOf("APPLE", "MANGO", "PEAR", "PLUM"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Seasons",
                    setOf("SPRING", "SUMMER", "FALL", "WINTER"),
                    CategoryColor.PURPLE
                )
            ),
            "Easy"
        ),

        ConnectionPuzzle(
            58,
            listOf(
                "LEFT",
                "RIGHT",
                "UP",
                "DOWN",
                "ADD",
                "SUB",
                "MUL",
                "DIV",
                "SUN",
                "RAIN",
                "SNOW",
                "WIND",
                "CUP",
                "PLATE",
                "SPOON",
                "BOWL"
            ),
            listOf(
                ConnectionCategory(
                    "Directions",
                    setOf("LEFT", "RIGHT", "UP", "DOWN"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Math Operations",
                    setOf("ADD", "SUB", "MUL", "DIV"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Weather",
                    setOf("SUN", "RAIN", "SNOW", "WIND"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Kitchen Items",
                    setOf("CUP", "PLATE", "SPOON", "BOWL"),
                    CategoryColor.PURPLE
                )
            ),
            "Easy"
        ),

        ConnectionPuzzle(
            59,
            listOf(
                "EVEN",
                "ODD",
                "ZERO",
                "ONE",
                "CAR",
                "BUS",
                "TRAIN",
                "PLANE",
                "RED",
                "GREEN",
                "BLUE",
                "YELLOW",
                "HAND",
                "FOOT",
                "ARM",
                "LEG"
            ),
            listOf(
                ConnectionCategory(
                    "Number Types",
                    setOf("EVEN", "ODD", "ZERO", "ONE"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Transport",
                    setOf("CAR", "BUS", "TRAIN", "PLANE"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Colors",
                    setOf("RED", "GREEN", "BLUE", "YELLOW"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Body Parts",
                    setOf("HAND", "FOOT", "ARM", "LEG"),
                    CategoryColor.PURPLE
                )
            ),
            "Easy"
        ),

        ConnectionPuzzle(
            60,
            listOf(
                "COUNT",
                "ADD",
                "TOTAL",
                "SUM",
                "MONDAY",
                "TUESDAY",
                "WEDNESDAY",
                "THURSDAY",
                "DOG",
                "CAT",
                "COW",
                "HORSE",
                "MILK",
                "CHEESE",
                "BUTTER",
                "YOGURT"
            ),
            listOf(
                ConnectionCategory(
                    "Math Verbs",
                    setOf("COUNT", "ADD", "TOTAL", "SUM"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Weekdays",
                    setOf("MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Animals",
                    setOf("DOG", "CAT", "COW", "HORSE"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Dairy Products",
                    setOf("MILK", "CHEESE", "BUTTER", "YOGURT"),
                    CategoryColor.PURPLE
                )
            ),
            "Easy"
        ),

        ConnectionPuzzle(
            61,
            listOf(
                "ONE",
                "TWO",
                "THREE",
                "FOUR",
                "RED",
                "BLUE",
                "GREEN",
                "YELLOW",
                "CAT",
                "DOG",
                "COW",
                "GOAT",
                "PEN",
                "PENCIL",
                "ERASER",
                "RULER"
            ),
            listOf(
                ConnectionCategory(
                    "Numbers",
                    setOf("ONE", "TWO", "THREE", "FOUR"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Colors",
                    setOf("RED", "BLUE", "GREEN", "YELLOW"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Animals",
                    setOf("CAT", "DOG", "COW", "GOAT"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Stationery",
                    setOf("PEN", "PENCIL", "ERASER", "RULER"),
                    CategoryColor.PURPLE
                )
            ),
            "Easy"
        ),

        ConnectionPuzzle(
            62,
            listOf(
                "ADD",
                "SUB",
                "MUL",
                "DIV",
                "SUN",
                "MOON",
                "STAR",
                "SKY",
                "CHAIR",
                "TABLE",
                "BED",
                "SOFA",
                "MILK",
                "WATER",
                "JUICE",
                "TEA"
            ),
            listOf(
                ConnectionCategory(
                    "Math Operations",
                    setOf("ADD", "SUB", "MUL", "DIV"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Sky Objects",
                    setOf("SUN", "MOON", "STAR", "SKY"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Furniture",
                    setOf("CHAIR", "TABLE", "BED", "SOFA"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Drinks",
                    setOf("MILK", "WATER", "JUICE", "TEA"),
                    CategoryColor.PURPLE
                )
            ),
            "Easy"
        ),

        ConnectionPuzzle(
            63,
            listOf(
                "EVEN",
                "ODD",
                "PRIME",
                "ZERO",
                "CAR",
                "BUS",
                "TRAIN",
                "BIKE",
                "APPLE",
                "BANANA",
                "ORANGE",
                "GRAPE",
                "HAND",
                "FOOT",
                "ARM",
                "LEG"
            ),
            listOf(
                ConnectionCategory(
                    "Number Types",
                    setOf("EVEN", "ODD", "PRIME", "ZERO"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Transport",
                    setOf("CAR", "BUS", "TRAIN", "BIKE"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Fruits",
                    setOf("APPLE", "BANANA", "ORANGE", "GRAPE"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Body Parts",
                    setOf("HAND", "FOOT", "ARM", "LEG"),
                    CategoryColor.PURPLE
                )
            ),
            "Easy"
        ),

        ConnectionPuzzle(
            64,
            listOf(
                "SECOND",
                "MINUTE",
                "HOUR",
                "DAY",
                "DOG",
                "CAT",
                "BIRD",
                "FISH",
                "RED",
                "BLACK",
                "WHITE",
                "GRAY",
                "BOOK",
                "PAPER",
                "PEN",
                "INK"
            ),
            listOf(
                ConnectionCategory(
                    "Time Units",
                    setOf("SECOND", "MINUTE", "HOUR", "DAY"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Pets",
                    setOf("DOG", "CAT", "BIRD", "FISH"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Colors",
                    setOf("RED", "BLACK", "WHITE", "GRAY"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Writing Items",
                    setOf("BOOK", "PAPER", "PEN", "INK"),
                    CategoryColor.PURPLE
                )
            ),
            "Easy"
        ),

        ConnectionPuzzle(
            65,
            listOf(
                "CIRCLE",
                "SQUARE",
                "TRIANGLE",
                "RECTANGLE",
                "ONE",
                "TWO",
                "THREE",
                "FOUR",
                "FORK",
                "SPOON",
                "KNIFE",
                "PLATE",
                "SUN",
                "RAIN",
                "SNOW",
                "WIND"
            ),
            listOf(
                ConnectionCategory(
                    "Shapes",
                    setOf("CIRCLE", "SQUARE", "TRIANGLE", "RECTANGLE"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Numbers",
                    setOf("ONE", "TWO", "THREE", "FOUR"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Dining Items",
                    setOf("FORK", "SPOON", "KNIFE", "PLATE"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Weather",
                    setOf("SUN", "RAIN", "SNOW", "WIND"),
                    CategoryColor.PURPLE
                )
            ),
            "Easy"
        ),

        // ---------- EASY CONTINUED (66–80) ----------
        ConnectionPuzzle(
            66,
            listOf(
                "ADD",
                "PLUS",
                "SUM",
                "TOTAL",
                "CAR",
                "TRUCK",
                "BUS",
                "VAN",
                "RED",
                "GREEN",
                "BLUE",
                "YELLOW",
                "DOG",
                "CAT",
                "HORSE",
                "COW"
            ),
            listOf(
                ConnectionCategory(
                    "Addition Words",
                    setOf("ADD", "PLUS", "SUM", "TOTAL"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Vehicles",
                    setOf("CAR", "TRUCK", "BUS", "VAN"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Colors",
                    setOf("RED", "GREEN", "BLUE", "YELLOW"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Animals",
                    setOf("DOG", "CAT", "HORSE", "COW"),
                    CategoryColor.PURPLE
                )
            ),
            "Easy"
        ),

        ConnectionPuzzle(
            67,
            listOf(
                "LEFT",
                "RIGHT",
                "UP",
                "DOWN",
                "ONE",
                "TEN",
                "HUNDRED",
                "THOUSAND",
                "PEN",
                "PENCIL",
                "MARKER",
                "CHALK",
                "MILK",
                "CHEESE",
                "BUTTER",
                "YOGURT"
            ),
            listOf(
                ConnectionCategory(
                    "Directions",
                    setOf("LEFT", "RIGHT", "UP", "DOWN"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Number Magnitudes",
                    setOf("ONE", "TEN", "HUNDRED", "THOUSAND"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Writing Tools",
                    setOf("PEN", "PENCIL", "MARKER", "CHALK"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Dairy Products",
                    setOf("MILK", "CHEESE", "BUTTER", "YOGURT"),
                    CategoryColor.PURPLE
                )
            ),
            "Easy"
        ),

        ConnectionPuzzle(
            68,
            listOf(
                "EVEN",
                "ODD",
                "ONE",
                "TWO",
                "SUN",
                "MOON",
                "STAR",
                "PLANET",
                "BOOK",
                "NOTE",
                "PAGE",
                "CHAPTER",
                "APPLE",
                "MANGO",
                "PEAR",
                "PLUM"
            ),
            listOf(
                ConnectionCategory(
                    "Number Words",
                    setOf("EVEN", "ODD", "ONE", "TWO"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Space Objects",
                    setOf("SUN", "MOON", "STAR", "PLANET"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Book Parts",
                    setOf("BOOK", "NOTE", "PAGE", "CHAPTER"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Fruits",
                    setOf("APPLE", "MANGO", "PEAR", "PLUM"),
                    CategoryColor.PURPLE
                )
            ),
            "Easy"
        ),

        ConnectionPuzzle(
            69,
            listOf(
                "SMALL",
                "MEDIUM",
                "LARGE",
                "BIG",
                "SECOND",
                "MINUTE",
                "HOUR",
                "DAY",
                "CAT",
                "DOG",
                "FOX",
                "WOLF",
                "RED",
                "BLUE",
                "BLACK",
                "WHITE"
            ),
            listOf(
                ConnectionCategory(
                    "Size Words",
                    setOf("SMALL", "MEDIUM", "LARGE", "BIG"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Time Units",
                    setOf("SECOND", "MINUTE", "HOUR", "DAY"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Animals",
                    setOf("CAT", "DOG", "FOX", "WOLF"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Colors",
                    setOf("RED", "BLUE", "BLACK", "WHITE"),
                    CategoryColor.PURPLE
                )
            ),
            "Easy"
        ),

        ConnectionPuzzle(
            70,
            listOf(
                "COUNT",
                "ADD",
                "TOTAL",
                "SUM",
                "CAR",
                "BUS",
                "TRAIN",
                "PLANE",
                "HAND",
                "FOOT",
                "ARM",
                "LEG",
                "SPRING",
                "SUMMER",
                "FALL",
                "WINTER"
            ),
            listOf(
                ConnectionCategory(
                    "Math Verbs",
                    setOf("COUNT", "ADD", "TOTAL", "SUM"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Transport",
                    setOf("CAR", "BUS", "TRAIN", "PLANE"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Body Parts",
                    setOf("HAND", "FOOT", "ARM", "LEG"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Seasons",
                    setOf("SPRING", "SUMMER", "FALL", "WINTER"),
                    CategoryColor.PURPLE
                )
            ),
            "Easy"
        ),

        // ---------- EASY FINAL (71–100) ----------
        ConnectionPuzzle(
            71,
            listOf(
                "ZERO",
                "ONE",
                "TWO",
                "THREE",
                "PEN",
                "PENCIL",
                "ERASER",
                "RULER",
                "SUN",
                "RAIN",
                "SNOW",
                "WIND",
                "DOG",
                "CAT",
                "BIRD",
                "FISH"
            ),
            listOf(
                ConnectionCategory(
                    "Numbers",
                    setOf("ZERO", "ONE", "TWO", "THREE"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Stationery",
                    setOf("PEN", "PENCIL", "ERASER", "RULER"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Weather",
                    setOf("SUN", "RAIN", "SNOW", "WIND"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Pets",
                    setOf("DOG", "CAT", "BIRD", "FISH"),
                    CategoryColor.PURPLE
                )
            ),
            "Easy"
        ),

        ConnectionPuzzle(
            72,
            listOf(
                "ADD",
                "SUB",
                "MUL",
                "DIV",
                "BOOK",
                "PAGE",
                "NOTE",
                "LINE",
                "RED",
                "GREEN",
                "BLUE",
                "YELLOW",
                "CAR",
                "TRUCK",
                "BUS",
                "VAN"
            ),
            listOf(
                ConnectionCategory(
                    "Math Operations",
                    setOf("ADD", "SUB", "MUL", "DIV"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Writing Terms",
                    setOf("BOOK", "PAGE", "NOTE", "LINE"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Colors",
                    setOf("RED", "GREEN", "BLUE", "YELLOW"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Vehicles",
                    setOf("CAR", "TRUCK", "BUS", "VAN"),
                    CategoryColor.PURPLE
                )
            ),
            "Easy"
        ),

        ConnectionPuzzle(
            73,
            listOf(
                "SECOND",
                "MINUTE",
                "HOUR",
                "DAY",
                "APPLE",
                "BANANA",
                "ORANGE",
                "GRAPE",
                "CHAIR",
                "TABLE",
                "BED",
                "SOFA",
                "HAND",
                "FOOT",
                "ARM",
                "LEG"
            ),
            listOf(
                ConnectionCategory(
                    "Time Units",
                    setOf("SECOND", "MINUTE", "HOUR", "DAY"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Fruits",
                    setOf("APPLE", "BANANA", "ORANGE", "GRAPE"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Furniture",
                    setOf("CHAIR", "TABLE", "BED", "SOFA"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Body Parts",
                    setOf("HAND", "FOOT", "ARM", "LEG"),
                    CategoryColor.PURPLE
                )
            ),
            "Easy"
        ),

        ConnectionPuzzle(
            74,
            listOf(
                "ONE",
                "TEN",
                "HUNDRED",
                "THOUSAND",
                "DOG",
                "CAT",
                "COW",
                "GOAT",
                "RED",
                "BLUE",
                "BLACK",
                "WHITE",
                "FORK",
                "SPOON",
                "KNIFE",
                "PLATE"
            ),
            listOf(
                ConnectionCategory(
                    "Number Scales",
                    setOf("ONE", "TEN", "HUNDRED", "THOUSAND"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Animals",
                    setOf("DOG", "CAT", "COW", "GOAT"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Colors",
                    setOf("RED", "BLUE", "BLACK", "WHITE"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Dining Items",
                    setOf("FORK", "SPOON", "KNIFE", "PLATE"),
                    CategoryColor.PURPLE
                )
            ),
            "Easy"
        ),

        ConnectionPuzzle(
            75,
            listOf(
                "CIRCLE",
                "SQUARE",
                "TRIANGLE",
                "RECTANGLE",
                "ADD",
                "PLUS",
                "SUM",
                "TOTAL",
                "CAR",
                "BUS",
                "TRAIN",
                "BIKE",
                "SUN",
                "MOON",
                "STAR",
                "SKY"
            ),
            listOf(
                ConnectionCategory(
                    "Shapes",
                    setOf("CIRCLE", "SQUARE", "TRIANGLE", "RECTANGLE"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Addition Words",
                    setOf("ADD", "PLUS", "SUM", "TOTAL"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Transport",
                    setOf("CAR", "BUS", "TRAIN", "BIKE"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Sky Objects",
                    setOf("SUN", "MOON", "STAR", "SKY"),
                    CategoryColor.PURPLE
                )
            ),
            "Easy"
        ),
        ConnectionPuzzle(
            76,
            listOf(
                "ADD",
                "SUB",
                "MUL",
                "DIV",
                "ONE",
                "TWO",
                "THREE",
                "FOUR",
                "DOG",
                "CAT",
                "COW",
                "GOAT",
                "RED",
                "BLUE",
                "GREEN",
                "YELLOW"
            ),
            listOf(
                ConnectionCategory(
                    "Math Operations",
                    setOf("ADD", "SUB", "MUL", "DIV"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Numbers",
                    setOf("ONE", "TWO", "THREE", "FOUR"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Animals",
                    setOf("DOG", "CAT", "COW", "GOAT"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Colors",
                    setOf("RED", "BLUE", "GREEN", "YELLOW"),
                    CategoryColor.PURPLE
                )
            ),
            "Easy-Medium"
        ),

        ConnectionPuzzle(
            77,
            listOf(
                "CIRCLE",
                "SQUARE",
                "TRIANGLE",
                "RECTANGLE",
                "SECOND",
                "MINUTE",
                "HOUR",
                "DAY",
                "CAR",
                "BUS",
                "TRAIN",
                "PLANE",
                "PEN",
                "PENCIL",
                "ERASER",
                "RULER"
            ),
            listOf(
                ConnectionCategory(
                    "Shapes",
                    setOf("CIRCLE", "SQUARE", "TRIANGLE", "RECTANGLE"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Time Units",
                    setOf("SECOND", "MINUTE", "HOUR", "DAY"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Transport",
                    setOf("CAR", "BUS", "TRAIN", "PLANE"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Stationery",
                    setOf("PEN", "PENCIL", "ERASER", "RULER"),
                    CategoryColor.PURPLE
                )
            ),
            "Easy-Medium"
        ),

        ConnectionPuzzle(
            78,
            listOf(
                "EVEN",
                "ODD",
                "PRIME",
                "ZERO",
                "SUN",
                "MOON",
                "STAR",
                "SKY",
                "APPLE",
                "BANANA",
                "ORANGE",
                "GRAPE",
                "HAND",
                "FOOT",
                "ARM",
                "LEG"
            ),
            listOf(
                ConnectionCategory(
                    "Number Types",
                    setOf("EVEN", "ODD", "PRIME", "ZERO"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Sky Objects",
                    setOf("SUN", "MOON", "STAR", "SKY"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Fruits",
                    setOf("APPLE", "BANANA", "ORANGE", "GRAPE"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Body Parts",
                    setOf("HAND", "FOOT", "ARM", "LEG"),
                    CategoryColor.PURPLE
                )
            ),
            "Easy-Medium"
        ),

        ConnectionPuzzle(
            79,
            listOf(
                "ADD",
                "PLUS",
                "SUM",
                "TOTAL",
                "FAST",
                "SLOW",
                "EARLY",
                "LATE",
                "DOG",
                "CAT",
                "FOX",
                "WOLF",
                "BOOK",
                "PAGE",
                "LINE",
                "WORD"
            ),
            listOf(
                ConnectionCategory(
                    "Addition Words",
                    setOf("ADD", "PLUS", "SUM", "TOTAL"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Time Descriptors",
                    setOf("FAST", "SLOW", "EARLY", "LATE"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Animals",
                    setOf("DOG", "CAT", "FOX", "WOLF"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Text Units",
                    setOf("BOOK", "PAGE", "LINE", "WORD"),
                    CategoryColor.PURPLE
                )
            ),
            "Easy-Medium"
        ),

        ConnectionPuzzle(
            80,
            listOf(
                "LEFT",
                "RIGHT",
                "UP",
                "DOWN",
                "ONE",
                "TEN",
                "HUNDRED",
                "THOUSAND",
                "MILK",
                "CHEESE",
                "BUTTER",
                "YOGURT",
                "CHAIR",
                "TABLE",
                "BED",
                "SOFA"
            ),
            listOf(
                ConnectionCategory(
                    "Directions",
                    setOf("LEFT", "RIGHT", "UP", "DOWN"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Number Scales",
                    setOf("ONE", "TEN", "HUNDRED", "THOUSAND"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Dairy Products",
                    setOf("MILK", "CHEESE", "BUTTER", "YOGURT"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Furniture",
                    setOf("CHAIR", "TABLE", "BED", "SOFA"),
                    CategoryColor.PURPLE
                )
            ),
            "Easy-Medium"
        ),

        // ---------- MEDIUM (81–100) ----------
        ConnectionPuzzle(
            81,
            listOf(
                "COUNT",
                "ADD",
                "TOTAL",
                "SUM",
                "MONDAY",
                "TUESDAY",
                "WEDNESDAY",
                "THURSDAY",
                "CAR",
                "BUS",
                "TRAIN",
                "BIKE",
                "SUN",
                "RAIN",
                "SNOW",
                "WIND"
            ),
            listOf(
                ConnectionCategory(
                    "Math Verbs",
                    setOf("COUNT", "ADD", "TOTAL", "SUM"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Weekdays",
                    setOf("MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Transport",
                    setOf("CAR", "BUS", "TRAIN", "BIKE"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Weather",
                    setOf("SUN", "RAIN", "SNOW", "WIND"),
                    CategoryColor.PURPLE
                )
            ),
            "Medium"
        ),

        ConnectionPuzzle(
            82,
            listOf(
                "CIRCLE",
                "CUBE",
                "SPHERE",
                "CONE",
                "SECOND",
                "MINUTE",
                "HOUR",
                "DAY",
                "RED",
                "GREEN",
                "BLUE",
                "YELLOW",
                "DOG",
                "CAT",
                "BIRD",
                "FISH"
            ),
            listOf(
                ConnectionCategory(
                    "3D Shapes",
                    setOf("CIRCLE", "CUBE", "SPHERE", "CONE"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Time Units",
                    setOf("SECOND", "MINUTE", "HOUR", "DAY"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Colors",
                    setOf("RED", "GREEN", "BLUE", "YELLOW"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Pets",
                    setOf("DOG", "CAT", "BIRD", "FISH"),
                    CategoryColor.PURPLE
                )
            ),
            "Medium"
        ),

        ConnectionPuzzle(
            83,
            listOf(
                "EVEN",
                "ODD",
                "SQUARE",
                "PRIME",
                "BUY",
                "SELL",
                "RENT",
                "LEASE",
                "PEN",
                "PENCIL",
                "MARKER",
                "CHALK",
                "APPLE",
                "MANGO",
                "PEAR",
                "PLUM"
            ),
            listOf(
                ConnectionCategory(
                    "Number Properties",
                    setOf("EVEN", "ODD", "SQUARE", "PRIME"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Property Actions",
                    setOf("BUY", "SELL", "RENT", "LEASE"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Writing Tools",
                    setOf("PEN", "PENCIL", "MARKER", "CHALK"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Fruits",
                    setOf("APPLE", "MANGO", "PEAR", "PLUM"),
                    CategoryColor.PURPLE
                )
            ),
            "Medium"
        ),

        ConnectionPuzzle(
            84,
            listOf(
                "POINT",
                "LINE",
                "RAY",
                "ANGLE",
                "ADD",
                "SUB",
                "MUL",
                "DIV",
                "SPRING",
                "SUMMER",
                "FALL",
                "WINTER",
                "HAND",
                "FOOT",
                "ARM",
                "LEG"
            ),
            listOf(
                ConnectionCategory(
                    "Geometry Basics",
                    setOf("POINT", "LINE", "RAY", "ANGLE"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Math Operations",
                    setOf("ADD", "SUB", "MUL", "DIV"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Seasons",
                    setOf("SPRING", "SUMMER", "FALL", "WINTER"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Body Parts",
                    setOf("HAND", "FOOT", "ARM", "LEG"),
                    CategoryColor.PURPLE
                )
            ),
            "Medium"
        ),

        ConnectionPuzzle(
            85,
            listOf(
                "ONE",
                "TWO",
                "FOUR",
                "EIGHT",
                "CPU",
                "RAM",
                "ROM",
                "GPU",
                "READ",
                "WRITE",
                "DRAW",
                "PAINT",
                "SUN",
                "MOON",
                "STAR",
                "PLANET"
            ),
            listOf(
                ConnectionCategory(
                    "Powers of Two",
                    setOf("ONE", "TWO", "FOUR", "EIGHT"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Computer Hardware",
                    setOf("CPU", "RAM", "ROM", "GPU"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Creative Actions",
                    setOf("READ", "WRITE", "DRAW", "PAINT"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Space Objects",
                    setOf("SUN", "MOON", "STAR", "PLANET"),
                    CategoryColor.PURPLE
                )
            ),
            "Medium"
        ),

        ConnectionPuzzle(
            86,
            listOf(
                "HALF",
                "DOUBLE",
                "TOTAL",
                "SUM",
                "CAR",
                "TRUCK",
                "BUS",
                "VAN",
                "RED",
                "BLUE",
                "BLACK",
                "WHITE",
                "DOG",
                "CAT",
                "HORSE",
                "COW"
            ),
            listOf(
                ConnectionCategory(
                    "Math Words",
                    setOf("HALF", "DOUBLE", "TOTAL", "SUM"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Vehicles",
                    setOf("CAR", "TRUCK", "BUS", "VAN"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Colors",
                    setOf("RED", "BLUE", "BLACK", "WHITE"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Animals",
                    setOf("DOG", "CAT", "HORSE", "COW"),
                    CategoryColor.PURPLE
                )
            ),
            "Medium"
        ),

        ConnectionPuzzle(
            87,
            listOf(
                "SECOND",
                "MINUTE",
                "HOUR",
                "DAY",
                "LOGIN",
                "LOGOUT",
                "UPLOAD",
                "DOWNLOAD",
                "BOOK",
                "PAGE",
                "NOTE",
                "LINE",
                "SUN",
                "RAIN",
                "SNOW",
                "WIND"
            ),
            listOf(
                ConnectionCategory(
                    "Time Units",
                    setOf("SECOND", "MINUTE", "HOUR", "DAY"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Computer Actions",
                    setOf("LOGIN", "LOGOUT", "UPLOAD", "DOWNLOAD"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Writing Terms",
                    setOf("BOOK", "PAGE", "NOTE", "LINE"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Weather",
                    setOf("SUN", "RAIN", "SNOW", "WIND"),
                    CategoryColor.PURPLE
                )
            ),
            "Medium"
        ),

        ConnectionPuzzle(
            88,
            listOf(
                "ADD",
                "PLUS",
                "MORE",
                "SUM",
                "LEFT",
                "RIGHT",
                "UP",
                "DOWN",
                "APPLE",
                "BANANA",
                "ORANGE",
                "GRAPE",
                "CHAIR",
                "TABLE",
                "BED",
                "SOFA"
            ),
            listOf(
                ConnectionCategory(
                    "Addition Words",
                    setOf("ADD", "PLUS", "MORE", "SUM"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Directions",
                    setOf("LEFT", "RIGHT", "UP", "DOWN"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Fruits",
                    setOf("APPLE", "BANANA", "ORANGE", "GRAPE"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Furniture",
                    setOf("CHAIR", "TABLE", "BED", "SOFA"),
                    CategoryColor.PURPLE
                )
            ),
            "Medium"
        ),

        ConnectionPuzzle(
            89,
            listOf(
                "EVEN",
                "ODD",
                "ZERO",
                "ONE",
                "PEN",
                "PENCIL",
                "ERASER",
                "RULER",
                "CAR",
                "BUS",
                "TRAIN",
                "PLANE",
                "SPRING",
                "SUMMER",
                "FALL",
                "WINTER"
            ),
            listOf(
                ConnectionCategory(
                    "Number Words",
                    setOf("EVEN", "ODD", "ZERO", "ONE"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Stationery",
                    setOf("PEN", "PENCIL", "ERASER", "RULER"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Transport",
                    setOf("CAR", "BUS", "TRAIN", "PLANE"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Seasons",
                    setOf("SPRING", "SUMMER", "FALL", "WINTER"),
                    CategoryColor.PURPLE
                )
            ),
            "Medium"
        ),

        ConnectionPuzzle(
            90,
            listOf(
                "CIRCLE",
                "SQUARE",
                "TRIANGLE",
                "RECTANGLE",
                "COUNT",
                "ADD",
                "TOTAL",
                "SUM",
                "DOG",
                "CAT",
                "BIRD",
                "FISH",
                "RED",
                "GREEN",
                "BLUE",
                "YELLOW"
            ),
            listOf(
                ConnectionCategory(
                    "Shapes",
                    setOf("CIRCLE", "SQUARE", "TRIANGLE", "RECTANGLE"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Math Verbs",
                    setOf("COUNT", "ADD", "TOTAL", "SUM"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory("Pets", setOf("DOG", "CAT", "BIRD", "FISH"), CategoryColor.BLUE),
                ConnectionCategory(
                    "Colors",
                    setOf("RED", "GREEN", "BLUE", "YELLOW"),
                    CategoryColor.PURPLE
                )
            ),
            "Medium"
        ),

        ConnectionPuzzle(
            91,
            listOf(
                "ONE",
                "TEN",
                "HUNDRED",
                "THOUSAND",
                "BOOK",
                "PAGE",
                "CHAPTER",
                "WORD",
                "SUN",
                "MOON",
                "STAR",
                "SKY",
                "CAR",
                "BUS",
                "TRAIN",
                "BIKE"
            ),
            listOf(
                ConnectionCategory(
                    "Number Scales",
                    setOf("ONE", "TEN", "HUNDRED", "THOUSAND"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Book Parts",
                    setOf("BOOK", "PAGE", "CHAPTER", "WORD"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Sky Objects",
                    setOf("SUN", "MOON", "STAR", "SKY"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Transport",
                    setOf("CAR", "BUS", "TRAIN", "BIKE"),
                    CategoryColor.PURPLE
                )
            ),
            "Medium"
        ),

        ConnectionPuzzle(
            92,
            listOf(
                "EVEN",
                "ODD",
                "PRIME",
                "SQUARE",
                "LOGIN",
                "LOGOUT",
                "UPLOAD",
                "DOWNLOAD",
                "MILK",
                "CHEESE",
                "BUTTER",
                "YOGURT",
                "HAND",
                "FOOT",
                "ARM",
                "LEG"
            ),
            listOf(
                ConnectionCategory(
                    "Number Properties",
                    setOf("EVEN", "ODD", "PRIME", "SQUARE"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "System Actions",
                    setOf("LOGIN", "LOGOUT", "UPLOAD", "DOWNLOAD"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Dairy Products",
                    setOf("MILK", "CHEESE", "BUTTER", "YOGURT"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Body Parts",
                    setOf("HAND", "FOOT", "ARM", "LEG"),
                    CategoryColor.PURPLE
                )
            ),
            "Medium"
        ),

        ConnectionPuzzle(
            93,
            listOf(
                "SECOND",
                "MINUTE",
                "HOUR",
                "DAY",
                "ADD",
                "SUB",
                "MUL",
                "DIV",
                "SUN",
                "RAIN",
                "SNOW",
                "WIND",
                "PEN",
                "PENCIL",
                "MARKER",
                "CHALK"
            ),
            listOf(
                ConnectionCategory(
                    "Time Units",
                    setOf("SECOND", "MINUTE", "HOUR", "DAY"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Math Operations",
                    setOf("ADD", "SUB", "MUL", "DIV"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Weather",
                    setOf("SUN", "RAIN", "SNOW", "WIND"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Writing Tools",
                    setOf("PEN", "PENCIL", "MARKER", "CHALK"),
                    CategoryColor.PURPLE
                )
            ),
            "Medium"
        ),

        ConnectionPuzzle(
            94,
            listOf(
                "CIRCLE",
                "CUBE",
                "SPHERE",
                "CONE",
                "FAST",
                "SLOW",
                "EARLY",
                "LATE",
                "DOG",
                "CAT",
                "FOX",
                "WOLF",
                "RED",
                "GREEN",
                "BLUE",
                "YELLOW"
            ),
            listOf(
                ConnectionCategory(
                    "3D Shapes",
                    setOf("CIRCLE", "CUBE", "SPHERE", "CONE"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Time Descriptors",
                    setOf("FAST", "SLOW", "EARLY", "LATE"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Animals",
                    setOf("DOG", "CAT", "FOX", "WOLF"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Colors",
                    setOf("RED", "GREEN", "BLUE", "YELLOW"),
                    CategoryColor.PURPLE
                )
            ),
            "Medium"
        ),

        ConnectionPuzzle(
            95,
            listOf(
                "ADD",
                "PLUS",
                "SUM",
                "TOTAL",
                "CAR",
                "TRUCK",
                "BUS",
                "VAN",
                "SUN",
                "MOON",
                "STAR",
                "PLANET",
                "FORK",
                "SPOON",
                "KNIFE",
                "PLATE"
            ),
            listOf(
                ConnectionCategory(
                    "Addition Words",
                    setOf("ADD", "PLUS", "SUM", "TOTAL"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Vehicles",
                    setOf("CAR", "TRUCK", "BUS", "VAN"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Space Objects",
                    setOf("SUN", "MOON", "STAR", "PLANET"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Dining Items",
                    setOf("FORK", "SPOON", "KNIFE", "PLATE"),
                    CategoryColor.PURPLE
                )
            ),
            "Medium"
        ),

        ConnectionPuzzle(
            96,
            listOf(
                "ONE",
                "TWO",
                "THREE",
                "FOUR",
                "POINT",
                "LINE",
                "RAY",
                "ANGLE",
                "BOOK",
                "PAGE",
                "NOTE",
                "WORD",
                "DOG",
                "CAT",
                "BIRD",
                "FISH"
            ),
            listOf(
                ConnectionCategory(
                    "Numbers",
                    setOf("ONE", "TWO", "THREE", "FOUR"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Geometry Basics",
                    setOf("POINT", "LINE", "RAY", "ANGLE"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Writing Terms",
                    setOf("BOOK", "PAGE", "NOTE", "WORD"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Pets",
                    setOf("DOG", "CAT", "BIRD", "FISH"),
                    CategoryColor.PURPLE
                )
            ),
            "Medium"
        ),

        ConnectionPuzzle(
            97,
            listOf(
                "EVEN",
                "ODD",
                "ZERO",
                "ONE",
                "LEFT",
                "RIGHT",
                "UP",
                "DOWN",
                "CHAIR",
                "TABLE",
                "BED",
                "SOFA",
                "MILK",
                "WATER",
                "TEA",
                "JUICE"
            ),
            listOf(
                ConnectionCategory(
                    "Number Words",
                    setOf("EVEN", "ODD", "ZERO", "ONE"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Directions",
                    setOf("LEFT", "RIGHT", "UP", "DOWN"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Furniture",
                    setOf("CHAIR", "TABLE", "BED", "SOFA"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Drinks",
                    setOf("MILK", "WATER", "TEA", "JUICE"),
                    CategoryColor.PURPLE
                )
            ),
            "Medium"
        ),

        ConnectionPuzzle(
            98,
            listOf(
                "SECOND",
                "MINUTE",
                "HOUR",
                "DAY",
                "ADD",
                "SUB",
                "MUL",
                "DIV",
                "APPLE",
                "BANANA",
                "ORANGE",
                "GRAPE",
                "CAR",
                "BUS",
                "TRAIN",
                "PLANE"
            ),
            listOf(
                ConnectionCategory(
                    "Time Units",
                    setOf("SECOND", "MINUTE", "HOUR", "DAY"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Math Operations",
                    setOf("ADD", "SUB", "MUL", "DIV"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Fruits",
                    setOf("APPLE", "BANANA", "ORANGE", "GRAPE"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Transport",
                    setOf("CAR", "BUS", "TRAIN", "PLANE"),
                    CategoryColor.PURPLE
                )
            ),
            "Medium"
        ),

        ConnectionPuzzle(
            99,
            listOf(
                "CIRCLE",
                "SQUARE",
                "TRIANGLE",
                "RECTANGLE",
                "COUNT",
                "ADD",
                "TOTAL",
                "SUM",
                "SUN",
                "RAIN",
                "SNOW",
                "WIND",
                "HAND",
                "FOOT",
                "ARM",
                "LEG"
            ),
            listOf(
                ConnectionCategory(
                    "Shapes",
                    setOf("CIRCLE", "SQUARE", "TRIANGLE", "RECTANGLE"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Math Verbs",
                    setOf("COUNT", "ADD", "TOTAL", "SUM"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Weather",
                    setOf("SUN", "RAIN", "SNOW", "WIND"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Body Parts",
                    setOf("HAND", "FOOT", "ARM", "LEG"),
                    CategoryColor.PURPLE
                )
            ),
            "Medium"
        ),

        ConnectionPuzzle(
            100,
            listOf(
                "ONE",
                "TEN",
                "HUNDRED",
                "THOUSAND",
                "ADD",
                "PLUS",
                "SUM",
                "TOTAL",
                "DOG",
                "CAT",
                "COW",
                "GOAT",
                "RED",
                "BLUE",
                "GREEN",
                "YELLOW"
            ),
            listOf(
                ConnectionCategory(
                    "Number Scales",
                    setOf("ONE", "TEN", "HUNDRED", "THOUSAND"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Addition Words",
                    setOf("ADD", "PLUS", "SUM", "TOTAL"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Animals",
                    setOf("DOG", "CAT", "COW", "GOAT"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Colors",
                    setOf("RED", "BLUE", "GREEN", "YELLOW"),
                    CategoryColor.PURPLE
                )
            ),
            "Medium"
        )
    )
}
