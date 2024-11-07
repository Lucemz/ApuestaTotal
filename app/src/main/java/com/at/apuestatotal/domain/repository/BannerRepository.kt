package com.at.apuestatotal.domain.repository

import android.net.Uri
import com.at.apuestatotal.domain.model.ResponseState
import com.at.apuestatotal.domain.model.banner.Banner

interface BannerRepository {

    suspend fun getAllHomeCentralBanner() : ResponseState<List<Banner>>

    suspend fun getAllHomeDeporitvasBanner() : ResponseState<List<Banner>>
    suspend fun getAllHomeCasinoBanner() : ResponseState<List<Banner>>

    suspend fun getImageBanner(imgUrl: String): Uri?
}