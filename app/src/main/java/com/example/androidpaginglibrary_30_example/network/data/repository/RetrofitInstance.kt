package com.example.androidpaginglibrary_30_example.network.data.repository

import com.example.androidpaginglibrary_30_example.network.api.PassangerApi
import com.example.androidpaginglibrary_30_example.utils.BASE_URL
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
object RetrofitInstance {

    @Singleton
    @Provides
    fun provideRetrofitInstance(okHttpClient: OkHttpClient): Retrofit {
        return  Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }

    @Singleton
    @Provides
    fun providePessangerAPi(retrofit: Retrofit): PassangerApi {
        return retrofit.create(PassangerApi::class.java)
    }

    @Singleton
    @Provides
     fun provideOkHttpClient(): OkHttpClient {
        val logginInterceptor = HttpLoggingInterceptor()
        logginInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        return OkHttpClient.Builder()
            .addInterceptor(logginInterceptor)
            .build()
    }
}
