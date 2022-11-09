package com.moaimar.movie_2022.data.local.db

import com.moaimar.movie_2022.data.local.MovieLocalDataRepository
import com.moaimar.movie_2022.domain.Movie

class MovieLocalDbDataSource(private val dao: MovieDao): MovieLocalDataRepository {
    override fun save(movie: Movie) {
        dao.save(movie.toEntity())
    }

    override fun getMoviesFeed():List<Movie>{
        val movies = dao.getMoviesFeed().map{
            it.toDomain()
        }
    return movies
    }

    override fun getMovieDetail(movieId: String)=
        dao.getMovieDetail(movieId).toDomain()
}