package com.example.aidar_hw_6_3.ui.screens.characters

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.aidar_hw_6_3.data.dto.character.CharacterDTO
import com.example.aidar_hw_6_3.data.repository.CharactersRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class CharactersViewModel(
    private val charactersRepository: CharactersRepository
) : ViewModel() {

    private val _isRefreshing = MutableStateFlow(false)
    val isRefreshing: StateFlow<Boolean> = _isRefreshing

    private val _charactersStateFlow =
        MutableStateFlow<PagingData<CharacterDTO>>(PagingData.empty())
    val charactersStateFlow: StateFlow<PagingData<CharacterDTO>> get() = _charactersStateFlow


    fun fetchAllCharacters() {
        viewModelScope.launch {
            charactersRepository.fetchAllCharacters().flow
                .cachedIn(viewModelScope)
                .collectLatest {
                    _charactersStateFlow.value = it
                }
        }
    }

    fun refreshCharacters() {
        viewModelScope.launch {
            _isRefreshing.emit(true)
            try {
                fetchAllCharacters()
            } finally {
                _isRefreshing.emit(false)
            }
        }
    }
}


