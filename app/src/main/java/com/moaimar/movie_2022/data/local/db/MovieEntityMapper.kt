package com.moaimar.movie_2022.data.local.db

import com.moaimar.movie_2022.domain.Movie

fun MovieEntity.toDomain():Movie{
    return Movie(this.id,this.title,this.plot,this.genre,this.rating,this.poster)
}

fun Movie.toEntity():MovieEntity {
    return MovieEntity(this.id,this.title,this.plot,this.genre,this.rating,this.poster)
}