package com.example.aidar_hw_6_3.data.dto.location

import com.google.gson.annotations.SerializedName

data class LocationInfoDTO(
    @SerializedName("count")
    val count: Int,
    @SerializedName("pages")
    val pages: Int,
    @SerializedName("next")
    val next: String,
    @SerializedName("prev")
    val prev: String
)