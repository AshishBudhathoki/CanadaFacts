package com.demo.domain.usecase

import com.demo.domain.repository.CanadaInfoRepository
import javax.inject.Inject

/**
 * Use case used for retreiving and loading ToolBarTitle from ApiResponse saved in Shared Preferences]
 */
class GetToolbarTitleUseCase @Inject constructor(
    private val canadaInfoRepository: CanadaInfoRepository
) {
    suspend operator fun invoke() =
        canadaInfoRepository.getToolbarTitle()

}