package com.inflames1986.domain.api

import com.inflames1986.mytranslator.translator.domainmodel.DictionaryResult
import com.inflames1986.utils.API_TOKEN
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

interface YandexApi {

    @GET("dicservice.json/lookup?key=${API_TOKEN}&lang=en-ru")
    fun searchAsync(@Query("text") targetWord: String): Deferred<DictionaryResult>
}
