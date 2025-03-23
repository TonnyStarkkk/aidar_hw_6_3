package com.example.aidar_hw_6_3.ui.screens.favorites

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.aidar_hw_6_3.data.room.FavoritesCharacter
import org.koin.androidx.compose.koinViewModel

@Composable
fun FavoritesScreen(
    navController: NavController,
    viewModel: FavoritesViewModel = koinViewModel()
) {

    LaunchedEffect(Unit) {
        viewModel.getAllFavorites()
    }

    val favorites = viewModel.favoritesStateFlow.collectAsState()

    LazyColumn {
        items(
            items = favorites.value
        ) { favorites ->
            FavoritesItem(
                favoritesCharacter = favorites,
                onDelete = {
                    viewModel.deleteFavoritesCharacter(favorites)
                }
            )
        }
    }
}

@Composable
fun FavoritesItem(favoritesCharacter: FavoritesCharacter, onDelete: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape),
                model = favoritesCharacter.image,
                contentDescription = null
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(
                    text = favoritesCharacter.name!!,
                    style = MaterialTheme.typography.bodyLarge
                )
                Text(
                    text = favoritesCharacter.status!!,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
        IconButton(
            onClick = onDelete
        ) {
            Icon(
                imageVector = Icons.Filled.Delete,
                contentDescription = "Delete",
                tint = MaterialTheme.colorScheme.error
            )
        }
    }
}

