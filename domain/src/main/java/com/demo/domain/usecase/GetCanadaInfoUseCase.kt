package com.demo.domain.usecase

import com.demo.domain.model.CanadaInfo
import com.demo.domain.repository.CanadaInfoRepository
import javax.inject.Inject

/**
 * Use case used for retreiving a [List] of [CanadaInfo] instances from the [CanadaInfoRepository]
 */
class GetCanadaInfoUseCase @Inject constructor(
    private val canadaInfoRepository: CanadaInfoRepository
) {
    suspend operator fun invoke(forceRefresh: Boolean) =
        canadaInfoRepository.getCanadaInfo(forceRefresh)
}