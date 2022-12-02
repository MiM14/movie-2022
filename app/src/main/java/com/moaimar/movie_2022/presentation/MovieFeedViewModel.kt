package com.moaimar.movie_2022.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.moaimar.movie_2022.domain.GetMoviesFeedUseCase
import com.moaimar.movie_2022.domain.Movie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieFeedViewModel(private val getMoviesFeedUseCase: GetMoviesFeedUseCase) : ViewModel() {
    val movieFeedPublisher: MutableLiveData<MovieUiState> by lazy {
        MutableLiveData<MovieUiState>()
    }

    fun loadMovieFeed() {
        movieFeedPublisher.value = MovieUiState(isLoading = true)

        viewModelScope.launch(Dispatchers.IO) {
            val movieFeed = getMoviesFeedUseCase.execute()
            movieFeedPublisher.postValue(
                MovieUiState(
                    isLoading = false,
                    movieFeed = movieFeed
                )
            )
        }
    }

    data class MovieUiState(
        val isLoading: Boolean = false,
        val movieFeed: List<GetMoviesFeedUseCase.MovieFeed> = emptyList()
    )
}