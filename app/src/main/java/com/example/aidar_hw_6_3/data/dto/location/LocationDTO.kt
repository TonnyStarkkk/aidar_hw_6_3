package com.example.aidar_hw_6_3.data.dto.location

import com.google.gson.annotations.SerializedName

data class LocationDTO(
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("type")
    val type: String? = null,
    @SerializedName("dimension")
    val dimension: String? = null,
    @SerializedName("created")
    val created: String? = null
)