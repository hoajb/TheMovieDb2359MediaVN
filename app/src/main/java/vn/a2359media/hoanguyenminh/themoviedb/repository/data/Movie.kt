package vn.a2359media.hoanguyenminh.themoviedb.repository.data

import com.google.gson.annotations.SerializedName

/**
 * Created by Hoa Nguyen on Dec 14 2018.
 */
class Movie {
    @SerializedName("id")
    val id: Int = 0

    @SerializedName("poster_path")
    val posterPath: String = ""

    @SerializedName("vote_average")
    val voteAverage: Float = 0.0f

    @SerializedName("original_title")
    val originalTitle: String = ""
}