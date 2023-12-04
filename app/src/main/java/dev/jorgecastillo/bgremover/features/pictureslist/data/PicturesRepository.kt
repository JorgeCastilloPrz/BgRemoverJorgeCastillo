package dev.jorgecastillo.bgremover.features.pictureslist.data

import android.graphics.BitmapFactory
import android.net.Uri
import dev.jorgecastillo.bgremover.features.pictureslist.domain.Picture
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import java.io.IOException
import javax.inject.Inject

class PicturesRepository @Inject constructor(
    private val dispatcher: CoroutineDispatcher,
    private val picturePreProcessor: PicturePreProcessor,
    private val service: PhotoRoomService,
    private val bitmapCache: BitmapCache
) {

    fun loadPictures(): Flow<List<Picture>> = bitmapCache.cachedPicturesHotFlow

    suspend fun onPictureSelected(uri: Uri) {
        withContext(dispatcher) {
            val body = picturePreProcessor.processPicture(uri)
            try {
                val response = service.sendImageToProcess(body)
                val bytes = response.bytes()
                val bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.size)
                bitmapCache.cache(originalUri = uri, processedBitmap = bitmap)
            } catch (e: IOException) {
                println(e)
            } catch (e: Exception) {
                println(e)
            }
        }
    }
}
