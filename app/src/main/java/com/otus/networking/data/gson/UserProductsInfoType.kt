package com.otus.networking.data.gson

import com.google.gson.annotations.SerializedName
import com.otus.networking.data.dto.EnumDefault

enum class UserProductsInfoType {
    @SerializedName("EXTERNAL_CARD")
    EXTERNAL_CARD,

    @SerializedName("CREDIT")
    CREDIT,

    @SerializedName("FIDUCIARY")
    FIDUCIARY,

    @SerializedName("BROKERAGE")
    BROKERAGE,

    @SerializedName("IIA")
    IIA,

    @SerializedName("INVESTBOX")
    INVESTBOX,

    @EnumDefault
    UNKNOWN
}