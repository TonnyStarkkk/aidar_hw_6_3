package com.example.aidar_hw_6_3.data.serviceLocator

import androidx.room.Room
import com.example.aidar_hw_6_3.BuildConfig
import com.example.aidar_hw_6_3.data.api.CharacterApiService
import com.example.aidar_hw_6_3.data.api.EpisodeApiService
import com.example.aidar_hw_6_3.data.api.LocationApiService
import com.example.aidar_hw_6_3.data.repository.CharactersRepository
import com.example.aidar_hw_6_3.data.repository.EpisodesRepository
import com.example.aidar_hw_6_3.data.repository.FavoritesRepository
import com.example.aidar_hw_6_3.data.repository.LocationsRepository
import com.example.aidar_hw_6_3.data.room.FavoritesDatabase
import com.example.aidar_hw_6_3.data.room.MIGRATION_1_2
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.module.Module
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val dataModule: Module = module {

    single { provideOkhttpClient() }

    single { provideRetrofit(get()) }

    single { get<Retrofit>().create(CharacterApiService::class.java) }

    single { get<Retrofit>().create(LocationApiService::class.java) }

    single { get<Retrofit>().create(EpisodeApiService::class.java) }

    single { CharactersRepository(get()) }

    single { LocationsRepository(get()) }

    single { EpisodesRepository(get()) }

    single {
        Room.databaseBuilder(
            get(), FavoritesDatabase::class.java,
            "favorites_db"
        )
            .addMigrations(MIGRATION_1_2)
            .build()
    }

    single { get<FavoritesDatabase>().favoritesDao() }

    single { FavoritesRepository(get()) }
}

private fun provideOkhttpClient(): OkHttpClient {
    return OkHttpClient.Builder()
        .connectTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        .build()
}

private fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()
}