package ir.jamshidi.data.api.tmdb

import ir.jamshidi.data.model.VideoDetail
import ir.jamshidi.data.model.VideoThumbnail

interface TmdbMoviesRemoteSource {

  suspend fun getMovieDetails(movieId: Int): VideoDetail

  suspend fun getTrendingMovies(): List<VideoThumbnail>
}
