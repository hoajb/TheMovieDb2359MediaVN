package vn.a2359media.hoanguyenminh.themoviedb.base.recyclerview

import androidx.recyclerview.widget.RecyclerView

/**
 * Created by Hoa Nguyen on 2018 November 11.
 *
 */

abstract class BaseRecycleViewAdapter<T : Any>(
    private var mListData: List<T>,
    private var clickListener: ItemClickListener<T>? = null
) : androidx.recyclerview.widget.RecyclerView.Adapter<BaseViewHolder<T>>() {

    override fun getItemCount(): Int {
        return mListData.size
    }

    fun updateData(list: List<T>) {
        mListData = list
    }

    override fun onBindViewHolder(holder: BaseViewHolder<T>, position: Int) {
        holder.bindingData(mListData[position])
    }

}