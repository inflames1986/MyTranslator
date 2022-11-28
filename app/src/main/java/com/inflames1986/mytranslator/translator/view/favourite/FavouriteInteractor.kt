package com.inflames1986.mytranslator.translator.view.favourite

import com.inflames1986.mytranslator.translator.domain.repository.IRepositoryLocal
import com.inflames1986.mytranslator.translator.domain.storage.entity.WordFavourite


class FavouriteInteractor(
    val repositoryLocal: IRepositoryLocal
) : IFavouriteInteractor<List<WordFavourite>> {

    override suspend fun getData(): List<WordFavourite> =
        repositoryLocal
            .fetchFavourite()

    override suspend fun clearFavourite(): Int =
        repositoryLocal
            .clearFavourite()
}