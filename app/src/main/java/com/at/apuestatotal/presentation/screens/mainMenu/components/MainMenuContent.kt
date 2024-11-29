package com.at.apuestatotal.presentation.screens.mainMenu.components

import android.os.Build
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
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
import com.example.ui.theme.Grays
import com.example.ui.theme.Primary
import com.example.ui.theme.Secondary
import kotlinx.coroutines.flow.StateFlow

@Composable
fun MainMenuContent(
    paddingValues: PaddingValues,
    mainMenuViewModel: MainMenuViewModel = hiltViewModel()
) {

    val listDeportivaBanner = mainMenuViewModel.listBannerHomeSports
    val listCasinoBanner = mainMenuViewModel.listBannerHomeCasino
    val listTournamentsBanner = mainMenuViewModel.listBannerHomeTournament
    val listCasinoLiveBanner = mainMenuViewModel.listBannerHomeCasinoLive
    val listJackpotBanner = mainMenuViewModel.listBannerHomeJackpots
    val listPromotionBanner = mainMenuViewModel.listBannerHomePromotions
    val listPaymentMethodsBanner = mainMenuViewModel.listBannerFooterPaymentMethods
    val listStampBanner = mainMenuViewModel.listBannerFooterStamps
    val listSponsorBanner = mainMenuViewModel.listBannerFooterSponsor


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
            .verticalScroll(rememberScrollState())
    ) {
        val linkPrincipal =
            "https://www.apuestatotal.com${mainMenuViewModel.bannerHomeCentralIndexSelected?.bannerConfig?.image}"
        AsyncImage(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .clickable {
                    //   mainMenuViewModel.getHomeCentralBanner()
                },
            model = ImageRequest.Builder(context)
                .data(linkPrincipal)
                .crossfade(true)
                .build(),
            contentDescription = "Imagen de banner",
            imageLoader = imageLoader,
            placeholder = painterResource(R.drawable.greyfade),
            error = painterResource(R.drawable.master),
            contentScale = ContentScale.FillBounds,
        )
        Spacer(modifier = Modifier.height(10.dp))
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
        Spacer(modifier = Modifier.height(10.dp))
        LazyRow(
            modifier = Modifier
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
                    //    Log.e("imagenLink", link)


                    AsyncImage(
                        model = ImageRequest.Builder(context)
                            .data(link)
                            .crossfade(true)
                            .build(),
                        contentDescription = "Imagen de banner",
                        imageLoader = imageLoader,
                        placeholder = painterResource(R.drawable.greyfade),
                        error = painterResource(R.drawable.master),
                        contentScale = ContentScale.FillBounds, // Ajusta a Fit para no recortar
                        modifier = Modifier.fillMaxSize()
                    )

                }


            }


        }

        Spacer(modifier = Modifier.height(10.dp))
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
                text = "Casino"
            )

            Icon(
                modifier = Modifier.rotate(270f),
                painter = painterResource(R.drawable.ic_detail_mini),
                contentDescription = ""
            )

        }
        Spacer(modifier = Modifier.height(10.dp))
        LazyRow(
            modifier = Modifier
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

                    AsyncImage(
                        model = ImageRequest.Builder(context)
                            .data(link)
                            .crossfade(true)
                            .build(),
                        contentDescription = "Imagen de banner",
                        imageLoader = imageLoader,
                        placeholder = painterResource(R.drawable.greyfade),
                        error = painterResource(R.drawable.master),
                        contentScale = ContentScale.FillBounds, // Ajusta a Fit para no recortar
                        modifier = Modifier.fillMaxSize()
                    )


                }


            }


        }

        Spacer(modifier = Modifier.height(10.dp))
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
                text = "Torneos"
            )

            Icon(
                modifier = Modifier.rotate(270f),
                painter = painterResource(R.drawable.ic_detail_mini),
                contentDescription = ""
            )

        }

        Spacer(modifier = Modifier.height(10.dp))
        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .height(140.dp)
        ) {

            items(listTournamentsBanner) {
                Spacer(modifier = Modifier.width(10.dp))
                Card(modifier = Modifier
                    .fillMaxHeight()
                    .width(220.dp)
                    //.shadow(1.dp, shape = RoundedCornerShape(10.dp))
                    .clickable { }, colors = CardDefaults.cardColors(containerColor = Color.Transparent) ) {
                    val link = "https://www.apuestatotal.com${it.cms.summaryImage}"

                    AsyncImage(
                        model = ImageRequest.Builder(context)
                            .data(link)
                            .crossfade(true)
                            .build(),
                        contentDescription = "Imagen de banner",
                        imageLoader = imageLoader,
                        placeholder = painterResource(R.drawable.greyfade),
                        error = painterResource(R.drawable.master),
                        contentScale = ContentScale.FillBounds, // Ajusta a Fit para no recortar
                        modifier = Modifier.fillMaxSize()
                    )


                }


            }


        }

        Spacer(modifier = Modifier.height(10.dp))
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
                text = "Casino en vivo"
            )

            Icon(
                modifier = Modifier.rotate(270f),
                painter = painterResource(R.drawable.ic_detail_mini),
                contentDescription = ""
            )

        }

        Spacer(modifier = Modifier.height(10.dp))
        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .height(170.dp)
        ) {

            items(listCasinoLiveBanner) {
                Spacer(modifier = Modifier.width(10.dp))
                Card(modifier = Modifier
                    .fillMaxHeight()
                    .width(120.dp)
                    .shadow(1.dp, shape = RoundedCornerShape(10.dp))
                    .clickable { }) {
                    val link = "https://www.apuestatotal.com${it.bannerConfig.image}"

                    AsyncImage(
                        model = ImageRequest.Builder(context)
                            .data(link)
                            .crossfade(true)
                            .build(),
                        contentDescription = "Imagen de banner",
                        imageLoader = imageLoader,
                        placeholder = painterResource(R.drawable.greyfade),
                        error = painterResource(R.drawable.master),
                        contentScale = ContentScale.FillBounds,
                        modifier = Modifier.fillMaxSize()
                    )


                }


            }


        }

        Spacer(modifier = Modifier.height(10.dp))
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
                text = "Jackpots"
            )

            Icon(
                modifier = Modifier.rotate(270f),
                painter = painterResource(R.drawable.ic_detail_mini),
                contentDescription = ""
            )

        }
        Spacer(modifier = Modifier.height(10.dp))
        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp)
        ) {

            items(listJackpotBanner) {
                Spacer(modifier = Modifier.width(10.dp))
                Card(modifier = Modifier
                    .fillMaxHeight()
                    .width(150.dp)
                    .shadow(1.dp, shape = RoundedCornerShape(10.dp))
                    .clickable { }) {
                    val link = "https://www.apuestatotal.com${it.logo}"

                    AsyncImage(
                        model = ImageRequest.Builder(context)
                            .data(link)
                            .crossfade(true)
                            .build(),
                        contentDescription = "Imagen de banner",
                        imageLoader = imageLoader,
                        placeholder = painterResource(R.drawable.greyfade),
                        error = painterResource(R.drawable.master),
                        contentScale = ContentScale.FillBounds,
                        modifier = Modifier.fillMaxSize()
                    )


                }


            }


        }

        Spacer(modifier = Modifier.height(10.dp))
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
                text = "Misiones"
            )

            Icon(
                modifier = Modifier.rotate(270f),
                painter = painterResource(R.drawable.ic_detail_mini),
                contentDescription = ""
            )

        }

        Spacer(modifier = Modifier.height(10.dp))
        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .height(140.dp)
        ) {

            items(listCasinoBanner) {
                Spacer(modifier = Modifier.width(10.dp))
                Card(modifier = Modifier
                    .fillMaxHeight()
                    .width(150.dp)
                    .shadow(1.dp, shape = RoundedCornerShape(10.dp))
                    .clickable { }) {
                    val link = "https://www.apuestatotal.com${it.bannerConfig.image}"

                    AsyncImage(
                        model = ImageRequest.Builder(context)
                            .data(link)
                            .crossfade(true)
                            .build(),
                        contentDescription = "Imagen de banner",
                        imageLoader = imageLoader,
                        placeholder = painterResource(R.drawable.greyfade),
                        error = painterResource(R.drawable.master),
                        contentScale = ContentScale.FillBounds,
                        modifier = Modifier.fillMaxSize()
                    )


                }



            }


        }

        Spacer(modifier = Modifier.height(10.dp))
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
                text = "Promociones"
            )

            Icon(
                modifier = Modifier.rotate(270f),
                painter = painterResource(R.drawable.ic_detail_mini),
                contentDescription = ""
            )

        }

        Spacer(modifier = Modifier.height(10.dp))
        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
            //.height(140.dp)
        ) {

            items(listPromotionBanner.chunked(2)) { list ->

                Spacer(modifier = Modifier.width(10.dp))
                Column {
                    list.forEach {

                        Card(modifier = Modifier
                            .fillMaxHeight()
                            .width(250.dp)
                            .height(100.dp)
                            .shadow(1.dp, shape = RoundedCornerShape(10.dp))
                            .clickable { }) {


                            val link = "https://www.apuestatotal.com${it.summaryImage}"
                            // Log.e("linkImage", link)
                            AsyncImage(
                                model = ImageRequest.Builder(context)
                                    .data(link)
                                    .crossfade(true)
                                    .build(),
                                contentDescription = "Imagen de banner",
                                imageLoader = imageLoader,
                                placeholder = painterResource(R.drawable.greyfade),
                                error = painterResource(R.drawable.master),
                                contentScale = ContentScale.FillBounds, // Ajusta a Fit para no recortar
                                modifier = Modifier.fillMaxSize()
                            )


                        }
                        Spacer(modifier = Modifier.height(5.dp))
                    }
                }

            }


        }





        Spacer(modifier = Modifier.height(30.dp))

        TextoAnimado(mainMenuViewModel.textoMostrado)


        Spacer(modifier = Modifier.height(20.dp))




        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(400.dp)
                .background(Color(0xFF292929))
        ) {

            Spacer(modifier = Modifier.height(10.dp))
            LazyRow(
                modifier = Modifier
                    .height(150.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
                //     .height(140.dp),

            ) {

                items(listPaymentMethodsBanner) {
                    Spacer(modifier = Modifier.width(10.dp))

                    Box(
                        modifier = Modifier
                            .width(150.dp)
                            .height(150.dp),
                        contentAlignment = Alignment.Center
                    ) {

                        val link = "https://www.apuestatotal.com${it.bannerConfig.image}"

                        AsyncImage(
                            modifier = Modifier
                                .fillMaxHeight()
                               // .widthIn(max = 200.dp)

                                //.heightIn(max = 150.dp)
                                .clickable { },
                            model = ImageRequest.Builder(context)
                                .data(link)
                                .crossfade(true)
                                .build(),
                            contentDescription = "Imagen de banner",
                            imageLoader = imageLoader,
                            placeholder = painterResource(R.drawable.greyfade),
                            error = painterResource(R.drawable.master),
                            contentScale = ContentScale.FillWidth,
                        )
                    }

                }
            }
            LazyRow(
                modifier = Modifier
                    // .height(80.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
                //     .height(140.dp),

            ) {

                items(listStampBanner) {
                    Spacer(modifier = Modifier.width(10.dp))

                    Box(
                        modifier = Modifier
                            .width(160.dp)
                            .height(85.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        AsyncImage(
                            modifier = Modifier
                                .fillMaxWidth()

                                .clickable { },
                            model = ImageRequest.Builder(context)
                                .data(it)
                                .crossfade(true)
                                .build(),
                            contentDescription = "Imagen de banner",
                            imageLoader = imageLoader,
                            placeholder = painterResource(R.drawable.greyfade),
                            error = painterResource(R.drawable.master),
                            contentScale = ContentScale.FillHeight, // Ajusta a Fit para no recortar
                            //  modifier = Modifier.fillMaxSize()
                        )
                    }
                    // val link = "https://www.apuestatotal.com${it.image}"


                }
            }
            LazyRow(
                modifier = Modifier
                    .height(120.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
                //     .height(140.dp),

            ) {

                items(listSponsorBanner) {
                    Spacer(modifier = Modifier.width(10.dp))

                    //  val link = "https://www.apuestatotal.com${it.bannerConfig.image}"
                    Image(
                        modifier = Modifier.fillMaxHeight(),
                        painter = painterResource(it),
                        contentDescription = ""
                    )
                    /*  AsyncImage(
                          modifier = Modifier
                              .widthIn(max = 200.dp)
                              .heightIn(max = 150.dp)
                              .clickable { },
                          model = ImageRequest.Builder(context)
                              .data(link)
                              .crossfade(true)
                              .build(),
                          contentDescription = "Imagen de banner",
                          imageLoader = imageLoader,
                          placeholder = painterResource(R.drawable.greyfade),
                          error = painterResource(R.drawable.master),
                          contentScale = ContentScale.Fit, // Ajusta a Fit para no recortar
                          //  modifier = Modifier.fillMaxSize()
                      )*/
                }
            }


        }

        /*Box(modifier = Modifier.fillMaxWidth()) {

            Image(painter = painterResource(R.drawable.greyfade), "")

            Column {


            }


        }*/

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(400.dp)
                .background(Grays.blackBackGround)
        ) {

        }


        /* Spacer(modifier = Modifier.height(10.dp))
         Text(
             modifier = Modifier.fillMaxWidth().padding(horizontal = 30.dp),
             text = buildAnnotatedString {
                 withStyle(style = SpanStyle(color = Secondary.RedSecondary, fontWeight = FontWeight.SemiBold)) {
                     append("Apuesta Total ¡Para ganar, hay que creer! ")
                 }
                 withStyle(style = SpanStyle(color = Primary.Black)) {
                     append("Juega y gana mientras disfrutas de tus deportes favoritos. Todas las ligas y eventos deportivos más importantes del mundo, los mejores mercados de apuestas y ofertas de cuotas, apuestas prematch y en vivo, juegos virtuales, casino online y en vivo, y mucho más.")
                 }
             },
             textAlign = TextAlign.Center,
             style = TextStyles.Body.textCard2
         )*/


    }

}

@Composable
fun TextoAnimado(textoMostrado: StateFlow<String>) {
    val texto = textoMostrado.collectAsState().value

    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier
                .padding(horizontal = 20.dp)
                .width(300.dp),
            painter = painterResource(R.drawable.ap_logo),
            contentDescription = "AT Logo"
        )

        Text(text = texto, style = TextStyles.Heading.h1)
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