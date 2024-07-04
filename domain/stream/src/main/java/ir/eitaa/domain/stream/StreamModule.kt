package ir.eitaa.domain.stream

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class StreamModule {

  @Binds
  abstract fun bindGetStreamInfoUseCase(impl: FakeGetStreamInfoUseCaseImpl): GetStreamInfoUseCase
}
