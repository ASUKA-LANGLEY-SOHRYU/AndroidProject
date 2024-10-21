package com.example.androidproject.data.model.anime

import com.google.gson.annotations.SerializedName


data class AnimeResponse (

    @SerializedName("data"       ) var data       : ArrayList<com.example.androidproject.data.model.anime.Data> = arrayListOf(),
    @SerializedName("pagination" ) var pagination : com.example.androidproject.data.model.anime.Pagination?     = com.example.androidproject.data.model.anime.Pagination()

)