package com.neuronest.neuronest.connection

object ConnectionPuzzleDataPart3 {
    fun getPuzzles(): List<ConnectionPuzzle> = listOf(
        ConnectionPuzzle(
            201,
            listOf(
                "NOUN", "VERB", "ADJECTIVE", "ADVERB",
                "ATOM", "ION", "MOLECULE", "COMPOUND",
                "SUPPLY", "DEMAND", "PRICE", "MARKET",
                "CAUSE", "EFFECT", "CHAIN", "OUTCOME"
            ),
            listOf(
                ConnectionCategory(
                    "Parts of Speech",
                    setOf("NOUN", "VERB", "ADJECTIVE", "ADVERB"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Chemical Entities",
                    setOf("ATOM", "ION", "MOLECULE", "COMPOUND"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Economics Basics",
                    setOf("SUPPLY", "DEMAND", "PRICE", "MARKET"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Causality",
                    setOf("CAUSE", "EFFECT", "CHAIN", "OUTCOME"),
                    CategoryColor.PURPLE
                )
            ),
            "Medium-Hard"
        ),

        ConnectionPuzzle(
            202,
            listOf(
                "HYPOTHESIS", "EXPERIMENT", "DATA", "CONCLUSION",
                "INPUT", "OUTPUT", "LATENCY", "THROUGHPUT",
                "SENSATION", "PERCEPTION", "MEMORY", "RECALL",
                "ORBIT", "ROTATION", "REVOLUTION", "AXIS"
            ),
            listOf(
                ConnectionCategory(
                    "Scientific Method",
                    setOf("HYPOTHESIS", "EXPERIMENT", "DATA", "CONCLUSION"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "System Performance",
                    setOf("INPUT", "OUTPUT", "LATENCY", "THROUGHPUT"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Cognitive Process",
                    setOf("SENSATION", "PERCEPTION", "MEMORY", "RECALL"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Astronomy Motions",
                    setOf("ORBIT", "ROTATION", "REVOLUTION", "AXIS"),
                    CategoryColor.PURPLE
                )
            ),
            "Medium-Hard"
        ),

        ConnectionPuzzle(
            203,
            listOf(
                "MONARCHY", "DEMOCRACY", "OLIGARCHY", "AUTOCRACY",
                "PLAINTIFF", "DEFENDANT", "JURY", "VERDICT",
                "PRODUCER", "DISTRIBUTOR", "RETAILER", "CONSUMER",
                "PAST", "PRESENT", "FUTURE", "TIMELINE"
            ),
            listOf(
                ConnectionCategory(
                    "Forms of Government",
                    setOf("MONARCHY", "DEMOCRACY", "OLIGARCHY", "AUTOCRACY"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Legal Process",
                    setOf("PLAINTIFF", "DEFENDANT", "JURY", "VERDICT"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Supply Chain",
                    setOf("PRODUCER", "DISTRIBUTOR", "RETAILER", "CONSUMER"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Time Flow",
                    setOf("PAST", "PRESENT", "FUTURE", "TIMELINE"),
                    CategoryColor.PURPLE
                )
            ),
            "Medium-Hard"
        ),

        ConnectionPuzzle(
            204,
            listOf(
                "PHONEME", "MORPHEME", "SYLLABLE", "WORD",
                "PACKET", "ROUTER", "FIREWALL", "GATEWAY",
                "NEURON", "SYNAPSE", "SIGNAL", "RESPONSE",
                "SEED", "MUTATION", "SELECTION", "EVOLUTION"
            ),
            listOf(
                ConnectionCategory(
                    "Linguistics Units",
                    setOf("PHONEME", "MORPHEME", "SYLLABLE", "WORD"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Network Components",
                    setOf("PACKET", "ROUTER", "FIREWALL", "GATEWAY"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Neural Signaling",
                    setOf("NEURON", "SYNAPSE", "SIGNAL", "RESPONSE"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Evolutionary Process",
                    setOf("SEED", "MUTATION", "SELECTION", "EVOLUTION"),
                    CategoryColor.PURPLE
                )
            ),
            "Hard"
        ),

        ConnectionPuzzle(
            205,
            listOf(
                "ACID", "BASE", "SALT", "PH",
                "BULL", "BEAR", "VOLATILITY", "TREND",
                "GOAL", "MOTIVE", "ACTION", "RESULT",
                "SCRIPT", "SHOT", "EDIT", "RELEASE"
            ),
            listOf(
                ConnectionCategory(
                    "Chemistry Concepts",
                    setOf("ACID", "BASE", "SALT", "PH"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Stock Market Terms",
                    setOf("BULL", "BEAR", "VOLATILITY", "TREND"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Intent to Outcome",
                    setOf("GOAL", "MOTIVE", "ACTION", "RESULT"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Film Production",
                    setOf("SCRIPT", "SHOT", "EDIT", "RELEASE"),
                    CategoryColor.PURPLE
                )
            ),
            "Hard"
        ),

        ConnectionPuzzle(
            206,
            listOf(
                "INPUT", "PROCESS", "OUTPUT", "CONTROL",
                "THESIS", "ANTITHESIS", "SYNTHESIS", "DIALECTIC",
                "TRIGGER", "RESPONSE", "FEEDBACK", "ADAPTATION",
                "CORE", "MANTLE", "CRUST", "LITHOSPHERE"
            ),
            listOf(
                ConnectionCategory(
                    "Control Systems",
                    setOf("INPUT", "PROCESS", "OUTPUT", "CONTROL"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Dialectical Reasoning",
                    setOf("THESIS", "ANTITHESIS", "SYNTHESIS", "DIALECTIC"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Behavioral Loop",
                    setOf("TRIGGER", "RESPONSE", "FEEDBACK", "ADAPTATION"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Earth Layers",
                    setOf("CORE", "MANTLE", "CRUST", "LITHOSPHERE"),
                    CategoryColor.PURPLE
                )
            ),
            "Hard"
        ),

        ConnectionPuzzle(
            207,
            listOf(
                "BYTECODE", "COMPILER", "INTERPRETER", "RUNTIME",
                "RIGHT", "DUTY", "LAW", "JUSTICE",
                "EMOTION", "THOUGHT", "DECISION", "ACTION",
                "SPAWN", "GROW", "COMPETE", "SURVIVE"
            ),
            listOf(
                ConnectionCategory(
                    "Program Execution",
                    setOf("BYTECODE", "COMPILER", "INTERPRETER", "RUNTIME"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Legal Principles",
                    setOf("RIGHT", "DUTY", "LAW", "JUSTICE"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Cognitive Flow",
                    setOf("EMOTION", "THOUGHT", "DECISION", "ACTION"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Life Strategy",
                    setOf("SPAWN", "GROW", "COMPETE", "SURVIVE"),
                    CategoryColor.PURPLE
                )
            ),
            "Hard"
        ),

        ConnectionPuzzle(
            208,
            listOf(
                "LATENT", "EXPLICIT", "IMPLICIT", "CONSCIOUS",
                "SIGNAL", "NOISE", "FILTER", "AMPLIFY",
                "RISK", "REWARD", "COST", "BENEFIT",
                "CAUSE", "DELAY", "IMPACT", "AFTERMATH"
            ),
            listOf(
                ConnectionCategory(
                    "Mental Awareness",
                    setOf("LATENT", "EXPLICIT", "IMPLICIT", "CONSCIOUS"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Signal Processing",
                    setOf("SIGNAL", "NOISE", "FILTER", "AMPLIFY"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Decision Tradeoffs",
                    setOf("RISK", "REWARD", "COST", "BENEFIT"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Delayed Effects",
                    setOf("CAUSE", "DELAY", "IMPACT", "AFTERMATH"),
                    CategoryColor.PURPLE
                )
            ),
            "Hard"
        ),

        ConnectionPuzzle(
            209,
            listOf(
                "HARDWARE", "FIRMWARE", "SOFTWARE", "SERVICE",
                "INPUT", "ATTENTION", "FOCUS", "OUTPUT",
                "PLAN", "EXECUTE", "MONITOR", "ADJUST",
                "PROBLEM", "CONSTRAINT", "TRADEOFF", "SOLUTION"
            ),
            listOf(
                ConnectionCategory(
                    "System Layers",
                    setOf("HARDWARE", "FIRMWARE", "SOFTWARE", "SERVICE"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Human Processing",
                    setOf("INPUT", "ATTENTION", "FOCUS", "OUTPUT"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Control Loop",
                    setOf("PLAN", "EXECUTE", "MONITOR", "ADJUST"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Optimization Logic",
                    setOf("PROBLEM", "CONSTRAINT", "TRADEOFF", "SOLUTION"),
                    CategoryColor.PURPLE
                )
            ),
            "Hard"
        ),

        ConnectionPuzzle(
            210,
            listOf(
                "SEQUENCE", "PARALLEL", "CONDITIONAL", "LOOP",
                "NORM", "VALUE", "BELIEF", "ETHICS",
                "OBSERVE", "HYPOTHESIZE", "TEST", "REFINE",
                "STIMULUS", "REACTION", "LEARNING", "CHANGE"
            ),
            listOf(
                ConnectionCategory(
                    "Programming Flow",
                    setOf("SEQUENCE", "PARALLEL", "CONDITIONAL", "LOOP"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Moral Framework",
                    setOf("NORM", "VALUE", "BELIEF", "ETHICS"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Scientific Inquiry",
                    setOf("OBSERVE", "HYPOTHESIZE", "TEST", "REFINE"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Adaptive Behavior",
                    setOf("STIMULUS", "REACTION", "LEARNING", "CHANGE"),
                    CategoryColor.PURPLE
                )
            ),
            "Hard"
        ),

        ConnectionPuzzle(
            211,
            listOf(
                "ASSUMPTION", "PREMISE", "INFERENCE", "CONCLUSION",
                "ENCODE", "TRANSMIT", "DECODE", "INTERPRET",
                "SCARCITY", "CHOICE", "OPPORTUNITY", "COST",
                "TRIAL", "ERROR", "LEARNING", "MASTERY"
            ),
            listOf(
                ConnectionCategory(
                    "Logical Reasoning",
                    setOf("ASSUMPTION", "PREMISE", "INFERENCE", "CONCLUSION"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Communication Cycle",
                    setOf("ENCODE", "TRANSMIT", "DECODE", "INTERPRET"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Economic Decision Making",
                    setOf("SCARCITY", "CHOICE", "OPPORTUNITY", "COST"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Skill Acquisition",
                    setOf("TRIAL", "ERROR", "LEARNING", "MASTERY"),
                    CategoryColor.PURPLE
                )
            ),
            "Hard+"
        ),

        ConnectionPuzzle(
            212,
            listOf(
                "LATENT", "MANIFEST", "SYMPTOM", "DIAGNOSIS",
                "SEED", "VARIATION", "PRESSURE", "ADAPTATION",
                "PLAN", "RISK", "EXECUTE", "EVALUATE",
                "INPUT", "FILTER", "WEIGHT", "DECISION"
            ),
            listOf(
                ConnectionCategory(
                    "Medical Reasoning",
                    setOf("LATENT", "MANIFEST", "SYMPTOM", "DIAGNOSIS"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Natural Selection",
                    setOf("SEED", "VARIATION", "PRESSURE", "ADAPTATION"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Strategic Planning",
                    setOf("PLAN", "RISK", "EXECUTE", "EVALUATE"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Decision Pipeline",
                    setOf("INPUT", "FILTER", "WEIGHT", "DECISION"),
                    CategoryColor.PURPLE
                )
            ),
            "Hard+"
        ),

        ConnectionPuzzle(
            213,
            listOf(
                "SIGNAL", "PATTERN", "ANOMALY", "INSIGHT",
                "HYPOTHESIS", "MODEL", "PREDICTION", "VALIDATION",
                "CAUSE", "MECHANISM", "EFFECT", "IMPACT",
                "QUESTION", "SEARCH", "SYNTHESIS", "ANSWER"
            ),
            listOf(
                ConnectionCategory(
                    "Data Analysis",
                    setOf("SIGNAL", "PATTERN", "ANOMALY", "INSIGHT"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Scientific Modeling",
                    setOf("HYPOTHESIS", "MODEL", "PREDICTION", "VALIDATION"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Causal Chain",
                    setOf("CAUSE", "MECHANISM", "EFFECT", "IMPACT"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Knowledge Construction",
                    setOf("QUESTION", "SEARCH", "SYNTHESIS", "ANSWER"),
                    CategoryColor.PURPLE
                )
            ),
            "Hard+"
        ),

        ConnectionPuzzle(
            214,
            listOf(
                "PERCEPTION", "ATTENTION", "INTERPRETATION", "BELIEF",
                "NORM", "DEVIATION", "ENFORCEMENT", "COMPLIANCE",
                "PLAN", "ALLOCATE", "OPTIMIZE", "SCALE",
                "SEED", "IDEA", "PROTOTYPE", "PIVOT"
            ),
            listOf(
                ConnectionCategory(
                    "Cognitive Bias Flow",
                    setOf("PERCEPTION", "ATTENTION", "INTERPRETATION", "BELIEF"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Social Regulation",
                    setOf("NORM", "DEVIATION", "ENFORCEMENT", "COMPLIANCE"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Resource Strategy",
                    setOf("PLAN", "ALLOCATE", "OPTIMIZE", "SCALE"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Startup Evolution",
                    setOf("SEED", "IDEA", "PROTOTYPE", "PIVOT"),
                    CategoryColor.PURPLE
                )
            ),
            "Hard+"
        ),

        ConnectionPuzzle(
            215,
            listOf(
                "MODEL", "ASSUMPTION", "LIMITATION", "FAILURE",
                "TRIGGER", "REACTION", "ESCALATION", "CRISIS",
                "OBSERVE", "MEASURE", "COMPARE", "CONCLUDE",
                "INPUT", "DELAY", "FEEDBACK", "STABILITY"
            ),
            listOf(
                ConnectionCategory(
                    "Model Weaknesses",
                    setOf("MODEL", "ASSUMPTION", "LIMITATION", "FAILURE"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Crisis Dynamics",
                    setOf("TRIGGER", "REACTION", "ESCALATION", "CRISIS"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Empirical Reasoning",
                    setOf("OBSERVE", "MEASURE", "COMPARE", "CONCLUDE"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Control Systems",
                    setOf("INPUT", "DELAY", "FEEDBACK", "STABILITY"),
                    CategoryColor.PURPLE
                )
            ),
            "Hard+"
        ),

        ConnectionPuzzle(
            216,
            listOf(
                "SYMBOL", "MEANING", "CONTEXT", "INTERPRETATION",
                "VALUE", "INCENTIVE", "BEHAVIOR", "OUTCOME",
                "PLAN", "SIMULATE", "TEST", "REFINE",
                "NOISE", "FILTER", "SIGNAL", "CLARITY"
            ),
            listOf(
                ConnectionCategory(
                    "Semiotics",
                    setOf("SYMBOL", "MEANING", "CONTEXT", "INTERPRETATION"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Behavioral Economics",
                    setOf("VALUE", "INCENTIVE", "BEHAVIOR", "OUTCOME"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Iteration Loop",
                    setOf("PLAN", "SIMULATE", "TEST", "REFINE"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Signal Extraction",
                    setOf("NOISE", "FILTER", "SIGNAL", "CLARITY"),
                    CategoryColor.PURPLE
                )
            ),
            "Hard+"
        ),

        ConnectionPuzzle(
            217,
            listOf(
                "QUESTION", "ASSUMPTION", "CHALLENGE", "REFRAME",
                "RULE", "EXCEPTION", "EDGE", "CASE",
                "PLAN", "PRIORITIZE", "EXECUTE", "REVIEW",
                "INPUT", "TRANSFORM", "AGGREGATE", "INSIGHT"
            ),
            listOf(
                ConnectionCategory(
                    "Critical Thinking",
                    setOf("QUESTION", "ASSUMPTION", "CHALLENGE", "REFRAME"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Edge Conditions",
                    setOf("RULE", "EXCEPTION", "EDGE", "CASE"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Execution Cycle",
                    setOf("PLAN", "PRIORITIZE", "EXECUTE", "REVIEW"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Analytics Pipeline",
                    setOf("INPUT", "TRANSFORM", "AGGREGATE", "INSIGHT"),
                    CategoryColor.PURPLE
                )
            ),
            "Hard+"
        ),

        ConnectionPuzzle(
            218,
            listOf(
                "CAUSE", "CORRELATION", "CONFOUND", "ERROR",
                "PLAN", "HEDGE", "MITIGATE", "INSURE",
                "EXPECTATION", "REALITY", "GAP", "ADJUSTMENT",
                "STIMULUS", "RESPONSE", "LEARNING", "ADAPTATION"
            ),
            listOf(
                ConnectionCategory(
                    "Statistical Pitfalls",
                    setOf("CAUSE", "CORRELATION", "CONFOUND", "ERROR"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Risk Management",
                    setOf("PLAN", "HEDGE", "MITIGATE", "INSURE"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Expectation Management",
                    setOf("EXPECTATION", "REALITY", "GAP", "ADJUSTMENT"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Adaptive Systems",
                    setOf("STIMULUS", "RESPONSE", "LEARNING", "ADAPTATION"),
                    CategoryColor.PURPLE
                )
            ),
            "Hard+"
        ),

        ConnectionPuzzle(
            219,
            listOf(
                "FRAME", "ASSUMPTION", "BIAS", "DECISION",
                "RULE", "PROCESS", "OUTCOME", "ACCOUNTABILITY",
                "SEED", "INVEST", "GROW", "HARVEST",
                "QUESTION", "EXPLORE", "SYNTHESIZE", "DECIDE"
            ),
            listOf(
                ConnectionCategory(
                    "Decision Framing",
                    setOf("FRAME", "ASSUMPTION", "BIAS", "DECISION"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Governance Cycle",
                    setOf("RULE", "PROCESS", "OUTCOME", "ACCOUNTABILITY"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Investment Lifecycle",
                    setOf("SEED", "INVEST", "GROW", "HARVEST"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Strategic Thinking",
                    setOf("QUESTION", "EXPLORE", "SYNTHESIZE", "DECIDE"),
                    CategoryColor.PURPLE
                )
            ),
            "Hard+"
        ),

        ConnectionPuzzle(
            220,
            listOf(
                "MODEL", "SIMULATION", "SCENARIO", "PROJECTION",
                "SIGNAL", "TREND", "SHIFT", "REGIME",
                "PLAN", "COORDINATE", "EXECUTE", "ALIGN",
                "INPUT", "CONSTRAINT", "TRADEOFF", "OPTIMUM"
            ),
            listOf(
                ConnectionCategory(
                    "Forecasting Tools",
                    setOf("MODEL", "SIMULATION", "SCENARIO", "PROJECTION"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "System Change",
                    setOf("SIGNAL", "TREND", "SHIFT", "REGIME"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Organizational Action",
                    setOf("PLAN", "COORDINATE", "EXECUTE", "ALIGN"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Optimization Logic",
                    setOf("INPUT", "CONSTRAINT", "TRADEOFF", "OPTIMUM"),
                    CategoryColor.PURPLE
                )
            ),
            "Hard+"
        ),
        ConnectionPuzzle(
            221,
            listOf(
                "SIGN", "SYMBOL", "MEANING", "REFERENCE",
                "INCENTIVE", "MOTIVATION", "BEHAVIOR", "OUTCOME",
                "PLAN", "SIMULATE", "EXECUTE", "EVALUATE",
                "INPUT", "SIGNAL", "INTERPRET", "DECIDE"
            ),
            listOf(
                ConnectionCategory(
                    "Semiotic Chain",
                    setOf("SIGN", "SYMBOL", "MEANING", "REFERENCE"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Behavior Economics Loop",
                    setOf("INCENTIVE", "MOTIVATION", "BEHAVIOR", "OUTCOME"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Strategy Cycle",
                    setOf("PLAN", "SIMULATE", "EXECUTE", "EVALUATE"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Decision Pipeline",
                    setOf("INPUT", "SIGNAL", "INTERPRET", "DECIDE"),
                    CategoryColor.PURPLE
                )
            ),
            "Hard+"
        ),

        ConnectionPuzzle(
            222,
            listOf(
                "OBSERVATION", "PATTERN", "HYPOTHESIS", "INSIGHT",
                "RULE", "EXCEPTION", "VIOLATION", "ENFORCEMENT",
                "CAUSE", "MECHANISM", "EFFECT", "IMPACT",
                "QUESTION", "SEARCH", "FILTER", "ANSWER"
            ),
            listOf(
                ConnectionCategory(
                    "Insight Formation",
                    setOf("OBSERVATION", "PATTERN", "HYPOTHESIS", "INSIGHT"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Regulatory Logic",
                    setOf("RULE", "EXCEPTION", "VIOLATION", "ENFORCEMENT"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Causal Reasoning",
                    setOf("CAUSE", "MECHANISM", "EFFECT", "IMPACT"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Information Retrieval",
                    setOf("QUESTION", "SEARCH", "FILTER", "ANSWER"),
                    CategoryColor.PURPLE
                )
            ),
            "Hard+"
        ),

        ConnectionPuzzle(
            223,
            listOf(
                "MODEL", "ASSUMPTION", "SIMPLIFICATION", "ERROR",
                "SIGNAL", "NOISE", "DISTORTION", "LOSS",
                "PLAN", "COORDINATE", "ALIGN", "EXECUTE",
                "EXPECTATION", "REALITY", "GAP", "REVISION"
            ),
            listOf(
                ConnectionCategory(
                    "Model Limitations",
                    setOf("MODEL", "ASSUMPTION", "SIMPLIFICATION", "ERROR"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Signal Degradation",
                    setOf("SIGNAL", "NOISE", "DISTORTION", "LOSS"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Operational Alignment",
                    setOf("PLAN", "COORDINATE", "ALIGN", "EXECUTE"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Expectation Adjustment",
                    setOf("EXPECTATION", "REALITY", "GAP", "REVISION"),
                    CategoryColor.PURPLE
                )
            ),
            "Hard+"
        ),

        ConnectionPuzzle(
            224,
            listOf(
                "VALUE", "TRADEOFF", "PRIORITY", "CHOICE",
                "INPUT", "LATENCY", "THROUGHPUT", "CAPACITY",
                "TRIGGER", "REACTION", "ESCALATION", "CRISIS",
                "SEED", "INVEST", "SCALE", "EXIT"
            ),
            listOf(
                ConnectionCategory(
                    "Decision Constraints",
                    setOf("VALUE", "TRADEOFF", "PRIORITY", "CHOICE"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "System Performance",
                    setOf("INPUT", "LATENCY", "THROUGHPUT", "CAPACITY"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Crisis Escalation",
                    setOf("TRIGGER", "REACTION", "ESCALATION", "CRISIS"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Venture Lifecycle",
                    setOf("SEED", "INVEST", "SCALE", "EXIT"),
                    CategoryColor.PURPLE
                )
            ),
            "Hard+"
        ),

        ConnectionPuzzle(
            225,
            listOf(
                "QUESTION", "ASSUMPTION", "REFRAME", "CLARITY",
                "NORM", "PRESSURE", "CONFORMITY", "DEVIATION",
                "PLAN", "TEST", "MEASURE", "REFINE",
                "INPUT", "TRANSFORM", "SYNTHESIZE", "INSIGHT"
            ),
            listOf(
                ConnectionCategory(
                    "Critical Thinking",
                    setOf("QUESTION", "ASSUMPTION", "REFRAME", "CLARITY"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Social Dynamics",
                    setOf("NORM", "PRESSURE", "CONFORMITY", "DEVIATION"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Experimental Loop",
                    setOf("PLAN", "TEST", "MEASURE", "REFINE"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Knowledge Pipeline",
                    setOf("INPUT", "TRANSFORM", "SYNTHESIZE", "INSIGHT"),
                    CategoryColor.PURPLE
                )
            ),
            "Hard+"
        ),

        ConnectionPuzzle(
            226,
            listOf(
                "SIGNAL", "TREND", "SHIFT", "REGIME",
                "GOAL", "CONSTRAINT", "TRADEOFF", "OPTIMUM",
                "PLAN", "ALLOCATE", "EXECUTE", "MONITOR",
                "STIMULUS", "RESPONSE", "FEEDBACK", "ADAPT"
            ),
            listOf(
                ConnectionCategory(
                    "System Change Detection",
                    setOf("SIGNAL", "TREND", "SHIFT", "REGIME"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Optimization Theory",
                    setOf("GOAL", "CONSTRAINT", "TRADEOFF", "OPTIMUM"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Operational Control",
                    setOf("PLAN", "ALLOCATE", "EXECUTE", "MONITOR"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Adaptive Loop",
                    setOf("STIMULUS", "RESPONSE", "FEEDBACK", "ADAPT"),
                    CategoryColor.PURPLE
                )
            ),
            "Hard+"
        ),

        ConnectionPuzzle(
            227,
            listOf(
                "FRAME", "BIAS", "DISTORTION", "DECISION",
                "RULE", "PROCESS", "OUTCOME", "ACCOUNTABILITY",
                "INPUT", "FILTER", "WEIGHT", "SCORE",
                "QUESTION", "EXPLORE", "CONNECT", "CONCLUDE"
            ),
            listOf(
                ConnectionCategory(
                    "Decision Bias",
                    setOf("FRAME", "BIAS", "DISTORTION", "DECISION"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Governance Cycle",
                    setOf("RULE", "PROCESS", "OUTCOME", "ACCOUNTABILITY"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Scoring Model",
                    setOf("INPUT", "FILTER", "WEIGHT", "SCORE"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Reasoning Path",
                    setOf("QUESTION", "EXPLORE", "CONNECT", "CONCLUDE"),
                    CategoryColor.PURPLE
                )
            ),
            "Hard+"
        ),

        ConnectionPuzzle(
            228,
            listOf(
                "MODEL", "SIMULATE", "STRESS", "FAIL",
                "SIGNAL", "ANOMALY", "INVESTIGATE", "RESOLVE",
                "PLAN", "BUFFER", "REDUNDANCY", "RECOVER",
                "EXPECTATION", "SURPRISE", "UPDATE", "LEARN"
            ),
            listOf(
                ConnectionCategory(
                    "Failure Testing",
                    setOf("MODEL", "SIMULATE", "STRESS", "FAIL"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Incident Response",
                    setOf("SIGNAL", "ANOMALY", "INVESTIGATE", "RESOLVE"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Resilience Design",
                    setOf("PLAN", "BUFFER", "REDUNDANCY", "RECOVER"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Learning Loop",
                    setOf("EXPECTATION", "SURPRISE", "UPDATE", "LEARN"),
                    CategoryColor.PURPLE
                )
            ),
            "Hard+"
        ),

        ConnectionPuzzle(
            229,
            listOf(
                "VALUE", "INCENTIVE", "BEHAVIOR", "PATTERN",
                "CAUSE", "CORRELATION", "CONFOUND", "ERROR",
                "INPUT", "AGGREGATE", "MODEL", "PREDICT",
                "QUESTION", "SEARCH", "FILTER", "DECIDE"
            ),
            listOf(
                ConnectionCategory(
                    "Behavior Formation",
                    setOf("VALUE", "INCENTIVE", "BEHAVIOR", "PATTERN"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Statistical Traps",
                    setOf("CAUSE", "CORRELATION", "CONFOUND", "ERROR"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Predictive Pipeline",
                    setOf("INPUT", "AGGREGATE", "MODEL", "PREDICT"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Decision Search",
                    setOf("QUESTION", "SEARCH", "FILTER", "DECIDE"),
                    CategoryColor.PURPLE
                )
            ),
            "Hard+"
        ),

        ConnectionPuzzle(
            230,
            listOf(
                "ASSUMPTION", "RISK", "UNCERTAINTY", "EXPOSURE",
                "PLAN", "HEDGE", "MITIGATE", "ABSORB",
                "SIGNAL", "SHIFT", "RESPONSE", "ADJUST",
                "INPUT", "CONSTRAINT", "TRADEOFF", "BALANCE"
            ),
            listOf(
                ConnectionCategory(
                    "Risk Structure",
                    setOf("ASSUMPTION", "RISK", "UNCERTAINTY", "EXPOSURE"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Risk Management",
                    setOf("PLAN", "HEDGE", "MITIGATE", "ABSORB"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Adaptive Response",
                    setOf("SIGNAL", "SHIFT", "RESPONSE", "ADJUST"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Constraint Balancing",
                    setOf("INPUT", "CONSTRAINT", "TRADEOFF", "BALANCE"),
                    CategoryColor.PURPLE
                )
            ),
            "Hard+"
        ),

        ConnectionPuzzle(
            231,
            listOf(
                "SIGNAL", "INDICATOR", "METRIC", "BENCHMARK",
                "GOAL", "PLAN", "EXECUTION", "REVIEW",
                "ASSUMPTION", "TEST", "INVALIDATE", "REVISE",
                "STIMULUS", "INTERPRETATION", "REACTION", "OUTCOME"
            ),
            listOf(
                ConnectionCategory(
                    "Performance Measurement",
                    setOf("SIGNAL", "INDICATOR", "METRIC", "BENCHMARK"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Goal Management",
                    setOf("GOAL", "PLAN", "EXECUTION", "REVIEW"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Hypothesis Correction",
                    setOf("ASSUMPTION", "TEST", "INVALIDATE", "REVISE"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Behavioral Response",
                    setOf("STIMULUS", "INTERPRETATION", "REACTION", "OUTCOME"),
                    CategoryColor.PURPLE
                )
            ),
            "Hard+"
        ),

        ConnectionPuzzle(
            232,
            listOf(
                "FRAME", "CONTEXT", "MEANING", "INTERPRETATION",
                "CONSTRAINT", "LIMIT", "BOUNDARY", "TRADEOFF",
                "PLAN", "BUFFER", "BACKUP", "RECOVERY",
                "OBSERVE", "COMPARE", "DIFFER", "CONCLUDE"
            ),
            listOf(
                ConnectionCategory(
                    "Meaning Construction",
                    setOf("FRAME", "CONTEXT", "MEANING", "INTERPRETATION"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Constraint Handling",
                    setOf("CONSTRAINT", "LIMIT", "BOUNDARY", "TRADEOFF"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "System Resilience",
                    setOf("PLAN", "BUFFER", "BACKUP", "RECOVERY"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Analytical Reasoning",
                    setOf("OBSERVE", "COMPARE", "DIFFER", "CONCLUDE"),
                    CategoryColor.PURPLE
                )
            ),
            "Hard+"
        ),

        ConnectionPuzzle(
            233,
            listOf(
                "SIGNAL", "PATTERN", "SHIFT", "BREAK",
                "VALUE", "INCENTIVE", "ACTION", "REACTION",
                "QUESTION", "EXPLORE", "CONNECT", "INSIGHT",
                "PLAN", "ALLOCATE", "TRACK", "ADJUST"
            ),
            listOf(
                ConnectionCategory(
                    "Trend Disruption",
                    setOf("SIGNAL", "PATTERN", "SHIFT", "BREAK"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Behavior Drivers",
                    setOf("VALUE", "INCENTIVE", "ACTION", "REACTION"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Insight Discovery",
                    setOf("QUESTION", "EXPLORE", "CONNECT", "INSIGHT"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Operational Control",
                    setOf("PLAN", "ALLOCATE", "TRACK", "ADJUST"),
                    CategoryColor.PURPLE
                )
            ),
            "Hard+"
        ),

        ConnectionPuzzle(
            234,
            listOf(
                "CAUSE", "CHAIN", "ESCALATION", "CRISIS",
                "ASSUMPTION", "BIAS", "DISTORTION", "ERROR",
                "PLAN", "COORDINATE", "EXECUTE", "ALIGN",
                "INPUT", "FILTER", "WEIGHT", "DECISION"
            ),
            listOf(
                ConnectionCategory(
                    "Crisis Formation",
                    setOf("CAUSE", "CHAIN", "ESCALATION", "CRISIS"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Cognitive Distortion",
                    setOf("ASSUMPTION", "BIAS", "DISTORTION", "ERROR"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Strategic Alignment",
                    setOf("PLAN", "COORDINATE", "EXECUTE", "ALIGN"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Decision Modeling",
                    setOf("INPUT", "FILTER", "WEIGHT", "DECISION"),
                    CategoryColor.PURPLE
                )
            ),
            "Hard+"
        ),

        ConnectionPuzzle(
            235,
            listOf(
                "MODEL", "SIMPLIFY", "APPROXIMATE", "PREDICT",
                "SIGNAL", "NOISE", "DISTORT", "SUPPRESS",
                "GOAL", "METRIC", "TARGET", "INCENTIVE",
                "QUESTION", "SEARCH", "FILTER", "ANSWER"
            ),
            listOf(
                ConnectionCategory(
                    "Predictive Modeling",
                    setOf("MODEL", "SIMPLIFY", "APPROXIMATE", "PREDICT"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Signal Interference",
                    setOf("SIGNAL", "NOISE", "DISTORT", "SUPPRESS"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Goal Setting",
                    setOf("GOAL", "METRIC", "TARGET", "INCENTIVE"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Information Retrieval",
                    setOf("QUESTION", "SEARCH", "FILTER", "ANSWER"),
                    CategoryColor.PURPLE
                )
            ),
            "Hard+"
        ),

        ConnectionPuzzle(
            236,
            listOf(
                "VALUE", "COST", "BENEFIT", "TRADEOFF",
                "PLAN", "HEDGE", "REDUCE", "ABSORB",
                "EXPECTATION", "OUTCOME", "GAP", "REVISION",
                "STIMULUS", "RESPONSE", "LEARNING", "CHANGE"
            ),
            listOf(
                ConnectionCategory(
                    "Economic Evaluation",
                    setOf("VALUE", "COST", "BENEFIT", "TRADEOFF"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Risk Mitigation",
                    setOf("PLAN", "HEDGE", "REDUCE", "ABSORB"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Expectation Management",
                    setOf("EXPECTATION", "OUTCOME", "GAP", "REVISION"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Adaptive Learning",
                    setOf("STIMULUS", "RESPONSE", "LEARNING", "CHANGE"),
                    CategoryColor.PURPLE
                )
            ),
            "Hard+"
        ),

        ConnectionPuzzle(
            237,
            listOf(
                "INPUT", "PROCESS", "OUTPUT", "FEEDBACK",
                "RULE", "EDGE", "EXCEPTION", "CASE",
                "PLAN", "EXECUTE", "MONITOR", "IMPROVE",
                "QUESTION", "ANALYZE", "SYNTHESIZE", "DECIDE"
            ),
            listOf(
                ConnectionCategory(
                    "Feedback System",
                    setOf("INPUT", "PROCESS", "OUTPUT", "FEEDBACK"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Edge Logic",
                    setOf("RULE", "EDGE", "EXCEPTION", "CASE"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Continuous Improvement",
                    setOf("PLAN", "EXECUTE", "MONITOR", "IMPROVE"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Decision Reasoning",
                    setOf("QUESTION", "ANALYZE", "SYNTHESIZE", "DECIDE"),
                    CategoryColor.PURPLE
                )
            ),
            "Hard+"
        ),

        ConnectionPuzzle(
            238,
            listOf(
                "SIGNAL", "DETECT", "CONFIRM", "ACT",
                "ASSUMPTION", "TEST", "FAIL", "LEARN",
                "GOAL", "PRIORITY", "FOCUS", "EXECUTION",
                "INPUT", "AGGREGATE", "MODEL", "PREDICT"
            ),
            listOf(
                ConnectionCategory(
                    "Alert Response",
                    setOf("SIGNAL", "DETECT", "CONFIRM", "ACT"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Failure Learning",
                    setOf("ASSUMPTION", "TEST", "FAIL", "LEARN"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Execution Focus",
                    setOf("GOAL", "PRIORITY", "FOCUS", "EXECUTION"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Predictive Analytics",
                    setOf("INPUT", "AGGREGATE", "MODEL", "PREDICT"),
                    CategoryColor.PURPLE
                )
            ),
            "Hard+"
        ),

        ConnectionPuzzle(
            239,
            listOf(
                "FRAME", "PERSPECTIVE", "INTERPRET", "CONCLUDE",
                "VALUE", "INCENTIVE", "BEHAVIOR", "SHIFT",
                "PLAN", "SIMULATE", "STRESS", "ADJUST",
                "STIMULUS", "REACTION", "ESCALATE", "RESOLVE"
            ),
            listOf(
                ConnectionCategory(
                    "Perspective Reasoning",
                    setOf("FRAME", "PERSPECTIVE", "INTERPRET", "CONCLUDE"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Behavior Change",
                    setOf("VALUE", "INCENTIVE", "BEHAVIOR", "SHIFT"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Stress Testing",
                    setOf("PLAN", "SIMULATE", "STRESS", "ADJUST"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Conflict Resolution",
                    setOf("STIMULUS", "REACTION", "ESCALATE", "RESOLVE"),
                    CategoryColor.PURPLE
                )
            ),
            "Hard+"
        ),

        ConnectionPuzzle(
            240,
            listOf(
                "MODEL", "SCENARIO", "OUTCOME", "IMPACT",
                "INPUT", "CONSTRAINT", "TRADEOFF", "OPTIMIZE",
                "QUESTION", "EXPLORE", "EVALUATE", "DECIDE",
                "SIGNAL", "SHIFT", "RESPONSE", "ADAPT"
            ),
            listOf(
                ConnectionCategory(
                    "Scenario Analysis",
                    setOf("MODEL", "SCENARIO", "OUTCOME", "IMPACT"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Optimization Problem",
                    setOf("INPUT", "CONSTRAINT", "TRADEOFF", "OPTIMIZE"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Strategic Choice",
                    setOf("QUESTION", "EXPLORE", "EVALUATE", "DECIDE"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Adaptive Response",
                    setOf("SIGNAL", "SHIFT", "RESPONSE", "ADAPT"),
                    CategoryColor.PURPLE
                )
            ),
            "Hard+"
        ),

        ConnectionPuzzle(
            241,
            listOf(
                "ASSUMPTION", "UNCERTAINTY", "RISK", "EXPOSURE",
                "PLAN", "BUFFER", "HEDGE", "RECOVER",
                "SIGNAL", "TREND", "SHIFT", "REGIME",
                "QUESTION", "REFRAME", "SIMPLIFY", "CLARIFY"
            ),
            listOf(
                ConnectionCategory(
                    "Risk Structure",
                    setOf("ASSUMPTION", "UNCERTAINTY", "RISK", "EXPOSURE"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Risk Protection",
                    setOf("PLAN", "BUFFER", "HEDGE", "RECOVER"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "System Change",
                    setOf("SIGNAL", "TREND", "SHIFT", "REGIME"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Problem Framing",
                    setOf("QUESTION", "REFRAME", "SIMPLIFY", "CLARIFY"),
                    CategoryColor.PURPLE
                )
            ),
            "Hard+"
        ),

        ConnectionPuzzle(
            242,
            listOf(
                "VALUE", "PRIORITY", "CHOICE", "COMMITMENT",
                "INPUT", "FILTER", "RANK", "SELECT",
                "PLAN", "EXECUTE", "VERIFY", "COMPLETE",
                "STIMULUS", "PROCESS", "LEARN", "ADAPT"
            ),
            listOf(
                ConnectionCategory(
                    "Commitment Logic",
                    setOf("VALUE", "PRIORITY", "CHOICE", "COMMITMENT"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Selection Pipeline",
                    setOf("INPUT", "FILTER", "RANK", "SELECT"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Task Completion",
                    setOf("PLAN", "EXECUTE", "VERIFY", "COMPLETE"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Adaptive Processing",
                    setOf("STIMULUS", "PROCESS", "LEARN", "ADAPT"),
                    CategoryColor.PURPLE
                )
            ),
            "Hard+"
        ),

        ConnectionPuzzle(
            243,
            listOf(
                "SIGNAL", "METRIC", "THRESHOLD", "ALERT",
                "CAUSE", "CONFOUND", "CORRELATION", "ERROR",
                "PLAN", "MONITOR", "DIAGNOSE", "FIX",
                "QUESTION", "EXPLORE", "CONNECT", "INSIGHT"
            ),
            listOf(
                ConnectionCategory(
                    "Alerting System",
                    setOf("SIGNAL", "METRIC", "THRESHOLD", "ALERT"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Statistical Pitfalls",
                    setOf("CAUSE", "CONFOUND", "CORRELATION", "ERROR"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Issue Resolution",
                    setOf("PLAN", "MONITOR", "DIAGNOSE", "FIX"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Insight Path",
                    setOf("QUESTION", "EXPLORE", "CONNECT", "INSIGHT"),
                    CategoryColor.PURPLE
                )
            ),
            "Hard+"
        ),

        ConnectionPuzzle(
            244,
            listOf(
                "MODEL", "ASSUMPTION", "LIMIT", "BREAKDOWN",
                "GOAL", "PLAN", "EXECUTE", "MEASURE",
                "INPUT", "TRANSFORM", "AGGREGATE", "OUTPUT",
                "STIMULUS", "REACTION", "ADJUST", "STABILIZE"
            ),
            listOf(
                ConnectionCategory(
                    "Model Failure",
                    setOf("MODEL", "ASSUMPTION", "LIMIT", "BREAKDOWN"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Performance Cycle",
                    setOf("GOAL", "PLAN", "EXECUTE", "MEASURE"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Data Processing",
                    setOf("INPUT", "TRANSFORM", "AGGREGATE", "OUTPUT"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Stabilization Loop",
                    setOf("STIMULUS", "REACTION", "ADJUST", "STABILIZE"),
                    CategoryColor.PURPLE
                )
            ),
            "Hard+"
        ),

        ConnectionPuzzle(
            245,
            listOf(
                "FRAME", "BIAS", "FILTER", "DISTORT",
                "VALUE", "INCENTIVE", "BEHAVIOR", "OUTCOME",
                "PLAN", "TEST", "FAIL", "IMPROVE",
                "QUESTION", "ANALYZE", "REFINE", "DECIDE"
            ),
            listOf(
                ConnectionCategory(
                    "Cognitive Filtering",
                    setOf("FRAME", "BIAS", "FILTER", "DISTORT"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Behavior Economics",
                    setOf("VALUE", "INCENTIVE", "BEHAVIOR", "OUTCOME"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Iteration Loop",
                    setOf("PLAN", "TEST", "FAIL", "IMPROVE"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Decision Refinement",
                    setOf("QUESTION", "ANALYZE", "REFINE", "DECIDE"),
                    CategoryColor.PURPLE
                )
            ),
            "Hard+"
        ),

        ConnectionPuzzle(
            246,
            listOf(
                "SIGNAL", "ANOMALY", "INVESTIGATE", "RESOLVE",
                "ASSUMPTION", "TEST", "INVALIDATE", "UPDATE",
                "GOAL", "FOCUS", "EXECUTE", "DELIVER",
                "STIMULUS", "FEEDBACK", "LEARN", "CHANGE"
            ),
            listOf(
                ConnectionCategory(
                    "Incident Response",
                    setOf("SIGNAL", "ANOMALY", "INVESTIGATE", "RESOLVE"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Belief Updating",
                    setOf("ASSUMPTION", "TEST", "INVALIDATE", "UPDATE"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Execution Discipline",
                    setOf("GOAL", "FOCUS", "EXECUTE", "DELIVER"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Learning Loop",
                    setOf("STIMULUS", "FEEDBACK", "LEARN", "CHANGE"),
                    CategoryColor.PURPLE
                )
            ),
            "Hard+"
        ),

        ConnectionPuzzle(
            247,
            listOf(
                "INPUT", "CONSTRAINT", "TRADEOFF", "BALANCE",
                "PLAN", "COORDINATE", "ALIGN", "ACT",
                "SIGNAL", "SHIFT", "RESPOND", "ADAPT",
                "QUESTION", "SEARCH", "EVALUATE", "CHOOSE"
            ),
            listOf(
                ConnectionCategory(
                    "Constraint Balancing",
                    setOf("INPUT", "CONSTRAINT", "TRADEOFF", "BALANCE"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Collective Action",
                    setOf("PLAN", "COORDINATE", "ALIGN", "ACT"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Adaptive Response",
                    setOf("SIGNAL", "SHIFT", "RESPOND", "ADAPT"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Decision Search",
                    setOf("QUESTION", "SEARCH", "EVALUATE", "CHOOSE"),
                    CategoryColor.PURPLE
                )
            ),
            "Hard+"
        ),

        ConnectionPuzzle(
            248,
            listOf(
                "MODEL", "SCENARIO", "STRESS", "FAILURE",
                "VALUE", "COST", "BENEFIT", "TRADEOFF",
                "PLAN", "BUFFER", "RECOVER", "STABILIZE",
                "STIMULUS", "REACTION", "ESCALATE", "RESOLVE"
            ),
            listOf(
                ConnectionCategory(
                    "Stress Testing",
                    setOf("MODEL", "SCENARIO", "STRESS", "FAILURE"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Economic Tradeoffs",
                    setOf("VALUE", "COST", "BENEFIT", "TRADEOFF"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "System Recovery",
                    setOf("PLAN", "BUFFER", "RECOVER", "STABILIZE"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Crisis Resolution",
                    setOf("STIMULUS", "REACTION", "ESCALATE", "RESOLVE"),
                    CategoryColor.PURPLE
                )
            ),
            "Hard+"
        ),

        ConnectionPuzzle(
            249,
            listOf(
                "FRAME", "ASSUMPTION", "CHALLENGE", "REFRAME",
                "GOAL", "METRIC", "TRACK", "ADJUST",
                "SIGNAL", "NOISE", "FILTER", "CLARIFY",
                "QUESTION", "EXPLORE", "CONNECT", "CONCLUDE"
            ),
            listOf(
                ConnectionCategory(
                    "Reframing Thinking",
                    setOf("FRAME", "ASSUMPTION", "CHALLENGE", "REFRAME"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Performance Tracking",
                    setOf("GOAL", "METRIC", "TRACK", "ADJUST"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Signal Clarification",
                    setOf("SIGNAL", "NOISE", "FILTER", "CLARIFY"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Reasoned Conclusion",
                    setOf("QUESTION", "EXPLORE", "CONNECT", "CONCLUDE"),
                    CategoryColor.PURPLE
                )
            ),
            "Hard+"
        ),

        ConnectionPuzzle(
            250,
            listOf(
                "ASSUMPTION", "UNCERTAINTY", "RISK", "EXPOSURE",
                "PLAN", "HEDGE", "MITIGATE", "ADAPT",
                "SIGNAL", "SHIFT", "RESPONSE", "STABILIZE",
                "QUESTION", "ANALYZE", "DECIDE", "ACT"
            ),
            listOf(
                ConnectionCategory(
                    "Risk Landscape",
                    setOf("ASSUMPTION", "UNCERTAINTY", "RISK", "EXPOSURE"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Risk Response",
                    setOf("PLAN", "HEDGE", "MITIGATE", "ADAPT"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "System Stabilization",
                    setOf("SIGNAL", "SHIFT", "RESPONSE", "STABILIZE"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Decision to Action",
                    setOf("QUESTION", "ANALYZE", "DECIDE", "ACT"),
                    CategoryColor.PURPLE
                )
            ),
            "Hard+"
        ),

        ConnectionPuzzle(
            251,
            listOf(
                "OBSERVABLE", "LATENT", "HIDDEN", "EMERGENT",
                "PLAN", "SIMULATE", "ANTICIPATE", "PREPARE",
                "SIGNAL", "SHIFT", "THRESHOLD", "TRANSITION",
                "QUESTION", "DECOMPOSE", "ABSTRACT", "MODEL"
            ),
            listOf(
                ConnectionCategory(
                    "System Properties",
                    setOf("OBSERVABLE", "LATENT", "HIDDEN", "EMERGENT"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Strategic Foresight",
                    setOf("PLAN", "SIMULATE", "ANTICIPATE", "PREPARE"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Phase Change",
                    setOf("SIGNAL", "SHIFT", "THRESHOLD", "TRANSITION"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Problem Abstraction",
                    setOf("QUESTION", "DECOMPOSE", "ABSTRACT", "MODEL"),
                    CategoryColor.PURPLE
                )
            ),
            "Expert"
        ),

        ConnectionPuzzle(
            252,
            listOf(
                "FRAME", "ASSUMPTION", "CONTEXT", "BOUNDARY",
                "INPUT", "PRIORITIZE", "SCHEDULE", "SEQUENCE",
                "VARIANCE", "VOLATILITY", "UNCERTAINTY", "RISK",
                "DATA", "PATTERN", "HYPOTHESIS", "INSIGHT"
            ),
            listOf(
                ConnectionCategory(
                    "Problem Framing",
                    setOf("FRAME", "ASSUMPTION", "CONTEXT", "BOUNDARY"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Execution Ordering",
                    setOf("INPUT", "PRIORITIZE", "SCHEDULE", "SEQUENCE"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Uncertainty Spectrum",
                    setOf("VARIANCE", "VOLATILITY", "UNCERTAINTY", "RISK"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Sensemaking",
                    setOf("DATA", "PATTERN", "HYPOTHESIS", "INSIGHT"),
                    CategoryColor.PURPLE
                )
            ),
            "Expert"
        ),

        ConnectionPuzzle(
            253,
            listOf(
                "MODEL", "SIMPLIFY", "GENERALIZE", "TRANSFER",
                "INCENTIVE", "FEEDBACK", "BEHAVIOR", "DYNAMICS",
                "CAUSE", "INTERACTION", "NONLINEARITY", "OUTCOME",
                "OBSERVE", "MEASURE", "INFER", "ESTIMATE"
            ),
            listOf(
                ConnectionCategory(
                    "Abstraction Power",
                    setOf("MODEL", "SIMPLIFY", "GENERALIZE", "TRANSFER"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Behavioral Systems",
                    setOf("INCENTIVE", "FEEDBACK", "BEHAVIOR", "DYNAMICS"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Complex Causality",
                    setOf("CAUSE", "INTERACTION", "NONLINEARITY", "OUTCOME"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Statistical Inference",
                    setOf("OBSERVE", "MEASURE", "INFER", "ESTIMATE"),
                    CategoryColor.PURPLE
                )
            ),
            "Expert"
        ),

        ConnectionPuzzle(
            254,
            listOf(
                "CONSTRAINT", "BOTTLENECK", "SATURATION", "COLLAPSE",
                "PLAN", "BUFFER", "REDUNDANCY", "RESILIENCE",
                "SIGNAL", "DETECT", "ESCALATE", "CONTAIN",
                "QUESTION", "EXPLORE", "SCOPE", "FOCUS"
            ),
            listOf(
                ConnectionCategory(
                    "System Failure Modes",
                    setOf("CONSTRAINT", "BOTTLENECK", "SATURATION", "COLLAPSE"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Resilient Design",
                    setOf("PLAN", "BUFFER", "REDUNDANCY", "RESILIENCE"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Incident Handling",
                    setOf("SIGNAL", "DETECT", "ESCALATE", "CONTAIN"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Problem Scoping",
                    setOf("QUESTION", "EXPLORE", "SCOPE", "FOCUS"),
                    CategoryColor.PURPLE
                )
            ),
            "Expert"
        ),

        ConnectionPuzzle(
            255,
            listOf(
                "ASSUMPTION", "MODEL", "REALITY", "DIVERGENCE",
                "INPUT", "WEIGHT", "AGGREGATE", "OPTIMIZE",
                "EXPECTATION", "SURPRISE", "UPDATE", "BELIEF",
                "OBSERVE", "REFLECT", "LEARN", "ADAPT"
            ),
            listOf(
                ConnectionCategory(
                    "Model Drift",
                    setOf("ASSUMPTION", "MODEL", "REALITY", "DIVERGENCE"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Optimization Pipeline",
                    setOf("INPUT", "WEIGHT", "AGGREGATE", "OPTIMIZE"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Bayesian Update",
                    setOf("EXPECTATION", "SURPRISE", "UPDATE", "BELIEF"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Reflective Learning",
                    setOf("OBSERVE", "REFLECT", "LEARN", "ADAPT"),
                    CategoryColor.PURPLE
                )
            ),
            "Expert"
        ),

        ConnectionPuzzle(
            256,
            listOf(
                "SIGNAL", "NOISE", "BIAS", "DISTORTION",
                "PLAN", "ALLOCATE", "TRADE", "REBALANCE",
                "CAUSE", "FEEDBACK", "AMPLIFICATION", "INSTABILITY",
                "QUESTION", "CHALLENGE", "REFRAME", "CLARIFY"
            ),
            listOf(
                ConnectionCategory(
                    "Information Degradation",
                    setOf("SIGNAL", "NOISE", "BIAS", "DISTORTION"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Resource Reallocation",
                    setOf("PLAN", "ALLOCATE", "TRADE", "REBALANCE"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Positive Feedback",
                    setOf("CAUSE", "FEEDBACK", "AMPLIFICATION", "INSTABILITY"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Cognitive Reframing",
                    setOf("QUESTION", "CHALLENGE", "REFRAME", "CLARIFY"),
                    CategoryColor.PURPLE
                )
            ),
            "Expert"
        ),

        ConnectionPuzzle(
            257,
            listOf(
                "STATE", "TRANSITION", "EQUILIBRIUM", "DYNAMICS",
                "GOAL", "METRIC", "PROXY", "TARGET",
                "SIGNAL", "LAG", "OVERSHOOT", "CORRECTION",
                "INPUT", "CONSTRAINT", "TRADEOFF", "BALANCE"
            ),
            listOf(
                ConnectionCategory(
                    "Dynamic Systems",
                    setOf("STATE", "TRANSITION", "EQUILIBRIUM", "DYNAMICS"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Measurement Pitfalls",
                    setOf("GOAL", "METRIC", "PROXY", "TARGET"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Control Oscillation",
                    setOf("SIGNAL", "LAG", "OVERSHOOT", "CORRECTION"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Constraint Reasoning",
                    setOf("INPUT", "CONSTRAINT", "TRADEOFF", "BALANCE"),
                    CategoryColor.PURPLE
                )
            ),
            "Expert"
        ),

        ConnectionPuzzle(
            258,
            listOf(
                "MODEL", "SCENARIO", "EDGECASE", "FAILURE",
                "PLAN", "TEST", "STRESS", "BREAK",
                "EXPECTATION", "REALITY", "ERROR", "REVISION",
                "OBSERVE", "DIAGNOSE", "INTERVENE", "RECOVER"
            ),
            listOf(
                ConnectionCategory(
                    "Model Robustness",
                    setOf("MODEL", "SCENARIO", "EDGECASE", "FAILURE"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Destructive Testing",
                    setOf("PLAN", "TEST", "STRESS", "BREAK"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Error Correction",
                    setOf("EXPECTATION", "REALITY", "ERROR", "REVISION"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "System Recovery",
                    setOf("OBSERVE", "DIAGNOSE", "INTERVENE", "RECOVER"),
                    CategoryColor.PURPLE
                )
            ),
            "Expert"
        ),

        ConnectionPuzzle(
            259,
            listOf(
                "FRAME", "NARRATIVE", "INTERPRETATION", "MEANING",
                "INCENTIVE", "GAMING", "DISTORTION", "MISALIGNMENT",
                "SIGNAL", "METRIC", "TARGET", "MANIPULATION",
                "QUESTION", "ABSTRACT", "GENERALIZE", "TRANSFER"
            ),
            listOf(
                ConnectionCategory(
                    "Sense Construction",
                    setOf("FRAME", "NARRATIVE", "INTERPRETATION", "MEANING"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Perverse Incentives",
                    setOf("INCENTIVE", "GAMING", "DISTORTION", "MISALIGNMENT"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Metric Exploitation",
                    setOf("SIGNAL", "METRIC", "TARGET", "MANIPULATION"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Concept Transfer",
                    setOf("QUESTION", "ABSTRACT", "GENERALIZE", "TRANSFER"),
                    CategoryColor.PURPLE
                )
            ),
            "Expert"
        ),

        ConnectionPuzzle(
            260,
            listOf(
                "UNCERTAINTY", "AMBIGUITY", "COMPLEXITY", "CHAOS",
                "PLAN", "OPTION", "FLEX", "PIVOT",
                "SIGNAL", "SENSE", "DECIDE", "ACT",
                "OBSERVE", "ORIENT", "DECIDE", "ACT"
            ),
            listOf(
                ConnectionCategory(
                    "Decision Environments",
                    setOf("UNCERTAINTY", "AMBIGUITY", "COMPLEXITY", "CHAOS"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Strategic Optionality",
                    setOf("PLAN", "OPTION", "FLEX", "PIVOT"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Sensemaking Loop",
                    setOf("SIGNAL", "SENSE", "DECIDE", "ACT"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "OODA Loop",
                    setOf("OBSERVE", "ORIENT", "DECIDE", "ACT"),
                    CategoryColor.PURPLE
                )
            ),
            "Expert"
        ),

        ConnectionPuzzle(
            261,
            listOf(
                "ASSUMPTION", "MODEL", "SIMULATION", "PROJECTION",
                "SIGNAL", "EARLY", "LATE", "MISSED",
                "PLAN", "DELEGATE", "COORDINATE", "ALIGN",
                "QUESTION", "ISOLATE", "REDUCE", "SOLVE"
            ),
            listOf(
                ConnectionCategory(
                    "Forecast Construction",
                    setOf("ASSUMPTION", "MODEL", "SIMULATION", "PROJECTION"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Timing Errors",
                    setOf("SIGNAL", "EARLY", "LATE", "MISSED"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Organizational Alignment",
                    setOf("PLAN", "DELEGATE", "COORDINATE", "ALIGN"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Problem Reduction",
                    setOf("QUESTION", "ISOLATE", "REDUCE", "SOLVE"),
                    CategoryColor.PURPLE
                )
            ),
            "Expert"
        ),

        ConnectionPuzzle(
            262,
            listOf(
                "VALUE", "UTILITY", "PREFERENCE", "CHOICE",
                "INPUT", "WEIGHT", "NORMALIZE", "SCORE",
                "SIGNAL", "TREND", "INFLECTION", "REVERSAL",
                "OBSERVE", "COMPARE", "RANK", "SELECT"
            ),
            listOf(
                ConnectionCategory(
                    "Decision Theory",
                    setOf("VALUE", "UTILITY", "PREFERENCE", "CHOICE"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Scoring Models",
                    setOf("INPUT", "WEIGHT", "NORMALIZE", "SCORE"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Trend Dynamics",
                    setOf("SIGNAL", "TREND", "INFLECTION", "REVERSAL"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Selection Logic",
                    setOf("OBSERVE", "COMPARE", "RANK", "SELECT"),
                    CategoryColor.PURPLE
                )
            ),
            "Expert"
        ),

        ConnectionPuzzle(
            263,
            listOf(
                "FRAME", "CONTEXT", "ASSUMPTION", "SCOPE",
                "PLAN", "OPTION", "OPTIONALITY", "FLEXIBILITY",
                "SIGNAL", "DELAY", "OVERSHOOT", "CORRECT",
                "QUESTION", "REPHRASE", "SIMPLIFY", "CLARIFY"
            ),
            listOf(
                ConnectionCategory(
                    "Problem Framing",
                    setOf("FRAME", "CONTEXT", "ASSUMPTION", "SCOPE"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Strategic Optionality",
                    setOf("PLAN", "OPTION", "OPTIONALITY", "FLEXIBILITY"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Control Instability",
                    setOf("SIGNAL", "DELAY", "OVERSHOOT", "CORRECT"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Cognitive Simplification",
                    setOf("QUESTION", "REPHRASE", "SIMPLIFY", "CLARIFY"),
                    CategoryColor.PURPLE
                )
            ),
            "Expert"
        ),

        ConnectionPuzzle(
            264,
            listOf(
                "MODEL", "EDGECASE", "BREAKPOINT", "FAILURE",
                "PLAN", "BUFFER", "REDUNDANCY", "ROBUSTNESS",
                "SIGNAL", "ANOMALY", "INVESTIGATE", "RESOLVE",
                "OBSERVE", "INTERPRET", "DECIDE", "ACT"
            ),
            listOf(
                ConnectionCategory(
                    "System Fragility",
                    setOf("MODEL", "EDGECASE", "BREAKPOINT", "FAILURE"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Robust Design",
                    setOf("PLAN", "BUFFER", "REDUNDANCY", "ROBUSTNESS"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Incident Resolution",
                    setOf("SIGNAL", "ANOMALY", "INVESTIGATE", "RESOLVE"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Decision Loop",
                    setOf("OBSERVE", "INTERPRET", "DECIDE", "ACT"),
                    CategoryColor.PURPLE
                )
            ),
            "Expert"
        ),

        ConnectionPuzzle(
            265,
            listOf(
                "ASSUMPTION", "BIAS", "DISTORTION", "MISJUDGMENT",
                "INPUT", "FILTER", "AGGREGATE", "MODEL",
                "SIGNAL", "METRIC", "TARGET", "GAMING",
                "QUESTION", "ABSTRACT", "TRANSFER", "APPLY"
            ),
            listOf(
                ConnectionCategory(
                    "Cognitive Failure",
                    setOf("ASSUMPTION", "BIAS", "DISTORTION", "MISJUDGMENT"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Data Pipeline",
                    setOf("INPUT", "FILTER", "AGGREGATE", "MODEL"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Metric Exploitation",
                    setOf("SIGNAL", "METRIC", "TARGET", "GAMING"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Concept Application",
                    setOf("QUESTION", "ABSTRACT", "TRANSFER", "APPLY"),
                    CategoryColor.PURPLE
                )
            ),
            "Expert"
        ),

        ConnectionPuzzle(
            266,
            listOf(
                "UNCERTAINTY", "VARIANCE", "VOLATILITY", "RISK",
                "PLAN", "HEDGE", "DIVERSIFY", "BALANCE",
                "SIGNAL", "SHIFT", "RESPONSE", "ADAPT",
                "OBSERVE", "LEARN", "UPDATE", "REPEAT"
            ),
            listOf(
                ConnectionCategory(
                    "Uncertainty Spectrum",
                    setOf("UNCERTAINTY", "VARIANCE", "VOLATILITY", "RISK"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Risk Strategy",
                    setOf("PLAN", "HEDGE", "DIVERSIFY", "BALANCE"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Adaptive Control",
                    setOf("SIGNAL", "SHIFT", "RESPONSE", "ADAPT"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Learning Loop",
                    setOf("OBSERVE", "LEARN", "UPDATE", "REPEAT"),
                    CategoryColor.PURPLE
                )
            ),
            "Expert"
        ),

        ConnectionPuzzle(
            267,
            listOf(
                "STATE", "TRANSITION", "THRESHOLD", "REGIME",
                "GOAL", "PROXY", "METRIC", "MISALIGNMENT",
                "PLAN", "COORDINATE", "EXECUTE", "SYNCHRONIZE",
                "QUESTION", "SCOPE", "DECOMPOSE", "SOLVE"
            ),
            listOf(
                ConnectionCategory(
                    "Phase Transition",
                    setOf("STATE", "TRANSITION", "THRESHOLD", "REGIME"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Measurement Failure",
                    setOf("GOAL", "PROXY", "METRIC", "MISALIGNMENT"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Coordinated Action",
                    setOf("PLAN", "COORDINATE", "EXECUTE", "SYNCHRONIZE"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Problem Decomposition",
                    setOf("QUESTION", "SCOPE", "DECOMPOSE", "SOLVE"),
                    CategoryColor.PURPLE
                )
            ),
            "Expert"
        ),

        ConnectionPuzzle(
            268,
            listOf(
                "MODEL", "SIMULATION", "SCENARIO", "SENSITIVITY",
                "SIGNAL", "NOISE", "FILTER", "CLARITY",
                "INPUT", "CONSTRAINT", "TRADEOFF", "OPTIMUM",
                "OBSERVE", "REFLECT", "LEARN", "IMPROVE"
            ),
            listOf(
                ConnectionCategory(
                    "Sensitivity Analysis",
                    setOf("MODEL", "SIMULATION", "SCENARIO", "SENSITIVITY"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Signal Processing",
                    setOf("SIGNAL", "NOISE", "FILTER", "CLARITY"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Optimization Logic",
                    setOf("INPUT", "CONSTRAINT", "TRADEOFF", "OPTIMUM"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Reflective Practice",
                    setOf("OBSERVE", "REFLECT", "LEARN", "IMPROVE"),
                    CategoryColor.PURPLE
                )
            ),
            "Expert"
        ),

        ConnectionPuzzle(
            269,
            listOf(
                "FRAME", "NARRATIVE", "INTERPRETATION", "MEANING",
                "INCENTIVE", "FEEDBACK", "ADAPTATION", "EVOLUTION",
                "SIGNAL", "SHIFT", "CASCADE", "SYSTEM",
                "QUESTION", "EXPLORE", "SYNTHESIZE", "INSIGHT"
            ),
            listOf(
                ConnectionCategory(
                    "Meaning Construction",
                    setOf("FRAME", "NARRATIVE", "INTERPRETATION", "MEANING"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Adaptive Systems",
                    setOf("INCENTIVE", "FEEDBACK", "ADAPTATION", "EVOLUTION"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Systemic Change",
                    setOf("SIGNAL", "SHIFT", "CASCADE", "SYSTEM"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Insight Formation",
                    setOf("QUESTION", "EXPLORE", "SYNTHESIZE", "INSIGHT"),
                    CategoryColor.PURPLE
                )
            ),
            "Expert"
        ),

        ConnectionPuzzle(
            270,
            listOf(
                "ASSUMPTION", "UNCERTAINTY", "AMBIGUITY", "CHAOS",
                "PLAN", "OPTION", "PIVOT", "RESPOND",
                "SIGNAL", "SENSE", "DECIDE", "ACT",
                "OBSERVE", "ORIENT", "DECIDE", "ACT"
            ),
            listOf(
                ConnectionCategory(
                    "Decision Environments",
                    setOf("ASSUMPTION", "UNCERTAINTY", "AMBIGUITY", "CHAOS"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Strategic Flexibility",
                    setOf("PLAN", "OPTION", "PIVOT", "RESPOND"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Sense-Respond Loop",
                    setOf("SIGNAL", "SENSE", "DECIDE", "ACT"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "OODA Loop",
                    setOf("OBSERVE", "ORIENT", "DECIDE", "ACT"),
                    CategoryColor.PURPLE
                )
            ),
            "Expert"
        ),

        ConnectionPuzzle(
            271,
            listOf(
                "ASSUMPTION", "CONSTRAINT", "BOUNDARY", "SCOPE",
                "PLAN", "DELEGATE", "COORDINATE", "EXECUTE",
                "SIGNAL", "LAG", "OVERSHOOT", "CORRECT",
                "QUESTION", "ANALYZE", "DECOMPOSE", "SOLVE"
            ),
            listOf(
                ConnectionCategory(
                    "Problem Definition",
                    setOf("ASSUMPTION", "CONSTRAINT", "BOUNDARY", "SCOPE"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Organized Execution",
                    setOf("PLAN", "DELEGATE", "COORDINATE", "EXECUTE"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Control Instability",
                    setOf("SIGNAL", "LAG", "OVERSHOOT", "CORRECT"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Analytical Reasoning",
                    setOf("QUESTION", "ANALYZE", "DECOMPOSE", "SOLVE"),
                    CategoryColor.PURPLE
                )
            ),
            "Expert"
        ),

        ConnectionPuzzle(
            272,
            listOf(
                "MODEL", "SIMULATION", "SENSITIVITY", "ROBUSTNESS",
                "VALUE", "UTILITY", "PREFERENCE", "CHOICE",
                "SIGNAL", "NOISE", "FILTER", "EXTRACT",
                "OBSERVE", "COMPARE", "RANK", "SELECT"
            ),
            listOf(
                ConnectionCategory(
                    "Model Evaluation",
                    setOf("MODEL", "SIMULATION", "SENSITIVITY", "ROBUSTNESS"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Decision Theory",
                    setOf("VALUE", "UTILITY", "PREFERENCE", "CHOICE"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Signal Extraction",
                    setOf("SIGNAL", "NOISE", "FILTER", "EXTRACT"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Selection Logic",
                    setOf("OBSERVE", "COMPARE", "RANK", "SELECT"),
                    CategoryColor.PURPLE
                )
            ),
            "Expert"
        ),

        ConnectionPuzzle(
            273,
            listOf(
                "FRAME", "PERSPECTIVE", "ASSUMPTION", "BIAS",
                "PLAN", "OPTION", "HEDGE", "PIVOT",
                "SIGNAL", "THRESHOLD", "SHIFT", "REGIME",
                "QUESTION", "REFRAME", "SIMPLIFY", "CLARIFY"
            ),
            listOf(
                ConnectionCategory(
                    "Cognitive Framing",
                    setOf("FRAME", "PERSPECTIVE", "ASSUMPTION", "BIAS"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Strategic Flexibility",
                    setOf("PLAN", "OPTION", "HEDGE", "PIVOT"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Phase Transition",
                    setOf("SIGNAL", "THRESHOLD", "SHIFT", "REGIME"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Problem Simplification",
                    setOf("QUESTION", "REFRAME", "SIMPLIFY", "CLARIFY"),
                    CategoryColor.PURPLE
                )
            ),
            "Expert"
        ),

        ConnectionPuzzle(
            274,
            listOf(
                "MODEL", "EDGECASE", "BREAKPOINT", "COLLAPSE",
                "PLAN", "BUFFER", "REDUNDANCY", "RECOVER",
                "SIGNAL", "ANOMALY", "ESCALATE", "CONTAIN",
                "OBSERVE", "DIAGNOSE", "INTERVENE", "RESTORE"
            ),
            listOf(
                ConnectionCategory(
                    "System Failure",
                    setOf("MODEL", "EDGECASE", "BREAKPOINT", "COLLAPSE"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Resilience Design",
                    setOf("PLAN", "BUFFER", "REDUNDANCY", "RECOVER"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Incident Response",
                    setOf("SIGNAL", "ANOMALY", "ESCALATE", "CONTAIN"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "System Recovery",
                    setOf("OBSERVE", "DIAGNOSE", "INTERVENE", "RESTORE"),
                    CategoryColor.PURPLE
                )
            ),
            "Expert"
        ),

        ConnectionPuzzle(
            275,
            listOf(
                "ASSUMPTION", "BIAS", "DISTORTION", "MISREAD",
                "INPUT", "WEIGHT", "AGGREGATE", "MODEL",
                "SIGNAL", "METRIC", "TARGET", "GAMING",
                "QUESTION", "ABSTRACT", "TRANSFER", "APPLY"
            ),
            listOf(
                ConnectionCategory(
                    "Cognitive Errors",
                    setOf("ASSUMPTION", "BIAS", "DISTORTION", "MISREAD"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Data Modeling",
                    setOf("INPUT", "WEIGHT", "AGGREGATE", "MODEL"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Metric Exploitation",
                    setOf("SIGNAL", "METRIC", "TARGET", "GAMING"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Knowledge Transfer",
                    setOf("QUESTION", "ABSTRACT", "TRANSFER", "APPLY"),
                    CategoryColor.PURPLE
                )
            ),
            "Expert"
        ),

        ConnectionPuzzle(
            276,
            listOf(
                "UNCERTAINTY", "VARIANCE", "VOLATILITY", "RISK",
                "PLAN", "HEDGE", "DIVERSIFY", "BALANCE",
                "SIGNAL", "SHIFT", "RESPOND", "ADAPT",
                "OBSERVE", "LEARN", "UPDATE", "REPEAT"
            ),
            listOf(
                ConnectionCategory(
                    "Uncertainty Spectrum",
                    setOf("UNCERTAINTY", "VARIANCE", "VOLATILITY", "RISK"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Risk Strategy",
                    setOf("PLAN", "HEDGE", "DIVERSIFY", "BALANCE"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Adaptive Control",
                    setOf("SIGNAL", "SHIFT", "RESPOND", "ADAPT"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Learning Cycle",
                    setOf("OBSERVE", "LEARN", "UPDATE", "REPEAT"),
                    CategoryColor.PURPLE
                )
            ),
            "Expert"
        ),

        ConnectionPuzzle(
            277,
            listOf(
                "STATE", "TRANSITION", "EQUILIBRIUM", "DYNAMICS",
                "GOAL", "PROXY", "METRIC", "MISALIGNMENT",
                "PLAN", "COORDINATE", "EXECUTE", "SYNCHRONIZE",
                "QUESTION", "SCOPE", "DECOMPOSE", "SOLVE"
            ),
            listOf(
                ConnectionCategory(
                    "Dynamic Systems",
                    setOf("STATE", "TRANSITION", "EQUILIBRIUM", "DYNAMICS"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Measurement Failure",
                    setOf("GOAL", "PROXY", "METRIC", "MISALIGNMENT"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Coordinated Action",
                    setOf("PLAN", "COORDINATE", "EXECUTE", "SYNCHRONIZE"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Problem Decomposition",
                    setOf("QUESTION", "SCOPE", "DECOMPOSE", "SOLVE"),
                    CategoryColor.PURPLE
                )
            ),
            "Expert"
        ),

        ConnectionPuzzle(
            278,
            listOf(
                "MODEL", "SCENARIO", "SENSITIVITY", "STRESS",
                "SIGNAL", "NOISE", "FILTER", "CLARITY",
                "INPUT", "CONSTRAINT", "TRADEOFF", "OPTIMUM",
                "OBSERVE", "REFLECT", "LEARN", "IMPROVE"
            ),
            listOf(
                ConnectionCategory(
                    "Stress Analysis",
                    setOf("MODEL", "SCENARIO", "SENSITIVITY", "STRESS"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Signal Processing",
                    setOf("SIGNAL", "NOISE", "FILTER", "CLARITY"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Optimization Logic",
                    setOf("INPUT", "CONSTRAINT", "TRADEOFF", "OPTIMUM"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Reflective Practice",
                    setOf("OBSERVE", "REFLECT", "LEARN", "IMPROVE"),
                    CategoryColor.PURPLE
                )
            ),
            "Expert"
        ),

        ConnectionPuzzle(
            279,
            listOf(
                "FRAME", "NARRATIVE", "INTERPRETATION", "MEANING",
                "INCENTIVE", "FEEDBACK", "ADAPTATION", "EVOLUTION",
                "SIGNAL", "SHIFT", "CASCADE", "SYSTEM",
                "QUESTION", "EXPLORE", "SYNTHESIZE", "INSIGHT"
            ),
            listOf(
                ConnectionCategory(
                    "Meaning Construction",
                    setOf("FRAME", "NARRATIVE", "INTERPRETATION", "MEANING"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Adaptive Systems",
                    setOf("INCENTIVE", "FEEDBACK", "ADAPTATION", "EVOLUTION"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Systemic Change",
                    setOf("SIGNAL", "SHIFT", "CASCADE", "SYSTEM"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Insight Formation",
                    setOf("QUESTION", "EXPLORE", "SYNTHESIZE", "INSIGHT"),
                    CategoryColor.PURPLE
                )
            ),
            "Expert"
        ),

        ConnectionPuzzle(
            280,
            listOf(
                "ASSUMPTION", "UNCERTAINTY", "AMBIGUITY", "CHAOS",
                "PLAN", "OPTION", "PIVOT", "RESPOND",
                "SIGNAL", "SENSE", "DECIDE", "ACT",
                "OBSERVE", "ORIENT", "DECIDE", "ACT"
            ),
            listOf(
                ConnectionCategory(
                    "Decision Environments",
                    setOf("ASSUMPTION", "UNCERTAINTY", "AMBIGUITY", "CHAOS"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Strategic Flexibility",
                    setOf("PLAN", "OPTION", "PIVOT", "RESPOND"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Sense-Respond Loop",
                    setOf("SIGNAL", "SENSE", "DECIDE", "ACT"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "OODA Loop",
                    setOf("OBSERVE", "ORIENT", "DECIDE", "ACT"),
                    CategoryColor.PURPLE
                )
            ),
            "Expert"
        ),

        ConnectionPuzzle(
            281,
            listOf(
                "MODEL", "ASSUMPTION", "LIMITATION", "FAILURE",
                "PLAN", "TEST", "BREAK", "LEARN",
                "SIGNAL", "ANOMALY", "INVESTIGATE", "RESOLVE",
                "QUESTION", "RETHINK", "ADAPT", "IMPROVE"
            ),
            listOf(
                ConnectionCategory(
                    "Model Weakness",
                    setOf("MODEL", "ASSUMPTION", "LIMITATION", "FAILURE"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Destructive Testing",
                    setOf("PLAN", "TEST", "BREAK", "LEARN"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Anomaly Handling",
                    setOf("SIGNAL", "ANOMALY", "INVESTIGATE", "RESOLVE"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Iterative Improvement",
                    setOf("QUESTION", "RETHINK", "ADAPT", "IMPROVE"),
                    CategoryColor.PURPLE
                )
            ),
            "Expert"
        ),

        ConnectionPuzzle(
            282,
            listOf(
                "VALUE", "COST", "BENEFIT", "TRADEOFF",
                "INPUT", "NORMALIZE", "WEIGHT", "SCORE",
                "SIGNAL", "METRIC", "THRESHOLD", "ALERT",
                "OBSERVE", "DECIDE", "ACT", "REVIEW"
            ),
            listOf(
                ConnectionCategory(
                    "Economic Evaluation",
                    setOf("VALUE", "COST", "BENEFIT", "TRADEOFF"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Scoring Pipeline",
                    setOf("INPUT", "NORMALIZE", "WEIGHT", "SCORE"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Alerting System",
                    setOf("SIGNAL", "METRIC", "THRESHOLD", "ALERT"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Action Loop",
                    setOf("OBSERVE", "DECIDE", "ACT", "REVIEW"),
                    CategoryColor.PURPLE
                )
            ),
            "Expert"
        ),

        ConnectionPuzzle(
            283,
            listOf(
                "FRAME", "ASSUMPTION", "CHALLENGE", "REFRAME",
                "GOAL", "METRIC", "TRACK", "ADJUST",
                "SIGNAL", "NOISE", "FILTER", "CLARIFY",
                "QUESTION", "ANALYZE", "REFINE", "DECIDE"
            ),
            listOf(
                ConnectionCategory(
                    "Reframing Logic",
                    setOf("FRAME", "ASSUMPTION", "CHALLENGE", "REFRAME"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Performance Tracking",
                    setOf("GOAL", "METRIC", "TRACK", "ADJUST"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Signal Clarification",
                    setOf("SIGNAL", "NOISE", "FILTER", "CLARIFY"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Decision Refinement",
                    setOf("QUESTION", "ANALYZE", "REFINE", "DECIDE"),
                    CategoryColor.PURPLE
                )
            ),
            "Expert"
        ),

        ConnectionPuzzle(
            284,
            listOf(
                "STATE", "CHANGE", "FEEDBACK", "STABILITY",
                "PLAN", "BUFFER", "RECOVER", "STABILIZE",
                "SIGNAL", "SHIFT", "RESPOND", "ADAPT",
                "QUESTION", "EXPLORE", "EVALUATE", "CHOOSE"
            ),
            listOf(
                ConnectionCategory(
                    "System Stability",
                    setOf("STATE", "CHANGE", "FEEDBACK", "STABILITY"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Recovery Strategy",
                    setOf("PLAN", "BUFFER", "RECOVER", "STABILIZE"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Adaptive Response",
                    setOf("SIGNAL", "SHIFT", "RESPOND", "ADAPT"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Strategic Choice",
                    setOf("QUESTION", "EXPLORE", "EVALUATE", "CHOOSE"),
                    CategoryColor.PURPLE
                )
            ),
            "Expert"
        ),

        ConnectionPuzzle(
            285,
            listOf(
                "MODEL", "SCENARIO", "OUTCOME", "IMPACT",
                "VALUE", "PRIORITY", "CHOICE", "COMMITMENT",
                "INPUT", "CONSTRAINT", "TRADEOFF", "BALANCE",
                "OBSERVE", "REFLECT", "LEARN", "APPLY"
            ),
            listOf(
                ConnectionCategory(
                    "Scenario Analysis",
                    setOf("MODEL", "SCENARIO", "OUTCOME", "IMPACT"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Commitment Logic",
                    setOf("VALUE", "PRIORITY", "CHOICE", "COMMITMENT"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Constraint Balancing",
                    setOf("INPUT", "CONSTRAINT", "TRADEOFF", "BALANCE"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Applied Learning",
                    setOf("OBSERVE", "REFLECT", "LEARN", "APPLY"),
                    CategoryColor.PURPLE
                )
            ),
            "Expert"
        ),

        ConnectionPuzzle(
            286,
            listOf(
                "ASSUMPTION", "RISK", "UNCERTAINTY", "EXPOSURE",
                "PLAN", "HEDGE", "MITIGATE", "ADAPT",
                "SIGNAL", "SHIFT", "RESPONSE", "STABILIZE",
                "QUESTION", "ANALYZE", "DECIDE", "ACT"
            ),
            listOf(
                ConnectionCategory(
                    "Risk Landscape",
                    setOf("ASSUMPTION", "RISK", "UNCERTAINTY", "EXPOSURE"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Risk Response",
                    setOf("PLAN", "HEDGE", "MITIGATE", "ADAPT"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "System Stabilization",
                    setOf("SIGNAL", "SHIFT", "RESPONSE", "STABILIZE"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Decision to Action",
                    setOf("QUESTION", "ANALYZE", "DECIDE", "ACT"),
                    CategoryColor.PURPLE
                )
            ),
            "Expert"
        ),

        ConnectionPuzzle(
            287,
            listOf(
                "FRAME", "PERSPECTIVE", "CONTEXT", "INTERPRET",
                "GOAL", "PROXY", "METRIC", "ERROR",
                "SIGNAL", "NOISE", "DISTORT", "MISLEAD",
                "QUESTION", "REFRAME", "CLARIFY", "CONCLUDE"
            ),
            listOf(
                ConnectionCategory(
                    "Perspective Shift",
                    setOf("FRAME", "PERSPECTIVE", "CONTEXT", "INTERPRET"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Metric Failure",
                    setOf("GOAL", "PROXY", "METRIC", "ERROR"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Signal Degradation",
                    setOf("SIGNAL", "NOISE", "DISTORT", "MISLEAD"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Reasoned Conclusion",
                    setOf("QUESTION", "REFRAME", "CLARIFY", "CONCLUDE"),
                    CategoryColor.PURPLE
                )
            ),
            "Expert"
        ),

        ConnectionPuzzle(
            288,
            listOf(
                "MODEL", "EDGECASE", "STRESS", "FAILURE",
                "PLAN", "BUFFER", "REDUNDANCY", "RESILIENCE",
                "SIGNAL", "ANOMALY", "CONTAIN", "RECOVER",
                "OBSERVE", "DIAGNOSE", "FIX", "RESTORE"
            ),
            listOf(
                ConnectionCategory(
                    "Stress Failure",
                    setOf("MODEL", "EDGECASE", "STRESS", "FAILURE"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Resilient Systems",
                    setOf("PLAN", "BUFFER", "REDUNDANCY", "RESILIENCE"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Incident Control",
                    setOf("SIGNAL", "ANOMALY", "CONTAIN", "RECOVER"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Restoration Process",
                    setOf("OBSERVE", "DIAGNOSE", "FIX", "RESTORE"),
                    CategoryColor.PURPLE
                )
            ),
            "Expert"
        ),

        ConnectionPuzzle(
            289,
            listOf(
                "ASSUMPTION", "BIAS", "FILTER", "DISTORT",
                "VALUE", "INCENTIVE", "BEHAVIOR", "OUTCOME",
                "PLAN", "TEST", "FAIL", "IMPROVE",
                "QUESTION", "ANALYZE", "REFINE", "DECIDE"
            ),
            listOf(
                ConnectionCategory(
                    "Cognitive Filtering",
                    setOf("ASSUMPTION", "BIAS", "FILTER", "DISTORT"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Behavior Economics",
                    setOf("VALUE", "INCENTIVE", "BEHAVIOR", "OUTCOME"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Iteration Loop",
                    setOf("PLAN", "TEST", "FAIL", "IMPROVE"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Decision Refinement",
                    setOf("QUESTION", "ANALYZE", "REFINE", "DECIDE"),
                    CategoryColor.PURPLE
                )
            ),
            "Expert"
        ),

        ConnectionPuzzle(
            290,
            listOf(
                "SIGNAL", "INDICATOR", "METRIC", "BENCHMARK",
                "GOAL", "PLAN", "EXECUTE", "REVIEW",
                "ASSUMPTION", "TEST", "INVALIDATE", "UPDATE",
                "OBSERVE", "LEARN", "ADAPT", "REPEAT"
            ),
            listOf(
                ConnectionCategory(
                    "Performance Signals",
                    setOf("SIGNAL", "INDICATOR", "METRIC", "BENCHMARK"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Goal Management",
                    setOf("GOAL", "PLAN", "EXECUTE", "REVIEW"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Belief Updating",
                    setOf("ASSUMPTION", "TEST", "INVALIDATE", "UPDATE"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Learning Cycle",
                    setOf("OBSERVE", "LEARN", "ADAPT", "REPEAT"),
                    CategoryColor.PURPLE
                )
            ),
            "Expert"
        ),

        ConnectionPuzzle(
            291,
            listOf(
                "FRAME", "CONTEXT", "MEANING", "INTERPRET",
                "PLAN", "ALLOCATE", "EXECUTE", "MONITOR",
                "SIGNAL", "SHIFT", "RESPOND", "ADAPT",
                "QUESTION", "EXPLORE", "SYNTHESIZE", "INSIGHT"
            ),
            listOf(
                ConnectionCategory(
                    "Meaning Construction",
                    setOf("FRAME", "CONTEXT", "MEANING", "INTERPRET"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Operational Control",
                    setOf("PLAN", "ALLOCATE", "EXECUTE", "MONITOR"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Adaptive Response",
                    setOf("SIGNAL", "SHIFT", "RESPOND", "ADAPT"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Insight Path",
                    setOf("QUESTION", "EXPLORE", "SYNTHESIZE", "INSIGHT"),
                    CategoryColor.PURPLE
                )
            ),
            "Expert"
        ),

        ConnectionPuzzle(
            292,
            listOf(
                "ASSUMPTION", "UNCERTAINTY", "RISK", "EXPOSURE",
                "PLAN", "HEDGE", "MITIGATE", "BALANCE",
                "SIGNAL", "TREND", "SHIFT", "REGIME",
                "QUESTION", "REFRAME", "SIMPLIFY", "CLARIFY"
            ),
            listOf(
                ConnectionCategory(
                    "Risk Landscape",
                    setOf("ASSUMPTION", "UNCERTAINTY", "RISK", "EXPOSURE"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Risk Strategy",
                    setOf("PLAN", "HEDGE", "MITIGATE", "BALANCE"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "System Change",
                    setOf("SIGNAL", "TREND", "SHIFT", "REGIME"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Problem Reframing",
                    setOf("QUESTION", "REFRAME", "SIMPLIFY", "CLARIFY"),
                    CategoryColor.PURPLE
                )
            ),
            "Expert"
        ),

        ConnectionPuzzle(
            293,
            listOf(
                "MODEL", "SIMULATION", "PROJECTION", "ERROR",
                "INPUT", "NORMALIZE", "WEIGHT", "SCORE",
                "SIGNAL", "METRIC", "TARGET", "DISTORT",
                "OBSERVE", "REFLECT", "LEARN", "CORRECT"
            ),
            listOf(
                ConnectionCategory(
                    "Forecast Error",
                    setOf("MODEL", "SIMULATION", "PROJECTION", "ERROR"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Scoring Systems",
                    setOf("INPUT", "NORMALIZE", "WEIGHT", "SCORE"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Metric Distortion",
                    setOf("SIGNAL", "METRIC", "TARGET", "DISTORT"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Corrective Learning",
                    setOf("OBSERVE", "REFLECT", "LEARN", "CORRECT"),
                    CategoryColor.PURPLE
                )
            ),
            "Expert"
        ),

        ConnectionPuzzle(
            294,
            listOf(
                "FRAME", "ASSUMPTION", "LIMIT", "BREAK",
                "PLAN", "TEST", "STRESS", "FAIL",
                "SIGNAL", "ANOMALY", "ESCALATE", "CONTAIN",
                "QUESTION", "RETHINK", "ADAPT", "IMPROVE"
            ),
            listOf(
                ConnectionCategory(
                    "Model Limits",
                    setOf("FRAME", "ASSUMPTION", "LIMIT", "BREAK"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Stress Testing",
                    setOf("PLAN", "TEST", "STRESS", "FAIL"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Incident Escalation",
                    setOf("SIGNAL", "ANOMALY", "ESCALATE", "CONTAIN"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Iterative Thinking",
                    setOf("QUESTION", "RETHINK", "ADAPT", "IMPROVE"),
                    CategoryColor.PURPLE
                )
            ),
            "Expert"
        ),

        ConnectionPuzzle(
            295,
            listOf(
                "STATE", "CHANGE", "INSTABILITY", "CRISIS",
                "PLAN", "BUFFER", "RECOVER", "STABILIZE",
                "SIGNAL", "SHIFT", "RESPOND", "ADAPT",
                "OBSERVE", "DECIDE", "ACT", "REVIEW"
            ),
            listOf(
                ConnectionCategory(
                    "System Instability",
                    setOf("STATE", "CHANGE", "INSTABILITY", "CRISIS"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Recovery Planning",
                    setOf("PLAN", "BUFFER", "RECOVER", "STABILIZE"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Adaptive Control",
                    setOf("SIGNAL", "SHIFT", "RESPOND", "ADAPT"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Action Review",
                    setOf("OBSERVE", "DECIDE", "ACT", "REVIEW"),
                    CategoryColor.PURPLE
                )
            ),
            "Expert"
        ),

        ConnectionPuzzle(
            296,
            listOf(
                "ASSUMPTION", "BIAS", "DISTORTION", "ERROR",
                "INPUT", "FILTER", "AGGREGATE", "MODEL",
                "SIGNAL", "METRIC", "THRESHOLD", "ALERT",
                "QUESTION", "ANALYZE", "DECIDE", "ACT"
            ),
            listOf(
                ConnectionCategory(
                    "Cognitive Bias",
                    setOf("ASSUMPTION", "BIAS", "DISTORTION", "ERROR"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Data Aggregation",
                    setOf("INPUT", "FILTER", "AGGREGATE", "MODEL"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Alert Mechanism",
                    setOf("SIGNAL", "METRIC", "THRESHOLD", "ALERT"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Decision Execution",
                    setOf("QUESTION", "ANALYZE", "DECIDE", "ACT"),
                    CategoryColor.PURPLE
                )
            ),
            "Expert"
        ),

        ConnectionPuzzle(
            297,
            listOf(
                "FRAME", "CONTEXT", "INTERPRET", "MEANING",
                "GOAL", "METRIC", "TRACK", "ADJUST",
                "SIGNAL", "NOISE", "FILTER", "CLARIFY",
                "OBSERVE", "REFLECT", "LEARN", "APPLY"
            ),
            listOf(
                ConnectionCategory(
                    "Interpretive Context",
                    setOf("FRAME", "CONTEXT", "INTERPRET", "MEANING"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Performance Adjustment",
                    setOf("GOAL", "METRIC", "TRACK", "ADJUST"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Signal Clarification",
                    setOf("SIGNAL", "NOISE", "FILTER", "CLARIFY"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Applied Learning",
                    setOf("OBSERVE", "REFLECT", "LEARN", "APPLY"),
                    CategoryColor.PURPLE
                )
            ),
            "Expert"
        ),

        ConnectionPuzzle(
            298,
            listOf(
                "MODEL", "SCENARIO", "OUTCOME", "IMPACT",
                "VALUE", "PRIORITY", "CHOICE", "COMMIT",
                "INPUT", "CONSTRAINT", "TRADEOFF", "BALANCE",
                "QUESTION", "EXPLORE", "EVALUATE", "DECIDE"
            ),
            listOf(
                ConnectionCategory(
                    "Impact Analysis",
                    setOf("MODEL", "SCENARIO", "OUTCOME", "IMPACT"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Commitment Logic",
                    setOf("VALUE", "PRIORITY", "CHOICE", "COMMIT"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Constraint Resolution",
                    setOf("INPUT", "CONSTRAINT", "TRADEOFF", "BALANCE"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Strategic Decision",
                    setOf("QUESTION", "EXPLORE", "EVALUATE", "DECIDE"),
                    CategoryColor.PURPLE
                )
            ),
            "Expert"
        ),

        ConnectionPuzzle(
            299,
            listOf(
                "ASSUMPTION", "UNCERTAINTY", "AMBIGUITY", "CHAOS",
                "PLAN", "OPTION", "FLEX", "RESPOND",
                "SIGNAL", "SENSE", "DECIDE", "ACT",
                "OBSERVE", "ORIENT", "DECIDE", "ACT"
            ),
            listOf(
                ConnectionCategory(
                    "Complex Environments",
                    setOf("ASSUMPTION", "UNCERTAINTY", "AMBIGUITY", "CHAOS"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Strategic Flexibility",
                    setOf("PLAN", "OPTION", "FLEX", "RESPOND"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Sense-Act Loop",
                    setOf("SIGNAL", "SENSE", "DECIDE", "ACT"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "OODA Loop",
                    setOf("OBSERVE", "ORIENT", "DECIDE", "ACT"),
                    CategoryColor.PURPLE
                )
            ),
            "Expert"
        ),

        ConnectionPuzzle(
            300,
            listOf(
                "MODEL", "ASSUMPTION", "REALITY", "DIVERGENCE",
                "PLAN", "TEST", "LEARN", "ADAPT",
                "SIGNAL", "SHIFT", "RESPOND", "STABILIZE",
                "QUESTION", "ANALYZE", "DECIDE", "ACT"
            ),
            listOf(
                ConnectionCategory(
                    "Model Drift",
                    setOf("MODEL", "ASSUMPTION", "REALITY", "DIVERGENCE"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Learning Strategy",
                    setOf("PLAN", "TEST", "LEARN", "ADAPT"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "System Stabilization",
                    setOf("SIGNAL", "SHIFT", "RESPOND", "STABILIZE"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Decision Execution",
                    setOf("QUESTION", "ANALYZE", "DECIDE", "ACT"),
                    CategoryColor.PURPLE
                )
            ),
            "Expert"
        )
    )
}
