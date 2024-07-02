package ir.jamshidi.data.api.tmdb

import ir.jamshidi.data.model.VideoDetail
import ir.jamshidi.data.model.VideoId
import ir.jamshidi.data.model.VideoThumbnail
import ir.jamshidi.data.network.TmdbMovieDetailsResponse
import ir.jamshidi.data.network.TmdbVideoResultResponse

private val TMDB_IMAGE_BASE_URL = "https://image.tmdb.org/t/p/original/"

fun TmdbMovieDetailsResponse.toVideoThumbnail() =
  VideoThumbnail(
    ids = VideoId(
      traktId = null,
      tmdbId = id,
    ),
    title = title ?: "",
    posterUrl = TMDB_IMAGE_BASE_URL.plus(posterPath),
    year = releaseDate?.take(4)?.toInt() ?: 0,
  )

fun TmdbMovieDetailsResponse.toVideoDetail() =
  VideoDetail(
    ids = VideoId(
      traktId = null,
      tmdbId = id,
    ),
    title = title ?: "",
    posterUrl = TMDB_IMAGE_BASE_URL.plus(posterPath),
    coverUrl = TMDB_IMAGE_BASE_URL.plus(backdropPath),
    year = releaseDate?.take(4)?.toInt() ?: 0,
    genres = genres?.map { it.name ?: "" } ?: emptyList(),
    originalLanguage = originalLanguage,
    tagLine = tagline,
    spokenLanguages = spokenLanguages?.map { it.name ?: "" }?.filter { it.isNotEmpty() } ?: emptyList(),
    description = overview ?: "",
  )

fun TmdbVideoResultResponse.toVideoThumbnail() = VideoThumbnail(
  ids = VideoId(
    traktId = null,
    tmdbId = id,
  ),
  title = title ?: "",
  posterUrl = TMDB_IMAGE_BASE_URL.plus(posterPath),
  year = releaseDate?.take(4)?.toInt() ?: 0,
)
