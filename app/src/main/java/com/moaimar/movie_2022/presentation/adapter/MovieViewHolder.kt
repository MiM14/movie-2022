package com.moaimar.movie_2022.presentation.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.moaimar.app.extensions.loadUrl
import com.moaimar.movie_2022.databinding.ItemMovieFeedBinding
import com.moaimar.movie_2022.domain.GetMoviesFeedUseCase

class MovieViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
    fun bind(movies: GetMoviesFeedUseCase.MovieFeed, itemClick: ((String) -> Unit)?) {
        val binding = ItemMovieFeedBinding.bind(view)
        binding.feedImage.loadUrl(movies.poster)
        binding.title.text = movies.title
        binding.rating.text = movies.rating
        binding.year.text = movies.year
        view.setOnClickListener {
            itemClick?.invoke(movies.id)
        }
    }
}