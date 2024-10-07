package com.at.apuestatotal.presentation.screens.betDetail

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.at.apuestatotal.presentation.screens.betDetail.components.BetHistoryContent
import com.at.apuestatotal.presentation.screens.betDetail.components.BetHistoryViewModel

@Composable
fun BetHistoryScreen(
    navHostController: NavHostController,
    betHistoryViewModel: BetHistoryViewModel = hiltViewModel()
) {

    Scaffold(
        topBar = {},
        content = {
            BetHistoryContent(navHostController, it, betHistoryViewModel)
        },
        bottomBar = {}
    )

}