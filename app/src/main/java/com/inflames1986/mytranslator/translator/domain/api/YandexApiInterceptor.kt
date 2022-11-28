package com.inflames1986.mytranslator.translator.domain.api

import com.inflames1986.mytranslator.utils.API_TOKEN
import okhttp3.Credentials
import okhttp3.Interceptor
import okhttp3.Response

object YandexApiInterceptor : Interceptor {
    private var responseCode: Int = 0

    private const val USER_NAME = "demo"
    private const val HEADER_NAME = "Authorization"

    override fun intercept(chain: Interceptor.Chain): Response {
        val response = chain.proceed(
            chain.request()
                .newBuilder()
                .header(
                    HEADER_NAME,
                    Credentials.basic(USER_NAME, API_TOKEN)
                )
                .build()
        )
        responseCode = response.code
        return response
    }

    fun getResponseCode(): ServerResponseStatusCode {
        var statusCode = ServerResponseStatusCode.UNDEFINED_ERROR
        when (responseCode / 100) {
            1 -> statusCode = ServerResponseStatusCode.INFO
            2 -> statusCode = ServerResponseStatusCode.SUCCESS
            3 -> statusCode = ServerResponseStatusCode.REDIRECTION
            4 -> statusCode = ServerResponseStatusCode.CLIENT_ERROR
            5 -> statusCode = ServerResponseStatusCode.SERVER_ERROR
        }
        return statusCode
    }

    enum class ServerResponseStatusCode {
        INFO,
        SUCCESS,
        REDIRECTION,
        CLIENT_ERROR,
        SERVER_ERROR,
        UNDEFINED_ERROR
    }
}