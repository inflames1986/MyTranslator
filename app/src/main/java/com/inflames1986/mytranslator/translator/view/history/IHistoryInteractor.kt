package com.inflames1986.mytranslator.translator.view.history

import com.inflames1986.mytranslator.translator.domain.storage.entity.WordTranslate

interface IHistoryInteractor<T> {

    suspend fun getData(): List<WordTranslate>

    suspend fun saveToDb(word: WordTranslate)

    suspend fun saveToDb(words: List<WordTranslate>)

    suspend fun clearHistory(): Int
}