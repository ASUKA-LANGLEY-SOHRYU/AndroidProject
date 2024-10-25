package com.example.androidproject.presenter.ui.list

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androidproject.domain.model.Anime
import com.example.androidproject.domain.provider.AnimeRequestProvider
import com.example.androidproject.domain.usecase.GetAnimeUseCase
import com.example.androidproject.presenter.mapper.AnimeListItemMapper
import com.example.androidproject.presenter.model.AnimeListItem
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class ListViewModel(
    private val getAnimeUseCase: GetAnimeUseCase,
    private val animeListItemMapper: AnimeListItemMapper,
    private val animeRequestProvider: AnimeRequestProvider
) : ViewModel() {

    private val _animes = MutableLiveData<MutableList<Anime>>(mutableListOf())
    val animes: LiveData<MutableList<Anime>> = _animes

    private val _animeListItems = MutableLiveData<MutableList<AnimeListItem>>(mutableListOf())
    val animeListItems: LiveData<MutableList<AnimeListItem>> = _animeListItems

    private val _isError = MutableLiveData(false)
    val isError: LiveData<Boolean> = _isError

    private val _error = MutableLiveData("")
    val error: LiveData<String> = _error

    init {
        loadAnimeList()
    }

    fun loadAnimeList() {
        getAnimeUseCase.execute()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe({
                _animes.value?.add(it)
                _animes.notifyObserver()

                _animeListItems.value?.add(animeListItemMapper.map(it))
                _animeListItems.notifyObserver()
            }, {
                _isError.value = true
                _isError.notifyObserver()

                _error.value = it.message
                _error.notifyObserver()
            })
    }

    fun loadMore() {
        animeRequestProvider.changeRequest()
        loadAnimeList()
    }

    private fun <T> MutableLiveData<T>.notifyObserver() {
        this.value = this.value
    }
}
