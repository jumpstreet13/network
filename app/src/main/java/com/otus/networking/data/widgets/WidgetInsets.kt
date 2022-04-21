package com.otus.networking.data.widgets

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class WidgetInsets(
    @SerializedName("top")
    @Expose
    val top: Int,
    @SerializedName("left")
    @Expose
    val left: Int,
    @SerializedName("bottom")
    @Expose
    val bottom: Int,
    @SerializedName("right")
    @Expose
    val right: Int
)