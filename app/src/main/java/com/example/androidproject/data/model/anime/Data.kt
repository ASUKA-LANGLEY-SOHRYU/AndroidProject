package com.example.androidproject.data.model.anime

import com.google.gson.annotations.SerializedName


data class Data (

    @SerializedName("mal_id"          ) var malId          : Int?                      = null,
    @SerializedName("url"             ) var url            : String?                   = null,
    @SerializedName("images"          ) var images         : com.example.androidproject.data.model.anime.Images?                   = com.example.androidproject.data.model.anime.Images(),
    @SerializedName("trailer"         ) var trailer        : com.example.androidproject.data.model.anime.Trailer?                  = com.example.androidproject.data.model.anime.Trailer(),
    @SerializedName("approved"        ) var approved       : Boolean?                  = null,
    @SerializedName("titles"          ) var titles         : ArrayList<com.example.androidproject.data.model.anime.Titles>         = arrayListOf(),
    @SerializedName("title"           ) var title          : String?                   = null,
    @SerializedName("title_english"   ) var titleEnglish   : String?                   = null,
    @SerializedName("title_japanese"  ) var titleJapanese  : String?                   = null,
    @SerializedName("title_synonyms"  ) var titleSynonyms  : ArrayList<String>         = arrayListOf(),
    @SerializedName("type"            ) var type           : String?                   = null,
    @SerializedName("source"          ) var source         : String?                   = null,
    @SerializedName("episodes"        ) var episodes       : Int?                      = null,
    @SerializedName("status"          ) var status         : String?                   = null,
    @SerializedName("airing"          ) var airing         : Boolean?                  = null,
    @SerializedName("aired"           ) var aired          : com.example.androidproject.data.model.anime.Aired?                    = com.example.androidproject.data.model.anime.Aired(),
    @SerializedName("duration"        ) var duration       : String?                   = null,
    @SerializedName("rating"          ) var rating         : String?                   = null,
    @SerializedName("score"           ) var score          : Double?                      = null,
    @SerializedName("scored_by"       ) var scoredBy       : Int?                      = null,
    @SerializedName("rank"            ) var rank           : Int?                      = null,
    @SerializedName("popularity"      ) var popularity     : Int?                      = null,
    @SerializedName("members"         ) var members        : Int?                      = null,
    @SerializedName("favorites"       ) var favorites      : Int?                      = null,
    @SerializedName("synopsis"        ) var synopsis       : String?                   = null,
    @SerializedName("background"      ) var background     : String?                   = null,
    @SerializedName("season"          ) var season         : String?                   = null,
    @SerializedName("year"            ) var year           : Int?                      = null,
    @SerializedName("broadcast"       ) var broadcast      : com.example.androidproject.data.model.anime.Broadcast?                = com.example.androidproject.data.model.anime.Broadcast(),
    @SerializedName("producers"       ) var producers      : ArrayList<com.example.androidproject.data.model.anime.Producers>      = arrayListOf(),
    @SerializedName("licensors"       ) var licensors      : ArrayList<com.example.androidproject.data.model.anime.Licensors>      = arrayListOf(),
    @SerializedName("studios"         ) var studios        : ArrayList<com.example.androidproject.data.model.anime.Studios>        = arrayListOf(),
    @SerializedName("genres"          ) var genres         : ArrayList<com.example.androidproject.data.model.anime.Genres>         = arrayListOf(),
    @SerializedName("explicit_genres" ) var explicitGenres : ArrayList<com.example.androidproject.data.model.anime.ExplicitGenres> = arrayListOf(),
    @SerializedName("themes"          ) var themes         : ArrayList<com.example.androidproject.data.model.anime.Themes>         = arrayListOf(),
    @SerializedName("demographics"    ) var demographics   : ArrayList<com.example.androidproject.data.model.anime.Demographics>   = arrayListOf()

)