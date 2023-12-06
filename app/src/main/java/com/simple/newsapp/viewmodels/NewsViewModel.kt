package com.simple.newsapp.viewmodels

import Article
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.simple.newsapp.repository.interfaces.INewsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    private var repository: INewsRepository
): ViewModel() {
    private val _headlines = MutableStateFlow<List<Article>>(emptyList())
    val headlines: StateFlow<List<Article>>
        get() = _headlines
    init {
        viewModelScope.launch {
            val result = repository.getHeadlines(
                "in",
                "",
                "",
                "",
                50,
                0,
                "Your-api-key"
            )

            if(result.isSuccessful && result.body()!!.articles.isNotEmpty()){
            _headlines.emit(result.body()!!.articles)
        }
        }
    }

    suspend fun getHeadlines(
        country: String?,
        category: String?,
        sources: String?,
        q: String?,
        pageSize: Int?,
        page: Int?,
        apiKey: String
    ){
        viewModelScope.launch {
            val result = repository.getHeadlines(
                country,
                category,
                sources,
                q,
                pageSize,
                page,
                apiKey
            )
            if(result.isSuccessful && result.body()!!.articles.isNotEmpty()){
                _headlines.emit(result.body()!!.articles)
            }
        }
    }
}