package com.demo.aboutcanada.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CanadaInfoUiModel(
    val title: String?,
    val description: String?,
    val imageHref: String?
) : Parcelable