package com.example.inshorts

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

const val URL = "https://newsapi.org/"
const val API_KEY = "da93c97b9a444667aa14025a0aa44849"
interface NewsInterface {
    @GET("v2/top-headlines?apikey=$API_KEY")
    fun getNews(@Query("country")country:String, @Query("page")page:Int): Call<News>
}

object NewsService{
    val instanceOfInterface: NewsInterface

    init{
        val retrofit = Retrofit.Builder().baseUrl(URL).addConverterFactory(GsonConverterFactory.create()).build()
        instanceOfInterface = retrofit.create(NewsInterface::class.java)
    }
}