package com.example.androidproject.data.model.anime

import com.google.gson.annotations.SerializedName


data class Items (

  @SerializedName("count"    ) var count   : Int? = null,
  @SerializedName("total"    ) var total   : Int? = null,
  @SerializedName("per_page" ) var perPage : Int? = null

)