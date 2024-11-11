package com.at.apuestatotal.data.repository

import com.at.apuestatotal.domain.model.ErrorInfo
import com.at.apuestatotal.domain.model.ResponseState
import com.at.apuestatotal.domain.model.login.User
import com.at.apuestatotal.domain.repository.AuthRepository
import com.at.apuestatotal.presentation.utils.FunctionApi
import com.google.gson.Gson
import com.google.gson.JsonObject
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(private val functionApi: FunctionApi) :
    AuthRepository {


    override suspend fun loginUserViaApi(user: User): ResponseState<User> {
        return try {
            val gson = Gson()
            val jsonString = """
    {
        "name": "TestName",
        "correo": "test@gmail.com",
        "password": "123"
    }
    """

            val response = gson.fromJson(jsonString, JsonObject::class.java)

            val user: User = functionApi.deserialize(response)

            ResponseState.Success(user)
        } catch (e: Exception) {
            ResponseState.Error(ErrorInfo(descripcion = e.message))
        }


    }
}
