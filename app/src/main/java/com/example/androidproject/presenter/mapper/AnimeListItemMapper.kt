package com.example.androidproject.presenter.mapper

import com.example.androidproject.app.core.mapper.IMapper
import com.example.androidproject.domain.model.Anime
import com.example.androidproject.presenter.model.AnimeListItem

class AnimeListItemMapper: IMapper<Anime, AnimeListItem> {
    override fun map(input: Anime): AnimeListItem {
        return AnimeListItem(
            title = input.title,
            description = input.description,
            smallImageUrl = input.smallImageUrl
        )
    }
}