package com.example.aidar_hw_6_3.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.example.aidar_hw_6_3.data.api.EpisodeApiService
import com.example.aidar_hw_6_3.data.dto.episode.EpisodeDTO
import com.example.aidar_hw_6_3.data.paging.EpisodesPagingSource

class EpisodesRepository(
    private val episodeApiService: EpisodeApiService
) {

    fun fetchAllEpisodes(): Pager<Int, EpisodeDTO> {
        return Pager(
            config = PagingConfig(
                pageSize = 20,
                prefetchDistance = 10,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                EpisodesPagingSource(episodeApiService)
            }
        )
    }

    suspend fun fetchSingleEpisode(id: Int): EpisodeDTO {
        return episodeApiService.fetchSingleEpisode(id)
    }
}