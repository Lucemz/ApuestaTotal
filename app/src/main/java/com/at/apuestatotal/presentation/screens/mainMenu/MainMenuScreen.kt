package com.at.apuestatotal.presentation.screens.mainMenu

import SetStatusBarIconsColor
import ToggleStatusBar
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
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.systemBarsPadding
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
import androidx.compose.runtime.rememberCoroutineScope
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
import com.at.apuestatotal.presentation.components.ATTopbarPreLogin
import com.at.apuestatotal.presentation.screens.mainMenu.components.MainMenuContent
import com.at.apuestatotal.presentation.ui.theme.ApuestaTotalTheme
import com.at.apuestatotal.presentation.ui.theme.TextStyles
import com.example.ui.theme.Grays
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.qualifiers.ActivityContext
import kotlinx.coroutines.launch


@Composable
fun MainMenuScreen() {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val coroutineScope = rememberCoroutineScope()


    drawerState.let {
        //ToggleStatusBar(drawerState.isClosed)
        //SetStatusBarIconsColor(!drawerState.isClosed)
    }


    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet(
                drawerTonalElevation = 0.dp,
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
                                contentDescription = "Icono",
                                modifier = Modifier
                                    .size(42.dp)
                            )



                            Icon(
                                modifier = Modifier
                                    .padding(start = 5.dp)
                                    .rotate(90f),
                                painter = painterResource(R.drawable.ic_arrow_rounded),
                                tint = Grays.Gray9,
                                contentDescription = ""
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
                            onClick = { coroutineScope.launch { drawerState.close() }})

                    }

                    Spacer(modifier = Modifier.height(40.dp))

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(10.dp))
                            .height(44.dp)
                            .background(color = Grays.Gray8)
                            .clickable { }
                            .padding(horizontal = 15.dp)
                        ,
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Text("APUESTA TOTAL", style = TextStyles.Heading.h3)

                        Icon(
                            painter = painterResource(R.drawable.ic_arrow_rounded),
                            contentDescription = "Icono desplegable",
                            tint = Grays.Gray9
                        )

                    }


                    Spacer(modifier = Modifier.height(10.dp))

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(10.dp))
                            .height(44.dp)
                            .background(color = Grays.Gray8)
                            .clickable { }
                            .padding(horizontal = 15.dp)
                        ,
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Text("PRODUCTOS", style = TextStyles.Heading.h3)

                        Icon(
                            painter = painterResource(R.drawable.ic_arrow_rounded),
                            contentDescription = "Icono desplegable",
                            tint = Grays.Gray9
                        )

                    }
                    Spacer(modifier = Modifier.height(10.dp))

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(10.dp))
                            .height(44.dp)
                            .background(color = Grays.Gray8)
                            .clickable { }
                            .padding(horizontal = 15.dp)
                        ,
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Text("EVENTOS Y PROMOCIONES", style = TextStyles.Heading.h3)

                        Icon(
                            painter = painterResource(R.drawable.ic_arrow_rounded),
                            contentDescription = "Icono desplegable",
                            tint = Grays.Gray9
                        )

                    }
                    Spacer(modifier = Modifier.height(10.dp))

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(10.dp))
                            .height(44.dp)
                            .background(color = Grays.Gray8)
                            .clickable { }
                            .padding(horizontal = 15.dp)
                        ,
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Text(
                            modifier = Modifier.weight(1f),
                            text = "ASISTENCIA Y SERVICIO AL CLIENTE",
                            style = TextStyles.Heading.h3,
                            overflow = TextOverflow.Ellipsis
                        )

                        Icon(
                            painter = painterResource(R.drawable.ic_arrow_rounded),
                            contentDescription = "Icono desplegable",
                            tint = Grays.Gray9
                        )

                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(10.dp))
                            .height(44.dp)
                            .background(color = Grays.Gray8)
                            .clickable { }
                            .padding(horizontal = 15.dp)
                        ,
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Text(
                            modifier = Modifier.weight(1f),
                            text = "RECURSOS Y CONTENIDO",
                            style = TextStyles.Heading.h3,
                            overflow = TextOverflow.Ellipsis
                        )

                        Icon(
                            painter = painterResource(R.drawable.ic_arrow_rounded),
                            contentDescription = "Icono desplegable",
                            tint = Grays.Gray9
                        )

                    }

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
                }
            }
        }
    ) {
        Scaffold (

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