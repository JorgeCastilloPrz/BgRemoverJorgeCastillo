package dev.jorgecastillo.bgremover.features.pictureslist.domain

import android.graphics.Bitmap
import android.net.Uri

data class Picture(
    val originalUri: Uri,
    val processedBitmap: Bitmap
)
