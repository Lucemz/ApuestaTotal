package com.at.apuestatotal.di

import android.app.Application
import android.content.Context
import com.at.apuestatotal.data.repository.AuthRepositoryImpl
import com.at.apuestatotal.data.repository.BannerRepositoryImpl
import com.at.apuestatotal.data.repository.BetRepositoryImpl
import com.at.apuestatotal.domain.repository.AuthRepository
import com.at.apuestatotal.domain.repository.BannerRepository
import com.at.apuestatotal.domain.repository.BetRepository
import com.at.apuestatotal.domain.useCase.bannerHome.BannerHomeAggregate
import com.at.apuestatotal.domain.useCase.bannerHome.GetAllHomeCasinoBanner
import com.at.apuestatotal.domain.useCase.bannerHome.GetAllHomeCasinoLiveBanner
import com.at.apuestatotal.domain.useCase.bannerHome.GetAllHomeCentralBanner
import com.at.apuestatotal.domain.useCase.bannerHome.GetAllHomeDeportivasBanner
import com.at.apuestatotal.domain.useCase.bannerHome.GetAllHomeJackpotBanner
import com.at.apuestatotal.domain.useCase.bannerHome.GetAllHomePaymentMethods
import com.at.apuestatotal.domain.useCase.bannerHome.GetAllHomePromotionBanner
import com.at.apuestatotal.domain.useCase.bannerHome.GetAllHomeTournamentBanner
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

    @Provides
    fun provideBannerRepository(impl: BannerRepositoryImpl): BannerRepository = impl


    @Provides
    fun provideHomeBannerUseCase(
        getAllHomeCentralBanner: GetAllHomeCentralBanner,
        getAllHomeDeportivasBanner: GetAllHomeDeportivasBanner,
        getAllHomeCasinoBanner: GetAllHomeCasinoBanner,
        getAllHomeCasinoLiveBanner: GetAllHomeCasinoLiveBanner,
        getAllHomeTournamentBanner: GetAllHomeTournamentBanner,
        getAllHomeJackpotBanner: GetAllHomeJackpotBanner,
        getAllHomePromotionBanner: GetAllHomePromotionBanner,
        getAllHomePaymentMethods: GetAllHomePaymentMethods
    ) = BannerHomeAggregate(
        getAllHomeCentralBanner,
        getAllHomeDeportivasBanner,
        getAllHomeCasinoBanner,
        getAllHomeCasinoLiveBanner,
        getAllHomeTournamentBanner,
        getAllHomeJackpotBanner,
        getAllHomePromotionBanner,
        getAllHomePaymentMethods
    )

}