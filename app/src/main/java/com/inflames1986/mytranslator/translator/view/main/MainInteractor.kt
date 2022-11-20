package com.inflames1986.mytranslator.translator.view.main

import io.reactivex.Observable
import com.inflames1986.mytranslator.translator.domain.model.AppState
import com.inflames1986.mytranslator.translator.domain.model.DictionaryResult
import com.inflames1986.mytranslator.translator.domain.repository.IRepository
import com.inflames1986.mytranslator.translator.presenter.IInteractor

class MainInteractor(
    private val repository: IRepository<DictionaryResult>,
) : IInteractor<AppState> {
    override fun getData(word: String): Observable<AppState> =
        repository.getData(word)
            .map { AppState.Success(it) }
}