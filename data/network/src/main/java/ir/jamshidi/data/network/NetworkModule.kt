package ir.jamshidi.data.network

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ir.jamshidi.data.network.adapter.NetworkCallAdapterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import retrofit2.CallAdapter
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

  @Provides
  @Singleton
  fun providesJson(): Json {
    return Json { ignoreUnknownKeys = true }
  }

  @Provides
  @Singleton
  fun providesRetrofit(
    json: Json,
    networkCallAdapterFactory: CallAdapter.Factory,
  ): Retrofit {
    return Retrofit.Builder()
      .baseUrl("https://api.themoviedb.org/3/")
      .addConverterFactory(json.asConverterFactory(MediaType.get("application/json")))
      .addCallAdapterFactory(networkCallAdapterFactory)
      .build()
  }

  @Provides
  @Singleton
  fun providesTmdbMoviesService(retrofit: Retrofit): TmdbMoviesService {
    return retrofit.create(TmdbMoviesService::class.java)
  }

  @Provides
  @Singleton
  fun provideNetworkCallAdapterFactory(): CallAdapter.Factory {
    return NetworkCallAdapterFactory()
  }
}
