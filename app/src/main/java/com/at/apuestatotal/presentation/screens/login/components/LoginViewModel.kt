package com.at.apuestatotal.presentation.screens.login.components

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.at.apuestatotal.domain.model.ErrorInfo
import com.at.apuestatotal.domain.model.ResponseState
import com.at.apuestatotal.domain.model.login.User
import com.at.apuestatotal.domain.useCase.login.LoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.math.log

@HiltViewModel
class LoginViewModel @Inject constructor(private val loginUseCase: LoginUseCase) : ViewModel() {


    var loginResponseState by mutableStateOf<ResponseState<Boolean>?>(null)
    var error by mutableStateOf<ErrorInfo?>(null)

    var email by mutableStateOf("")
    var password by mutableStateOf("")

   // init {
   //     email = "test@gmail.com"
   //     password = "123"
   //     login()
   // }

    fun login() {
        viewModelScope.launch {
            val user = User("", email, password)

            loginResponseState = loginUseCase(user)
        }
    }


}