package com.simple.newsapp.datasource

import HeadlinesModel
import com.simple.newsapp.api.NewsService
import com.simple.newsapp.datasource.interfaces.IRemoteSource
import retrofit2.Response
import javax.inject.Inject

class RemoteSourceImpl @Inject constructor(private val newsService: NewsService): IRemoteSource {
    override suspend fun getHeadlines(
        country: String?,
        category: String?,
        sources: String?,
        q: String?,
        pageSize: Int?,
        page: Int?,
        apiKey: String
    ): Response<HeadlinesModel> {
        return newsService.getHeadlines(
            country,
            category,
            sources,
            q,
            pageSize,
            page,
            apiKey
        )
    }

}