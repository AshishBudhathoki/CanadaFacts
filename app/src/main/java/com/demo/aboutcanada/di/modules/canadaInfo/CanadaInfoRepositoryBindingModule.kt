package com.demo.aboutcanada.di.modules.canadaInfo

import com.demo.data.repository.CanadaInfoRepositoryImpl
import com.demo.domain.repository.CanadaInfoRepository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class CanadaInfoRepositoryBindingModule {

    @Singleton
    @Binds
    abstract fun bindCanadaInfoRepository(
        canadaInfoRepositoryImpl: CanadaInfoRepositoryImpl
    ): CanadaInfoRepository

}