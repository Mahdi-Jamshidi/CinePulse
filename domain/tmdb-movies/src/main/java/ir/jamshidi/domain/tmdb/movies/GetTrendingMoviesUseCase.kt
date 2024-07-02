package ir.jamshidi.domain.tmdb.movies

import ir.jamshidi.data.model.VideoThumbnail
import kotlinx.coroutines.flow.Flow

interface GetTrendingMoviesUseCase {

  suspend operator fun invoke(): Flow<List<VideoThumbnail>>
}
