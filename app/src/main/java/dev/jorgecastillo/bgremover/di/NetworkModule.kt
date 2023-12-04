package dev.jorgecastillo.bgremover.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.jorgecastillo.bgremover.features.pictureslist.data.PhotoRoomService
import retrofit2.Retrofit


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    fun providePhotoRoomService(): PhotoRoomService {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://sdk.photoroom.com/")
            .build()

        return retrofit.create(PhotoRoomService::class.java)
    }
}