package com.example.aidar_hw_6_3.ui.screens.episodes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.aidar_hw_6_3.data.dto.episode.EpisodeDTO
import com.example.aidar_hw_6_3.data.repository.EpisodesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class EpisodesViewModel(
    private val episodesRepository: EpisodesRepository
): ViewModel() {

    private val _episodesStateFlow = MutableStateFlow<List<EpisodeDTO>>(emptyList())
    val episodeStateFlow: StateFlow<List<EpisodeDTO>> get() = _episodesStateFlow

    fun fetchAllEpisodes() {
        viewModelScope.launch(Dispatchers.IO) {
            episodesRepository.fetchAllEpisodes()?.let {
                _episodesStateFlow.value = it
            }
        }
    }
}