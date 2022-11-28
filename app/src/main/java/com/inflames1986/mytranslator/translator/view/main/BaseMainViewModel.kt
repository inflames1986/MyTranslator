package com.inflames1986.mytranslator.translator.view.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import kotlinx.coroutines.*
import com.inflames1986.mytranslator.translator.domain.model.AppState
import com.inflames1986.mytranslator.translator.domain.storage.entity.WordTranslate

abstract class BaseMainViewModel<T : AppState>(
    protected val translateLiveData: MutableLiveData<T> = MutableLiveData(),
    protected val compositeDisposable: CompositeDisposable = CompositeDisposable(),
    protected val networkStateLiveData: MutableLiveData<Boolean> = MutableLiveData(),
    protected val historyLiveData: MutableLiveData<T> = MutableLiveData(),
    protected val favouritesLiveData: MutableLiveData<T> = MutableLiveData()
) : ViewModel() {

    companion object {
        private const val CANCEL_MESSAGE = "Уже не актуально."
    }

    protected val viewModelCoroutineScope = CoroutineScope(
        Dispatchers.IO
                + SupervisorJob()
                + CoroutineExceptionHandler { coroutineContext, throwable ->
            handleError(throwable)
        })

    abstract fun getData(word: String, isOnline: Boolean)

    abstract fun saveToFavourite(word: WordTranslate)

    abstract fun findInHistory(word: String)

    open fun getNetworkState(): LiveData<Boolean> = networkStateLiveData

    override fun onCleared() {
        super.onCleared()
        cancelJob()
        compositeDisposable.clear()
    }

    protected fun cancelJob() {
        viewModelCoroutineScope.coroutineContext.cancelChildren(CancellationException(CANCEL_MESSAGE))
    }

    abstract fun handleError(error: Throwable)
}