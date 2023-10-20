package com.codepath.flixterpt2

import com.codepath.asynchttpclient.AsyncHttpClient
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler


private const val TAG = "apiClient/"
private const val SEARCH_API_KEY = BuildConfig.API_KEY
private const val POPULAR_MOVIES_URL = "https://api.themoviedb.org/3/movie/popular?api_key=${SEARCH_API_KEY}"
private const val POPULAR_ACTORS_URL = "https://api.themoviedb.org/3/person/popular?api_key=${SEARCH_API_KEY}"
class getClient (callback: JsonHttpResponseHandler){
    class ApiClient {

        fun getPopularMovies(callback: JsonHttpResponseHandler) {
            val client = AsyncHttpClient()
            client.get(POPULAR_MOVIES_URL, callback)
        }

        fun getPopularActors(callback: JsonHttpResponseHandler) {
            val client = AsyncHttpClient()
            client.get(POPULAR_ACTORS_URL, callback)
        }
    }
}

