package com.inflames1986.mytranslator.translator

import android.app.Application
import com.inflames1986.mytranslator.translator.di.Di
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class AppTranslator : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@AppTranslator)
            modules(
                listOf(
                    Di.viewModelModule(),
                    Di.interactorModule(),
                    Di.networkModule(),
                    Di.repositoryModule(),
                    Di.yandexApiModule()
                )
            )
        }
    }
}