package com.inflames1986.mytranslator.translator.domain.repository

import io.reactivex.Observable

interface IRepository<T> {

    fun getData(word: String): Observable<T>
}