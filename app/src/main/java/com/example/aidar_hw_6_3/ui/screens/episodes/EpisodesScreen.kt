package com.example.aidar_hw_6_3.ui.screens.episodes

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode.Companion.Screen
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.aidar_hw_6_3.ui.models.Episode
import com.example.aidar_hw_6_3.ui.models.mockEpisodes
import kotlinx.serialization.json.Json

@Composable
fun EpisodesScreen(navController: NavController) {
    Column {
        LazyColumn {
            items(mockEpisodes) { episode ->
                EpisodeItem(episode) {
                    navController.navigate("episodeDetail/${episode.id}")
                }
            }
        }
    }
}
@Composable
fun EpisodeItem(episode: Episode, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(
                onClick = onClick
            )
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Text(
                text = episode.name,
                style = MaterialTheme.typography.bodyLarge
            )
            Text(
                text = "Episode: ${episode.episode}",
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}