package com.demo.aboutcanada.mapper

import com.demo.aboutcanada.model.CanadaInfoUiModel
import com.demo.aboutcanada.model.ToolbarTitleUiModel
import com.demo.data.models.entity.CanadaInfoEntity
import com.demo.domain.model.CanadaInfo
import com.demo.domain.model.ToolbarTitle

/**
 * Map a [CanadaInfo] instance to a [CanadaInfoUiModel] instance
 */
fun CanadaInfo.toPresentation(): CanadaInfoUiModel {
    return CanadaInfoUiModel(
        this.title,
        this.description,
        this.imageHref
    )
}


/**
 * Map a [ToolbarTitle] instance to a [ToolbarTitleUiModel] instance
 */
fun ToolbarTitle.toPresentation(): ToolbarTitleUiModel {
    return ToolbarTitleUiModel(
        this.toolbarTitle
    )
}