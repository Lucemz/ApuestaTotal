package com.at.apuestatotal.presentation.screens.login.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.at.apuestatotal.presentation.screens.login.LoginScreen

@Composable
fun LoginContent(navHostController: NavHostController, paddingValues: PaddingValues) {

    Column {
        Text("hlas")

    }


}


@Preview
@Composable
private fun preview() {
    LoginScreen(rememberNavController(), PaddingValues())

}