package com.otus.networking.data.gson

import com.google.gson.Gson
import com.google.gson.TypeAdapter
import com.google.gson.TypeAdapterFactory
import com.google.gson.internal.Streams
import com.google.gson.reflect.TypeToken
import com.google.gson.stream.JsonReader
import com.google.gson.stream.JsonWriter

class PrefillerRuntimeTypeAdapterFactory<T>(
    private val baseType: Class<T>,
    private val typeFieldName: String,
    private val defaultValue: T
) : TypeAdapterFactory {

    private val labelToSubtype = HashMap<String, Class<out T>>()

    fun registerSubtype(subtype: Class<out T>, label: String) {
        labelToSubtype[label] = subtype
    }

    override fun <R : Any> create(gson: Gson, type: TypeToken<R>): TypeAdapter<R>? {
        if (type.rawType != baseType) return null

        val labelToDelegate = HashMap<String?, TypeAdapter<*>>()
        val subtypeToDelegate = HashMap<Class<*>, TypeAdapter<*>>()
        labelToSubtype.forEach { (label, subtype) ->
            val delegate = gson.getDelegateAdapter(this, TypeToken.get(subtype))
            labelToDelegate[label] = delegate
            subtypeToDelegate[subtype] = delegate
        }
        return object : TypeAdapter<R>() {

            override fun read(reader: JsonReader): R {
                val jsonElement = Streams.parse(reader)
                val label = jsonElement.asJsonObject.get(typeFieldName)?.asString
                return if (!labelToDelegate.containsKey(label)) {
                    defaultValue as R
                } else {
                    val delegate = labelToDelegate[label] as TypeAdapter<R>
                    delegate.fromJsonTree(jsonElement)
                }
            }

            override fun write(writer: JsonWriter, value: R) {
                val srcType = value::class.java
                val delegate = subtypeToDelegate[srcType] as TypeAdapter<R>
                val jsonObject = delegate.toJsonTree(value).asJsonObject
                Streams.write(jsonObject, writer)
                return
            }
        }.nullSafe()
    }
}