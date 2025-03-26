package com.example.aidar_hw_6_3.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.aidar_hw_6_3.data.api.LocationApiService
import com.example.aidar_hw_6_3.data.dto.location.LocationDTO
import com.example.aidar_hw_6_3.data.paging.LocationsPagingSource

class LocationsRepository(
    private val locationApiService: LocationApiService
) {

    fun fetchAllLocations(): Pager<Int, LocationDTO> {
        return Pager(
            config = PagingConfig(
                pageSize = 20,
                enablePlaceholders = false,
                prefetchDistance = 10
            ),
            pagingSourceFactory = {
                LocationsPagingSource(locationApiService)
            }
        )
    }

    suspend fun fetchSingleLocation(id: Int) : LocationDTO {
        return locationApiService.fetchSingleLocation(id)
    }
}