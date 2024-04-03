package com.ic.newsapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.viewModelFactory
import com.ic.newsapp.Article
import com.ic.newsapp.repository.NewsRepository
import kotlinx.coroutines.launch

class MainViewModel(private val newsRepository: NewsRepository): ViewModel() {
    val newsListLive: LiveData<List<Article>>
    get() = newsRepository.newsList

    init{
        getDefaultNews()
    }

    fun getDefaultNews(){
        viewModelScope.launch {
            newsRepository.fetchNewsDefault()
        }
    }

    fun getUserSearchNews(string: String){
        viewModelScope.launch {
            newsRepository.fetchUserSearchedNews(string)
        }
    }
}