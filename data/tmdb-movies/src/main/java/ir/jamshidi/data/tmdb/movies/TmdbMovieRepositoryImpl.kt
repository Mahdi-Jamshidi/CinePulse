package ir.jamshidi.data.tmdb.movies

import ir.jamshidi.data.api.tmdb.TmdbMoviesRemoteSource
import ir.jamshidi.data.model.GeneralError
import ir.jamshidi.data.model.Result
import ir.jamshidi.data.model.VideoDetail
import ir.jamshidi.data.model.VideoThumbnail
import javax.inject.Inject

internal class TmdbMovieRepositoryImpl @Inject constructor(
  private val tmdbMoviesRemoteSource: TmdbMoviesRemoteSource,
) : TmdbMovieRepository {

  override suspend fun getMovieDetails(movieId: Int): Result<VideoDetail, GeneralError> =
    tmdbMoviesRemoteSource.getMovieDetails(movieId)

  override suspend fun getTrendingMovies(): List<VideoThumbnail> =
    tmdbMoviesRemoteSource.getTrendingMovies()

}
