package com.moaimar.movie_2022.data.remote.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface MovieApiEndPoints{
    @GET("movies")
    fun getAll(): Call<List<MovieApiModel>>

    @GET("movies/{movieId}")
    fun findById(@Path("movieId") id:String): Call<MovieApiModel>
}