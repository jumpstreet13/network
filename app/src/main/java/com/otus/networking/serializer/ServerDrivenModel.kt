package com.otus.networking.serializer

import com.google.gson.annotations.Expose
import com.google.gson.annotations.JsonAdapter
import com.google.gson.annotations.SerializedName

data class ServerDrivenModel(
    @Expose
    @SerializedName("type")
    val serverDrivenType: ServerDrivenType,
    @Expose
    @SerializedName("content")
    val content: ServerDrivenContent
)

/*
{
  type: DataView // image, text, dataview
  content: {
    text: you shall not pass
    url: "fkdmfslkmds.jpeg"
  }
}
*/
