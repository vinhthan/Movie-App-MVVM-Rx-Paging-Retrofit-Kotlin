package com.example.movieappmvvmpagingrxretrofitkotlin.ui.popular_movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.movieappmvvmpagingrxretrofitkotlin.data.api.POST_PER_PAGE
import com.example.movieappmvvmpagingrxretrofitkotlin.data.api.TheMovieDBInterface
import com.example.movieappmvvmpagingrxretrofitkotlin.data.ropository.MovieDataSource
import com.example.movieappmvvmpagingrxretrofitkotlin.data.ropository.MovieDataSourceFactory
import com.example.movieappmvvmpagingrxretrofitkotlin.data.ropository.NetworkState
import com.example.movieappmvvmpagingrxretrofitkotlin.data.viewobject.Movie
import io.reactivex.disposables.CompositeDisposable

class MoviePagedListReporytory (private val apiService: TheMovieDBInterface){

    lateinit var moviePageList: LiveData<PagedList<Movie>>
    lateinit var movieDataSourceFactory: MovieDataSourceFactory

    fun fetchLiveMoviePagedList(compositeDisposable: CompositeDisposable): LiveData<PagedList<Movie>> {
        movieDataSourceFactory = MovieDataSourceFactory(apiService, compositeDisposable)

        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setPageSize(POST_PER_PAGE)
            .build()

        moviePageList = LivePagedListBuilder(movieDataSourceFactory, config).build()
        return moviePageList

    }

    fun getNetworkState(): LiveData<NetworkState>{
        return Transformations.switchMap<MovieDataSource, NetworkState>(
            movieDataSourceFactory.moviesLivaDataSource, MovieDataSource::networkState)

    }


}