package com.moaimar.movie_2022.data.local

import com.moaimar.movie_2022.domain.Movie

interface MovieLocalDataRepository {
    fun save(movie: Movie)
    fun getMoviesFeed():List<Movie>
    fun getMovieDetail(movieId:String):Movie
}