package com.moaimar.movie_2022.data.remote

import com.moaimar.movie_2022.domain.Movie

interface MovieRemoteDataRepository{
    fun getMoviesFeed():List<Movie>
    fun getMovieDetail(movieId:String): Movie
}