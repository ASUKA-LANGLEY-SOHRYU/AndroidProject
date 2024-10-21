package com.example.androidproject.data.model.anime

import com.google.gson.annotations.SerializedName


data class Prop (

    @SerializedName("from"   ) var from   : com.example.androidproject.data.model.anime.From?   = com.example.androidproject.data.model.anime.From(),
    @SerializedName("to"     ) var to     : com.example.androidproject.data.model.anime.To?     = com.example.androidproject.data.model.anime.To(),
    @SerializedName("string" ) var string : String? = null

)