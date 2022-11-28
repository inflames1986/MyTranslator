package com.inflames1986.mytranslator.translator.domain.repository

import com.inflames1986.mytranslator.translator.domain.repository.datasource.IDataSourceLocal
import com.inflames1986.mytranslator.translator.domain.storage.entity.WordFavourite
import com.inflames1986.mytranslator.translator.domain.storage.entity.WordTranslate

class RepositoryLocalImpl(private val dataSource: IDataSourceLocal) : IRepositoryLocal {
    override suspend fun saveToDb(word: WordTranslate) {
        dataSource.saveToDB(word)
    }

    override suspend fun saveToDb(words: List<WordTranslate>) {
        dataSource.saveToDB(words)
    }

    override suspend fun fetchHistory(): List<WordTranslate> =
        dataSource.fetchHistory()

    override suspend fun findInHistoryByWord(word: String): WordTranslate =
        dataSource.findInHistoryByWord(word)

    override suspend fun fetchFavourite(): List<WordFavourite> =
        dataSource.fetchFavourite()

    override suspend fun insertWordToFavourite(word: WordFavourite): Long =
        dataSource.insertWordToFavourite(word)

    override suspend fun clearFavourite(): Int =
        dataSource.clearFavourite()

    override suspend fun clearHistory(): Int =
        dataSource.clearHistory()
}