package ir.jamshidi.data.tmdb.movies

import ir.jamshidi.data.model.VideoDetail
import ir.jamshidi.data.model.VideoThumbnail

interface TmdbMovieRepository {

  suspend fun getMovieDetails(movieId: Int): VideoDetail

  suspend fun getTrendingMovies(): List<VideoThumbnail>
}
