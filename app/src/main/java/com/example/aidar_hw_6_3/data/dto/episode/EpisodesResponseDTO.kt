package com.example.aidar_hw_6_3.data.dto.episode

import com.google.gson.annotations.SerializedName

data class EpisodesResponseDTO(
    @SerializedName("info")
    val episodeInfoDTO: EpisodeInfoDTO,
    @SerializedName("results")
    val episodes: List<EpisodeDTO>
)