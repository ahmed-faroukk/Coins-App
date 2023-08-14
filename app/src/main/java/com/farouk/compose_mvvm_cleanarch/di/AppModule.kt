package com.farouk.compose_mvvm_cleanarch.di

import com.farouk.compose_mvvm_cleanarch.common.Constants
import com.farouk.compose_mvvm_cleanarch.data.remote.CoinApi
import com.farouk.compose_mvvm_cleanarch.data.repository.CoinRepoImp
import com.farouk.compose_mvvm_cleanarch.domin.repository.CoinRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideApi(): CoinApi {
        val retrofit by lazy {
            val logging = HttpLoggingInterceptor()
            logging.setLevel(HttpLoggingInterceptor.Level.BODY)
            val client = OkHttpClient.Builder()
                .addInterceptor(logging).build()

            Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
        }

        return retrofit.create(CoinApi::class.java)
    }

    @Provides
    @Singleton
    fun provideRepo(api: CoinApi): CoinRepo {
        return CoinRepoImp(api)
    }
}