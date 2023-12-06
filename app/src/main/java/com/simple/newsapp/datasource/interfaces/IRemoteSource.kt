package com.simple.newsapp.datasource.interfaces

import HeadlinesModel
import retrofit2.Response

interface IRemoteSource {

    suspend fun getHeadlines(
        country: String?,
        category: String?,
        sources: String?,
        q: String?,
        pageSize: Int?,
        page: Int?,
        apiKey: String
    ): Response<HeadlinesModel>
}