package com.inflames1986.domain.repository.datasource

interface IDataSource<T> {

    suspend fun getData(word: String): T
}