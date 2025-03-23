package com.example.aidar_hw_6_3.ui.screens.characters

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.aidar_hw_6_3.data.dto.character.CharacterDTO
import com.example.aidar_hw_6_3.data.repository.CharactersRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CharactersViewModel(
    private val charactersRepository: CharactersRepository
) : ViewModel() {

    private val _charactersStateFlow = MutableStateFlow<List<CharacterDTO?>>(emptyList())
    val charactersStateFlow: StateFlow<List<CharacterDTO?>> get() = _charactersStateFlow

    fun fetchAllCharacters() {
        viewModelScope.launch {
            charactersRepository.fetchAllCharacters()?.let {
                _charactersStateFlow.value = it
            }
        }
    }
}