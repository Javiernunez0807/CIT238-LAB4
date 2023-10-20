package com.codepath.flixterpt2

import android.support.annotation.Keep
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Locale


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
    @SerialName("known_for")
    val knownForMovie: List<KnownFor>?,

    ): java.io.Serializable {
    val mediaImageUrl = "https://image.tmdb.org/t/p/w500$multimedia"
}

@Keep
@Serializable
data class KnownFor(
    @SerialName("title")
    val title: String? = null,
    @SerialName("poster_path")
    val knownForMultimedia: String? = null,
    @SerialName("release_date")
    val releaseDate: String? = null,
    @SerialName("overview")
    val overview: String? = null,
): java.io.Serializable{
    val mediaImageUrl = "https://image.tmdb.org/t/p/w500$knownForMultimedia"
    val formattedReleaseDate: String?
    get(){
        if(releaseDate != null) {
            val inputFormat = SimpleDateFormat("yyyy-MM-dd", Locale.US)
            val outputFormat = SimpleDateFormat("MMM d, yyyy", Locale.US)
            return try {
                val date = inputFormat.parse(releaseDate)
                outputFormat.format(date)
            } catch (e: ParseException) {
                null
            }
        }
        return null
    }
}



