package com.otus.networking.data.gson

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ProductSortRequest(
    @Expose
    @SerializedName("orders")
    val orders: List<CategoryProductsOrder>
)