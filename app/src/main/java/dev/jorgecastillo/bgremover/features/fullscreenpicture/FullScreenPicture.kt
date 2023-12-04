@file:OptIn(ExperimentalMaterial3Api::class)

package dev.jorgecastillo.bgremover.features.fullscreenpicture

import android.net.Uri
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.unit.dp
import dev.jorgecastillo.bgremover.ui.Spacings
import me.saket.telephoto.zoomable.coil.ZoomableAsyncImage

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
            Text(modifier = Modifier
                .weight(1f)
                .padding(Spacings.large), text = "Pinch to zoom! 👌")
            ZoomableAsyncImage(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = Spacings.normal),
                model = pictureUri,
                contentDescription = "zoomable img"
            )
        }
    }
}
