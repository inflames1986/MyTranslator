package com.inflames1986.mytranslator.translator.domain.repository

import com.inflames1986.mytranslator.translator.domain.model.DictionaryResult
import com.inflames1986.mytranslator.translator.domain.repository.datasource.CacheDataSourceFactory
import com.inflames1986.mytranslator.translator.domain.repository.datasource.NetworkDataSourceFactory

object RepositoryFactory {
    private val repository: IRepository<DictionaryResult> by lazy {
        RepositoryImpl(
            NetworkDataSourceFactory.create(),
            CacheDataSourceFactory.create()
        )
    }

    fun create(): IRepository<DictionaryResult> = repository
}