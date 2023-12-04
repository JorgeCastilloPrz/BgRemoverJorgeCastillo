package dev.jorgecastillo.bgremover.features.pictureslist.data

import android.content.Context
import kotlinx.coroutines.CoroutineDispatcher
import okhttp3.MediaType
import okhttp3.RequestBody
import java.io.File
import java.nio.file.Files
import javax.inject.Inject

class PicturePreProcessor @Inject constructor(
    private var ctx: Context,
    private val dispatcher: CoroutineDispatcher
) {

    fun processPicture(path: String): RequestBody {
        val file = File(path)

        return RequestBody.create(
            MediaType.parse("application/octet"),
            Files.readAllBytes(file.toPath())
        )
    }
}