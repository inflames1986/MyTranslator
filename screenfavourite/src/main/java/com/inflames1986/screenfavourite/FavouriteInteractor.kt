package com.inflames1986.screenfavourite

import com.inflames1986.domain.repository.IRepositoryLocal
import com.inflames1986.domain.storage.entity.WordFavourite

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