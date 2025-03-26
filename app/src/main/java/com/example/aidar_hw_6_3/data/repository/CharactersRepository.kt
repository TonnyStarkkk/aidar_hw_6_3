package com.example.aidar_hw_6_3.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.example.aidar_hw_6_3.data.api.CharacterApiService
import com.example.aidar_hw_6_3.data.dto.character.CharacterDTO
import com.example.aidar_hw_6_3.data.paging.CharactersPagingSource

class CharactersRepository(
    private val characterApiService: CharacterApiService
) {
    fun fetchAllCharacters(): Pager<Int, CharacterDTO> {
        return Pager(
            config = PagingConfig(
                pageSize = 20,
                prefetchDistance = 10,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                CharactersPagingSource(characterApiService)
            }
        )
    }

    suspend fun fetchSingleCharacter(id: Int): CharacterDTO {
        return characterApiService.fetchSingleCharacter(id)
    }
}