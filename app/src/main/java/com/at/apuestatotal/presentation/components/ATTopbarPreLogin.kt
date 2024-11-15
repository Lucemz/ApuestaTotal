package com.at.apuestatotal.presentation.components

import SetStatusBarIconsColor
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
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
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.fastCbrt
import com.at.apuestatotal.R
import com.at.apuestatotal.presentation.ui.theme.ApuestaTotalTheme
import com.at.apuestatotal.presentation.ui.theme.TextStyles
import com.example.ui.theme.Grays
import com.example.ui.theme.Primary
import com.example.ui.theme.Secondary
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun ATTopbarPreLogin(
    onIconClick: () -> Unit = {},
    onRegisterClick: () -> Unit = {},
    onLoginClick: () -> Unit = {}
) {
//val locoas = rememberSystemUiController().
    SetStatusBarIconsColor(false)

    Box(
        modifier = Modifier
            .fillMaxWidth()
              .background(Primary.Black)
              .padding(WindowInsets.statusBars.asPaddingValues())
            .height(48.dp)
    ) {
        Row(
            modifier = Modifier
                .background(Color.Black)
                .fillMaxSize()
                .padding(horizontal = 10.dp), // Margen horizontal
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {


            Row(
                modifier = Modifier.clickable { onIconClick() },
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_at_mini_white),
                    contentDescription = "Icono",
                    modifier = Modifier.size(32.dp)
                )
                Icon(
                    modifier = Modifier
                        .padding(start = 5.dp)
                        .rotate(270f),
                    painter = painterResource(R.drawable.ic_arrow_rounded),
                    contentDescription = "",
                    tint = Grays.Gray9
                )

            }



            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                TextButton(
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier.height(30.dp),
                    onClick = onLoginClick,
                    contentPadding = PaddingValues(vertical = 5.dp, horizontal = 5.dp)
                ) {
                    Text(
                        text = "Iniciar sesión",
                        style = TextStyles.Heading.subtitle2,
                        color = Primary.White
                    )
                }
                Text("|", color = Grays.Gray5)
                Spacer(modifier = Modifier.padding(horizontal = 3.dp))
                TextButton(
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier.height(30.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Grays.Gray5),
                    onClick = onRegisterClick,
                    contentPadding = PaddingValues(vertical = 5.dp, horizontal = 5.dp)
                ) {
                    Text(
                        modifier = Modifier.padding(horizontal = 5.dp),
                        text = "Regístrate",
                        style = TextStyles.Heading.subtitle2,
                        color = Primary.White
                    )
                }
            }
        }
        Spacer(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .height(1.dp)
                .background(Secondary.RedSecondary)
        )
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