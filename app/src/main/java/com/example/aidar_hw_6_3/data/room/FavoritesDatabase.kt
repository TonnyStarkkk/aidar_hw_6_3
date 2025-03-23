package com.example.aidar_hw_6_3.data.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [FavoritesCharacter::class], version = 2, exportSchema = false)
abstract class FavoritesDatabase: RoomDatabase() {

    abstract fun favoritesDao(): FavoritesDao

}