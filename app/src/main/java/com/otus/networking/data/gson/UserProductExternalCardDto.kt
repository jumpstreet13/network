package ru.alfabank.mobile.android.widgetuserproducts.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.otus.networking.data.gson.UserProductsData
import com.otus.networking.data.gson.UserProductsInfoType

data class UserProductExternalCardDto(
    @Expose
    @SerializedName("id")
    val cardId: String,
    @Expose
    @SerializedName("title")
    val title: String,
    @Expose
    @SerializedName("maskedNumber")
    val maskedNumber: String,
    @Expose
    @SerializedName("bankName")
    val bankName: String,
    @Expose
    @SerializedName("bankIconURL")
    val bankIconURL: String,
    @Expose
    @SerializedName("skinUrl")
    val skinUrl: String?,
    @Expose
    @SerializedName("color")
    val color: String,
    @Expose
    @SerializedName("expirationDate")
    val expirationDate: String,
    @Expose
    @SerializedName("paymentSystem")
    val paymentSystem: String,
    @Expose
    @SerializedName("countryCode")
    val countryCode: String,
    @Expose
    @SerializedName("type")
    val type: UserProductsInfoType
) : UserProductsData