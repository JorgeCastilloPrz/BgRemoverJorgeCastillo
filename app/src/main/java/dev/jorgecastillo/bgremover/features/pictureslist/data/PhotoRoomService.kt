package dev.jorgecastillo.bgremover.features.pictureslist.data

import okhttp3.RequestBody
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST


interface PhotoRoomService {
    @POST("https://sdk.photoroom.com/v1/segment")
    suspend fun sendImageToProcess(@Body photo: RequestBody): List<Repo?>
}