package com.example.inshorts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getData()
    }

    private fun getData() {
        val news = NewsService.instanceOfInterface.getNews("in",1)
        news.enqueue(object: Callback<News?>{
            override fun onResponse(call: Call<News?>, response: Response<News?>) {
                val news = response.body()
                if (news!=null){
                    var adapter = MyAdapter(this@MainActivity, news.articles)
                    viewPager.adapter = adapter
                    Log.d("status","no error")
                }
            }

            override fun onFailure(call: Call<News?>, t: Throwable) {
                Log.d("status","error: $t")
            }
        })
    }
}