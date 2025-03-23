package com.example.aidar_hw_6_3.data.repository

import com.example.aidar_hw_6_3.data.api.CharacterApiService
import com.example.aidar_hw_6_3.data.dto.character.CharacterDTO

class CharactersRepository(
    private val characterApiService: CharacterApiService
) {
    suspend fun fetchAllCharacters(): List<CharacterDTO?>? {
        val response = characterApiService.fetchAllCharacters()

        return if (response.isSuccessful) {
            response.body()?.characters
        } else {
            emptyList()
        }
    }

    suspend fun fetchSingleCharacter(id: Int): CharacterDTO {
        return characterApiService.fetchSingleCharacter(id)
    }
}