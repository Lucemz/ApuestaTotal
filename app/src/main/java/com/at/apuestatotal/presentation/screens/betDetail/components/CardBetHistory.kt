package com.at.apuestatotal.presentation.screens.betDetail.components

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.combinedClickable
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
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.at.apuestatotal.R
import com.at.apuestatotal.domain.model.bet.BetDetailHistory
import com.at.apuestatotal.domain.model.bet.BetHistory
import com.at.apuestatotal.domain.model.bet.BetSelection
import com.at.apuestatotal.presentation.ui.theme.ApuestaTotalTheme
import com.at.apuestatotal.presentation.ui.theme.TextStyles
import com.at.apuestatotal.presentation.utils.OPEN
import com.at.apuestatotal.presentation.utils.betStatusMaperColor
import com.at.apuestatotal.presentation.utils.betStatusMaperTitle
import com.at.apuestatotal.presentation.utils.betTypeMaperTitle
import com.at.apuestatotal.presentation.utils.mapDate
import com.at.apuestatotal.presentation.utils.redondearString
import com.example.ui.theme.Grays
import com.example.ui.theme.Primary
import com.example.ui.theme.Secondary

const val TYPE1 = 1
const val TYPE2 = 2
const val TYPE3 = 3

@Composable
fun CardBetHistory(betList: List<BetHistory>) {


    LazyColumn(
        modifier = Modifier
            .animateContentSize()
            .fillMaxWidth()
            .padding(top = 10.dp, start = 15.dp, end = 15.dp)
            .clip(RoundedCornerShape(size = 15.dp))
            .background(Grays.Gray6)
            .padding(top = 10.dp, start = 10.dp, end = 10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(betList) { betHistory ->
            var estado by remember { mutableStateOf(TYPE1) }
            val colorEstado = betStatusMaperColor(betHistory.status)
            Card(
                modifier = Modifier
                    .width(328.dp)
                    .clip(RoundedCornerShape(size = 15.dp))
                    .border(
                        width = 1.dp,
                        color = colorEstado,
                        shape = RoundedCornerShape(size = 15.dp)
                    )
                    //.shadow(4.dp)
                    .background(Primary.White, shape = RoundedCornerShape(size = 15.dp))
                    .animateContentSize(),
                colors = CardDefaults.cardColors(containerColor = Primary.White),

                ) {


                when (estado) {
                    TYPE1 -> {
                        type1(
                            betHistory,
                            onClick = { estado = TYPE2 },
                            onLongClick = { estado = TYPE3 })
                    }

                    TYPE2 -> {
                        type2(
                            betHistory,
                            onClick = { estado = TYPE3 },
                            onClick2 = { estado = TYPE1 })
                    }

                    TYPE3 -> {
                        type3(
                            betHistory,
                            onClick = { estado = TYPE2 },
                            onLongClick = { estado = TYPE1 })
                    }
                }


            }

            VerticalDivider(modifier = Modifier.padding(vertical = 10.dp))


        }
    }


}


@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun type1(betHistory: BetHistory, onClick: () -> Unit, onLongClick: () -> Unit) {

    val colorEstado = betStatusMaperColor(betHistory.status)
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(67.dp)
            // .clip(RoundedCornerShape(size = 15.dp))
            .combinedClickable(onClick = { onClick() }, onLongClick = { onLongClick() })
            //.border(width = 1.dp, color = colorEstado, shape = RoundedCornerShape(size = 15.dp))
            //.shadow(4.dp)
            .background(Primary.White, shape = RoundedCornerShape(size = 15.dp)),

        ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Column(
                horizontalAlignment = Alignment.Start,
                modifier = Modifier
                    .weight(1.5f)
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.SpaceBetween
                //  .wrapContentWidth(),
            ) {
                Column(
                    modifier = Modifier
                        .wrapContentWidth()
                        .fillMaxHeight(),

                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = mapDate(betHistory.createdDate),
                        style = TextStyles.Body.textCard1,
                        color = colorEstado
                    )
                    Icon(
                        modifier = Modifier
                            .size(20.dp)
                            .clip(CircleShape)
                            .combinedClickable(
                                onClick = { onClick() },
                                onLongClick = { onLongClick() }),
                        painter = painterResource(R.drawable.ic_detail_mini),
                        contentDescription = ""
                    )
                }

            }

            Column(
                modifier = Modifier.weight(3f),
            ) {
                Text("Tipo", style = TextStyles.Body.textCard1, color = colorEstado)
                Spacer(modifier = Modifier.padding(vertical = 5.dp))
                Text(betTypeMaperTitle(betHistory.type), style = TextStyles.Card.title2)
            }
            Column(
                modifier = Modifier.weight(3f),
            ) {
                Text("Monto", style = TextStyles.Body.textCard1, color = colorEstado)
                Spacer(modifier = Modifier.padding(vertical = 5.dp))
                Text("S/${betHistory.wager.redondearString()}", style = TextStyles.Card.title2)
            }
            Column(
                modifier = Modifier.weight(3f),
            ) {
                Text("Ganancia", style = TextStyles.Body.textCard1, color = colorEstado)
                Spacer(modifier = Modifier.padding(vertical = 5.dp))
                Text("S/${betHistory.winning.redondearString()}", style = TextStyles.Card.title2)
            }

        }


    }
}

