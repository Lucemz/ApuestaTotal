package com.at.apuestatotal.presentation.screens.mainMenu

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.at.apuestatotal.domain.model.ResponseState
import com.at.apuestatotal.domain.model.banner.Banner
import com.at.apuestatotal.domain.model.casino.LobbyCasino
import com.at.apuestatotal.domain.model.promotion.LobbyPromotion
import com.at.apuestatotal.domain.model.tournaments.Lobby
import com.at.apuestatotal.domain.useCase.bannerHome.BannerHomeAggregate
import com.at.apuestatotal.domain.useCase.bannerHome.GetAllHomeCasinoBanner
import com.at.apuestatotal.domain.useCase.bannerHome.GetAllHomeCentralBanner
import com.at.apuestatotal.domain.useCase.bannerHome.GetAllHomeDeportivasBanner
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainMenuViewModel @Inject constructor(
    private val bannerHomeAggregate: BannerHomeAggregate
) :
    ViewModel() {
    var bannerHomeCentralIndexSelected by mutableStateOf<Banner?>(null)

    var listBannerHomeCentral by mutableStateOf<List<Banner>>(emptyList())
    var listBannerHomeSports by mutableStateOf<List<Banner>>(emptyList())
    var listBannerHomeCasino by mutableStateOf<List<Banner>>(emptyList())
    var listBannerHomeTournament by mutableStateOf<List<Lobby>>(emptyList())

    var listBannerHomeCasinoLive by mutableStateOf<List<Banner>>(emptyList())
    var listBannerHomeJackpots by mutableStateOf<List<LobbyCasino>>(emptyList())
    var listBannerHomeMission by mutableStateOf<List<Banner>>(emptyList())
    var listBannerHomePromotions by mutableStateOf<List<LobbyPromotion>>(emptyList())

    init {

        getHomeDeportivasBanner()
        getHomeCentralBanner()
        getHomeCasinoBanner()
        getHomeCasinoLiveBanner()
        getHomeTournamentBanner()
        getHomeJackpotBanner()
        getHomePromotionBanner()
    }

    fun autoChangeHomeTop() {
        var counter = 0
        viewModelScope.launch {


            while (true) {
                counter = changeMainHomeImage(counter)
                counter++
                delay(5000)

            }

        }

    }

    fun changeMainHomeImage(indexNew: Int): Int {

        val newIndex: Int? = when {
            indexNew in 0..listBannerHomeCentral.lastIndex -> indexNew
            indexNew > listBannerHomeCentral.lastIndex -> listBannerHomeCentral.firstOrNull()
                ?.let { 0 }

            indexNew < 0 -> listBannerHomeCentral.lastIndex
            else -> null
        }
        bannerHomeCentralIndexSelected = listBannerHomeCentral.getOrNull(newIndex ?: 0)
        return newIndex ?: 0

    }


    fun getHomeDeportivasBanner() {
        viewModelScope.launch {
            val listoncio = bannerHomeAggregate.getAllHomeDeportivasBanner()

            when (listoncio) {
                is ResponseState.Success -> {
                    listBannerHomeSports = listoncio.data
                }

                is ResponseState.Error -> {

                    Log.e("error", listoncio.errorInfo.toString())
                }

                else -> {

                }
            }
        }

    }

    fun getHomeCentralBanner() {
        viewModelScope.launch {
            val listoncio = bannerHomeAggregate.getAllHomeCentralBanner()

            when (listoncio) {
                is ResponseState.Success -> {
                    listBannerHomeCentral = listoncio.data
                    autoChangeHomeTop()
                }

                is ResponseState.Error -> {

                    Log.e("error", listoncio.errorInfo.toString())
                }

                else -> {

                }
            }
        }

    }

    fun getHomeCasinoBanner() {
        viewModelScope.launch {
            val listoncio = bannerHomeAggregate.getAllHomeCasinoBanner()

            when (listoncio) {
                is ResponseState.Success -> {
                    listBannerHomeCasino = listoncio.data

                }

                is ResponseState.Error -> {

                    Log.e("error", listoncio.errorInfo.toString())
                }

                else -> {

                }
            }
        }

    }
    fun getHomeCasinoLiveBanner() {
        viewModelScope.launch {
            val responseList = bannerHomeAggregate.getAllHomeCasinoLiveBanner()

            when (responseList) {
                is ResponseState.Success -> {
                    listBannerHomeCasinoLive = responseList.data

                }

                is ResponseState.Error -> {

                    Log.e("error", responseList.errorInfo.toString())
                }

                else -> {

                }
            }
        }

    }

    fun getHomeTournamentBanner() {
        viewModelScope.launch {
            val responseList = bannerHomeAggregate.getAllHomeTournamentBanner()

            when (responseList) {
                is ResponseState.Success -> {
                    listBannerHomeTournament = responseList.data

                }

                is ResponseState.Error -> {

                    Log.e("error", responseList.errorInfo.toString())
                }

                else -> {

                }
            }
        }

    }

    fun getHomeJackpotBanner() {
        viewModelScope.launch {
            val responseList = bannerHomeAggregate.getAllHomeJackpotBanner()

            when (responseList) {
                is ResponseState.Success -> {
                    listBannerHomeJackpots = responseList.data

                }

                is ResponseState.Error -> {

                    Log.e("error", responseList.errorInfo.toString())
                }

                else -> {

                }
            }
        }

    }

    fun getHomePromotionBanner() {
        viewModelScope.launch {
            val responseList = bannerHomeAggregate.getAllHomePromotionBanner()

            when (responseList) {
                is ResponseState.Success -> {
                    listBannerHomePromotions = responseList.data

                }

                is ResponseState.Error -> {

                    Log.e("error", responseList.errorInfo.toString())
                }

                else -> {

                }
            }
        }

    }

}