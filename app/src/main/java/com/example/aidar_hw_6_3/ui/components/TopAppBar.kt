package com.example.aidar_hw_6_3.ui.components

import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.compose.material3.TopAppBar
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.aidar_hw_6_3.ui.navigation.NavigationRoutes

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar(navController: NavController) {
    val currentBackStackEntry = navController.currentBackStackEntryAsState().value
    val currentRoute = currentBackStackEntry?.destination?.route
    val isDetailScreen = currentRoute?.contains("Detail") == true

    if (!isDetailScreen && currentRoute != null) {
        CenterAlignedTopAppBar(
            title = {
                Text(
                    text = when (currentRoute) {
                        NavigationRoutes.CharactersScreen -> "Characters"
                        NavigationRoutes.LocationsScreen -> "Locations"
                        NavigationRoutes.EpisodesScreen -> "Episodes"
                        else -> "Unknown"
                    }
                )
            }
        )
    }
}