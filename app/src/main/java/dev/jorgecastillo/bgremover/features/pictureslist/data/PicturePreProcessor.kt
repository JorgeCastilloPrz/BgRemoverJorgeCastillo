package dev.jorgecastillo.bgremover.features.pictureslist.data

import android.content.Context
import android.net.Uri
import kotlinx.coroutines.CoroutineDispatcher
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.MultipartBody
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
        val body = MultipartBody.Builder()
            .setType(MultipartBody.FORM)
            .addFormDataPart("image_file", "image_file", RequestBody.create(
                "application/octet".toMediaType(),
                bytes
            ))
            .addFormDataPart("format", "png")
            .addFormDataPart("channels", "rgba")
            .addFormDataPart("bg_color", "")
            .addFormDataPart("size", "full")
            .addFormDataPart("crop", "false")

        return body.build()
    }
}
