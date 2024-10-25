package com.example.androidproject.data.mapper

import com.example.androidproject.app.core.mapper.IMapper
import com.example.androidproject.data.exception.api.BadResponse
import com.example.androidproject.data.model.anime.Data
import com.example.androidproject.domain.model.Anime

class AnimeMapper: IMapper<Data, Anime> {
    override fun map(input: Data): Anime {
        return Anime(
            id = input.malId ?: throw BadResponse(),
            title = input.title  ?: throw BadResponse(),
            description = input.synopsis ?: "",
            smallImageUrl = input.images?.jpg?.imageUrl  ?: throw BadResponse(),
        )
    }
}