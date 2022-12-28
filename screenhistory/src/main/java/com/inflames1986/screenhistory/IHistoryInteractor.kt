package com.inflames1986.screenhistory

import com.inflames1986.domain.storage.entity.WordTranslate


interface IHistoryInteractor<T> {

    suspend fun getData(): List<WordTranslate>

    suspend fun saveToDb(word: WordTranslate)

    suspend fun saveToDb(words: List<WordTranslate>)

    suspend fun clearHistory(): Int
}