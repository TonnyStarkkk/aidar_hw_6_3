package com.example.aidar_hw_6_3.data.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface FavoritesDao {

    @Query("SELECT * FROM favoritescharacter")
    suspend fun getAllFavorites(): List<FavoritesCharacter>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addFavoritesCharacter(favoritesCharacter: FavoritesCharacter)

    @Delete
    suspend fun deleteFavoritesCharacter(favoritesCharacter: FavoritesCharacter)

}