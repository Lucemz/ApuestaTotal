package com.at.apuestatotal.data.repository

import com.at.apuestatotal.data.remote.ATServiceLogin
import com.at.apuestatotal.domain.model.ErrorInfo
import com.at.apuestatotal.domain.model.ResponseState
import com.at.apuestatotal.domain.model.login.LoginEvent
import com.at.apuestatotal.domain.model.login.ProviderInfoAPI
import com.at.apuestatotal.domain.model.login.User
import com.at.apuestatotal.domain.model.login.UserAPI
import com.at.apuestatotal.domain.repository.AuthRepository
import com.at.apuestatotal.presentation.utils.FunctionApi
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val atService: ATServiceLogin,
    private val functionApi: FunctionApi,
    private val atServiceLogin: ATServiceLogin
) :
    AuthRepository {


    override suspend fun loginUserViaApi(userAPI: UserAPI): ResponseState<User> {
        return try {

            val response = atServiceLogin.postJson(
                endpoint = "login", objeto = userAPI, header = mapOf(
                    "accept" to "*/*",
                    "accept-language" to "en-US,en;q=0.9",
                    "content-type" to "application/x-www-form-urlencoded;charset=UTF-8",
                    "origin" to "https://www.apuestatotal.com",
                    "priority" to "u=1, i",
                    "referer" to "https://www.apuestatotal.com/",
                    "sec-ch-ua" to "\"Google Chrome\";v=\"131\", \"Chromium\";v=\"131\", \"Not_A Brand\";v=\"24\"",
                    "sec-ch-ua-mobile" to "?1",
                    "sec-ch-ua-platform" to "\"Android\"",
                    "sec-fetch-dest" to "empty",
                    "sec-fetch-mode" to "cors",
                    "sec-fetch-site" to "same-site",
                    "user-agent" to "Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/131.0.0.0 Mobile Safari/537.36"
                )
            )

            val userReponse: LoginEvent = functionApi.deserialize(response)
            ResponseState.Success(userReponse.user)

        } catch (e: Exception) {
            ResponseState.Error(ErrorInfo(descripcion = e.message))
        }

    }

   //override suspend fun getUserData(providerInfoAPI: ProviderInfoAPI): ResponseState<UserAPI> {
   //    return try {

   //        val response = atService.post("casino/getProviderInfo", providerInfoAPI)



   //    /    ResponseState.Success()

   //    } catch (e: Exception) {
   //        ResponseState.Error(ErrorInfo(descripcion = e.message))
   //    }


   //}

}
