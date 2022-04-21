package com.otus.networking.serializer

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import java.lang.reflect.Type

private const val SERVER_DRIVEN_CONTENT = "content"
private const val SERVER_DRIVEN_CHILDREN = "children"
private const val CONTENT_TYPE = "type"

class ServerDrivenSerializer : JsonDeserializer<ServerDrivenModel> {

    override fun deserialize(
        json: JsonElement,
        typeOfT: Type,
        context: JsonDeserializationContext
    ): ServerDrivenModel {
        val jsonObject = json.asJsonObject
        val serverDrivenType = ServerDrivenType.parseServerDrivenType(jsonObject.get(CONTENT_TYPE).asString)
        return when (serverDrivenType) {
            ServerDrivenType.UNKNOWN -> ServerDrivenModel(serverDrivenType, ServerDrivenContent())
            ServerDrivenType.STACK -> {
                getStackServerModel(typeOfT, context, jsonObject, serverDrivenType)
            }
            ServerDrivenType.SPACER -> ServerDrivenModel(serverDrivenType, ServerDrivenSpacerDto)
            else -> ServerDrivenModel(
                serverDrivenType,
                context.deserialize(jsonObject.get(SERVER_DRIVEN_CONTENT), serverDrivenType.drivenClass)
            )
        }
    }

    private fun getStackServerModel(
        typeOfT: Type,
        context: JsonDeserializationContext,
        jsonObject: JsonObject,
        serverDrivenType: ServerDrivenType
    ): ServerDrivenModel {
        val children = getStackServerModelChildren(typeOfT, context, jsonObject)
        val contentJsonObject = jsonObject[SERVER_DRIVEN_CONTENT]
        val serverModel = (context.deserialize(contentJsonObject, serverDrivenType.drivenClass) as StackViewDto)
            .copy(children = children)
        return ServerDrivenModel(serverDrivenType, serverModel)
    }

    private fun getStackServerModelChildren(
        typeOfT: Type,
        context: JsonDeserializationContext,
        jsonObject: JsonObject
    ): List<ServerDrivenModel> {
        return jsonObject[SERVER_DRIVEN_CONTENT]
            .asJsonObject[SERVER_DRIVEN_CHILDREN]
            .asJsonArray
            .map {
                deserialize(
                    it,
                    typeOfT,
                    context
                )
            }
    }
}