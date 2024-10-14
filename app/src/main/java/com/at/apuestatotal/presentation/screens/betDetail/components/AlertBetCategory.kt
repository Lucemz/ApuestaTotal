package com.at.apuestatotal.presentation.screens.betDetail.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.at.apuestatotal.R
import com.at.apuestatotal.presentation.components.MCDialog
import com.at.apuestatotal.presentation.ui.theme.ApuestaTotalTheme
import com.at.apuestatotal.presentation.ui.theme.TextStyles
import com.example.ui.theme.Secondary

@Composable
fun AlertBetCategory(onDismissRequest: () -> Unit) {

    MCDialog(onDismissRequest = { onDismissRequest() }) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 18.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {

            Text("Categorias ", style = TextStyles.Card.title1, color = Secondary.RedSecondary)
            Text("de apuesta", style = TextStyles.Card.title1)


        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 28.dp, start = 38.dp, end = 38.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Text("Donatelo ", style = TextStyles.Card.subtitle1)

            Icon(painter = painterResource(R.drawable.donatelo), contentDescription = "")


        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 14.dp, start = 38.dp, end = 38.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Text("Caza Fijas ", style = TextStyles.Card.subtitle1)

            Icon(painter = painterResource(R.drawable.cazafijas), contentDescription = "")


        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 14.dp, start = 38.dp, end = 38.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Text("Capo ", style = TextStyles.Card.subtitle1)

            Icon(painter = painterResource(R.drawable.capo), contentDescription = "")


        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 14.dp, start = 38.dp, end = 38.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Text("Master ", style = TextStyles.Card.subtitle1)

            Icon(painter = painterResource(R.drawable.master), contentDescription = "")


        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 14.dp, start = 38.dp, end = 38.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Text("King ", style = TextStyles.Card.subtitle1)

            Icon(painter = painterResource(R.drawable.king), contentDescription = "")


        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 14.dp, bottom = 18.dp, start = 38.dp, end = 38.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Text("Leyenda ", style = TextStyles.Card.subtitle1)

            Icon(painter = painterResource(R.drawable.leyenda), contentDescription = "")


        }

    }


}

@Preview
@Composable
private fun Preview() {
    ApuestaTotalTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AlertBetCategory({})//rememberNavController(), PaddingValues()) }

        }
    }

}