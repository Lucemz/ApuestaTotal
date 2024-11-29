package com.at.apuestatotal.domain.repository

import com.at.apuestatotal.domain.model.ResponseState
import com.at.apuestatotal.domain.model.login.User
import com.at.apuestatotal.domain.model.login.UserAPI

interface AuthRepository {

    suspend fun loginUserViaApi(userAPI: UserAPI): ResponseState<User>
}