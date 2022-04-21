package com.otus.networking.data.widgets

import com.google.gson.Gson
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import com.google.gson.JsonSerializationContext
import com.google.gson.JsonSerializer
import java.lang.reflect.Type

class WidgetDataTypeAdapter
    : JsonDeserializer<Map<WidgetDataType, Any>>, JsonSerializer<Map<WidgetDataType, Any>> {

    private val widgetTypes = WidgetDataType.values().map { it.serverKey }
    private val gson = Gson()

    override fun deserialize(
        json: JsonElement?,
        typeOfT: Type,
        context: JsonDeserializationContext
    ): Map<WidgetDataType, Any> {
        val jsonObject = json?.asJsonObject
        removeUnknownTypes(jsonObject)
        val map = context.deserialize<Map<WidgetDataType, Any>>(jsonObject, typeOfT).toMutableMap()
        when {
            map.containsKey(WidgetDataType.INSETS) -> {
                val insets = json?.asJsonObject?.getAsJsonObject(WidgetDataType.INSETS.serverKey)
                map[WidgetDataType.INSETS] = context.deserialize<WidgetInsets>(
                    insets,
                    WidgetInsets::class.java
                )
            }
        }
        return map
    }

    private fun removeUnknownTypes(jsonObject: JsonObject?) {
        val iterator = jsonObject?.entrySet()?.iterator()
        if (iterator != null) {
            deleteUnknownTypes(iterator)
        }
    }

    private fun deleteUnknownTypes(iterator: MutableIterator<Map.Entry<String, JsonElement>>) {
        while (iterator.hasNext()) {
            val next = iterator.next()
            if (!widgetTypes.contains(next.key)) {
                iterator.remove()
            }
        }
    }

    override fun serialize(
        src: Map<WidgetDataType, Any>,
        typeOfSrc: Type?,
        context: JsonSerializationContext
    ): JsonElement {
        val map = src.toMutableMap()
        when {
            map.containsKey(WidgetDataType.INSETS) -> {
                val insets = context.serialize(map[WidgetDataType.INSETS])
                map[WidgetDataType.INSETS] = gson.fromJson(insets, HashMap::class.java)
            }
        }
        return context.serialize(map, typeOfSrc)
    }
}