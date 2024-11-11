package com.at.apuestatotal.domain.useCase.bannerHome

import com.at.apuestatotal.domain.repository.BannerRepository
import javax.inject.Inject

class GetAllHomeTournamentBanner @Inject constructor(private val bannerRepository: BannerRepository) {

    suspend operator fun invoke() = bannerRepository.getAllHomeTournamentBanner()
}