package com.berkaytuncel.animelist.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.berkaytuncel.animelist.model.Anime

class FeedViewModel: ViewModel() {

    val anime = MutableLiveData<List<Anime>>()
    val animeError = MutableLiveData<Boolean>()
    val animeLoading = MutableLiveData<Boolean>()

    fun refreshData() {

        val anime = Anime("Naruto", "720 episode", "Airred", "25 min per episodes", "10.0", "a, b", "www.ss.com")
        val anime2 = Anime("Bleach", "366 episodes", "Airing", "24 min per episodes", "10.0", "c, d", "www.dd.com")
        val anime3 = Anime("Black Clover", "170 episodes", "Airing", "23 min per episodes", "10.0", "f, g", "www.ff.com")

        val animeList = arrayListOf<Anime>(anime, anime2, anime3)

        this.anime.value = animeList
        animeError.value = false
        animeLoading.value = false
    }
}