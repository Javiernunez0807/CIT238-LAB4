package com.codepath.flixterpt2

import android.os.Bundle
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide


private const val TAG = "DetailActivity"

class MovieDetailActivity : AppCompatActivity() {
    private lateinit var mediaImageView: ImageView
    private lateinit var titleTextView: TextView
    private lateinit var ratingBar: RatingBar
    private lateinit var overviewTextView: TextView
    private lateinit var countTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_moviedetail)

        // TODO: Find the views for the screen
        mediaImageView = findViewById(R.id.movieImage)
        titleTextView = findViewById(R.id.movieTitle)
        overviewTextView = findViewById(R.id.movieOverview)
        ratingBar = findViewById(R.id.movieRating)
        countTextView = findViewById(R.id.countView)

        // TODO: Get the extra from the Intent
        val movie = intent.getSerializableExtra(MOVIE_EXTRA) as Movie

        // TODO: Set the title, byline, and abstract information from the article
        titleTextView.text = movie.title
        overviewTextView.text = movie.overview
        ratingBar.rating = (
                (movie.voteAverage?.toFloat() ?: 0.0).toFloat())/2

        countTextView.text = movie.voteCount

        // TODO: Load the media image
        Glide.with(this)
            .load(movie.backdropImageUrl)
            .into(mediaImageView)

    }
}