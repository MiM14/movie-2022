package com.moaimar.movie_2022.data.local.mem

import com.moaimar.app.data.MemDataStore
import com.moaimar.movie_2022.data.local.MovieLocalDataRepository
import com.moaimar.movie_2022.domain.Movie

class MovieLocalMemDataSource(private val dataStore:MemDataStore<Movie>): MovieLocalDataRepository {
    override fun save(movies: List<Movie>) {
        movies.forEach{movie ->
            dataStore.save(movie.id, movie)
        }
    }

    override fun getMoviesFeed() = dataStore.getFeed()

    override fun getMovieDetail(movieId: String) = dataStore.getDetail(movieId)
}