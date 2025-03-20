package com.example.aidar_hw_6_3.ui.models

import kotlinx.serialization.Serializable

@Serializable
data class Location(
    val id: Int,
    val name: String,
    val type: String,
    val dimension: String
)
val mockLocations = listOf(
    Location(
        id = 1,
        name = "Earth",
        type = "Planet",
        dimension = "Dimension C-137"
    ),
    Location(
        id = 2,
        name = "Citadel of Ricks",
        type = "Space Station",
        dimension = "Unknown"
    )
)