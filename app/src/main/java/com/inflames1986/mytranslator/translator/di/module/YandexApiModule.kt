package com.inflames1986.mytranslator.translator.di.module

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.inflames1986.mytranslator.BuildConfig
import com.inflames1986.mytranslator.translator.domain.api.YandexApi
import com.inflames1986.mytranslator.translator.domain.api.YandexApiInterceptor
import com.inflames1986.mytranslator.translator.utils.BASE_URL
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class YandexApiModule {

    private val gson: Gson =
        GsonBuilder()
            .create()

    @Singleton
    @Provides
    fun provideYandexApi(): YandexApi =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(
                OkHttpClient.Builder()
                    .addInterceptor(YandexApiInterceptor)
                    .addInterceptor(HttpLoggingInterceptor().apply {
                        level = if (BuildConfig.DEBUG) {
                            HttpLoggingInterceptor.Level.BODY
                        } else {
                            HttpLoggingInterceptor.Level.NONE
                        }
                    })
                    .build()
            )
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(YandexApi::class.java)
}