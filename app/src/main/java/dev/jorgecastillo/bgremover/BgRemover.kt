package dev.jorgecastillo.bgremover

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dev.jorgecastillo.bgremover.features.fullscreenpicture.FullScreenPicture
import dev.jorgecastillo.bgremover.features.pictureslist.PicturesList
import dev.jorgecastillo.bgremover.features.pictureslist.presentation.PicturesListViewModel

private const val PICTURES_LIST_ROUTE = "picturesList"
private const val FULL_SCREEN_PICTURE_ROUTE = "fullScreenPicture"

@Composable
fun BgRemover() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = PICTURES_LIST_ROUTE) {
        composable(PICTURES_LIST_ROUTE) {
            val picturesListViewModel = hiltViewModel<PicturesListViewModel>()
            PicturesList(
                viewModel = picturesListViewModel,
                onPictureSelected = picturesListViewModel::onPictureSelected,
                onItemClick = { navController.navigate("FULL_SCREEN_PICTURE_ROUTE/{${it.originalUri}}") }
            )
        }
        composable("$FULL_SCREEN_PICTURE_ROUTE/{pictureUri}") { backStackEntry ->
            val pictureUri = backStackEntry.arguments?.getSerializable("pictureUri")!!
            FullScreenPicture(pictureUri) { navController.navigateUp() }
        }
    }
}
