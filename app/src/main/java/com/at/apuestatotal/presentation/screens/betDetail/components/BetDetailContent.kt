package com.at.apuestatotal.presentation.screens.betDetail.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController

@Composable
fun BetDetailContent(
    navHostController: NavHostController,
    paddingValues: PaddingValues,
    betHistoryViewModel: BetHistoryViewModel
) {


    Column(
        modifier = Modifier
            .padding(paddingValues)
            .fillMaxSize()
    ) {


        CardBetHistory(betHistoryViewModel.betHistoryList)


    }


}