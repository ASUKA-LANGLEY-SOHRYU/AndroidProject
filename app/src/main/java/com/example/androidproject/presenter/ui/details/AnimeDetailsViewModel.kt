package com.example.androidproject.presenter.ui.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AnimeDetailsViewModel(

): ViewModel() {

    private val _title = MutableLiveData("Anime")
    val title: LiveData<String> = _title

    fun setTitle(value: String) {
        _title.value = value
    }
}