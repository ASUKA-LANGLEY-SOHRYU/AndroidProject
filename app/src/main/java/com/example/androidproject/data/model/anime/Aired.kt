package com.example.androidproject.data.model.anime

import com.google.gson.annotations.SerializedName


data class Aired (

  @SerializedName("from" ) var from : String? = null,
  @SerializedName("to"   ) var to   : String? = null,
  @SerializedName("prop" ) var prop : com.example.androidproject.data.model.anime.Prop?   = com.example.androidproject.data.model.anime.Prop()

)