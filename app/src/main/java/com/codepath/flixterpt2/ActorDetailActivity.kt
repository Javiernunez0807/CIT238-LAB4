package com.codepath.flixterpt2

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import org.w3c.dom.Text

class ActorDetailActivity: AppCompatActivity() {
    private lateinit var actorImageView: ImageView
    private lateinit var actorNameView: TextView
    private lateinit var actorKnownFor: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actordetail)

        actorImageView = findViewById(R.id.detailImage)
        actorNameView = findViewById(R.id.detailName)


        val actor = intent.getSerializableExtra(ACTOR_EXTRA) as Actor

        actorNameView.text = actor.name


        Glide.with(this)
            .load(actor.mediaImageUrl)
            .into(actorImageView)
    }
}