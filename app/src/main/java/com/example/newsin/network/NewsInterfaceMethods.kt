package com.example.newsin.network

import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.newsin.Component.NewsList
import com.example.newsin.model.Article
import com.example.newsin.model.News
import com.example.newsin.viewmodel.NewsViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


fun getNews(){
    val viewModel = NewsViewModel()
    val news = newservice.newsInstance.getHeadlines("in", 1)

    news.enqueue(object : Callback<News>{
        override fun onResponse(call: Call<News>, response: Response<News>) {
            val news = response.body()
            if(news != null){
                viewModel.NewsListResponse = news.articles

            }


           Log.d("news", "${news.toString()}")
        }

        override fun onFailure(call: Call<News>, t: Throwable) {

            Log.d("news", "${t.toString()}")

        }
    })


}
