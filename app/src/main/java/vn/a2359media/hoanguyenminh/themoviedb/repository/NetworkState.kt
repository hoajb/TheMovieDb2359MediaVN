package com.app.seedin.structure.repository

/**
 * Created by Hoa Nguyen on Dec 16 2018.
 *
 */
enum class Status {
    RUNNING,
    SUCCESS,
    FAILED
}

@Suppress("DataClassPrivateConstructor")
data class NetworkState private constructor(
        val status: Status,
        val msg: String? = null
) {
    companion object {
        val LOADED = NetworkState(Status.SUCCESS)
        val LOADING = NetworkState(Status.RUNNING)
        fun error(msg: String?) =
                NetworkState(Status.FAILED, msg)
    }
}