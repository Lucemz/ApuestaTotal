package com.at.apuestatotal.presentation.screens.mainMenu.components

import android.os.Build
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.ImageLoader
import coil.compose.AsyncImage
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import coil.request.ImageRequest
import com.at.apuestatotal.R
import com.at.apuestatotal.presentation.screens.mainMenu.MainMenuScreen
import com.at.apuestatotal.presentation.screens.mainMenu.MainMenuViewModel
import com.at.apuestatotal.presentation.ui.theme.ApuestaTotalTheme
import com.at.apuestatotal.presentation.ui.theme.TextStyles

@Composable
fun MainMenuContent(
    paddingValues: PaddingValues,
    mainMenuViewModel: MainMenuViewModel = hiltViewModel()
) {

    val listDeportivaBanner = mainMenuViewModel.listaBanerHomeDeportiva
    val listCasinoBanner = mainMenuViewModel.listaBanerHomeCasino

    val context = LocalContext.current
    val imageLoader = ImageLoader.Builder(context)
        .components {
            if (Build.VERSION.SDK_INT >= 28) {
                add(ImageDecoderDecoder.Factory())
            } else {
                add(GifDecoder.Factory())
            }
        }
        .build()




    Column(
        modifier = Modifier
            .padding(paddingValues = paddingValues)
            .fillMaxSize()
    ) {
val link = "https://www.apuestatotal.com${mainMenuViewModel.banerHomeCentralIndexSelected?.bannerConfig?.image}"
        AsyncImage(
            modifier = Modifier
                .fillMaxWidth()
                .height(130.dp)
                .clickable {
                    mainMenuViewModel.getHomeDeportivasBanner()
                },
            model = ImageRequest.Builder(context)
                .data(link)
                .crossfade(true)
                .build(),
            contentDescription = "Imagen de banner",
            imageLoader = imageLoader,
            placeholder = painterResource(R.drawable.ap_logo),
            error = painterResource(R.drawable.master),
            contentScale = ContentScale.FillBounds,
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 15.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {


            Text(
                modifier = Modifier,
                style = TextStyles.Card.title1,
                text = "Deportivas"
            )

            Icon(
                modifier = Modifier.rotate(270f),
                painter = painterResource(R.drawable.ic_detail_mini),
                contentDescription = ""
            )

        }

        LazyRow(
            modifier = Modifier
                .padding(top = 10.dp)
                .fillMaxWidth()
                .height(170.dp)
        ) {

            items(listDeportivaBanner) {
                Spacer(modifier = Modifier.width(10.dp))
                Card(modifier = Modifier
                    .fillMaxHeight()
                    .width(120.dp)
                    .shadow(1.dp, shape = RoundedCornerShape(10.dp))
                    .clickable { }) {
                    val link = "https://www.apuestatotal.com${it.bannerConfig.image}"
                    Log.e("imagenLink", link)



                    AsyncImage(
                        model = ImageRequest.Builder(context)
                            .data(link)
                            .crossfade(true)
                            .build(),
                        contentDescription = "Imagen de banner",
                        imageLoader = imageLoader,
                        placeholder = painterResource(R.drawable.ap_logo),
                        error = painterResource(R.drawable.master),
                        contentScale = ContentScale.FillBounds, // Ajusta a Fit para no recortar
                        modifier = Modifier.fillMaxSize()
                    )


                    /*   AsyncImage(
                           modifier = Modifier.fillMaxSize(),
                           model = link,
                           contentDescription = "Imagen desde URL",
                           placeholder = painterResource(R.drawable.ap_logo),
                           error = painterResource(R.drawable.master),
                           contentScale = ContentScale.Crop
                       )*/

                    /*  Image(
                          modifier = Modifier.fillMaxSize(),
                          painter = painterResource(R.drawable.ic_at_mini),
                          contentScale = ContentScale.Crop,
                          contentDescription = ""
                      )*/
                }


            }


        }


        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 15.dp, vertical = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {


            Text(
                modifier = Modifier,
                style = TextStyles.Card.title1,
                text = "Casino"
            )

            Icon(
                modifier = Modifier.rotate(270f),
                painter = painterResource(R.drawable.ic_detail_mini),
                contentDescription = ""
            )

        }
        LazyRow(
            modifier = Modifier
                .padding(top = 10.dp)
                .fillMaxWidth()
                .height(170.dp)
        ) {

            items(listCasinoBanner) {
                Spacer(modifier = Modifier.width(10.dp))
                Card(modifier = Modifier
                    .fillMaxHeight()
                    .width(120.dp)
                    .shadow(1.dp, shape = RoundedCornerShape(10.dp))
                    .clickable { }) {
                    val link = "https://www.apuestatotal.com${it.bannerConfig.image}"
                    Log.e("imagenLink", link)



                    AsyncImage(
                        model = ImageRequest.Builder(context)
                            .data(link)
                            .crossfade(true)
                            .build(),
                        contentDescription = "Imagen de banner",
                        imageLoader = imageLoader,
                        placeholder = painterResource(R.drawable.ap_logo),
                        error = painterResource(R.drawable.master),
                        contentScale = ContentScale.FillBounds, // Ajusta a Fit para no recortar
                        modifier = Modifier.fillMaxSize()
                    )


                    /*   AsyncImage(
                           modifier = Modifier.fillMaxSize(),
                           model = link,
                           contentDescription = "Imagen desde URL",
                           placeholder = painterResource(R.drawable.ap_logo),
                           error = painterResource(R.drawable.master),
                           contentScale = ContentScale.Crop
                       )*/

                    /*  Image(
                          modifier = Modifier.fillMaxSize(),
                          painter = painterResource(R.drawable.ic_at_mini),
                          contentScale = ContentScale.Crop,
                          contentDescription = ""
                      )*/
                }



            }


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
            MainMenuScreen()//rememberNavController(), PaddingValues()) }

        }
    }

}