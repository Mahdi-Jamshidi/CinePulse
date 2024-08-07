package ir.jamshidi.data.network

import ir.jamshidi.data.network.adapter.NetworkCallAdapterFactory
import ir.jamshidi.data.network.adapter.NetworkResponse
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TmdbMoviesService {

  @GET("movie/{movie_id}")
  suspend fun getMovieDetails(
    @Path("movie_id") movieId: Int,
    @Query("api_key") apiKey: String = BuildConfig.TMDB_API_KEY,
  ): NetworkResponse<TmdbMovieDetailsResponse, TmdbErrorResponse>

  @GET("trending/movie/{time_window}")
  suspend fun getTrendingMovies(
    @Path("time_window") timeWindow: String = "day",
    @Query("api_key") apiKey: String = BuildConfig.TMDB_API_KEY,
  ): TmdbVideoListResponse
}

suspend fun main(){
  val json = Json { ignoreUnknownKeys = true }

  val retrofit = Retrofit.Builder()
    .baseUrl("https://api.themoviedb.org/3/")
    .addConverterFactory(
      json.asConverterFactory(MediaType.get("application/json"))
    )
    .addCallAdapterFactory(NetworkCallAdapterFactory())
    .build()

  val tmdbMoviesService = retrofit.create(TmdbMoviesService::class.java)
  val result = tmdbMoviesService.getMovieDetails(550)
  println(result)
}
