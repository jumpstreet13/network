package ru.alfabank.mobile.android.widgetuserproducts.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.otus.networking.data.gson.UserProductsData
import com.otus.networking.data.gson.UserProductsInfoType
import java.math.BigDecimal

data class UserProductInvestDto(
    @SerializedName("type")
    @Expose
    val type: UserProductsInfoType
) : UserProductsData