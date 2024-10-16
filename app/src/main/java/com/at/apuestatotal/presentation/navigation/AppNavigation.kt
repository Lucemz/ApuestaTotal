package com.at.apuestatotal.presentation.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.at.apuestatotal.presentation.screens.LoadingScreen
import com.at.apuestatotal.presentation.screens.betDetail.BetHistoryScreen
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
        route = MAIN_ROUTE, enterTransition = {
            slideIntoContainer(AnimatedContentTransitionScope.SlideDirection.Start, tween(700))
        },
        exitTransition = {
            slideOutOfContainer(AnimatedContentTransitionScope.SlideDirection.Start, tween(700))
        },
        popEnterTransition = {
            slideIntoContainer(AnimatedContentTransitionScope.SlideDirection.End, tween(700))
        },
        popExitTransition = {
            slideOutOfContainer(AnimatedContentTransitionScope.SlideDirection.End, tween(700))
        }
    ) {

        composable(route = AppNavRoute.LoginNR.route) {
            LoginScreen(navHostController, paddingValues = innerPadding)
        }
        composable(route = AppNavRoute.LoadingNR.route) {
            LoadingScreen(navHostController, paddingValues = innerPadding)
        }
        composable(route = AppNavRoute.BetHistoryNR.route) {
            BetHistoryScreen(navHostController)
        }
    }
}

sealed class AppNavRoute(val route: String) {

    object LoginNR : AppNavRoute("LoginNR")
    object LoadingNR : AppNavRoute("LoadingNR")
    object BetHistoryNR : AppNavRoute("BetHistoryNR")


}