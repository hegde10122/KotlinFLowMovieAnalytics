package com.flowmovieanalytics.data.validation

import org.apache.commons.csv.CSVFormat
import java.nio.file.Files
import java.nio.file.Path

/**
 * CSV-based implementation of [DatasetValidator].
 *
 * This validator ensures that the movie plots CSV file:
 * - Contains required headers
 * - Can be fully parsed without corruption
 * - Contains readable plot text
 *
 * This class performs infrastructure-level validation only
 * and must be executed before any streaming pipeline is built.
 */

class CsvDatasetValidator(
    private val requiredHeaders:Set<String> = DEFAULT_REQUIRED_HEADERS
):DatasetValidator {
    override fun validate(datasetPath: Path): SanityResult {

        var totalRows = 0
        var maxPlotLength = 0
        var nonEmptyPlots = 0

        Files.newBufferedReader(datasetPath).use { reader ->

            val format = CSVFormat.DEFAULT.builder()
                .setHeader()
                .setSkipHeaderRecord(true)
                .setIgnoreHeaderCase(true)
                .setTrim(true).build()

            val parser = format.parse(reader)

            val headers = parser.headerMap.keys

            require(headers.containsAll(requiredHeaders)) {
                "Missing required headers. Found $headers"
            }

            for (record in parser){
                totalRows++

                val plot = record["Plot"]

                if(plot.isNotBlank()){
                    nonEmptyPlots++
                    maxPlotLength = maxOf(maxPlotLength,plot.length)
                }

            }
        }

        return SanityResult(totalRows,nonEmptyPlots,maxPlotLength)
    }

    companion object {
        private val DEFAULT_REQUIRED_HEADERS = setOf("Title","Genre", "Plot")
    }



}