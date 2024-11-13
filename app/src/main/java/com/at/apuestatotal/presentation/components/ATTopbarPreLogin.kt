package com.at.apuestatotal.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.at.apuestatotal.R
import com.at.apuestatotal.presentation.ui.theme.ApuestaTotalTheme
import com.at.apuestatotal.presentation.ui.theme.TextStyles
import com.example.ui.theme.Primary
import com.example.ui.theme.Secondary

@Composable
fun ATTopbarPreLogin(
    onIconClick: () -> Unit = {},
    onRegisterClick: () -> Unit = {},
    onLoginClick: () -> Unit = {}
) {
    Box (
        modifier = Modifier
            .fillMaxWidth()
            .background(Primary.White)
            .padding(WindowInsets.statusBars.asPaddingValues())
            .height(48.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 5.dp), // Margen horizontal
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            IconButton(onClick = onIconClick) {
                Image(
                    painter = painterResource(id = R.drawable.ic_at_mini),
                    contentDescription = "Icono",
                    modifier = Modifier.size(42.dp)
                )
            }


            Row {
                TextButton(onClick = onRegisterClick) {
                    Text(
                        text = "Regístrate",
                        style = TextStyles.Heading.subtitle2,
                        color = Primary.Black
                    )
                }
                TextButton(onClick = onLoginClick) {
                    Text(
                        text = "Iniciar sesión",
                        style = TextStyles.Heading.subtitle2,
                        color = Primary.Black
                    )
                }
            }
        }
        Spacer(modifier = Modifier
            .align(Alignment.BottomCenter)
            .fillMaxWidth()
            .height(1.dp)
            .background(Secondary.RedSecondary))
    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun GreetingPreview() {
    ApuestaTotalTheme(darkTheme = false) {
        // A surface container using the 'background' color from the theme
        Scaffold(topBar = {
            ATTopbarPreLogin()
        }) {

            Column(modifier = Modifier.padding(it)) { }
        }
    }
}