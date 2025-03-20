package com.example.aidar_hw_6_3.ui.screens.episodes.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.aidar_hw_6_3.ui.models.Episode

@Composable
fun EpisodeDetailScreen(episode: Episode) {
    Column(
        modifier = Modifier
            .padding(16.dp)
    ) {
        Text(
            text = "Name: ${episode.name}",
            style = MaterialTheme.typography.bodyLarge
        )
        Text(
            text = "Air Date: ${episode.airDate}",
            style = MaterialTheme.typography.bodyMedium
        )
        Text(
            text = "Episode: ${episode.episode}",
            style = MaterialTheme.typography.bodyMedium
        )
    }
}