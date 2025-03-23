package com.example.aidar_hw_6_3.ui.screens.characters

import android.net.Uri
import androidx.compose.foundation.clickable
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
import com.example.aidar_hw_6_3.data.dto.character.CharacterDTO
import com.example.aidar_hw_6_3.data.dto.character.originGson
import org.koin.androidx.compose.koinViewModel

@Composable
fun CharactersScreen(
    navController: NavController,
    viewModel: CharactersViewModel = koinViewModel()
) {
    LaunchedEffect(Unit) {
        viewModel.fetchAllCharacters()
    }

    val characters = viewModel.charactersStateFlow.collectAsState()

    LazyColumn {
        items(
            items = characters.value
        ) { character ->
            CharacterItem(character!!) {
                val encodedOrigin = Uri.encode(originGson)
                navController.navigate("characterDetail/${character.id}?origin=${encodedOrigin}")
            }
        }
    }
}

@Composable
fun CharacterItem(character: CharacterDTO, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable(
                onClick = onClick
            ),
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
}