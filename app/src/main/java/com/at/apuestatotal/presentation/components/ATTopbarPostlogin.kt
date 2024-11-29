package com.at.apuestatotal.presentation.components

import SetStatusBarIconsColor
import androidx.compose.animation.animateContentSize
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
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.VectorProperty
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

                Icon(
                    modifier = Modifier
                        .align(Alignment.Bottom)
                        .padding(bottom = 1.dp),
                    painter = painterResource(R.drawable.ic_menu),
                    contentDescription = "",
                    tint = Primary.White
                )

                Spacer(modifier = Modifier.width(5.dp))
                Image(
                    painter = painterResource(id = R.drawable.ic_at_mini_white),
                    contentDescription = "Icono",
                    modifier = Modifier.size(32.dp)
                )


            }



            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Box(
                    modifier = Modifier
                        // .width(100.dp)
                        .height(32.dp)
                        .clip(CircleShape)
                        .background(Secondary.Yellow)
                        .clickable { }
                        .padding(horizontal = 10.dp),
                    contentAlignment = Alignment.Center
                ) { Text("Recarga", style = TextStyles.Card.title2) }

                Spacer(modifier = Modifier.width(5.dp))
                Row(
                    modifier = Modifier
                        .clickable { }
                        .wrapContentWidth()
                        .height(32.dp)
                        .clip(CircleShape)
                        .background(Grays.GrayBorder)
                        .padding(start = 10.dp, end = 4.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    // horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    var isShowBalance by remember { mutableStateOf(false) }

                    Icon(
                        modifier = Modifier
                            .size(16.dp)
                            .clickable { isShowBalance = !isShowBalance },
                        painter = painterResource(if (isShowBalance) R.drawable.ic_eye_slash_outline_regular else R.drawable.eye_icon),
                        contentDescription = "Desplegable saldo",
                        tint = Primary.White
                    )

                    Spacer(modifier = Modifier.width(10.dp))


                    Text(
                        modifier = Modifier.animateContentSize(),
                        text = if (isShowBalance) "S/ 1,000,000.50" else "S/ *****",
                        style = TextStyles.Card.title2,
                        color = Primary.White
                    )
                    Spacer(modifier = Modifier.width(10.dp))

                    Box(
                        modifier = Modifier
                            .size(24.dp)
                            .clip(CircleShape)
                            .background(Color.Red)
                            .clickable { }, contentAlignment = Alignment.Center
                    ) { Text("R", style = TextStyles.Body.paragraph2, color = Primary.White) }

                }


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