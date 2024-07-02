package ir.jamshidi.data.api.tmdb

import ir.jamshidi.data.model.VideoDetail

interface TmdbMoviesRemoteSource {

  suspend fun getMovieDetails(movieId: Int): VideoDetail
}
