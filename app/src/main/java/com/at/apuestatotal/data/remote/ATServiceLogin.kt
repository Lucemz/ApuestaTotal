package com.at.apuestatotal.data.remote

import com.google.gson.JsonObject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject


class ATServiceLogin @Inject constructor(private val apiService: APILogin) {


    suspend fun post(endpoint: String, objeto: Any): JsonObject {
        return withContext(Dispatchers.IO) {
            try {
                val response = apiService.post(endpoint, objeto)
                if (response.isSuccessful) {
                    response.body() ?: JsonObject()
                } else {
                    val errorBody = response.errorBody()?.string()
                    throw Exception(errorBody?.toString() ?: "Error desconocido")
                }
            } catch (e: Exception) {
                throw Exception("Error en el servicio: ${e.message}")
            }
        }
    }



    suspend fun postJson(endpoint: String, objeto: Any, header: Map<String, String>): JsonObject {
        return withContext(Dispatchers.IO) {
            try {
                val response = apiService.postJson(endpoint, objeto, header)
                if (response.isSuccessful) {
                    response.body() ?: JsonObject()
                } else {
                    val errorBody = response.errorBody()?.string()
                    throw Exception(errorBody?.toString() ?: "Error desconocido")
                }
            } catch (e: Exception) {
                throw Exception("Error en el servicio: ${e.message}")
            }
        }
    }

    suspend fun get(endpoint: String): JsonObject {
        return withContext(Dispatchers.IO) {
            try {
                val response = apiService.get(endpoint)
                if (response.isSuccessful) {
                    response.body() ?: JsonObject()
                } else {
                    val errorBody = response.errorBody()?.string()
                    throw Exception(errorBody?.toString() ?: "Error desconocido")
                }
            } catch (e: Exception) {
                throw Exception("Error en el servicio: ${e.message}")
            }
        }
    }





    suspend fun put(endpoint: String, objeto: Any): JsonObject {
        return   try {
            val response = apiService.put(endpoint, objeto)
            if (response.isSuccessful) {
                response.body() ?: JsonObject()
            } else {
                val errorBody = response.errorBody()?.string()
                throw Exception(errorBody?.toString() ?: "Error desconocido")
            }
        } catch (e: Exception) {
            throw Exception("Error en el servicio: ${e.message}")
        }
    }

    suspend fun del(endpoint: String): Response<String> {
        return withContext(Dispatchers.IO) {
            try {
                val response = apiService.del(endpoint)
                if (response.isSuccessful) {
                    Response.success(response.body() ?: "No hubo respuesta del servidor")
                } else {
                    val errorBody = response.errorBody()?.string()
                    throw Exception(errorBody?.toString() ?: "Error desconocido")
                }
            } catch (e: Exception) {
                throw Exception("Error en el servicio: ${e.message}")
            }
        }
    }
}