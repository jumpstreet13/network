package com.otus.networking.data.widgets

import com.google.gson.annotations.Expose
import com.google.gson.annotations.JsonAdapter
import com.google.gson.annotations.SerializedName

data class WidgetContentDto(
    @SerializedName("version")
    @Expose
    val version: Int,
    @SerializedName("currentScreenName")
    @Expose
    val currentScreenName: String?,
    @SerializedName("category")
    @Expose
    val category: String?,
    @SerializedName("data")
    @JsonAdapter(WidgetDataTypeAdapter::class)
    @Expose
    val data: Map<WidgetDataType, Any>,
    @SerializedName("widgets")
    @Expose
    val prefetchData: Any?
)