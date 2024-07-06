package ir.jamshidi.data.api.tmdb

import ir.jamshidi.data.model.GeneralError
import ir.jamshidi.data.model.Result
import ir.jamshidi.data.model.VideoDetail
import ir.jamshidi.data.model.VideoThumbnail
import ir.jamshidi.data.network.TmdbMoviesService
import ir.jamshidi.data.network.adapter.NetworkResponse
import javax.inject.Inject

internal class TmdbMoviesRemoteSourceImpl @Inject constructor(
  private val tmdbMoviesService: TmdbMoviesService,
) : TmdbMoviesRemoteSource {

  override suspend fun getMovieDetails(movieId: Int): Result<VideoDetail, GeneralError> =
    when (val result = tmdbMoviesService.getMovieDetails(movieId)) {
      is NetworkResponse.Success -> {
        val videoDetailResponse = result.body
        if (videoDetailResponse == null) {
            Result.Failure(GeneralError.UnknownError(Throwable("Video detail response is null")))
        } else {
          Result.Success(videoDetailResponse.toVideoDetail())
        }
      }

      is NetworkResponse.ApiError -> {
        val responseError = result.body
        Result.Failure(GeneralError.ApiError(responseError.statusMessage, responseError.statusCode))
      }

      is NetworkResponse.NetworkError -> Result.Failure(GeneralError.NetworkError)
      is NetworkResponse.UnknownError -> Result.Failure(GeneralError.UnknownError(result.error))
    }

  override suspend fun getTrendingMovies(): List<VideoThumbnail> =
    tmdbMoviesService.getTrendingMovies().results?.map { it.toVideoThumbnail() } ?: emptyList()

}
