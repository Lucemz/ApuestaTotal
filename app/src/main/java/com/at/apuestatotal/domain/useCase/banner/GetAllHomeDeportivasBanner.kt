package com.at.apuestatotal.domain.useCase.banner

import com.at.apuestatotal.domain.model.ResponseState
import com.at.apuestatotal.domain.repository.BannerRepository
import javax.inject.Inject


class GetAllHomeDeportivasBanner @Inject constructor(private val bannerRepository: BannerRepository) {

    suspend operator fun invoke() = bannerRepository.getAllHomeDeporitvasBanner()


}