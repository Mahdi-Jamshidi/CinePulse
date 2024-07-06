package ir.jamshidi.domain.tmdb.movies

import ir.jamshidi.data.model.GeneralError
import ir.jamshidi.data.model.Result
import ir.jamshidi.data.model.VideoDetail
import ir.jamshidi.data.tmdb.movies.TmdbMovieRepository
import javax.inject.Inject

internal class GetMovieDetailsUseCaseImpl @Inject constructor(
  private val tmdbMovieRepository: TmdbMovieRepository,
) : GetMovieDetailsUseCase {
  override suspend fun invoke(movieId: Int): Result<VideoDetail, GeneralError> =
    tmdbMovieRepository.getMovieDetails(movieId)
}
