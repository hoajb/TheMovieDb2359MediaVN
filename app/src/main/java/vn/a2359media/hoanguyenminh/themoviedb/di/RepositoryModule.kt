package vn.a2359media.hoanguyenminh.themoviedb.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import vn.a2359media.hoanguyenminh.themoviedb.repository.config.Config
import vn.a2359media.hoanguyenminh.themoviedb.repository.remote.NetworkAPI

/**
 * Created by Hoa Nguyen on 2018 Dec 14.
 *
 */
@Module
class RepositoryModule {
    @Provides
    fun provideGson(): Gson {
        return GsonBuilder()
            .serializeNulls()
            .create()
    }

    @Provides
    fun provideGsonConverterFactory(gson: Gson): GsonConverterFactory {
        return GsonConverterFactory.create(gson)
    }

    @Provides
    fun provideClient(): OkHttpClient {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY


        return OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()
    }

    @Provides
    fun provideRetrofit(
        client: OkHttpClient,
        converter: GsonConverterFactory
    ): NetworkAPI {
        val builder = Retrofit.Builder()
            .baseUrl(Config.BASE_HOST_URL)
            .client(client)
            .addConverterFactory(converter)
            .build()

        return builder.create(NetworkAPI::class.java)
    }
}