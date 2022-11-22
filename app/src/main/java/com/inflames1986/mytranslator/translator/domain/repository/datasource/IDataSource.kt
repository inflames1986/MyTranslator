package com.inflames1986.mytranslator.translator.domain.repository.datasource

import io.reactivex.Observable

interface IDataSource<T> {

    fun getData(word: String): Observable<T>
}