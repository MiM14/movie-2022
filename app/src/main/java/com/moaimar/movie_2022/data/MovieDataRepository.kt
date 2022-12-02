package com.moaimar.movie_2022.data

import com.moaimar.movie_2022.data.local.MovieLocalDataRepository
import com.moaimar.movie_2022.data.remote.MovieRemoteDataRepository
import com.moaimar.movie_2022.domain.Movie
import com.moaimar.movie_2022.domain.MovieRepository

class MovieDataRepository(
    private val localSource: MovieLocalDataRepository,
    private val remoteSource: MovieRemoteDataRepository
) : MovieRepository {
    override fun getMovieFeed(): List<Movie> {
        var movies = localSource.getMoviesFeed()
       //if (movies.isEmpty()) {
            movies = remoteSource.getMoviesFeed()
            localSource.save(movies)
        //}
        return movies
    }

    override fun getMovieDetail(movieId: String): Movie {
        return localSource.getMovieDetail(movieId) ?: remoteSource.getMovieDetail(movieId)
    }
}