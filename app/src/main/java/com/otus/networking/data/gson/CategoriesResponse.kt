package com.otus.networking.data.gson

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.otus.networking.data.gson.UserProductCategory

data class CategoriesResponse(
    @Expose
    @SerializedName("categories")
    val categories: List<UserProductCategory>
)