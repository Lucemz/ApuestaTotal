package com.at.apuestatotal.presentation.screens.betDetail

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.at.apuestatotal.presentation.screens.login.components.LoginContent

@Composable
fun BetDetailScreen(navHostController: NavHostController) {

    Scaffold(
        topBar = {},
        content = {
            LoginContent(navHostController, it)
        },
        bottomBar = {}
    )

}