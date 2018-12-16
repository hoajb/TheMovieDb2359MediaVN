package vn.a2359media.hoanguyenminh.themoviedb.ui.movies

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import vn.a2359media.hoanguyenminh.themoviedb.base.recyclerview.BasePagedListAdapter
import vn.a2359media.hoanguyenminh.themoviedb.base.recyclerview.ItemClickListener
import vn.a2359media.hoanguyenminh.themoviedb.repository.data.Movie

/**
 * Created by Hoa Nguyen on Dec 16 2018.
 */

class MoviesAdapter (private val retryCallback: () -> Unit, private val clickListener: ItemClickListener<Movie>?) :
    BasePagedListAdapter<Movie, MovieViewHolder>(diffCallback, retryCallback, clickListener) {

    override fun createItemViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder =
        MovieViewHolder.createInstance(parent, viewType)

    companion object {
        /**
         * This diff callback informs the PagedListAdapter how to compute list differences when new
         * PagedLists arrive.
         * <p>
         * When you add a Cheese with the 'Add' button, the PagedListAdapter uses diffCallback to
         * detect there's only a single item difference from before, so it only needs to animate and
         * rebind a single view.
         *
         * @see android.support.v7.util.DiffUtil
         */
        private val diffCallback = object : DiffUtil.ItemCallback<Movie>() {
            override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean =
                oldItem.id == newItem.id

            /**
             * Note that in kotlin, == checking on data classes compares all contents, but in Java,
             * typically you'll implement Object#equals, and use it to compare object contents.
             */
            override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean =
                oldItem == newItem
        }
    }
}