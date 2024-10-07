package com.at.apuestatotal.presentation.utils

import androidx.compose.ui.graphics.Color
import com.example.ui.theme.Secondary

const val LOST = "LOST"
const val WON = "WON"
const val OPEN = "OPEN"
const val CASHOUT = "CASHOUT"

const val SIMPLE = "SIMPLE"
const val MULTIPLE = "MULTIPLE"
const val SYSTEM = "SYSTEM"

fun betStatusMaperTitle(status: String): String {
    return when (status) {
        LOST -> "Perdido"
        WON -> "Ganado"
        OPEN -> "Abierto"
        CASHOUT -> "Cashout"
        else -> "N/A"
    }
}

fun betAllMaperTitle(title: String): String {
    return when (title) {
        LOST -> "Perdido"
        WON -> "Ganado"
        OPEN -> "Abierto"
        CASHOUT -> "Cashout"
        SIMPLE -> "Simple"
        MULTIPLE -> "Multiple"
        SYSTEM -> "Sistema"
        else -> "N/A"
    }
}

fun betStatusMaperColor(status: String): Color {
    return when (status) {
        LOST -> Secondary.RedSecondary
        WON -> Secondary.Green
        OPEN -> Secondary.GrayPrime
        CASHOUT -> Secondary.Blue
        else -> Secondary.GrayPrime
    }
}

fun betTypeMaperTitle(status: String): String {
    return when (status) {
        SIMPLE -> "Simple"
        MULTIPLE -> "Multiple"
        SYSTEM -> "Sistema"
        else -> "N/A"
    }
}