package com.demo.data.mappers

import com.demo.data.models.entity.CanadaInfoEntity
import com.demo.data.models.response.CanadaInfoModel

/**
 * Map a [CanadaInfoModel] instance to a [CanadaInfoEntity] instance
 */
internal fun CanadaInfoModel.toEntity(primarykey: Int): CanadaInfoEntity {
    return CanadaInfoEntity(
        id = primarykey,
        this.title,
        this.description,
        this.imageHref
    )
}