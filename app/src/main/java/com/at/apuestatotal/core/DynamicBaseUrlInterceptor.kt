package com.at.apuestatotal.core

import android.util.Log
import okhttp3.HttpUrl
import okhttp3.HttpUrl.Companion.toHttpUrlOrNull
import okhttp3.Interceptor
import okhttp3.Response
import retrofit2.Invocation
import java.io.IOException


@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
annotation class BaseUrl(val url: String)

class DynamicBaseUrlInterceptor : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()

        // Obtener la anotación `@BaseUrl` de la interfaz
        val invocation = originalRequest.tag(Invocation::class.java)
        val baseUrlAnnotation = invocation?.method()?.declaringClass?.getAnnotation(BaseUrl::class.java)

        if (baseUrlAnnotation != null) {
            val newBaseUrl = baseUrlAnnotation.url

            // Reemplazar la URL base de la solicitud original
            val originalHttpUrl = originalRequest.url
            val newHttpUrl = newBaseUrl.toHttpUrlOrNull()?.newBuilder()
                ?.encodedPath(originalHttpUrl.encodedPath)
                ?.build()

            if (newHttpUrl != null) {
                val newRequest = originalRequest.newBuilder()
                    .url(newHttpUrl)
                    .build()
                return chain.proceed(newRequest)
            }
        }

        return chain.proceed(originalRequest)
    }
}
