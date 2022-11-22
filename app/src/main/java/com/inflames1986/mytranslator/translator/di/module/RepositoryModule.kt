package com.inflames1986.mytranslator.translator.di.module

import dagger.Module
import dagger.Provides
import com.inflames1986.mytranslator.translator.di.Qualifiers.Local
import com.inflames1986.mytranslator.translator.di.Qualifiers.Remote
import com.inflames1986.mytranslator.translator.domain.api.YandexApi
import com.inflames1986.mytranslator.translator.domain.model.DictionaryResult
import com.inflames1986.mytranslator.translator.domain.repository.IRepository
import com.inflames1986.mytranslator.translator.domain.repository.RepositoryImpl
import com.inflames1986.mytranslator.translator.domain.repository.datasource.CacheDataSourceImpl
import com.inflames1986.mytranslator.translator.domain.repository.datasource.IDataSource
import com.inflames1986.mytranslator.translator.domain.repository.datasource.NetworkDataSourceImpl
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    @Remote
    internal fun provideRepositoryRemote(@Remote dataSourceRemote: IDataSource<DictionaryResult>): IRepository<DictionaryResult> =
        RepositoryImpl(dataSourceRemote)

    @Provides
    @Singleton
    @Local
    internal fun provideRepositoryLocal(@Local dataSourceLocal: IDataSource<DictionaryResult>): IRepository<DictionaryResult> =
        RepositoryImpl(dataSourceLocal)

    @Provides
    @Singleton
    @Remote
    internal fun provideDataSourceRemote(yandexApi: YandexApi): IDataSource<DictionaryResult> =
        NetworkDataSourceImpl(yandexApi)

    @Provides
    @Singleton
    @Local
    internal fun provideDataSourceLocal(): IDataSource<DictionaryResult> = CacheDataSourceImpl()
}