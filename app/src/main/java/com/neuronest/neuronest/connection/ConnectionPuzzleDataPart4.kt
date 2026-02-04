package com.neuronest.neuronest.connection

object ConnectionPuzzleDataPart4 {
    fun getPuzzles(): List<ConnectionPuzzle> = listOf(
        ConnectionPuzzle(
            301,
            listOf(
                "FRAME", "AXIOM", "ASSUMPTION", "PREMISE",
                "PLAN", "BRANCH", "MERGE", "COMMIT",
                "SIGNAL", "AMPLIFY", "DAMPEN", "STABILIZE",
                "QUESTION", "ABSTRACT", "GENERALIZE", "TRANSFER"
            ),
            listOf(
                ConnectionCategory(
                    "Foundational Beliefs",
                    setOf("FRAME", "AXIOM", "ASSUMPTION", "PREMISE"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Version Control Actions",
                    setOf("PLAN", "BRANCH", "MERGE", "COMMIT"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "System Regulation",
                    setOf("SIGNAL", "AMPLIFY", "DAMPEN", "STABILIZE"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Conceptual Transfer",
                    setOf("QUESTION", "ABSTRACT", "GENERALIZE", "TRANSFER"),
                    CategoryColor.PURPLE
                )
            ),
            "Very Hard"
        ),

        ConnectionPuzzle(
            302,
            listOf(
                "STATE", "PHASE", "THRESHOLD", "REGIME",
                "INPUT", "LATENCY", "THROUGHPUT", "SATURATION",
                "GOAL", "PROXY", "METRIC", "DRIFT",
                "OBSERVE", "INTERPRET", "DECIDE", "ACT"
            ),
            listOf(
                ConnectionCategory(
                    "System Phase Change",
                    setOf("STATE", "PHASE", "THRESHOLD", "REGIME"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Capacity Limits",
                    setOf("INPUT", "LATENCY", "THROUGHPUT", "SATURATION"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Measurement Drift",
                    setOf("GOAL", "PROXY", "METRIC", "DRIFT"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Decision Loop",
                    setOf("OBSERVE", "INTERPRET", "DECIDE", "ACT"),
                    CategoryColor.PURPLE
                )
            ),
            "Very Hard"
        ),

        ConnectionPuzzle(
            303,
            listOf(
                "MODEL", "SURROGATE", "PROXY", "STANDIN",
                "PLAN", "SIMULATE", "SENSITIZE", "STRESS",
                "SIGNAL", "NOISE", "BIAS", "ALIASING",
                "QUESTION", "DECOMPOSE", "ISOLATE", "RESOLVE"
            ),
            listOf(
                ConnectionCategory(
                    "Representation Substitutes",
                    setOf("MODEL", "SURROGATE", "PROXY", "STANDIN"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Stress Preparation",
                    setOf("PLAN", "SIMULATE", "SENSITIZE", "STRESS"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Information Corruption",
                    setOf("SIGNAL", "NOISE", "BIAS", "ALIASING"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Problem Isolation",
                    setOf("QUESTION", "DECOMPOSE", "ISOLATE", "RESOLVE"),
                    CategoryColor.PURPLE
                )
            ),
            "Very Hard"
        ),

        ConnectionPuzzle(
            304,
            listOf(
                "INCENTIVE", "REWARD", "PUNISHMENT", "SIGNAL",
                "RULE", "EXCEPTION", "LOOPHOLE", "EXPLOIT",
                "PLAN", "BUFFER", "HEDGE", "OPTION",
                "OBSERVE", "FEEDBACK", "ADJUST", "ITERATE"
            ),
            listOf(
                ConnectionCategory(
                    "Behavior Shaping",
                    setOf("INCENTIVE", "REWARD", "PUNISHMENT", "SIGNAL"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Rule Circumvention",
                    setOf("RULE", "EXCEPTION", "LOOPHOLE", "EXPLOIT"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Downside Protection",
                    setOf("PLAN", "BUFFER", "HEDGE", "OPTION"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Adaptive Iteration",
                    setOf("OBSERVE", "FEEDBACK", "ADJUST", "ITERATE"),
                    CategoryColor.PURPLE
                )
            ),
            "Very Hard"
        ),

        ConnectionPuzzle(
            305,
            listOf(
                "CAUSE", "CORRELATION", "CONFOUND", "SPURIOUS",
                "DATA", "SAMPLE", "POPULATION", "DISTRIBUTION",
                "SIGNAL", "THRESHOLD", "ALERT", "ESCALATION",
                "QUESTION", "REFRAME", "RESTRICT", "FOCUS"
            ),
            listOf(
                ConnectionCategory(
                    "Statistical Fallacies",
                    setOf("CAUSE", "CORRELATION", "CONFOUND", "SPURIOUS"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Statistical Scope",
                    setOf("DATA", "SAMPLE", "POPULATION", "DISTRIBUTION"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Alert Escalation",
                    setOf("SIGNAL", "THRESHOLD", "ALERT", "ESCALATION"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Problem Narrowing",
                    setOf("QUESTION", "REFRAME", "RESTRICT", "FOCUS"),
                    CategoryColor.PURPLE
                )
            ),
            "Very Hard"
        ),

        ConnectionPuzzle(
            306,
            listOf(
                "MODEL", "EDGECASE", "BOUNDARY", "PATHOLOGY",
                "PLAN", "REDUNDANCY", "FAILOVER", "RECOVERY",
                "SIGNAL", "CASCADE", "AMPLIFICATION", "COLLAPSE",
                "OBSERVE", "DIAGNOSE", "INTERVENE", "RESTORE"
            ),
            listOf(
                ConnectionCategory(
                    "Model Pathologies",
                    setOf("MODEL", "EDGECASE", "BOUNDARY", "PATHOLOGY"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Fault Tolerance",
                    setOf("PLAN", "REDUNDANCY", "FAILOVER", "RECOVERY"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Failure Cascades",
                    setOf("SIGNAL", "CASCADE", "AMPLIFICATION", "COLLAPSE"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "System Restoration",
                    setOf("OBSERVE", "DIAGNOSE", "INTERVENE", "RESTORE"),
                    CategoryColor.PURPLE
                )
            ),
            "Very Hard"
        ),

        ConnectionPuzzle(
            307,
            listOf(
                "FRAME", "NARRATIVE", "CONTEXT", "SPIN",
                "VALUE", "UTILITY", "TRADEOFF", "SACRIFICE",
                "PLAN", "ALLOCATE", "PRIORITIZE", "SEQUENCE",
                "QUESTION", "SYNTHESIZE", "INTEGRATE", "CONCLUDE"
            ),
            listOf(
                ConnectionCategory(
                    "Narrative Framing",
                    setOf("FRAME", "NARRATIVE", "CONTEXT", "SPIN"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Cost–Benefit Logic",
                    setOf("VALUE", "UTILITY", "TRADEOFF", "SACRIFICE"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Execution Ordering",
                    setOf("PLAN", "ALLOCATE", "PRIORITIZE", "SEQUENCE"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Integrative Reasoning",
                    setOf("QUESTION", "SYNTHESIZE", "INTEGRATE", "CONCLUDE"),
                    CategoryColor.PURPLE
                )
            ),
            "Very Hard"
        ),

        ConnectionPuzzle(
            308,
            listOf(
                "ASSUMPTION", "UNCERTAINTY", "AMBIGUITY", "CHAOS",
                "PLAN", "OPTION", "FLEX", "PIVOT",
                "SIGNAL", "DELAY", "OVERSHOOT", "OSCILLATE",
                "OBSERVE", "REFLECT", "LEARN", "ADAPT"
            ),
            listOf(
                ConnectionCategory(
                    "Decision Contexts",
                    setOf("ASSUMPTION", "UNCERTAINTY", "AMBIGUITY", "CHAOS"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Strategic Optionality",
                    setOf("PLAN", "OPTION", "FLEX", "PIVOT"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Control Oscillation",
                    setOf("SIGNAL", "DELAY", "OVERSHOOT", "OSCILLATE"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Adaptive Learning",
                    setOf("OBSERVE", "REFLECT", "LEARN", "ADAPT"),
                    CategoryColor.PURPLE
                )
            ),
            "Very Hard"
        ),

        ConnectionPuzzle(
            309,
            listOf(
                "MODEL", "GENERALIZE", "TRANSFER", "MISAPPLY",
                "GOAL", "METRIC", "TARGET", "GAMING",
                "SIGNAL", "NOISE", "FILTER", "CLARITY",
                "QUESTION", "ABSTRACT", "TEST", "REFINE"
            ),
            listOf(
                ConnectionCategory(
                    "Abstraction Errors",
                    setOf("MODEL", "GENERALIZE", "TRANSFER", "MISAPPLY"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Metric Exploitation",
                    setOf("GOAL", "METRIC", "TARGET", "GAMING"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Signal Cleaning",
                    setOf("SIGNAL", "NOISE", "FILTER", "CLARITY"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Concept Validation",
                    setOf("QUESTION", "ABSTRACT", "TEST", "REFINE"),
                    CategoryColor.PURPLE
                )
            ),
            "Very Hard"
        ),

        ConnectionPuzzle(
            310,
            listOf(
                "STATE", "INSTABILITY", "CRISIS", "RESET",
                "PLAN", "BUFFER", "ABSORB", "STABILIZE",
                "SIGNAL", "SHIFT", "RESPOND", "ADAPT",
                "OBSERVE", "DECIDE", "ACT", "REVIEW"
            ),
            listOf(
                ConnectionCategory(
                    "System Breakdown",
                    setOf("STATE", "INSTABILITY", "CRISIS", "RESET"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Shock Absorption",
                    setOf("PLAN", "BUFFER", "ABSORB", "STABILIZE"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Adaptive Control",
                    setOf("SIGNAL", "SHIFT", "RESPOND", "ADAPT"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Action Review Loop",
                    setOf("OBSERVE", "DECIDE", "ACT", "REVIEW"),
                    CategoryColor.PURPLE
                )
            ),
            "Very Hard"
        ),

        ConnectionPuzzle(
            311,
            listOf(
                "AXIOM", "LEMMA", "THEOREM", "PROOF",
                "PLAN", "BRANCH", "MERGE", "DEPLOY",
                "SIGNAL", "GAIN", "LOSS", "STABILITY",
                "QUESTION", "FORMALIZE", "DERIVE", "VERIFY"
            ),
            listOf(
                ConnectionCategory(
                    "Mathematical Reasoning",
                    setOf("AXIOM", "LEMMA", "THEOREM", "PROOF"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Software Release Flow",
                    setOf("PLAN", "BRANCH", "MERGE", "DEPLOY"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Control System Properties",
                    setOf("SIGNAL", "GAIN", "LOSS", "STABILITY"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Logical Validation",
                    setOf("QUESTION", "FORMALIZE", "DERIVE", "VERIFY"),
                    CategoryColor.PURPLE
                )
            ),
            "Very Hard"
        ),

        ConnectionPuzzle(
            312,
            listOf(
                "STATE", "ENTROPY", "DISORDER", "DECAY",
                "INPUT", "QUEUE", "LATENCY", "THROUGHPUT",
                "GOAL", "METRIC", "BENCHMARK", "DRIFT",
                "OBSERVE", "INTERPRET", "ADJUST", "REPEAT"
            ),
            listOf(
                ConnectionCategory(
                    "Thermodynamic Concepts",
                    setOf("STATE", "ENTROPY", "DISORDER", "DECAY"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "System Performance",
                    setOf("INPUT", "QUEUE", "LATENCY", "THROUGHPUT"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Measurement Degradation",
                    setOf("GOAL", "METRIC", "BENCHMARK", "DRIFT"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Feedback Cycle",
                    setOf("OBSERVE", "INTERPRET", "ADJUST", "REPEAT"),
                    CategoryColor.PURPLE
                )
            ),
            "Very Hard"
        ),

        ConnectionPuzzle(
            313,
            listOf(
                "MODEL", "REPRESENT", "ABSTRACT", "SIMPLIFY",
                "CAUSE", "INTERACTION", "EMERGENCE", "OUTCOME",
                "PLAN", "PARALLEL", "SERIAL", "PIPELINE",
                "QUESTION", "SCOPE", "BOUND", "FOCUS"
            ),
            listOf(
                ConnectionCategory(
                    "Abstraction Techniques",
                    setOf("MODEL", "REPRESENT", "ABSTRACT", "SIMPLIFY"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Complex Causality",
                    setOf("CAUSE", "INTERACTION", "EMERGENCE", "OUTCOME"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Execution Patterns",
                    setOf("PLAN", "PARALLEL", "SERIAL", "PIPELINE"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Problem Bounding",
                    setOf("QUESTION", "SCOPE", "BOUND", "FOCUS"),
                    CategoryColor.PURPLE
                )
            ),
            "Very Hard"
        ),

        ConnectionPuzzle(
            314,
            listOf(
                "INCENTIVE", "PRESSURE", "CONFORMITY", "DEVIATION",
                "SIGNAL", "THRESHOLD", "TRIGGER", "ESCALATE",
                "PLAN", "BUFFER", "HEDGE", "INSURE",
                "OBSERVE", "REFLECT", "LEARN", "ADAPT"
            ),
            listOf(
                ConnectionCategory(
                    "Social Dynamics",
                    setOf("INCENTIVE", "PRESSURE", "CONFORMITY", "DEVIATION"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Event Escalation",
                    setOf("SIGNAL", "THRESHOLD", "TRIGGER", "ESCALATE"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Risk Protection",
                    setOf("PLAN", "BUFFER", "HEDGE", "INSURE"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Adaptive Learning",
                    setOf("OBSERVE", "REFLECT", "LEARN", "ADAPT"),
                    CategoryColor.PURPLE
                )
            ),
            "Very Hard"
        ),

        ConnectionPuzzle(
            315,
            listOf(
                "ASSUMPTION", "BIAS", "HEURISTIC", "ERROR",
                "DATA", "CLEAN", "TRANSFORM", "NORMALIZE",
                "SIGNAL", "NOISE", "FILTER", "AMPLIFY",
                "QUESTION", "ANALYZE", "REFINE", "DECIDE"
            ),
            listOf(
                ConnectionCategory(
                    "Cognitive Shortcuts",
                    setOf("ASSUMPTION", "BIAS", "HEURISTIC", "ERROR"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Data Preparation",
                    setOf("DATA", "CLEAN", "TRANSFORM", "NORMALIZE"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Signal Processing",
                    setOf("SIGNAL", "NOISE", "FILTER", "AMPLIFY"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Decision Refinement",
                    setOf("QUESTION", "ANALYZE", "REFINE", "DECIDE"),
                    CategoryColor.PURPLE
                )
            ),
            "Very Hard"
        ),

        ConnectionPuzzle(
            316,
            listOf(
                "STATE", "PHASE", "TRANSITION", "REGIME",
                "MODEL", "EDGECASE", "FAILURE", "COLLAPSE",
                "PLAN", "REDUNDANCY", "FAILOVER", "RECOVER",
                "OBSERVE", "DIAGNOSE", "INTERVENE", "RESTORE"
            ),
            listOf(
                ConnectionCategory(
                    "Phase Change",
                    setOf("STATE", "PHASE", "TRANSITION", "REGIME"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "System Fragility",
                    setOf("MODEL", "EDGECASE", "FAILURE", "COLLAPSE"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Fault Tolerance",
                    setOf("PLAN", "REDUNDANCY", "FAILOVER", "RECOVER"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Recovery Process",
                    setOf("OBSERVE", "DIAGNOSE", "INTERVENE", "RESTORE"),
                    CategoryColor.PURPLE
                )
            ),
            "Very Hard"
        ),

        ConnectionPuzzle(
            317,
            listOf(
                "FRAME", "CONTEXT", "NARRATIVE", "SPIN",
                "GOAL", "PRIORITY", "TRADEOFF", "CHOICE",
                "INPUT", "WEIGHT", "SCORE", "RANK",
                "QUESTION", "SYNTHESIZE", "INTEGRATE", "CONCLUDE"
            ),
            listOf(
                ConnectionCategory(
                    "Narrative Framing",
                    setOf("FRAME", "CONTEXT", "NARRATIVE", "SPIN"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Decision Tradeoffs",
                    setOf("GOAL", "PRIORITY", "TRADEOFF", "CHOICE"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Ranking Systems",
                    setOf("INPUT", "WEIGHT", "SCORE", "RANK"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Integrative Reasoning",
                    setOf("QUESTION", "SYNTHESIZE", "INTEGRATE", "CONCLUDE"),
                    CategoryColor.PURPLE
                )
            ),
            "Very Hard"
        ),

        ConnectionPuzzle(
            318,
            listOf(
                "UNCERTAINTY", "VARIANCE", "VOLATILITY", "CHAOS",
                "PLAN", "OPTION", "PIVOT", "FLEX",
                "SIGNAL", "DELAY", "OVERSHOOT", "OSCILLATE",
                "OBSERVE", "LEARN", "UPDATE", "REPEAT"
            ),
            listOf(
                ConnectionCategory(
                    "Unstable Environments",
                    setOf("UNCERTAINTY", "VARIANCE", "VOLATILITY", "CHAOS"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Strategic Optionality",
                    setOf("PLAN", "OPTION", "PIVOT", "FLEX"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Control Oscillation",
                    setOf("SIGNAL", "DELAY", "OVERSHOOT", "OSCILLATE"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Learning Loop",
                    setOf("OBSERVE", "LEARN", "UPDATE", "REPEAT"),
                    CategoryColor.PURPLE
                )
            ),
            "Very Hard"
        ),

        ConnectionPuzzle(
            319,
            listOf(
                "MODEL", "GENERALIZE", "TRANSFER", "MISAPPLY",
                "GOAL", "METRIC", "TARGET", "GAMING",
                "SIGNAL", "NOISE", "DISTORT", "MISLEAD",
                "QUESTION", "ABSTRACT", "TEST", "REFINE"
            ),
            listOf(
                ConnectionCategory(
                    "Abstraction Pitfalls",
                    setOf("MODEL", "GENERALIZE", "TRANSFER", "MISAPPLY"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Metric Gaming",
                    setOf("GOAL", "METRIC", "TARGET", "GAMING"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Signal Distortion",
                    setOf("SIGNAL", "NOISE", "DISTORT", "MISLEAD"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Concept Validation",
                    setOf("QUESTION", "ABSTRACT", "TEST", "REFINE"),
                    CategoryColor.PURPLE
                )
            ),
            "Very Hard"
        ),

        ConnectionPuzzle(
            320,
            listOf(
                "STATE", "INSTABILITY", "CRISIS", "RESET",
                "PLAN", "BUFFER", "ABSORB", "STABILIZE",
                "SIGNAL", "SHIFT", "RESPOND", "ADAPT",
                "OBSERVE", "DECIDE", "ACT", "REVIEW"
            ),
            listOf(
                ConnectionCategory(
                    "System Breakdown",
                    setOf("STATE", "INSTABILITY", "CRISIS", "RESET"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Shock Absorption",
                    setOf("PLAN", "BUFFER", "ABSORB", "STABILIZE"),
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
            "Very Hard"
        ),

        ConnectionPuzzle(
            321,
            listOf(
                "AXIOM", "POSTULATE", "ASSUMPTION", "PREMISE",
                "PLAN", "PIPELINE", "QUEUE", "EXECUTE",
                "SIGNAL", "GAIN", "ATTENUATE", "STABILIZE",
                "QUESTION", "FORMALIZE", "PROVE", "VERIFY"
            ),
            listOf(
                ConnectionCategory(
                    "Foundational Logic",
                    setOf("AXIOM", "POSTULATE", "ASSUMPTION", "PREMISE"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Processing Flow",
                    setOf("PLAN", "PIPELINE", "QUEUE", "EXECUTE"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Signal Control",
                    setOf("SIGNAL", "GAIN", "ATTENUATE", "STABILIZE"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Proof Construction",
                    setOf("QUESTION", "FORMALIZE", "PROVE", "VERIFY"),
                    CategoryColor.PURPLE
                )
            ),
            "Very Hard"
        ),

        ConnectionPuzzle(
            322,
            listOf(
                "STATE", "ENTROPY", "DISORDER", "IRREVERSIBLE",
                "INPUT", "LATENCY", "BOTTLENECK", "SATURATION",
                "GOAL", "BENCHMARK", "METRIC", "DRIFT",
                "OBSERVE", "INTERPRET", "CORRECT", "REPEAT"
            ),
            listOf(
                ConnectionCategory(
                    "Thermodynamic Direction",
                    setOf("STATE", "ENTROPY", "DISORDER", "IRREVERSIBLE"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Capacity Constraints",
                    setOf("INPUT", "LATENCY", "BOTTLENECK", "SATURATION"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Measurement Degradation",
                    setOf("GOAL", "BENCHMARK", "METRIC", "DRIFT"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Feedback Correction",
                    setOf("OBSERVE", "INTERPRET", "CORRECT", "REPEAT"),
                    CategoryColor.PURPLE
                )
            ),
            "Very Hard"
        ),

        ConnectionPuzzle(
            323,
            listOf(
                "MODEL", "REPRESENT", "ENCODE", "ABSTRACT",
                "CAUSE", "INTERACTION", "FEEDBACK", "EMERGENCE",
                "PLAN", "SERIAL", "PARALLEL", "PIPELINED",
                "QUESTION", "BOUND", "ISOLATE", "SOLVE"
            ),
            listOf(
                ConnectionCategory(
                    "Representation Methods",
                    setOf("MODEL", "REPRESENT", "ENCODE", "ABSTRACT"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Emergent Causality",
                    setOf("CAUSE", "INTERACTION", "FEEDBACK", "EMERGENCE"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Execution Modes",
                    setOf("PLAN", "SERIAL", "PARALLEL", "PIPELINED"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Problem Isolation",
                    setOf("QUESTION", "BOUND", "ISOLATE", "SOLVE"),
                    CategoryColor.PURPLE
                )
            ),
            "Very Hard"
        ),

        ConnectionPuzzle(
            324,
            listOf(
                "INCENTIVE", "REWARD", "SANCTION", "DETERRENCE",
                "SIGNAL", "THRESHOLD", "TRIGGER", "CASCADE",
                "PLAN", "HEDGE", "BUFFER", "OPTION",
                "OBSERVE", "EVALUATE", "ADJUST", "ITERATE"
            ),
            listOf(
                ConnectionCategory(
                    "Behavior Shaping",
                    setOf("INCENTIVE", "REWARD", "SANCTION", "DETERRENCE"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Escalation Dynamics",
                    setOf("SIGNAL", "THRESHOLD", "TRIGGER", "CASCADE"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Downside Protection",
                    setOf("PLAN", "HEDGE", "BUFFER", "OPTION"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Adaptive Iteration",
                    setOf("OBSERVE", "EVALUATE", "ADJUST", "ITERATE"),
                    CategoryColor.PURPLE
                )
            ),
            "Very Hard"
        ),

        ConnectionPuzzle(
            325,
            listOf(
                "ASSUMPTION", "BIAS", "HEURISTIC", "MISJUDGMENT",
                "DATA", "FILTER", "NORMALIZE", "TRANSFORM",
                "SIGNAL", "NOISE", "DISTORT", "ALIAS",
                "QUESTION", "ANALYZE", "REFINE", "DECIDE"
            ),
            listOf(
                ConnectionCategory(
                    "Cognitive Biases",
                    setOf("ASSUMPTION", "BIAS", "HEURISTIC", "MISJUDGMENT"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Data Conditioning",
                    setOf("DATA", "FILTER", "NORMALIZE", "TRANSFORM"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Signal Corruption",
                    setOf("SIGNAL", "NOISE", "DISTORT", "ALIAS"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Decision Refinement",
                    setOf("QUESTION", "ANALYZE", "REFINE", "DECIDE"),
                    CategoryColor.PURPLE
                )
            ),
            "Very Hard"
        ),

        ConnectionPuzzle(
            326,
            listOf(
                "STATE", "PHASE", "TRANSITION", "REGIME",
                "MODEL", "EDGECASE", "BOUNDARY", "FAILURE",
                "PLAN", "REDUNDANCY", "FAILOVER", "RECOVER",
                "OBSERVE", "DIAGNOSE", "INTERVENE", "RESTORE"
            ),
            listOf(
                ConnectionCategory(
                    "Phase Transitions",
                    setOf("STATE", "PHASE", "TRANSITION", "REGIME"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Model Fragility",
                    setOf("MODEL", "EDGECASE", "BOUNDARY", "FAILURE"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Fault Tolerance",
                    setOf("PLAN", "REDUNDANCY", "FAILOVER", "RECOVER"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "System Recovery",
                    setOf("OBSERVE", "DIAGNOSE", "INTERVENE", "RESTORE"),
                    CategoryColor.PURPLE
                )
            ),
            "Very Hard"
        ),

        ConnectionPuzzle(
            327,
            listOf(
                "FRAME", "NARRATIVE", "CONTEXT", "SPIN",
                "VALUE", "COST", "TRADEOFF", "SACRIFICE",
                "INPUT", "WEIGHT", "SCORE", "RANK",
                "QUESTION", "SYNTHESIZE", "INTEGRATE", "CONCLUDE"
            ),
            listOf(
                ConnectionCategory(
                    "Narrative Framing",
                    setOf("FRAME", "NARRATIVE", "CONTEXT", "SPIN"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Economic Tradeoffs",
                    setOf("VALUE", "COST", "TRADEOFF", "SACRIFICE"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Ranking Systems",
                    setOf("INPUT", "WEIGHT", "SCORE", "RANK"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Integrative Reasoning",
                    setOf("QUESTION", "SYNTHESIZE", "INTEGRATE", "CONCLUDE"),
                    CategoryColor.PURPLE
                )
            ),
            "Very Hard"
        ),

        ConnectionPuzzle(
            328,
            listOf(
                "UNCERTAINTY", "VARIANCE", "VOLATILITY", "TURBULENCE",
                "PLAN", "OPTION", "FLEX", "PIVOT",
                "SIGNAL", "DELAY", "OVERSHOOT", "OSCILLATION",
                "OBSERVE", "LEARN", "UPDATE", "REPEAT"
            ),
            listOf(
                ConnectionCategory(
                    "Unstable Conditions",
                    setOf("UNCERTAINTY", "VARIANCE", "VOLATILITY", "TURBULENCE"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Strategic Optionality",
                    setOf("PLAN", "OPTION", "FLEX", "PIVOT"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Control Oscillation",
                    setOf("SIGNAL", "DELAY", "OVERSHOOT", "OSCILLATION"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Learning Loop",
                    setOf("OBSERVE", "LEARN", "UPDATE", "REPEAT"),
                    CategoryColor.PURPLE
                )
            ),
            "Very Hard"
        ),

        ConnectionPuzzle(
            329,
            listOf(
                "MODEL", "GENERALIZE", "TRANSFER", "OVERFIT",
                "GOAL", "METRIC", "TARGET", "GAMING",
                "SIGNAL", "NOISE", "FILTER", "CLARITY",
                "QUESTION", "ABSTRACT", "TEST", "REFINE"
            ),
            listOf(
                ConnectionCategory(
                    "Generalization Errors",
                    setOf("MODEL", "GENERALIZE", "TRANSFER", "OVERFIT"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Metric Manipulation",
                    setOf("GOAL", "METRIC", "TARGET", "GAMING"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Signal Cleaning",
                    setOf("SIGNAL", "NOISE", "FILTER", "CLARITY"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Concept Validation",
                    setOf("QUESTION", "ABSTRACT", "TEST", "REFINE"),
                    CategoryColor.PURPLE
                )
            ),
            "Very Hard"
        ),

        ConnectionPuzzle(
            330,
            listOf(
                "STATE", "INSTABILITY", "CRISIS", "RESET",
                "PLAN", "BUFFER", "ABSORB", "STABILIZE",
                "SIGNAL", "SHIFT", "RESPOND", "ADAPT",
                "OBSERVE", "DECIDE", "ACT", "REVIEW"
            ),
            listOf(
                ConnectionCategory(
                    "System Breakdown",
                    setOf("STATE", "INSTABILITY", "CRISIS", "RESET"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Shock Absorption",
                    setOf("PLAN", "BUFFER", "ABSORB", "STABILIZE"),
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
            "Very Hard"
        ),

        ConnectionPuzzle(
            331,
            listOf(
                "AXIOM", "ASSUMPTION", "INFERENCE", "CONCLUSION",
                "PLAN", "PIPELINE", "QUEUE", "DISPATCH",
                "SIGNAL", "AMPLIFY", "ATTENUATE", "FILTER",
                "QUESTION", "FORMALIZE", "EVALUATE", "VERIFY"
            ),
            listOf(
                ConnectionCategory(
                    "Logical Derivation",
                    setOf("AXIOM", "ASSUMPTION", "INFERENCE", "CONCLUSION"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Task Scheduling",
                    setOf("PLAN", "PIPELINE", "QUEUE", "DISPATCH"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Signal Conditioning",
                    setOf("SIGNAL", "AMPLIFY", "ATTENUATE", "FILTER"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Proof Validation",
                    setOf("QUESTION", "FORMALIZE", "EVALUATE", "VERIFY"),
                    CategoryColor.PURPLE
                )
            ),
            "Very Hard"
        ),

        ConnectionPuzzle(
            332,
            listOf(
                "STATE", "ENTROPY", "DECAY", "IRREVERSIBLE",
                "INPUT", "LATENCY", "BOTTLENECK", "OVERLOAD",
                "GOAL", "METRIC", "BENCHMARK", "DEGRADATION",
                "OBSERVE", "INTERPRET", "CORRECT", "ITERATE"
            ),
            listOf(
                ConnectionCategory(
                    "Irreversible Processes",
                    setOf("STATE", "ENTROPY", "DECAY", "IRREVERSIBLE"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Performance Saturation",
                    setOf("INPUT", "LATENCY", "BOTTLENECK", "OVERLOAD"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Metric Degradation",
                    setOf("GOAL", "METRIC", "BENCHMARK", "DEGRADATION"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Correction Loop",
                    setOf("OBSERVE", "INTERPRET", "CORRECT", "ITERATE"),
                    CategoryColor.PURPLE
                )
            ),
            "Very Hard"
        ),

        ConnectionPuzzle(
            333,
            listOf(
                "MODEL", "REPRESENT", "ENCODE", "SIMPLIFY",
                "CAUSE", "INTERACTION", "FEEDBACK", "NONLINEARITY",
                "PLAN", "SERIAL", "PARALLEL", "PIPELINED",
                "QUESTION", "ISOLATE", "BOUND", "SOLVE"
            ),
            listOf(
                ConnectionCategory(
                    "Model Representation",
                    setOf("MODEL", "REPRESENT", "ENCODE", "SIMPLIFY"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Nonlinear Causality",
                    setOf("CAUSE", "INTERACTION", "FEEDBACK", "NONLINEARITY"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Execution Structures",
                    setOf("PLAN", "SERIAL", "PARALLEL", "PIPELINED"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Problem Isolation",
                    setOf("QUESTION", "ISOLATE", "BOUND", "SOLVE"),
                    CategoryColor.PURPLE
                )
            ),
            "Very Hard"
        ),

        ConnectionPuzzle(
            334,
            listOf(
                "INCENTIVE", "REWARD", "PENALTY", "DETERRENCE",
                "SIGNAL", "THRESHOLD", "TRIGGER", "CASCADE",
                "PLAN", "HEDGE", "BUFFER", "OPTION",
                "OBSERVE", "EVALUATE", "ADJUST", "REPEAT"
            ),
            listOf(
                ConnectionCategory(
                    "Behavioral Controls",
                    setOf("INCENTIVE", "REWARD", "PENALTY", "DETERRENCE"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Escalation Mechanics",
                    setOf("SIGNAL", "THRESHOLD", "TRIGGER", "CASCADE"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Risk Protection",
                    setOf("PLAN", "HEDGE", "BUFFER", "OPTION"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Adaptive Adjustment",
                    setOf("OBSERVE", "EVALUATE", "ADJUST", "REPEAT"),
                    CategoryColor.PURPLE
                )
            ),
            "Very Hard"
        ),

        ConnectionPuzzle(
            335,
            listOf(
                "ASSUMPTION", "BIAS", "HEURISTIC", "MISREAD",
                "DATA", "FILTER", "NORMALIZE", "TRANSFORM",
                "SIGNAL", "NOISE", "DISTORT", "ALIAS",
                "QUESTION", "ANALYZE", "REFINE", "DECIDE"
            ),
            listOf(
                ConnectionCategory(
                    "Cognitive Distortions",
                    setOf("ASSUMPTION", "BIAS", "HEURISTIC", "MISREAD"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Data Conditioning",
                    setOf("DATA", "FILTER", "NORMALIZE", "TRANSFORM"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Signal Corruption",
                    setOf("SIGNAL", "NOISE", "DISTORT", "ALIAS"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Decision Refinement",
                    setOf("QUESTION", "ANALYZE", "REFINE", "DECIDE"),
                    CategoryColor.PURPLE
                )
            ),
            "Very Hard"
        ),

        ConnectionPuzzle(
            336,
            listOf(
                "STATE", "PHASE", "TRANSITION", "REGIME",
                "MODEL", "EDGECASE", "BOUNDARY", "FAILURE",
                "PLAN", "REDUNDANCY", "FAILOVER", "RECOVER",
                "OBSERVE", "DIAGNOSE", "INTERVENE", "RESTORE"
            ),
            listOf(
                ConnectionCategory(
                    "Phase Transitions",
                    setOf("STATE", "PHASE", "TRANSITION", "REGIME"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Model Fragility",
                    setOf("MODEL", "EDGECASE", "BOUNDARY", "FAILURE"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Fault Tolerance",
                    setOf("PLAN", "REDUNDANCY", "FAILOVER", "RECOVER"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "System Recovery",
                    setOf("OBSERVE", "DIAGNOSE", "INTERVENE", "RESTORE"),
                    CategoryColor.PURPLE
                )
            ),
            "Very Hard"
        ),

        ConnectionPuzzle(
            337,
            listOf(
                "FRAME", "NARRATIVE", "CONTEXT", "SPIN",
                "VALUE", "COST", "TRADEOFF", "SACRIFICE",
                "INPUT", "WEIGHT", "SCORE", "RANK",
                "QUESTION", "SYNTHESIZE", "INTEGRATE", "CONCLUDE"
            ),
            listOf(
                ConnectionCategory(
                    "Narrative Framing",
                    setOf("FRAME", "NARRATIVE", "CONTEXT", "SPIN"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Economic Tradeoffs",
                    setOf("VALUE", "COST", "TRADEOFF", "SACRIFICE"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Ranking Algorithms",
                    setOf("INPUT", "WEIGHT", "SCORE", "RANK"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Integrative Reasoning",
                    setOf("QUESTION", "SYNTHESIZE", "INTEGRATE", "CONCLUDE"),
                    CategoryColor.PURPLE
                )
            ),
            "Very Hard"
        ),

        ConnectionPuzzle(
            338,
            listOf(
                "UNCERTAINTY", "VARIANCE", "VOLATILITY", "TURBULENCE",
                "PLAN", "OPTION", "FLEX", "PIVOT",
                "SIGNAL", "DELAY", "OVERSHOOT", "OSCILLATION",
                "OBSERVE", "LEARN", "UPDATE", "REPEAT"
            ),
            listOf(
                ConnectionCategory(
                    "Unstable Environments",
                    setOf("UNCERTAINTY", "VARIANCE", "VOLATILITY", "TURBULENCE"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Strategic Optionality",
                    setOf("PLAN", "OPTION", "FLEX", "PIVOT"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Control Oscillation",
                    setOf("SIGNAL", "DELAY", "OVERSHOOT", "OSCILLATION"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Learning Loop",
                    setOf("OBSERVE", "LEARN", "UPDATE", "REPEAT"),
                    CategoryColor.PURPLE
                )
            ),
            "Very Hard"
        ),

        ConnectionPuzzle(
            339,
            listOf(
                "MODEL", "GENERALIZE", "TRANSFER", "OVERFIT",
                "GOAL", "METRIC", "TARGET", "GAMING",
                "SIGNAL", "NOISE", "FILTER", "CLARITY",
                "QUESTION", "ABSTRACT", "TEST", "REFINE"
            ),
            listOf(
                ConnectionCategory(
                    "Generalization Errors",
                    setOf("MODEL", "GENERALIZE", "TRANSFER", "OVERFIT"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Metric Manipulation",
                    setOf("GOAL", "METRIC", "TARGET", "GAMING"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Signal Cleaning",
                    setOf("SIGNAL", "NOISE", "FILTER", "CLARITY"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Concept Validation",
                    setOf("QUESTION", "ABSTRACT", "TEST", "REFINE"),
                    CategoryColor.PURPLE
                )
            ),
            "Very Hard"
        ),

        ConnectionPuzzle(
            340,
            listOf(
                "STATE", "INSTABILITY", "CRISIS", "RESET",
                "PLAN", "BUFFER", "ABSORB", "STABILIZE",
                "SIGNAL", "SHIFT", "RESPOND", "ADAPT",
                "OBSERVE", "DECIDE", "ACT", "REVIEW"
            ),
            listOf(
                ConnectionCategory(
                    "System Breakdown",
                    setOf("STATE", "INSTABILITY", "CRISIS", "RESET"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Shock Absorption",
                    setOf("PLAN", "BUFFER", "ABSORB", "STABILIZE"),
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
            "Very Hard"
        ),

        ConnectionPuzzle(
            341,
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
            "Very Hard"
        ),

        ConnectionPuzzle(
            342,
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
            "Very Hard"
        ),

        ConnectionPuzzle(
            343,
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
            "Very Hard"
        ),

        ConnectionPuzzle(
            344,
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
                    "System Restoration",
                    setOf("OBSERVE", "DIAGNOSE", "INTERVENE", "RESTORE"),
                    CategoryColor.PURPLE
                )
            ),
            "Very Hard"
        ),

        ConnectionPuzzle(
            345,
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
            "Very Hard"
        ),

        ConnectionPuzzle(
            346,
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
            "Very Hard"
        ),

        ConnectionPuzzle(
            347,
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
            "Very Hard"
        ),

        ConnectionPuzzle(
            348,
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
            "Very Hard"
        ),

        ConnectionPuzzle(
            349,
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
            "Very Hard"
        ),

        ConnectionPuzzle(
            350,
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
            "Very Hard"
        ),
        ConnectionPuzzle(
            351,
            listOf(
                "AXIOM", "ASSUMPTION", "CONSTRAINT", "BOUNDARY",
                "PLAN", "PIPELINE", "QUEUE", "EXECUTE",
                "SIGNAL", "GAIN", "ATTENUATION", "STABILITY",
                "QUESTION", "FORMALIZE", "DERIVE", "VERIFY"
            ),
            listOf(
                ConnectionCategory(
                    "Foundational Conditions",
                    setOf("AXIOM", "ASSUMPTION", "CONSTRAINT", "BOUNDARY"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Execution Flow",
                    setOf("PLAN", "PIPELINE", "QUEUE", "EXECUTE"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Signal Regulation",
                    setOf("SIGNAL", "GAIN", "ATTENUATION", "STABILITY"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Logical Validation",
                    setOf("QUESTION", "FORMALIZE", "DERIVE", "VERIFY"),
                    CategoryColor.PURPLE
                )
            ),
            "Very Hard"
        ),

        ConnectionPuzzle(
            352,
            listOf(
                "STATE", "ENTROPY", "DISORDER", "DECAY",
                "INPUT", "LATENCY", "BOTTLENECK", "SATURATION",
                "GOAL", "METRIC", "BENCHMARK", "DRIFT",
                "OBSERVE", "INTERPRET", "CORRECT", "ITERATE"
            ),
            listOf(
                ConnectionCategory(
                    "Irreversible Processes",
                    setOf("STATE", "ENTROPY", "DISORDER", "DECAY"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Capacity Limits",
                    setOf("INPUT", "LATENCY", "BOTTLENECK", "SATURATION"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Measurement Drift",
                    setOf("GOAL", "METRIC", "BENCHMARK", "DRIFT"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Correction Loop",
                    setOf("OBSERVE", "INTERPRET", "CORRECT", "ITERATE"),
                    CategoryColor.PURPLE
                )
            ),
            "Very Hard"
        ),

        ConnectionPuzzle(
            353,
            listOf(
                "MODEL", "REPRESENT", "ENCODE", "SIMPLIFY",
                "CAUSE", "INTERACTION", "FEEDBACK", "EMERGENCE",
                "PLAN", "SERIAL", "PARALLEL", "PIPELINED",
                "QUESTION", "BOUND", "ISOLATE", "SOLVE"
            ),
            listOf(
                ConnectionCategory(
                    "Representation Methods",
                    setOf("MODEL", "REPRESENT", "ENCODE", "SIMPLIFY"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Emergent Causality",
                    setOf("CAUSE", "INTERACTION", "FEEDBACK", "EMERGENCE"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Execution Structures",
                    setOf("PLAN", "SERIAL", "PARALLEL", "PIPELINED"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Problem Isolation",
                    setOf("QUESTION", "BOUND", "ISOLATE", "SOLVE"),
                    CategoryColor.PURPLE
                )
            ),
            "Very Hard"
        ),

        ConnectionPuzzle(
            354,
            listOf(
                "INCENTIVE", "REWARD", "SANCTION", "DETERRENCE",
                "SIGNAL", "THRESHOLD", "TRIGGER", "CASCADE",
                "PLAN", "HEDGE", "BUFFER", "OPTION",
                "OBSERVE", "EVALUATE", "ADJUST", "REPEAT"
            ),
            listOf(
                ConnectionCategory(
                    "Behavior Shaping",
                    setOf("INCENTIVE", "REWARD", "SANCTION", "DETERRENCE"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Escalation Dynamics",
                    setOf("SIGNAL", "THRESHOLD", "TRIGGER", "CASCADE"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Risk Protection",
                    setOf("PLAN", "HEDGE", "BUFFER", "OPTION"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Adaptive Adjustment",
                    setOf("OBSERVE", "EVALUATE", "ADJUST", "REPEAT"),
                    CategoryColor.PURPLE
                )
            ),
            "Very Hard"
        ),

        ConnectionPuzzle(
            355,
            listOf(
                "ASSUMPTION", "BIAS", "HEURISTIC", "MISJUDGMENT",
                "DATA", "FILTER", "NORMALIZE", "TRANSFORM",
                "SIGNAL", "NOISE", "DISTORT", "ALIAS",
                "QUESTION", "ANALYZE", "REFINE", "DECIDE"
            ),
            listOf(
                ConnectionCategory(
                    "Cognitive Biases",
                    setOf("ASSUMPTION", "BIAS", "HEURISTIC", "MISJUDGMENT"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Data Conditioning",
                    setOf("DATA", "FILTER", "NORMALIZE", "TRANSFORM"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Signal Corruption",
                    setOf("SIGNAL", "NOISE", "DISTORT", "ALIAS"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Decision Refinement",
                    setOf("QUESTION", "ANALYZE", "REFINE", "DECIDE"),
                    CategoryColor.PURPLE
                )
            ),
            "Very Hard"
        ),

        ConnectionPuzzle(
            356,
            listOf(
                "STATE", "PHASE", "TRANSITION", "REGIME",
                "MODEL", "EDGECASE", "BOUNDARY", "FAILURE",
                "PLAN", "REDUNDANCY", "FAILOVER", "RECOVER",
                "OBSERVE", "DIAGNOSE", "INTERVENE", "RESTORE"
            ),
            listOf(
                ConnectionCategory(
                    "Phase Transitions",
                    setOf("STATE", "PHASE", "TRANSITION", "REGIME"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Model Fragility",
                    setOf("MODEL", "EDGECASE", "BOUNDARY", "FAILURE"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Fault Tolerance",
                    setOf("PLAN", "REDUNDANCY", "FAILOVER", "RECOVER"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "System Recovery",
                    setOf("OBSERVE", "DIAGNOSE", "INTERVENE", "RESTORE"),
                    CategoryColor.PURPLE
                )
            ),
            "Very Hard"
        ),

        ConnectionPuzzle(
            357,
            listOf(
                "FRAME", "NARRATIVE", "CONTEXT", "SPIN",
                "VALUE", "COST", "TRADEOFF", "SACRIFICE",
                "INPUT", "WEIGHT", "SCORE", "RANK",
                "QUESTION", "SYNTHESIZE", "INTEGRATE", "CONCLUDE"
            ),
            listOf(
                ConnectionCategory(
                    "Narrative Framing",
                    setOf("FRAME", "NARRATIVE", "CONTEXT", "SPIN"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Economic Tradeoffs",
                    setOf("VALUE", "COST", "TRADEOFF", "SACRIFICE"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Ranking Systems",
                    setOf("INPUT", "WEIGHT", "SCORE", "RANK"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Integrative Reasoning",
                    setOf("QUESTION", "SYNTHESIZE", "INTEGRATE", "CONCLUDE"),
                    CategoryColor.PURPLE
                )
            ),
            "Very Hard"
        ),

        ConnectionPuzzle(
            358,
            listOf(
                "UNCERTAINTY", "VARIANCE", "VOLATILITY", "TURBULENCE",
                "PLAN", "OPTION", "FLEX", "PIVOT",
                "SIGNAL", "DELAY", "OVERSHOOT", "OSCILLATION",
                "OBSERVE", "LEARN", "UPDATE", "REPEAT"
            ),
            listOf(
                ConnectionCategory(
                    "Unstable Conditions",
                    setOf("UNCERTAINTY", "VARIANCE", "VOLATILITY", "TURBULENCE"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Strategic Optionality",
                    setOf("PLAN", "OPTION", "FLEX", "PIVOT"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Control Oscillation",
                    setOf("SIGNAL", "DELAY", "OVERSHOOT", "OSCILLATION"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Learning Loop",
                    setOf("OBSERVE", "LEARN", "UPDATE", "REPEAT"),
                    CategoryColor.PURPLE
                )
            ),
            "Very Hard"
        ),

        ConnectionPuzzle(
            359,
            listOf(
                "MODEL", "GENERALIZE", "TRANSFER", "OVERFIT",
                "GOAL", "METRIC", "TARGET", "GAMING",
                "SIGNAL", "NOISE", "FILTER", "CLARITY",
                "QUESTION", "ABSTRACT", "TEST", "REFINE"
            ),
            listOf(
                ConnectionCategory(
                    "Generalization Errors",
                    setOf("MODEL", "GENERALIZE", "TRANSFER", "OVERFIT"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Metric Manipulation",
                    setOf("GOAL", "METRIC", "TARGET", "GAMING"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Signal Cleaning",
                    setOf("SIGNAL", "NOISE", "FILTER", "CLARITY"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Concept Validation",
                    setOf("QUESTION", "ABSTRACT", "TEST", "REFINE"),
                    CategoryColor.PURPLE
                )
            ),
            "Very Hard"
        ),

        ConnectionPuzzle(
            360,
            listOf(
                "STATE", "INSTABILITY", "CRISIS", "RESET",
                "PLAN", "BUFFER", "ABSORB", "STABILIZE",
                "SIGNAL", "SHIFT", "RESPOND", "ADAPT",
                "OBSERVE", "DECIDE", "ACT", "REVIEW"
            ),
            listOf(
                ConnectionCategory(
                    "System Breakdown",
                    setOf("STATE", "INSTABILITY", "CRISIS", "RESET"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Shock Absorption",
                    setOf("PLAN", "BUFFER", "ABSORB", "STABILIZE"),
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
            "Very Hard"
        ),
        ConnectionPuzzle(
            361,
            listOf(
                "AXIOM", "POSTULATE", "ASSUMPTION", "HYPOTHESIS",
                "PLAN", "PIPELINE", "QUEUE", "DISPATCH",
                "SIGNAL", "GAIN", "ATTENUATE", "STABILIZE",
                "QUESTION", "FORMALIZE", "TEST", "VERIFY"
            ),
            listOf(
                ConnectionCategory(
                    "Foundational Reasoning",
                    setOf("AXIOM", "POSTULATE", "ASSUMPTION", "HYPOTHESIS"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Work Scheduling",
                    setOf("PLAN", "PIPELINE", "QUEUE", "DISPATCH"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Signal Control",
                    setOf("SIGNAL", "GAIN", "ATTENUATE", "STABILIZE"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Hypothesis Validation",
                    setOf("QUESTION", "FORMALIZE", "TEST", "VERIFY"),
                    CategoryColor.PURPLE
                )
            ),
            "Very Hard"
        ),

        ConnectionPuzzle(
            362,
            listOf(
                "STATE", "ENTROPY", "DECAY", "IRREVERSIBILITY",
                "INPUT", "LATENCY", "BOTTLENECK", "OVERLOAD",
                "GOAL", "METRIC", "BENCHMARK", "DEGRADATION",
                "OBSERVE", "INTERPRET", "CORRECT", "ITERATE"
            ),
            listOf(
                ConnectionCategory(
                    "Irreversible Processes",
                    setOf("STATE", "ENTROPY", "DECAY", "IRREVERSIBILITY"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "System Saturation",
                    setOf("INPUT", "LATENCY", "BOTTLENECK", "OVERLOAD"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Metric Degradation",
                    setOf("GOAL", "METRIC", "BENCHMARK", "DEGRADATION"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Correction Loop",
                    setOf("OBSERVE", "INTERPRET", "CORRECT", "ITERATE"),
                    CategoryColor.PURPLE
                )
            ),
            "Very Hard"
        ),

        ConnectionPuzzle(
            363,
            listOf(
                "MODEL", "REPRESENT", "ENCODE", "ABSTRACT",
                "CAUSE", "INTERACTION", "FEEDBACK", "EMERGENCE",
                "PLAN", "SERIAL", "PARALLEL", "PIPELINED",
                "QUESTION", "BOUND", "ISOLATE", "SOLVE"
            ),
            listOf(
                ConnectionCategory(
                    "Representation Techniques",
                    setOf("MODEL", "REPRESENT", "ENCODE", "ABSTRACT"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Emergent Behavior",
                    setOf("CAUSE", "INTERACTION", "FEEDBACK", "EMERGENCE"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Execution Patterns",
                    setOf("PLAN", "SERIAL", "PARALLEL", "PIPELINED"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Problem Isolation",
                    setOf("QUESTION", "BOUND", "ISOLATE", "SOLVE"),
                    CategoryColor.PURPLE
                )
            ),
            "Very Hard"
        ),

        ConnectionPuzzle(
            364,
            listOf(
                "INCENTIVE", "REWARD", "PENALTY", "DETERRENCE",
                "SIGNAL", "THRESHOLD", "TRIGGER", "CASCADE",
                "PLAN", "HEDGE", "BUFFER", "OPTION",
                "OBSERVE", "EVALUATE", "ADJUST", "REPEAT"
            ),
            listOf(
                ConnectionCategory(
                    "Behavioral Controls",
                    setOf("INCENTIVE", "REWARD", "PENALTY", "DETERRENCE"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Escalation Mechanics",
                    setOf("SIGNAL", "THRESHOLD", "TRIGGER", "CASCADE"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Risk Protection",
                    setOf("PLAN", "HEDGE", "BUFFER", "OPTION"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Adaptive Adjustment",
                    setOf("OBSERVE", "EVALUATE", "ADJUST", "REPEAT"),
                    CategoryColor.PURPLE
                )
            ),
            "Very Hard"
        ),

        ConnectionPuzzle(
            365,
            listOf(
                "ASSUMPTION", "BIAS", "HEURISTIC", "MISREAD",
                "DATA", "FILTER", "NORMALIZE", "TRANSFORM",
                "SIGNAL", "NOISE", "DISTORT", "ALIAS",
                "QUESTION", "ANALYZE", "REFINE", "DECIDE"
            ),
            listOf(
                ConnectionCategory(
                    "Cognitive Distortions",
                    setOf("ASSUMPTION", "BIAS", "HEURISTIC", "MISREAD"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Data Conditioning",
                    setOf("DATA", "FILTER", "NORMALIZE", "TRANSFORM"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Signal Corruption",
                    setOf("SIGNAL", "NOISE", "DISTORT", "ALIAS"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Decision Refinement",
                    setOf("QUESTION", "ANALYZE", "REFINE", "DECIDE"),
                    CategoryColor.PURPLE
                )
            ),
            "Very Hard"
        ),

        ConnectionPuzzle(
            366,
            listOf(
                "STATE", "PHASE", "TRANSITION", "REGIME",
                "MODEL", "EDGECASE", "BOUNDARY", "FAILURE",
                "PLAN", "REDUNDANCY", "FAILOVER", "RECOVER",
                "OBSERVE", "DIAGNOSE", "INTERVENE", "RESTORE"
            ),
            listOf(
                ConnectionCategory(
                    "Phase Transitions",
                    setOf("STATE", "PHASE", "TRANSITION", "REGIME"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Model Fragility",
                    setOf("MODEL", "EDGECASE", "BOUNDARY", "FAILURE"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Fault Tolerance",
                    setOf("PLAN", "REDUNDANCY", "FAILOVER", "RECOVER"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "System Recovery",
                    setOf("OBSERVE", "DIAGNOSE", "INTERVENE", "RESTORE"),
                    CategoryColor.PURPLE
                )
            ),
            "Very Hard"
        ),

        ConnectionPuzzle(
            367,
            listOf(
                "FRAME", "NARRATIVE", "CONTEXT", "SPIN",
                "VALUE", "COST", "TRADEOFF", "SACRIFICE",
                "INPUT", "WEIGHT", "SCORE", "RANK",
                "QUESTION", "SYNTHESIZE", "INTEGRATE", "CONCLUDE"
            ),
            listOf(
                ConnectionCategory(
                    "Narrative Framing",
                    setOf("FRAME", "NARRATIVE", "CONTEXT", "SPIN"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Economic Tradeoffs",
                    setOf("VALUE", "COST", "TRADEOFF", "SACRIFICE"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Ranking Algorithms",
                    setOf("INPUT", "WEIGHT", "SCORE", "RANK"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Integrative Reasoning",
                    setOf("QUESTION", "SYNTHESIZE", "INTEGRATE", "CONCLUDE"),
                    CategoryColor.PURPLE
                )
            ),
            "Very Hard"
        ),

        ConnectionPuzzle(
            368,
            listOf(
                "UNCERTAINTY", "VARIANCE", "VOLATILITY", "TURBULENCE",
                "PLAN", "OPTION", "FLEX", "PIVOT",
                "SIGNAL", "DELAY", "OVERSHOOT", "OSCILLATION",
                "OBSERVE", "LEARN", "UPDATE", "REPEAT"
            ),
            listOf(
                ConnectionCategory(
                    "Unstable Conditions",
                    setOf("UNCERTAINTY", "VARIANCE", "VOLATILITY", "TURBULENCE"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Strategic Optionality",
                    setOf("PLAN", "OPTION", "FLEX", "PIVOT"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Control Oscillation",
                    setOf("SIGNAL", "DELAY", "OVERSHOOT", "OSCILLATION"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Learning Loop",
                    setOf("OBSERVE", "LEARN", "UPDATE", "REPEAT"),
                    CategoryColor.PURPLE
                )
            ),
            "Very Hard"
        ),

        ConnectionPuzzle(
            369,
            listOf(
                "MODEL", "GENERALIZE", "TRANSFER", "OVERFIT",
                "GOAL", "METRIC", "TARGET", "GAMING",
                "SIGNAL", "NOISE", "FILTER", "CLARITY",
                "QUESTION", "ABSTRACT", "TEST", "REFINE"
            ),
            listOf(
                ConnectionCategory(
                    "Generalization Errors",
                    setOf("MODEL", "GENERALIZE", "TRANSFER", "OVERFIT"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Metric Manipulation",
                    setOf("GOAL", "METRIC", "TARGET", "GAMING"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Signal Cleaning",
                    setOf("SIGNAL", "NOISE", "FILTER", "CLARITY"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Concept Validation",
                    setOf("QUESTION", "ABSTRACT", "TEST", "REFINE"),
                    CategoryColor.PURPLE
                )
            ),
            "Very Hard"
        ),

        ConnectionPuzzle(
            370,
            listOf(
                "STATE", "INSTABILITY", "CRISIS", "RESET",
                "PLAN", "BUFFER", "ABSORB", "STABILIZE",
                "SIGNAL", "SHIFT", "RESPOND", "ADAPT",
                "OBSERVE", "DECIDE", "ACT", "REVIEW"
            ),
            listOf(
                ConnectionCategory(
                    "System Breakdown",
                    setOf("STATE", "INSTABILITY", "CRISIS", "RESET"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Shock Absorption",
                    setOf("PLAN", "BUFFER", "ABSORB", "STABILIZE"),
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
            "Very Hard"
        ),

        ConnectionPuzzle(
            371,
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
            "Very Hard"
        ),

        ConnectionPuzzle(
            372,
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
            "Very Hard"
        ),

        ConnectionPuzzle(
            373,
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
            "Very Hard"
        ),

        ConnectionPuzzle(
            374,
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
            "Very Hard"
        ),

        ConnectionPuzzle(
            375,
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
            "Very Hard"
        ),

        ConnectionPuzzle(
            376,
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
            "Very Hard"
        ),

        ConnectionPuzzle(
            377,
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
            "Very Hard"
        ),

        ConnectionPuzzle(
            378,
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
            "Very Hard"
        ),

        ConnectionPuzzle(
            379,
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
            "Very Hard"
        ),

        ConnectionPuzzle(
            380,
            listOf(
                "STATE", "CHANGE", "ESCALATION", "COLLAPSE",
                "PLAN", "BUFFER", "HEDGE", "RECOVER",
                "SIGNAL", "ANOMALY", "INVESTIGATE", "RESOLVE",
                "OBSERVE", "REVIEW", "LEARN", "IMPROVE"
            ),
            listOf(
                ConnectionCategory(
                    "System Escalation",
                    setOf("STATE", "CHANGE", "ESCALATION", "COLLAPSE"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Risk Cushioning",
                    setOf("PLAN", "BUFFER", "HEDGE", "RECOVER"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Incident Resolution",
                    setOf("SIGNAL", "ANOMALY", "INVESTIGATE", "RESOLVE"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Continuous Improvement",
                    setOf("OBSERVE", "REVIEW", "LEARN", "IMPROVE"),
                    CategoryColor.PURPLE
                )
            ),
            "Very Hard"
        ),

        ConnectionPuzzle(
            381,
            listOf(
                "FRAME", "PERSPECTIVE", "ASSUMPTION", "BIAS",
                "GOAL", "PROXY", "METRIC", "ERROR",
                "SIGNAL", "NOISE", "DISTORT", "MISLEAD",
                "QUESTION", "REFRAME", "CLARIFY", "CONCLUDE"
            ),
            listOf(
                ConnectionCategory(
                    "Perspective Bias",
                    setOf("FRAME", "PERSPECTIVE", "ASSUMPTION", "BIAS"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Measurement Error",
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
            "Very Hard"
        ),

        ConnectionPuzzle(
            382,
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
            "Very Hard"
        ),

        ConnectionPuzzle(
            383,
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
            "Very Hard"
        ),

        ConnectionPuzzle(
            384,
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
            "Very Hard"
        ),

        ConnectionPuzzle(
            385,
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
            "Very Hard"
        ),

        ConnectionPuzzle(
            386,
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
            "Very Hard"
        ),

        ConnectionPuzzle(
            387,
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
            "Very Hard"
        ),

        ConnectionPuzzle(
            388,
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
            "Very Hard"
        ),

        ConnectionPuzzle(
            389,
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
            "Very Hard"
        ),

        ConnectionPuzzle(
            390,
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
            "Very Hard"
        ),

        ConnectionPuzzle(
            391,
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
            "Very Hard"
        ),

        ConnectionPuzzle(
            392,
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
            "Very Hard"
        ),

        ConnectionPuzzle(
            393,
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
            "Very Hard"
        ),

        ConnectionPuzzle(
            394,
            listOf(
                "STATE", "CHANGE", "ESCALATION", "COLLAPSE",
                "PLAN", "BUFFER", "HEDGE", "RECOVER",
                "SIGNAL", "ANOMALY", "INVESTIGATE", "RESOLVE",
                "OBSERVE", "REVIEW", "LEARN", "IMPROVE"
            ),
            listOf(
                ConnectionCategory(
                    "System Escalation",
                    setOf("STATE", "CHANGE", "ESCALATION", "COLLAPSE"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Risk Cushioning",
                    setOf("PLAN", "BUFFER", "HEDGE", "RECOVER"),
                    CategoryColor.GREEN
                ),
                ConnectionCategory(
                    "Incident Resolution",
                    setOf("SIGNAL", "ANOMALY", "INVESTIGATE", "RESOLVE"),
                    CategoryColor.BLUE
                ),
                ConnectionCategory(
                    "Continuous Improvement",
                    setOf("OBSERVE", "REVIEW", "LEARN", "IMPROVE"),
                    CategoryColor.PURPLE
                )
            ),
            "Very Hard"
        ),

        ConnectionPuzzle(
            395,
            listOf(
                "FRAME", "PERSPECTIVE", "ASSUMPTION", "BIAS",
                "GOAL", "PROXY", "METRIC", "ERROR",
                "SIGNAL", "NOISE", "DISTORT", "MISLEAD",
                "QUESTION", "REFRAME", "CLARIFY", "CONCLUDE"
            ),
            listOf(
                ConnectionCategory(
                    "Perspective Bias",
                    setOf("FRAME", "PERSPECTIVE", "ASSUMPTION", "BIAS"),
                    CategoryColor.YELLOW
                ),
                ConnectionCategory(
                    "Measurement Error",
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
            "Very Hard"
        ),

        ConnectionPuzzle(
            396,
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
            "Very Hard"
        ),

        ConnectionPuzzle(
            397,
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
            "Very Hard"
        ),

        ConnectionPuzzle(
            398,
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
            "Very Hard"
        ),

        ConnectionPuzzle(
            399,
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
            "Very Hard"
        ),

        ConnectionPuzzle(
            400,
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
            "Very Hard"
        )
    )
}
