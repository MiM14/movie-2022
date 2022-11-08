package com.moaimar.movie_2022.data.remote

import com.moaimar.movie_2022.domain.Movie

class MovieRemoteDataSource{
    private val api= MovieApiService()

    fun getMoviesFeed()=
        api.getAll().map{
            it.toDomain()
        }
    fun getMovieDetail(movieId:String):Movie{
        return api.findById(movieId)!!.toDomain()
    }
}