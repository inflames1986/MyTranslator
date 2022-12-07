package com.inflames1986.screenhistory

import com.inflames1986.domain.storage.entity.WordTranslate
import com.inflames1986.domain.repository.IRepositoryLocal

class HistoryInteractor(
    val repositoryLocal: IRepositoryLocal
) : IHistoryInteractor<List<WordTranslate>> {

    override suspend fun getData(): List<WordTranslate> {
        return repositoryLocal
            .fetchHistory()
    }

    override suspend fun saveToDb(word: WordTranslate) {
        repositoryLocal.saveToDb(word)
    }

    override suspend fun saveToDb(words: List<WordTranslate>) {
        repositoryLocal.saveToDb(words)
    }

    override suspend fun clearHistory(): Int =
        repositoryLocal.clearHistory()
}