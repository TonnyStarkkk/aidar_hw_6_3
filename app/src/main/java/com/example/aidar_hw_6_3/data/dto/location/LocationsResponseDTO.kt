package com.example.aidar_hw_6_3.data.dto.location

import com.google.gson.annotations.SerializedName

data class LocationsResponseDTO(
    @SerializedName("results")
    val locations: List<LocationDTO>
)