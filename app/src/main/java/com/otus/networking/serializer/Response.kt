package com.otus.networking.serializer

import com.google.gson.annotations.JsonAdapter
import com.google.gson.annotations.SerializedName

data class Response(
    @SerializedName("title")
    val title: String,
    @JsonAdapter(ServerDrivenSerializer::class)
    @SerializedName("uiComponent")
    val components: List<ServerDrivenContent>
)