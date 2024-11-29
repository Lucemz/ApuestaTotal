package com.at.apuestatotal.domain.useCase.login

import com.at.apuestatotal.domain.model.ErrorInfo
import com.at.apuestatotal.domain.model.ResponseState
import com.at.apuestatotal.domain.model.login.UserAPI
import com.at.apuestatotal.domain.repository.AuthRepository
import javax.inject.Inject

class LoginUseCase @Inject constructor(private val authRepository: AuthRepository) {

    suspend operator fun invoke(userAPI: UserAPI): ResponseState<Boolean> {

        if (userAPI.email.isEmpty() || userAPI.password.isEmpty()) {
            return ResponseState.Error(
                ErrorInfo(
                    titulo = "Error de Validación",
                    descripcion = "El correo o la contraseña no pueden estar vacíos"
                )
            )
        }


        if (!isValidEmail(userAPI.email)) {
            return ResponseState.Error(
                ErrorInfo(
                    titulo = "Correo Inválido",
                    descripcion = "El correo ingresado no tiene un formato válido"
                )
            )
        }

        val response = authRepository.loginUserViaApi(userAPI)

        return when (response) {
            is ResponseState.Success -> {

                if (response.data.email != userAPI.email) {
                    ResponseState.Error(
                        ErrorInfo(
                            titulo = "Usuario Incorrecto",
                            descripcion = "El email ingresado no esta asociado a ninguna cuenta"
                        )
                    )
                } else {
                   // if (response.data. == userAPI.password) {
                        ResponseState.Success(true)
                 //   } else {
                        ResponseState.Error(
                            ErrorInfo(
                                titulo = "Contraseña Incorrecta",
                                descripcion = "La contraseña ingresada es incorrecta"
                            )
                        )
                  //  }
                }


            }

            is ResponseState.Error -> {
                ResponseState.Error(
                    ErrorInfo(
                        titulo = "Error de Autenticación",
                        descripcion = response.errorInfo.descripcion ?: "Error desconocido"
                    )
                )
            }

            is ResponseState.Loading -> {
                ResponseState.Loading
            }
        }
    }

    private fun isValidEmail(email: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
}
