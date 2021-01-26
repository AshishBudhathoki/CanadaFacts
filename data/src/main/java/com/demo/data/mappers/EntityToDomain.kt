package com.demo.data.mappers

import com.demo.data.models.entity.CanadaInfoEntity
import com.demo.domain.model.CanadaInfo
import com.demo.domain.model.ToolbarTitle

/**
 * Map a [CanadaInfoEntity] instance to a [CanadaInfo] instance
 */
internal fun CanadaInfoEntity.toDomain(): CanadaInfo {
    return CanadaInfo(
        this.title,
        this.description,
        this.imageHref
    )
}
