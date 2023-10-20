package com.codepath.flixterpt2

import android.support.annotation.Keep
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Locale


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
    @SerialName("vote_average")
    val voteAverage: String?,
    @SerialName("vote_count")
    val voteCount: String?,

): java.io.Serializable {
    val mediaImageUrl = "https://image.tmdb.org/t/p/w500$multimedia"

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



