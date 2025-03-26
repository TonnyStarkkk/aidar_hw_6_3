package com.example.aidar_hw_6_3.data.dto.character

import com.google.gson.annotations.SerializedName

data class PagingInfoDTO(
    @SerializedName("count")
    val count: Int,
    @SerializedName("pages")
    val pages: Int,
    @SerializedName("next")
    val next: String,
    @SerializedName("prev")
    val prev: String
)