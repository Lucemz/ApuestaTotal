package com.at.apuestatotal.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.at.apuestatotal.R
import com.at.apuestatotal.presentation.navigation.AppNavRoute
import com.at.apuestatotal.presentation.ui.theme.ApuestaTotalTheme
import com.at.apuestatotal.presentation.ui.theme.TextStyles

@Composable
fun LoadingScreen(
    navHostController: NavHostController,
) {

    LaunchedEffect(Unit) {

        kotlinx.coroutines.delay(5000L)
        navHostController.navigate(route = AppNavRoute.BetHistoryNR.route) {
            popUpTo(AppNavRoute.LoginNR.route) { inclusive = true }
        }
    }

    Scaffold(
        topBar = {},
        content = {


            Column(
                modifier = Modifier
                    .padding(it)
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {


                Image(
                    modifier = Modifier
                        .padding(top = 30.dp)
                        .size(160.dp),
                    painter = painterResource(R.drawable.ic_at_mini),
                    contentDescription = ""
                )


                val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.anim_soccer_loading))
                val progress by animateLottieCompositionAsState(
                    composition = composition,
                    iterations = LottieConstants.IterateForever
                )

                Box(
                    modifier = Modifier.padding(top = 70.dp),
                    contentAlignment = Alignment.Center
                ) {

                    LottieAnimation(
                        modifier = Modifier.size(312.dp),
                        composition = composition,
                        progress = { progress })
                }

                Text(
                    modifier = Modifier.padding(top = 40.dp),
                    text = "Cargando...",
                    style = TextStyles.Heading.h1
                )


            }

        },
        bottomBar = {}
    )


}

@Preview
@Composable
private fun Preview() {
    ApuestaTotalTheme {
        LoadingScreen(rememberNavController())

    }


}