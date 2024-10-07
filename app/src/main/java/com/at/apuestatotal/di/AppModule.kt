package com.at.apuestatotal.di

import android.app.Application
import android.content.Context
import com.at.apuestatotal.data.repository.AuthRepositoryImpl
import com.at.apuestatotal.data.repository.BetRepositoryImpl
import com.at.apuestatotal.domain.repository.AuthRepository
import com.at.apuestatotal.domain.repository.BetRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {
    @Provides
    @Singleton
    fun provideApplicationContext(application: Application): Context = application

    @Provides
    fun provideAuthRepository(impl: AuthRepositoryImpl): AuthRepository = impl

    @Provides
    fun provideBetRepository(impl: BetRepositoryImpl): BetRepository = impl
}