package com.at.apuestatotal.presentation.screens.login.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import com.at.apuestatotal.domain.model.ResponseState
import com.at.apuestatotal.presentation.components.MCErrorDialog
import com.at.apuestatotal.presentation.navigation.AppNavRoute

@Composable
fun Login(navHostController: NavHostController, loginViewModel: LoginViewModel) {


    val context = LocalContext.current
    when (
        val loco = loginViewModel.loginResponseState) {
        ResponseState.Loading -> {

        }

        is ResponseState.Success -> {


            LaunchedEffect(Unit) {
                navHostController.navigate(route = AppNavRoute.BetDetailNR.route) {
                    popUpTo(AppNavRoute.LoginNR.route) { inclusive = true }
                }

            }

        }

        is ResponseState.Error -> {

            loginViewModel.error = loco.errorInfo

            loginViewModel.loginResponseState = null


        }

        null -> {

        }
    }

    if (loginViewModel.error != null) {
        MCErrorDialog(
            onButtonAccept = { loginViewModel.error = null },
            errorInfo = loginViewModel.error!!
        )
    }

}