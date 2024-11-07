package com.at.apuestatotal.presentation.screens.mainMenu

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import com.at.apuestatotal.presentation.screens.mainMenu.components.MainMenuContent

@Composable
fun MainMenuScreen() {

    Scaffold(
        topBar = {},
        content = { MainMenuContent(it) },
        bottomBar = {})

}