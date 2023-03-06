package com.rewqty.prototypelistanime

import com.rewqty.prototypelistanime.model.Anime
import retrofit2.http.GET
import retrofit2.http.Headers

interface AnimeAPI {
    @GET("anime/ranking?ranking_type=all&limit=50&fields=title")
    suspend fun getAnimeTop(): List<Anime>
}