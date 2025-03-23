package com.example.aidar_hw_6_3.ui.screens.characters.detail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.aidar_hw_6_3.data.dto.character.OriginDTO
import org.koin.androidx.compose.koinViewModel

@Composable
fun CharacterDetailScreen(
    characterId: Int,
    origin: OriginDTO?,
    viewModel: CharacterDetailViewModel = koinViewModel()
) {
    LaunchedEffect(characterId) {
        viewModel.fetchSingleCharacter(characterId)
    }

    val character = viewModel.characterDetailStateFlow.collectAsState()

    character.value?.let { character ->
        character.origin?.let { origin ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    AsyncImage(
                        modifier = Modifier
                            .fillMaxWidth()
                            .size(200.dp),
                        model = character.image,
                        contentDescription = null
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = "Name: ${character.name}",
                        style = MaterialTheme.typography.bodyLarge,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "Status: ${character.status}",
                        style = MaterialTheme.typography.bodyMedium
                    )
                    Text(
                        text = "Specie: ${character.species}",
                        style = MaterialTheme.typography.bodyMedium
                    )
                    Text(
                        text = "Gender: ${character.gender}",
                        style = MaterialTheme.typography.bodyMedium
                    )
                    Text(
                        text = "Type: ${character.type}",
                        style = MaterialTheme.typography.bodyMedium
                    )
                    Text(
                        text = "Location: ${character.origin.name}",
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
        }
    }
}