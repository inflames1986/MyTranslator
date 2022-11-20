package com.inflames1986.mytranslator.translator.domain.repository.datasource

import com.inflames1986.mytranslator.translator.domain.api.YandexApiFactory

object NetworkDataSourceFactory {
    fun create(): INetworkDataSource = NetworkDataSourceImpl(YandexApiFactory.create())
}