@Composable
private fun type2(betHistory: BetHistory, onClick: () -> Unit, onClick2: () -> Unit) {

    val colorEstado = betStatusMaperColor(betHistory.status)

    Box() {
        Icon(
            modifier = Modifier
                .padding(end = 10.dp, top = 14.dp)
                .rotate(180f)
                .size(20.dp)
                .clip(CircleShape)
                .align(Alignment.TopEnd)
                .clickable { onClick2() },
            tint = colorEstado,
            painter = painterResource(R.drawable.ic_detail_mini),
            contentDescription = ""
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()

        ) {


            Row(
                modifier = Modifier
                    .fillMaxWidth()

                    .padding(top = 15.dp, bottom = 6.dp, start = 15.dp, end = 15.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    modifier = Modifier.weight(2f),
                ) {
                    Text(
                        "Fecha y hora de creación",
                        style = TextStyles.Body.textCard1,
                        color = colorEstado
                    )
                    Text(mapDate(betHistory.createdDate, 2), style = TextStyles.Card.title2)
                }
                Column(
                    modifier = Modifier.weight(1f),
                ) {
                    Text("Monto", style = TextStyles.Body.textCard1, color = colorEstado)
                    Text("S/${betHistory.wager.redondearString()}", style = TextStyles.Card.title2)
                }

            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 6.dp, horizontal = 15.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    modifier = Modifier.weight(2f),
                ) {
                    Text("Tipo", style = TextStyles.Body.textCard1, color = colorEstado)
                    Text(betTypeMaperTitle(betHistory.type), style = TextStyles.Card.title2)
                }
                Column(
                    modifier = Modifier.weight(1f),
                ) {
                    Text("Cuota", style = TextStyles.Body.textCard1, color = colorEstado)
                    Text(betHistory.odds.redondearString(), style = TextStyles.Card.title2)
                }

            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 6.dp, horizontal = 15.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    modifier = Modifier.weight(2f),
                ) {
                    Text("Resultado", style = TextStyles.Body.textCard1, color = colorEstado)
                    Text(betStatusMaperTitle(betHistory.status), style = TextStyles.Card.title2)
                }

                Column(
                    modifier = Modifier.weight(1f),
                ) {
                    Text("Ganancia", style = TextStyles.Body.textCard1, color = colorEstado)
                    Text(
                        "S/${betHistory.winning.redondearString()}",
                        style = TextStyles.Card.title2
                    )
                }


            }

            Button(
                modifier = Modifier
                    .padding(start = 15.dp, top = 11.dp, bottom = 20.dp)
                    .width(89.dp)
                    .height(20.dp),
                contentPadding = PaddingValues(0.dp),
                content = {
                    Icon(
                        modifier = Modifier,
                        painter = painterResource(R.drawable.ic_detail_mini),
                        contentDescription = ""
                    )
                    Text("ver mas", style = TextStyles.Card.subtitle2)
                },
                onClick = { onClick() },
                colors = ButtonDefaults.buttonColors(colorEstado)
            )

        }
    }


}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun type3(
    betHistory: BetHistory,
    onClick: () -> Unit,
    onLongClick: () -> Unit
) {

    val colorEstado = betStatusMaperColor(betHistory.status)
    //val colorTexto = if (betHistory.status == OPEN) Primary.Black else Primary.White


    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Primary.White, shape = RoundedCornerShape(size = 15.dp)),

        ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(42.dp)
                .background(colorEstado),
            contentAlignment = Alignment.Center
        ) {
            Text(
                modifier = Modifier,
                text = betHistory.game,
                style = TextStyles.Card.title1,
                color = Primary.White,
                textAlign = TextAlign.Center,
            )

        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 15.dp, bottom = 6.dp, start = 15.dp, end = 15.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.weight(2f),
            ) {
                Text(
                    "Fecha y hora de creación",
                    style = TextStyles.Body.textCard1,
                    color = colorEstado
                )
                Text(mapDate(betHistory.createdDate, 2), style = TextStyles.Card.title2)
            }
            Column(
                modifier = Modifier.weight(1f),
            ) {
                Text("Monto", style = TextStyles.Body.textCard1, color = colorEstado)
                Text("S/${betHistory.wager.redondearString()}", style = TextStyles.Card.title2)
            }

        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 6.dp, horizontal = 15.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.weight(2f),
            ) {
                Text("Tipo", style = TextStyles.Body.textCard1, color = colorEstado)
                Text(betTypeMaperTitle(betHistory.type), style = TextStyles.Card.title2)
            }
            Column(
                modifier = Modifier.weight(1f),
            ) {
                Text("Cuota", style = TextStyles.Body.textCard1, color = colorEstado)
                Text(betHistory.odds.redondearString(), style = TextStyles.Card.title2)
            }

        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 6.dp, horizontal = 15.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.weight(2f),
            ) {
                Text("Resultado", style = TextStyles.Body.textCard1, color = colorEstado)
                Text(text = betStatusMaperTitle(betHistory.status), style = TextStyles.Card.title2)
            }

            Column(
                modifier = Modifier.weight(1f),
            ) {
                Text("Ganancia", style = TextStyles.Body.textCard1, color = colorEstado)
                Text("S/${betHistory.winning.redondearString()}", style = TextStyles.Card.title2)
            }


        }
        val betDetailHistory = betHistory.betDetails.getOrNull(0)
        Card(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .width(304.dp)
                .heightIn(max = 1800.dp)
                .clip(RoundedCornerShape(size = 15.dp))
                //.shadow(4.dp)
                .background(Primary.White, shape = RoundedCornerShape(size = 13.dp)),
            colors = CardDefaults.cardColors(containerColor = colorEstado.copy(alpha = 0.2f)),

            ) {

            betDetailHistory?.betSelections?.forEachIndexed() { index, item ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Primary.Black.copy(if (index % 2 == 0) 0.05f else 0.1f))
                        .padding(15.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column(modifier = Modifier.weight(1f)) {
                        Text(text = item.eventName, style = TextStyles.Card.subtitle2)
                        Text(
                            modifier = Modifier.padding(top = 10.dp),
                            text = item.name,
                            style = TextStyles.Body.textCard2
                        )
                        Text(
                            modifier = Modifier.padding(top = 7.dp),
                            text = item.marketName,
                            style = TextStyles.Body.textCard2
                        )
                        Text(
                            modifier = Modifier.padding(top = 7.dp),
                            text = item.eventDate,
                            style = TextStyles.Body.textCard2
                        )
                    }

                    Text(
                        modifier = Modifier.align(Alignment.CenterVertically),
                        text = item.price,
                        style = TextStyles.Card.subtitle1
                    )


                }

            }


        }
        Row(
            modifier = Modifier
                .padding(top = 15.dp, bottom = 25.dp)
                .fillMaxWidth(),

            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            /*    Button(
                    modifier = Modifier
                        // .weight(1.5f)
                        .align(Alignment.CenterVertically)
                        .padding(start = 15.dp, end = 30.dp)
                        .width(89.dp)
                        .height(20.dp),
                    contentPadding = PaddingValues(0.dp),
                    content = {

                    },
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(containerColor = colorEstado)
                )*/

            Row(
                modifier = Modifier
                    // .weight(1.5f)
                    .align(Alignment.CenterVertically)

                    .padding(start = 15.dp, end = 30.dp)
                    .width(89.dp)
                    .height(20.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .border(width = 1.dp, colorEstado, RoundedCornerShape(12.dp))
                    .background(color = Color.Transparent)

                    .combinedClickable(onClick = { onClick() }, onLongClick = { onLongClick() }
                    ),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {

                Icon(
                    modifier = Modifier.rotate(180f),
                    painter = painterResource(R.drawable.ic_detail_mini),
                    contentDescription = "",
                    tint = colorEstado
                )
                Text("ver menos", style = TextStyles.Card.subtitle2, color = colorEstado)
            }

            Column(modifier = Modifier.weight(1f)) {

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    Text(
                        modifier = Modifier.weight(1f),
                        text = "Monto Total",
                        style = TextStyles.Card.subtitle2
                    )
                    Text(
                        modifier = Modifier.weight(1f),
                        text = "${betDetailHistory?.totalStake} PEN",
                        style = TextStyles.Card.subtitle2,
                        textAlign = TextAlign.Start
                    )
                }
                Spacer(modifier = Modifier.padding(top = 13.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    Text(
                        modifier = Modifier.weight(1f),
                        text = "Ganancia Total",
                        style = TextStyles.Card.subtitle2
                    )
                    Text(
                        modifier = Modifier.weight(1f),
                        text = "${betDetailHistory?.totalWin} PEN",
                        style = TextStyles.Card.subtitle2,
                        textAlign = TextAlign.Start
                    )
                }


            }

        }
        if (betHistory.status == OPEN) {
            Button(
                modifier = Modifier
                    .padding(bottom = 25.dp)
                    .size(246.dp, 35.dp)
                    .align(Alignment.CenterHorizontally),
                content = {
                    Text(
                        "Cashout ${betDetailHistory?.cashoutValue} PEN ",
                        style = TextStyles.Button.text2,
                        color = Primary.White
                    )
                },
                onClick = {},
                colors = ButtonDefaults.buttonColors(containerColor = Secondary.RedSecondary)
            )
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
            CardBetHistory(betListHistory)//rememberNavController(), PaddingValues()) }

        }
    }

}

