package com.inflames1986.mytranslator.translator.view.main

import com.inflames1986.mytranslator.translator.domain.storage.entity.WordFavourite
import com.inflames1986.mytranslator.translator.domain.storage.entity.WordTranslate

interface IMainInteractor<T> {

    suspend fun getData(word: String, fromRemoteSource: Boolean): T
    suspend fun saveToDb(word: WordTranslate)
    suspend fun saveToDb(words: List<WordTranslate>)
    suspend fun insertWordToFavourite(word: WordFavourite): Long
}