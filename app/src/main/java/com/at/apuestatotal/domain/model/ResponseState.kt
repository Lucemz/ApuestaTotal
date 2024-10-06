package com.at.apuestatotal.domain.model


sealed class ResponseState<out T>{

    object Loading : ResponseState<Nothing>()
    data class Success<out T>(val data: T) : ResponseState<T>()
    data class Error<out T>(val errorInfo: ErrorInfo) : ResponseState<T>()

}
