package com.moaimar.movie_2022.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.moaimar.movie_2022.R
import com.moaimar.movie_2022.domain.GetMoviesFeedUseCase

class MovieAdapter : RecyclerView.Adapter<MovieViewHolder>() {

    private val dataItems= mutableListOf<GetMoviesFeedUseCase.MovieFeed>()
    private var itemClick: ((String)->Unit)? =null

    fun setOnClickItem(itemClick: (String) -> Unit) {
        this.itemClick = itemClick
    }

    fun setDataItems(movies: List<GetMoviesFeedUseCase.MovieFeed>) {
        dataItems.clear()
        dataItems.addAll(movies)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_movie_feed, parent,false)

        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(dataItems[position], itemClick)
    }

    override fun getItemCount() = dataItems.size
}