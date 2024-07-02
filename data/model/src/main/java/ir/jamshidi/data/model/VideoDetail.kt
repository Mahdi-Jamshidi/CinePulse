package ir.jamshidi.data.model

data class VideoDetail (
  val ids: VideoId,
  val title: String,
  val posterUrl: String,
  val coverUrl: String,
  val year: Int,
  val genres: List<String>,
  val originalLanguage: String?,
  val tagLine: String?,
  val spokenLanguages: List<String>,
  val description: String,
)
