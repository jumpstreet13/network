package com.otus.networking.data.gson

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class UserProductCategory(
    @Expose
    @SerializedName("title")
    val title: String,
    @Expose
    @SerializedName("actions")
    val actions: List<CategoryAction>
)