package com.at.apuestatotal.domain.repository

import com.at.apuestatotal.domain.model.ResponseState
import com.at.apuestatotal.domain.model.login.User

interface AuthRepository {

    suspend fun loginUserViaApi(user: User): ResponseState<User>
}