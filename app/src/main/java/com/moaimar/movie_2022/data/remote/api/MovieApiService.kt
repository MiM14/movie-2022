package com.moaimar.movie_2022.data.remote.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MovieApiService {

    private val url = "https://movies-and-shows-api.cyclic.app/"
    private var apiEndPoints: MovieApiEndPoints

    init {
        apiEndPoints = buildApiEndPoint()
    }
    private fun buildClient(): Retrofit{
        return Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    }

    private fun buildApiEndPoint(): MovieApiEndPoints {
        return buildClient().create(MovieApiEndPoints::class.java)
    }

    fun getAll(): List<MovieApiModel>{
        val callMovies = apiEndPoints.getAll()
        val response = callMovies.execute()
        return if (response.isSuccessful){
            response.body()!!
        }else{
            emptyList()
        }
    }

    fun findById(movieId:String): MovieApiModel?{
        val callMovie = apiEndPoints.findById(movieId)
        val response = callMovie.execute()
        return if (response.isSuccessful){
            response.body()
        }else{
            null
        }
    }
}