package com.ic.newsapp.Adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ic.newsapp.Article
import com.ic.newsapp.R
import com.ic.newsapp.databinding.RowItemBinding

class NewsAdapter: RecyclerView.Adapter<NewsViewHolder>(){


    private var newsList: List<Article> = emptyList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val binding: RowItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context), R.layout.row_item, parent, false)
        return NewsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
     val article = newsList.get(position)
        holder.binding.title =  article.title
        holder.binding.content = article.content
        val imageView = holder.binding.newsImage
        Glide.with(imageView.context).load(article.urlToImage).into(imageView)

    }

    override fun getItemCount(): Int {
return newsList.size
    }

    fun setData(list: List<Article>){
        newsList = list
        notifyDataSetChanged()
    }

}

class NewsViewHolder ( val binding: RowItemBinding): RecyclerView.ViewHolder(binding.root){

}

