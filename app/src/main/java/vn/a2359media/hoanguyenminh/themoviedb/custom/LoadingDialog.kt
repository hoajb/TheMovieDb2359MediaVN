package vn.a2359media.hoanguyenminh.themoviedb.custom

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import kotlinx.android.synthetic.main.dialog_loading.*
import vn.a2359media.hoanguyenminh.themoviedb.R

class LoadingDialog(context: Context) : Dialog(context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_loading)
    }

    lateinit var messageShow: String

    fun setMessage(str: String): LoadingDialog {
        messageShow = str
        return this
    }

    override fun show() {
        message.text = messageShow
        super.show()
    }

}