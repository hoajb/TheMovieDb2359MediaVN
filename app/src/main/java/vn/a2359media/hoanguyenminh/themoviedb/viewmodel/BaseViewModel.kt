package vn.a2359media.hoanguyenminh.themoviedb.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.app.seedin.structure.repository.NetworkState

/**
 * Created by Hoa Nguyen on 2018 November 30.
 *
 */
open class BaseViewModel(application: Application) : AndroidViewModel(application) {
    var networkStateGlobal: MutableLiveData<NetworkState> = MutableLiveData()

}