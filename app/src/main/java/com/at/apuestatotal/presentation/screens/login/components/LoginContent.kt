package com.at.apuestatotal.presentation.screens.login.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.at.apuestatotal.R
import com.at.apuestatotal.presentation.screens.login.LoginScreen
import com.at.apuestatotal.presentation.ui.theme.ApuestaTotalTheme
import com.at.apuestatotal.presentation.ui.theme.TextStyles
import com.example.ui.theme.Grays
import com.example.ui.theme.Primary
import com.example.ui.theme.Secondary

@Composable
fun LoginContent(navHostController: NavHostController, paddingValues: PaddingValues, loginViewModel: LoginViewModel) {

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            modifier = Modifier
                .padding(top = 60.dp)
                .fillMaxWidth()
                .size(300.dp, 60.dp),
            painter = painterResource(R.drawable.ap_logo),
            contentDescription = "",
        )

        Card(
            modifier = Modifier
                .padding(top = 80.dp, start = 30.dp, end = 30.dp)
                .fillMaxWidth()

                .clip(RoundedCornerShape(size = 23.dp))
                .border(width = 1.dp, color = Grays.Gray2, shape = RoundedCornerShape(size = 23.dp))
                //.shadow(4.dp)
                .background(Primary.White, shape = RoundedCornerShape(size = 23.dp)),
            colors = CardDefaults.cardColors(containerColor = Primary.White),

            ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    modifier = Modifier.padding(top = 20.dp),
                    text = "Iniciar Sesión",
                    style = TextStyles.Heading.h2
                )


                OutlinedTextField(
                    modifier = Modifier.padding(top = 32.dp),
                    value = loginViewModel.email,
                    shape = RoundedCornerShape(15.dp),
                    onValueChange = {
                        loginViewModel.email = it

                    }, placeholder = { Text("Usuario") }, keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Email,
                        imeAction = ImeAction.Next
                    ), singleLine = true


                )
                var hideText by remember { mutableStateOf(false) }
                OutlinedTextField(
                    modifier = Modifier.padding(top = 32.dp),
                    value = loginViewModel.password,
                    shape = RoundedCornerShape(15.dp),
                    onValueChange = {
                        loginViewModel.password = it
                    },
                    placeholder = { Text("Contraseña") },
                    trailingIcon = {
                        Icon(

                            painter = if (hideText) painterResource(id = R.drawable.ic_eye_password_outline) else painterResource(
                                id = R.drawable.ic_eye_slash_outline_regular
                            ),
                            contentDescription = "Mostrar/Ocultar contraseña",
                            modifier = Modifier
                                .padding(end = 20.dp)
                                .clickable {
                                    hideText = !hideText
                                }
                        )
                    },
                    visualTransformation = if (!hideText) PasswordVisualTransformation() else VisualTransformation.None,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Password,
                        imeAction = ImeAction.Next
                    ),
                    singleLine = true
                )





                Button(
                    modifier = Modifier

                        .padding(top = 25.dp)
                        .size(220.dp, 45.dp),
                    content = {
                        Text(
                            "Ingresar",
                            style = TextStyles.Button.text1,
                            color = Primary.White
                        )
                    },
                    onClick = {loginViewModel.login()},
                    colors = ButtonDefaults.buttonColors(containerColor = Primary.Black)
                )

                Text(
                    modifier = Modifier
                        .align(Alignment.End)
                        .padding(end = 20.dp, top = 15.dp),
                    text = "¿Olvidaste tu contraseña?",
                    style = TextStyles.Heading.subtitle2,
                    color = Secondary.GrayPrime,
                )


                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 50.dp, end = 50.dp, top = 16.dp),
                    verticalAlignment = Alignment.CenterVertically

                ) {

                    HorizontalDivider(
                        modifier = Modifier.weight(1f),
                        thickness = 1.dp,
                        color = Grays.Gray4
                    )
                    Text(
                        modifier = Modifier
                            .padding(start = 5.dp, end = 5.dp)
                            .align(Alignment.CenterVertically),

                        text = "o",
                        color = Grays.Gray4,
                        style = TextStyles.Card.subtitle2
                    )

                    HorizontalDivider(
                        modifier = Modifier.weight(1f),
                        thickness = 1.dp,
                        color = Grays.Gray4
                    )
                }

                Text(
                    modifier = Modifier.padding(top = 20.dp),
                    text = "¿No tienes una cuenta?\n ¡Qué esperas!",
                    style = TextStyles.Card.subtitle1,
                    textAlign = TextAlign.Center
                )
                Button(
                    modifier = Modifier

                        .padding(top = 25.dp, bottom = 25.dp)
                        .size(220.dp, 45.dp),
                    content = {
                        Text(
                            "¡Registrate aquí!",
                            style = TextStyles.Button.text1,
                            color = Primary.White
                        )
                    },
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(containerColor = Secondary.RedSecondary)
                )
            }


        }
    }


}


@Preview
@Composable
private fun Preview() {
    ApuestaTotalTheme {
        LoginScreen(rememberNavController())

    }


}