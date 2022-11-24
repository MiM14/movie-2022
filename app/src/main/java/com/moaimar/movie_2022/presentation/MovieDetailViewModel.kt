package com.moaimar.movie_2022.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.moaimar.movie_2022.domain.Movie

class MovieDetailViewModel(): ViewModel() {
    val movieDetailPublisher: MutableLiveData<Movie> by lazy{
        MutableLiveData<Movie>()
    }


}