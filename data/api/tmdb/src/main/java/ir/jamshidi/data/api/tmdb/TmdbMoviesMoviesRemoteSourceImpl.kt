package ir.jamshidi.data.api.tmdb

import ir.jamshidi.data.model.VideoThumbnail
import ir.jamshidi.data.network.TmdbMoviesService

internal class TmdbMoviesMoviesRemoteSourceImpl(
  private val tmdbMoviesService: TmdbMoviesService
) : TmdbMoviesRemoteSource {

  override suspend fun getMovieDetails(movieId: Int): VideoThumbnail =
    tmdbMoviesService.getMovieDetails(movieId).toVideoThumbnail()
}
