package com.otus.networking.data.widgets

import com.google.gson.annotations.SerializedName
import com.otus.networking.data.dto.EnumDefault

enum class WidgetDataType(
    val serverKey: String = ""
) {

    @EnumDefault
    UNKNOWN,

    @SerializedName("name")
    NAME("name"),

    @SerializedName("iconName")
    ICON_NAME("iconName"),

    @SerializedName("title")
    TITLE("title"),

    @SerializedName("blockedForNonClients")
    IS_BLOCKED("blockedForNonClients"),

    @SerializedName("subtitle")
    SUBTITLE("subtitle"),

    @SerializedName("currencyFilter")
    CURRENCY_FILTER("currencyFilter"),

    @SerializedName("imageUrl")
    IMAGE_URL("imageUrl"),

    @SerializedName("backgroundColor")
    BACKGROUND_COLOR("backgroundColor"),

    @SerializedName("deeplink")
    DEEPLINK("deeplink"),

    @SerializedName("iconDeeplink")
    ICON_DEEPLINK("iconDeeplink"),

    @SerializedName("isCollapsable")
    IS_COLLAPSIBLE("isCollapsable"),

    @SerializedName("endpoint")
    ENDPOINT("endpoint"),

    @SerializedName("marketplaceProducts")
    MARKETPLACE_PRODUCTS("marketplaceProducts"),

    @SerializedName("style")
    STYLE("style"),

    @SerializedName("maxSize")
    INVESTMENTS_BONDS_LIMIT("maxSize"),

    @SerializedName("items")
    TRANSFERS_ITEMS("items"),

    @SerializedName("itemsType")
    ITEMS_TYPE("itemsType"),

    @SerializedName("isClickable")
    IS_CLICKABLE("isClickable"),

    @SerializedName("buttons")
    BUTTONS("buttons"),

    @SerializedName("analyticsLabel")
    ANALYTICS_LABEL("analyticsLabel"),

    @SerializedName("insets")
    INSETS("insets"),

    @SerializedName("shouldPrefetchData")
    SHOULD_PREFETCH_DATA("shouldPrefetchData");

    override fun toString() = serverKey
}