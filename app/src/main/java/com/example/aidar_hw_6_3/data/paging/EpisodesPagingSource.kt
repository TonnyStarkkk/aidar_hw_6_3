package com.example.aidar_hw_6_3.data.paging

import androidx.core.net.toUri
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.aidar_hw_6_3.data.api.EpisodeApiService
import com.example.aidar_hw_6_3.data.dto.episode.EpisodeDTO
import okio.IOException
import retrofit2.HttpException

class EpisodesPagingSource(
    private val episodeApiService: EpisodeApiService
) : PagingSource<Int, EpisodeDTO>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, EpisodeDTO> {
        return try {
            val currentPage = params.key ?: 0

            val response = episodeApiService.fetchAllEpisodes(currentPage)

            val prevPage = currentPage.takeIf { it > 0 }?.minus(1)
            val nextPage =
                if (response.body()?.episodeInfoDTO?.next != null) {
                    response.body()?.episodeInfoDTO?.next?.toUri()?.getQueryParameter("page")
                        ?.toInt()
                } else null

            LoadResult.Page(
                data = response.body()?.episodes ?: emptyList(),
                prevKey = prevPage,
                nextKey = nextPage
            )
        } catch (e: IOException) {
            LoadResult.Error(e)
        } catch (httpEx: HttpException) {
            LoadResult.Error(httpEx)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, EpisodeDTO>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val closestPage = state.closestPageToPosition(anchorPosition)
            closestPage?.prevKey?.plus(1) ?: closestPage?.nextKey?.minus(1)
        }
    }
}