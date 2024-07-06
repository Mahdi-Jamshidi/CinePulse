package ir.jamshidi.domain.tmdb.movies

import ir.jamshidi.data.model.GeneralError
import ir.jamshidi.data.model.Result
import ir.jamshidi.data.model.VideoDetail
import ir.jamshidi.data.model.VideoThumbnail

interface GetMovieDetailsUseCase {
  suspend operator fun invoke(movieId: Int): Result<VideoDetail, GeneralError>
}
