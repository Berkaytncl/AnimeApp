package com.berkaytuncel.animelist.service

import com.berkaytuncel.animelist.model.response.AnimeDataResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface AnimeAPI {

    //GET, POST

    //BASE_URL -> https://api.jikan.moe/v4/
    //ext -> anime

    @GET("anime")
    fun getAnime(
       @Query("page") page:Int,
    ): Single<AnimeDataResponse>

}