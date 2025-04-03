package com.example.aidar_hw_6_3.data.paging

import androidx.core.net.toUri
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.aidar_hw_6_3.data.api.LocationApiService
import com.example.aidar_hw_6_3.data.dto.location.LocationDTO
import okio.IOException
import retrofit2.HttpException

class LocationsPagingSource(
    private val locationApiService: LocationApiService
) : PagingSource<Int, LocationDTO>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, LocationDTO> {
        return try {
            val currentPage = params.key ?: 0

            val response = locationApiService.fetchAllLocations(currentPage)

            val prevPage = currentPage.takeIf { it > 0 }?.minus(1)
            val nextPage =
                if (response.body()?.locationInfoDTO?.next != null) {
                    response.body()?.locationInfoDTO?.next?.toUri()?.getQueryParameter("page")
                        ?.toInt()
                } else null

            LoadResult.Page(
                data = response.body()?.locations ?: emptyList(),
                prevKey = prevPage,
                nextKey = nextPage
            )
        } catch (e: IOException) {
            LoadResult.Error(e)
        } catch (httpEx: HttpException) {
            LoadResult.Error(httpEx)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, LocationDTO>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val closestPage = state.closestPageToPosition(anchorPosition)
            closestPage?.prevKey?.plus(1) ?: closestPage?.nextKey?.minus(1)
        }
    }
}