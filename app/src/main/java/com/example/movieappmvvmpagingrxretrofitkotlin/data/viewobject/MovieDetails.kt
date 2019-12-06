package com.example.movieappmvvmpagingrxretrofitkotlin.data.viewobject


import com.google.gson.annotations.SerializedName

data class MovieDetails(
    val budget: Int,
    val id: Int,
/*    @SerializedName("imdb_id")
    val imdbId: String,
    @SerializedName("original_language")
    val originalLanguage: String,
    @SerializedName("original_title")
    val originalTitle: String,*/
    val overview: String,
    val popularity: Double,
    @SerializedName("poster_path")
    val posterPath: String,
    @SerializedName("release_date")
    val releaseDate: String,
    val revenue: Int,
    val runtime: Int,
/*    @SerializedName("spoken_languages")
    val spokenLanguages: List<SpokenLanguage>,*/
    val status: String,
    val tagline: String,
    val title: String,
    val video: Boolean,
    @SerializedName("vote_average")
    //val voteAverage: Double
    val rating: Double//thay voteAverage
/*    @SerializedName("vote_count")
    val voteCount: Int*/
)

//xoa data class SpokenLanguage vi tao ra nhung k dung den