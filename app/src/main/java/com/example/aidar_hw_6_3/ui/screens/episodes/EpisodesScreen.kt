package com.example.aidar_hw_6_3.ui.screens.episodes

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.aidar_hw_6_3.data.dto.episode.EpisodeDTO
import com.example.aidar_hw_6_3.ui.components.LoadState
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EpisodesScreen(
    navController: NavController,
    viewModel: EpisodesViewModel = koinViewModel(),
    listState: LazyListState
) {

    LaunchedEffect(Unit) {
        viewModel.fetchAllEpisodes()
    }

    val isRefreshing = viewModel.isRefreshing.collectAsState()
    val episodes = viewModel.episodeStateFlow.collectAsLazyPagingItems()

    PullToRefreshBox(
        isRefreshing = isRefreshing.value,
        onRefresh = {
            viewModel.refreshEpisodes()
        }
    ) {
        LoadState(
            loadState = episodes.loadState,
            onRetry = {
                episodes.retry()
            }
        )

        Column {
            LazyColumn(
                state = listState
            ) {
                items(
                    count = episodes.itemCount
                ) { index ->
                    val episode = episodes[index]
                    episode?.let {
                        EpisodeItem(episode) {
                            navController.navigate("episodeDetail/${episode.id}")
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun EpisodeItem(
    episode: EpisodeDTO,
    onClick: () -> Unit
) {

    var isPressed by remember { mutableStateOf(false) }
    val episodeHeight by animateDpAsState(
        targetValue = if (isPressed) 100.dp else 80.dp
    )

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(episodeHeight)
            .padding(16.dp)
            .clickable(
                onClick = {
                    isPressed = !isPressed
                    onClick()
                }
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Text(
                text = episode.name!!,
                style = MaterialTheme.typography.bodyLarge
            )
            Text(
                text = episode.episode!!,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}