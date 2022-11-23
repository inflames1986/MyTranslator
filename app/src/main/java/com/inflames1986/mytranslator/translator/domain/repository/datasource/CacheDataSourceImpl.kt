package com.inflames1986.mytranslator.translator.domain.repository.datasource

import com.inflames1986.mytranslator.translator.domain.model.DictionaryResult


class CacheDataSourceImpl : IDataSource<DictionaryResult> {
    companion object {
        private const val ERROR_MESSAGE =
            "Локальный источник данных еще не реализован.\nПопросите разработчика реализовать :)"
    }

    override suspend fun getData(word: String): DictionaryResult =
        throw Exception(ERROR_MESSAGE)
}