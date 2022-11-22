package com.inflames1986.mytranslator.translator.domain.api

import io.reactivex.Observable

import retrofit2.http.GET
import retrofit2.http.Query
import com.inflames1986.mytranslator.translator.domain.model.DictionaryResult
import com.inflames1986.mytranslator.translator.utils.API_TOKEN

interface YandexApi {
    /**
     * Получить перевод
     * @param targetWord Слово, которое необходимо перевести
     * @return DictionaryResult
     */
    @GET("dicservice.json/lookup?key=${API_TOKEN}&lang=en-ru")
    fun search(@Query("text") targetWord: String): Observable<DictionaryResult>
}