package dev.jorgecastillo.bgremover.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import dev.jorgecastillo.bgremover.features.pictureslist.data.PicturePreProcessor
import kotlinx.coroutines.CoroutineDispatcher


@Module
@InstallIn(SingletonComponent::class)
object ProcessorModule {
    @Provides
    fun providePicturePreProcessor(
        @ApplicationContext context: Context,
        dispatcher: CoroutineDispatcher
    ): PicturePreProcessor {
        return PicturePreProcessor(
            context,
            dispatcher
        )
    }
}
