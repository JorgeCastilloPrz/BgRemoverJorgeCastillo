package dev.jorgecastillo.bgremover.features.pictureslist.data

import dev.jorgecastillo.bgremover.features.pictureslist.domain.Picture
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

class PicturesRepository @Inject constructor() {

    fun loadPictures(): Flow<List<Picture>> = flowOf(
        listOf(
            Picture(
                "https://photoroom.com/api/original",
                "https://photoroom.com/api/original"
            ),
            Picture(
                "https://photoroom.com/api/original",
                "https://photoroom.com/api/original"
            ),
            Picture(
                "https://photoroom.com/api/original",
                "https://photoroom.com/api/original"
            ),
            Picture(
                "https://photoroom.com/api/original",
                "https://photoroom.com/api/original"
            ),
            Picture(
                "https://photoroom.com/api/original",
                "https://photoroom.com/api/original"
            ),
            Picture(
                "https://photoroom.com/api/original",
                "https://photoroom.com/api/original"
            ),
            Picture(
                "https://photoroom.com/api/original",
                "https://photoroom.com/api/original"
            ),
            Picture(
                "https://photoroom.com/api/original",
                "https://photoroom.com/api/original"
            ),
            Picture(
                "https://photoroom.com/api/original",
                "https://photoroom.com/api/original"
            ),
            Picture(
                "https://photoroom.com/api/original",
                "https://photoroom.com/api/original"
            ),
            Picture(
                "https://photoroom.com/api/original",
                "https://photoroom.com/api/original"
            ),
            Picture(
                "https://photoroom.com/api/original",
                "https://photoroom.com/api/original"
            ),
            Picture(
                "https://photoroom.com/api/original",
                "https://photoroom.com/api/original"
            ),
            Picture(
                "https://photoroom.com/api/original",
                "https://photoroom.com/api/original"
            ),
        )
    )

    suspend fun onPictureSelected(uri: String) {
        TODO("Not yet implemented")
    }
}
