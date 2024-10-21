package com.example.androidproject.data.datasource.api.retrofit

import com.example.androidproject.data.model.anime.AnimeResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface AnimeApiService {

    @GET("/v4/anime")
    fun getAll(
        @Query("page") page: Int,
        @Query("limit") limit: Int,
        @Query("q") query: String
    ): Observable<AnimeResponse>
}