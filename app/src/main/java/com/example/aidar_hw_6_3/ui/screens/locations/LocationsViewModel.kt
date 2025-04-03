package com.example.aidar_hw_6_3.ui.screens.locations

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import com.example.aidar_hw_6_3.data.dto.location.LocationDTO
import com.example.aidar_hw_6_3.data.repository.LocationsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class LocationsViewModel(
    private val locationsRepository: LocationsRepository
) : ViewModel() {

    private val _isRefreshing = MutableStateFlow(false)
    val isRefreshing: StateFlow<Boolean> = _isRefreshing

    private val _locationsStateFlow = MutableStateFlow<PagingData<LocationDTO>>(PagingData.empty())
    val locationsStateFlow: StateFlow<PagingData<LocationDTO>> get() = _locationsStateFlow

    fun fetchAllLocations() {
        viewModelScope.launch {
            locationsRepository.fetchAllLocations().flow.collectLatest {
                _locationsStateFlow.value = it
            }
        }
    }

    fun refreshLocations() {
        viewModelScope.launch {
            _isRefreshing.emit(true)
            try {
                fetchAllLocations()
            } finally {
                _isRefreshing.emit(false)
            }
        }
    }
}