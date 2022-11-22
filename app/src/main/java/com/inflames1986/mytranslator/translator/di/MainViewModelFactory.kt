package com.inflames1986.mytranslator.translator.di

import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.savedstate.SavedStateRegistryOwner
import com.inflames1986.mytranslator.translator.domain.scheduler.Schedulers
import com.inflames1986.mytranslator.translator.utils.network.NetworkStateObservable
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import com.inflames1986.mytranslator.translator.view.main.MainInteractor
import com.inflames1986.mytranslator.translator.view.main.MainViewModel


class MainViewModelFactory @AssistedInject constructor(
    val interactor: MainInteractor,
    val schedulers: Schedulers,
    val networkState: NetworkStateObservable,
    @Assisted owner: SavedStateRegistryOwner
) : AbstractSavedStateViewModelFactory(owner, null) {
    override fun <T : ViewModel?> create(
        key: String,
        modelClass: Class<T>,
        handle: SavedStateHandle
    ): T = MainViewModel(interactor, schedulers, networkState, handle) as T
}