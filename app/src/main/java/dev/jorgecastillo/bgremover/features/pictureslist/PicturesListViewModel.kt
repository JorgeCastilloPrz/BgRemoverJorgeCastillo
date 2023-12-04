package dev.jorgecastillo.bgremover.features.pictureslist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PicturesListViewModel @Inject constructor(
    // private val getTransactionsUseCase: GetTransactionsUseCase
) : ViewModel() {

//    val uiState: StateFlow<PicturesListUiState> =
//        getFollowableTopics(sortBy = TopicSortField.NAME).map(
//            InterestsUiState::Interests,
//        ).stateIn(
//            scope = viewModelScope,
//            started = SharingStarted.WhileSubscribed(5_000),
//            initialValue = PicturesListUiState.DEFAULT,
//        )

    init {
        viewModelScope.launch {
//            repo.loadProcessedPictures().collect { uiState ->
//                _uiState.update { uiState }
//            }
        }
    }

    fun onPictureSelected(uri: String) {
        viewModelScope.launch {
            // inputState.emit(text)
        }
    }
}
