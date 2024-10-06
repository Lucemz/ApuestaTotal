package com.at.apuestatotal.presentation.components

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.at.apuestatotal.R
import com.at.apuestatotal.domain.model.ErrorInfo
import com.at.apuestatotal.presentation.ui.theme.ApuestaTotalTheme
import com.at.apuestatotal.presentation.ui.theme.TextStyles
import com.example.ui.theme.Primary
import com.example.ui.theme.Secondary


@Composable
fun MCErrorDialog(
    onButtonAccept: () -> Unit,
    onDismissRequest: () -> Unit = {},
    icon: Painter = painterResource(id = R.drawable.ic_alert_outlined),
    color: Color = Color(0xFFB9A600),
    errorInfo: ErrorInfo
) {


    var isDetalleShow by remember { mutableStateOf(false) }
    MCDialog(
        onDismissRequest = onDismissRequest
    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Icon(
                painter = icon,
                contentDescription = null,
                tint = color,
                modifier = Modifier
                    .size(48.dp)
            )


            Text(
                modifier = Modifier
                    .padding(top = 20.dp)
                    .fillMaxWidth(),
                text = errorInfo.titulo ?: "Error",
                textAlign = TextAlign.Center,
                color = Primary.Black,
                fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                fontSize = 16.sp,

                )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp),
                text = errorInfo.descripcion ?: "No se pudo realizar la operación",
                textAlign = TextAlign.Center,
                color = Primary.Black,
                fontFamily = FontFamily(Font(R.font.poppins)),
                fontSize = 14.sp,
            )

            if (!errorInfo.detalle.isNullOrEmpty()) {
                Row(
                    modifier = Modifier
                        .padding(top = 10.dp)
                        .border(0.5.dp, Secondary.GrayPrime, RoundedCornerShape(8.dp))
                        .clickable { isDetalleShow = !isDetalleShow },
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        modifier = Modifier.padding(horizontal = 5.dp),
                        text = "Detalle",
                        color = Secondary.GrayPrime,
                        textAlign = TextAlign.Center,
                        fontFamily = FontFamily(Font(R.font.poppins)),
                        fontSize = 12.sp,
                    )
                    Icon(
                        modifier = Modifier
                            .padding(horizontal = 5.dp)
                            .size(12.dp)
                            .rotate(if (isDetalleShow) 180f else 0f),
                        painter = painterResource(id = R.drawable.ic_detail_outline),
                        contentDescription = "",
                        tint = Secondary.GrayPrime
                    )

                }
            }




            if (isDetalleShow) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp),
                    text = errorInfo.detalle!!,
                    textAlign = TextAlign.Justify,
                    fontFamily = FontFamily(Font(R.font.poppins)),
                    fontSize = 14.sp,
                )
            }

            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp),
                content = { Text("Aceptar", style = TextStyles.Button.text1) },
                onClick = onButtonAccept
            )


        }


    }
}


@Preview()
@Composable
private fun preview() {

    ApuestaTotalTheme() {
        MCErrorDialog(onButtonAccept = {}, onDismissRequest = {}, errorInfo =
        ErrorInfo(
            titulo = "Error al Logearse",
            codigo = "1",
            descripcion = "Contraseña incorrecta",
            detalle = ""
        )
        )

    }


}