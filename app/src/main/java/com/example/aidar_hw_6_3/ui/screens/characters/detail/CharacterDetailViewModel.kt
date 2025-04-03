package com.example.aidar_hw_6_3.ui.screens.characters.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.aidar_hw_6_3.data.dto.character.CharacterDTO
import com.example.aidar_hw_6_3.data.repository.CharactersRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CharacterDetailViewModel(
    private val charactersRepository: CharactersRepository
): ViewModel() {

    private val _characterDetailStateFlow = MutableStateFlow<CharacterDTO?>(null)
    val characterDetailStateFlow: StateFlow<CharacterDTO?> get() = _characterDetailStateFlow

    fun fetchSingleCharacter(characterId: Int) {
        viewModelScope.launch {
            try {
                val character = charactersRepository.fetchSingleCharacter(characterId)
                _characterDetailStateFlow.value = character
            } catch (e: Exception) {
                _characterDetailStateFlow.value = null
            }
        }
    }
}