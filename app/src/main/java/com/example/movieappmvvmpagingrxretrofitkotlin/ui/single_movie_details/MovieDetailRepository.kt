package com.example.movieappmvvmpagingrxretrofitkotlin.ui.single_movie_details

import androidx.lifecycle.LiveData
import com.example.movieappmvvmpagingrxretrofitkotlin.data.api.TheMovieDBInterface
import com.example.movieappmvvmpagingrxretrofitkotlin.data.ropository.MovieDetailsNetworkDataSource
import com.example.movieappmvvmpagingrxretrofitkotlin.data.ropository.NetworkState
import com.example.movieappmvvmpagingrxretrofitkotlin.data.viewobject.MovieDetails
import io.reactivex.disposables.CompositeDisposable

class MovieDetailRepository(private val apiService: TheMovieDBInterface) {

    lateinit var movieDetailsNetworkDataSource: MovieDetailsNetworkDataSource

    fun fetchSingleMovieDetails (compositeDisposable: CompositeDisposable, movieId: Int) : LiveData<MovieDetails>{
        movieDetailsNetworkDataSource = MovieDetailsNetworkDataSource(apiService, compositeDisposable)
        movieDetailsNetworkDataSource.fetchMovieDetails(movieId)

        return movieDetailsNetworkDataSource.downloadMovieDetailsResponse

    }

    fun getMovieDetailsNetworkState(): LiveData<NetworkState>{
        return movieDetailsNetworkDataSource.networkState
    }


}