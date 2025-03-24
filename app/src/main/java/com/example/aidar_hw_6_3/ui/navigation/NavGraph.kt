package com.example.aidar_hw_6_3.ui.navigation

import LocationsScreen
import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.aidar_hw_6_3.data.dto.character.OriginDTO
import com.example.aidar_hw_6_3.ui.screens.characters.CharactersScreen
import com.example.aidar_hw_6_3.ui.screens.characters.detail.CharacterDetailScreen
import com.example.aidar_hw_6_3.ui.screens.episodes.EpisodesScreen
import com.example.aidar_hw_6_3.ui.screens.episodes.detail.EpisodeDetailScreen
import com.example.aidar_hw_6_3.ui.screens.favorites.FavoritesScreen
import com.example.aidar_hw_6_3.ui.screens.locations.detail.LocationDetailScreen
import com.google.gson.Gson

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
        composable(NavigationRoutes.FavoritesScreen) {
            FavoritesScreen(navController)
        }

        composable(NavigationRoutes.CharacterDetailScreen) { backStackEntry ->
            val characterId = backStackEntry.arguments?.getString("characterId")?.toInt() ?: -1
            val originJson = backStackEntry.arguments?.getString("origin")
            val origin = originJson?.let {
                Gson().fromJson(it, OriginDTO::class.java)
            }
            CharacterDetailScreen(characterId, origin)
        }

        composable(NavigationRoutes.LocationDetailScreen) { backStackEntry ->
            val locationId = backStackEntry.arguments?.getString("locationId")?.toInt() ?: -1
            LocationDetailScreen(locationId)
        }

        composable(NavigationRoutes.EpisodeDetailScreen) { backStackEntry ->
            val episodeId = backStackEntry.arguments?.getString("episodeId")?.toInt() ?: -1
            EpisodeDetailScreen(episodeId)
        }
    }
}