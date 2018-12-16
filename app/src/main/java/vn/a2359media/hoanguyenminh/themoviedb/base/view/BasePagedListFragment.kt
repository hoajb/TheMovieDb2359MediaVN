package vn.a2359media.hoanguyenminh.themoviedb.base.view

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.base_fragment_single_list.*
import vn.a2359media.hoanguyenminh.themoviedb.R
import vn.a2359media.hoanguyenminh.themoviedb.base.recyclerview.BasePagedListAdapter
import vn.a2359media.hoanguyenminh.themoviedb.base.recyclerview.BaseViewHolder
import vn.a2359media.hoanguyenminh.themoviedb.repository.NetworkState
import vn.a2359media.hoanguyenminh.themoviedb.viewmodel.BasePagedListViewModel

/**
 * Created by Hoa Nguyen on Dec 04 2018.
 *
 */
abstract class BasePagedListFragment<T : Any, VH : BaseViewHolder<T>> : BaseFragment() {
    override val layoutId: Int
        get() = R.layout.base_fragment_single_list

    abstract fun createAdapter(
    ): BasePagedListAdapter<T, VH>

    lateinit var viewModel: BasePagedListViewModel<T>
    lateinit var adapter: BasePagedListAdapter<T, VH>

    open fun getLayoutManager(): androidx.recyclerview.widget.RecyclerView.LayoutManager =
        androidx.recyclerview.widget.LinearLayoutManager(
            context,
            androidx.recyclerview.widget.RecyclerView.VERTICAL,
            false
        )

    open fun setUpRecyclerView() {
        adapter = createAdapter()
        recyclerView.layoutManager = getLayoutManager()
        recyclerView.adapter = adapter

        createItemDecoration()?.let { recyclerView.addItemDecoration(it) }
    }

    open fun createItemDecoration(): RecyclerView.ItemDecoration? {
        return null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = createViewModel()
    }

    abstract fun createViewModel(): BasePagedListViewModel<T>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initSwipeToRefresh()
        setUpRecyclerView()
        setupViewModel()
    }

    open fun setupViewModel() {
        viewModel.pagedListInvestments.observe(this,
            Observer<PagedList<T>> { listing ->
                adapter.submitList(listing)
            })

        viewModel.networkState.observe(this, Observer {
            adapter.setNetworkState(it)
        })
        viewModel.loadListData()
    }

    open fun initSwipeToRefresh() {
        viewModel.refreshState.observe(this, Observer { it ->
            swipe_refresh.isRefreshing = it == NetworkState.LOADING
        })
        swipe_refresh.setOnRefreshListener {
            viewModel.refresh()
        }
    }
}

