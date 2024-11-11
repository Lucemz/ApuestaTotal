package com.at.apuestatotal.core

import android.util.Log
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException


class DynamicBaseUrlInterceptor() :
    Interceptor {
    var newBaseUrl: String? = null
    var authToken: String? = null
    var numberDrop: Int = 5

    suspend fun initialize() {



    }

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()

        newBaseUrl?.let { baseUrl ->

            val url = request.url.toString()
            val parts = url.split("/")
            val isPort = parts.filter { it.contains(":") }
            val relevantParts = if (isPort.size > 1) parts.drop(numberDrop - 1) else parts.drop(
                (numberDrop)
            )

            val newPath = relevantParts.joinToString(separator = "/")
            val newBase = baseUrl.split("/").dropLast(1).joinToString("/")
            val newUrl = "$baseUrl/$newPath"
            val newRequestBuilder = request.newBuilder().url(newUrl)

            /*Log.e("edulog", "request: ${request.url()}")
            Log.e("edulog", "urlBase:"+ baseUrl)
            Log.e("edulog", "newrUrlBase"+newBase)
            Log.e("edulog", "newPath"+ newPath)
            Log.e("edulog", "newUrl"+newUrl)*/

            authToken?.let { token ->
                newRequestBuilder.addHeader("Authorization", "Bearer $token")
            }
            Log.e("testFinalurl", newUrl.toString())
            Log.e("testFinaltoken", authToken.toString())
            request = newRequestBuilder.build()
        }

        return chain.proceed(request)
    }
}

