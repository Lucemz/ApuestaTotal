package com.at.apuestatotal.data.remote

import com.google.gson.JsonObject
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Url



interface APIService {


    @POST
    suspend fun post(@Url url: String, @Body body: Any): Response<JsonObject>

    @POST
    suspend fun postJson(@Url url: String, @Body body: Any, @Header("Content-Type") content_type: String): Response<JsonObject>

    @GET
    suspend fun get(@Url url: String): Response<JsonObject>


    @PUT
    suspend fun put(@Url url: String, @Body body: Any): Response<JsonObject>

    @DELETE
    suspend fun del(@Url url: String): Response<String>

    @GET
    suspend fun downloadImage(@Url imageUrl: String): ResponseBody
}
