package vn.a2359media.hoanguyenminh.themoviedb.base.view

import android.os.Bundle
import dagger.android.support.DaggerAppCompatActivity
import vn.a2359media.hoanguyenminh.themoviedb.custom.LoadingDialog

abstract class BaseActivity : DaggerAppCompatActivity() {
    abstract val layoutId: Int

    private lateinit var loadingDialog: LoadingDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutId)

        initView()
    }

    private fun initView() {
        loadingDialog = LoadingDialog(this)
    }

    fun showLoading() {
        if (!loadingDialog.isShowing) {
        }
        loadingDialog.show()
    }

    fun hideLoading() {
        if (loadingDialog.isShowing) {
        }
        loadingDialog.dismiss()
    }
}
