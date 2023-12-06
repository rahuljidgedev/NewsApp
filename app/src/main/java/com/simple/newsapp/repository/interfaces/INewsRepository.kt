package com.simple.newsapp.repository.interfaces

import HeadlinesModel
import retrofit2.Response

interface INewsRepository {

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