package vn.a2359media.hoanguyenminh.themoviedb.repository.data

import com.google.gson.annotations.SerializedName

/**
 * Created by Hoa Nguyen on Dec 16 2018.
 */

open class BaseListReturnData<T> : BaseItems<T>() {
    override fun getListItems(): List<T> {
        return results
    }

    @SerializedName("page")
    var page: Int = 0
    @SerializedName("total_pages")
    var totalPages: Int = 0
    @SerializedName("total_results")
    var totalResults: Int = 0
    @SerializedName("results")
    var results: ArrayList<T> = ArrayList()


}