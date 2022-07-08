package com.berkaytuncel.animelist.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.berkaytuncel.animelist.model.Anime

class AnimeViewModel: ViewModel() {

    val animeLiveData = MutableLiveData<Anime>()

    fun getDataFromRoom() {
        val anime = Anime("Naruto", "720 episode", "Airred", "25 min per episodes", "10.0", "a, b", "www.ss.com")
        animeLiveData.value = anime

    }
}