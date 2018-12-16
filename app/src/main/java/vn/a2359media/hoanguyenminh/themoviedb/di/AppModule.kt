package vn.a2359media.hoanguyenminh.themoviedb.di

import android.app.Application
import dagger.Module
import dagger.Provides
import vn.a2359media.hoanguyenminh.themoviedb.application.TheMovieDBApplication
import javax.inject.Singleton

/**
 * Created by Hoa Nguyen on 2018 Dec 14.
 *
 */

@Module
class AppModule {

    @Provides
    @Singleton
    fun provideApplication(application: TheMovieDBApplication): Application = application
}