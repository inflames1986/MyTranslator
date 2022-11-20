package com.inflames1986.mytranslator.translator.domain.repository.datasource

object CacheDataSourceFactory {
    fun create(): ICacheDataSource =
        CacheDataSourceImpl()
}