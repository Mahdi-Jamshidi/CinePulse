package ir.jamshidi.feature.movie.detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.eitaa.domain.stream.GetStreamInfoUseCase
import ir.jamshidi.domain.tmdb.movies.GetMovieDetailsUseCase
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.count
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailViewModel @Inject constructor(
  savedStateHandle: SavedStateHandle,
  private val getMovieDetail: GetMovieDetailsUseCase,
  private val getStreamInfo: GetStreamInfoUseCase
): ViewModel() {

  private val movieId = savedStateHandle.get<Int>("movie_id") ?: throw IllegalStateException("tmdbMovieId is required")
  private val _state: MutableStateFlow<MovieDetailState> = MutableStateFlow(MovieDetailState())
  val state = _state.asStateFlow()

  val navigationToPlayer = MutableSharedFlow<String?>()

  init {
      loadMovieDetails(movieId)
  }

  fun loadMovieDetails(videoId: Int) = viewModelScope.launch {
    _state.value = _state.value.copy(isLoading = true)
    val result = getMovieDetail(videoId)
    _state.value = _state.value.copy(videoDetail = result, isLoading = false)
  }

  fun loadStreamInfo() = viewModelScope.launch {
    _state.update { it.copy(isStreamLoading = true) }
    getStreamInfo()
      .onEach { streamInfo ->
        _state.update { it.copy(streamInfo = streamInfo  ,isStreamLoading = false) }
        navigationToPlayer.emit(streamInfo.url)
      }.collect()
  }
}
