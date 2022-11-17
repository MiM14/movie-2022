package com.moaimar.movie_2022.data.local.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

const val MOVIE_TABLE_NAME = "movie"

@Entity(tableName = MOVIE_TABLE_NAME)
data class MovieEntity(
    @PrimaryKey @ColumnInfo(name = "id") val id: String,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "plot") val plot: String,
    @ColumnInfo(name = "genre") val genre: String,
    @ColumnInfo(name = "rating") val rating: String,
    @ColumnInfo(name = "year") val year: String,
    @ColumnInfo(name = "poster") val poster: String
)
