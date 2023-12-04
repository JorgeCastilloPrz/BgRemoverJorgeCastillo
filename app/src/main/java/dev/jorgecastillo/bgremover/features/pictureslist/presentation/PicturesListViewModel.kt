package dev.jorgecastillo.bgremover.features.pictureslist.presentation

import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.jorgecastillo.bgremover.features.pictureslist.data.PicturesRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PicturesListViewModel @Inject constructor(
    private val repo: PicturesRepository
) : ViewModel() {

    val uiState: StateFlow<PicturesListUiState> =
        repo.loadPictures().map { PicturesListUiState(it.toUiStates(), false, null) }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = PicturesListUiState.DEFAULT,
        )

    fun onPictureSelected(uri: Uri) {
        viewModelScope.launch {
            repo.onPictureSelected(uri)
        }
    }
}
