package com.codepath.flixterpt2

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide


private const val TAG = "DetailActivity"

class MovieDetailActivity : AppCompatActivity() {
    private lateinit var mediaImageView: ImageView
    private lateinit var titleTextView: TextView
    private lateinit var bylineTextView: TextView
    private lateinit var overviewTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_moviedetail)

        // TODO: Find the views for the screen
        mediaImageView = findViewById(R.id.movieImage)
        titleTextView = findViewById(R.id.movieTitle)
        overviewTextView = findViewById(R.id.movieOverview)

        // TODO: Get the extra from the Intent
        val movie = intent.getSerializableExtra(MOVIE_EXTRA) as Movie

        // TODO: Set the title, byline, and abstract information from the article
        titleTextView.text = movie.title
        overviewTextView.text = movie.overview

        // TODO: Load the media image
        Glide.with(this)
            .load(movie.mediaImageUrl)
            .into(mediaImageView)

    }
}