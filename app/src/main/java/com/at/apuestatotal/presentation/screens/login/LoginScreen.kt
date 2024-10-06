package com.at.apuestatotal.presentation.screens.login

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.at.apuestatotal.presentation.screens.login.components.LoginContent

@Composable
fun LoginScreen(navHostController: NavHostController,paddingValues: PaddingValues) {

    Scaffold(
        modifier = Modifier.padding(paddingValues),
        topBar = {},
        content = {
            LoginContent(navHostController, it)
        },
        bottomBar = {}
    )

}