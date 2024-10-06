package com.at.apuestatotal.domain.model.bet

import com.google.gson.annotations.SerializedName

data class BBSelection(
    @SerializedName("SelectionId") val selectionId: Long,
    @SerializedName("SelectionName") val selectionName: String,
    @SerializedName("MarketName") val marketName: String,
    @SerializedName("EarlyPayout") val earlyPayout: Boolean,
    @SerializedName("BoreDraw") val boreDraw: Boolean,
    @SerializedName("SelectionStatus") val selectionStatus: Int
)