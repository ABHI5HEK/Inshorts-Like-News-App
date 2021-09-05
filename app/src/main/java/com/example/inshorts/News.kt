package com.example.inshorts

data class News(val articles: List<Articles>)
data class Articles(val title:String, val description: String,val url: String, val urlToImage:String, val author:String)
