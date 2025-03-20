package com.example.aidar_hw_6_3.ui.navigation

import LocationsScreen
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.aidar_hw_6_3.ui.models.mockCharacters
import com.example.aidar_hw_6_3.ui.models.mockEpisodes
import com.example.aidar_hw_6_3.ui.models.mockLocations
import com.example.aidar_hw_6_3.ui.screens.characters.CharactersScreen
import com.example.aidar_hw_6_3.ui.screens.characters.detail.CharacterDetailScreen
import com.example.aidar_hw_6_3.ui.screens.episodes.EpisodesScreen
import com.example.aidar_hw_6_3.ui.screens.episodes.detail.EpisodeDetailScreen
import com.example.aidar_hw_6_3.ui.screens.locations.detail.LocationDetailScreen

@Composable
fun NavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = NavigationRoutes.CharactersScreen
    ) {
        composable(NavigationRoutes.CharactersScreen) {
            CharactersScreen(navController)
        }
        composable(NavigationRoutes.LocationsScreen) {
            LocationsScreen(navController)
        }
        composable(NavigationRoutes.EpisodesScreen) {
            EpisodesScreen(navController)
        }

        composable(NavigationRoutes.CharacterDetailScreen) { backStackEntry ->
            val characterId = backStackEntry.arguments?.getString("characterId")?.toInt() ?: -1
            val character = mockCharacters.find {
                it.id == characterId
            }
            character?.let {
                CharacterDetailScreen(it)
            }
        }

        composable(NavigationRoutes.LocationDetailScreen) { backStackEntry ->
            val locationId = backStackEntry.arguments?.getString("locationId")?.toInt() ?: -1
            val location = mockLocations.find {
                it.id == locationId
            }
            location?.let {
                LocationDetailScreen(location)
            }
        }

        composable(NavigationRoutes.EpisodeDetailScreen) { backStackEntry ->
            val episodeId = backStackEntry.arguments?.getString("episodeId")?.toInt() ?: -1
            val episode = mockEpisodes.find {
                it.id == episodeId
            }
            episode?.let {
                EpisodeDetailScreen(episode)
            }
        }
    }
}