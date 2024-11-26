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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.at.apuestatotal.R
import com.at.apuestatotal.presentation.ui.theme.ApuestaTotalTheme
import com.at.apuestatotal.presentation.ui.theme.TextStyles
import com.example.ui.theme.Grays
import com.example.ui.theme.Primary
import com.example.ui.theme.Secondary

@Composable
fun ATTopbarPostLogin(
    onIconClick: () -> Unit = {},
    onRegisterClick: () -> Unit = {},
    onLoginClick: () -> Unit = {}
) {
    SetStatusBarIconsColor(false)

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Grays.blackBackGround)
            .padding(WindowInsets.statusBars.asPaddingValues())
            .height(48.dp)
    ) {
        Row(
            modifier = Modifier

                .fillMaxSize()
                .padding(horizontal = 10.dp),
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


                Text("S/ 10.00", style = TextStyles.Body.textCard1, color = Primary.White)
                Spacer(modifier = Modifier.width(10.dp))

                Box(
                    modifier = Modifier
                        .width(100.dp)
                        .height(32.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .background(Secondary.Yellow)
                        .clickable { },
                    contentAlignment = Alignment.Center
                ) { Text("Recargar", style = TextStyles.Heading.h2) }



                Spacer(modifier = Modifier.width(10.dp))

                Box(
                    modifier = Modifier
                        .size(38.dp)
                        .clip(CircleShape)
                        .background(Color.Red)
                        .clickable { }, contentAlignment = Alignment.Center
                ) { Text("R", style = TextStyles.Heading.h2, color = Primary.White) }

            }
        }
        Spacer(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .height(2.dp)
                .background(Grays.GrayBorder.copy(alpha = 0.25f))
        )
    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun GreetingPreview() {
    ApuestaTotalTheme(darkTheme = false) {
        // A surface container using the 'background' color from the theme
        Scaffold(topBar = {
            ATTopbarPostLogin()
        }) {

            Column(modifier = Modifier.padding(it)) { }
        }
    }
}