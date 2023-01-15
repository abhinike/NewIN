package com.example.newsin.viewmodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsin.model.Article
import com.example.newsin.model.News
import com.example.newsin.network.newservice
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsViewModel : ViewModel() {

    var NewsListResponse: List<Article> by mutableStateOf(listOf())
    var errormessege : String by mutableStateOf("Error")

    var queryForSearch : String by mutableStateOf("in")

    var url : String by mutableStateOf("https://boingboing.net/2022/12/28/right-wing-dating-app-a-flop.html")


    fun getNews(query : String){

        val news = newservice.newsInstance.getHeadlines(query, 1)

        news.enqueue(object : Callback<News>{
            override fun onResponse(call: Call<News>, response: Response<News>) {
                val news = response.body()
                if(news != null){
                    NewsListResponse = news.articles


                }


//                Log.d("news", "${news.toString()}")
            }

            override fun onFailure(call: Call<News>, t: Throwable) {

//                Log.d("news", "${t.toString()}")

            }
        })


    }

}