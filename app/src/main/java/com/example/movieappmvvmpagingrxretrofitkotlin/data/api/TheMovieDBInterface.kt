package com.example.movieappmvvmpagingrxretrofitkotlin.data.api

import com.example.movieappmvvmpagingrxretrofitkotlin.data.viewobject.MovieDetails
import com.example.movieappmvvmpagingrxretrofitkotlin.data.viewobject.MovieResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


//https://api.themoviedb.org/3/movie/popular?api_key=034bbd1b233d6726e0c7dc7f338657f9&page=1  //lay ra cac phim trong trang 1
//https://api.themoviedb.org/3/movie/330457?api_key=034bbd1b233d6726e0c7dc7f338657f9&page=1   //theo id cua phim
//https://image.tmdb.org/t/p/w342
//https:image.tmdb.org/t/p/w342/mbm8k3GFhXS0ROd9AD1gqYbIFbM.jpg  //lay ra hinh anh cua poster



interface TheMovieDBInterface {

    @GET("movie/popular")
    fun getPopularMovie(@Query("page")page: Int): Single<MovieResponse>

    @GET("movie/{movie_id}")
    fun getMovieDetails(@Path("movie_id") id: Int) : Single<MovieDetails>
    //Single nay co trong Rx, 2 thanh phan chinh la: observable va obser
    //can 1 gtri duy nhat nen dung Single

}