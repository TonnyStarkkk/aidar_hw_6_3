package com.example.aidar_hw_6_3.data.dto.episode

import com.google.gson.annotations.SerializedName

data class EpisodeDTO(
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("air_date")
    val airDate: String? = null,
    @SerializedName("episode")
    val episode: String? = null,
    @SerializedName("created")
    val created: String? = null
)