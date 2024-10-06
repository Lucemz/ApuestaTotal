package com.at.apuestatotal.presentation.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.at.apuestatotal.presentation.screens.betDetail.BetDetailScreen
import com.at.apuestatotal.presentation.screens.login.LoginScreen

const val MAIN_ROUTE = "mainRoute"

@Composable
fun AppNavigation(
    navHostController: NavHostController,
    innerPadding: PaddingValues,
    startDestination: String
) {

    NavHost(
        navController = navHostController,
        startDestination = startDestination,
        route = MAIN_ROUTE
    ) {

        composable(route = AppNavRoute.LoginNR.route) {
            LoginScreen(navHostController, paddingValues = innerPadding)
        }

        composable(route = AppNavRoute.BetDetailNR.route) {
            BetDetailScreen(navHostController)
        }
    }
}

sealed class AppNavRoute(val route: String) {

    object LoginNR : AppNavRoute("LoginNR")
    object BetDetailNR : AppNavRoute("BetDetailNR")


}