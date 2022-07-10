package com.berkaytuncel.animelist.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.berkaytuncel.animelist.model.response.AnimeDataResponse

class AnimeViewModel: ViewModel() {

    val animeLiveData = MutableLiveData<AnimeDataResponse>()

    fun getDataFromRoom() {


    }
}