package vn.a2359media.hoanguyenminh.themoviedb.repository.data

import com.google.gson.annotations.SerializedName

/**
 * Created by Hoa Nguyen on Dec 16 2018.
 */

open class BaseReturnData() {

    @SerializedName("status_message")
    var statusMessage: String = ""

    @SerializedName("success")
    var success: Boolean = true

    @SerializedName("status_code")
    var statusCode: Int = STATUS_OK

    companion object {
        const val STATUS_OK: Int = -1
    }
}