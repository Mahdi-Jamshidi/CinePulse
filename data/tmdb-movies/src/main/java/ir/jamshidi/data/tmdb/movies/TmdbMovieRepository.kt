package ir.jamshidi.data.tmdb.movies

import ir.jamshidi.data.model.VideoThumbnail

interface TmdbMovieRepository {

  suspend fun getMovieDetails(movieId: Int): VideoThumbnail
}
