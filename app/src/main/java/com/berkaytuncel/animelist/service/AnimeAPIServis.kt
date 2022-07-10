package com.berkaytuncel.animelist.service

import com.berkaytuncel.animelist.model.response.AnimeDataResponse
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class AnimeAPIServis {

    //BASE_URL -> https://api.jikan.moe/v4/

    private val BASE_URL = "https://api.jikan.moe/v4/"
    private val api = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(AnimeAPI::class.java)

    fun getData(page: Int = 209): Single<AnimeDataResponse> {
        return api.getAnime(page)
    }
}