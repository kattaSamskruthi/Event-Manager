package com.ic.newsapp.network

import com.ic.newsapp.ResponseDTO
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiService {
    @Headers("X-Api-Key: a4c94ad3813c4c358995bae93465e1ab")
    @GET("top-headlines?country=in")
    suspend fun getTopHeadlines(): ResponseDTO

    @Headers("X-Api-Key: a4c94ad3813c4c358995bae93465e1ab ")
    @GET("top-headlines")
    suspend fun getSearchHeadlines(@Query("q") query: String): ResponseDTO
}

