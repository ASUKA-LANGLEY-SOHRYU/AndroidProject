package com.example.androidproject.domain.model

data class AnimeRequest (
    val page: Int,
    val limit: Int,
    val query: String
)