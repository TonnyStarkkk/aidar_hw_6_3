package com.example.aidar_hw_6_3.data.repository

import com.example.aidar_hw_6_3.data.api.EpisodeApiService
import com.example.aidar_hw_6_3.data.dto.episode.EpisodeDTO

class EpisodesRepository(
    private val episodeApiService: EpisodeApiService
) {

    suspend fun fetchAllEpisodes(): List<EpisodeDTO>? {
        val response = episodeApiService.fetchAllEpisodes()

        return if (response.isSuccessful) {
            response.body()?.episodes
        } else {
            emptyList()
        }
    }

    suspend fun fetchSingleEpisode(id: Int): EpisodeDTO {
        return episodeApiService.fetchSingleEpisode(id)
    }
}