val betListHistory = listOf(
    BetHistory(
        db = 10,
        operation = 881854983,
        game = "2988647419",
        createdDate = "2024-09-24 15:39:55",
        status = "OPEN",
        wager = 1000.00,
        winning = 0.00,
        odds = 15.1799,
        type = "SYSTEM",
        account = "CASH",
        betDetails = mutableListOf(
            BetDetailHistory(
                betNivel = "Donatelo",
                betStarts = 0,
                betStatusName = "Abierto",
                betTypeName = "System",
                bgSrc = "/_next/static/media/cazafijas.47b1d146.jpg",
                cashoutOdds = "0.00",
                totalOdds = "0.00",
                totalStake = "10.00",
                totalWin = "70.61",
                cashoutValue = "4.21",
                createdDate = "2024-09-24 10:39",
                betSelections = listOf(
                    BetSelection(
                        selectionId = 1811160742,
                        selectionStatus = 0,
                        price = "1.23",
                        name = "Real Madrid",
                        spec = "",
                        marketTypeId = 1,
                        marketId = 775746628,
                        marketName = "1x2",
                        isLive = false,
                        isBetBuilder = false,
                        isBanker = false,
                        isVirtual = false,
                        bbSelections = null,
                        eventId = 9996710,
                        eventCode = null,
                        feedEventId = 10390066,
                        eventName = "Real Madrid vs. Alavés",
                        sportTypeId = 1,
                        categoryId = 501,
                        categoryName = null,
                        champId = 2941,
                        champName = null,
                        eventScore = null,
                        gameTime = null,
                        eventDate = "2024-09-24 14:00",
                        pitcherInfo = null,
                        runners = null,
                        extraEventInfo = null,
                        rc = false,
                        liveInfoAtEventMinute = null,
                        isLiveOrVirtual = false,
                        earlyPayout = true,
                        boreDraw = false,
                        deadHeatFactor = null,
                        dbId = 10
                    ),
                    BetSelection(
                        selectionId = 1811160963,
                        selectionStatus = 0,
                        price = "1.20",
                        name = "Real Madrid",
                        spec = "{\"9\":\"1\"}",
                        marketTypeId = 8,
                        marketId = 775746692,
                        marketName = "Primer gol",
                        isLive = false,
                        isBetBuilder = false,
                        isBanker = false,
                        isVirtual = false,
                        bbSelections = null,
                        eventId = 9996710,
                        eventCode = null,
                        feedEventId = 10390066,
                        eventName = "Real Madrid vs. Alavés",
                        sportTypeId = 1,
                        categoryId = 501,
                        categoryName = null,
                        champId = 2941,
                        champName = null,
                        eventScore = null,
                        gameTime = null,
                        eventDate = "2024-09-24 14:00",
                        pitcherInfo = null,
                        runners = null,
                        extraEventInfo = null,
                        rc = false,
                        liveInfoAtEventMinute = null,
                        isLiveOrVirtual = false,
                        earlyPayout = false,
                        boreDraw = false,
                        deadHeatFactor = null,
                        dbId = 10
                    ),
                    BetSelection(
                        selectionId = 1811160615,
                        selectionStatus = 0,
                        price = "2.10",
                        name = "Sí",
                        spec = "",
                        marketTypeId = 29,
                        marketId = 775746608,
                        marketName = "Ambos equipos marcan",
                        isLive = false,
                        isBetBuilder = false,
                        isBanker = false,
                        isVirtual = false,
                        bbSelections = null,
                        eventId = 9996710,
                        eventCode = null,
                        feedEventId = 10390066,
                        eventName = "Real Madrid vs. Alavés",
                        sportTypeId = 1,
                        categoryId = 501,
                        categoryName = null,
                        champId = 2941,
                        champName = null,
                        eventScore = null,
                        gameTime = null,
                        eventDate = "2024-09-24 14:00",
                        pitcherInfo = null,
                        runners = null,
                        extraEventInfo = null,
                        rc = false,
                        liveInfoAtEventMinute = null,
                        isLiveOrVirtual = false,
                        earlyPayout = false,
                        boreDraw = false,
                        deadHeatFactor = null,
                        dbId = 10
                    )
                ),
                betStatus = 0,
                betType = 2,
                betId = 2988647419
            )
        )
    ), BetHistory(
        db = 10,
        operation = 881854983,
        game = "2988647419",
        createdDate = "2024-09-24 15:39:55",
        status = "WON",
        wager = 1000.00,
        winning = 0.00,
        odds = 15.1799,
        type = "SYSTEM",
        account = "CASH",
        betDetails = mutableListOf(
            BetDetailHistory(
                betNivel = "Donatelo",
                betStarts = 0,
                betStatusName = "Abierto",
                betTypeName = "System",
                bgSrc = "/_next/static/media/cazafijas.47b1d146.jpg",
                cashoutOdds = "0.00",
                totalOdds = "0.00",
                totalStake = "10.00",
                totalWin = "70.61",
                cashoutValue = "4.21",
                createdDate = "2024-09-24 10:39",
                betSelections = listOf(
                    BetSelection(
                        selectionId = 1811160742,
                        selectionStatus = 0,
                        price = "1.23",
                        name = "Real Madrid",
                        spec = "",
                        marketTypeId = 1,
                        marketId = 775746628,
                        marketName = "1x2",
                        isLive = false,
                        isBetBuilder = false,
                        isBanker = false,
                        isVirtual = false,
                        bbSelections = null,
                        eventId = 9996710,
                        eventCode = null,
                        feedEventId = 10390066,
                        eventName = "Real Madrid vs. Alavés",
                        sportTypeId = 1,
                        categoryId = 501,
                        categoryName = null,
                        champId = 2941,
                        champName = null,
                        eventScore = null,
                        gameTime = null,
                        eventDate = "2024-09-24 14:00",
                        pitcherInfo = null,
                        runners = null,
                        extraEventInfo = null,
                        rc = false,
                        liveInfoAtEventMinute = null,
                        isLiveOrVirtual = false,
                        earlyPayout = true,
                        boreDraw = false,
                        deadHeatFactor = null,
                        dbId = 10
                    ),
                    BetSelection(
                        selectionId = 1811160963,
                        selectionStatus = 0,
                        price = "1.20",
                        name = "Real Madrid",
                        spec = "{\"9\":\"1\"}",
                        marketTypeId = 8,
                        marketId = 775746692,
                        marketName = "Primer gol",
                        isLive = false,
                        isBetBuilder = false,
                        isBanker = false,
                        isVirtual = false,
                        bbSelections = null,
                        eventId = 9996710,
                        eventCode = null,
                        feedEventId = 10390066,
                        eventName = "Real Madrid vs. Alavés",
                        sportTypeId = 1,
                        categoryId = 501,
                        categoryName = null,
                        champId = 2941,
                        champName = null,
                        eventScore = null,
                        gameTime = null,
                        eventDate = "2024-09-24 14:00",
                        pitcherInfo = null,
                        runners = null,
                        extraEventInfo = null,
                        rc = false,
                        liveInfoAtEventMinute = null,
                        isLiveOrVirtual = false,
                        earlyPayout = false,
                        boreDraw = false,
                        deadHeatFactor = null,
                        dbId = 10
                    ),
                    BetSelection(
                        selectionId = 1811160615,
                        selectionStatus = 0,
                        price = "2.10",
                        name = "Sí",
                        spec = "",
                        marketTypeId = 29,
                        marketId = 775746608,
                        marketName = "Ambos equipos marcan",
                        isLive = false,
                        isBetBuilder = false,
                        isBanker = false,
                        isVirtual = false,
                        bbSelections = null,
                        eventId = 9996710,
                        eventCode = null,
                        feedEventId = 10390066,
                        eventName = "Real Madrid vs. Alavés",
                        sportTypeId = 1,
                        categoryId = 501,
                        categoryName = null,
                        champId = 2941,
                        champName = null,
                        eventScore = null,
                        gameTime = null,
                        eventDate = "2024-09-24 14:00",
                        pitcherInfo = null,
                        runners = null,
                        extraEventInfo = null,
                        rc = false,
                        liveInfoAtEventMinute = null,
                        isLiveOrVirtual = false,
                        earlyPayout = false,
                        boreDraw = false,
                        deadHeatFactor = null,
                        dbId = 10
                    )
                ),
                betStatus = 0,
                betType = 2,
                betId = 2988647419
            )
        )
    ), BetHistory(
        db = 10,
        operation = 881854983,
        game = "2988647419",
        createdDate = "2024-09-24 15:39:55",
        status = "CASHOUT",
        wager = 1000.00,
        winning = 0.00,
        odds = 15.1799,
        type = "SYSTEM",
        account = "CASH",
        betDetails = mutableListOf(
            BetDetailHistory(
                betNivel = "Donatelo",
                betStarts = 0,
                betStatusName = "Abierto",
                betTypeName = "System",
                bgSrc = "/_next/static/media/cazafijas.47b1d146.jpg",
                cashoutOdds = "0.00",
                totalOdds = "0.00",
                totalStake = "10.00",
                totalWin = "70.61",
                cashoutValue = "4.21",
                createdDate = "2024-09-24 10:39",
                betSelections = listOf(
                    BetSelection(
                        selectionId = 1811160742,
                        selectionStatus = 0,
                        price = "1.23",
                        name = "Real Madrid",
                        spec = "",
                        marketTypeId = 1,
                        marketId = 775746628,
                        marketName = "1x2",
                        isLive = false,
                        isBetBuilder = false,
                        isBanker = false,
                        isVirtual = false,
                        bbSelections = null,
                        eventId = 9996710,
                        eventCode = null,
                        feedEventId = 10390066,
                        eventName = "Real Madrid vs. Alavés",
                        sportTypeId = 1,
                        categoryId = 501,
                        categoryName = null,
                        champId = 2941,
                        champName = null,
                        eventScore = null,
                        gameTime = null,
                        eventDate = "2024-09-24 14:00",
                        pitcherInfo = null,
                        runners = null,
                        extraEventInfo = null,
                        rc = false,
                        liveInfoAtEventMinute = null,
                        isLiveOrVirtual = false,
                        earlyPayout = true,
                        boreDraw = false,
                        deadHeatFactor = null,
                        dbId = 10
                    ),
                    BetSelection(
                        selectionId = 1811160963,
                        selectionStatus = 0,
                        price = "1.20",
                        name = "Real Madrid",
                        spec = "{\"9\":\"1\"}",
                        marketTypeId = 8,
                        marketId = 775746692,
                        marketName = "Primer gol",
                        isLive = false,
                        isBetBuilder = false,
                        isBanker = false,
                        isVirtual = false,
                        bbSelections = null,
                        eventId = 9996710,
                        eventCode = null,
                        feedEventId = 10390066,
                        eventName = "Real Madrid vs. Alavés",
                        sportTypeId = 1,
                        categoryId = 501,
                        categoryName = null,
                        champId = 2941,
                        champName = null,
                        eventScore = null,
                        gameTime = null,
                        eventDate = "2024-09-24 14:00",
                        pitcherInfo = null,
                        runners = null,
                        extraEventInfo = null,
                        rc = false,
                        liveInfoAtEventMinute = null,
                        isLiveOrVirtual = false,
                        earlyPayout = false,
                        boreDraw = false,
                        deadHeatFactor = null,
                        dbId = 10
                    ),
                    BetSelection(
                        selectionId = 1811160615,
                        selectionStatus = 0,
                        price = "2.10",
                        name = "Sí",
                        spec = "",
                        marketTypeId = 29,
                        marketId = 775746608,
                        marketName = "Ambos equipos marcan",
                        isLive = false,
                        isBetBuilder = false,
                        isBanker = false,
                        isVirtual = false,
                        bbSelections = null,
                        eventId = 9996710,
                        eventCode = null,
                        feedEventId = 10390066,
                        eventName = "Real Madrid vs. Alavés",
                        sportTypeId = 1,
                        categoryId = 501,
                        categoryName = null,
                        champId = 2941,
                        champName = null,
                        eventScore = null,
                        gameTime = null,
                        eventDate = "2024-09-24 14:00",
                        pitcherInfo = null,
                        runners = null,
                        extraEventInfo = null,
                        rc = false,
                        liveInfoAtEventMinute = null,
                        isLiveOrVirtual = false,
                        earlyPayout = false,
                        boreDraw = false,
                        deadHeatFactor = null,
                        dbId = 10
                    )
                ),
                betStatus = 0,
                betType = 2,
                betId = 2988647419
            )
        )
    ), BetHistory(
        db = 10,
        operation = 881854983,
        game = "2988647419",
        createdDate = "2024-09-24 15:39:55",
        status = "LOST",
        wager = 1000.00,
        winning = 0.00,
        odds = 15.1799,
        type = "SYSTEM",
        account = "CASH",
        betDetails = mutableListOf(
            BetDetailHistory(
                betNivel = "Donatelo",
                betStarts = 0,
                betStatusName = "Abierto",
                betTypeName = "System",
                bgSrc = "/_next/static/media/cazafijas.47b1d146.jpg",
                cashoutOdds = "0.00",
                totalOdds = "0.00",
                totalStake = "10.00",
                totalWin = "70.61",
                cashoutValue = "4.21",
                createdDate = "2024-09-24 10:39",
                betSelections = listOf(
                    BetSelection(
                        selectionId = 1811160742,
                        selectionStatus = 0,
                        price = "1.23",
                        name = "Real Madrid",
                        spec = "",
                        marketTypeId = 1,
                        marketId = 775746628,
                        marketName = "1x2",
                        isLive = false,
                        isBetBuilder = false,
                        isBanker = false,
                        isVirtual = false,
                        bbSelections = null,
                        eventId = 9996710,
                        eventCode = null,
                        feedEventId = 10390066,
                        eventName = "Real Madrid vs. Alavés",
                        sportTypeId = 1,
                        categoryId = 501,
                        categoryName = null,
                        champId = 2941,
                        champName = null,
                        eventScore = null,
                        gameTime = null,
                        eventDate = "2024-09-24 14:00",
                        pitcherInfo = null,
                        runners = null,
                        extraEventInfo = null,
                        rc = false,
                        liveInfoAtEventMinute = null,
                        isLiveOrVirtual = false,
                        earlyPayout = true,
                        boreDraw = false,
                        deadHeatFactor = null,
                        dbId = 10
                    ),
                    BetSelection(
                        selectionId = 1811160963,
                        selectionStatus = 0,
                        price = "1.20",
                        name = "Real Madrid",
                        spec = "{\"9\":\"1\"}",
                        marketTypeId = 8,
                        marketId = 775746692,
                        marketName = "Primer gol",
                        isLive = false,
                        isBetBuilder = false,
                        isBanker = false,
                        isVirtual = false,
                        bbSelections = null,
                        eventId = 9996710,
                        eventCode = null,
                        feedEventId = 10390066,
                        eventName = "Real Madrid vs. Alavés",
                        sportTypeId = 1,
                        categoryId = 501,
                        categoryName = null,
                        champId = 2941,
                        champName = null,
                        eventScore = null,
                        gameTime = null,
                        eventDate = "2024-09-24 14:00",
                        pitcherInfo = null,
                        runners = null,
                        extraEventInfo = null,
                        rc = false,
                        liveInfoAtEventMinute = null,
                        isLiveOrVirtual = false,
                        earlyPayout = false,
                        boreDraw = false,
                        deadHeatFactor = null,
                        dbId = 10
                    ),
                    BetSelection(
                        selectionId = 1811160615,
                        selectionStatus = 0,
                        price = "2.10",
                        name = "Sí",
                        spec = "",
                        marketTypeId = 29,
                        marketId = 775746608,
                        marketName = "Ambos equipos marcan",
                        isLive = false,
                        isBetBuilder = false,
                        isBanker = false,
                        isVirtual = false,
                        bbSelections = null,
                        eventId = 9996710,
                        eventCode = null,
                        feedEventId = 10390066,
                        eventName = "Real Madrid vs. Alavés",
                        sportTypeId = 1,
                        categoryId = 501,
                        categoryName = null,
                        champId = 2941,
                        champName = null,
                        eventScore = null,
                        gameTime = null,
                        eventDate = "2024-09-24 14:00",
                        pitcherInfo = null,
                        runners = null,
                        extraEventInfo = null,
                        rc = false,
                        liveInfoAtEventMinute = null,
                        isLiveOrVirtual = false,
                        earlyPayout = false,
                        boreDraw = false,
                        deadHeatFactor = null,
                        dbId = 10
                    )
                ),
                betStatus = 0,
                betType = 2,
                betId = 2988647419
            )
        )
    ), BetHistory(
        db = 10,
        operation = 881854983,
        game = "2988647419",
        createdDate = "2024-09-24 15:39:55",
        status = "WON",
        wager = 1000.00,
        winning = 0.00,
        odds = 15.1799,
        type = "SYSTEM",
        account = "CASH",
        betDetails = mutableListOf(
            BetDetailHistory(
                betNivel = "Donatelo",
                betStarts = 0,
                betStatusName = "Abierto",
                betTypeName = "System",
                bgSrc = "/_next/static/media/cazafijas.47b1d146.jpg",
                cashoutOdds = "0.00",
                totalOdds = "0.00",
                totalStake = "10.00",
                totalWin = "70.61",
                cashoutValue = "4.21",
                createdDate = "2024-09-24 10:39",
                betSelections = listOf(
                    BetSelection(
                        selectionId = 1811160742,
                        selectionStatus = 0,
                        price = "1.23",
                        name = "Real Madrid",
                        spec = "",
                        marketTypeId = 1,
                        marketId = 775746628,
                        marketName = "1x2",
                        isLive = false,
                        isBetBuilder = false,
                        isBanker = false,
                        isVirtual = false,
                        bbSelections = null,
                        eventId = 9996710,
                        eventCode = null,
                        feedEventId = 10390066,
                        eventName = "Real Madrid vs. Alavés",
                        sportTypeId = 1,
                        categoryId = 501,
                        categoryName = null,
                        champId = 2941,
                        champName = null,
                        eventScore = null,
                        gameTime = null,
                        eventDate = "2024-09-24 14:00",
                        pitcherInfo = null,
                        runners = null,
                        extraEventInfo = null,
                        rc = false,
                        liveInfoAtEventMinute = null,
                        isLiveOrVirtual = false,
                        earlyPayout = true,
                        boreDraw = false,
                        deadHeatFactor = null,
                        dbId = 10
                    ),
                    BetSelection(
                        selectionId = 1811160963,
                        selectionStatus = 0,
                        price = "1.20",
                        name = "Real Madrid",
                        spec = "{\"9\":\"1\"}",
                        marketTypeId = 8,
                        marketId = 775746692,
                        marketName = "Primer gol",
                        isLive = false,
                        isBetBuilder = false,
                        isBanker = false,
                        isVirtual = false,
                        bbSelections = null,
                        eventId = 9996710,
                        eventCode = null,
                        feedEventId = 10390066,
                        eventName = "Real Madrid vs. Alavés",
                        sportTypeId = 1,
                        categoryId = 501,
                        categoryName = null,
                        champId = 2941,
                        champName = null,
                        eventScore = null,
                        gameTime = null,
                        eventDate = "2024-09-24 14:00",
                        pitcherInfo = null,
                        runners = null,
                        extraEventInfo = null,
                        rc = false,
                        liveInfoAtEventMinute = null,
                        isLiveOrVirtual = false,
                        earlyPayout = false,
                        boreDraw = false,
                        deadHeatFactor = null,
                        dbId = 10
                    ),
                    BetSelection(
                        selectionId = 1811160615,
                        selectionStatus = 0,
                        price = "2.10",
                        name = "Sí",
                        spec = "",
                        marketTypeId = 29,
                        marketId = 775746608,
                        marketName = "Ambos equipos marcan",
                        isLive = false,
                        isBetBuilder = false,
                        isBanker = false,
                        isVirtual = false,
                        bbSelections = null,
                        eventId = 9996710,
                        eventCode = null,
                        feedEventId = 10390066,
                        eventName = "Real Madrid vs. Alavés",
                        sportTypeId = 1,
                        categoryId = 501,
                        categoryName = null,
                        champId = 2941,
                        champName = null,
                        eventScore = null,
                        gameTime = null,
                        eventDate = "2024-09-24 14:00",
                        pitcherInfo = null,
                        runners = null,
                        extraEventInfo = null,
                        rc = false,
                        liveInfoAtEventMinute = null,
                        isLiveOrVirtual = false,
                        earlyPayout = false,
                        boreDraw = false,
                        deadHeatFactor = null,
                        dbId = 10
                    )
                ),
                betStatus = 0,
                betType = 2,
                betId = 2988647419
            )
        )
    ), BetHistory(
        db = 10,
        operation = 881854983,
        game = "2988647419",
        createdDate = "2024-09-24 15:39:55",
        status = "WON",
        wager = 1000.00,
        winning = 0.00,
        odds = 15.1799,
        type = "SYSTEM",
        account = "CASH",
        betDetails = mutableListOf(
            BetDetailHistory(
                betNivel = "Donatelo",
                betStarts = 0,
                betStatusName = "Abierto",
                betTypeName = "System",
                bgSrc = "/_next/static/media/cazafijas.47b1d146.jpg",
                cashoutOdds = "0.00",
                totalOdds = "0.00",
                totalStake = "10.00",
                totalWin = "70.61",
                cashoutValue = "4.21",
                createdDate = "2024-09-24 10:39",
                betSelections = listOf(
                    BetSelection(
                        selectionId = 1811160742,
                        selectionStatus = 0,
                        price = "1.23",
                        name = "Real Madrid",
                        spec = "",
                        marketTypeId = 1,
                        marketId = 775746628,
                        marketName = "1x2",
                        isLive = false,
                        isBetBuilder = false,
                        isBanker = false,
                        isVirtual = false,
                        bbSelections = null,
                        eventId = 9996710,
                        eventCode = null,
                        feedEventId = 10390066,
                        eventName = "Real Madrid vs. Alavés",
                        sportTypeId = 1,
                        categoryId = 501,
                        categoryName = null,
                        champId = 2941,
                        champName = null,
                        eventScore = null,
                        gameTime = null,
                        eventDate = "2024-09-24 14:00",
                        pitcherInfo = null,
                        runners = null,
                        extraEventInfo = null,
                        rc = false,
                        liveInfoAtEventMinute = null,
                        isLiveOrVirtual = false,
                        earlyPayout = true,
                        boreDraw = false,
                        deadHeatFactor = null,
                        dbId = 10
                    ),
                    BetSelection(
                        selectionId = 1811160963,
                        selectionStatus = 0,
                        price = "1.20",
                        name = "Real Madrid",
                        spec = "{\"9\":\"1\"}",
                        marketTypeId = 8,
                        marketId = 775746692,
                        marketName = "Primer gol",
                        isLive = false,
                        isBetBuilder = false,
                        isBanker = false,
                        isVirtual = false,
                        bbSelections = null,
                        eventId = 9996710,
                        eventCode = null,
                        feedEventId = 10390066,
                        eventName = "Real Madrid vs. Alavés",
                        sportTypeId = 1,
                        categoryId = 501,
                        categoryName = null,
                        champId = 2941,
                        champName = null,
                        eventScore = null,
                        gameTime = null,
                        eventDate = "2024-09-24 14:00",
                        pitcherInfo = null,
                        runners = null,
                        extraEventInfo = null,
                        rc = false,
                        liveInfoAtEventMinute = null,
                        isLiveOrVirtual = false,
                        earlyPayout = false,
                        boreDraw = false,
                        deadHeatFactor = null,
                        dbId = 10
                    ),
                    BetSelection(
                        selectionId = 1811160615,
                        selectionStatus = 0,
                        price = "2.10",
                        name = "Sí",
                        spec = "",
                        marketTypeId = 29,
                        marketId = 775746608,
                        marketName = "Ambos equipos marcan",
                        isLive = false,
                        isBetBuilder = false,
                        isBanker = false,
                        isVirtual = false,
                        bbSelections = null,
                        eventId = 9996710,
                        eventCode = null,
                        feedEventId = 10390066,
                        eventName = "Real Madrid vs. Alavés",
                        sportTypeId = 1,
                        categoryId = 501,
                        categoryName = null,
                        champId = 2941,
                        champName = null,
                        eventScore = null,
                        gameTime = null,
                        eventDate = "2024-09-24 14:00",
                        pitcherInfo = null,
                        runners = null,
                        extraEventInfo = null,
                        rc = false,
                        liveInfoAtEventMinute = null,
                        isLiveOrVirtual = false,
                        earlyPayout = false,
                        boreDraw = false,
                        deadHeatFactor = null,
                        dbId = 10
                    )
                ),
                betStatus = 0,
                betType = 2,
                betId = 2988647419
            )
        )
    ), BetHistory(
        db = 10,
        operation = 881854983,
        game = "2988647419",
        createdDate = "2024-09-24 15:39:55",
        status = "LOST",
        wager = 1000.00,
        winning = 0.00,
        odds = 15.1799,
        type = "SYSTEM",
        account = "CASH",
        betDetails = mutableListOf(
            BetDetailHistory(
                betNivel = "Donatelo",
                betStarts = 0,
                betStatusName = "Abierto",
                betTypeName = "System",
                bgSrc = "/_next/static/media/cazafijas.47b1d146.jpg",
                cashoutOdds = "0.00",
                totalOdds = "0.00",
                totalStake = "10.00",
                totalWin = "70.61",
                cashoutValue = "4.21",
                createdDate = "2024-09-24 10:39",
                betSelections = listOf(
                    BetSelection(
                        selectionId = 1811160742,
                        selectionStatus = 0,
                        price = "1.23",
                        name = "Real Madrid",
                        spec = "",
                        marketTypeId = 1,
                        marketId = 775746628,
                        marketName = "1x2",
                        isLive = false,
                        isBetBuilder = false,
                        isBanker = false,
                        isVirtual = false,
                        bbSelections = null,
                        eventId = 9996710,
                        eventCode = null,
                        feedEventId = 10390066,
                        eventName = "Real Madrid vs. Alavés",
                        sportTypeId = 1,
                        categoryId = 501,
                        categoryName = null,
                        champId = 2941,
                        champName = null,
                        eventScore = null,
                        gameTime = null,
                        eventDate = "2024-09-24 14:00",
                        pitcherInfo = null,
                        runners = null,
                        extraEventInfo = null,
                        rc = false,
                        liveInfoAtEventMinute = null,
                        isLiveOrVirtual = false,
                        earlyPayout = true,
                        boreDraw = false,
                        deadHeatFactor = null,
                        dbId = 10
                    ),
                    BetSelection(
                        selectionId = 1811160963,
                        selectionStatus = 0,
                        price = "1.20",
                        name = "Real Madrid",
                        spec = "{\"9\":\"1\"}",
                        marketTypeId = 8,
                        marketId = 775746692,
                        marketName = "Primer gol",
                        isLive = false,
                        isBetBuilder = false,
                        isBanker = false,
                        isVirtual = false,
                        bbSelections = null,
                        eventId = 9996710,
                        eventCode = null,
                        feedEventId = 10390066,
                        eventName = "Real Madrid vs. Alavés",
                        sportTypeId = 1,
                        categoryId = 501,
                        categoryName = null,
                        champId = 2941,
                        champName = null,
                        eventScore = null,
                        gameTime = null,
                        eventDate = "2024-09-24 14:00",
                        pitcherInfo = null,
                        runners = null,
                        extraEventInfo = null,
                        rc = false,
                        liveInfoAtEventMinute = null,
                        isLiveOrVirtual = false,
                        earlyPayout = false,
                        boreDraw = false,
                        deadHeatFactor = null,
                        dbId = 10
                    ),
                    BetSelection(
                        selectionId = 1811160615,
                        selectionStatus = 0,
                        price = "2.10",
                        name = "Sí",
                        spec = "",
                        marketTypeId = 29,
                        marketId = 775746608,
                        marketName = "Ambos equipos marcan",
                        isLive = false,
                        isBetBuilder = false,
                        isBanker = false,
                        isVirtual = false,
                        bbSelections = null,
                        eventId = 9996710,
                        eventCode = null,
                        feedEventId = 10390066,
                        eventName = "Real Madrid vs. Alavés",
                        sportTypeId = 1,
                        categoryId = 501,
                        categoryName = null,
                        champId = 2941,
                        champName = null,
                        eventScore = null,
                        gameTime = null,
                        eventDate = "2024-09-24 14:00",
                        pitcherInfo = null,
                        runners = null,
                        extraEventInfo = null,
                        rc = false,
                        liveInfoAtEventMinute = null,
                        isLiveOrVirtual = false,
                        earlyPayout = false,
                        boreDraw = false,
                        deadHeatFactor = null,
                        dbId = 10
                    )
                ),
                betStatus = 0,
                betType = 2,
                betId = 2988647419
            )
        )
    )
)