package com.at.apuestatotal.domain.model.optionNavigationDrawer


const val TOP_1 = "Top 1"
const val NUEVO = "Nuevo"
const val NONE = ""

data class ItemOptionDrawer(
    val nombre: String,
    val type: String? = null,
    val colorTab: androidx.compose.ui.graphics.Color? = null
)


