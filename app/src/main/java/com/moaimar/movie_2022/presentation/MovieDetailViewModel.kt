package com.moaimar.movie_2022.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.moaimar.movie_2022.domain.GetMovieDetailUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieDetailViewModel(private val getMovieDetail: GetMovieDetailUseCase) : ViewModel() {
    val movieDetailPublisher: MutableLiveData<MovieDetailUiState> by lazy {
        MutableLiveData<MovieDetailUiState>()
    }

    fun loadMovieDetail(movieId: String) {

        viewModelScope.launch(Dispatchers.IO) {
            getMovieDetail.execute(movieId).apply {
                movieDetailPublisher.postValue(
                    MovieDetailUiState(
                        movieDetail = this
                    )
                )
            }
        }
    }

    data class MovieDetailUiState(
        val movieDetail: GetMovieDetailUseCase.MovieDetail? = null
    )
}