package com.example.aidar_hw_6_3.ui.serviceLocator

import com.example.aidar_hw_6_3.ui.screens.characters.CharactersViewModel
import com.example.aidar_hw_6_3.ui.screens.characters.detail.CharacterDetailViewModel
import com.example.aidar_hw_6_3.ui.screens.episodes.EpisodesViewModel
import com.example.aidar_hw_6_3.ui.screens.episodes.detail.EpisodeDetailViewModel
import com.example.aidar_hw_6_3.ui.screens.favorites.FavoritesViewModel
import com.example.aidar_hw_6_3.ui.screens.locations.LocationsViewModel
import com.example.aidar_hw_6_3.ui.screens.locations.detail.LocationDetailViewModel
import org.koin.core.module.Module
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val uiModule: Module = module {

    viewModel { CharactersViewModel(get()) }

    viewModel { CharacterDetailViewModel(get()) }

    viewModel { LocationsViewModel(get()) }

    viewModel { LocationDetailViewModel(get()) }

    viewModel { EpisodesViewModel(get()) }

    viewModel { EpisodeDetailViewModel(get()) }

    viewModel { FavoritesViewModel(get()) }

}