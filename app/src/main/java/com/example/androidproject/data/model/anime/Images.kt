package com.example.androidproject.data.model.anime

import com.google.gson.annotations.SerializedName


data class Images (

    @SerializedName("jpg"  ) var jpg  : com.example.androidproject.data.model.anime.Jpg?  = com.example.androidproject.data.model.anime.Jpg(),
    @SerializedName("webp" ) var webp : com.example.androidproject.data.model.anime.Webp? = com.example.androidproject.data.model.anime.Webp()

)