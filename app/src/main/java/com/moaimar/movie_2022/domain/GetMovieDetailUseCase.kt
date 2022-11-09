package com.moaimar.movie_2022.domain

class GetMovieDetailUseCase(private val repository: MovieRepository){
    fun execute() = repository.getMovieDetail()
}