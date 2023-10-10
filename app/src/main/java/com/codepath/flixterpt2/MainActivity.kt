package com.codepath.flixterpt2

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.codepath.asynchttpclient.AsyncHttpClient
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler
import com.codepath.flixterpt2.databinding.ActivityMainBinding

import kotlinx.serialization.json.Json
import okhttp3.Headers
import org.json.JSONException

fun createJson() = Json {
    isLenient = true
    ignoreUnknownKeys = true
    useAlternativeNames = false
}

private const val TAG = "MainActivity/"
private const val SEARCH_API_KEY = BuildConfig.API_KEY
private const val POPULAR_MOVIES_URL = "https://api.themoviedb.org/3/movie/popular?api_key=${SEARCH_API_KEY}"
private const val POPULAR_ACTORS_URL = "https://api.themoviedb.org/3/person/popular?api_key=${SEARCH_API_KEY}"

class MainActivity : AppCompatActivity() {
    private lateinit var articlesRecyclerView: RecyclerView
    private lateinit var actorsRecyclerView: RecyclerView
    private lateinit var binding: ActivityMainBinding
    private val movies = mutableListOf<com.codepath.flixterpt2.Movie>()
    private val actors = mutableListOf<Actor>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        articlesRecyclerView = findViewById(R.id.articles)
        actorsRecyclerView = findViewById(R.id.actors)

    /// SETTING UP BOTH ADAPTERS
        // TODO: Set up MovieAdapter with movies
        val movieAdapter = MovieAdapter(this, movies)
        articlesRecyclerView.adapter = movieAdapter
        // TODO: Set up ActorAdapter with Actor
        val actorAdapter = ActorAdapter(this, actors)
        actorsRecyclerView.adapter = actorAdapter

        articlesRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        actorsRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        val client = AsyncHttpClient()
        client.get(POPULAR_MOVIES_URL, object : JsonHttpResponseHandler() {
            override fun onFailure(
                statusCode: Int,
                headers: Headers?,
                response: String?,
                throwable: Throwable?
            ) {
                Log.e(TAG, "Failed to fetch movies: $statusCode")
            }

            override fun onSuccess(statusCode: Int, headers: Headers, json: JSON) {
                Log.i(TAG, "Successfully fetched movies: $json")
                try {
                    // TODO: Create the parsedJSON
                        val parsedJson = createJson().decodeFromString(
                            BaseResponse.serializer(),
                            json.jsonObject.toString()
                        )
                    // TODO: Do something with the returned json (contains article information)
                    // TODO: Save the articles and reload the screen
                        parsedJson.results?.let {list ->
                            movies.addAll(list)
                            movieAdapter.notifyDataSetChanged()
                        }
                } catch (e: JSONException) {
                    Log.e(TAG, "Exception: $e")
                }
            }

        })

        client.get(POPULAR_ACTORS_URL, object : JsonHttpResponseHandler() {
            override fun onFailure(
                statusCode: Int,
                headers: Headers?,
                response: String?,
                throwable: Throwable?
            ) {
                Log.e(TAG, "Failed to fetch actors: $statusCode")
            }

            override fun onSuccess(statusCode: Int, headers: Headers, json: JSON) {
                Log.i(TAG, "Successfully fetched actors: $json")
                try{
                    val parsedJson = createJson().decodeFromString(
                        Response.serializer(),
                        json.jsonObject.toString()
                    )

                    parsedJson.results?.let { list ->
                        actors.addAll(list)
                        actorAdapter.notifyDataSetChanged()
                    }
                    } catch (e: JSONException) {
                        Log.e(TAG, "Exception: $e")
                }
            }
        })


    }
}