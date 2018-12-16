package vn.a2359media.hoanguyenminh.themoviedb.ui.movies

import vn.a2359media.hoanguyenminh.themoviedb.base.view.BaseFragment
import vn.a2359media.hoanguyenminh.themoviedb.base.view.BaseSingleFragmentActivity

/**
 * Created by Hoa Nguyen on Dec 16 2018.
 */
class MoviesListActivity : BaseSingleFragmentActivity() {
    override fun createFragment(): BaseFragment = MoviesFragment.newInstance()
}