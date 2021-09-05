package com.example.inshorts

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import org.w3c.dom.Text

class MyAdapter(val context:Context, val newsdata: List<Articles>):RecyclerView.Adapter<MyAdapter.MyViewholder>(){

    inner class MyViewholder(itemView: View): RecyclerView.ViewHolder(itemView){
        var imageView = itemView.findViewById<ImageView>(R.id.imageView)
        var headline = itemView.findViewById<TextView>(R.id.NewsHeadline)
        var description = itemView.findViewById<TextView>(R.id.description)
        var footerLine = itemView.findViewById<TextView>(R.id.footerLine)
        var bottomLayout = itemView.findViewById<LinearLayout>(R.id.linearLayout2)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewholder {
        var inflater = LayoutInflater.from(context)
        var view = inflater.inflate(R.layout.viewpagerlayout,parent,false)
        return MyViewholder(view)
    }

    override fun onBindViewHolder(holder: MyViewholder, position: Int) {
        var data = newsdata[position]
        holder.headline.text = data.title
        holder.description.text = data.description
        holder.footerLine.text = data.author
        var news = data.url
        if (data.urlToImage != null){
            Glide.with(context).load(data.urlToImage).into(holder.imageView)
        }

        holder.bottomLayout.setOnClickListener(View.OnClickListener {
            var intent = Intent(context, Webpage::class.java)
            intent.putExtra("URL",news)
            context.startActivity(intent)
        })
    }

    override fun getItemCount(): Int {
        return newsdata.size
    }
}