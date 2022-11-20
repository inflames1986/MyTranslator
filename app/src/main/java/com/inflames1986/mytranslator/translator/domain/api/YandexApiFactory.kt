package com.inflames1986.mytranslator.translator.domain.api

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object YandexApiFactory {
    private val gson: Gson =
        GsonBuilder()
            .create()

    fun create(): YandexApi =
        Retrofit.Builder()
            .baseUrl("\"https://translate.api.cloud.yandex.net/")
            .client(
                OkHttpClient.Builder()
                    .addInterceptor(YandexApiInterceptor)
                    .addInterceptor(HttpLoggingInterceptor().apply {
                        level = HttpLoggingInterceptor.Level.BODY
                    })
                    .build()
            )
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(YandexApi::class.java)
}