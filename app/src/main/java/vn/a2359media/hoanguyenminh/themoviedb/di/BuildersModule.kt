package vn.a2359media.hoanguyenminh.themoviedb.di


import dagger.Module
import dagger.android.ContributesAndroidInjector
import vn.a2359media.hoanguyenminh.themoviedb.MainActivity

/**
 * Created by Hoa Nguyen on 2018 Dec 14.
 *
 */
@Module
abstract class BuildersModule {

    @ContributesAndroidInjector()
    abstract fun bindMainActivity(): MainActivity

//    @ContributesAndroidInjector()
//    abstract fun bindTheMovieListFragment(): TheMovieListFragment
}