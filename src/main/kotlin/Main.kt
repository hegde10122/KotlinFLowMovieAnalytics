package com.flowmovieanalytics
import java.io.File

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    // Replace with your CSV path
    val csvFile = File("D:\\KotlinPatterns\\KotlinFLowMovieAnalytics\\data\\wiki_movie_plots_deduped.csv")

    if (!csvFile.exists()) {
        println("File not found: ${csvFile.absolutePath}")
        return
    }

    var totalMovies = 0

    csvFile.forEachLine { line ->
        // Skip header
        if (totalMovies == 0 && line.contains("Title,Plot")) {
            // header line, skip counting
            return@forEachLine
        }
        totalMovies++
    }

    println("Total movies in CSV: $totalMovies")
}