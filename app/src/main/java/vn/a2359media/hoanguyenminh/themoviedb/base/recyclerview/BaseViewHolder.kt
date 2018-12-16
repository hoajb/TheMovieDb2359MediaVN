package vn.a2359media.hoanguyenminh.themoviedb.base.recyclerview

import android.view.View
import android.widget.ImageView
import vn.a2359media.hoanguyenminh.themoviedb.R
import vn.a2359media.hoanguyenminh.themoviedb.custom.GlideApp

/**
 * Created by Hoa Nguyen on 2018 November 11.
 *
 */

abstract class BaseViewHolder<T : Any>(itemView: View, itemClickListener: ItemClickListener<T>? = null) :
    androidx.recyclerview.widget.RecyclerView.ViewHolder(itemView) {

    var clickListener: ItemClickListener<T>? = itemClickListener

    private var mData: T? = null

    abstract fun bindingData(data: T?)

    fun setData(data: T?) {
        mData = data
    }

    init {
        itemView.setOnClickListener {
            clickListener?.onItemClick(mData, adapterPosition, 0)
        }
    }

    fun showImage(imageView: ImageView, url: String) {
        GlideApp.with(itemView.context)
            .load(url)
            .placeholder(R.mipmap.ic_error)
            .fitCenter()
            .into(imageView)
    }
}

interface ItemClickListener<T> {
    fun onItemClick(data: T?, position: Int, typeClick: Int = 0)
}

