package com.at.apuestatotal.domain.model.promotion

import com.google.gson.annotations.SerializedName

data class LobbyPromotion(
    @SerializedName("body") val body: String,
    @SerializedName("image") val image: String,
    @SerializedName("title") val title: String,
    @SerializedName("summary_body") val summaryBody: String,
    @SerializedName("summary_image") val summaryImage: String,
    @SerializedName("summary_title") val summaryTitle: String,
    @SerializedName("groups_forbidden") val groupsForbidden: List<Int>,
    @SerializedName("groups_allowed") val groupsAllowed: List<Int>,
    @SerializedName("promotion") val promotion: String,
    @SerializedName("tags") val tags: String?
)