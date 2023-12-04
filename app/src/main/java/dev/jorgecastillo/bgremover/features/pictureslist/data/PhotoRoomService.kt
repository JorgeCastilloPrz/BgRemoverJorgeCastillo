package dev.jorgecastillo.bgremover.features.pictureslist.data

import okhttp3.RequestBody
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST


interface PhotoRoomService {
    @POST("v1/segment")
    suspend fun sendImageToProcess(
        @Body body: RequestBody,
        @Header("x-api-key") apiKey: String = "4e1cf2956b116c4015e5086ebd6b653614f4d1c0" // TODO should be moved to OkHttp interceptor,
    ): List<ProcessImageResponse>
}
