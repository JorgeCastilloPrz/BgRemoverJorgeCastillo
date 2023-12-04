package dev.jorgecastillo.bgremover.features.pictureslist.presentation

import dev.jorgecastillo.bgremover.features.pictureslist.domain.Picture

fun List<Picture>.toUiStates() = map { it.toUiState() }

fun Picture.toUiState() = PictureUiState(originalUrl = originalUrl, processedUrl = processedUrl)