package com.example.aidar_hw_6_3.ui.screens.characters

import android.net.Uri
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.Favorite
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.filter
import coil.compose.AsyncImage
import com.example.aidar_hw_6_3.data.dto.character.CharacterDTO
import com.example.aidar_hw_6_3.data.dto.character.originGson
import com.example.aidar_hw_6_3.data.room.FavoritesCharacter
import com.example.aidar_hw_6_3.ui.load.LoadState
import com.example.aidar_hw_6_3.ui.screens.favorites.FavoritesViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun CharactersScreen(
    navController: NavController,
    viewModel: CharactersViewModel = koinViewModel(),
    favoritesViewModel: FavoritesViewModel = koinViewModel()
) {
    LaunchedEffect(Unit) {
        viewModel.fetchAllCharacters()
    }

    val characters = viewModel.charactersStateFlow.collectAsLazyPagingItems()
    val favorites = favoritesViewModel.favoritesStateFlow.collectAsState()

    LoadState(
        loadState = characters.loadState,
        onRetry = {
            characters.retry()
        }
    )

    LazyColumn {
        items(
            count = characters.itemCount
        ) { index ->
            val character = characters[index]
            character?.let {
                CharacterItem(
                    character = it,
                    onClick = {
                        val encodedOrigin = Uri.encode(originGson)
                        navController.navigate("characterDetail/${character.id}?origin=${encodedOrigin}")
                    },
                    isFavorite = favorites.value.any { favorite ->
                        favorite.id == character.id
                    },
                    onFavoriteClick = {
                        val favoriteCharacter = FavoritesCharacter(
                            id = character.id!!,
                            name = character.name!!,
                            status = character.status!!
                        )
                        if (favorites.value.any { favorites ->
                                favorites.id == character.id
                            }) {
                            favoritesViewModel.deleteFavoritesCharacter(favoriteCharacter)
                        } else {
                            favoritesViewModel.addFavoritesCharacter(favoriteCharacter)
                        }
                    }
                )
            }
        }
    }
}

@Composable
fun CharacterItem(
    character: CharacterDTO,
    onClick: () -> Unit,
    isFavorite: Boolean,
    onFavoriteClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable(
                onClick = onClick
            ),
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
                model = character.image,
                contentDescription = null,
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(
                    text = character.name!!,
                    style = MaterialTheme.typography.bodyLarge
                )
                Text(
                    text = character.status!!,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
        IconButton(
            onClick = onFavoriteClick
        ) {
            Icon(
                imageVector = if (isFavorite) Icons.Filled.Favorite else Icons.Outlined.Favorite,
                contentDescription = "Add to favorites",
                tint = if (isFavorite) Color.Red else Color.Gray
            )
        }
    }
}
