package com.flowmovieanalytics.data.validation

/**
 * Represents summary statistics produced during dataset sanity validation.
 *
 * This data structure captures high-level properties of the CSV file,
 * such as total record count and plot text characteristics, and is used
 * solely for verification and diagnostics.
 *
 * It is not a domain model and must not be used in business logic.
 */

data class SanityResult(

    val totalRows: Int,
    val nonEmptyPlots: Int,
    val maxPlotLength: Int,
)
