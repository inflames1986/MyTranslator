package com.inflames1986.mytranslator.translator.presenter

import io.reactivex.Observable


interface IInteractor<T> {

    fun getData(word: String): Observable<T>
}