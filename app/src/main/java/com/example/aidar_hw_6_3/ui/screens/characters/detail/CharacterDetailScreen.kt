package com.example.aidar_hw_6_3.ui.screens.characters.detail

import androidx.compose.foundation.Image
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.aidar_hw_6_3.R
import com.example.aidar_hw_6_3.ui.models.Character

@Composable
fun CharacterDetailScreen(character: Character) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .size(200.dp),
                painter = painterResource(R.drawable.ic_image),
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
                text = "Location: ${character.location}",
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}