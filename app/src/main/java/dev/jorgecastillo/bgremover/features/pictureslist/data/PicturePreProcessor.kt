package dev.jorgecastillo.bgremover.features.pictureslist.data

import android.content.Context
import android.net.Uri
import kotlinx.coroutines.CoroutineDispatcher
import okhttp3.MediaType
import okhttp3.RequestBody
import java.io.ByteArrayOutputStream
import java.io.File
import java.nio.file.Files
import javax.inject.Inject

class PicturePreProcessor @Inject constructor(
    private var ctx: Context,
    private val dispatcher: CoroutineDispatcher
) {

    fun processPicture(uri: Uri): RequestBody {
        val inputStream = ctx.contentResolver.openInputStream(uri)
        val bytes = inputStream!!.readBytes()
        inputStream.close()
        return RequestBody.create(
            MediaType.parse("application/octet"),
            bytes
        )
    }
}