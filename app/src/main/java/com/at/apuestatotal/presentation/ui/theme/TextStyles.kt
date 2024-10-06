package com.at.apuestatotal.presentation.ui.theme

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.at.apuestatotal.R


val Poppins = FontFamily(
    Font(R.font.poppins, FontWeight.Normal),
    Font(R.font.poppins_medium, FontWeight.Medium),
    Font(R.font.poppins_semibold, FontWeight.SemiBold),
    Font(R.font.poppins_bold, FontWeight.Bold)
)

object TextStyles {

    // Categoría Heading
    object Heading {
        val h1 = TextStyle(
            fontFamily = Poppins,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            lineHeight = 1.3.em  // 130% de 20sp
        )
        val h2 = TextStyle(
            fontFamily = Poppins,
            fontWeight = FontWeight.SemiBold,
            fontSize = 18.sp,
            lineHeight = 1.3.em  // 130% de 18sp
        )
        val h3 = TextStyle(
            fontFamily = Poppins,
            fontWeight = FontWeight.SemiBold,
            fontSize = 16.sp,
            lineHeight = 1.3.em  // 130% de 16sp
        )
        val subtitle1 = TextStyle(
            fontFamily = Poppins,
            fontWeight = FontWeight.Medium,
            fontSize = 14.sp,
            lineHeight = 1.3.em  // 130% de 14sp
        )
        val subtitle2 = TextStyle(
            fontFamily = Poppins,
            fontWeight = FontWeight.Medium,
            fontSize = 12.sp,
            lineHeight = 1.3.em  // 130% de 12sp
        )
    }

    // Categoría Card
    object Card {
        val title1 = TextStyle(
            fontFamily = Poppins,
            fontWeight = FontWeight.SemiBold,
            fontSize = 16.sp,
            lineHeight = 1.3.em  // 130% de 16sp
        )
        val title2 = TextStyle(
            fontFamily = Poppins,
            fontWeight = FontWeight.SemiBold,
            fontSize = 14.sp,
            lineHeight = 1.3.em  // 130% de 14sp
        )
        val subtitle1 = TextStyle(
            fontFamily = Poppins,
            fontWeight = FontWeight.Medium,
            fontSize = 12.sp,
            lineHeight = 1.3.em  // 130% de 12sp
        )
        val subtitle2 = TextStyle(
            fontFamily = Poppins,
            fontWeight = FontWeight.Medium,
            fontSize = 10.sp,
            lineHeight = 1.3.em  // 130% de 10sp
        )
    }

    // Categoría Button
    object Button {
        val text1 = TextStyle(
            fontFamily = Poppins,
            fontWeight = FontWeight.SemiBold,
            fontSize = 16.sp,
            lineHeight = 1.3.em  // 130% de 16sp
        )
        val text2 = TextStyle(
            fontFamily = Poppins,
            fontWeight = FontWeight.Medium,
            fontSize = 14.sp,
            lineHeight = 1.3.em  // 130% de 14sp
        )
        val text3 = TextStyle(
            fontFamily = Poppins,
            fontWeight = FontWeight.Medium,
            fontSize = 12.sp,
            lineHeight = 1.3.em  // 130% de 12sp
        )
    }

    // Categoría Body
    object Body {
        val paragraph1 = TextStyle(
            fontFamily = Poppins,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp,
            lineHeight = 1.3.em  // 130% de 16sp
        )
        val paragraph2 = TextStyle(
            fontFamily = Poppins,
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp,
            lineHeight = 1.3.em  // 130% de 14sp
        )
        val subtitleCard1 = TextStyle(
            fontFamily = Poppins,
            fontWeight = FontWeight.Medium,
            fontSize = 10.sp,
            lineHeight = 1.3.em  // 130% de 10sp
        )
        val textCard1 = TextStyle(
            fontFamily = Poppins,
            fontWeight = FontWeight.Normal,
            fontSize = 12.sp,
            lineHeight = 1.3.em  // 130% de 12sp
        )
        val textCard2 = TextStyle(
            fontFamily = Poppins,
            fontWeight = FontWeight.Normal,
            fontSize = 10.sp,
            lineHeight = 1.3.em  // 130% de 10sp
        )
    }
}
