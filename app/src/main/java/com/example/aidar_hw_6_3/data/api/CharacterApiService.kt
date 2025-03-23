package com.example.aidar_hw_6_3.data.api

import com.example.aidar_hw_6_3.data.dto.character.CharacterDTO
import com.example.aidar_hw_6_3.data.dto.character.CharactersResponseDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface CharacterApiService {

    @GET("character")
    suspend fun fetchAllCharacters(): Response<CharactersResponseDTO>

    @GET("character/{id}")
    suspend fun fetchSingleCharacter(@Path("id") id: Int): CharacterDTO
}