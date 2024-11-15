package com.at.apuestatotal.data.repository

import com.at.apuestatotal.data.remote.ATService
import com.at.apuestatotal.domain.model.ErrorInfo
import com.at.apuestatotal.domain.model.ResponseState
import com.at.apuestatotal.domain.model.banner.Banner
import com.at.apuestatotal.domain.model.casino.LobbyCasino
import com.at.apuestatotal.domain.model.promotion.LobbyPromotion
import com.at.apuestatotal.domain.model.tournaments.Lobby
import com.at.apuestatotal.domain.repository.BannerRepository
import com.at.apuestatotal.presentation.utils.FunctionApi
import javax.inject.Inject

class BannerRepositoryImpl @Inject constructor(
    private val atService: ATService,
    private val functionApi: FunctionApi
) :
    BannerRepository {
    override suspend fun getAllHomeCentralBanner(): ResponseState<List<Banner>> {
        return try {
            val response = atService.post(
                endpoint = "/api/contents/getBanners?company=ATP&container=HOME_CENTRAL",
                objeto = Any()
            )

            val list: List<Banner> = functionApi.deserialize(response, "banners")
            list.forEach {
                getImageBanner(banner = it)
            }
            ResponseState.Success(list)
        } catch (e: Exception) {
            return ResponseState.Error(ErrorInfo(descripcion = e.message))
        }


    }

    override suspend fun getAllHomeDeporitvasBanner(): ResponseState<List<Banner>> {
        return try {
            val response = atService.post(
                endpoint = "contents/getBanners?company=ATP&container=HOME_DEPORTIVAS",
                objeto = Any()
            )
            val list: List<Banner> = functionApi.deserialize(response, "banners")


            ResponseState.Success(list)
        } catch (e: Exception) {
            ResponseState.Error(ErrorInfo(descripcion = e.message))
        }
    }

    override suspend fun getAllHomeCasinoBanner(): ResponseState<List<Banner>> {
        return try {
            val respuesta = atService.post(
                endpoint = "contents/getBanners?company=ATP&container=HOME_CASINO",
                objeto = Any()
            )
            val list: List<Banner> = functionApi.deserialize(respuesta, "banners")

            ResponseState.Success(list)
        } catch (e: Exception) {
            ResponseState.Error(ErrorInfo(descripcion = e.message))
        }
    }

    override suspend fun getAllHomeCasinoLiveBanner(): ResponseState<List<Banner>> {
        return try {
            val respuesta = atService.post(
                endpoint = "contents/getBanners?company=ATP&container=HOME_CASINOVIVO",
                objeto = Any()
            )
            val list: List<Banner> = functionApi.deserialize(respuesta, "banners")

            ResponseState.Success(list)
        } catch (e: Exception) {
            ResponseState.Error(ErrorInfo(descripcion = e.message))
        }
    }

    override suspend fun getAllHomeTournamentBanner(): ResponseState<List<Lobby>> {
        return try {
            val respuestaMain = atService.post(
                endpoint = "https://wallet.apuestatotal.com/api/contents/getTournamentsLobby?company=ATP&lobby=MAIN",
                objeto = Any()
            )
            val respuestaCarreras = atService.post(
                endpoint = "https://wallet.apuestatotal.com/api/contents/getTournamentsLobby?company=ATP&lobby=CARRERAS",
                objeto = Any()
            )
            val listMain: List<Lobby> = functionApi.deserialize(respuestaMain, "lobby")
            val listCarrera: List<Lobby> = functionApi.deserialize(respuestaMain, "lobby")

            ResponseState.Success(listMain + listCarrera)
        } catch (e: Exception) {
            ResponseState.Error(ErrorInfo(descripcion = e.message))
        }
    }

    override suspend fun getAllHomeJackpotBanner(): ResponseState<List<LobbyCasino>> {
        return try {
            val response = atService.post(
                endpoint = "https://wallet.apuestatotal.com/api/contents/getLobby?company=ATP&lobby=CASINO_TODOS&filter={\"name\":\"\",\"providers\":\"\",\"tags\":\"JACKPOT\",\"favourites\":false}&limits={\"init\":0,\"end\":15}",
                objeto = Any()
            )
            val listResponse: List<LobbyCasino> = functionApi.deserialize(response, "lobby")

            ResponseState.Success(listResponse)
        } catch (e: Exception) {
            ResponseState.Error(ErrorInfo(descripcion = e.message))
        }
    }

    override suspend fun getAllHomePromotionsBanner(): ResponseState<List<LobbyPromotion>> {
        return try {
            val response = atService.post(
                endpoint = "https://wallet.apuestatotal.com/api/contents/getPromotionsLobby?company=ATP&lobby=MAIN",
                objeto = Any()
            )
            val listResponse: List<LobbyPromotion> = functionApi.deserialize(response, "lobby")

            ResponseState.Success(listResponse)
        } catch (e: Exception) {
            ResponseState.Error(ErrorInfo(descripcion = e.message))
        }
    }

    override suspend fun getAllHomePaymentMethods(): ResponseState<List<Banner>> {
        return try {
            val response = atService.post(
                endpoint = "https://wallet.apuestatotal.com/api/contents/getBanners?company=ATP&container=METODOSDEPAGO",
                objeto = Any()
            )
            val listResponse: List<Banner> = functionApi.deserialize(response, "banners")

            ResponseState.Success(listResponse)
        } catch (e: Exception) {
            ResponseState.Error(ErrorInfo(descripcion = e.message))
        }
    }



    override suspend fun getImageBanner(banner: Banner) {

     /*   try {
           // atService.downloadImage()
            val imagen = atService.downloadImage(banner.bannerConfig.image)
            val anibal = imagen

        }catch (e: Exception){
            Log.e("getImage", e.message.toString())
        }*/

    }

}