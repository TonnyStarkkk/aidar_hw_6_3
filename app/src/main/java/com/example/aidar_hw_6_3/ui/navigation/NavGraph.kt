package com.example.aidar_hw_6_3.ui.navigation

import LocationsScreen
import android.content.Context
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.lazy.LazyListState
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

const val SCREEN_TRANSITION_MILLIS = 200

@Composable
fun NavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    listState: LazyListState
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = NavigationRoutes.CharactersScreen,
        enterTransition = {
            slideIntoContainer(
                AnimatedContentTransitionScope.SlideDirection.Start,
                tween(SCREEN_TRANSITION_MILLIS)
            )
        },
        exitTransition = {
            slideOutOfContainer(
                AnimatedContentTransitionScope.SlideDirection.Start,
                tween(SCREEN_TRANSITION_MILLIS)
            )
        },
        popEnterTransition = {
            slideIntoContainer(
                AnimatedContentTransitionScope.SlideDirection.End,
                tween(SCREEN_TRANSITION_MILLIS)
            )
        },
        popExitTransition = {
            slideOutOfContainer(
                AnimatedContentTransitionScope.SlideDirection.End,
                tween(SCREEN_TRANSITION_MILLIS)
            )
        }
    ) {
        composable(NavigationRoutes.CharactersScreen) {
            CharactersScreen(
                navController = navController,
                listState = listState
            )
        }
        composable(NavigationRoutes.LocationsScreen) {
            LocationsScreen(
                navController = navController,
                listState = listState
            )
        }
        composable(NavigationRoutes.EpisodesScreen) {
            EpisodesScreen(
                navController = navController,
                listState = listState
            )
        }
        composable(NavigationRoutes.FavoritesScreen) {
            FavoritesScreen(
                navController = navController
            )
        }

        composable(NavigationRoutes.CharacterDetailScreen) { backStackEntry ->
            val characterId = backStackEntry.arguments?.getString("characterId")?.toInt() ?: -1
            val originJson = backStackEntry.arguments?.getString("origin")
            val origin = originJson?.let {
                Gson().fromJson(it, OriginDTO::class.java)
            }
            CharacterDetailScreen(
                characterId = characterId,
                origin = origin,
                navController = navController
            )
        }

        composable(NavigationRoutes.LocationDetailScreen) { backStackEntry ->
            val locationId = backStackEntry.arguments?.getString("locationId")?.toInt() ?: -1
            LocationDetailScreen(
                locationId = locationId,
                navController = navController
            )
        }

        composable(NavigationRoutes.EpisodeDetailScreen) { backStackEntry ->
            val episodeId = backStackEntry.arguments?.getString("episodeId")?.toInt() ?: -1
            EpisodeDetailScreen(
                episodeId = episodeId,
                navController = navController
            )
        }
    }
}