package com.example.androidproject.data.repository

import com.example.androidproject.data.datasource.api.retrofit.AnimeApiService
import com.example.androidproject.data.mapper.AnimeMapper
import com.example.androidproject.domain.model.Anime
import com.example.androidproject.domain.repository.AnimeRepository
import io.reactivex.Observable

class AnimeRepositoryImpl(
    private val apiService: AnimeApiService,
    private val mapper: AnimeMapper
) : AnimeRepository {
    override fun getListOfAnime(page: Int, limit: Int, query: String): Observable<Anime> {
        return apiService.getAll(page, limit, query)
            .map { it.data }
            .flatMap {dataArray -> Observable.fromIterable(dataArray) }
            .map { data -> mapper.map(data)}
    }
}