package com.inflames1986.mytranslator.translator.di.module

import com.inflames1986.mytranslator.translator.di.Qualifiers
import com.inflames1986.mytranslator.translator.domain.model.DictionaryResult
import com.inflames1986.mytranslator.translator.domain.repository.IRepository
import dagger.Module
import dagger.Provides
import com.inflames1986.mytranslator.translator.view.main.MainInteractor


@Module
class InteractorModule {

    @Provides
    internal fun provideMainInteractor(
        @Qualifiers.Remote repositoryRemote: IRepository<DictionaryResult>,
        @Qualifiers.Local repositoryLocal: IRepository<DictionaryResult>
    ) = MainInteractor(repositoryRemote, repositoryLocal)
}