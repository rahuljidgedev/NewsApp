package com.simple.newsapp.repository

import HeadlinesModel
import com.simple.newsapp.datasource.interfaces.IRemoteSource
import com.simple.newsapp.repository.interfaces.INewsRepository
import retrofit2.Response
import javax.inject.Inject

class NewRepositoryImpl @Inject constructor(private val remoteSource: IRemoteSource) :
    INewsRepository {

    override suspend fun getHeadlines(
        country: String?,
        category: String?,
        sources: String?,
        q: String?,
        pageSize: Int?,
        page: Int?,
        apiKey: String
    ): Response<HeadlinesModel> {
        return remoteSource.getHeadlines(
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