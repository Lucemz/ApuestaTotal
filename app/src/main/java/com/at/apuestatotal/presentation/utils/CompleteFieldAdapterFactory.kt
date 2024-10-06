package com.at.apuestatotal.presentation.utils

import com.google.gson.Gson
import com.google.gson.TypeAdapter
import com.google.gson.TypeAdapterFactory
import com.google.gson.reflect.TypeToken
import com.google.gson.stream.JsonReader
import com.google.gson.stream.JsonWriter

class CompleteFieldAdapterFactory: TypeAdapterFactory {
    //Convierte null's y atributos faltantes que llegan desde el servicio a campos vacios o por defecto (trabaja con nulls y campos faltantes)
    //Es realizado en PostCreacion del objeto
    override fun <T : Any?> create(gson: Gson?, type: TypeToken<T>?): TypeAdapter<T>? {
        val delegate = gson!!.getDelegateAdapter(this, type)
        return object : TypeAdapter<T>() {
            override fun write(out: JsonWriter?, value: T) {
                delegate.write(out, value)
            }

            override fun read(reader: JsonReader?): T {
                val obj = delegate.read(reader)
                return if (obj != null) {
                    fillMissingFields(obj)
                } else {
                    getDefaultForType(type!!.rawType) as T
                }
            }
        }
    }

    private fun <T> fillMissingFields(obj: T): T {
        obj!!::class.java.declaredFields.forEach { field ->
            field.isAccessible = true
            if (field.get(obj) == null) {
                val defaultValue = getDefaultForType(field.type)
                if (defaultValue != null) {
                    field.set(obj, defaultValue)
                }
            }
        }
        return obj
    }

    private fun getDefaultForType(type: Class<*>): Any? {
        return when {
            type.isAssignableFrom(List::class.java) -> emptyList<Any>()
            type.isAssignableFrom(Set::class.java) -> emptySet<Any>()
            type.isAssignableFrom(Map::class.java) -> emptyMap<Any, Any>()
            type.isAssignableFrom(String::class.java) -> ""
            type.isAssignableFrom(Boolean::class.javaObjectType) -> false
            type.isAssignableFrom(Int::class.javaObjectType) -> 0
            type.isAssignableFrom(Long::class.javaObjectType) -> 0L
            type.isAssignableFrom(Double::class.javaObjectType) -> 0.0
            type.isAssignableFrom(Float::class.javaObjectType) -> 0f

            else -> null
        }
    }
}