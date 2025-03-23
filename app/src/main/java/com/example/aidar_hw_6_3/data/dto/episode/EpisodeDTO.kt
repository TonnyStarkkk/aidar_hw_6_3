package com.example.aidar_hw_6_3.data.dto.episode

import com.google.gson.annotations.SerializedName

data class EpisodeDTO(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name :String,
    @SerializedName("air_date")
    val airDate: String,
    @SerializedName("episode")
    val episode: String,
    @SerializedName("created")
    val created: String
)