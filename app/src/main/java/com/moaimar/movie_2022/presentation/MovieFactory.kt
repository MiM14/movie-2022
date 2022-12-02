package com.moaimar.movie_2022.presentation

import android.content.Context
import androidx.room.Room
import com.moaimar.app.data.AppDatabase
import com.moaimar.movie_2022.data.MovieDataRepository
import com.moaimar.movie_2022.data.local.db.MovieLocalDbDataSource
import com.moaimar.movie_2022.data.local.mem.MovieLocalMemDataSource
import com.moaimar.movie_2022.data.remote.api.MovieApiService
import com.moaimar.movie_2022.data.remote.api.MovieRemoteDataSource
import com.moaimar.movie_2022.domain.GetMovieDetailUseCase
import com.moaimar.movie_2022.domain.GetMoviesFeedUseCase


class MovieFactory {
    fun getMovieFeedViewModel(applicationContext: Context) =
        MovieFeedViewModel(getMovieFeedUseCase(applicationContext))


    fun getMovieDetailViewModel(applicationContext: Context) =
        MovieDetailViewModel(getMovieDetailUseCase(applicationContext))

    private fun getMovieFeedUseCase(applicationContext: Context) =
        GetMoviesFeedUseCase(
            MovieDataRepository(
                MovieLocalDbDataSource(DataBaseSingleton.getInstance(applicationContext).movieDao()),
                MovieRemoteDataSource()
            )
        )


    private fun getMovieDetailUseCase(applicationContext: Context) =
        GetMovieDetailUseCase(
            MovieDataRepository(
                MovieLocalDbDataSource(DataBaseSingleton.getInstance(applicationContext).movieDao()),
                MovieRemoteDataSource()
            )
        )


    object DataBaseSingleton {
        private var db: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            if (db == null) {
                db = Room.databaseBuilder(
                    context, AppDatabase::class.java, "db-movies"
                ).build()
            }
            return db!!
        }
    }
}