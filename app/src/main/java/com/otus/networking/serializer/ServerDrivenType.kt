package com.otus.networking.serializer

import com.google.gson.annotations.SerializedName
import com.otus.networking.data.dto.EnumDefault

enum class ServerDrivenType(
    val serverKey: String = "",
    val drivenClass: Class<out ServerDrivenContent> = ServerDrivenContent::class.java
) {

    @EnumDefault
    UNKNOWN,

    @SerializedName("DataView")
    DATA_VIEW("DataView", ServerDrivenContent::class.java),

    @SerializedName("IconView")
    ICON_VIEW("IconView", ServerDrivenContent::class.java),

    @SerializedName("Button")
    BUTTON("Button", ServerDrivenContent::class.java),

    @SerializedName("Spacer")
    SPACER("Spacer", ServerDrivenContent::class.java),

    @SerializedName("Stack")
    STACK("Stack", ServerDrivenContent::class.java);

    companion object {

        fun parseServerDrivenType(type: String): ServerDrivenType {
            return values().filter { it.serverKey == type }.getOrElse(0) { UNKNOWN }
        }
    }
}