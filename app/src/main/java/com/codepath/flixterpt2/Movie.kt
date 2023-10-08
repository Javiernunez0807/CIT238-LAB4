package com.codepath.flixterpt2

import android.support.annotation.Keep
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Keep
@Serializable
data class BaseResponse(
    @SerialName("results")
    val results: List<Movie>?
)

@Keep
@Serializable
data class Movie(
    @SerialName("overview")
    val overview: String?,
    @SerialName("release_date")
    val releaseDate: String?,
    @SerialName("title")
    val title: String?,
    @SerialName("poster_path")
    val multimedia: String?,
): java.io.Serializable {
    val mediaImageUrl = "https://image.tmdb.org/t/p/w500$multimedia"}

