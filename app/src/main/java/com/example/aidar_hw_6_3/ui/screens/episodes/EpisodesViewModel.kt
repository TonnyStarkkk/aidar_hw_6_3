package com.example.aidar_hw_6_3.ui.screens.episodes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import com.example.aidar_hw_6_3.data.dto.episode.EpisodeDTO
import com.example.aidar_hw_6_3.data.repository.EpisodesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class EpisodesViewModel(
    private val episodesRepository: EpisodesRepository
) : ViewModel() {

    private val _episodesStateFlow = MutableStateFlow<PagingData<EpisodeDTO>>(PagingData.empty())
    val episodeStateFlow: StateFlow<PagingData<EpisodeDTO>> get() = _episodesStateFlow

    fun fetchAllEpisodes() {
        viewModelScope.launch {
            episodesRepository.fetchAllEpisodes().flow.collectLatest {
                _episodesStateFlow.value = it
            }
        }
    }
}