package com.demo.data.models.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Representation for a [CanadaInfoEntity] used solely for the caching
 */
@Entity(tableName = "CanadaInfoEntity")
data class CanadaInfoEntity(
    @PrimaryKey var id: Int,
    val title: String? = null,
    val description: String? = null,
    val imageHref: String? = null
)