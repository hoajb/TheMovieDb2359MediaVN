package vn.a2359media.hoanguyenminh.themoviedb.di


import dagger.Module
import dagger.android.ContributesAndroidInjector
import vn.a2359media.hoanguyenminh.themoviedb.MainActivity
import vn.a2359media.hoanguyenminh.themoviedb.ui.movies.MoviesFragment
import vn.a2359media.hoanguyenminh.themoviedb.ui.movies.MoviesListActivity

/**
 * Created by Hoa Nguyen on 2018 Dec 14.
 *
 */
@Module
abstract class BuildersModule {

    @ContributesAndroidInjector()
    abstract fun bindMainActivity(): MainActivity

    @ContributesAndroidInjector()
    abstract fun bindMoviesListActivity(): MoviesListActivity

    @ContributesAndroidInjector()
    abstract fun bindTheMovieListFragment(): MoviesFragment
}