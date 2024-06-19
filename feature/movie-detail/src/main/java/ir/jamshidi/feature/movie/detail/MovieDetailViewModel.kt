package ir.jamshidi.feature.movie.detail

import androidx.lifecycle.ViewModel
import ir.jamshidi.domain.tmdb.movies.GetMovieDetailsUseCase

class MovieDetailViewModel(
  private val getMovieDetail: GetMovieDetailsUseCase
): ViewModel() {

  fun loadMovieDetails(videoId: Int) {
      getMovieDetail(videoId)
  }
}
