package com.moaimar.movie_2022.domain

class GetMoviesFeedUseCase(private val repository: MovieRepository) {
    fun execute(): List<MovieFeed> {
        val movies = repository.getMovieFeed()

        val list = movies.map {

            MovieFeed(
                it.id,
                it.title,
                it.rating,
                it.year,
                it.poster
            )
        }
        return list
    }
    data class MovieFeed(
        val id: String,
        val title: String,
        val rating: String,
        val year: String,
        val poster: String
    )
}

