package com.inflames1986.domain.repository

import com.inflames1986.domain.repository.datasource.IDataSource
import com.inflames1986.model.data.DictionaryResult


class RepositoryImpl(
    private val dataSource: IDataSource<DictionaryResult>
) : IRepository<DictionaryResult> {

    override suspend fun getData(word: String): DictionaryResult =
        dataSource.getData(word)
}