package com.at.apuestatotal.presentation.utils

import java.text.DateFormatSymbols
import java.text.DecimalFormat
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Locale

fun Double.redondearString(decimales: Int = 2): String {
    val pattern = StringBuilder("#,##0")
    if (decimales > 0) {
        pattern.append(".")
        repeat(decimales) {
            pattern.append("0")
        }
    }
    val format = DecimalFormat(pattern.toString())
    return format.format(this)
}





fun mapDate(dateString: String, formatType: Int = 1): String {
    // Definir el formato original de la fecha
    val originalFormat = SimpleDateFormat("yyyy-MM-dd HH:mm", Locale("es", "ES"))

    // Definir los símbolos para AM/PM
    val customSymbols = DateFormatSymbols(Locale("es", "ES")).apply {
        amPmStrings = arrayOf("am", "pm")
    }

    // Definir los formatos de salida con los símbolos personalizados
    val dayMonthFormat = SimpleDateFormat("dd-MM", Locale("es", "ES"))
    val fullFormat = SimpleDateFormat("dd-MM-yyyy hh:mm a", Locale("es", "ES")).apply {
        dateFormatSymbols = customSymbols
    }

    return try {
        // Convertir la cadena de texto en una fecha
        val date = originalFormat.parse(dateString)

        // Retornar el formato adecuado según el valor de formatType
        when (formatType) {
            1 -> dayMonthFormat.format(date) // 24-09
            2 -> fullFormat.format(date) // 24-09-2024 03:39 pm
            else -> dayMonthFormat.format(date) // Por defecto, formato 1
        }
    } catch (e: ParseException) {
        e.printStackTrace() // Manejo de error si el formato de la fecha es incorrecto
        return "Formato de fecha no válido"
    }
}
