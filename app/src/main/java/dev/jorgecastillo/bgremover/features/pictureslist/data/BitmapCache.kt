package dev.jorgecastillo.bgremover.features.pictureslist.data

import android.graphics.Bitmap
import android.net.Uri
import dev.jorgecastillo.bgremover.features.pictureslist.domain.Picture
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

class BitmapCache @Inject constructor() {

    private var cachedPictures = mutableListOf<Picture>()
    val cachedPicturesHotFlow = MutableSharedFlow<List<Picture>>()

    suspend fun cache(originalUri: Uri, processedBitmap: Bitmap) {
        cachedPictures.add(Picture(originalUri, processedBitmap))
        cachedPicturesHotFlow.emit(cachedPictures)
    }
}