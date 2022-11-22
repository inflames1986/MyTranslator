package com.inflames1986.mytranslator.translator.domain.repository.datasource

import com.inflames1986.mytranslator.translator.domain.api.YandexApi
import com.inflames1986.mytranslator.translator.domain.model.DictionaryResult
import io.reactivex.Observable
import javax.inject.Inject

class NetworkDataSourceImpl @Inject constructor(private val yandexApi: YandexApi) :
    IDataSource<DictionaryResult> {

    override fun getData(word: String): Observable<DictionaryResult> =
        yandexApi.search(word)
}