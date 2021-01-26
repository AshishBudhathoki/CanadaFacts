package com.demo.data.repository

import com.demo.data.mappers.toDomain
import com.demo.data.source.CanadaInfoDataSource
import com.demo.domain.model.CanadaInfo
import com.demo.domain.model.ToolbarTitle
import com.demo.domain.repository.CanadaInfoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

/**
 * Bridges data from Data Layer to Domain Layer
 */
class CanadaInfoRepositoryImpl @Inject constructor(
    private val canadaInfoDataSource: CanadaInfoDataSource
) : CanadaInfoRepository {

    override suspend fun getCanadaInfo(forceRefresh: Boolean): Flow<List<CanadaInfo>> {
        return canadaInfoDataSource.query(forceRefresh).map { listCanadaInfoEntity ->
            listCanadaInfoEntity.map { canadaInfoEntity ->
                canadaInfoEntity.toDomain()
            }
        }
    }

    override suspend fun getToolbarTitle(): ToolbarTitle {
        return canadaInfoDataSource.getToolbarTitle()
    }

}