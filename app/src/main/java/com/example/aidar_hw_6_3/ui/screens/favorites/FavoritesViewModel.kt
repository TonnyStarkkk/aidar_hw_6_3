package com.example.aidar_hw_6_3.ui.screens.favorites

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.aidar_hw_6_3.data.repository.FavoritesRepository
import com.example.aidar_hw_6_3.data.room.FavoritesCharacter
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class FavoritesViewModel(
    private val favoritesRepository: FavoritesRepository
) : ViewModel() {

    private val _favoritesStateFlow = MutableStateFlow<List<FavoritesCharacter>>(emptyList())
    val favoritesStateFlow: StateFlow<List<FavoritesCharacter>> get() = _favoritesStateFlow

    fun getAllFavorites() {
        viewModelScope.launch {
            try {
                _favoritesStateFlow.value = favoritesRepository.getAllFavorites()
            } catch (e: Exception) {
                _favoritesStateFlow.value = emptyList()
            }
        }
    }

    fun addFavoritesCharacter(favoritesCharacter: FavoritesCharacter) {
        viewModelScope.launch {
            favoritesRepository.addFavoritesCharacter(favoritesCharacter)
            getAllFavorites()
        }
    }

    fun deleteFavoritesCharacter(favoritesCharacter: FavoritesCharacter) {
        viewModelScope.launch {
            favoritesRepository.deleteFavoritesCharacter(favoritesCharacter)
            getAllFavorites()
        }
    }
}