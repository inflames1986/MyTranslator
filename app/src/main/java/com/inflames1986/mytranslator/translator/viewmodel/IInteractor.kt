package com.inflames1986.mytranslator.translator.viewmodel

import io.reactivex.Observable

interface IInteractor<T> {

    fun getData(word: String, fromRemoteSource: Boolean): Observable<T>
}
