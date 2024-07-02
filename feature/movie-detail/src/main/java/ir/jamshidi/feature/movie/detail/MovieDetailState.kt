package ir.jamshidi.feature.movie.detail

import ir.jamshidi.data.model.VideoThumbnail

data class MovieDetailState(
  val isLoading: Boolean = false,
  val videoThumbnail: VideoThumbnail? = null
)
