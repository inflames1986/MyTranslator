package com.inflames1986.screenhistory

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.inflames1986.model.data.AppState
import io.reactivex.disposables.CompositeDisposable
import kotlinx.coroutines.*


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