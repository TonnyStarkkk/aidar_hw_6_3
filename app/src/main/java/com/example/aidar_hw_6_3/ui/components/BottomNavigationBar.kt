package com.example.aidar_hw_6_3.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.aidar_hw_6_3.R
import com.example.aidar_hw_6_3.ui.navigation.NavigationRoutes

@Composable
fun BottomNavigationBar(navController: NavController) {
    val currentBackStackEntry = navController.currentBackStackEntryAsState().value
    val currentRoute = currentBackStackEntry?.destination?.route

    if (currentRoute != null && !currentRoute.contains("Detail")) {
        NavigationBar {
            NavigationBarItem(
                icon = {
                    Icon(
                        Icons.Default.Person,
                        contentDescription = null
                    )
                },
                label = {
                    Text(
                        text = "Characters"
                    )
                },
                selected = currentRoute == NavigationRoutes.CharactersScreen,
                onClick = {
                    if (currentRoute != NavigationRoutes.CharactersScreen) {
                        navController.navigate(NavigationRoutes.CharactersScreen) {
                            popUpTo(NavigationRoutes.CharactersScreen) { inclusive = true }
                        }
                    }
                }
            )
            NavigationBarItem(
                icon = {
                    Icon(
                        Icons.Default.LocationOn,
                        contentDescription = null
                    )
                },
                label = {
                    Text(
                        text = "Locations"
                    )
                },
                selected = currentRoute == NavigationRoutes.LocationsScreen,
                onClick = {
                    if (currentRoute != NavigationRoutes.LocationsScreen) {
                        navController.navigate(NavigationRoutes.LocationsScreen) {
                            popUpTo(NavigationRoutes.LocationsScreen) { inclusive = true }
                        }
                    }
                }
            )
            NavigationBarItem(
                icon = {
                    Icon(
                        painter = painterResource(R.drawable.ic_episode),
                        contentDescription = null
                    )
                },
                label = {
                    Text(
                        text = "Episodes"
                    )
                },
                selected = currentRoute == NavigationRoutes.EpisodesScreen,
                onClick = {
                    if (currentRoute != NavigationRoutes.EpisodesScreen) {
                        navController.navigate(NavigationRoutes.EpisodesScreen) {
                            popUpTo(NavigationRoutes.EpisodesScreen) { inclusive = true }
                        }
                    }
                }
            )
            NavigationBarItem(
                icon = {
                    Icon(
                        Icons.Default.Favorite,
                        contentDescription = null
                    )
                },
                label = {
                    Text(
                        text = "Favorites"
                    )
                },
                selected = currentRoute == NavigationRoutes.FavoritesScreen,
                onClick = {
                    if (currentRoute != NavigationRoutes.FavoritesScreen) {
                        navController.navigate(NavigationRoutes.FavoritesScreen) {
                            popUpTo(NavigationRoutes.CharactersScreen) { inclusive = false }
                        }
                    }
                }
            )
        }
    }
}