package com.moaimar.movie_2022.domain

interface MovieRepository{
    fun getMovieFeed(): List<Movie>
    fun getMovieDetail(movieId:String): Movie
}