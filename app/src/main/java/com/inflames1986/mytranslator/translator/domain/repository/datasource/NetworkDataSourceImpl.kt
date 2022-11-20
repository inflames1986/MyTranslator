package com.inflames1986.mytranslator.translator.domain.repository.datasource

import io.reactivex.Observable
import com.inflames1986.mytranslator.translator.domain.api.YandexApi
import com.inflames1986.mytranslator.translator.domain.model.DictionaryResult

class NetworkDataSourceImpl(private val yandexApi: YandexApi) : INetworkDataSource {
    override fun getData(word: String): Observable<DictionaryResult> =
        yandexApi.search(word)
}