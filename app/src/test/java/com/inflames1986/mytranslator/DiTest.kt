package com.inflames1986.mytranslator

import com.inflames1986.mytranslator.translator.di.Di
import org.junit.Test
import org.koin.test.KoinTest
import org.koin.test.check.checkModules

class DiTest : KoinTest {

    @Test
    fun testFunc() {

        val listModules = listOf(
            Di.viewModelModule(),
            Di.interactorModule(),
            Di.networkModule(),
            Di.repositoryModule(),
            Di.yandexApiModule(),
            Di.navigationModule()
        )

        checkModules { listModules }
    }
}