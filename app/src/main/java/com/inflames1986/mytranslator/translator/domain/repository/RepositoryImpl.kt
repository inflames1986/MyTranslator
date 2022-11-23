package com.inflames1986.mytranslator.translator.domain.repository

import com.inflames1986.mytranslator.translator.domain.model.DictionaryResult
import com.inflames1986.mytranslator.translator.domain.repository.datasource.IDataSource

class RepositoryImpl(
    private val dataSource: IDataSource<DictionaryResult>
) : IRepository<DictionaryResult> {

    override suspend fun getData(word: String): DictionaryResult =
        dataSource.getData(word)
}