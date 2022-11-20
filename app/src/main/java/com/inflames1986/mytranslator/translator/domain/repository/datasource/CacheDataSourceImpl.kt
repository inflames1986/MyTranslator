package com.inflames1986.mytranslator.translator.domain.repository.datasource

import io.reactivex.Observable
import com.inflames1986.mytranslator.translator.domain.model.DictionaryResult

class CacheDataSourceImpl : ICacheDataSource {
    override fun getData(word: String): Observable<DictionaryResult> {
        TODO("Not yet implemented")
    }
}