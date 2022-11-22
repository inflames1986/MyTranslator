package com.inflames1986.mytranslator.translator.domain.repository.datasource

import com.inflames1986.mytranslator.translator.domain.model.DictionaryResult
import io.reactivex.Observable


class CacheDataSourceImpl : IDataSource<DictionaryResult> {

    override fun getData(word: String): Observable<DictionaryResult> =
        Observable.error(Exception("Локальный источник данных еще не реализован"))
}