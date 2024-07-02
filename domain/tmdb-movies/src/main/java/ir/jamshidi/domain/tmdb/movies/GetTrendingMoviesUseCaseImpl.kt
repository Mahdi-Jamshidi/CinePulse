package ir.jamshidi.domain.tmdb.movies

import ir.jamshidi.data.model.VideoThumbnail
import ir.jamshidi.data.tmdb.movies.TmdbMovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

internal class GetTrendingMoviesUseCaseImpl @Inject constructor(
  private val tmdbMovieRepository: TmdbMovieRepository
): GetTrendingMoviesUseCase {

  override suspend fun invoke(): Flow<List<VideoThumbnail>> = flow {
    emit(tmdbMovieRepository.getTrendingMovies())
  }
}
