package com.example.aidar_hw_6_3.ui.screens.locations.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.aidar_hw_6_3.data.dto.location.LocationDTO
import com.example.aidar_hw_6_3.data.repository.LocationsRepository
import com.example.aidar_hw_6_3.ui.models.Location
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class LocationDetailViewModel(
    private val locationsRepository: LocationsRepository
): ViewModel() {

    private val _locationDetailStateFlow = MutableStateFlow<LocationDTO?>(null)
    val locationDetailStateFlow: StateFlow<LocationDTO?> get() = _locationDetailStateFlow

    fun fetchSingleLocation(locationId: Int) {
        viewModelScope.launch {
            try {
                val location = locationsRepository.fetchSingleLocation(locationId)
                _locationDetailStateFlow.value = location
            } catch (e: Exception) {
                _locationDetailStateFlow.value = null
            }
        }
    }
}