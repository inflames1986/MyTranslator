package com.inflames1986.mytranslator.translator.view.favourite

import com.inflames1986.mytranslator.translator.domain.storage.entity.WordFavourite

interface IFavouriteInteractor<T> {

    suspend fun getData(): List<WordFavourite>

    suspend fun clearFavourite(): Int
}