package ir.jamshidi.data.network

import kotlinx.serialization.*

@Serializable
data class TmdbVideoListResponse (
  val page: Long? = null,
  val results: List<TmdbVideoResultResponse>? = null,

  @SerialName("total_pages")
  val totalPages: Long? = null,

  @SerialName("total_results")
  val totalResults: Long? = null
)

@Serializable
data class TmdbVideoResultResponse (
  @SerialName("backdrop_path")
  val backdropPath: String? = null,

  val id: Int? = null,
  val title: String? = null,

  @SerialName("original_title")
  val originalTitle: String? = null,

  val overview: String? = null,

  @SerialName("poster_path")
  val posterPath: String? = null,

  @SerialName("media_type")
  val mediaType: MediaType? = null,

  val adult: Boolean? = null,

  @SerialName("original_language")
  val originalLanguage: String? = null,

  @SerialName("genre_ids")
  val genreIDS: List<Long>? = null,

  val popularity: Double? = null,

  @SerialName("release_date")
  val releaseDate: String? = null,

  val video: Boolean? = null,

  @SerialName("vote_average")
  val voteAverage: Double? = null,

  @SerialName("vote_count")
  val voteCount: Long? = null
)

@Serializable
enum class MediaType(val value: String) {
  @SerialName("movie") Movie("movie");
}
