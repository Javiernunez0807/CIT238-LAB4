package com.codepath.flixterpt2

import android.support.annotation.Keep
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable



@Keep
@Serializable
data class Response(
    @SerialName("results")
    val results: List<Actor>?
)

@Keep
@Serializable
data class Actor(
    @SerialName("name")
    val name: String?,
    @SerialName("known_for_department")
    val knownFor: String?,
    @SerialName("profile_path")
    val multimedia: String?,

    ): java.io.Serializable {
    val mediaImageUrl = "https://image.tmdb.org/t/p/w500$multimedia"

}