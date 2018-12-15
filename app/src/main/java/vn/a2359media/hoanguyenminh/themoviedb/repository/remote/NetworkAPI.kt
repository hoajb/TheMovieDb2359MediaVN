package vn.a2359media.hoanguyenminh.themoviedb.repository.remote

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import vn.a2359media.hoanguyenminh.themoviedb.repository.data.MovieList

/**
 * Created by Hoa Nguyen on Dec 14 2018.
 */

interface NetworkAPI {
    @GET("movie/now_playing")
    fun getNowPlayingMovies(
        @Query("api_key") site: String,
        @Query("page") page: Int
    ): Call<MovieList>
}