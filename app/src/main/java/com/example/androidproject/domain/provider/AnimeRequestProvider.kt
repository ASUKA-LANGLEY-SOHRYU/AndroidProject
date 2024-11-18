package com.example.androidproject.domain.provider

import com.example.androidproject.domain.model.AnimeRequest

interface AnimeRequestProvider {
    fun provideAnimeRequest(): AnimeRequest
    fun changeRequest()
}