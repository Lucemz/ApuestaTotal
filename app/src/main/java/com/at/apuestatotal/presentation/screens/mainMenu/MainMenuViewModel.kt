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
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainMenuViewModel @Inject constructor(
    private val bannerHomeAggregate: BannerHomeAggregate
) : ViewModel() {

    var bannerHomeCentralIndexSelected by mutableStateOf<Banner?>(null)

    var listBannerHomeCentral by mutableStateOf<List<Banner>>(emptyList())
    var listBannerHomeSports by mutableStateOf<List<Banner>>(emptyList())
    var listBannerHomeCasino by mutableStateOf<List<Banner>>(emptyList())
    var listBannerHomeTournament by mutableStateOf<List<Lobby>>(emptyList())
    var listBannerHomeCasinoLive by mutableStateOf<List<Banner>>(emptyList())
    var listBannerHomeJackpots by mutableStateOf<List<LobbyCasino>>(emptyList())
    var listBannerHomeMission by mutableStateOf<List<Banner>>(emptyList())
    var listBannerHomePromotions by mutableStateOf<List<LobbyPromotion>>(emptyList())

    private val listWordAt: List<String> = listOf(
        "Es juegos virtuales",
        "Es diversion",
        "Es casino en vivo",
        "Es pagos rapidos",
        "Es los reyes del ajuste",
        "Es entretenimiento",
        "Es deportes",
        "Es casino"
    )

    private val alfabeto = listOf(' ') + ('a'..'z') + ('A'..'Z') + listOf('á', 'é', 'í', 'ó', 'ú')

    private val _textoMostradoFlow = MutableStateFlow("")
    val textoMostrado: StateFlow<String> = _textoMostradoFlow.asStateFlow()

    init {
        getHomeDeportivasBanner()
        getHomeCentralBanner()
        getHomeCasinoBanner()
        getHomeCasinoLiveBanner()
        getHomeTournamentBanner()
        getHomeJackpotBanner()
        getHomePromotionBanner()
        mostrarFrasesAnimadas()
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

    private fun mostrarFrasesAnimadas() {
        viewModelScope.launch {
            val delayEscritura = 3L
            val delayBorrado = 1L
            val delayPausa = 1500L

            while (true) {
                for (palabra in listWordAt) {
                    _textoMostradoFlow.value = ""

                    // Escribir cada letra de la palabra
                    for (letra in palabra) {
                        var progresoParcial = _textoMostradoFlow.value

                        for (letraAlfabeto in alfabeto) {
                            _textoMostradoFlow.value = progresoParcial + letraAlfabeto
                            delay(delayEscritura)

                            if (letraAlfabeto == letra) {
                                _textoMostradoFlow.value = progresoParcial + letra
                                break
                            }
                        }
                    }

                    delay(delayPausa)

                    // Borrar cada letra en orden inverso desde el índice actual en el alfabeto
                    for (letra in palabra.reversed()) {
                        var progresoParcial = _textoMostradoFlow.value.dropLast(1)
                        val index = alfabeto.indexOf(letra)

                        for (i in index downTo 0) {
                            _textoMostradoFlow.value = progresoParcial + alfabeto[i]
                            delay(delayEscritura)

                            if (i == 0) {
                                _textoMostradoFlow.value = progresoParcial
                                break
                            }
                        }
                    }

                    delay(500)
                }
            }
        }
    }
    fun changeMainHomeImage(indexNew: Int): Int {
        val newIndex: Int? = when {
            indexNew in 0..listBannerHomeCentral.lastIndex -> indexNew
            indexNew > listBannerHomeCentral.lastIndex -> 0
            indexNew < 0 -> listBannerHomeCentral.lastIndex
            else -> null
        }
        bannerHomeCentralIndexSelected = listBannerHomeCentral.getOrNull(newIndex ?: 0)
        return newIndex ?: 0
    }

    private fun getHomeDeportivasBanner() {
        viewModelScope.launch {
            val response = bannerHomeAggregate.getAllHomeDeportivasBanner()
            if (response is ResponseState.Success) {
                listBannerHomeSports = response.data
            } else {
                Log.e("error", (response as ResponseState.Error).errorInfo.toString())
            }
        }
    }

    private fun getHomeCentralBanner() {
        viewModelScope.launch {
            val response = bannerHomeAggregate.getAllHomeCentralBanner()
            if (response is ResponseState.Success) {
                listBannerHomeCentral = response.data
                autoChangeHomeTop()
            } else {
                Log.e("error", (response as ResponseState.Error).errorInfo.toString())
            }
        }
    }

    private fun getHomeCasinoBanner() {
        viewModelScope.launch {
            val response = bannerHomeAggregate.getAllHomeCasinoBanner()
            if (response is ResponseState.Success) {
                listBannerHomeCasino = response.data
            } else {
                Log.e("error", (response as ResponseState.Error).errorInfo.toString())
            }
        }
    }

    private fun getHomeCasinoLiveBanner() {
        viewModelScope.launch {
            val response = bannerHomeAggregate.getAllHomeCasinoLiveBanner()
            if (response is ResponseState.Success) {
                listBannerHomeCasinoLive = response.data
            } else {
                Log.e("error", (response as ResponseState.Error).errorInfo.toString())
            }
        }
    }

    private fun getHomeTournamentBanner() {
        viewModelScope.launch {
            val response = bannerHomeAggregate.getAllHomeTournamentBanner()
            if (response is ResponseState.Success) {
                listBannerHomeTournament = response.data
            } else {
                Log.e("error", (response as ResponseState.Error).errorInfo.toString())
            }
        }
    }

    private fun getHomeJackpotBanner() {
        viewModelScope.launch {
            val response = bannerHomeAggregate.getAllHomeJackpotBanner()
            if (response is ResponseState.Success) {
                listBannerHomeJackpots = response.data
            } else {
                Log.e("error", (response as ResponseState.Error).errorInfo.toString())
            }
        }
    }

    private fun getHomePromotionBanner() {
        viewModelScope.launch {
            val response = bannerHomeAggregate.getAllHomePromotionBanner()
            if (response is ResponseState.Success) {
                listBannerHomePromotions = response.data
            } else {
                Log.e("error", (response as ResponseState.Error).errorInfo.toString())
            }
        }
    }
}