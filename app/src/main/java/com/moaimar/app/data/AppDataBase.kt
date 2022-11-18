package com.moaimar.app.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.moaimar.movie_2022.data.local.db.MovieDao
import com.moaimar.movie_2022.data.local.db.MovieEntity

@Database(entities = [MovieEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
}
