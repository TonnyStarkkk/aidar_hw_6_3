package com.example.aidar_hw_6_3.data.dto.character

import com.google.gson.annotations.SerializedName

data class CharactersResponseDTO(
    @SerializedName("info")
    val pagingInfoDTO: PagingInfoDTO,
    @SerializedName("results")
    val characters: List<CharacterDTO>
)