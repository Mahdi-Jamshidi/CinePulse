package ir.jamshidi.data.network

import retrofit2.http.GET

interface TmdbMoviesService {

  @GET("movie/{movie_id}")
  suspend fun getMovieDetails(movieId: Int): TmdbMovieDetailsResponse
}
