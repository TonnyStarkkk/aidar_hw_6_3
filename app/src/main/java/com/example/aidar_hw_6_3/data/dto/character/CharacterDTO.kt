package com.example.aidar_hw_6_3.data.dto.character

import com.google.gson.annotations.SerializedName

data class CharacterDTO(
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("status")
    val status: String? = null,
    @SerializedName("species")
    val species: String? = null,
    @SerializedName("image")
    val image: String? = null,
    @SerializedName("gender")
    val gender: String? = null,
    @SerializedName("type")
    val type: String? = null,
    @SerializedName("origin")
    val origin: OriginDTO? = null
)