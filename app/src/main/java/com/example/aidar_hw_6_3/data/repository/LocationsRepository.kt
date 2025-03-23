package com.example.aidar_hw_6_3.data.repository

import com.example.aidar_hw_6_3.data.api.LocationApiService
import com.example.aidar_hw_6_3.data.dto.location.LocationDTO

class LocationsRepository(
    private val locationApiService: LocationApiService
) {

    suspend fun fetchAllLocations(): List<LocationDTO>? {
        val response = locationApiService.fetchAllLocations()

        return if (response.isSuccessful) {
            response.body()?.locations
        } else {
            emptyList()
        }
    }

    suspend fun fetchSingleLocation(id: Int) : LocationDTO {
        return locationApiService.fetchSingleLocation(id)
    }
}