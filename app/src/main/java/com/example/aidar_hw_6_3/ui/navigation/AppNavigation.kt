package com.example.aidar_hw_6_3.ui.navigation

import LocationsScreen
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.aidar_hw_6_3.ui.models.Character
import com.example.aidar_hw_6_3.ui.models.Episode
import com.example.aidar_hw_6_3.ui.models.Location
import com.example.aidar_hw_6_3.ui.screens.characters.CharactersScreen
import com.example.aidar_hw_6_3.ui.screens.characters.detail.CharacterDetailScreen
import com.example.aidar_hw_6_3.ui.screens.episodes.EpisodesScreen
import com.example.aidar_hw_6_3.ui.screens.episodes.detail.EpisodeDetailScreen
import com.example.aidar_hw_6_3.ui.screens.locations.detail.LocationDetailScreen
import kotlinx.serialization.json.Json

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Characters.route
    ) {
        composable(Screen.Characters.route) {
            CharactersScreen(navController)
        }
        composable(Screen.Episodes.route) {
            EpisodesScreen(navController)
        }
        composable(Screen.Locations.route) {
            LocationsScreen(navController)
        }

        composable(
            route = Screen.CharacterDetail.route,
            arguments = listOf(navArgument("characterJson") {
                type = NavType.StringType
            })
        ) { backStackEntry ->
            val characterJson = backStackEntry.arguments?.getString("characterJson")
            val character = Json.decodeFromString<Character>(characterJson ?: "")
            CharacterDetailScreen(character)
        }
        composable(
            Screen.LocationDetail.route,
            arguments = listOf(navArgument("locationJson") { type = NavType.StringType })
        ) { backStackEntry ->
            val locationJson = backStackEntry.arguments?.getString("locationJson")
            val location = Json.decodeFromString<Location>(locationJson ?: "")
            LocationDetailScreen(location)
        }
        composable(
            Screen.EpisodeDetail.route,
            arguments = listOf(navArgument("episodeJson") { type = NavType.StringType })
        ) { backStackEntry ->
            val episodeJson = backStackEntry.arguments?.getString("episodeJson")
            val episode = Json.decodeFromString<Episode>(episodeJson ?: "")
            EpisodeDetailScreen(episode)
        }
    }
}
