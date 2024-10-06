package com.at.apuestatotal.presentation.utils

import com.google.gson.GsonBuilder
import com.google.gson.JsonArray
import com.google.gson.JsonObject
import com.google.gson.TypeAdapterFactory
import com.google.gson.reflect.TypeToken

class FunctionApi(typeAdapterFactory: TypeAdapterFactory) {

    val gson = GsonBuilder()
        .registerTypeAdapterFactory(typeAdapterFactory)
        .create()

    inline fun <reified T> deserialize(jsonObject: JsonObject, memberName: String): T {
        val type = object : TypeToken<T>() {}.type
        return gson.fromJson(jsonObject.get(memberName), type)
    }

    inline fun <reified T> deserialize(jsonObject: JsonObject): T {
        val type = object : TypeToken<T>() {}.type
        return gson.fromJson(jsonObject, type)
    }

    inline fun <reified T> deserialize(jsonArray: JsonArray): List<T> {
        val type = object : TypeToken<List<T>>() {}.type
        return gson.fromJson(jsonArray, type)
    }


}