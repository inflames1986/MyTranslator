package com.inflames1986.mytranslator.translator.view.history

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import kotlinx.coroutines.*
import com.inflames1986.mytranslator.translator.domain.model.AppState

abstract class BaseHistoryViewModel<T : AppState>(
    protected val historyWordsLiveData: MutableLiveData<T> = MutableLiveData(),
    protected val compositeDisposable: CompositeDisposable = CompositeDisposable(),
    protected val clearLiveData: MutableLiveData<T> = MutableLiveData(),
) : ViewModel(), LifecycleObserver {

    companion object {
        private const val CANCEL_MESSAGE = "Уже не актуально."
    }

    protected val viewModelCoroutineScope = CoroutineScope(
        Dispatchers.IO
                + SupervisorJob()
                + CoroutineExceptionHandler { coroutineContext, throwable ->
            handleError(throwable)
        })

    abstract fun getData()
    abstract fun clearHistory()

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