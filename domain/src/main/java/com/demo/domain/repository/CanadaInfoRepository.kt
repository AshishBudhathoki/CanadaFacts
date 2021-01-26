package com.demo.domain.repository

import com.demo.domain.model.CanadaInfo
import com.demo.domain.model.ToolbarTitle
import kotlinx.coroutines.flow.Flow

/**
 * Interface defining methods for how the data layer can pass data to and from the Domain layer.
 * This is to be implemented by the data layer, setting the requirements for the
 * operations that need to be implemented
 */
interface CanadaInfoRepository {

    suspend fun getCanadaInfo(forceRefresh: Boolean): Flow<List<CanadaInfo>>

    suspend fun getToolbarTitle(): ToolbarTitle

}
