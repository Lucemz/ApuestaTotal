package com.at.apuestatotal.di

import com.at.apuestatotal.core.DynamicBaseUrlInterceptor
import com.at.apuestatotal.core.RetrofitClient
import com.at.apuestatotal.data.remote.APILogin
import com.at.apuestatotal.data.remote.APIService
import com.at.apuestatotal.presentation.utils.CompleteFieldAdapterFactory
import com.at.apuestatotal.presentation.utils.FunctionApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.runBlocking
import retrofit2.Retrofit
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
object NetworkModule {


    @Provides
    @Singleton
    fun provideDynamicBaseUrlInterceptor(): DynamicBaseUrlInterceptor {
        val interceptor = DynamicBaseUrlInterceptor()
        return interceptor
    }


    @Provides
    fun provideRetrofit(interceptor: DynamicBaseUrlInterceptor): Retrofit {
        return RetrofitClient.createRetrofit(interceptor)
    }

    @Provides
    fun provideApiService(retrofit: Retrofit): APIService {
        return retrofit.create(APIService::class.java)
    }
    @Provides
    fun provideApiServiceLogin(retrofit: Retrofit): APILogin {
        return retrofit.create(APILogin::class.java)
    }


    @Provides
    fun provideCompleteFieldAdapterFactory(): CompleteFieldAdapterFactory {
        return CompleteFieldAdapterFactory()
    }

    @Provides
    fun provideTypeAdapterFactoryComplete(completeFieldAdapterFactory: CompleteFieldAdapterFactory): FunctionApi {
        return FunctionApi(completeFieldAdapterFactory)
    }


}
