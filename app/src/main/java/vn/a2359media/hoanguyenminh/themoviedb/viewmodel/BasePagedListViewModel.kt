package vn.a2359media.hoanguyenminh.themoviedb.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import vn.a2359media.hoanguyenminh.themoviedb.repository.data.Listing

/**
 * Created by Hoa Nguyen on Dec 05 2018.
 */

abstract class BasePagedListViewModel<Model>(application: Application) : BaseViewModel(application) {
    protected var apiResult: MutableLiveData<Listing<Model>> = MutableLiveData()

    abstract fun loadListData()

    fun refresh() {
        apiResult.value?.refresh?.invoke()
    }

    fun retry() {
        val listing = apiResult.value
        listing?.retry?.invoke()
    }

    val pagedListInvestments = Transformations.switchMap(apiResult) { it.pagedList }
    val networkState = Transformations.switchMap(apiResult) { it.networkState }
    val refreshState = Transformations.switchMap(apiResult) { it.refreshState }

}