package com.moaimar.movie_2022.domain

class GetMovieDetailUseCase(private val repository: MovieRepository) {
    fun execute(movieId: String): MovieDetail {
        val movie = repository.getMovieDetail(movieId)
        return MovieDetail(
            movie.id,
            movie.title,
            movie.rating,
            movie.plot,
            movie.genre,
            movie.year,
            movie.poster
        )
    }

    data class MovieDetail(
        val id: String,
        val title: String,
        val rating: String,
        val plot: String,
        val genre: String,
        val year: String,
        val poster: String
    )
}