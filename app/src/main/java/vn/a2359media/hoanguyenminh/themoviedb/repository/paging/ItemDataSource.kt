package vn.a2359media.hoanguyenminh.themoviedb.repository.paging

import androidx.lifecycle.MutableLiveData
import androidx.paging.PageKeyedDataSource
import com.app.seedin.structure.repository.NetworkState
import retrofit2.Call
import retrofit2.Response
import vn.a2359media.hoanguyenminh.themoviedb.repository.data.BaseItems
import vn.a2359media.hoanguyenminh.themoviedb.repository.remote.NetworkAPI
import java.io.IOException

/**
 * Created by Hoa Nguyen on Dec 16 2018.
 *
 */
abstract class ItemDataSource<Item, Items : BaseItems<Item>>(private val networkApi: NetworkAPI) : PageKeyedDataSource<Int, Item>() {
    abstract fun getRequest(page: Int): Call<Items>

    private var retry: (() -> Any)? = null

    val networkState = MutableLiveData<NetworkState>()

    val initialLoad = MutableLiveData<NetworkState>()

    fun retryAllFailed() {
        val prevRetry = retry
        retry = null
//        prevRetry?.let {
//            retryExecutor.execute {
//                it.invoke()
//            }
//        }

        prevRetry?.invoke()
    }

    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, Item>) {
        val initPage = 1
        val request = getRequest(initPage)

        networkState.postValue(NetworkState.LOADING)
        initialLoad.postValue(NetworkState.LOADING)

        try {
            val response = request.execute()
            val items = response.body()?.getListItems() ?: emptyList()
            retry = null
            networkState.postValue(NetworkState.LOADED)
            initialLoad.postValue(NetworkState.LOADED)

            val nextKey: Int? = if (items.isNotEmpty()) initPage + 1 else null
            callback.onResult(
                    items,
                    null,
                    nextKey
            )
        } catch (ioException: IOException) {
            retry = {
                loadInitial(params, callback)
            }
            val error = NetworkState.error(ioException.message ?: "unknown error")
            networkState.postValue(error)
            initialLoad.postValue(error)
        }
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Item>) {
        networkState.postValue(NetworkState.LOADING)
        val request = getRequest(params.key)
        request.enqueue(object : retrofit2.Callback<Items> {
            override fun onFailure(call: Call<Items>, t: Throwable) {
                retry = {
                    loadAfter(params, callback)
                }
                networkState.postValue(NetworkState.error(t.message ?: "unknown err"))
            }

            override fun onResponse(
                    call: Call<Items>,
                    response: Response<Items>) {
                if (response.isSuccessful) {
                    val items = response.body()?.getListItems() ?: emptyList()
                    retry = null
                    val nextKey: Int? = if (items.isNotEmpty()) params.key + 1 else null
                    callback.onResult(items, nextKey)
                    networkState.postValue(NetworkState.LOADED)
                } else {
                    retry = {
                        loadAfter(params, callback)
                    }
                    networkState.postValue(
                            NetworkState.error("error code: ${response.code()}")
                    )
                }
            }
        })
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Item>) {
    }
}