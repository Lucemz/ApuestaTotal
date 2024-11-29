package com.at.apuestatotal.domain.model.login

import com.google.gson.annotations.SerializedName

data class LoginEvent(
    @SerializedName("event") val event: String,
    @SerializedName("ip") val ip: String,
    @SerializedName("result") val result: String,
    @SerializedName("user") val user: User,
    @SerializedName("data") val data: Data
)

data class User(
    @SerializedName("alias") val alias: String,
    @SerializedName("user") val user: Long,
    @SerializedName("email") val email: String,
    @SerializedName("status") val status: String,
    @SerializedName("db") val db: Int,
    @SerializedName("country") val country: String,
    @SerializedName("lastLogin") val lastLogin: String,
    @SerializedName("company") val company: String,
    @SerializedName("national_id") val nationalId: String,
    @SerializedName("ip_login_errors") val ipLoginErrors: Int,
    @SerializedName("otp") val otp: String?,
    @SerializedName("facebook_id") val facebookId: String?,
    @SerializedName("google_id") val googleId: String?,
    @SerializedName("client_device") val clientDevice: String,
    @SerializedName("session") val session: String
)

data class Data(
    @SerializedName("db") val db: Int,
    @SerializedName("user") val user: Long
)
