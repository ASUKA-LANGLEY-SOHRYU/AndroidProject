package com.example.androidproject.domain.repository

import com.example.androidproject.domain.model.Anime
import io.reactivex.Observable

interface AnimeRepository {
    fun getListOfAnime(page: Int, limit: Int, query: String): Observable<Anime>
}