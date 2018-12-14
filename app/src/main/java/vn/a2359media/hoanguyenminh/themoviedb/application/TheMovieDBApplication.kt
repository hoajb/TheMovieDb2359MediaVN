package vn.a2359media.hoanguyenminh.themoviedb.application

import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import timber.log.Timber
import vn.a2359media.hoanguyenminh.themoviedb.di.DaggerAppComponent

/**
 * Created by Hoa Nguyen on Dec 14 2018.
 */
class TheMovieDBApplication : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder()
            .build()
    }

    override fun onCreate() {
        super.onCreate()
        Timber.uprootAll()
        Timber.plant(Timber.DebugTree())
    }
}