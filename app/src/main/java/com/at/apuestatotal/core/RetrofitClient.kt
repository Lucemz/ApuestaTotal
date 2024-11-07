package com.at.apuestatotal.core

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


object RetrofitClient {
    private const val BASE_URL = "https://wallet.apuestatotal.com/api/"
    //private const val BASE_URL = "http://192.168.100.6/LicenciaSFA/api/"
    //private const val BASE_URL = "http://192.168.1.2/LicenciamientoSFANew/api/"

    // http://192.168.1.230/LicenciamientoFlexMobile/ServicioLicenciamiento.svc/

    fun createRetrofit(interceptor: DynamicBaseUrlInterceptor): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(getClient(interceptor))
            .build()
    }

    private fun getClient(interceptor : DynamicBaseUrlInterceptor): OkHttpClient{
        val client = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .connectTimeout(20, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
            .writeTimeout(120, TimeUnit.SECONDS)
            .build()

        return client
    }
}