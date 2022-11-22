package com.inflames1986.mytranslator.translator.di

import android.content.Context
import com.inflames1986.mytranslator.translator.AppTranslator
import com.inflames1986.mytranslator.translator.di.module.*
import com.inflames1986.mytranslator.translator.domain.scheduler.Schedulers
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        NetworkModule::class,
        YandexApiModule::class,
        InteractorModule::class,
        RepositoryModule::class,
        ScreenModule::class,
        AndroidSupportInjectionModule::class]
)
interface ApplicationComponent : AndroidInjector<AppTranslator> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun withContext(context: Context): Builder

        @BindsInstance
        fun withSchedulers(schedulers: Schedulers): Builder

        fun build(): ApplicationComponent
    }
}