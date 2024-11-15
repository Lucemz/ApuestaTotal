package com.at.apuestatotal.domain.repository

import com.at.apuestatotal.domain.model.ResponseState
import com.at.apuestatotal.domain.model.banner.Banner
import com.at.apuestatotal.domain.model.casino.LobbyCasino
import com.at.apuestatotal.domain.model.promotion.LobbyPromotion
import com.at.apuestatotal.domain.model.tournaments.Lobby

interface BannerRepository {

    suspend fun getAllHomeCentralBanner() : ResponseState<List<Banner>>

    suspend fun getAllHomeDeporitvasBanner() : ResponseState<List<Banner>>
    suspend fun getAllHomeCasinoBanner() : ResponseState<List<Banner>>
    suspend fun getAllHomeCasinoLiveBanner() : ResponseState<List<Banner>>

    suspend fun getImageBanner(banner: Banner)
    suspend fun getAllHomeTournamentBanner(): ResponseState<List<Lobby>>
    suspend fun getAllHomeJackpotBanner(): ResponseState<List<LobbyCasino>>
    suspend fun getAllHomePromotionsBanner(): ResponseState<List<LobbyPromotion>>
    suspend fun getAllHomePaymentMethods(): ResponseState<List<Banner>>
}