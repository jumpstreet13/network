package ru.alfabank.mobile.android.widgetuserproducts.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.otus.networking.data.gson.UserProductsData
import com.otus.networking.data.gson.UserProductsInfoType

data class UserProductCreditDto(
    @Expose
    @SerializedName("type")
    val type: UserProductsInfoType,
    @Expose
    @SerializedName("accountNumber")
    val accountNumber: String,
    @Expose
    @SerializedName("paymentInfo")
    val paymentInfo: String,
    @Expose
    @SerializedName("creditInfo")
    val creditInfo: String
) : UserProductsData