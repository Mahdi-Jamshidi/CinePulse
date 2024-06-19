package ir.jamshidi.data.tmdb.movies

import ir.jamshidi.data.api.tmdb.TmdbMoviesRemoteSource
import ir.jamshidi.data.model.VideoThumbnail

internal class TmdbMovieRepositoryImpl(
  private val tmdbMoviesRemoteSource: TmdbMoviesRemoteSource,
) : TmdbMovieRepository {

  override suspend fun getMovieDetails(movieId: Int): VideoThumbnail =
    tmdbMoviesRemoteSource.getMovieDetails(movieId)

}
