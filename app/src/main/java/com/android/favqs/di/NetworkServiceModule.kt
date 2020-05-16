package com.android.favqs.di

import com.android.favqs.data.service.remote.HeadersInterceptor
import com.android.favqs.data.service.remote.SessionInterceptor
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkServiceModule {
    companion object {
        private const val BASE_URL = "https://https://favqs.com/api"
    }

    private val headersInterceptor: HeadersInterceptor = HeadersInterceptor()

    @Provides
    @Singleton
    fun client(): Retrofit {
        // TODO - set logging level interception according to build config
        val loggingInterceptor = HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY)

        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .addInterceptor(headersInterceptor)
            .build()

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }

    @Provides
    @Singleton
    fun headerCallsInterceptor(): SessionInterceptor {
        return headersInterceptor
    }
}