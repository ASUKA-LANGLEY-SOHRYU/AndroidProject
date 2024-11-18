package com.example.androidproject.domain.provider.impl

import com.example.androidproject.domain.model.AnimeRequest
import com.example.androidproject.domain.provider.AnimeRequestProvider

class ChangingAnimeRequestProvider : AnimeRequestProvider {
    private var animeRequest = AnimeRequest(1, 20, "")

    override fun provideAnimeRequest(): AnimeRequest {
        return animeRequest
    }

    override fun changeRequest() {
        this.animeRequest = AnimeRequest(animeRequest.page + 1, animeRequest.limit, animeRequest.query)
    }
}