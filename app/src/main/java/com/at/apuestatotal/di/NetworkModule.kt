package com.at.apuestatotal.di

import com.at.apuestatotal.presentation.utils.CompleteFieldAdapterFactory
import com.at.apuestatotal.presentation.utils.FunctionApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.runBlocking
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
object NetworkModule {


    @Provides
    fun provideCompleteFieldAdapterFactory(): CompleteFieldAdapterFactory {
        return CompleteFieldAdapterFactory()
    }

    @Provides
    fun provideTypeAdapterFactoryComplete(completeFieldAdapterFactory: CompleteFieldAdapterFactory): FunctionApi {
        return FunctionApi(completeFieldAdapterFactory)
    }


}
