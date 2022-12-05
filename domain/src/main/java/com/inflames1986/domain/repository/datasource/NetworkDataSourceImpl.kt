package com.inflames1986.mytranslator.translator.domain.repository.datasource

import com.inflames1986.domain.api.YandexApi
import com.inflames1986.mytranslator.translator.domain.model.DictionaryResult

class NetworkDataSourceImpl(private val yandexApi: YandexApi) :
    IDataSource<DictionaryResult> {

    override suspend fun getData(word: String): DictionaryResult =
        yandexApi.searchAsync(word).await()
}