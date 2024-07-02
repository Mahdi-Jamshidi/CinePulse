package ir.jamshidi.data.tmdb.movies

import ir.jamshidi.data.model.VideoDetail

interface TmdbMovieRepository {

  suspend fun getMovieDetails(movieId: Int): VideoDetail
}
