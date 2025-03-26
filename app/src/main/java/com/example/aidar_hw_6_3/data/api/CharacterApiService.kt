package com.example.aidar_hw_6_3.data.api

import com.example.aidar_hw_6_3.data.dto.character.CharacterDTO
import com.example.aidar_hw_6_3.data.dto.character.CharactersResponseDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CharacterApiService {

    @GET("character")
    suspend fun fetchAllCharacters(
        @Query("page") page: Int
    ): Response<CharactersResponseDTO>

    @GET("character/{id}")
    suspend fun fetchSingleCharacter(@Path("id") id: Int): CharacterDTO
}