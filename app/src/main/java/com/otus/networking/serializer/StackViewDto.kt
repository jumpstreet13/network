package com.otus.networking.serializer

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class StackViewDto(
    @Expose
    @SerializedName("children")
    val children: List<ServerDrivenModel>,
    @Expose
    @SerializedName("backgroundColor")
    val backgroundColor: String
) : ServerDrivenContent()