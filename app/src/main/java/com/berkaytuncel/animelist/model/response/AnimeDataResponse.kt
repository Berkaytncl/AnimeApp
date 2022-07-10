package com.berkaytuncel.animelist.model.response

import com.berkaytuncel.animelist.model.enum.DatumType
import com.berkaytuncel.animelist.model.enum.Source
import com.berkaytuncel.animelist.model.enum.Status

data class AnimeDataResponse(
    val pagination: Pagination,
    val data: List<Datum>
) {

    data class Datum(
        val url: String,
        val images: Map<String, Image>,
        val trailer: Trailer,
        val title: String,
        val type: DatumType,
        val source: Source,
        val episodes: Long? = null,
        val status: Status,
        val airing: Boolean,
        val duration: String,
        val score: Double,
        val rank: Long,
        val popularity: Long,
        val members: Long,
        val favorites: Long,
        val synopsis: String,
        val background: String? = null,
        val year: Long? = null,
        val themes: List<Demographic>,
    )

    data class Demographic(
        val name: String,
        val url: String
    )

    data class Image(
        val imageURL: String,
    )

    data class Trailer(
        val url: String? = null,
    )

    data class Pagination(
        val lastVisiblePage: Long,
        val hasNextPage: Boolean,
        val currentPage: Long,
        val items: Items
    )

    data class Items(
        val total: Long,
    )
}