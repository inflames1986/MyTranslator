package com.inflames1986.domain.repository.datasource

import com.inflames1986.domain.api.YandexApi
import com.inflames1986.model.data.DictionaryResult


class NetworkDataSourceImpl(private val yandexApi: YandexApi) :
    IDataSource<DictionaryResult> {

    override suspend fun getData(word: String): DictionaryResult =
        yandexApi.searchAsync(word).await()
}