package com.at.apuestatotal.domain.model.casino


import com.google.gson.annotations.SerializedName


data class LobbyCasino(
    @SerializedName("machine") val machine: Int,
    @SerializedName("name") val name: String,
    @SerializedName("web_name") val webName: String,
    @SerializedName("provider") val provider: String,
    @SerializedName("sub_provider") val subProvider: String,
    @SerializedName("external_id") val externalId: String,
    @SerializedName("type") val type: String,
    @SerializedName("tags") val tags: String,
    @SerializedName("lobby_tag") val lobbyTag: String?,
    @SerializedName("logo") val logo: String,
    @SerializedName("background") val background: String,
    @SerializedName("rtp") val rtp: Double?,
    @SerializedName("demo_allowed") val demoAllowed: Boolean,
    @SerializedName("gaming_session_required") val gamingSessionRequired: Boolean
)
