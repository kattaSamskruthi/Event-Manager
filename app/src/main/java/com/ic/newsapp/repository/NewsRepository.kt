package com.ic.newsapp.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.newsapp.database.LocalDatabase
import com.ic.newsapp.Article
import com.ic.newsapp.network.ApiService
import javax.inject.Inject

class NewsRepository @Inject constructor(private val apiService: ApiService, private
val localDatabase: LocalDatabase){

    private val _newsList = MutableLiveData<List<Article>>()
    var newsList : LiveData<List<Article>> = _newsList

    suspend fun fetchNewsDefault() {
        val result = apiService.getTopHeadlines()
        if (result.status.toString().lowercase() == "ok") {
            localDatabase.getLocalDao().addArticles(result.articles)
            _newsList.postValue(result.articles)
        } else {
            _newsList.postValue(localDatabase.getLocalDao().getArticles())
        }
        Log.e("Repository", newsList.value.toString())
    }
        suspend fun fetchUserSearchedNews(string: String){
            val result = apiService.getSearchHeadlines(string)
            if(result.status.toString().lowercase() == "ok"){
                localDatabase.getLocalDao().addArticles(result.articles)
                _newsList.postValue(result.articles)
            }
            else{
                _newsList.postValue(localDatabase.getLocalDao().getArticles())
            }
            Log.e("Repository", newsList.value.toString())
        }


}