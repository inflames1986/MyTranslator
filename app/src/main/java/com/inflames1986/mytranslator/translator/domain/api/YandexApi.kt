package com.inflames1986.mytranslator.translator.domain.api
import com.inflames1986.mytranslator.translator.domain.model.DictionaryResult
import retrofit2.http.GET
import retrofit2.http.Query
import com.inflames1986.mytranslator.translator.utils.API_TOKEN
import kotlinx.coroutines.Deferred

interface YandexApi {

    @GET("dicservice.json/lookup?key=${API_TOKEN}&lang=en-ru")
    fun searchAsync(@Query("text") targetWord: String): Deferred<DictionaryResult>
}