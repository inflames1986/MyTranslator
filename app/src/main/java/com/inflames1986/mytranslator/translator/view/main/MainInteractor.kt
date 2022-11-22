package com.inflames1986.mytranslator.translator.view.main

import android.util.Log
import com.inflames1986.mytranslator.translator.di.Qualifiers
import com.inflames1986.mytranslator.translator.domain.model.AppState
import com.inflames1986.mytranslator.translator.domain.model.DictionaryResult
import com.inflames1986.mytranslator.translator.domain.repository.IRepository
import io.reactivex.Observable

import com.inflames1986.mytranslator.translator.viewmodel.IInteractor
import javax.inject.Inject

class MainInteractor @Inject constructor(
    @Qualifiers.Remote val repositoryRemote: IRepository<DictionaryResult>,
    @Qualifiers.Local val repositoryLocal: IRepository<DictionaryResult>
) : IInteractor<AppState> {

    override fun getData(word: String, fromRemoteSource: Boolean): Observable<AppState> {
        return if (fromRemoteSource) {
            Log.d("translatorDebug", "repositoryRemote")
            repositoryRemote
        } else {
            Log.d("translatorDebug", "repositoryLocal")
            repositoryLocal
        }.getData(word).map { AppState.Success(it) }
    }
}