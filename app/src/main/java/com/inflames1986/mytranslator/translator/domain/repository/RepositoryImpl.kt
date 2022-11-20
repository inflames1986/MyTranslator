package com.inflames1986.mytranslator.translator.domain.repository

import io.reactivex.Observable
import com.inflames1986.mytranslator.translator.domain.model.DictionaryResult
import com.inflames1986.mytranslator.translator.domain.repository.datasource.ICacheDataSource
import com.inflames1986.mytranslator.translator.domain.repository.datasource.INetworkDataSource

class RepositoryImpl(
    private val cloud: INetworkDataSource,
    private val cache: ICacheDataSource
) : IRepository<DictionaryResult> {

    override fun getData(word: String): Observable<DictionaryResult> =
        cloud.getData(word)
}