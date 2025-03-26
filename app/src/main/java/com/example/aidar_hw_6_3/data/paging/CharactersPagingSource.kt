package com.example.aidar_hw_6_3.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.aidar_hw_6_3.data.api.CharacterApiService
import com.example.aidar_hw_6_3.data.dto.character.CharacterDTO
import okio.IOException
import retrofit2.HttpException

class CharactersPagingSource(
    private val characterApiService: CharacterApiService
) : PagingSource<Int, CharacterDTO>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, CharacterDTO> {
        return try {
            val currentPage = params.key ?: 0

            val response = characterApiService.fetchAllCharacters(currentPage)

            val prevPage = if (currentPage > 0) currentPage.minus(1) else null
            val nextPage =
                if (response.body()?.pagingInfoDTO?.next != null) currentPage.plus(1) else null

            LoadResult.Page(
                data = response.body()?.characters ?: emptyList(),
                prevKey = prevPage,
                nextKey = nextPage
            )
        } catch (e: IOException) {
            LoadResult.Error(e)
        } catch (ex: HttpException) {
            LoadResult.Error(ex)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, CharacterDTO>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val closestPage = state.closestPageToPosition(anchorPosition)
            closestPage?.prevKey?.plus(1) ?: closestPage?.nextKey?.minus(1)
        }
    }
}