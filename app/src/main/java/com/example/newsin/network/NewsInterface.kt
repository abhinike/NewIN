package com.example.newsin.network
// https://newsapi.org/v2/everything?q=modi&from=2022-11-28&apiKey=ac7b8bf7d27e4616b86b4dd319702525
import com.example.newsin.model.API_KEY
import com.example.newsin.model.BASE_URL
import com.example.newsin.model.News
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsInterface {
    @GET("v2/everything?apiKey=$API_KEY")
    fun getHeadlines(@Query("q") query: String, @Query("page") page : Int) : Call<News>



}




