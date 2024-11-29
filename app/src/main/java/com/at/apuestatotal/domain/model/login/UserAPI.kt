package com.at.apuestatotal.domain.model.login

import com.google.gson.annotations.SerializedName

data class UserAPI(
    @SerializedName("company") val company: String,
    @SerializedName("alias") val email: String,
    @SerializedName("password") val password: String
)

data class ProviderInfoAPI(
    @SerializedName("company") val company: String,
    @SerializedName("provider") val provider: String,
    @SerializedName("session") val passwosessionrd: String
)
