package vn.a2359media.hoanguyenminh.themoviedb.base.view

import android.os.Bundle
import vn.a2359media.hoanguyenminh.themoviedb.R

/**
 * Created by Hoa Nguyen on Dec 04 2018.
 */
abstract class BaseSingleFragmentActivity : BaseActivity() {

    override val layoutId: Int
        get() = R.layout.activity_single_fragment

    abstract fun createFragment(): BaseFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val fragment = createFragment()
        supportFragmentManager.beginTransaction()
            .add(R.id.contentFrame, fragment, fragment.mTAG)
            .commit()

    }
}