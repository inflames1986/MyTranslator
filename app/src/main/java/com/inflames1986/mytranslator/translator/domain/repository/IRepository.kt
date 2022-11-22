package com.inflames1986.mytranslator.translator.domain.repository

import io.reactivex.Observable


interface IRepository<T> {

    /**
     * Получить перевод
     * @param word Слово, которое необходимо перевести
     * @return Observable<T>
     */
    fun getData(word: String): Observable<T>
}