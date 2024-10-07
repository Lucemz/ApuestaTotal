package com.at.apuestatotal.presentation.screens.betDetail.components

import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.at.apuestatotal.R
import com.at.apuestatotal.presentation.components.MCBaseTextField
import com.at.apuestatotal.presentation.ui.theme.TextStyles
import com.at.apuestatotal.presentation.utils.addOrRemove
import com.at.apuestatotal.presentation.utils.betAllMaperTitle
import com.example.ui.theme.Grays
import com.example.ui.theme.Primary
import com.example.ui.theme.Secondary

@Composable
fun BetHistoryContent(
    navHostController: NavHostController,
    paddingValues: PaddingValues,
    betHistoryViewModel: BetHistoryViewModel
) {

    val textfilter = betHistoryViewModel.textFilter
    var isFilterShow = betHistoryViewModel.isFilterShow
    Column(
        modifier = Modifier
            .padding(paddingValues)
            .fillMaxSize()
    ) {
        Row(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 35.dp, bottom = 20.dp)
        ) {

            Text(

                text = "Mis ",
                style = TextStyles.Heading.h1,
                color = Primary.Red
            )
            Text(

                text = "Apuestas",
                style = TextStyles.Heading.h1
            )
        }



        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp, horizontal = 20.dp)
        ) {
            MCBaseTextField(
                modifier = Modifier
                    .weight(1f)
                    .height(36.dp),
                hint = "Buscar",
                textValue = textfilter,
                onValueChange = {
                    betHistoryViewModel.textFilter = it
                    betHistoryViewModel.filterByText()
                },

                icon = painterResource(id = R.drawable.ic_search_outline),
                iconSize = 24.dp,
                trailingIcon = {
                    if (textfilter.isNotBlank()) {
                        Icon(imageVector = Icons.Default.Close,
                            contentDescription = "Eliminar texto de buscar cliente",
                            modifier = Modifier
                                .padding(end = 10.dp)
                                .clickable {
                                    betHistoryViewModel.textFilter = ""
                                    betHistoryViewModel.filterByText()
                                })
                    }
                },
                textFontFamily = FontFamily(Font(R.font.poppins)),
                textFontSize = 14.sp,
            )


            val cantItems = betHistoryViewModel.filtrosSeleccionados.size

            Row(
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    //.weight(1f)
                    .padding(start = 15.dp)
                    .height(36.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(color = if (isFilterShow) Primary.Red else Grays.Gray4)
                    .padding(horizontal = 7.dp)
                    .clickable {

                        if (cantItems > 0 ){
                            betHistoryViewModel.filtrosSeleccionados.clear()
                            betHistoryViewModel.filterByText()
                        }else{
                            betHistoryViewModel.isFilterShow = !betHistoryViewModel.isFilterShow
                        }

                    },
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {

                Icon(
                    painter = painterResource(R.drawable.baseline_filter_list_alt_24),
                    contentDescription = "",
                    tint = if (isFilterShow) Primary.White else Primary.Black
                )

                Text(
                    text = if (cantItems > 0) "Filtrar | $cantItems" else "Filtrar",
                    style = TextStyles.Button.text1,
                    color = if (isFilterShow) Primary.White else Primary.Black
                )
            }


        }


        Column(
            modifier = Modifier
                .fillMaxWidth()
                .animateContentSize()
        ) {
            AnimatedVisibility(
                visible = isFilterShow,
                enter = slideInVertically(initialOffsetY = { it }) + fadeIn(),
                exit = slideOutVertically(targetOffsetY = { it }) + fadeOut()
            ) {
                LazyRow(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding()
                ) {
                    items(betHistoryViewModel.listFiltros) {
                        Button(
                            contentPadding = PaddingValues(0.dp),
                            modifier = Modifier.padding(horizontal = 10.dp).height(30.dp).width(98.dp), shape = RoundedCornerShape(10.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = if (betHistoryViewModel.filtrosSeleccionados.contains(it))
                                    Secondary.RedSecondary
                                else
                                    Grays.Gray4
                            ),
                            content = {
                                Text(
                                    text = betAllMaperTitle(it),
                                    color = if (betHistoryViewModel.filtrosSeleccionados.contains(it))
                                        Primary.White
                                    else
                                        Primary.Black
                                )
                            },
                            onClick = {
                                betHistoryViewModel.filtrosSeleccionados.addOrRemove(it)
                                betHistoryViewModel.filterByText()
                            }
                        )
                    }
                }
            }
        }





        CardBetHistory(betHistoryViewModel.betHistoryListFiltered)


    }


}