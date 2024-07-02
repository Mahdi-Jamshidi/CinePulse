package ir.jamshidi.domain.tmdb.movies

import ir.jamshidi.data.model.VideoThumbnail
import ir.jamshidi.data.tmdb.movies.TmdbMovieRepository
import javax.inject.Inject

internal class GetMovieDetailsUseCaseImpl @Inject constructor(
  private val tmdbMovieRepository: TmdbMovieRepository,
) : GetMovieDetailsUseCase {
  override suspend fun invoke(movieId: Int): VideoThumbnail =
    tmdbMovieRepository.getMovieDetails(movieId)
}
