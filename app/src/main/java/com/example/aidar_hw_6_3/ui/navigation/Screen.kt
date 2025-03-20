package com.example.aidar_hw_6_3.ui.navigation

import com.example.aidar_hw_6_3.ui.models.Character
import com.example.aidar_hw_6_3.ui.models.Episode
import com.example.aidar_hw_6_3.ui.models.Location
import kotlinx.serialization.json.Json

sealed class Screen(val route: String) {
    data object Characters : Screen("characters")
    data object Locations : Screen("locations")
    data object Episodes : Screen("episodes")

    data object CharacterDetail : Screen("character_detail/{characterJson}") {
        fun createRoute(character: Character): String {
            val json = Json.encodeToString(character)
            return "character_detail/$json"
        }
    }

    data object LocationDetail : Screen("location_detail/{locationJson}") {
        fun createRoute(location: Location): String {
            val json = Json.encodeToString(location)
            return "location_detail/$json"
        }
    }

    data object EpisodeDetail : Screen("episode_detail/{episodeJson}") {
        fun createRoute(episode: Episode): String {
            val json = Json.encodeToString(episode)
            return "episode_detail/$json"
        }
    }
}