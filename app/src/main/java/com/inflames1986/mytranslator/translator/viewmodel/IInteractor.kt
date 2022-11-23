package com.inflames1986.mytranslator.translator.viewmodel

interface IInteractor<T> {

    suspend fun getData(word: String, fromRemoteSource: Boolean): T
}