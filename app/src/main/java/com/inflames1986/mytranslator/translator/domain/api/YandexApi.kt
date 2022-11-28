package com.inflames1986.mytranslator.translator.domain.api

import com.inflames1986.mytranslator.translator.utils.API_TOKEN
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query
import com.inflames1986.mytranslator.translator.domain.model.DictionaryResult

interface YandexApi {

    /**
     * Получить перевод
     * @param targetWord Слово, которое необходимо перевести
     * @return DictionaryResult
     */
    @GET("dicservice.json/lookup?key=${API_TOKEN}&lang=en-ru")
    fun searchAsync(@Query("text") targetWord: String): Deferred<DictionaryResult>
}