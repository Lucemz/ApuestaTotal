package com.at.apuestatotal.domain.model.bet

import com.google.gson.annotations.SerializedName

data class BetDetailHistory(
    @SerializedName("BetNivel") val betNivel: String,
    @SerializedName("BetStarts") val betStarts: Int,
    @SerializedName("BetStatusName") val betStatusName: String,
    @SerializedName("BetTypeName") val betTypeName: String,
    @SerializedName("BgSrc") val bgSrc: String,
    @SerializedName("CashoutOdds") val cashoutOdds: String,
    @SerializedName("TotalOdds") val totalOdds: String,
    @SerializedName("TotalStake") val totalStake: String,
    @SerializedName("TotalWin") val totalWin: String,
    @SerializedName("CashoutValue") val cashoutValue: String,
    @SerializedName("CreatedDate") val createdDate: String,
    @SerializedName("BetSelections") val betSelections: List<BetSelection>,
    @SerializedName("BetStatus") val betStatus: Int,
    @SerializedName("BetType") val betType: Int,
    @SerializedName("BetId") val betId: Long
)