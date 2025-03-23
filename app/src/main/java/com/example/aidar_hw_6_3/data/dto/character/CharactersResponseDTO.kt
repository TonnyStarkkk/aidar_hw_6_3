package com.example.aidar_hw_6_3.data.dto.character

import com.google.gson.annotations.SerializedName

data class CharactersResponseDTO(
    @SerializedName("results")
    val characters: List<CharacterDTO>
)