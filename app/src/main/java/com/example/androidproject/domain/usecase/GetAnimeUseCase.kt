package com.example.androidproject.domain.usecase

import com.example.androidproject.domain.model.Anime
import com.example.androidproject.domain.provider.AnimeRequestProvider
import com.example.androidproject.domain.repository.AnimeRepository
import io.reactivex.Observable

class GetAnimeUseCase(
    private val animeRepository: AnimeRepository,
    private val animeRequestProvider: AnimeRequestProvider
){
    fun execute(): Observable<Anime>{
        val request = animeRequestProvider.provideAnimeRequest()
        return animeRepository.getListOfAnime(request.page, request.limit, request.query)
    }
}