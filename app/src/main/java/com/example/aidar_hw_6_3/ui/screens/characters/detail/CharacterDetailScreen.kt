package com.example.aidar_hw_6_3.ui.screens.characters.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.aidar_hw_6_3.ui.models.Character

@Composable
fun CharacterDetailScreen(character: Character) {
    Column(
        modifier = Modifier
            .padding(16.dp)
    ) {
        Image(
            modifier = Modifier
                .size(200.dp),
            painter = rememberAsyncImagePainter(character.image),
            contentDescription = character.name
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Name: ${character.name}",
            style = MaterialTheme.typography.bodyLarge
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
            text = "Location: ${character.location}",
            style = MaterialTheme.typography.bodyMedium
        )
    }
}