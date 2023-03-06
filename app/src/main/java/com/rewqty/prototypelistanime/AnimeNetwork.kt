package com.rewqty.prototypelistanime

import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import com.rewqty.prototypelistanime.model.Anime
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object AnimeNetwork {
    val listType = object : TypeToken<MutableList<Anime>>() {}.type
    val gson = GsonBuilder()
        .registerTypeAdapter(listType, AnimeDeserializer())
        .create()
    val apiKeyHeader = OkHttpClient.Builder().apply {
        addInterceptor(
            Interceptor { chain ->
                val builder = chain.request().newBuilder()
                builder.header("X-MAL-CLIENT-ID", BuildConfig.API_KEY)
                return@Interceptor chain.proceed(builder.build())
            }
        )
    }.build()
    val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://api.myanimelist.net/v2/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(apiKeyHeader)
            .build()
            .create(AnimeAPI::class.java)
    }
}