package vn.a2359media.hoanguyenminh.themoviedb.repository.paging

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import vn.a2359media.hoanguyenminh.themoviedb.repository.data.BaseItems
import vn.a2359media.hoanguyenminh.themoviedb.repository.remote.NetworkAPI

/**
 * Created by Hoa Nguyen on Dec 16 2018.
 *
 */

abstract class ItemDataSourceFactory<Item, Items : BaseItems<Item>, DSource : ItemDataSource<Item, Items>>
    (private val networkApi: NetworkAPI) : DataSource.Factory<Int, Item>() {
    abstract fun createDataSource(networkApi: NetworkAPI): DSource

    val sourceLiveData = MutableLiveData<DSource>()
    override fun create(): DataSource<Int, Item> {
        val source = createDataSource(networkApi)

        sourceLiveData.postValue(source)
        return source
    }
}