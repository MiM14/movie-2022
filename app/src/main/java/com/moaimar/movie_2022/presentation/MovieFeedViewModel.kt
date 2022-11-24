package com.moaimar.movie_2022.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.moaimar.movie_2022.domain.GetMoviesFeedUseCase
import com.moaimar.movie_2022.domain.Movie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieFeedViewModel(private val getMoviesFeedUseCase: GetMoviesFeedUseCase) : ViewModel() {
    private val movieFeedPublisher: MutableLiveData<Movie> by lazy {
        MutableLiveData<Movie>()
    }
    fun loadMovieFeed(){
        viewModelScope.launch(Dispatchers.IO){
            movieFeedPublisher.postValue(getMoviesFeedUseCase.execute())
        }
    }
}