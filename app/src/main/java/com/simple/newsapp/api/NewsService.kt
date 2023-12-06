package com.simple.newsapp.api

import HeadlinesModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface NewsService {

    @GET("/v2/top-headlines")
    suspend fun getHeadlines(
        @Query(value = "country") country: String?,
        @Query(value = "category") category: String?,
        @Query(value = "sources") sources: String?,
        @Query(value = "q") q: String?,
        @Query(value = "pageSize") pageSize: Int?,
        @Query(value = "page") page: Int?,
        @Query(value = "apiKey") apiKey: String
        ): Response<HeadlinesModel>

}