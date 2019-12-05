package com.example.movieappmvvmpagingrxretrofitkotlin.ui.single_movie_details

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.example.movieappmvvmpagingrxretrofitkotlin.R
import com.example.movieappmvvmpagingrxretrofitkotlin.data.api.POSTER_BASE_URL
import com.example.movieappmvvmpagingrxretrofitkotlin.data.api.TheMovieDBClient
import com.example.movieappmvvmpagingrxretrofitkotlin.data.api.TheMovieDBInterface
import com.example.movieappmvvmpagingrxretrofitkotlin.data.ropository.NetworkState
import com.example.movieappmvvmpagingrxretrofitkotlin.data.viewobject.MovieDetails
import kotlinx.android.synthetic.main.activity_single_movie.*
import java.text.NumberFormat
import java.util.*

class SingleMovieActivity : AppCompatActivity() {
    private lateinit var viewModel: SingleMovieViewModel
    private lateinit var movieRepository: MovieDetailRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single_movie)

        val movieId : Int = intent.getIntExtra("id", 1)

        val apiService: TheMovieDBInterface = TheMovieDBClient.getClient()
        movieRepository= MovieDetailRepository(apiService)

        viewModel = getViewModel(movieId)
        viewModel.movieDetails.observe(this, Observer {
            bindUI(it)
        })

        viewModel.networkState.observe(this, Observer {
            progressBar.visibility= if (it== NetworkState.LOADING) View.VISIBLE else View.GONE
            txvError.visibility = if(it== NetworkState.ERROR) View.VISIBLE else View.GONE
        })



    }

    fun bindUI(it: MovieDetails) {
        txvMovieTitle.text = it.title
        txvMovieTagLine.text = it.tagline
        txvMovieReleaseDate.text = it.releaseDate
        txvMovieRating.text = it.rating.toString()
        txvMovieRunTime.text = it.runtime.toString()
        txvMovieOveriew.text= it.overview

        val formatCurrency = NumberFormat.getCurrencyInstance(Locale.US)
        txvMovieBudget.text = formatCurrency.format(it.budget)
        txvMovieReneue.text = formatCurrency.format(it.revenue)

        val moviePosterURL = POSTER_BASE_URL + it.posterPath
        Glide.with(this).load(moviePosterURL).into(ivMoviePoster)



    }

    private fun getViewModel(movieId: Int): SingleMovieViewModel{
        return ViewModelProviders.of(this, object : ViewModelProvider.Factory{
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                @Suppress("UNCHECKED_CAST")
                return SingleMovieViewModel(movieRepository, movieId) as T
            }
        })[SingleMovieViewModel::class.java]
    }
}
