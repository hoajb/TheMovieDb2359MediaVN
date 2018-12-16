package vn.a2359media.hoanguyenminh.themoviedb.ui.movies

import androidx.lifecycle.ViewModelProviders
import vn.a2359media.hoanguyenminh.themoviedb.base.recyclerview.BasePagedListAdapter
import vn.a2359media.hoanguyenminh.themoviedb.base.recyclerview.ItemClickListener
import vn.a2359media.hoanguyenminh.themoviedb.base.view.BasePagedListFragment
import vn.a2359media.hoanguyenminh.themoviedb.repository.data.Movie
import vn.a2359media.hoanguyenminh.themoviedb.viewmodel.BasePagedListViewModel
import javax.inject.Inject

/**
 * Created by Hoa Nguyen on Dec 16 2018.
 */
class MoviesFragment : BasePagedListFragment<Movie, MovieViewHolder>() {
    override fun createViewModel(): BasePagedListViewModel<Movie> =
        ViewModelProviders.of(this, factory).get(MoviesViewModel::class.java)

    override fun createAdapter(): BasePagedListAdapter<Movie, MovieViewHolder> =
        MoviesAdapter(
            retryCallback = { viewModel.retry() },
            clickListener = object : ItemClickListener<Movie> {
                override fun onItemClick(data: Movie?, position: Int, typeClick: Int) {
                    showMessage(data?.originalTitle ?: "")
                }
            })

    @Inject
    lateinit var factory: InvestmentListViewModelFactory

    override val mTAG: String?
        get() = MoviesFragment::class.java.simpleName


    companion object {
        const val REQUEST_INVEST_DETAIL = 3332

        fun newInstance(): MoviesFragment {
            return MoviesFragment()
        }
    }
}