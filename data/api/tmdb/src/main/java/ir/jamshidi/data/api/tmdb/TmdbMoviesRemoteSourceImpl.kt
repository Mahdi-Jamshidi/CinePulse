package ir.jamshidi.data.api.tmdb

import ir.jamshidi.data.model.VideoDetail
import ir.jamshidi.data.model.VideoThumbnail
import ir.jamshidi.data.network.TmdbMoviesService
import javax.inject.Inject

internal class TmdbMoviesRemoteSourceImpl @Inject constructor(
  private val tmdbMoviesService: TmdbMoviesService
) : TmdbMoviesRemoteSource {

  override suspend fun getMovieDetails(movieId: Int): VideoDetail =
    tmdbMoviesService.getMovieDetails(movieId).toVideoDetail()
}
