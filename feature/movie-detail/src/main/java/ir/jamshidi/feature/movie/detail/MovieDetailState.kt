package ir.jamshidi.feature.movie.detail

import ir.jamshidi.data.model.VideoDetail

data class MovieDetailState(
  val isLoading: Boolean = false,
  val videoDetail: VideoDetail? = null
)
