package vn.a2359media.hoanguyenminh.themoviedb.base.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import dagger.android.support.DaggerFragment
import timber.log.Timber
import vn.a2359media.hoanguyenminh.themoviedb.custom.LoadingDialog

/**
 * Created by Hoa Nguyen on 12/4/18.
 *
 */
abstract class BaseFragment : DaggerFragment() {
    private lateinit var dialog: LoadingDialog

    abstract val layoutId: Int
    abstract val mTAG: String?

    override fun onAttach(context: Context) {
        super.onAttach(context)
        dialog = LoadingDialog(context)
        dialog.setMessage("Loading")
        dialog.setCancelable(false)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(layoutId, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    fun showMessage(message: String) {
        //show Dialog message
        Timber.d(message)
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    fun showLoading(message: String = "") {
        if (!dialog.isShowing)
            dialog.show()
    }

    open fun hideLoading() {
        if (dialog.isShowing)
            dialog.dismiss()
    }

    fun showToast(mess: String) {
        Toast.makeText(context, mess, Toast.LENGTH_SHORT).show()
    }
}