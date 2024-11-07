package com.at.apuestatotal.data.repository

import android.net.Uri
import com.at.apuestatotal.data.remote.ATService
import com.at.apuestatotal.domain.model.ErrorInfo
import com.at.apuestatotal.domain.model.ResponseState
import com.at.apuestatotal.domain.model.banner.Banner
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
            val respuesta = atService.post(
                endpoint = "/api/contents/getBanners?company=ATP&container=HOME_CENTRAL",
                objeto = Any()
            )

            val list: List<Banner> = functionApi.deserialize(respuesta, "banners")
            ResponseState.Success(list)
        } catch (e: Exception) {
            return ResponseState.Error(ErrorInfo(descripcion = e.message))
        }


    }

    override suspend fun getAllHomeDeporitvasBanner(): ResponseState<List<Banner>> {
        return try {
            val respuesta = atService.post(
                endpoint = "contents/getBanners?company=ATP&container=HOME_DEPORTIVAS",
                objeto = Any()
            )
            val list: List<Banner> = functionApi.deserialize(respuesta, "banners")


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


    override suspend fun getImageBanner(imgUrl: String): Uri? {
        /*     return try {
                 // Descargar la imagen con Retrofit
                 val responseBody: ResponseBody = api.downloadImage(imgUrl)

                 // Guardar la imagen en caché
                 val inputStream: InputStream = responseBody.byteStream()
                 val file = File(context.cacheDir, "banner_${System.currentTimeMillis()}.jpg")
                 val outputStream = FileOutputStream(file)

                 inputStream.use { input ->
                     outputStream.use { output ->
                         input.copyTo(output)
                     }
                 }

                 // Devolver la URI del archivo de imagen guardado
                 Uri.fromFile(file)
             } catch (e: Exception) {
                 e.printStackTrace()
                 null
             }*/
        TODO()
    }

}