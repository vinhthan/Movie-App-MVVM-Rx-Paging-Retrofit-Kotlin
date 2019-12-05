package com.example.movieappmvvmpagingrxretrofitkotlin.ui.single_movie_details

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.movieappmvvmpagingrxretrofitkotlin.data.ropository.NetworkState
import com.example.movieappmvvmpagingrxretrofitkotlin.data.viewobject.MovieDetails
import io.reactivex.disposables.CompositeDisposable

class  SingleMovieViewModel(private val movieRepository: MovieDetailRepository, movieId: Int): ViewModel(){

    private val compositeDisposable = CompositeDisposable()

    //lay chi tiet phim
    val movieDetails: LiveData<MovieDetails> by lazy {
        movieRepository.fetchSingleMovieDetails(compositeDisposable, movieId)
    }

    val networkState: LiveData<NetworkState> by lazy {
        movieRepository.getMovieDetailsNetworkState()
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }



}