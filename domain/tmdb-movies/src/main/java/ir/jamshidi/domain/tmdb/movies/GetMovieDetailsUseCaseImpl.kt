package ir.jamshidi.domain.tmdb.movies

import ir.jamshidi.data.model.VideoThumbnail
import ir.jamshidi.data.tmdb.movies.TmdbMovieRepository

internal class GetMovieDetailsUseCaseImpl(
  private val tmdbMovieRepository: TmdbMovieRepository,
) : GetMovieDetailsUseCase {
  override suspend fun invoke(movieId: Int): VideoThumbnail =
    tmdbMovieRepository.getMovieDetails(movieId)
}
