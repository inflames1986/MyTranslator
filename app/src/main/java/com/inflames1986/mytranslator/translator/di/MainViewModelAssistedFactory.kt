package com.inflames1986.mytranslator.translator.di

import androidx.savedstate.SavedStateRegistryOwner
import dagger.assisted.AssistedFactory

@AssistedFactory
interface MainViewModelAssistedFactory {
    fun create(owner: SavedStateRegistryOwner): MainViewModelFactory
}