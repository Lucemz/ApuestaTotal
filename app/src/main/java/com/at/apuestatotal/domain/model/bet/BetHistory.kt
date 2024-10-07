package com.at.apuestatotal.domain.model.bet

import com.google.gson.annotations.SerializedName


data class BetHistory(
    @SerializedName("db") val db: Int,
    @SerializedName("operation") val operation: Long,
    @SerializedName("game") val game: String,
    @SerializedName("created_date") val createdDate: String,
    @SerializedName("status") val status: String,
    @SerializedName("wager") var wager: Double,
    @SerializedName("winning") var winning: Double,
    @SerializedName("odds") val odds: Double,
    @SerializedName("type") val type: String,
    @SerializedName("account") val account: String,
    @SerializedName("betDetails") var betDetails: MutableList<BetDetailHistory> = mutableListOf()

)
