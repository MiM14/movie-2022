package com.moaimar.movie_2022.data.local.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface MovieDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun save(movie:MovieEntity): Long

    @Query("SELECT * FROM $MOVIE_TABLE_NAME")
    fun getMoviesFeed(): List<MovieEntity>

    @Query("SELECT * FROM $MOVIE_TABLE_NAME WHERE id = :movieId")
    fun getMovieDetail(movieId:String): MovieEntity
}