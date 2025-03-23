package com.example.aidar_hw_6_3.ui.screens.locations
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.aidar_hw_6_3.data.dto.location.LocationDTO
import com.example.aidar_hw_6_3.data.repository.LocationsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class LocationsViewModel(
    private val locationsRepository: LocationsRepository
): ViewModel() {

    private val _locationsStateFlow = MutableStateFlow<List<LocationDTO>>(emptyList())
    val locationsStateFlow: StateFlow<List<LocationDTO>> get() = _locationsStateFlow

    fun fetchAllLocations() {
        viewModelScope.launch {
            locationsRepository.fetchAllLocations()?.let {
                _locationsStateFlow.value = it
            }
        }
    }
}