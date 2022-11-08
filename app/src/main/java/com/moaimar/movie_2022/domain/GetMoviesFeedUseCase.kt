package com.moaimar.movie_2022.domain

class GetMoviesFeedUseCase(private val repository:MovieRepository){
    fun execute() = repository.getMovieFeed()
}