package vn.a2359media.hoanguyenminh.themoviedb.repository

import androidx.annotation.MainThread
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.app.seedin.structure.repository.config.Config
import com.app.seedin.structure.repository.config.Config.Companion.API_KEY
import retrofit2.Call
import vn.a2359media.hoanguyenminh.themoviedb.repository.data.Listing
import vn.a2359media.hoanguyenminh.themoviedb.repository.data.Movie
import vn.a2359media.hoanguyenminh.themoviedb.repository.data.MovieList
import vn.a2359media.hoanguyenminh.themoviedb.repository.paging.ItemDataSource
import vn.a2359media.hoanguyenminh.themoviedb.repository.paging.ItemDataSourceFactory
import vn.a2359media.hoanguyenminh.themoviedb.repository.remote.NetworkAPI
import javax.inject.Inject

/**
 * Created by Hoa Nguyen on Dec 16 2018.
 *
 */

class MainRepository @Inject constructor(private val networkAPI: NetworkAPI) {
    private val defaultPagedListConfig: PagedList.Config by lazy {
        PagedList.Config.Builder()
            .setInitialLoadSizeHint(DEFAULT_PAGE_SIZE)
            .setPageSize(DEFAULT_PAGE_SIZE)
            .build()
    }

    @MainThread
    fun loadNowPlayingMoviesFromAPI(
        apiResult: MutableLiveData<Listing<Movie>>
    ): MutableLiveData<Listing<Movie>> {
        val sourceFactory = createMoviesListDataSourceFactory()
        val livePagedList = LivePagedListBuilder<Int, Movie>(sourceFactory, defaultPagedListConfig).build()

        val refreshState = Transformations.switchMap(sourceFactory.sourceLiveData) {
            it.initialLoad
        }

        val listing = Listing(
            pagedList = livePagedList,
            networkState = Transformations.switchMap(sourceFactory.sourceLiveData) {
                it.networkState
            },
            retry = {
                sourceFactory.sourceLiveData.value?.retryAllFailed()
            },
            refresh = {
                sourceFactory.sourceLiveData.value?.invalidate()
            },
            refreshState = refreshState
        )

        apiResult.postValue(listing)
        return apiResult
    }

    fun createMoviesListDataSourceFactory()
            : ItemDataSourceFactory<Movie, MovieList, ItemDataSource<Movie, MovieList>> {
        return object : ItemDataSourceFactory<Movie, MovieList, ItemDataSource<Movie, MovieList>>(networkAPI) {
            override fun createDataSource(networkApi: NetworkAPI): ItemDataSource<Movie, MovieList> {
                return object : ItemDataSource<Movie, MovieList>(networkAPI) {
                    override fun getRequest(page: Int): Call<MovieList> {
                        return networkAPI.getNowPlayingMovies(API_KEY, page)
                    }
                }
            }
        }
    }


    companion object {
        const val DEFAULT_PAGE_SIZE = Config.PAGE_SIZE
    }
}
