package com.inflames1986.mytranslator.translator.di.module

import com.inflames1986.mytranslator.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface ScreenModule {

    @ContributesAndroidInjector
    fun bindMainActivity(): MainActivity
}