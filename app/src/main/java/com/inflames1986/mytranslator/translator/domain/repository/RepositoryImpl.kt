package com.inflames1986.mytranslator.translator.domain.repository

import com.inflames1986.mytranslator.translator.domain.model.DictionaryResult
import com.inflames1986.mytranslator.translator.domain.repository.datasource.IDataSource
import io.reactivex.Observable
import javax.inject.Inject

class RepositoryImpl @Inject constructor(

    private val dataSource: IDataSource<DictionaryResult>,

    ) : IRepository<DictionaryResult> {

    override fun getData(word: String): Observable<DictionaryResult> =
        dataSource.getData(word)
}