package com.example.androidproject.presenter.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androidproject.domain.model.Anime
import com.example.androidproject.domain.usecase.GetAnimeUseCase
import com.example.androidproject.presenter.mapper.AnimeListItemMapper
import com.example.androidproject.presenter.model.AnimeListItem
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class ListViewModel(
    private val getAnimeUseCase: GetAnimeUseCase,
    private val animeListItemMapper: AnimeListItemMapper
) : ViewModel() {

    private val _animes = MutableLiveData<MutableList<Anime>>(mutableListOf())
    val animes: LiveData<MutableList<Anime>> = _animes

    private val _animeListItems = MutableLiveData<MutableList<AnimeListItem>>(mutableListOf())
    val animeListItems: LiveData<MutableList<AnimeListItem>> = _animeListItems

    init {
        loadAnimeList()
    }

    private fun loadAnimeList(){
        getAnimeUseCase.execute()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe {
                _animes.value?.add(it)
                _animes.notifyObserver()

                _animeListItems.value?.add(animeListItemMapper.map(it))
                _animeListItems.notifyObserver()
            }
    }

    private fun <T> MutableLiveData<T>.notifyObserver() {
        this.value = this.value
    }
}