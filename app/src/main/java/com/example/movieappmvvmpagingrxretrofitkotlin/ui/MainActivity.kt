package com.example.movieappmvvmpagingrxretrofitkotlin.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.movieappmvvmpagingrxretrofitkotlin.R
import com.example.movieappmvvmpagingrxretrofitkotlin.ui.single_movie_details.SingleMovieActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn.setOnClickListener {
            val intent = Intent(this, SingleMovieActivity::class.java)
            intent.putExtra("id", 2)
            this.startActivity(intent)
        }



    }
}
