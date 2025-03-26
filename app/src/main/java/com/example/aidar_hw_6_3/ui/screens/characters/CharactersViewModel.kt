package com.example.aidar_hw_6_3.ui.screens.characters

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.aidar_hw_6_3.data.dto.character.CharacterDTO
import com.example.aidar_hw_6_3.data.repository.CharactersRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class CharactersViewModel(
    private val charactersRepository: CharactersRepository
) : ViewModel() {

    private val _charactersStateFlow =
        MutableStateFlow<PagingData<CharacterDTO>>(PagingData.empty())
    val charactersStateFlow: StateFlow<PagingData<CharacterDTO>> get() = _charactersStateFlow

    fun fetchAllCharacters() {
        viewModelScope.launch(Dispatchers.IO) {
            val pagingData = charactersRepository.fetchAllCharacters().flow.cachedIn(viewModelScope)
            pagingData.collectLatest {
                _charactersStateFlow.value = it
            }
        }
    }
}


