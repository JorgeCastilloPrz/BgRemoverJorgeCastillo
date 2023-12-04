@file:OptIn(ExperimentalMaterial3Api::class)

package dev.jorgecastillo.bgremover.features.pictureslist

import android.graphics.Bitmap
import android.net.Uri
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import dev.jorgecastillo.bgremover.features.pictureslist.presentation.PictureUiState
import dev.jorgecastillo.bgremover.ui.Spacings
import dev.jorgecastillo.bgremover.ui.theme.BgRemoverJorgeCastilloTheme

@Composable
fun PictureRow(picture: PictureUiState) {
    Card(
        modifier = Modifier.padding(Spacings.small),
        onClick = { /*TODO*/ }
    ) {
        Row(modifier = Modifier.padding(Spacings.normal)) {
            AsyncImage(
                modifier = Modifier.weight(1f).height(200.dp),
                model = picture.originalUri,
                contentScale = ContentScale.Crop,
                contentDescription = "Picture with uri: ${picture.originalUri}",
            )
            AsyncImage(
                modifier = Modifier.weight(1f).height(200.dp),
                model = picture.processedBitmap,
                contentScale = ContentScale.Crop,
                contentDescription = "Picture with uri: ${picture.originalUri}",
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PictureRowPreview() {
    BgRemoverJorgeCastilloTheme {
        PictureRow(
            picture = PictureUiState(
                originalUri = Uri.parse("https://photoroom.com/api/original"),
                processedBitmap = Bitmap.createBitmap(300, 300, Bitmap.Config.ALPHA_8)
            )
        )
    }
}
