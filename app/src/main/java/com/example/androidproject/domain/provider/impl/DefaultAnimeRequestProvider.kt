package com.example.androidproject.domain.provider.impl

import com.example.androidproject.domain.model.AnimeRequest
import com.example.androidproject.domain.provider.AnimeRequestProvider

class DefaultAnimeRequestProvider : AnimeRequestProvider {
    override fun provideAnimeRequest(): AnimeRequest {
        return AnimeRequest(
            page = 1,
            limit = 20,
            query = ""
        )
    }
}