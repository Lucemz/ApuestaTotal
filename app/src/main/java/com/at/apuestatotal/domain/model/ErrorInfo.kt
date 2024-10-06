package com.at.apuestatotal.domain.model

data class ErrorInfo(
    val titulo: String? = "Error",
    val codigo: String? = "2",
    val descripcion: String? = "No se pudo realizar la operación",
    val detalle: String? = null//= "Sin detalle"
) : Throwable()