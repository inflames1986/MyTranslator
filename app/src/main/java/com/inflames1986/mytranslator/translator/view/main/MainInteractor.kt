package com.inflames1986.mytranslator.translator.view.main

import com.inflames1986.model.data.DictionaryResult
import com.inflames1986.mytranslator.translator.domain.repository.IRepository
import com.inflames1986.mytranslator.translator.domain.repository.IRepositoryLocal
import com.inflames1986.mytranslator.translator.domain.storage.entity.WordFavourite
import com.inflames1986.mytranslator.translator.domain.storage.entity.WordTranslate

class MainInteractor(
    val repositoryRemote: IRepository<com.inflames1986.model.data.DictionaryResult>,
    val repositoryLocal: IRepositoryLocal
) : IMainInteractor<com.inflames1986.model.data.DictionaryResult> {

    override suspend fun getData(word: String, fromRemoteSource: Boolean): com.inflames1986.model.data.DictionaryResult =
        repositoryRemote
            .getData(word)

    override suspend fun saveToDb(word: WordTranslate) {
        repositoryLocal.saveToDb(word)
    }

    override suspend fun saveToDb(words: List<WordTranslate>) {
        repositoryLocal.saveToDb(words)
    }

    override suspend fun insertWordToFavourite(word: WordFavourite) =
        repositoryLocal.insertWordToFavourite(word)
}