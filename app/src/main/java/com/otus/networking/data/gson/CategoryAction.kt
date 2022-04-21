package com.otus.networking.data.gson

import com.google.gson.annotations.SerializedName
import com.otus.networking.data.dto.EnumDefault

enum class CategoryAction {
    @SerializedName("OPEN_INVESTMENTS_ACCOUNTS")
    OPEN_INVESTMENTS_ACCOUNT,
    @EnumDefault
    UNKNOWN
}