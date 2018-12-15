package vn.a2359media.hoanguyenminh.themoviedb.repository.data

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.app.seedin.structure.repository.NetworkState

/**
 * Created by Hoa Nguyen on 2018 November 29.
 *
 */

/**
 * Data class that is necessary for a UI to show a listing and interact w/ the rest of the system
 */
data class Listing<T>(
    // the LiveData of paged lists for the UI to observe
    val pagedList: LiveData<PagedList<T>>,
    // represents the network request status to show to the user
    val networkState: LiveData<NetworkState>,
    // represents the refresh status to show to the user. Separate from networkState, this
    // value is importantly only when refresh is requested.
    val refreshState: LiveData<NetworkState>,
    // refreshes the whole data and fetches it from scratch.
    val refresh: () -> Unit,
    // retries any failed requests.
    val retry: () -> Unit
)