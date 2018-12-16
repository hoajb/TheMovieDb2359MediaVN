package vn.a2359media.hoanguyenminh.themoviedb.di

import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import vn.a2359media.hoanguyenminh.themoviedb.application.TheMovieDBApplication
import javax.inject.Singleton

/**
 * Created by Hoa Nguyen on 2018 Dec 14.
 *
 */

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AppModule::class,
        BuildersModule::class,
        RepositoryModule::class
    ]
)


interface AppComponent : AndroidInjector<TheMovieDBApplication> {
    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(app: TheMovieDBApplication): AppComponent.Builder

//        fun repositoryModule(module: RepositoryModule): AppComponent.Builder

        fun build(): AppComponent
    }
}