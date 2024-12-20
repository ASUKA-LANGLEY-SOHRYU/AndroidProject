package com.example.androidproject.domain.di

import com.example.androidproject.domain.provider.AnimeRequestProvider
import com.example.androidproject.domain.provider.impl.ChangingAnimeRequestProvider
import com.example.androidproject.domain.provider.impl.DefaultAnimeRequestProvider
import com.example.androidproject.domain.usecase.GetAnimeUseCase
import org.koin.dsl.module

val domainModule = module {
    single<AnimeRequestProvider> { ChangingAnimeRequestProvider() }
    single { GetAnimeUseCase(
        animeRepository = get(),
        animeRequestProvider = get()
    ) }
}