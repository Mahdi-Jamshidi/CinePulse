package ir.eitaa.domain.stream

import ir.jamshidi.data.model.StreamInfo
import kotlinx.coroutines.flow.Flow

interface GetStreamInfoUseCase {

  suspend operator fun invoke(): Flow<StreamInfo>
}
