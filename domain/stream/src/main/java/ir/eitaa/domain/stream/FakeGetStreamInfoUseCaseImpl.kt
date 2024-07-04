package ir.eitaa.domain.stream

import ir.jamshidi.data.model.StreamInfo
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

class FakeGetStreamInfoUseCaseImpl @Inject constructor() : GetStreamInfoUseCase {

  override suspend fun invoke(): Flow<StreamInfo> = flow {
    delay(3000)
    emit(StreamInfo("https://demo.unified-streaming.com/k8s/features/stable/video/tears-of-steel/tears-of-steel.ism/.m3u8"))
  }
}
