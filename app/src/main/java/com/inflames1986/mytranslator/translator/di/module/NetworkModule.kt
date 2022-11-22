package com.inflames1986.mytranslator.translator.di.module

import android.content.Context
import com.inflames1986.mytranslator.translator.utils.network.NetworkStateObservable
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    @Singleton
    internal fun provideNetworkState(context: Context) = NetworkStateObservable(context)
}