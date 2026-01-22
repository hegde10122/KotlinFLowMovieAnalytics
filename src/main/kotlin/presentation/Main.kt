package com.flowmovieanalytics.presentation
import com.flowmovieanalytics.data.validation.CsvDatasetValidator
import java.nio.file.Path
import kotlin.io.path.exists

fun main() {
    // Replace with your CSV path
    val csvFile = Path.of("D:\\KotlinPatterns\\KotlinFLowMovieAnalytics\\data\\wiki_movie_plots_deduped.csv")

    if (!csvFile.exists()) {
        println("File not found: ${csvFile.root}")
        return
    }

    val validator = CsvDatasetValidator()

    val result = validator.validate(csvFile)

    println("Dataset sanity check passed:")
    println("Total rows : ${result.totalRows}")
    println("Non empty plots : ${result.nonEmptyPlots}")
    println("Max plot length : ${result.maxPlotLength}")
}

