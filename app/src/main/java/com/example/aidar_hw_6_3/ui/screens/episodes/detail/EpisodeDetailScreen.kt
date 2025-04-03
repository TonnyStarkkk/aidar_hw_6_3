package com.example.aidar_hw_6_3.ui.screens.episodes.detail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EpisodeDetailScreen(
    episodeId: Int,
    navController: NavController,
    viewModel: EpisodeDetailViewModel = koinViewModel()
) {

    LaunchedEffect(episodeId) {
        viewModel.fetchSingleEpisode(episodeId)
    }

    val episode = viewModel.episodeDetailStateFlow.collectAsState()

    Scaffold(
        topBar = {
            episode.value?.let { episode ->
                CenterAlignedTopAppBar(
                    title = {
                        Text(
                            text = episode.name!!,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    },
                    navigationIcon = {
                        IconButton(onClick = {
                            navController.popBackStack()
                        }) {
                            Icon(
                                imageVector = Icons.Default.ArrowBack,
                                contentDescription = null
                            )
                        }
                    }
                )
            }
        }
    ) { paddingValues ->
        episode.value?.let { episode ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Name: ${episode.name}",
                        style = MaterialTheme.typography.bodyLarge,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "Air Date: ${episode.airDate}",
                        style = MaterialTheme.typography.bodyMedium
                    )
                    Text(
                        text = "Episode: ${episode.episode}",
                        style = MaterialTheme.typography.bodyMedium
                    )
                    Text(
                        text = "Created: ${episode.created}",
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
        }
    }
}