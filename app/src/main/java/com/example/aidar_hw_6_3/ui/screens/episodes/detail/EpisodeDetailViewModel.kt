package com.example.aidar_hw_6_3.ui.screens.episodes.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.aidar_hw_6_3.data.dto.episode.EpisodeDTO
import com.example.aidar_hw_6_3.data.repository.EpisodesRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class EpisodeDetailViewModel(
    private val episodesRepository: EpisodesRepository
) : ViewModel() {

    private val _episodeDetailStateFlow = MutableStateFlow<EpisodeDTO?>(null)
    val episodeDetailStateFlow: StateFlow<EpisodeDTO?> get() = _episodeDetailStateFlow

    fun fetchSingleEpisode(episodeId: Int) {
        viewModelScope.launch {
            try {
                val location = episodesRepository.fetchSingleEpisode(episodeId)
                _episodeDetailStateFlow.value = location
            } catch (e: Exception) {
                _episodeDetailStateFlow.value = null
            }
        }
    }
}