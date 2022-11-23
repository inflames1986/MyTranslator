package com.inflames1986.mytranslator.translator.domain.repository.datasource

interface IDataSource<T> {

    suspend fun getData(word: String): T
}