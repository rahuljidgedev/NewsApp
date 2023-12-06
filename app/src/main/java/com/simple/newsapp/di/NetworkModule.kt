package com.simple.newsapp.di

import com.simple.newsapp.api.NewsService
import com.simple.newsapp.datasource.RemoteSourceImpl
import com.simple.newsapp.datasource.interfaces.IRemoteSource
import com.simple.newsapp.repository.NewRepositoryImpl
import com.simple.newsapp.repository.interfaces.INewsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        val logger = HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BASIC }
        val client = OkHttpClient.Builder()
            .addInterceptor(logger)
            .build()
        return Retrofit.Builder()
            .baseUrl("https://newsapi.org")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideNewsService(retrofit: Retrofit): NewsService{
        return retrofit.create(NewsService::class.java)
    }

    @Singleton
    @Provides
    fun provideRemoteSource(newsService: NewsService): IRemoteSource
    = RemoteSourceImpl(newsService)

    @Singleton
    @Provides
    fun provideNewsRepository(remoteSource: RemoteSourceImpl): INewsRepository
    = NewRepositoryImpl(remoteSource)
}