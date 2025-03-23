package com.example.aidar_hw_6_3.data.room

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

@Entity
data class FavoritesCharacter(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String? = null,
    val status: String? = null,
    val image: String? = null
)

val MIGRATION_1_2 = object : Migration(1, 2) {
    override fun migrate(db: SupportSQLiteDatabase) {
        db.execSQL("ALTER TABLE FavoritesCharacter ADD COLUMN image TEXT")
    }
}