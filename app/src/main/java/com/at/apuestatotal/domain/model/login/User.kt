package com.at.apuestatotal.domain.model.login

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("name") val name: String,
    @SerializedName("correo") val email: String,
    @SerializedName("password") val password: String
)
