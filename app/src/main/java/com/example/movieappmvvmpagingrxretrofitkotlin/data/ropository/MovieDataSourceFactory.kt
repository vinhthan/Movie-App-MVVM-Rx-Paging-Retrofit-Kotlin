package com.example.movieappmvvmpagingrxretrofitkotlin.data.ropository

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.example.movieappmvvmpagingrxretrofitkotlin.data.api.TheMovieDBInterface
import com.example.movieappmvvmpagingrxretrofitkotlin.data.viewobject.Movie
import io.reactivex.disposables.CompositeDisposable

class MovieDataSourceFactory(private val apiService: TheMovieDBInterface, private  val compositeDisposable: CompositeDisposable)
    : DataSource.Factory<Int, Movie>(){

    val moviesLivaDataSource = MutableLiveData<MovieDataSource>()

    override fun create(): DataSource<Int, Movie> {
        val movieDataSource = MovieDataSource(apiService, compositeDisposable)

        moviesLivaDataSource.postValue(movieDataSource)
        return  movieDataSource
    }

}