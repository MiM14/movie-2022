package com.moaimar.movie_2022.data.local.xml

import android.content.SharedPreferences
import com.moaimar.app.commons.KSerializer
import com.moaimar.movie_2022.data.local.MovieLocalDataRepository
import com.moaimar.movie_2022.domain.Movie

class MovieLocalXmlDataSource(private val sharedPref: SharedPreferences,private val kSerializer: KSerializer): MovieLocalDataRepository{
    private val editor = sharedPref.edit()

    override fun save(movies: List<Movie>) {
        movies.forEach{
             editor.putString(it.id,kSerializer.toJson(it, Movie::class.java))
        }
        editor.apply()
    }

    override fun getMoviesFeed(): List<Movie> {
        val movies: MutableList<Movie> = mutableListOf()
        sharedPref.all.map{
            movies.add(kSerializer.fromJson(it.value as String, Movie::class.java))
        }
        return movies
    }

    override fun getMovieDetail(movieId: String)=
        sharedPref.getString(movieId, null)?.let {
            kSerializer.fromJson(it, Movie::class.java)
    }
}