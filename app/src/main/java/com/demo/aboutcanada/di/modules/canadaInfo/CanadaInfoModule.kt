package com.demo.aboutcanada.di.modules.canadaInfo

import com.demo.data.api.ApiService
import com.demo.data.db.CanadaInfoDao
import com.demo.data.repository.CanadaInfoRepositoryImpl
import com.demo.data.source.CanadaInfoDataSource
import com.demo.data.utils.SharedPrefsHelper
import com.demo.domain.usecase.GetCanadaInfoUseCase
import com.demo.domain.usecase.GetToolbarTitleUseCase
import dagger.Module
import dagger.Provides

@Module
open class CanadaInfoModule {
    @Provides
    fun provideCanadaInfoUseCase(
        canadaInfoRepositoryImpl: CanadaInfoRepositoryImpl
    ): GetCanadaInfoUseCase =
        GetCanadaInfoUseCase(canadaInfoRepositoryImpl)

    @Provides
    fun provideToolbarTileUseCase(
        canadaInfoRepositoryImpl: CanadaInfoRepositoryImpl
    ): GetToolbarTitleUseCase =
        GetToolbarTitleUseCase(canadaInfoRepositoryImpl)

    @Provides
    fun provideCanadaInfoDataSource(
        apiService: ApiService,
        canadaInfoDao: CanadaInfoDao,
        sharedPrefsHelper: SharedPrefsHelper
    ): CanadaInfoDataSource =
        CanadaInfoDataSource(apiService, canadaInfoDao, sharedPrefsHelper)
}