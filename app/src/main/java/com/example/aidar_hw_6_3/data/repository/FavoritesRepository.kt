package com.example.aidar_hw_6_3.data.repository

import com.example.aidar_hw_6_3.data.room.FavoritesCharacter
import com.example.aidar_hw_6_3.data.room.FavoritesDao

class FavoritesRepository(
    private val favoritesDao: FavoritesDao
) {

    suspend fun getAllFavorites(): List<FavoritesCharacter> {
        return favoritesDao.getAllFavorites()
    }

    suspend fun addFavoritesCharacter(favoritesCharacter: FavoritesCharacter) {
        return favoritesDao.addFavoritesCharacter(favoritesCharacter)
    }

    suspend fun deleteFavoritesCharacter(favoritesCharacter: FavoritesCharacter) {
        return favoritesDao.deleteFavoritesCharacter(favoritesCharacter)
    }
}