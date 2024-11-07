package com.at.apuestatotal.domain.model.banner

import android.net.Uri
import com.google.gson.annotations.SerializedName

data class Banner(
    @SerializedName("name") val name: String,
    @SerializedName("config") val bannerConfig: BannerConfig,
    @SerializedName("init_date") val initDate: String,
    @SerializedName("end_date") val endDate: String
)

data class BannerConfig(
    @SerializedName("url") val url: String,
    @SerializedName("title") val title: String,
    @SerializedName("body") val body: String,
    @SerializedName("image") val image: String,
    @SerializedName("button_text") val buttonText: String? = null,
    @SerializedName("imageUri") var imageUri: Uri? = null
)