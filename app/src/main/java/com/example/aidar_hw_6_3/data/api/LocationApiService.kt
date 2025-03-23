package com.example.aidar_hw_6_3.data.api

import com.example.aidar_hw_6_3.data.dto.location.LocationDTO
import com.example.aidar_hw_6_3.data.dto.location.LocationsResponseDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface LocationApiService {

    @GET("location")
    suspend fun fetchAllLocations(): Response<LocationsResponseDTO>

    @GET("location/{id}")
    suspend fun fetchSingleLocation(@Path("id") id: Int): LocationDTO
}