package dev.jorgecastillo.bgremover.features.pictureslist

import dev.jorgecastillo.bgremover.features.pictureslist.domain.Picture

/**
 * I'd normally go for sealed interface or sealed class with exclusive states if we were dealing
 * with more complex UI state.
 */
data class PicturesListUiState(
    val pictures: List<Picture>,
    val loading: Boolean,
    val errorMessage: String?
) {
    companion object {
        val DEFAULT = PicturesListUiState(
            pictures = emptyList(),
            loading = false,
            errorMessage = null
        )
    }
}
