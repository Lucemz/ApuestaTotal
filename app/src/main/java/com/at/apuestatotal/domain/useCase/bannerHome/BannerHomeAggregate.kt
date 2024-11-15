package com.at.apuestatotal.domain.useCase.bannerHome


data class BannerHomeAggregate(

    val getAllHomeCentralBanner: GetAllHomeCentralBanner,
    val getAllHomeDeportivasBanner: GetAllHomeDeportivasBanner,
    val getAllHomeCasinoBanner: GetAllHomeCasinoBanner,
    val getAllHomeCasinoLiveBanner: GetAllHomeCasinoLiveBanner,
    val getAllHomeTournamentBanner: GetAllHomeTournamentBanner,
    val getAllHomeJackpotBanner: GetAllHomeJackpotBanner,
    val getAllHomePromotionBanner: GetAllHomePromotionBanner,
    val getAllHomePaymentMethods: GetAllHomePaymentMethods

)
