package com.moaimar.movie_2022.data.remote.api

import com.moaimar.movie_2022.data.remote.MovieRemoteDataRepository
import com.moaimar.movie_2022.domain.Movie

class MovieRemoteDataSource(): MovieRemoteDataRepository{
    private val api= MovieApiService()

    override fun getMoviesFeed()=
        api.getAll().map{
            it.toDomain()
        }
    override fun getMovieDetail(movieId:String):Movie{
        return api.findById(movieId)!!.toDomain()
    }
}