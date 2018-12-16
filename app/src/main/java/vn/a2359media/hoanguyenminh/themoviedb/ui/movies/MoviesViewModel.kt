package vn.a2359media.hoanguyenminh.themoviedb.ui.movies

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import vn.a2359media.hoanguyenminh.themoviedb.repository.MainRepository
import vn.a2359media.hoanguyenminh.themoviedb.repository.data.Movie
import vn.a2359media.hoanguyenminh.themoviedb.viewmodel.BasePagedListViewModel
import javax.inject.Inject

/**
 * Created by Hoa Nguyen on Dec 16 2018.
 */
class MoviesViewModel(application: Application, private val repo: MainRepository) :
    BasePagedListViewModel<Movie>(application) {
    override fun loadListData() {
        repo.loadNowPlayingMoviesFromAPI(apiResult)
    }
}

class InvestmentListViewModelFactory @Inject constructor(
    private val application: Application,
    private val repo: MainRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        @Suppress("UNCHECKED_CAST")
        return MoviesViewModel(application, repo) as T
    }

}