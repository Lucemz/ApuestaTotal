package com.at.apuestatotal.presentation.screens.mainMenu

import android.util.Log
import android.view.animation.OvershootInterpolator
import androidx.activity.compose.BackHandler
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animate
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DrawerDefaults
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.BeyondBoundsLayout
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withLink
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.SubcomposeAsyncImage
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.at.apuestatotal.R
import com.at.apuestatotal.domain.model.optionNavigationDrawer.ItemOptionDrawer
import com.at.apuestatotal.domain.model.optionNavigationDrawer.NUEVO
import com.at.apuestatotal.domain.model.optionNavigationDrawer.OptionDrawer
import com.at.apuestatotal.domain.model.optionNavigationDrawer.TOP_1
import com.at.apuestatotal.presentation.components.ATTopbarPostLogin
import com.at.apuestatotal.presentation.components.ATTopbarPreLogin
import com.at.apuestatotal.presentation.screens.mainMenu.components.MainMenuContent
import com.at.apuestatotal.presentation.ui.theme.ApuestaTotalTheme
import com.at.apuestatotal.presentation.ui.theme.TextStyles
import com.example.ui.theme.Grays
import com.example.ui.theme.Primary
import com.example.ui.theme.Secondary
import kotlinx.coroutines.launch


@Composable
fun MainMenuScreen() {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val drawerState2 = rememberDrawerState(initialValue = DrawerValue.Closed)

    var gestureEnable by remember { mutableStateOf(drawerState2.isClosed) }
    var isLogged by remember { mutableStateOf(false) }
    drawerState2.isClosed.let {
        gestureEnable = it
    }

    BackHandler(enabled = true, onBack = {

    })


    val coroutineScope = rememberCoroutineScope()
    val itemsOptionDrawer by remember {
        mutableStateOf(
            listOf(
                OptionDrawer(
                    "EL TÍO TE TRAE",
                    listOf(
                        ItemOptionDrawer(
                            "Football Studio",
                            type = TOP_1,
                            colorTab = Secondary.RedSecondary
                        ),
                        ItemOptionDrawer("Poker", type = NUEVO, colorTab = Secondary.RedSecondary)
                    )
                ),
                OptionDrawer(
                    "APUESTA TOTAL",
                    listOf(
                        ItemOptionDrawer("Acerca de Apuesta Total"),
                        ItemOptionDrawer("Juego responsable"),
                        ItemOptionDrawer("Políticas de privacidad"),
                        ItemOptionDrawer("Políticas de cookies"),
                        ItemOptionDrawer("¿Quieres ser un agente AT?"),
                        ItemOptionDrawer("Trabaja con nosotros")
                    )
                ),
                OptionDrawer(
                    "PRODUCTOS",
                    listOf(
                        ItemOptionDrawer("Apuestas en vivo"),
                        ItemOptionDrawer("Apuestas deportivas"),
                        ItemOptionDrawer("Casino"),
                        ItemOptionDrawer("Casino en vivo"),
                        ItemOptionDrawer("Juegos virtuales"),
                        ItemOptionDrawer("Football Studio")
                    )
                ),
                OptionDrawer(
                    "EVENTOS Y PROMOCIONES",
                    listOf(
                        ItemOptionDrawer("Torneos y Carreras"),
                        ItemOptionDrawer("Sorteos"),
                        ItemOptionDrawer("Resultados"),
                        ItemOptionDrawer("Promociones")
                    )
                ),
                OptionDrawer(
                    "ASISTENCIA Y SERVICIO AL CLIENTE",
                    listOf(
                        ItemOptionDrawer("Nuestras tiendas"),
                        ItemOptionDrawer("Servicio al cliente"),
                        ItemOptionDrawer("Acerca de Teleservicios"),
                        ItemOptionDrawer("Territorios restringidos"),
                        ItemOptionDrawer("Reglamento de juego")
                    )
                ),
                OptionDrawer(
                    "RECURSOS Y CONTENIDO",
                    listOf(
                        ItemOptionDrawer("Podcast"),
                        ItemOptionDrawer("Preguntas frecuentes"),
                        ItemOptionDrawer("Tutoriales"),
                        ItemOptionDrawer("Calendario de fútbol")
                    )
                )
            )
        )
    }
    var indexSelected by remember { mutableStateOf<Int?>(0) }

    ModalNavigationDrawer(
        drawerState = drawerState,
        gesturesEnabled = gestureEnable,
        drawerContent = {
            ModalDrawerSheet(
                modifier = Modifier
                    .fillMaxWidth(0.90f), drawerTonalElevation = 0.dp,
                drawerContainerColor = Color.White,
                drawerShape = RectangleShape
            ) {

                Column(
                    modifier = Modifier
                        .padding(16.dp)
                        .verticalScroll(rememberScrollState())
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Row(
                            modifier = Modifier
                                .clickable { coroutineScope.launch { drawerState.close() } },
                            verticalAlignment = Alignment.CenterVertically
                        ) {

                            Image(
                                painter = painterResource(id = R.drawable.ic_at_mini),
                                contentDescription = "Icono at",
                                modifier = Modifier
                                    .size(42.dp)
                            )



                            Icon(
                                modifier = Modifier
                                    .padding(start = 5.dp)
                                    .rotate(90f),
                                painter = painterResource(R.drawable.ic_arrow_rounded),
                                tint = Grays.Gray9,
                                contentDescription = "icon close"
                            )
                        }

                        Row(verticalAlignment = Alignment.CenterVertically) {

                            /*Icon(
                                painter = painterResource(R.drawable.baseline_support_agent_24),
                                contentDescription = ""
                            )
                            Spacer(modifier = Modifier.width(10.dp))
*/
                            FilledIconButton(
                                shape = RoundedCornerShape(15.dp),
                                colors = IconButtonDefaults.iconButtonColors(containerColor = Grays.Gray7),
                                content = {
                                    Icon(
                                        modifier = Modifier,
                                        //  .padding(end = 10.dp),
                                        imageVector = Icons.Filled.Close,
                                        contentDescription = ""
                                    )
                                },
                                onClick = { coroutineScope.launch { drawerState.close() } })

                        }
                    }

                    Spacer(modifier = Modifier.height(40.dp))

                    LazyColumn(
                        modifier = Modifier
                            .heightIn(max = 1500.dp)
                            .fillMaxWidth()
                    ) {

                        itemsIndexed(itemsOptionDrawer) { index, optionDrawer ->
                            var isOpen by remember { mutableStateOf(index == 0) }
                            Log.e("open", isOpen.toString() + optionDrawer.nombre)

                            val rotationAngle by animateFloatAsState(
                                targetValue = if (isOpen) 180f else 0f, // Gira de 0 a 180 grados
                                animationSpec = tween(
                                    durationMillis = 500, // Duración de la animación
                                    easing = {
                                        OvershootInterpolator(2f).getInterpolation(it)
                                    }
                                )
                            )

                            indexSelected.let {

                                isOpen = (it == index)

                            }
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clip(RoundedCornerShape(10.dp))
                                    .height(50.dp)
                                    .background(color = if (!isOpen) Grays.Gray8 else Grays.blackBackGround)
                                    .clickable {
                                        indexSelected = if (indexSelected != index) index else null
                                    }
                                    .padding(horizontal = 15.dp),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {

                                Text(
                                    modifier = Modifier.weight(1f),
                                    text = optionDrawer.nombre,
                                    style = TextStyles.Heading.h3,
                                    color = if (!isOpen) Color.Unspecified else Primary.White
                                )

                                Icon(
                                    modifier = Modifier.rotate(rotationAngle),
                                    painter = painterResource(R.drawable.ic_arrow_rounded),
                                    contentDescription = "Icono desplegable",
                                    tint = Grays.Gray9// if (!isOpen) Grays.Gray9 else Primary.White
                                )

                            }
                            var alpha by remember { mutableStateOf(0f) }

                            LaunchedEffect(isOpen) {
                                if (isOpen) {
                                    alpha = 0f
                                    animate(
                                        initialValue = 0f,
                                        targetValue = 1f,
                                        animationSpec = tween(
                                            durationMillis = 500,
                                            easing = LinearOutSlowInEasing
                                        )
                                    ) { value, _ ->
                                        alpha = value
                                    }
                                } else {
                                    alpha = 0f
                                }
                            }

                            if (isOpen) {
                                Spacer(modifier = Modifier.height(7.dp))
                                optionDrawer.list.forEach { item ->
                                    Row(
                                        modifier = Modifier
                                            .padding(vertical = 2.dp)
                                            .fillMaxWidth()
                                            .clip(RoundedCornerShape(10.dp))
                                            .height(44.dp)
                                            .background(color = Color.Unspecified)
                                            .clickable { }
                                            .padding(horizontal = 15.dp),
                                        horizontalArrangement = Arrangement.Start,
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {

                                        Text(
                                            modifier = Modifier.alpha(alpha),
                                            text = item.nombre.uppercase(),
                                            style = TextStyles.Heading.h3,
                                            fontWeight = FontWeight.Normal
                                        )

                                        if (!item.type.isNullOrEmpty()) {
                                            Row(
                                                modifier = Modifier
                                                    .padding(start = 5.dp)
                                                    .clip(RoundedCornerShape(5.dp))
                                                    .background(item.colorTab ?: Color.Unspecified)
                                            ) {

                                                Text(
                                                    modifier = Modifier.padding(3.dp),
                                                    text = item.type,
                                                    style = TextStyles.Button.text3,
                                                    fontSize = 11.sp,
                                                    color = Primary.White
                                                )

                                            }
                                        }


                                    }
                                }
                                // Spacer(modifier = Modifier.height(7.dp))

                            }



                            Spacer(modifier = Modifier.height(7.dp))
                        }

                        item {

                            Spacer(modifier = Modifier.height(30.dp))
                            val linkMessi =
                                "https://cosasbucket.s3.amazonaws.com/wp-content/uploads/2024/08/08173244/WhatsApp-Image-2024-08-08-at-4.58.04-PM.jpeg"
                            val context = LocalContext.current

                            SubcomposeAsyncImage(
                                model = ImageRequest.Builder(context)
                                    .data(linkMessi)
                                    .crossfade(true)
                                    .build(),
                                contentDescription = "Imagen de banner",
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(160.dp)
                                    .clip(RoundedCornerShape(8.dp)) // Esquinas redondeadas
                                    .clickable {

                                    },
                                loading = {
                                    // Skeleton animado
                                    Image(
                                        painter = rememberAsyncImagePainter(R.drawable.gif_skeleton),
                                        contentDescription = "Cargando",
                                        modifier = Modifier
                                            .fillMaxSize()
                                            .background(Color.LightGray)
                                    )
                                },
                                error = {
                                    // Imagen de error
                                    Image(
                                        painter = painterResource(R.drawable.master),
                                        contentDescription = "Error al cargar la imagen",
                                        modifier = Modifier.fillMaxSize()
                                    )
                                },
                                contentScale = ContentScale.FillBounds // Escalado de la imagen cargada
                            )
                            Spacer(modifier = Modifier.padding(vertical = 5.dp))
                            Text(
                                "Sobrino participa en nuestro sorteo para el circo MESSI 10",
                                style = TextStyles.Body.paragraph2
                            )
                        }
                    }


                }
            }
        }
    ) {

        CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {

            ModalNavigationDrawer(
                gesturesEnabled = !gestureEnable,
                drawerState = drawerState2,
                drawerContent = {
                    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Ltr) {
                        ModalDrawerSheet(
                            modifier = Modifier
                                .fillMaxWidth(0.90f),
                            drawerTonalElevation = 0.dp,
                            drawerContainerColor = Color.White,
                            drawerShape = RectangleShape
                        ) {

                            Column(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(vertical = 10.dp, horizontal = 20.dp)
                            ) {


                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {


                                    Row(verticalAlignment = Alignment.CenterVertically) {

                                        /*Icon(
                                            painter = painterResource(R.drawable.baseline_support_agent_24),
                                            contentDescription = ""
                                        )
                                        Spacer(modifier = Modifier.width(10.dp))
            */
                                        FilledIconButton(
                                            shape = RoundedCornerShape(15.dp),
                                            colors = IconButtonDefaults.iconButtonColors(
                                                containerColor = Grays.Gray7
                                            ),
                                            content = {
                                                Icon(
                                                    modifier = Modifier,
                                                    //  .padding(end = 10.dp),
                                                    imageVector = Icons.Filled.Close,
                                                    contentDescription = ""
                                                )
                                            },
                                            onClick = { coroutineScope.launch { drawerState2.close() } })

                                    }

                                    Row(
                                        modifier = Modifier
                                            .clickable { coroutineScope.launch { drawerState2.close() } },
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {

                                        Image(
                                            painter = painterResource(id = R.drawable.ic_at_mini),
                                            contentDescription = "Icono at",
                                            modifier = Modifier
                                                .size(42.dp)
                                        )


                                        /*
                                                                                Icon(
                                                                                    modifier = Modifier
                                                                                        .padding(start = 5.dp)
                                                                                        .rotate(90f),
                                                                                    painter = painterResource(R.drawable.ic_arrow_rounded),
                                                                                    tint = Grays.Gray9,
                                                                                    contentDescription = "icon close"
                                                                                )*/
                                    }

                                }


                                Spacer(modifier = Modifier.padding(vertical = 15.dp))

                                var textEmail by remember { mutableStateOf<String>("") }

                                val color by remember { mutableStateOf(Color.Cyan) }

                                val interactionSource = remember { MutableInteractionSource() }
                                val isFocused by interactionSource.collectIsFocusedAsState()

                                val containerColor = if (isFocused) Secondary.Blue else Color.Gray

                                TextField(
                                    modifier = Modifier
                                        .border(
                                            1.dp,
                                            color = containerColor,
                                            shape = RoundedCornerShape(10.dp)
                                        )
                                        .fillMaxWidth()
                                        .height(56.dp),
                                    value = textEmail,
                                    onValueChange = { textEmail = it },
                                    label = { Text("Email") },
                                    shape = RoundedCornerShape(10.dp),
                                    colors = TextFieldDefaults.colors(
                                        unfocusedContainerColor = Color.Transparent,
                                        focusedIndicatorColor = Color.Transparent,
                                        unfocusedIndicatorColor = Color.Transparent,
                                        focusedContainerColor = Color.Transparent,
                                        focusedLabelColor = containerColor,
                                        cursorColor = containerColor
                                    ), interactionSource = interactionSource, singleLine = true
                                )

                                Spacer(modifier = Modifier.padding(vertical = 10.dp))
                                var textPassword by remember { mutableStateOf<String>("") }
                                val interactionSource2 = remember { MutableInteractionSource() }
                                val isFocused2 by interactionSource2.collectIsFocusedAsState()

                                val containerColor2 = if (isFocused2) Secondary.Blue else Color.Gray
                                var hideText by remember { mutableStateOf(false) }
                                TextField(
                                    modifier = Modifier
                                        .border(
                                            1.dp,
                                            color = containerColor2,
                                            shape = RoundedCornerShape(10.dp)
                                        )
                                        .fillMaxWidth()
                                        .height(56.dp),
                                    value = textPassword,
                                    onValueChange = { textPassword = it },
                                    label = { Text("Contraseña") },
                                    shape = RoundedCornerShape(10.dp),
                                    colors = TextFieldDefaults.colors(
                                        unfocusedContainerColor = Color.Transparent,
                                        focusedIndicatorColor = Color.Transparent,
                                        unfocusedIndicatorColor = Color.Transparent,
                                        focusedContainerColor = Color.Transparent,
                                        focusedLabelColor = containerColor2,
                                        cursorColor = containerColor2
                                    ),
                                    interactionSource = interactionSource2,
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
                                )

                                Spacer(modifier = Modifier.padding(vertical = 15.dp))
                                Button(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(48.dp),
                                    content = {
                                        Text(
                                            "Iniciar sesíon",
                                            style = TextStyles.Button.text1
                                        )
                                    },
                                    onClick = {
                                        isLogged = true
                                        coroutineScope.launch { drawerState2.close() }

                                    },
                                    shape = RoundedCornerShape(10.dp)
                                )
                                Spacer(modifier = Modifier.padding(vertical = 5.dp))
                                val annotatedText = buildAnnotatedString {
                                    withStyle(
                                        style = SpanStyle(
                                            color = Color.Black,
                                            textDecoration = TextDecoration.None
                                        )
                                    ) {
                                        append("¿Olvidaste tu contraseña? ")
                                    }

                                    pushStringAnnotation(
                                        tag = "CLICKABLE",
                                        annotation = "click_action"
                                    )
                                    withStyle(
                                        style = SpanStyle(
                                            color = Color.Red,
                                            textDecoration = TextDecoration.Underline
                                        )
                                    ) {
                                        append("Haz click aquí")
                                    }
                                    pop()

                                }

                                ClickableText(
                                    modifier = Modifier.align(Alignment.CenterHorizontally),
                                    text = annotatedText,
                                    onClick = { offset ->
                                        annotatedText.getStringAnnotations(
                                            tag = "CLICKABLE",
                                            start = offset,
                                            end = offset
                                        )
                                            .firstOrNull()?.let {
                                                println("Texto clickeado: ${it.item}")
                                                // Aquí puedes manejar la acción deseada (navegación, etc.)
                                            }
                                    },
                                    style = TextStyles.Body.paragraph2
                                )
                                Spacer(modifier = Modifier.padding(vertical = 15.dp))

                                Button(
                                    colors = ButtonDefaults.buttonColors(containerColor = Primary.Black),
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(48.dp),
                                    content = {
                                        Text(
                                            "¡Registrate aqui!",
                                            style = TextStyles.Button.text1
                                        )
                                    },
                                    onClick = {},
                                    shape = RoundedCornerShape(10.dp)
                                )
                                Spacer(modifier = Modifier.padding(vertical = 5.dp))

                                Text(
                                    textAlign = TextAlign.Center,
                                    modifier = Modifier.align(Alignment.CenterHorizontally),
                                    text = "¿No tienes una cuenta Sobrin@ \n ¿Que esperas?",
                                    style = TextStyles.Body.paragraph2
                                )
                                Spacer(modifier = Modifier.height(320.dp))
                                Row(
                                    modifier = Modifier,
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.Start
                                ) {

                                    FilledIconButton(
                                        shape = RoundedCornerShape(15.dp),
                                        colors = IconButtonDefaults.iconButtonColors(
                                            containerColor = Grays.Gray7
                                        ),
                                        content = {
                                            Icon(
                                                painter = painterResource(R.drawable.baseline_support_agent_24),
                                                contentDescription = ""
                                            )
                                        },
                                        onClick = { })


                                    Spacer(modifier = Modifier.width(5.dp))

                                    Text("¿Necesitas ayuda?")

                                }


                            }


                        }
                    }

                }
            ) {
                CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Ltr) {
                    Scaffold(

                        topBar = {
                            if (!isLogged) {
                                ATTopbarPreLogin(
                                    onIconClick = {
                                        coroutineScope.launch {
                                            if (drawerState.isClosed) drawerState.open() else drawerState.close()
                                        }
                                    },
                                    onLoginClick = {
                                        coroutineScope.launch {
                                            if (drawerState2.isClosed) drawerState2.open() else drawerState2.close()
                                        }
                                    }
                                )
                            } else {
                                ATTopbarPostLogin(
                                    onIconClick = {
                                        coroutineScope.launch {
                                            if (drawerState.isClosed) drawerState.open() else drawerState.close()
                                        }
                                    },
                                    onLoginClick = {
                                        coroutineScope.launch {
                                            if (drawerState2.isClosed) drawerState2.open() else drawerState2.close()
                                        }
                                    }
                                )
                            }


                        },
                        content = { paddingValues ->
                            MainMenuContent(paddingValues)
                        }
                    )
                }


            }
        }


    }

}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MainMenuScreenPreview() {
    ApuestaTotalTheme(darkTheme = false) {
        MainMenuScreen()
    }
}