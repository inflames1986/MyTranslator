package com.inflames1986.mytranslator.translator.domain.repository

import com.inflames1986.mytranslator.translator.domain.storage.entity.WordFavourite
import com.inflames1986.mytranslator.translator.domain.storage.entity.WordTranslate

interface IRepositoryLocal {

    suspend fun saveToDb(word: WordTranslate)

    suspend fun saveToDb(words: List<WordTranslate>)

    suspend fun fetchHistory(): List<WordTranslate>

    suspend fun findInHistoryByWord(word: String): WordTranslate

    suspend fun fetchFavourite(): List<WordFavourite>

    suspend fun insertWordToFavourite(word: WordFavourite): Long

    suspend fun clearFavourite(): Int

    suspend fun clearHistory(): Int
}