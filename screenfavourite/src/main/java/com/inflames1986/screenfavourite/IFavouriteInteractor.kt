package com.inflames1986.screenfavourite

import com.inflames1986.domain.storage.entity.WordFavourite


interface IFavouriteInteractor<T> {

    suspend fun getData(): List<WordFavourite>

    suspend fun clearFavourite(): Int
}