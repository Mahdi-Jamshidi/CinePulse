package ir.eitaa.feature.home

import ir.jamshidi.data.model.VideoThumbnail

data class HomeUiState(
  val isLoading: Boolean,
  val items: List<VideoThumbnail> = emptyList()
)
