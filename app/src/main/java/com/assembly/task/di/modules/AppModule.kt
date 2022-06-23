package com.assembly.task.di.modules

import com.assembly.task.BuildConfig
import com.assembly.task.api.RedditApiServices
import com.assembly.task.repository.PicsRepository
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Developed by Manjunath on 18,June,2022
 * App module
 */

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    /**
     * Provides ApiServices client for Retrofit
     */

    @Singleton
    @Provides
    fun provideApiService(): RedditApiServices {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .client(provideHttpLogging())
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()))
            .build()
            .create(RedditApiServices::class.java)
    }

    @Singleton
    @Provides
    fun providePicsRepository(redditApiServices: RedditApiServices): PicsRepository{
            return PicsRepository(redditApiServices)
    }

    private fun provideHttpLogging(): OkHttpClient {
        return OkHttpClient.Builder().also { client ->
            if(BuildConfig.DEBUG) {
                val logging = HttpLoggingInterceptor()
                logging.setLevel(HttpLoggingInterceptor.Level.BODY)
                client.addInterceptor(logging)
            }
        }.build()
    }


}