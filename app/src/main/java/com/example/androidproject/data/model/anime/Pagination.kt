package com.example.androidproject.data.model.anime

import com.google.gson.annotations.SerializedName


data class Pagination (

  @SerializedName("last_visible_page" ) var lastVisiblePage : Int?     = null,
  @SerializedName("has_next_page"     ) var hasNextPage     : Boolean? = null,
  @SerializedName("items"             ) var items           : com.example.androidproject.data.model.anime.Items?   = com.example.androidproject.data.model.anime.Items()

)