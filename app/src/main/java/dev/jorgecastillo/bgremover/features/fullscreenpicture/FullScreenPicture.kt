@file:OptIn(ExperimentalMaterial3Api::class)

package dev.jorgecastillo.bgremover.features.fullscreenpicture

import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import dev.jorgecastillo.bgremover.features.pictureslist.presentation.PictureUiState
import me.saket.telephoto.zoomable.coil.ZoomableAsyncImage
import java.io.Serializable

@Composable
fun FullScreenPicture(
    pictureUri: Uri,
    onNavigationIconClick: () -> Unit
) {
    // val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Account Limits")
                },
                navigationIcon = {
                    IconButton(onClick = onNavigationIconClick) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back button",
                        )
                    }
                },
            )
        },
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(horizontal = 16.dp, vertical = 8.dp),
        ) {
            ZoomableAsyncImage(
                modifier = Modifier.fillMaxSize().background(Color.Red),
                model = pictureUri,
                contentDescription = "zoomable img"
            )
        }
    }
}
