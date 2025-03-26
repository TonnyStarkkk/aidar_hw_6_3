package com.example.aidar_hw_6_3.data.api

import com.example.aidar_hw_6_3.data.dto.episode.EpisodeDTO
import com.example.aidar_hw_6_3.data.dto.episode.EpisodesResponseDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface EpisodeApiService {

    @GET("episode")
    suspend fun fetchAllEpisodes(
        @Query("page") page: Int
    ): Response<EpisodesResponseDTO>

    @GET("episode/{id}")
    suspend fun fetchSingleEpisode(@Path("id") id: Int): EpisodeDTO
}