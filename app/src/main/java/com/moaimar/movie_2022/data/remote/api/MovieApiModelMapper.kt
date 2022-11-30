package com.moaimar.movie_2022.data.remote.api

import com.moaimar.movie_2022.domain.Movie

fun MovieApiModel.toDomain():Movie {
    return Movie(this.id, this.title, this.plot, this.genre, this.rating,this.year ,this.poster)
}