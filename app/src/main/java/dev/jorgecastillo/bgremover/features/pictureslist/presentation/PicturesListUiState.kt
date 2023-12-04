package dev.jorgecastillo.bgremover.features.pictureslist.presentation

import android.graphics.Bitmap
import android.net.Uri

/**
 * I'd normally go for sealed interface or sealed class with exclusive states if we were dealing
 * with more complex UI state.
 */
data class PicturesListUiState(
    val pictures: List<PictureUiState>,
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

data class PictureUiState(
    val originalUri: Uri,
    val processedBitmap: Bitmap
)
