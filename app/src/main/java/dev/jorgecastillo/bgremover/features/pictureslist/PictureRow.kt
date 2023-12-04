@file:OptIn(ExperimentalMaterial3Api::class)

package dev.jorgecastillo.bgremover.features.pictureslist

import android.graphics.Bitmap
import android.net.Uri
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import dev.jorgecastillo.bgremover.features.pictureslist.presentation.PictureUiState
import dev.jorgecastillo.bgremover.ui.Spacings
import dev.jorgecastillo.bgremover.ui.theme.BgRemoverJorgeCastilloTheme

@Composable
fun PictureRow(picture: PictureUiState) {
    Card(
        modifier = Modifier.padding(Spacings.small),
        onClick = { /*TODO*/ }
    ) {
        Column(modifier = Modifier.padding(Spacings.normal)) {
            Text(text = picture.originalUri.path!!)
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
