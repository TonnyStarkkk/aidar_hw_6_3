package com.example.aidar_hw_6_3.ui.models

import kotlinx.serialization.Serializable

@Serializable
data class Episode(
    val id: Int,
    val name: String,
    val airDate: String,
    val episode: String
)
val mockEpisodes = listOf(
    Episode(
        id = 1,
        name = "Pilot",
        airDate = "December 2, 2013",
        episode = "S01E01"
    ),
    Episode(
        id = 2,
        name = "The Ricklantis Mixup",
        airDate = "September 10, 2017",
        episode = "S03E07"
    )
)
