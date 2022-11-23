package com.inflames1986.mytranslator.translator.view.main

import com.inflames1986.mytranslator.translator.domain.model.DictionaryResult
import com.inflames1986.mytranslator.translator.domain.repository.IRepository
import com.inflames1986.mytranslator.translator.viewmodel.IInteractor

class MainInteractor(
    val repositoryRemote: IRepository<DictionaryResult>,
    val repositoryLocal: IRepository<DictionaryResult>
) : IInteractor<DictionaryResult> {

    override suspend fun getData(word: String, fromRemoteSource: Boolean): DictionaryResult {
        return if (fromRemoteSource) {
            repositoryRemote
        } else {
            repositoryLocal
        }.getData(word)
    }
}