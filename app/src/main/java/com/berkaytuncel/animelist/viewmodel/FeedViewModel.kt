package com.berkaytuncel.animelist.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.berkaytuncel.animelist.model.response.AnimeDataResponse

import com.berkaytuncel.animelist.service.AnimeAPIServis
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class FeedViewModel: ViewModel() {

    private val animeAPIServis = AnimeAPIServis()
    private val disposable = CompositeDisposable()

    val anime = MutableLiveData<AnimeDataResponse>()
    val animeError = MutableLiveData<Boolean>()
    val animeLoading = MutableLiveData<Boolean>()

    fun refreshData() {
        getDataFromAPI()
    }

    private fun getDataFromAPI() {
        animeLoading.value = true

        disposable.add(
            animeAPIServis.getData()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object: DisposableSingleObserver<AnimeDataResponse>(){
                    override fun onSuccess(t: AnimeDataResponse) {
                        anime.value = t
                        animeError.value = false
                        animeLoading.value = false
                    }

                    override fun onError(e: Throwable) {
                        animeError.value = true
                        animeLoading.value = false
                        e.printStackTrace()
                    }
                })
        )
    }
}