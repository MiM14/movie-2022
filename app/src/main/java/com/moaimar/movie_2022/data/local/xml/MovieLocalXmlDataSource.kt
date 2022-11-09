package com.moaimar.movie_2022.data.local.xml

import com.moaimar.movie_2022.data.local.MovieLocalDataRepository
import com.moaimar.movie_2022.domain.Movie

class MovieLocalXmlDataSource(): MovieLocalDataRepository{
    override fun save(movie: Movie) {
        TODO("Not yet implemented")
    }

    override fun getMoviesFeed(): List<Movie> {
        TODO("Not yet implemented")
    }

    override fun getMovieDetail(movieId: String): Movie {
        TODO("Not yet implemented")
    }

}