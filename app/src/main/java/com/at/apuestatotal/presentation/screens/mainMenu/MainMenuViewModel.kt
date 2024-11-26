package com.at.apuestatotal.presentation.screens.mainMenu

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.at.apuestatotal.R
import com.at.apuestatotal.domain.model.ResponseState
import com.at.apuestatotal.domain.model.banner.Banner
import com.at.apuestatotal.domain.model.casino.LobbyCasino
import com.at.apuestatotal.domain.model.optionNavigationDrawer.ItemOptionDrawer
import com.at.apuestatotal.domain.model.optionNavigationDrawer.OptionDrawer
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
    var listBannerFooterPaymentMethods by mutableStateOf<List<Banner>>(emptyList())
    var listBannerFooterStamps by mutableStateOf<List<String>>(emptyList())
    var listBannerFooterSponsor by mutableStateOf<List<Int>>(emptyList())
    var listOptionsNavigationDrawer by mutableStateOf<List<OptionDrawer>>(emptyList())

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
        getHomePaymentMethodsBanner()
        mostrarFrasesAnimadas()
        getHomeFooterStampsBanner()
        getHomeFooterSponsorBanner()
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
            val delayBorrado = 2L
            val delayPausa = 1500L

            while (true) {
                for (palabra in listWordAt) {
                    _textoMostradoFlow.value = ""

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

                    for (letra in palabra.reversed()) {
                        var progresoParcial = _textoMostradoFlow.value.dropLast(1)
                        val index = alfabeto.indexOf(letra)

                        for (i in index downTo 0) {
                            _textoMostradoFlow.value = progresoParcial + alfabeto[i]
                            delay(delayBorrado)

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

    private fun getHomePaymentMethodsBanner() {
        viewModelScope.launch {
            val response = bannerHomeAggregate.getAllHomePaymentMethods()
            if (response is ResponseState.Success) {
                listBannerFooterPaymentMethods = response.data
            } else {
                Log.e("error", (response as ResponseState.Error).errorInfo.toString())
            }
        }
    }

    private fun getHomeFooterStampsBanner() {
        //viewModelScope.launch {
        listBannerFooterStamps = listOf(
            "https://www.apuestatotal.com/_next/static/media/libro.fe81189f.webp",
            "https://www.apuestatotal.com/_next/static/media/certification.4e804dff.png",
            "https://5a091b68-8b84-43e4-b94f-9caaddd58204.seals-xcm.certria.com/sealassets/d9d8b19238c3e3c754b7584cd0ed6b42-www.apuestatotal.com-9a8de541d07ceeb894f60b4fa1f7810a53f0b2275ce1debf476f6839d6d2eb6fbb519c50da3e7f285be6309959144441-c2VhbC5wbmc%3D?status=valid",
            "https://www.apuestatotal.com/_next/static/media/certification-gcb.d81f4ccd.png"
        )
        //}
    }

    private fun getHomeFooterSponsorBanner() {
        //viewModelScope.launch {
        listBannerFooterSponsor = listOf(
            R.drawable.logo_alianza_lima,
            R.drawable.logo_u,
            R.drawable.logo_sport_boys,
            R.drawable.logo_cesar_vallejo,
        )
        //}
    }


    private fun getOptionsNavigationDrawer() {
        val listOptionsNavigationDrawer = listOf(
            OptionDrawer(
                "EL TIO TE TRAE",
                listOf(ItemOptionDrawer("Football Studio"), ItemOptionDrawer("Poker"))
            ),

            OptionDrawer(
                "APUESTA TOTAL",
                listOf(
                    ItemOptionDrawer("Acerca de Apuesta Total"),
                    ItemOptionDrawer("Juego responsable"),
                    ItemOptionDrawer("Políticas de privacidad"),
                    ItemOptionDrawer("Políticas de cookies"),
                    ItemOptionDrawer("¿Quieres ser un agente AT?"),
                    ItemOptionDrawer("Trabaja con nosotros")
                )
            ),
            OptionDrawer(
                "PRODUCTOS",
                listOf(
                    ItemOptionDrawer("Apuestas en vivo"),
                    ItemOptionDrawer("Apuestas deportivas"),
                    ItemOptionDrawer("Casino"),
                    ItemOptionDrawer("Casino en vivo"),
                    ItemOptionDrawer("Juegos virtuales"),
                    ItemOptionDrawer("Football Studio")
                )
            ),
            OptionDrawer(
                "EVENTOS Y PROMOCIONES",
                listOf(
                    ItemOptionDrawer("Torneos y Carreras"),
                    ItemOptionDrawer("Sorteos"),
                    ItemOptionDrawer("Resultados"),
                    ItemOptionDrawer("Promociones")
                )
            ),
            OptionDrawer(
                "ASISTENCIA Y SERVICIO AL CLIENTE",
                listOf(
                    ItemOptionDrawer("Nuestras tiendas"),
                    ItemOptionDrawer("Servicio al cliente"),
                    ItemOptionDrawer("Acerca de Teleservicios"),
                    ItemOptionDrawer("Territorios restringidos"),
                    ItemOptionDrawer("Reglamento de juego")
                )
            ),
            OptionDrawer(
                "RECURSOS Y CONTENIDO",
                listOf(
                    ItemOptionDrawer("Podcast"),
                    ItemOptionDrawer("Preguntas frecuentes"),
                    ItemOptionDrawer("Tutoriales"),
                    ItemOptionDrawer("Calendario de fútbol")
                )
            )
        )
    }

}