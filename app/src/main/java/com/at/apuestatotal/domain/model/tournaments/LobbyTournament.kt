package com.at.apuestatotal.domain.model.tournaments

import com.google.gson.annotations.SerializedName


data class Lobby(
    @SerializedName("cms") val cms: Cms,
    @SerializedName("groups") val groups: Groups,
    @SerializedName("type") val type: String,
    @SerializedName("tournament") val tournament: String,
    @SerializedName("init_date") val initDate: String,
    @SerializedName("end_date") val endDate: String,
    @SerializedName("min_amount") val minAmount: Int,
    @SerializedName("min_rounds") val minRounds: Int,
    @SerializedName("winners") val winners: Int,
    @SerializedName("prize") val prize: Int,
    @SerializedName("acceptance_type") val acceptanceType: String
)

data class Cms(
    @SerializedName("summary_title") val summaryTitle: String,
    @SerializedName("summary_body") val summaryBody: String,
    @SerializedName("summary_image") val summaryImage: String,
    @SerializedName("summary_url") val summaryUrl: String
)

data class Groups(
    @SerializedName("ALLOWED") val allowed: List<Int>,
    @SerializedName("FORBIDDEN") val forbidden: List<Int>
)