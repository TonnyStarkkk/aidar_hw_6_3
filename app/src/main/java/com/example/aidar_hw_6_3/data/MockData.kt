package com.example.aidar_hw_6_3.data

import com.example.aidar_hw_6_3.ui.models.Character
import com.example.aidar_hw_6_3.ui.models.Episode
import com.example.aidar_hw_6_3.ui.models.Location

object MockData {
    val characters = listOf(
        Character(
            id = 1,
            name = "Rick Sanchez",
            status = "Alive",
            species = "Human",
            image = "https://rickandmortyapi.com/api/character/avatar/1.jpeg",
            gender = "Male",
            location = "Earth"
        ),
        Character(
            id = 2,
            name = "Morty Smith",
            status = "Alive",
            species = "Human",
            image = "https://rickandmortyapi.com/api/character/avatar/2.jpeg",
            gender = "Male",
            location = "Earth"
        )
    )

    val episodes = listOf(
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

    val locations = listOf(
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
}