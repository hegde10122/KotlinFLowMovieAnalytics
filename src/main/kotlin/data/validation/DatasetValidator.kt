package com.flowmovieanalytics.data.validation

import java.nio.file.Path

/**
 * Performs a one-time structural validation of the movie plots CSV dataset.
 *
 * This validator ensures that:
 * - Required headers are present
 * - Records can be parsed without corruption
 * - Plot fields are readable and non-empty
 *
 * This step is executed before any streaming or analytical pipeline is built
 * and is intended to fail fast if the dataset is malformed. It returns
 * diagnostic metadata describing the dataset characteristics
 * This class belongs to the data layer and must not be referenced by the domain.
 */

interface DatasetValidator {

    /**
     * Executes validation against the given dataset path.
     *
     * @param datasetPath path to the dataset source
     * @return summary information produced during validation
     * @throws IllegalArgumentException if validation fails
     */
    fun validate(datasetPath: Path): SanityResult
}
