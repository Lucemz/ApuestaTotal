package com.at.apuestatotal.presentation.utils

import androidx.compose.ui.graphics.Color
import com.at.apuestatotal.R
import com.example.ui.theme.Secondary

const val LOST = "LOST"
const val WON = "WON"
const val OPEN = "OPEN"
const val CASHOUT = "CASHOUT"

const val SIMPLE = "SIMPLE"
const val MULTIPLE = "MULTIPLE"
const val SYSTEM = "SYSTEM"

const val DONATELO = "Donatelo"
const val CAZAFIJAS = "CazaFijas"
const val CAPO = "Capo"
const val MASTER = "Master"
const val KING = "King"
const val LEYENDA = "Leyenda"

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

fun betTypeMaperIcon(type: String): Int? {
    return when (type) {
        DONATELO -> {
            R.drawable.donatelo
        }

        CAZAFIJAS -> {
            R.drawable.cazafijas
        }

        CAPO -> {
            R.drawable.capo
        }

        MASTER -> {
            R.drawable.master
        }

        KING -> {
            R.drawable.king
        }

        LEYENDA -> {
            R.drawable.leyenda
        }

        else -> {
            null
        }
    }
}