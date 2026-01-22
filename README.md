# KotlinFLowMovieAnalytics
Stream 35,000 movie plots from a CSV file, process them CPU-intensively (tokenization, normalization, word counts), and output statistics while ensuring main thread is never blocked. Used Kotlin and Clean Architecture

## Step 1: Dataset Sanity Validation
- Ensure the CSV file can be parsed correctly by verifying headers, row count, 
  and the integrity of quoted plot text before building the streaming pipeline.
- src/main/kotlin/data/parser/DatasetSanityCheck.kt
- Validation artifacts that describe dataset structure belong to the data layer 
  and are intentionally excluded from the domain model.

## Step 2: Streaming CSV Parsing
- Parse the CSV file row-by-row without loading it fully into memory.

## Step 3: Domain Mapping
- Convert raw CSV records into clean domain Movie objects.

## Step 4: Repository Streaming Abstraction
- Expose movies as a Flow<Movie> through a repository interface.

## Step 5: CPU-Bound Text Normalization
- Tokenize, normalize, and clean plot text for analysis.

## Step 6: Word Frequency Aggregation
- Accumulate global word counts using a streaming Flow pipeline.

## Step 7: Dispatcher Isolation
- Explicitly move CPU-intensive operations to Dispatchers.Default.

## Step 8: Progress Observation
- Emit and observe progress updates without breaking streaming.

## Step 9: Result Materialization
- Collect and persist or display the final analysis result.

## Step 10: Anti-Pattern Demonstration
- Show incorrect Flow usage where CPU work blocks the main thread.

## Step 11: Corrected Pipeline Comparison
- Fix the anti-pattern by applying proper dispatcher management.

## Step 12: Test Coverage & Verification
- Validate correctness, performance assumptions, and architectural boundaries.

