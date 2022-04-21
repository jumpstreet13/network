package com.otus.networking.data.gson

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CategoryProductsOrder(
    @Expose
    @SerializedName("accounts")
    val accounts: List<String>
)