package ir.jamshidi.feature.movie.detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.jamshidi.domain.tmdb.movies.GetMovieDetailsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailViewModel @Inject constructor(
  private val getMovieDetail: GetMovieDetailsUseCase,
  savedStateHandle: SavedStateHandle
): ViewModel() {

  private val movieId = savedStateHandle.get<Int>("movie_id") ?: throw IllegalStateException("tmdbMovieId is required")
  private val _state: MutableStateFlow<MovieDetailState> = MutableStateFlow(MovieDetailState())
  val state = _state.asStateFlow()

  init {
      loadMovieDetails(movieId)
  }

  fun loadMovieDetails(videoId: Int) = viewModelScope.launch {
    _state.value = _state.value.copy(isLoading = true)
    val result = getMovieDetail(videoId)
    _state.value = _state.value.copy(videoDetail = result, isLoading = false)
  }
}
