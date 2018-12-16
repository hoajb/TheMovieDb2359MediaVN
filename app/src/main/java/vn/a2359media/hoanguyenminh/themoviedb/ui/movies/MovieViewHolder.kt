package vn.a2359media.hoanguyenminh.themoviedb.ui.movies

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import vn.a2359media.hoanguyenminh.themoviedb.R
import vn.a2359media.hoanguyenminh.themoviedb.base.recyclerview.BaseViewHolder
import vn.a2359media.hoanguyenminh.themoviedb.base.recyclerview.ItemClickListener
import vn.a2359media.hoanguyenminh.themoviedb.repository.config.Config
import vn.a2359media.hoanguyenminh.themoviedb.repository.data.Movie

/**
 * Created by Hoa Nguyen on Dec 16 2018.
 */
class MovieViewHolder(itemView: View, clickListener: ItemClickListener<Movie>? = null) :
    BaseViewHolder<Movie>(itemView, clickListener) {

    private val imgPoster = itemView.findViewById<ImageView>(R.id.imgPoster)
    private val voteAverage = itemView.findViewById<TextView>(R.id.txtVoteAverage)

    override fun bindingData(data: Movie?) {
        showImage(imgPoster, Config.BASE_URL_IMAGE + data?.posterPath)
        voteAverage.text = "%.1f".format(data?.voteAverage ?: "")
    }

    companion object {
        fun createInstance(parent: ViewGroup, viewType: Int = 0): MovieViewHolder {
            return MovieViewHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.item_movie,
                    parent,
                    false
                )
            )
        }
    }
}