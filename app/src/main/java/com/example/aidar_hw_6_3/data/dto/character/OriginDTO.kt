package com.example.aidar_hw_6_3.data.dto.character

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName

data class OriginDTO(
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("url")
    val url: String? = null
)
val gson = Gson()
val originGson = gson.toJson(OriginDTO())