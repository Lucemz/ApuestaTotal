package com.at.apuestatotal.presentation.screens.mainMenu

import SetStatusBarIconsColor
import ToggleStatusBar
import android.util.Log
import android.view.animation.OvershootInterpolator
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.DrawerDefaults
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalWindowInfo
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import coil.compose.AsyncImage
import coil.compose.SubcomposeAsyncImage
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.at.apuestatotal.R
import com.at.apuestatotal.domain.model.optionNavigationDrawer.ItemOptionDrawer
import com.at.apuestatotal.domain.model.optionNavigationDrawer.OptionDrawer
import com.at.apuestatotal.presentation.components.ATTopbarPreLogin
import com.at.apuestatotal.presentation.screens.mainMenu.components.MainMenuContent
import com.at.apuestatotal.presentation.ui.theme.ApuestaTotalTheme
import com.at.apuestatotal.presentation.ui.theme.TextStyles
import com.example.ui.theme.Grays
import com.example.ui.theme.Primary
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.qualifiers.ActivityContext
import kotlinx.coroutines.launch


@Composable
fun MainMenuScreen() {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val coroutineScope = rememberCoroutineScope()
    val itemsOptionDrawer by remember {
        mutableStateOf(
            listOf(
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
    var indexSelected by remember { mutableStateOf<Int?>(null) }

    drawerState.let {
        //ToggleStatusBar(drawerState.isClosed)
        //SetStatusBarIconsColor(!drawerState.isClosed)
    }



    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet(
                modifier = Modifier
                    .fillMaxWidth(0.95f), drawerTonalElevation = 0.dp,
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

                    Spacer(modifier = Modifier.height(40.dp))

                    LazyColumn(
                        modifier = Modifier
                            .heightIn( max= 1500.dp)
                            .fillMaxWidth()
                    ) {

                        itemsIndexed(itemsOptionDrawer) { index, optionDrawer ->
                            var isOpen by remember { mutableStateOf(false) }

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
                                    optionDrawer.nombre,
                                    style = TextStyles.Heading.h2,
                                    color = if (!isOpen) Color.Unspecified else Primary.White
                                )

                                Icon(
                                    modifier = Modifier.rotate(rotationAngle),
                                    painter = painterResource(R.drawable.ic_arrow_rounded),
                                    contentDescription = "Icono desplegable",
                                    tint = Grays.Gray9// if (!isOpen) Grays.Gray9 else Primary.White
                                )

                            }
                            if (isOpen) {
                                optionDrawer.list.forEach { item ->
                                    Row(
                                        modifier = Modifier
                                            .padding(vertical = 3.dp)
                                            .fillMaxWidth()
                                            .clip(RoundedCornerShape(10.dp))
                                            .height(44.dp)
                                            .background(color = Color.Unspecified)
                                            .clickable { }
                                            .padding(horizontal = 15.dp),
                                        horizontalArrangement = Arrangement.SpaceBetween,
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {

                                        Text(
                                            item.nombre.uppercase(),
                                            style = TextStyles.Heading.h3,
                                            fontWeight = FontWeight.Normal
                                        )


                                    }
                                }

                            }



                            Spacer(modifier = Modifier.height(10.dp))
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
                            Text(
                                "Sobrino participa en nuestro sorteo para el circo MESSI 10",
                                style = TextStyles.Body.textCard1
                            )
                        }
                    }


                }
            }
        }
    ) {
        Scaffold(

            topBar = {
                ATTopbarPreLogin(
                    onIconClick = {
                        coroutineScope.launch {
                            if (drawerState.isClosed) drawerState.open() else drawerState.close()
                        }
                    }
                )
            },
            content = { paddingValues ->
                MainMenuContent(paddingValues)
            }
        )
    }

}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MainMenuScreenPreview() {
    ApuestaTotalTheme(darkTheme = false) {
        MainMenuScreen()
    }
}