package com.example.androidproject.presenter.di

import com.example.androidproject.presenter.mapper.AnimeListItemMapper
import com.example.androidproject.presenter.ui.details.AnimeDetailsViewModel
import com.example.androidproject.presenter.ui.list.ListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presenterModule = module{
    viewModel{
        ListViewModel(
            getAnimeUseCase = get(),
            animeListItemMapper = get(),
            animeRequestProvider = get(),
        )
    }
    viewModel {
        AnimeDetailsViewModel()
    }
    single { AnimeListItemMapper() }
}