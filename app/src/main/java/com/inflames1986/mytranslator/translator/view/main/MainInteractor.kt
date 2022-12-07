package com.inflames1986.mytranslator.translator.view.main

import com.inflames1986.domain.repository.IRepositoryLocal
import com.inflames1986.domain.storage.entity.WordFavourite
import com.inflames1986.domain.storage.entity.WordTranslate
import com.inflames1986.model.data.DictionaryResult
import com.inflames1986.domain.repository.IRepository


class MainInteractor(
    val repositoryRemote: IRepository<DictionaryResult>,
    val repositoryLocal: IRepositoryLocal
) : IMainInteractor<DictionaryResult> {

    override suspend fun getData(word: String, fromRemoteSource: Boolean): DictionaryResult =
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