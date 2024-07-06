package ir.jamshidi.data.tmdb.movies

import ir.jamshidi.data.model.GeneralError
import ir.jamshidi.data.model.Result
import ir.jamshidi.data.model.VideoDetail
import ir.jamshidi.data.model.VideoThumbnail

interface TmdbMovieRepository {

  suspend fun getMovieDetails(movieId: Int): Result<VideoDetail, GeneralError>

  suspend fun getTrendingMovies(): List<VideoThumbnail>
}
