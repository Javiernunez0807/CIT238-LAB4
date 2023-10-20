package com.codepath.flixterpt2

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class ActorDetailActivity: AppCompatActivity() {
    private lateinit var actorImageView: ImageView
    private lateinit var actorNameView: TextView

    private lateinit var actorKnownFor: TextView
    private lateinit var actorKnownImage: ImageView
    private lateinit var actorKnownRelease: TextView
    private lateinit var actorKnownOverview: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actordetail)

        actorImageView = findViewById(R.id.detailImage)
        actorNameView = findViewById(R.id.detailName)
        actorKnownFor = findViewById(R.id.knownFor)
        actorKnownImage = findViewById(R.id.knownForImage)
        actorKnownRelease = findViewById(R.id.knowForRelease)
        actorKnownOverview = findViewById(R.id.knownForOverview)


        val actor = intent.getSerializableExtra(ACTOR_EXTRA) as Actor

        actorNameView.text = actor.name
        actorKnownFor.text = actor.knownForMovie?.get(0)?.title
        actorKnownOverview.text = actor.knownForMovie?.get(0)?.overview
        actorKnownRelease.text = actor.knownForMovie?.get(0)?.formattedReleaseDate



        Glide.with(this)
            .load(actor.mediaImageUrl)
            .into(actorImageView)

        Glide.with(this)
            .load(actor.knownForMovie?.get(0)?.mediaImageUrl)
            .into(actorKnownImage)
        }
    }
