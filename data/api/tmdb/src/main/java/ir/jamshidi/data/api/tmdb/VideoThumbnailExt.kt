package ir.jamshidi.data.api.tmdb

import ir.jamshidi.data.model.VideoId
import ir.jamshidi.data.model.VideoThumbnail
import ir.jamshidi.data.network.TmdbMovieDetailsResponse

fun TmdbMovieDetailsResponse.toVideoThumbnail() =
  VideoThumbnail(
    ids = VideoId(
      traktId = null,
      tmdbId = id,
    ),
    title = title?:"",
    posterUrl = posterPath ?: "",
    year = releaseDate?.take( 4)?.toInt() ?: 0,
  )
